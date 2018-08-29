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
import rh.gob.igm.ec.TFuncion;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TFuncionFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TFuncionController {

    private boolean ERROR;

    public TFuncionController() {
        pagingInfo = new PagingInfo();
        converter = new TFuncionConverter();
    }
    private TFuncion TFuncion = null;
    private List<TFuncion> TFuncionItems = null;
    private TFuncionFacade jpaController = null;
    private TFuncionConverter converter = null;
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

    public TFuncionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TFuncionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tFuncionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTFuncionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTFuncionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TFuncion getTFuncion() {
        if (TFuncion == null) {
            TFuncion = (TFuncion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTFuncion", converter, null);
        }
        if (TFuncion == null) {
            TFuncion = new TFuncion();
        }
        return TFuncion;
    }

    public String listSetup() {
        reset(true);
        return "TFuncion_list";
    }

    public String createSetup() {
        reset(false);
        TFuncion = new TFuncion();
        return "TFuncion_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TFuncion);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TFuncion was successfully created.");
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
        return scalarSetup("TFuncion_detail");
    }

    public String editSetup() {
        return scalarSetup("TFuncion_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TFuncion = (TFuncion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTFuncion", converter, null);
        if (TFuncion == null) {
            String requestTFuncionString = JsfUtil.getRequestParameter("jsfcrud.currentTFuncion");
            JsfUtil.addErrorMessage("The TFuncion with id " + requestTFuncionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TFuncionString = converter.getAsString(FacesContext.getCurrentInstance(), null, TFuncion);
        String currentTFuncionString = JsfUtil.getRequestParameter("jsfcrud.currentTFuncion");
        if (TFuncionString == null || TFuncionString.length() == 0 || !TFuncionString.equals(currentTFuncionString)) {
            String outcome = editSetup();
            if ("TFuncion_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TFuncion. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TFuncion);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TFuncion was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTFuncion");
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
                JsfUtil.addSuccessMessage("TFuncion was successfully deleted.");
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

    public List<TFuncion> getTFuncionItems() {
        if (TFuncionItems == null) {
            getPagingInfo();
            TFuncionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TFuncionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TFuncion_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TFuncion_list";
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
        TFuncion = null;
        TFuncionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TFuncion newTFuncion = new TFuncion();
        String newTFuncionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTFuncion);
        String TFuncionString = converter.getAsString(FacesContext.getCurrentInstance(), null, TFuncion);
        if (!newTFuncionString.equals(TFuncionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
