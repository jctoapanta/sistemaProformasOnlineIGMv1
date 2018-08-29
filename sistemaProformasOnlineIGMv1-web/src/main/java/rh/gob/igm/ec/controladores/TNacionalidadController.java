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
import rh.gob.igm.ec.TNacionalidad;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TNacionalidadFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TNacionalidadController {

    private boolean ERROR;

    public TNacionalidadController() {
        pagingInfo = new PagingInfo();
        converter = new TNacionalidadConverter();
    }
    private TNacionalidad TNacionalidad = null;
    private List<TNacionalidad> TNacionalidadItems = null;
    private TNacionalidadFacade jpaController = null;
    private TNacionalidadConverter converter = null;
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

    public TNacionalidadFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TNacionalidadFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tNacionalidadJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTNacionalidadItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTNacionalidadItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TNacionalidad getTNacionalidad() {
        if (TNacionalidad == null) {
            TNacionalidad = (TNacionalidad) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTNacionalidad", converter, null);
        }
        if (TNacionalidad == null) {
            TNacionalidad = new TNacionalidad();
        }
        return TNacionalidad;
    }

    public String listSetup() {
        reset(true);
        return "TNacionalidad_list";
    }

    public String createSetup() {
        reset(false);
        TNacionalidad = new TNacionalidad();
        return "TNacionalidad_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TNacionalidad);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TNacionalidad was successfully created.");
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
        return scalarSetup("TNacionalidad_detail");
    }

    public String editSetup() {
        return scalarSetup("TNacionalidad_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TNacionalidad = (TNacionalidad) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTNacionalidad", converter, null);
        if (TNacionalidad == null) {
            String requestTNacionalidadString = JsfUtil.getRequestParameter("jsfcrud.currentTNacionalidad");
            JsfUtil.addErrorMessage("The TNacionalidad with id " + requestTNacionalidadString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TNacionalidadString = converter.getAsString(FacesContext.getCurrentInstance(), null, TNacionalidad);
        String currentTNacionalidadString = JsfUtil.getRequestParameter("jsfcrud.currentTNacionalidad");
        if (TNacionalidadString == null || TNacionalidadString.length() == 0 || !TNacionalidadString.equals(currentTNacionalidadString)) {
            String outcome = editSetup();
            if ("TNacionalidad_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TNacionalidad. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TNacionalidad);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TNacionalidad was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTNacionalidad");
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
                JsfUtil.addSuccessMessage("TNacionalidad was successfully deleted.");
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

    public List<TNacionalidad> getTNacionalidadItems() {
        if (TNacionalidadItems == null) {
            getPagingInfo();
            TNacionalidadItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TNacionalidadItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TNacionalidad_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TNacionalidad_list";
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
        TNacionalidad = null;
        TNacionalidadItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TNacionalidad newTNacionalidad = new TNacionalidad();
        String newTNacionalidadString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTNacionalidad);
        String TNacionalidadString = converter.getAsString(FacesContext.getCurrentInstance(), null, TNacionalidad);
        if (!newTNacionalidadString.equals(TNacionalidadString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
