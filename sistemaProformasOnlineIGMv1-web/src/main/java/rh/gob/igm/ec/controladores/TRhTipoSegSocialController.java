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
import rh.gob.igm.ec.TRhTipoSegSocial;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TRhTipoSegSocialFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TRhTipoSegSocialController {

    private boolean ERROR;

    public TRhTipoSegSocialController() {
        pagingInfo = new PagingInfo();
        converter = new TRhTipoSegSocialConverter();
    }
    private TRhTipoSegSocial TRhTipoSegSocial = null;
    private List<TRhTipoSegSocial> TRhTipoSegSocialItems = null;
    private TRhTipoSegSocialFacade jpaController = null;
    private TRhTipoSegSocialConverter converter = null;
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

    public TRhTipoSegSocialFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TRhTipoSegSocialFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tRhTipoSegSocialJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTRhTipoSegSocialItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTRhTipoSegSocialItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TRhTipoSegSocial getTRhTipoSegSocial() {
        if (TRhTipoSegSocial == null) {
            TRhTipoSegSocial = (TRhTipoSegSocial) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTRhTipoSegSocial", converter, null);
        }
        if (TRhTipoSegSocial == null) {
            TRhTipoSegSocial = new TRhTipoSegSocial();
        }
        return TRhTipoSegSocial;
    }

    public String listSetup() {
        reset(true);
        return "TRhTipoSegSocial_list";
    }

    public String createSetup() {
        reset(false);
        TRhTipoSegSocial = new TRhTipoSegSocial();
        return "TRhTipoSegSocial_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TRhTipoSegSocial);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TRhTipoSegSocial was successfully created.");
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
        return scalarSetup("TRhTipoSegSocial_detail");
    }

    public String editSetup() {
        return scalarSetup("TRhTipoSegSocial_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TRhTipoSegSocial = (TRhTipoSegSocial) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTRhTipoSegSocial", converter, null);
        if (TRhTipoSegSocial == null) {
            String requestTRhTipoSegSocialString = JsfUtil.getRequestParameter("jsfcrud.currentTRhTipoSegSocial");
            JsfUtil.addErrorMessage("The TRhTipoSegSocial with id " + requestTRhTipoSegSocialString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TRhTipoSegSocialString = converter.getAsString(FacesContext.getCurrentInstance(), null, TRhTipoSegSocial);
        String currentTRhTipoSegSocialString = JsfUtil.getRequestParameter("jsfcrud.currentTRhTipoSegSocial");
        if (TRhTipoSegSocialString == null || TRhTipoSegSocialString.length() == 0 || !TRhTipoSegSocialString.equals(currentTRhTipoSegSocialString)) {
            String outcome = editSetup();
            if ("TRhTipoSegSocial_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TRhTipoSegSocial. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TRhTipoSegSocial);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TRhTipoSegSocial was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTRhTipoSegSocial");
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
                JsfUtil.addSuccessMessage("TRhTipoSegSocial was successfully deleted.");
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

    public List<TRhTipoSegSocial> getTRhTipoSegSocialItems() {
        if (TRhTipoSegSocialItems == null) {
            getPagingInfo();
            TRhTipoSegSocialItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TRhTipoSegSocialItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TRhTipoSegSocial_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TRhTipoSegSocial_list";
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
        TRhTipoSegSocial = null;
        TRhTipoSegSocialItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TRhTipoSegSocial newTRhTipoSegSocial = new TRhTipoSegSocial();
        String newTRhTipoSegSocialString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTRhTipoSegSocial);
        String TRhTipoSegSocialString = converter.getAsString(FacesContext.getCurrentInstance(), null, TRhTipoSegSocial);
        if (!newTRhTipoSegSocialString.equals(TRhTipoSegSocialString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
