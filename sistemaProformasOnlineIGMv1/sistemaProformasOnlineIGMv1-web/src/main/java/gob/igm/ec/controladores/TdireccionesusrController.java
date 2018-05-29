package gob.igm.ec.controladores;

import gob.igm.ec.Tcanton;
import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.Tentidad;
import gob.igm.ec.Tprovincia;
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
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Named("tdireccionesusrController")
@SessionScoped
public class TdireccionesusrController extends FacesUtil implements Serializable {

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


    @Inject
    private Login login;
    
    @Inject
    private TentidadController tentidadController;
    
    @EJB
    private gob.igm.ec.servicios.TdireccionesusrFacade ejbFacade;
    private List<Tdireccionesusr> items = null;
    private List<Tdireccionesusr> direccionesXCiu = null;
    private Long siguienteIdDireccion;
    private Tdireccionesusr selected;
    private TdireccionesusrFacade direccionServicio;
    @EJB
    private TcantonFacade cantonServicio;
    @EJB
    private TparroquiaFacade parroquiaServicio;
    
    private List<SelectItem> provinciaItems = new ArrayList<>();
    private List<SelectItem> cantonItems = new ArrayList<>();
    private List<SelectItem> parroquiaItems = new ArrayList<>();
    private HtmlSelectOneMenu provinciaMenu;
    private HtmlSelectOneMenu cantonMenu;
    private HtmlSelectOneMenu parroquiaMenu;
    private HtmlInputHidden ciuH;
    
    /** La variable logger. */
    private static org.apache.log4j.Logger logger;

    public TdireccionesusrController() {
        this.siguienteIdDireccion = null;
        ciuH=new HtmlInputHidden();
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

    public void create() {
        Tentidad ciu=new Tentidad();
        ciu.setCiu(ciuH.getValue().toString());
        siguienteIdDireccion=this.ejbFacade.obtenerSiguienteValor();
        if (siguienteIdDireccion == null){
            siguienteIdDireccion=Long.decode("1");
        }
        this.selected.setIdDireccion(siguienteIdDireccion);
        this.selected.setCiu(ciu);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TdireccionesusrCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
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
      Map<String,String> params = 
         fc.getExternalContext().getRequestParameterMap();
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
        direccionesXCiu = this.ejbFacade.buscarDireccionesXCliente(tentidadController.getSelected().getCiu());
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
     * @return Regla de navegaci�n
     */
    public String registrarDireccion() {
        //List<Object> usuario;
        String regla = "/tdireccionesusr/List";
        try {
            setDireccionesXCiu(this.direccionServicio.buscarDireccionesXCliente(login.getAliasBase()));
//            for (Tdireccionesusr tdireccion : direccion) {
//                direccion.setCiu(tdireccion.getCiu());
//                direccion.setApellidos(tdireccion.getApellidos());
//                direccion.setNombres(tdireccion.getNombres());
//                direccion.setDireccion(tdireccion.getDireccion());
//            }
            if (getDireccionesXCiu().isEmpty()){
                JsfUtil.addErrorMessage("Usted aún no ha registrado su Direcciones");
                regla = "faces/registro.xhtml";
            }
        }
        catch (Exception ex) {
            regla = "#";
            logger.error(ex.getMessage(), ex);
            super.addErrorMessage(super.getRecursoGeneral().getString("msgErrorLogin"));
        }
        return regla;
    }    

    /**
     * Funcion para cargar los cantones de acuerdo a las provincias
     * @param event 
     */
    public void changeProvinciaMenu(ValueChangeEvent event) {
        // Obtiene la provincia seleccionada.
        String provincia = (String) event.getNewValue();

        if (provincia != null) {
            
                // Obtiene los cantones por provincia
            try {
                cantonItems=cantonServicio.buscarCantonesXProvincia(provincia);
            } catch (Exception ex) {
                Logger.getLogger(TdireccionesusrController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Skip validation of non-immediate components and invocation of the submit() method.
        //FacesContext.getCurrentInstance().renderResponse();
    }    
    
    /**
     * Funcion para cargar las parroquias de acuerdo a los cantones
     * @param event 
     */
    public void changeCantonMenu(ValueChangeEvent event) {
        // Obtiene el canton seleccionada.
        String canton = (String) event.getNewValue();

        if (canton != null) {
            
                // Obtiene los cantones por provincia
            try {
                parroquiaItems=parroquiaServicio.buscarParroquiasXCantones(canton);
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
}
