package rh.gob.igm.ec.controladores;

import rh.gob.igm.ec.TRhTipoSegSocial;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import rh.gob.igm.ec.servicios.TRhTipoSegSocialFacade;

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

@Named("tRhTipoSegSocialController")
@SessionScoped
public class TRhTipoSegSocialController implements Serializable {

    @EJB
    private rh.gob.igm.ec.servicios.TRhTipoSegSocialFacade ejbFacade;
    private List<TRhTipoSegSocial> items = null;
    private TRhTipoSegSocial selected;

    public TRhTipoSegSocialController() {
    }

    public TRhTipoSegSocial getSelected() {
        return selected;
    }

    public void setSelected(TRhTipoSegSocial selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TRhTipoSegSocialFacade getFacade() {
        return ejbFacade;
    }

    public TRhTipoSegSocial prepareCreate() {
        selected = new TRhTipoSegSocial();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TRhTipoSegSocialCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TRhTipoSegSocialUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TRhTipoSegSocialDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TRhTipoSegSocial> getItems() {
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

    public TRhTipoSegSocial getTRhTipoSegSocial(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<TRhTipoSegSocial> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TRhTipoSegSocial> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TRhTipoSegSocial.class)
    public static class TRhTipoSegSocialControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TRhTipoSegSocialController controller = (TRhTipoSegSocialController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tRhTipoSegSocialController");
            return controller.getTRhTipoSegSocial(getKey(value));
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
            if (object instanceof TRhTipoSegSocial) {
                TRhTipoSegSocial o = (TRhTipoSegSocial) object;
                return getStringKey(o.getNoSeg());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TRhTipoSegSocial.class.getName()});
                return null;
            }
        }

    }

}
