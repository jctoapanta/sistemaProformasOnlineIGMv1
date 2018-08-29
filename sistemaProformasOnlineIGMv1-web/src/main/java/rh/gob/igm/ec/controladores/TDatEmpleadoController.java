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
import rh.gob.igm.ec.TDatEmpleado;
import rh.gob.igm.ec.controladores.util.JsfUtil;
import rh.gob.igm.ec.controladores.util.PagingInfo;
import rh.gob.igm.ec.servicios.TDatEmpleadoFacade;

/**
 *
 * @author TOAPANTA_JUAN
 */
public class TDatEmpleadoController {

    private boolean ERROR;

    public TDatEmpleadoController() {
        pagingInfo = new PagingInfo();
        converter = new TDatEmpleadoConverter();
    }
    private TDatEmpleado TDatEmpleado = null;
    private List<TDatEmpleado> TDatEmpleadoItems = null;
    private TDatEmpleadoFacade jpaController = null;
    private TDatEmpleadoConverter converter = null;
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

    public TDatEmpleadoFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (TDatEmpleadoFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "tDatEmpleadoJpa");
        }
        return jpaController;
    }

    public SelectItem[] getTDatEmpleadoItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getTDatEmpleadoItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public TDatEmpleado getTDatEmpleado() {
        if (TDatEmpleado == null) {
            TDatEmpleado = (TDatEmpleado) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTDatEmpleado", converter, null);
        }
        if (TDatEmpleado == null) {
            TDatEmpleado = new TDatEmpleado();
        }
        return TDatEmpleado;
    }

    public String listSetup() {
        reset(true);
        return "TDatEmpleado_list";
    }

    public String createSetup() {
        reset(false);
        TDatEmpleado = new TDatEmpleado();
        return "TDatEmpleado_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(TDatEmpleado);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TDatEmpleado was successfully created.");
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
        return scalarSetup("TDatEmpleado_detail");
    }

    public String editSetup() {
        return scalarSetup("TDatEmpleado_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        TDatEmpleado = (TDatEmpleado) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTDatEmpleado", converter, null);
        if (TDatEmpleado == null) {
            String requestTDatEmpleadoString = JsfUtil.getRequestParameter("jsfcrud.currentTDatEmpleado");
            JsfUtil.addErrorMessage("The TDatEmpleado with id " + requestTDatEmpleadoString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String TDatEmpleadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, TDatEmpleado);
        String currentTDatEmpleadoString = JsfUtil.getRequestParameter("jsfcrud.currentTDatEmpleado");
        if (TDatEmpleadoString == null || TDatEmpleadoString.length() == 0 || !TDatEmpleadoString.equals(currentTDatEmpleadoString)) {
            String outcome = editSetup();
            if ("TDatEmpleado_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit TDatEmpleado. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(TDatEmpleado);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("TDatEmpleado was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTDatEmpleado");
        Integer id = new Integer(idAsString);
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
                JsfUtil.addSuccessMessage("TDatEmpleado was successfully deleted.");
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

    public List<TDatEmpleado> getTDatEmpleadoItems() {
        if (TDatEmpleadoItems == null) {
            getPagingInfo();
            TDatEmpleadoItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return TDatEmpleadoItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "TDatEmpleado_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "TDatEmpleado_list";
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
        TDatEmpleado = null;
        TDatEmpleadoItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TDatEmpleado newTDatEmpleado = new TDatEmpleado();
        String newTDatEmpleadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTDatEmpleado);
        String TDatEmpleadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, TDatEmpleado);
        if (!newTDatEmpleadoString.equals(TDatEmpleadoString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
