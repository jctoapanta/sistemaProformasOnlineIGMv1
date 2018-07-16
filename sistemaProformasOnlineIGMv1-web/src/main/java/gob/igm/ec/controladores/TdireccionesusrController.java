package gob.igm.ec.controladores;

import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.Tentidad;
import gob.igm.ec.controladores.util.FacesUtil;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TcantonFacade;
import gob.igm.ec.servicios.TdireccionesusrFacade;
import gob.igm.ec.servicios.TparroquiaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named("tdireccionesusrController")
@SessionScoped
public class TdireccionesusrController extends FacesUtil implements Serializable {

    @Inject
    private Login login;

    @Inject
    private TentidadController tentidadController;

    @Inject
    private TemplateController templateControl;

    @Inject
    private OrderBean order;

    @EJB
    private gob.igm.ec.servicios.TdireccionesusrFacade ejbFacade;
    private List<Tdireccionesusr> items = null;
    private List<Tdireccionesusr> direccionesXCiu = null;
    private Long siguienteIdDireccion;
    private Tdireccionesusr selected;

    @EJB
    private TcantonFacade cantonServicio;

    @EJB
    private TparroquiaFacade parroquiaServicio;

    private TdireccionesusrController direccionesControl;
    private List<SelectItem> provinciaItems = new ArrayList<>();
    private List<SelectItem> cantonItems = new ArrayList<>();
    private List<SelectItem> parroquiaItems = new ArrayList<>();
    private HtmlSelectOneMenu provinciaMenu;
    private HtmlSelectOneMenu cantonMenu;
    private HtmlSelectOneMenu parroquiaMenu;
    private HtmlInputHidden ciuH;
    private HtmlInputHidden tipoEntrega;
    private HtmlInputHidden ciur;
    private String selectedItem;
    private List<SelectItem> selectedItems = new ArrayList<>();
    private Long idDireccionC = new Long(0);
    private HtmlDataTable SomeDataTable;

    /**
     * @return the selectedItems
     */
    public List<SelectItem> getSelectedItems() {
        return selectedItems;
    }

    /**
     * @return the selectedItem
     */
    public String getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param selectedItem the selectedItem to set
     */
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * @return the tipoEntrega
     */
    public HtmlInputHidden getTipoEntrega() {
        return tipoEntrega;
    }

    /**
     * @param tipoEntrega the tipoEntrega to set
     */
    public void setTipoEntrega(HtmlInputHidden tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    /**
     * @return the ciur
     */
    public HtmlInputHidden getCiur() {
        return ciur;
    }

    /**
     * @param ciur the ciur to set
     */
    public void setCiur(HtmlInputHidden ciur) {
        this.ciur = ciur;
    }

    public List<Tdireccionesusr> buscaDomicilioCliente() {
        String ciu = order.getCiuH().getValue().toString();
        List<Tdireccionesusr> Dir = new ArrayList<>();
        Dir = this.ejbFacade.buscarDireccionDomicilioCliente(ciu);
        return Dir;
    }

    public List<Tdireccionesusr> buscaDirEnvioCliente() {
        //ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String ciu = order.getCiuH().getValue().toString();// ec.getRequestParameterMap().get("principalForm:ciuHidden");
        List<Tdireccionesusr> Dir = new ArrayList<>();
        Dir = this.ejbFacade.buscarDireccionEnvioCliente(ciu);
        return Dir;
    }

    public void seleccionaDirEnvio(Tdireccionesusr direccionSelec) {
        //Actualiza el valor de lenvio a null de todos los registros del usuario
        for (Tdireccionesusr tdireccionesusr : this.direccionesXCiu) {
            tdireccionesusr.setLEnvio((short) 0);
            ejbFacade.actualizaDirecciones(tdireccionesusr);
        }
        //Actualiza el valor de lenvio a 1 de la direccion seleccionada
        this.selected.setLEnvio((short) 1);
        JsfUtil.addSuccessMessage("Usted ha seleccionado esta dirección para recibir su pedido.");
        JsfUtil.addSuccessMessage("Seleccione en el Menu, la opción <Ir al Listado de Pedidos> para que pueda generar su pedido...");
        JsfUtil.addSuccessMessage("Gracias por su tiempo y completar el registro de sus Direcciones");
        this.update();
    }

    public String activaDirEnvio() {
        String regla = "/tproforma/ListProXCli";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String tEntrega = ec.getRequestParameterMap().get("principalForm:tipoEntregaHidden2");
        String ciu = ec.getRequestParameterMap().get("principalForm:ciuHidden");

        if (tEntrega.equals("1") || tEntrega.equals("2")) {
            //JsfUtil.addErrorMessage("Se ha guardado su proforma correctamente");
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("TproformaCreated"));
            regla = "/tproforma/ListProXCli";
        }

        return regla;
    }

    /**
     * @return the ciuH
     */
    public HtmlInputHidden getCiuH() {
        return ciuH;
    }

    /**
     * @param ciuH the ciuH to set
     */
    public void setCiuH(HtmlInputHidden ciuH) {
        this.ciuH = ciuH;
    }

    /**
     * La variable logger.
     */
    private static org.apache.log4j.Logger logger;

    public TdireccionesusrController() {

        this.siguienteIdDireccion = null;
        ciuH = new HtmlInputHidden();
        tipoEntrega = new HtmlInputHidden();
        selectedItems.add(new SelectItem("1", "Retiro en oficina IGM Quito"));
        selectedItems.add(new SelectItem("2", "Retiro en oficina IGM Guayaquil"));
        selectedItems.add(new SelectItem("3", "Entrega a Domicilio"));
    }

    public Tdireccionesusr getSelected() {
        return selected;
    }

    public void setSelected(Tdireccionesusr selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TdireccionesusrFacade getFacade() {
        return ejbFacade;
    }

    public Tdireccionesusr prepareCreate() {
        selected = new Tdireccionesusr();
        initializeEmbeddableKey();
        return selected;
    }

    public String create() {
        Tentidad ciu = new Tentidad();
        Long cuentaDireccionesUsr;
        List<Tdireccionesusr> direccionEnvioSeleccionada = new ArrayList<>();
        String regla = new String();
        ciu.setCiu(ciuH.getValue().toString());
        siguienteIdDireccion = this.ejbFacade.obtenerSiguienteValor();
        if (siguienteIdDireccion == null) {
            siguienteIdDireccion = Long.decode("1");
        }
        this.selected.setIdDireccion(siguienteIdDireccion);
        this.selected.setCiu(ciu);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TdireccionesusrCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        cuentaDireccionesUsr = this.ejbFacade.cuentaDireccionesCliente(this.getCiuH().getValue().toString());
        if (cuentaDireccionesUsr >= 2L) {
            direccionEnvioSeleccionada = this.buscaDirEnvioCliente();
            if (direccionEnvioSeleccionada.size()==0) {
                regla = "/tdireccionesusr/List.xhtml";
                templateControl.refresh();
                JsfUtil.addErrorMessage("Por favor seleccione la Dirección en DÓNDE desea recibir su pedido!!! Pulse el botón <Enviar a:> en su listado de Direcciones");

            } else {
                JsfUtil.addSuccessMessage("En este momento ya se encuentra en la Pantalla de Pedidos, puede generar su requerimiento...Gracias por registrar sus datos.");
                regla = "/tproforma/ListProXCli.xhtml";
                templateControl.refresh();
            }
        } else {
            regla = "/tdireccionesusr/List.xhtml";
            templateControl.refresh();
            JsfUtil.addErrorMessage("Por favor agregue al menos una Dirección adicional!!!");
        }
        return regla;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TdireccionesusrUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TdireccionesusrDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public String showResult() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String data = params.get("ciuParam");
        return data;
    }

    public List<Tdireccionesusr> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Tdireccionesusr getTdireccionesusr(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Tdireccionesusr> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tdireccionesusr> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tdireccionesusr.class)
    public static class TdireccionesusrControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TdireccionesusrController controller = (TdireccionesusrController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tdireccionesusrController");
            return controller.getTdireccionesusr(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tdireccionesusr) {
                Tdireccionesusr o = (Tdireccionesusr) object;
                return getStringKey(o.getIdDireccion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tdireccionesusr.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the direccionesXCiu
     */
    public List<Tdireccionesusr> getDireccionesXCiu() {
        direccionesXCiu = this.ejbFacade.buscarDireccionesXCliente(this.ciuH.getValue().toString());
        if (direccionesXCiu.isEmpty()) {
            JsfUtil.addErrorMessage("Usted aun no dispone de Direcciones registradas");
        }
        return direccionesXCiu;
    }

    /**
     * @param direccionesXCiu the direccionesXCiu to set
     */
    public void setDireccionesXCiu(List<Tdireccionesusr> direccionesXCiu) {
        this.direccionesXCiu = direccionesXCiu;
    }

    /**
     * Permite ingresar los datos del usuarios a sesi�n.
     *
     * @return Regla de navegaci�n
     */
    public String registrarDireccion() {
        String regla = "/tdireccionesusr/List";
        try {
            setDireccionesXCiu(this.ejbFacade.buscarDireccionesXCliente(login.getAliasBase()));

            if (getDireccionesXCiu().isEmpty()) {
                JsfUtil.addErrorMessage("Usted aún no ha registrado su Direcciones");
                regla = "faces/registro.xhtml";
            }
        } catch (Exception ex) {
            regla = "#";
            logger.error(ex.getMessage(), ex);
            super.addErrorMessage(super.getRecursoGeneral().getString("msgErrorLogin"));
        }
        return regla;
    }

    /**
     * Funcion para cargar los cantones de acuerdo a las provincias
     *
     * @param event
     */
    public void changeProvinciaMenu(ValueChangeEvent event) {
        // Obtiene la provincia seleccionada.
        String provincia = (String) event.getNewValue();

        if (provincia != null) {

            // Obtiene los cantones por provincia
            try {
                cantonItems = cantonServicio.buscarCantonesXProvincia(provincia);
            } catch (Exception ex) {
                Logger.getLogger(TdireccionesusrController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Funcion para cargar las parroquias de acuerdo a los cantones
     *
     * @param event
     */
    public void changeCantonMenu(ValueChangeEvent event) {
        // Obtiene el canton seleccionada.
        String canton = (String) event.getNewValue();

        if (canton != null) {

            // Obtiene los cantones por provincia
            try {
                parroquiaItems = parroquiaServicio.buscarParroquiasXCantones(canton);
            } catch (Exception ex) {
                Logger.getLogger(TdireccionesusrController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the provinciaItems
     */
    public List<SelectItem> getProvinciaItems() {
        return provinciaItems;
    }

    /**
     * @param provinciaItems the provinciaItems to set
     */
    public void setProvinciaItems(List<SelectItem> provinciaItems) {
        this.provinciaItems = provinciaItems;
    }

    /**
     * @return the cantonItems
     */
    public List<SelectItem> getCantonItems() {
        return cantonItems;
    }

    /**
     * @param cantonItems the cantonItems to set
     */
    public void setCantonItems(List<SelectItem> cantonItems) {
        this.cantonItems = cantonItems;
    }

    /**
     * @return the parroquiaItems
     */
    public List<SelectItem> getParroquiaItems() {
        return parroquiaItems;
    }

    /**
     * @param parroquiaItems the parroquiaItems to set
     */
    public void setParroquiaItems(List<SelectItem> parroquiaItems) {
        this.parroquiaItems = parroquiaItems;
    }

    /**
     * @return the provinciaMenu
     */
    public HtmlSelectOneMenu getProvinciaMenu() {
        return provinciaMenu;
    }

    /**
     * @param provinciaMenu the provinciaMenu to set
     */
    public void setProvinciaMenu(HtmlSelectOneMenu provinciaMenu) {
        this.provinciaMenu = provinciaMenu;
    }

    /**
     * @return the cantonMenu
     */
    public HtmlSelectOneMenu getCantonMenu() {
        return cantonMenu;
    }

    /**
     * @param cantonMenu the cantonMenu to set
     */
    public void setCantonMenu(HtmlSelectOneMenu cantonMenu) {
        this.cantonMenu = cantonMenu;
    }

    /**
     * @return the parroquiaMenu
     */
    public HtmlSelectOneMenu getParroquiaMenu() {
        return parroquiaMenu;
    }

    /**
     * @param parroquiaMenu the parroquiaMenu to set
     */
    public void setParroquiaMenu(HtmlSelectOneMenu parroquiaMenu) {
        this.parroquiaMenu = parroquiaMenu;
    }

    /**
     * @return the idDireccionC
     */
    public Long getIdDireccionC() {
        return idDireccionC;
    }

    /**
     * @param idDireccionC the idDireccionC to set
     */
    public void setIdDireccionC(Long idDireccionC) {
        this.idDireccionC = idDireccionC;
    }
}
