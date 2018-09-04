package gob.igm.ec.controladores;

import gob.igm.ec.Tproforma;
import gob.igm.ec.controladores.util.EncriptUtil;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TproformaFacade;
import gob.igm.ec.controladores.util.JasperReportUtil;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named("tproformaController")
@SessionScoped
public class TproformaController implements Serializable {

    /**
     * @return the proformasSelected
     */
    public Tproforma[] getProformasSelected() {
        return proformasSelected;
    }

    /**
     * @param proformasSelected the proformasSelected to set
     */
    public void setProformasSelected(Tproforma[] proformasSelected) {
        this.proformasSelected = proformasSelected;
    }

    /**
     * @return the itemsSeleccionados
     */
    public List<Tproforma> getItemsSeleccionados() {
        return itemsSeleccionados;
    }

    /**
     * @param itemsSeleccionados the itemsSeleccionados to set
     */
    public void setItemsSeleccionados(List<Tproforma> itemsSeleccionados) {
        this.itemsSeleccionados = itemsSeleccionados;
    }

    /**
     * @return the itemsXEstado
     */
    public List<Tproforma> getItemsXEstado() {
        if (itemsXEstado == null) {
            itemsXEstado = getFacade().buscarProformsXEstado("V");
        }
        return itemsXEstado;
    }

    /**
     * @param itemsXEstado the itemsXEstado to set
     */
    public void setItemsXEstado(List<Tproforma> itemsXEstado) {
        this.itemsXEstado = itemsXEstado;
    }

    @Inject
    private Login login;

    @EJB
    private gob.igm.ec.servicios.TproformaFacade ejbFacade;

    @EJB
    private gob.igm.ec.servicios.TentidadFacade ejbFacadeEntidad;

    private List<Tproforma> items = null;
    private List<Tproforma> itemsXCiu = null;
    private List<Tproforma> itemsXCiuTotal = null;
    private List<Tproforma> itemsXEstado = null;
    private List<Tproforma> itemsSeleccionados =new ArrayList() ;
    private Tproforma selected;
    private EncriptUtil encriptUtil;
    @Resource(name = "ptvDS")
    private DataSource PTV;
    private Tproforma[] proformasSelected; 

    public TproformaController() {
    }

    public Tproforma getSelected() {
        return selected;
    }

    public void setSelected(Tproforma selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTproformaPK().setIdSucursal(selected.getTsucursal().getIdSucursal());
    }

    protected void initializeEmbeddableKey() {
        selected.setTproformaPK(new gob.igm.ec.TproformaPK());
    }

    private TproformaFacade getFacade() {
        return ejbFacade;
    }

    public Tproforma prepareCreate() {
        selected = new Tproforma();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TproformaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            setItems(null);    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TproformaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TproformaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            setItems(null);    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tproforma> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Tproforma> items) {
        this.items = items;
    }

    /**
     * La variable logger.
     */
    private static org.apache.log4j.Logger logger;

    /**
     * Recupera las proformas asociadas al cliente logueado
     *
     * @return items
     */
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

    public Tproforma getTproforma(gob.igm.ec.TproformaPK id) {
        return getFacade().find(id);
    }

    public List<Tproforma> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tproforma> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tproforma.class)
    public static class TproformaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TproformaController controller = (TproformaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tproformaController");
            return controller.getTproforma(getKey(value));
        }

        gob.igm.ec.TproformaPK getKey(String value) {
            gob.igm.ec.TproformaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new gob.igm.ec.TproformaPK();
            key.setIdPeriodo(Short.parseShort(values[0]));
            key.setIdSucursal(Long.parseLong(values[1]));
            key.setIdProforma(Long.parseLong(values[2]));
            return key;
        }

        String getStringKey(gob.igm.ec.TproformaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPeriodo());
            sb.append(SEPARATOR);
            sb.append(value.getIdSucursal());
            sb.append(SEPARATOR);
            sb.append(value.getIdProforma());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tproforma) {
                Tproforma o = (Tproforma) object;
                return getStringKey(o.getTproformaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tproforma.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the itemsXCiuTotal
     */
    public List<Tproforma> getItemsXCiuTotal() {
        Date fechaActual = new Date();
        Short vIdPeriodo;
        vIdPeriodo = Short.parseShort(new SimpleDateFormat("yy").format(fechaActual));
        itemsXCiuTotal = this.ejbFacade.buscarProformsXClienteTotal(login.getAliasBase(), vIdPeriodo);
        if (itemsXCiuTotal.isEmpty()) {
            JsfUtil.addErrorMessage("Usted aún no ha generado Pedidos");
        }
        return itemsXCiuTotal;
    }

    /**
     * @param itemsXCiuTotal the itemsXCiuTotal to set
     */
    public void setItemsXCiuTotal(List<Tproforma> itemsXCiuTotal) {
        this.itemsXCiuTotal = itemsXCiuTotal;
    }
    
    /**
     * @return the itemsXCiu
     */
    public List<Tproforma> getItemsXCiu() {
        Date fechaActual = new Date();
        Short vIdPeriodo;
        vIdPeriodo = Short.parseShort(new SimpleDateFormat("yy").format(fechaActual));
        itemsXCiu = this.ejbFacade.buscarProformsXCliente(login.getAliasBase(), vIdPeriodo);
        if (itemsXCiu.isEmpty()) {
            JsfUtil.addErrorMessage("Usted aún no ha generado Pedidos");
        }
        return itemsXCiu;
    }

    /**
     * @param itemsXCiu the itemsXCiu to set
     */
    public void setItemsXCiu(List<Tproforma> itemsXCiu) {
        this.itemsXCiu = itemsXCiu;
    }

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(FileUploadEvent e) {
        try {
            Long id_proforma = selected.getTproformaPK().getIdProforma();
            this.ejbFacade.upload(e.getFile(), id_proforma);
        } catch (Exception ex) {
            Logger.getLogger(TproformaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarPDFp() throws JRException, ClassNotFoundException, SQLException, FileNotFoundException {
        {
            JasperReportUtil jasper = new JasperReportUtil();
            JRExporter exporter = null;
            Long id_proforma = selected.getTproformaPK().getIdProforma();
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ID_PROFORMA", id_proforma);
            parameters.put("PATH_IMAGES", jasper.PATH_IMAGES);
            this.ejbFacade.generaPDF(parameters);
        }

    }
    
    public void aprobar(ActionEvent evento){
        
         
       if(this.itemsSeleccionados.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Por favor seleccione al menos una proforma", ""));
       }
       else{
        for (Tproforma proforma:this.itemsSeleccionados) {
            this.ejbFacade.aprobarFinanciero(proforma.getTproformaPK().getIdProforma(),"P");
               
        }
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha aprobado con éxito", ""));
         this.itemsSeleccionados.removeAll(this.itemsSeleccionados);
         this.itemsXEstado=getFacade().buscarProformsXEstado("V");
        }
      
    }
             
       
    }


