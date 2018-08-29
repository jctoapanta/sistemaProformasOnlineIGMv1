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
import rh.gob.igm.ec.TRhReligion;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TRhReligionFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TRhReligionController {

    private boolean ERROR;

    public TRhReligionController() {
        pagingInfo = new PagingInfo();
        converter = new TRhReligionConverter();
    }
    private TRhReligion TRhReligion = null;
    private List<TRhReligion> TRhReligionItems = null;
    private TRhReligionFacade jpaController = null;
    private TRhReligionConverter converter = null;
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

    public TRhReligionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TRhReligionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tRhReligionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTRhReligionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTRhReligionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TRhReligion getTRhReligion() {
        if (TRhReligion == null) {
            TRhReligion = (TRhReligion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTRhReligion", converter, null);
        }
        if (TRhReligion == null) {
            TRhReligion = new TRhReligion();
        }
        return TRhReligion;
    }

    public String listSetup() {
        reset(true);
        return "TRhReligion_list";
    }

    public String createSetup() {
        reset(false);
        TRhReligion = new TRhReligion();
        return "TRhReligion_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TRhReligion);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TRhReligion was successfully created.");
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
        return scalarSetup("TRhReligion_detail");
    }

    public String editSetup() {
        return scalarSetup("TRhReligion_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TRhReligion = (TRhReligion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTRhReligion", converter, null);
        if (TRhReligion == null) {
            String requestTRhReligionString = JsfUtil.getRequestParameter("jsfcrud.currentTRhReligion");
            JsfUtil.addErrorMessage("The TRhReligion with id " + requestTRhReligionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TRhReligionString = converter.getAsString(FacesContext.getCurrentInstance(), null, TRhReligion);
        String currentTRhReligionString = JsfUtil.getRequestParameter("jsfcrud.currentTRhReligion");
        if (TRhReligionString == null || TRhReligionString.length() == 0 || !TRhReligionString.equals(currentTRhReligionString)) {
            String outcome = editSetup();
            if ("TRhReligion_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TRhReligion. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TRhReligion);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TRhReligion was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTRhReligion");
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
                JsfUtil.addSuccessMessage("TRhReligion was successfully deleted.");
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

    public List<TRhReligion> getTRhReligionItems() {
        if (TRhReligionItems == null) {
            getPagingInfo();
            TRhReligionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TRhReligionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TRhReligion_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TRhReligion_list";
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
        TRhReligion = null;
        TRhReligionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TRhReligion newTRhReligion = new TRhReligion();
        String newTRhReligionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTRhReligion);
        String TRhReligionString = converter.getAsString(FacesContext.getCurrentInstance(), null, TRhReligion);
        if (!newTRhReligionString.equals(TRhReligionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
