package rh.gob.igm.ec.controladores;

import rh.gob.igm.ec.TContrataciones;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import rh.gob.igm.ec.servicios.TContratacionesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tContratacionesController")
@SessionScoped
public class TContratacionesController implements Serializable {

    @EJB
    private rh.gob.igm.ec.servicios.TContratacionesFacade ejbFacade;
    private List<TContrataciones> items = null;
    private TContrataciones selected;

    public TContratacionesController() {
    }

    public TContrataciones getSelected() {
        return selected;
    }

    public void setSelected(TContrataciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTContratacionesPK().setNoPersona(selected.getTDatEmpleado().getNoPersona());
    }

    protected void initializeEmbeddableKey() {
        selected.setTContratacionesPK(new rh.gob.igm.ec.TContratacionesPK());
    }

    private TContratacionesFacade getFacade() {
        return ejbFacade;
    }

    public TContrataciones prepareCreate() {
        selected = new TContrataciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TContratacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TContratacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TContratacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TContrataciones> getItems() {
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

    public TContrataciones getTContrataciones(rh.gob.igm.ec.TContratacionesPK id) {
        return getFacade().find(id);
    }

    public List<TContrataciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TContrataciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TContrataciones.class)
    public static class TContratacionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TContratacionesController controller = (TContratacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tContratacionesController");
            return controller.getTContrataciones(getKey(value));
        }

        rh.gob.igm.ec.TContratacionesPK getKey(String value) {
            rh.gob.igm.ec.TContratacionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new rh.gob.igm.ec.TContratacionesPK();
            key.setNoPersona(Integer.parseInt(values[0]));
            key.setNoCont(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(rh.gob.igm.ec.TContratacionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNoPersona());
            sb.append(SEPARATOR);
            sb.append(value.getNoCont());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TContrataciones) {
                TContrataciones o = (TContrataciones) object;
                return getStringKey(o.getTContratacionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TContrataciones.class.getName()});
                return null;
            }
        }

    }

}
