package rh.gob.igm.ec.controladores;

import rh.gob.igm.ec.TAreas;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import rh.gob.igm.ec.servicios.TAreasFacade;

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

@Named("tAreasController")
@SessionScoped
public class TAreasController implements Serializable {

    @EJB
    private rh.gob.igm.ec.servicios.TAreasFacade ejbFacade;
    private List<TAreas> items = null;
    private TAreas selected;

    public TAreasController() {
    }

    public TAreas getSelected() {
        return selected;
    }

    public void setSelected(TAreas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTAreasPK().setNoEmpMatriz(selected.getTAreas().getTAreasPK().getNoEmpMatriz());
    }

    protected void initializeEmbeddableKey() {
        selected.setTAreasPK(new rh.gob.igm.ec.TAreasPK());
    }

    private TAreasFacade getFacade() {
        return ejbFacade;
    }

    public TAreas prepareCreate() {
        selected = new TAreas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TAreasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TAreasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TAreasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TAreas> getItems() {
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

    public TAreas getTAreas(rh.gob.igm.ec.TAreasPK id) {
        return getFacade().find(id);
    }

    public List<TAreas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TAreas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TAreas.class)
    public static class TAreasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TAreasController controller = (TAreasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tAreasController");
            return controller.getTAreas(getKey(value));
        }

        rh.gob.igm.ec.TAreasPK getKey(String value) {
            rh.gob.igm.ec.TAreasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new rh.gob.igm.ec.TAreasPK();
            key.setNoCd(Short.parseShort(values[0]));
            key.setNoEmpMatriz(Short.parseShort(values[1]));
            return key;
        }

        String getStringKey(rh.gob.igm.ec.TAreasPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNoCd());
            sb.append(SEPARATOR);
            sb.append(value.getNoEmpMatriz());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TAreas) {
                TAreas o = (TAreas) object;
                return getStringKey(o.getTAreasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TAreas.class.getName()});
                return null;
            }
        }

    }

}
