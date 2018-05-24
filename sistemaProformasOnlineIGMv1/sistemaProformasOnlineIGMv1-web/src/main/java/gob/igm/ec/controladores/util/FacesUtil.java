/*
 * Instituto Geogr�fico Militar
 * Sistema: IGM
 * Creado: 11-ago-2010 - 11:21:20
 * 
 * Los contenidos de este archivo son propiedad intelectual del Instituto Geogr�fico Militar
 * y se encuentran protegidos por la licencia: "".
 * 
 * Usted puede encontrar una copia de esta licencia en: 
 *   http://www.igm.gov.ec
 * 
 * Copyright 2010-2012 Instituto Geogr�fico Militar. Todos los derechos reservados.
 */
package gob.igm.ec.controladores.util;

//import com.gov.ec.produccion.igm.MenuOP;
import gob.igm.ec.Tprovincia;
import gob.igm.ec.servicios.TprovinciaFacade;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;
import javax.ejb.EJB;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * The Class FacesUtil.
 *
 * @author CAIZA_CARLOS
 */
public class FacesUtil {
    /** La variable recursoGeneral. */
    private ResourceBundle recursoGeneral;
    
    @EJB
    private TprovinciaFacade provinciaServicio;
    
    private List<Tprovincia> provincias;

    /**
     * @return the provincias
     */
    public List<Tprovincia> getProvincias() {
        provinciaServicio=new TprovinciaFacade();
        return provinciaServicio.findAll();
    }

    /**
     * @param provincias the provincias to set
     */
    public void setProvincias(List<Tprovincia> provincias) {
        this.provincias = provincias;
    }


    /* Inicializa las variables de clase. */
    /**
     * Inicializa las variables de clase y
     * crea una nueva instancia de faces util.
     */
    public FacesUtil() {
        this.recursoGeneral = ResourceBundle.getBundle("/Bundle");
    }

    /**
     * Agrega un mensaje de error.
     * @param msg Mensaje de error
     */
    public void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Agrega un mensaje de satisfacci�n.
     * @param msg Mensaje
     */
    public void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    /**
     * 
     * Agrega un mensaje de advertencia 
     * @param msg 
     */
     public void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Retorna el FacesContex de la aplicaci�n.
     * @return FacesContext
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Retorna el valor ELContext.
     *
     * @return El eL context
     */
    public ELContext getELContext() {
        return this.getFacesContext().getELContext();
    }

    /**
     * Retorna el valor Bean.
     *
     * @param <T> the generic type
     * @param nombreBean la nombre bean
     * @return El bean
     */
    public <T> T getBean(String nombreBean) {
        return (T) this.getELContext().getELResolver().getValue(this.getELContext(), null, nombreBean);
    }

    /**
     * Permite quitar de sesi�n todos los beans a excepci�n
     * del bean especificado como par�metro.
     * Se debe tener en cuenta que solo busca y elimina los
     * Beans que terminan en OP, puesto que para la aplicaci�n
     * todos los bean son nombrados de la siguiente manera:
     * nombreBeanOP.
     * El nombre de los bean est�n definidos en el archivo
     * faces-config.
     *
     * @param beanPersistir la bean persistir
     */
    protected void eliminarBeans(String beanPersistir) {
        Map<String, Object> sesiones = this.getFacesContext().getExternalContext().getSessionMap();
        Iterator it = sesiones.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> object = (Entry) it.next();
            //Verificamos que existan bean de Ordenes de Producci�n cargados,
            //estos beans siempre terminan en OP y luego los eliminamos
            if (StringUtils.endsWith(object.getKey(), "OP")
                    && !StringUtils.equalsIgnoreCase(object.getKey(), beanPersistir)) {
                it.remove();
            }
        }
    }

    /**
     * Elimina un bean de sesi�n.
     * @param beanEliminar Nombre del bean a ser eliminado
     */
    protected void eliminarBean(String beanEliminar) {
        Map<String, Object> sesiones = this.getFacesContext().getExternalContext().getSessionMap();
        Iterator it = sesiones.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Map.Entry<String, Object> object = (Entry) it.next();
                //eliminamos el bean
                if (StringUtils.equalsIgnoreCase(object.getKey(), beanEliminar)) {
                    it.remove();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Retorna el valor Request.
     *
     * @return El request
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) this.getFacesContext().getExternalContext().getRequest();
    }

    /**
     * Retorna el valor RecursoGeneral.
     *
     * @return El recurso general
     */
    public ResourceBundle getRecursoGeneral() {
        return recursoGeneral;
    }

    /**
     * Ingresa el valor de RecursoGeneral.
     *
     * @param recursoGeneral la recurso general
     */
    public void setRecursoGeneral(ResourceBundle recursoGeneral) {
        this.recursoGeneral = recursoGeneral;
    }

    /**
     * @return the provinciaServicio
     */
    public TprovinciaFacade getProvinciaServicio() {
        return provinciaServicio;
    }

    /**
     * @param provinciaServicio the provinciaServicio to set
     */
    public void setProvinciaServicio(TprovinciaFacade provinciaServicio) {
        this.provinciaServicio = provinciaServicio;
    }
    


    /**
     * Retorna el valor MenuOP.
     *
     * @return El menu op
     */
//    public MenuOP getMenuOP() {
//        return (MenuOP) this.getBean(MenuOP.NOMBRE_BEAN);
//    }
}
