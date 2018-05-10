package gob.igm.ec.controladores;

import gob.igm.ec.Tcanton;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TcantonFacade;

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

@Named("tcantonController")
@SessionScoped
public class TcantonController implements Serializable {

    @EJB
    private gob.igm.ec.servicios.TcantonFacade ejbFacade;
    private List<Tcanton> items = null;
    private Tcanton selected;

    public TcantonController() {
    }

    public Tcanton getSelected() {
        return selected;
    }

    public void setSelected(Tcanton selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTcantonPK().setIdProvincia(selected.getTprovincia().getIdProvincia());
    }

    protected void initializeEmbeddableKey() {
        selected.setTcantonPK(new gob.igm.ec.TcantonPK());
    }

    private TcantonFacade getFacade() {
        return ejbFacade;
    }

    public Tcanton prepareCreate() {
        selected = new Tcanton();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TcantonCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TcantonUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TcantonDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tcanton> getItems() {
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

    public Tcanton getTcanton(gob.igm.ec.TcantonPK id) {
        return getFacade().find(id);
    }

    public List<Tcanton> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tcanton> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tcanton.class)
    public static class TcantonControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TcantonController controller = (TcantonController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tcantonController");
            return controller.getTcanton(getKey(value));
        }

        gob.igm.ec.TcantonPK getKey(String value) {
            gob.igm.ec.TcantonPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new gob.igm.ec.TcantonPK();
            key.setIdProvincia(Integer.parseInt(values[0]));
            key.setIdCanton(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(gob.igm.ec.TcantonPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdProvincia());
            sb.append(SEPARATOR);
            sb.append(value.getIdCanton());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tcanton) {
                Tcanton o = (Tcanton) object;
                return getStringKey(o.getTcantonPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tcanton.class.getName()});
                return null;
            }
        }

    }

}
