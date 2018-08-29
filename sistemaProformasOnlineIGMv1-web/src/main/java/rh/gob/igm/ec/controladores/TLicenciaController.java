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
import rh.gob.igm.ec.TLicencia;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TLicenciaFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TLicenciaController {

    private boolean ERROR;

    public TLicenciaController() {
        pagingInfo = new PagingInfo();
        converter = new TLicenciaConverter();
    }
    private TLicencia TLicencia = null;
    private List<TLicencia> TLicenciaItems = null;
    private TLicenciaFacade jpaController = null;
    private TLicenciaConverter converter = null;
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

    public TLicenciaFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TLicenciaFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tLicenciaJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTLicenciaItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTLicenciaItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TLicencia getTLicencia() {
        if (TLicencia == null) {
            TLicencia = (TLicencia) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTLicencia", converter, null);
        }
        if (TLicencia == null) {
            TLicencia = new TLicencia();
        }
        return TLicencia;
    }

    public String listSetup() {
        reset(true);
        return "TLicencia_list";
    }

    public String createSetup() {
        reset(false);
        TLicencia = new TLicencia();
        return "TLicencia_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TLicencia);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TLicencia was successfully created.");
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
        return scalarSetup("TLicencia_detail");
    }

    public String editSetup() {
        return scalarSetup("TLicencia_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TLicencia = (TLicencia) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTLicencia", converter, null);
        if (TLicencia == null) {
            String requestTLicenciaString = JsfUtil.getRequestParameter("jsfcrud.currentTLicencia");
            JsfUtil.addErrorMessage("The TLicencia with id " + requestTLicenciaString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TLicenciaString = converter.getAsString(FacesContext.getCurrentInstance(), null, TLicencia);
        String currentTLicenciaString = JsfUtil.getRequestParameter("jsfcrud.currentTLicencia");
        if (TLicenciaString == null || TLicenciaString.length() == 0 || !TLicenciaString.equals(currentTLicenciaString)) {
            String outcome = editSetup();
            if ("TLicencia_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TLicencia. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TLicencia);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TLicencia was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTLicencia");
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
                JsfUtil.addSuccessMessage("TLicencia was successfully deleted.");
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

    public List<TLicencia> getTLicenciaItems() {
        if (TLicenciaItems == null) {
            getPagingInfo();
            TLicenciaItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TLicenciaItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TLicencia_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TLicencia_list";
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
        TLicencia = null;
        TLicenciaItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TLicencia newTLicencia = new TLicencia();
        String newTLicenciaString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTLicencia);
        String TLicenciaString = converter.getAsString(FacesContext.getCurrentInstance(), null, TLicencia);
        if (!newTLicenciaString.equals(TLicenciaString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
