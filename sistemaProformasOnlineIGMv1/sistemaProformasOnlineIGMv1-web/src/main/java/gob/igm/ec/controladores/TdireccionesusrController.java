package gob.igm.ec.controladores;

import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TdireccionesusrFacade;

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

@Named("tdireccionesusrController")
@SessionScoped
public class TdireccionesusrController implements Serializable {

    @EJB
    private gob.igm.ec.servicios.TdireccionesusrFacade ejbFacade;
    private List<Tdireccionesusr> items = null;
    private Tdireccionesusr selected;

    public TdireccionesusrController() {
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

}
