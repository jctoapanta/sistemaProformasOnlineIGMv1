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
import rh.gob.igm.ec.TTiposContrato;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TTiposContratoFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TTiposContratoController {

    private boolean ERROR;

    public TTiposContratoController() {
        pagingInfo = new PagingInfo();
        converter = new TTiposContratoConverter();
    }
    private TTiposContrato TTiposContrato = null;
    private List<TTiposContrato> TTiposContratoItems = null;
    private TTiposContratoFacade jpaController = null;
    private TTiposContratoConverter converter = null;
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

    public TTiposContratoFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TTiposContratoFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tTiposContratoJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTTiposContratoItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTTiposContratoItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TTiposContrato getTTiposContrato() {
        if (TTiposContrato == null) {
            TTiposContrato = (TTiposContrato) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTTiposContrato", converter, null);
        }
        if (TTiposContrato == null) {
            TTiposContrato = new TTiposContrato();
        }
        return TTiposContrato;
    }

    public String listSetup() {
        reset(true);
        return "TTiposContrato_list";
    }

    public String createSetup() {
        reset(false);
        TTiposContrato = new TTiposContrato();
        return "TTiposContrato_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TTiposContrato);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TTiposContrato was successfully created.");
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
        return scalarSetup("TTiposContrato_detail");
    }

    public String editSetup() {
        return scalarSetup("TTiposContrato_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TTiposContrato = (TTiposContrato) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTTiposContrato", converter, null);
        if (TTiposContrato == null) {
            String requestTTiposContratoString = JsfUtil.getRequestParameter("jsfcrud.currentTTiposContrato");
            JsfUtil.addErrorMessage("The TTiposContrato with id " + requestTTiposContratoString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TTiposContratoString = converter.getAsString(FacesContext.getCurrentInstance(), null, TTiposContrato);
        String currentTTiposContratoString = JsfUtil.getRequestParameter("jsfcrud.currentTTiposContrato");
        if (TTiposContratoString == null || TTiposContratoString.length() == 0 || !TTiposContratoString.equals(currentTTiposContratoString)) {
            String outcome = editSetup();
            if ("TTiposContrato_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TTiposContrato. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TTiposContrato);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TTiposContrato was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTTiposContrato");
        Short id = new Short(idAsString);
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
                JsfUtil.addSuccessMessage("TTiposContrato was successfully deleted.");
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

    public List<TTiposContrato> getTTiposContratoItems() {
        if (TTiposContratoItems == null) {
            getPagingInfo();
            TTiposContratoItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TTiposContratoItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TTiposContrato_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TTiposContrato_list";
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
        TTiposContrato = null;
        TTiposContratoItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TTiposContrato newTTiposContrato = new TTiposContrato();
        String newTTiposContratoString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTTiposContrato);
        String TTiposContratoString = converter.getAsString(FacesContext.getCurrentInstance(), null, TTiposContrato);
        if (!newTTiposContratoString.equals(TTiposContratoString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
