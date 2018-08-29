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
import rh.gob.igm.ec.TAreas;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.TAreasPK;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TAreasFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TAreasController {

    private boolean ERROR;

    public TAreasController() {
        pagingInfo = new PagingInfo();
        converter = new TAreasConverter();
    }
    private TAreas TAreas = null;
    private List<TAreas> TAreasItems = null;
    private TAreasFacade jpaController = null;
    private TAreasConverter converter = null;
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

    public TAreasFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TAreasFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tAreasJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTAreasItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTAreasItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TAreas getTAreas() {
        if (TAreas == null) {
            TAreas = (TAreas) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAreas", converter, null);
        }
        if (TAreas == null) {
            TAreas = new TAreas();
        }
        return TAreas;
    }

    public String listSetup() {
        reset(true);
        return "TAreas_list";
    }

    public String createSetup() {
        reset(false);
        TAreas = new TAreas();
        TAreas.setTAreasPK(new TAreasPK());
        return "TAreas_create";
    }

    public String create() {
        TAreas.getTAreasPK().setNoEmpMatriz(TAreas.getTAreas().getTAreasPK().getNoEmpMatriz());
        // TODO: no setter methods were found in your primary key class
        //    rh.gob.igm.ec.TAreasPK
        // and therefore initialization code need manual adjustments.
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TAreas);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAreas was successfully created.");
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
        return scalarSetup("TAreas_detail");
    }

    public String editSetup() {
        return scalarSetup("TAreas_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TAreas = (TAreas) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTAreas", converter, null);
        if (TAreas == null) {
            String requestTAreasString = JsfUtil.getRequestParameter("jsfcrud.currentTAreas");
            JsfUtil.addErrorMessage("The TAreas with id " + requestTAreasString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        TAreas.getTAreasPK().setNoEmpMatriz(TAreas.getTAreas().getTAreasPK().getNoEmpMatriz());
        // TODO: no setter methods were found in your primary key class
        //    rh.gob.igm.ec.TAreasPK
        // and therefore initialization code need manual adjustments.
        String TAreasString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAreas);
        String currentTAreasString = JsfUtil.getRequestParameter("jsfcrud.currentTAreas");
        if (TAreasString == null || TAreasString.length() == 0 || !TAreasString.equals(currentTAreasString)) {
            String outcome = editSetup();
            if ("TAreas_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TAreas. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TAreas);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TAreas was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTAreas");
        TAreasPK id = converter.getId(idAsString);
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
                JsfUtil.addSuccessMessage("TAreas was successfully deleted.");
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

    public List<TAreas> getTAreasItems() {
        if (TAreasItems == null) {
            getPagingInfo();
            TAreasItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TAreasItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TAreas_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TAreas_list";
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
        TAreas = null;
        TAreasItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TAreas newTAreas = new TAreas();
        newTAreas.setTAreasPK(new TAreasPK());
        String newTAreasString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTAreas);
        String TAreasString = converter.getAsString(FacesContext.getCurrentInstance(), null, TAreas);
        if (!newTAreasString.equals(TAreasString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
