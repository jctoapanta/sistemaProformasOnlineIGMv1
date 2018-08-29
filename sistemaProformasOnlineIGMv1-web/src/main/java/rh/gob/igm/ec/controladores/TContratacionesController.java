/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.controladores;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import rh.gob.igm.ec.TContrataciones;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.TContratacionesPK;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TContratacionesFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TContratacionesController {

    private boolean ERROR;

    public TContratacionesController() {
        pagingInfo = new PagingInfo();
        converter = new TContratacionesConverter();
    }
    private TContrataciones TContrataciones = null;
    private List<TContrataciones> TContratacionesItems = null;
    private TContratacionesFacade jpaController = null;
    private TContratacionesConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "gob.igm.ec_rh_ejb_1.0-SNAPSHOTPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public TContratacionesFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TContratacionesFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tContratacionesJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTContratacionesItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTContratacionesItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TContrataciones getTContrataciones() {
        if (TContrataciones == null) {
            TContrataciones = (TContrataciones) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTContrataciones", converter, null);
        }
        if (TContrataciones == null) {
            TContrataciones = new TContrataciones();
        }
        return TContrataciones;
    }

    public String listSetup() {
        reset(true);
        return "TContrataciones_list";
    }

    public String createSetup() {
        reset(false);
        TContrataciones = new TContrataciones();
        TContrataciones.setTContratacionesPK(new TContratacionesPK());
        return "TContrataciones_create";
    }

    public String create() {
        TContrataciones.getTContratacionesPK().setNoPersona(TContrataciones.getTDatEmpleado().getNoPersona());
        // TODO: no setter methods were found in your primary key class
        //    rh.gob.igm.ec.TContratacionesPK
        // and therefore initialization code need manual adjustments.
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TContrataciones);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TContrataciones was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("TContrataciones_detail");
    }

    public String editSetup() {
        return scalarSetup("TContrataciones_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TContrataciones = (TContrataciones) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTContrataciones", converter, null);
        if (TContrataciones == null) {
            String requestTContratacionesString = JsfUtil.getRequestParameter("jsfcrud.currentTContrataciones");
            JsfUtil.addErrorMessage("The TContrataciones with id " + requestTContratacionesString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        TContrataciones.getTContratacionesPK().setNoPersona(TContrataciones.getTDatEmpleado().getNoPersona());
        // TODO: no setter methods were found in your primary key class
        //    rh.gob.igm.ec.TContratacionesPK
        // and therefore initialization code need manual adjustments.
        String TContratacionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, TContrataciones);
        String currentTContratacionesString = JsfUtil.getRequestParameter("jsfcrud.currentTContrataciones");
        if (TContratacionesString == null || TContratacionesString.length() == 0 || !TContratacionesString.equals(currentTContratacionesString)) {
            String outcome = editSetup();
            if ("TContrataciones_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TContrataciones. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TContrataciones);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TContrataciones was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTContrataciones");
        TContratacionesPK id = converter.getId(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TContrataciones was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if ((ERROR)) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<TContrataciones> getTContratacionesItems() {
        if (TContratacionesItems == null) {
            getPagingInfo();
            TContratacionesItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TContratacionesItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TContrataciones_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TContrataciones_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        TContrataciones = null;
        TContratacionesItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TContrataciones newTContrataciones = new TContrataciones();
        newTContrataciones.setTContratacionesPK(new TContratacionesPK());
        String newTContratacionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTContrataciones);
        String TContratacionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, TContrataciones);
        if (!newTContratacionesString.equals(TContratacionesString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
