package gob.igm.ec.controladores;

import gob.igm.ec.Tdetproforma;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.JsfUtil.PersistAction;
import gob.igm.ec.servicios.TdetproformaFacade;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Named("tdetproformaController")
@SessionScoped
public class TdetproformaController implements Serializable {

    @EJB
    private gob.igm.ec.servicios.TdetproformaFacade ejbFacade;
    private List<Tdetproforma> items = null;
    private Tdetproforma selected;

    public TdetproformaController() {
    }

    public Tdetproforma getSelected() {
        return selected;
    }

    public void setSelected(Tdetproforma selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTdetproformaPK().setIdProforma(selected.getTproforma().getTproformaPK().getIdProforma());
        selected.getTdetproformaPK().setIdPeriodo(selected.getTproforma().getTproformaPK().getIdPeriodo());
        selected.getTdetproformaPK().setIdSucursal(selected.getTproforma().getTproformaPK().getIdSucursal());
    }

    protected void initializeEmbeddableKey() {
        selected.setTdetproformaPK(new gob.igm.ec.TdetproformaPK());
    }

    private TdetproformaFacade getFacade() {
        return ejbFacade;
    }

    public Tdetproforma prepareCreate() {
        selected = new Tdetproforma();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TdetproformaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TdetproformaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TdetproformaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tdetproforma> getItems() {
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

    public Tdetproforma getTdetproforma(gob.igm.ec.TdetproformaPK id) {
        return getFacade().find(id);
    }

    public List<Tdetproforma> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tdetproforma> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tdetproforma.class)
    public static class TdetproformaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TdetproformaController controller = (TdetproformaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tdetproformaController");
            return controller.getTdetproforma(getKey(value));
        }

        gob.igm.ec.TdetproformaPK getKey(String value) {
            gob.igm.ec.TdetproformaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new gob.igm.ec.TdetproformaPK();
            key.setIdPeriodo(Short.parseShort(values[0]));
            key.setIdSucursal(Short.parseShort(values[1]));
            key.setIdProforma(Long.parseLong(values[2]));
            key.setNoReg(Short.parseShort(values[3]));
            return key;
        }

        String getStringKey(gob.igm.ec.TdetproformaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPeriodo());
            sb.append(SEPARATOR);
            sb.append(value.getIdSucursal());
            sb.append(SEPARATOR);
            sb.append(value.getIdProforma());
            sb.append(SEPARATOR);
            sb.append(value.getNoReg());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tdetproforma) {
                Tdetproforma o = (Tdetproforma) object;
                return getStringKey(o.getTdetproformaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tdetproforma.class.getName()});
                return null;
            }
        }

    }

    public BigDecimal valorTotalProforma (Long noProforma, Short periodo){
        BigDecimal total=BigDecimal.ZERO;
        total=ejbFacade.totalProforma(noProforma, periodo);
        return total;
    }
}
