package rh.gob.igm.ec.controladores;

import rh.gob.igm.ec.TTiposContrato;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import rh.gob.igm.ec.servicios.TTiposContratoFacade;

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

@Named("tTiposContratoController")
@SessionScoped
public class TTiposContratoController implements Serializable {

    @EJB
    private rh.gob.igm.ec.servicios.TTiposContratoFacade ejbFacade;
    private List<TTiposContrato> items = null;
    private TTiposContrato selected;

    public TTiposContratoController() {
    }

    public TTiposContrato getSelected() {
        return selected;
    }

    public void setSelected(TTiposContrato selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TTiposContratoFacade getFacade() {
        return ejbFacade;
    }

    public TTiposContrato prepareCreate() {
        selected = new TTiposContrato();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TTiposContratoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TTiposContratoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TTiposContratoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TTiposContrato> getItems() {
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

    public TTiposContrato getTTiposContrato(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<TTiposContrato> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TTiposContrato> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TTiposContrato.class)
    public static class TTiposContratoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TTiposContratoController controller = (TTiposContratoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tTiposContratoController");
            return controller.getTTiposContrato(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TTiposContrato) {
                TTiposContrato o = (TTiposContrato) object;
                return getStringKey(o.getCContrato());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TTiposContrato.class.getName()});
                return null;
            }
        }

    }

}
