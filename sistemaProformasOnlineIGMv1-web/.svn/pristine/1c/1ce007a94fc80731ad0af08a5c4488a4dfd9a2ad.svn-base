package gob.igm.ec.controladores;

import gob.igm.ec.Tparroquia;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TparroquiaFacade;

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

@Named("tparroquiaController")
@SessionScoped
public class TparroquiaController implements Serializable {

    @EJB
    private gob.igm.ec.servicios.TparroquiaFacade ejbFacade;
    private List<Tparroquia> items = null;
    private Tparroquia selected;

    public TparroquiaController() {
    }

    public Tparroquia getSelected() {
        return selected;
    }

    public void setSelected(Tparroquia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTparroquiaPK().setIdProvincia(selected.getTcanton().getTcantonPK().getIdProvincia());
        selected.getTparroquiaPK().setIdCanton(selected.getTcanton().getTcantonPK().getIdCanton());
    }

    protected void initializeEmbeddableKey() {
        selected.setTparroquiaPK(new gob.igm.ec.TparroquiaPK());
    }

    private TparroquiaFacade getFacade() {
        return ejbFacade;
    }

    public Tparroquia prepareCreate() {
        selected = new Tparroquia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TparroquiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TparroquiaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TparroquiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tparroquia> getItems() {
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

    public Tparroquia getTparroquia(gob.igm.ec.TparroquiaPK id) {
        return getFacade().find(id);
    }

    public List<Tparroquia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tparroquia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tparroquia.class)
    public static class TparroquiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TparroquiaController controller = (TparroquiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tparroquiaController");
            return controller.getTparroquia(getKey(value));
        }

        gob.igm.ec.TparroquiaPK getKey(String value) {
            gob.igm.ec.TparroquiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new gob.igm.ec.TparroquiaPK();
            key.setIdProvincia(Integer.parseInt(values[0]));
            key.setIdCanton(Integer.parseInt(values[1]));
            key.setIdParroquia(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(gob.igm.ec.TparroquiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdProvincia());
            sb.append(SEPARATOR);
            sb.append(value.getIdCanton());
            sb.append(SEPARATOR);
            sb.append(value.getIdParroquia());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tparroquia) {
                Tparroquia o = (Tparroquia) object;
                return getStringKey(o.getTparroquiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tparroquia.class.getName()});
                return null;
            }
        }

    }

}
