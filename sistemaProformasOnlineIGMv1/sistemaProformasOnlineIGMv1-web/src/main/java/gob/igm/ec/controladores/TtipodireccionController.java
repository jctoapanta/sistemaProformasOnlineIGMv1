package gob.igm.ec.controladores;

import gob.igm.ec.Ttipodireccion;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TtipodireccionFacade;

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

@Named("ttipodireccionController")
@SessionScoped
public class TtipodireccionController implements Serializable {

    @EJB
    private gob.igm.ec.servicios.TtipodireccionFacade ejbFacade;
    private List<Ttipodireccion> items = null;
    private Ttipodireccion selected;

    public TtipodireccionController() {
    }

    public Ttipodireccion getSelected() {
        return selected;
    }

    public void setSelected(Ttipodireccion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TtipodireccionFacade getFacade() {
        return ejbFacade;
    }

    public Ttipodireccion prepareCreate() {
        selected = new Ttipodireccion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TtipodireccionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TtipodireccionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TtipodireccionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ttipodireccion> getItems() {
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

    public Ttipodireccion getTtipodireccion(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<Ttipodireccion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ttipodireccion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ttipodireccion.class)
    public static class TtipodireccionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TtipodireccionController controller = (TtipodireccionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ttipodireccionController");
            return controller.getTtipodireccion(getKey(value));
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
            if (object instanceof Ttipodireccion) {
                Ttipodireccion o = (Ttipodireccion) object;
                return getStringKey(o.getIdTipoDireccion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ttipodireccion.class.getName()});
                return null;
            }
        }

    }

}
