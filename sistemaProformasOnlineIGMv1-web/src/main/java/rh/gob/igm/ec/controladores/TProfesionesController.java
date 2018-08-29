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
import rh.gob.igm.ec.TProfesiones;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TProfesionesFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TProfesionesController {

    private boolean ERROR;

    public TProfesionesController() {
        pagingInfo = new PagingInfo();
        converter = new TProfesionesConverter();
    }
    private TProfesiones TProfesiones = null;
    private List<TProfesiones> TProfesionesItems = null;
    private TProfesionesFacade jpaController = null;
    private TProfesionesConverter converter = null;
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

    public TProfesionesFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TProfesionesFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tProfesionesJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTProfesionesItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTProfesionesItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TProfesiones getTProfesiones() {
        if (TProfesiones == null) {
            TProfesiones = (TProfesiones) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTProfesiones", converter, null);
        }
        if (TProfesiones == null) {
            TProfesiones = new TProfesiones();
        }
        return TProfesiones;
    }

    public String listSetup() {
        reset(true);
        return "TProfesiones_list";
    }

    public String createSetup() {
        reset(false);
        TProfesiones = new TProfesiones();
        return "TProfesiones_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TProfesiones);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TProfesiones was successfully created.");
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
        return scalarSetup("TProfesiones_detail");
    }

    public String editSetup() {
        return scalarSetup("TProfesiones_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TProfesiones = (TProfesiones) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTProfesiones", converter, null);
        if (TProfesiones == null) {
            String requestTProfesionesString = JsfUtil.getRequestParameter("jsfcrud.currentTProfesiones");
            JsfUtil.addErrorMessage("The TProfesiones with id " + requestTProfesionesString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TProfesionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, TProfesiones);
        String currentTProfesionesString = JsfUtil.getRequestParameter("jsfcrud.currentTProfesiones");
        if (TProfesionesString == null || TProfesionesString.length() == 0 || !TProfesionesString.equals(currentTProfesionesString)) {
            String outcome = editSetup();
            if ("TProfesiones_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TProfesiones. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TProfesiones);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TProfesiones was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTProfesiones");
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
                JsfUtil.addSuccessMessage("TProfesiones was successfully deleted.");
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

    public List<TProfesiones> getTProfesionesItems() {
        if (TProfesionesItems == null) {
            getPagingInfo();
            TProfesionesItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TProfesionesItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TProfesiones_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TProfesiones_list";
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
        TProfesiones = null;
        TProfesionesItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TProfesiones newTProfesiones = new TProfesiones();
        String newTProfesionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTProfesiones);
        String TProfesionesString = converter.getAsString(FacesContext.getCurrentInstance(), null, TProfesiones);
        if (!newTProfesionesString.equals(TProfesionesString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
