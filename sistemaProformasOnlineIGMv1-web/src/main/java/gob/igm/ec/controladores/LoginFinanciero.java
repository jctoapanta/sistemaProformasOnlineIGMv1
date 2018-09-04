/*
 * Instituto Geogr�fico Militar
 * Sistema: IGM
 * 
 * Los contenidos de este archivo son propiedad intelectual del Instituto Geogr�fico Militar
 * y se encuentran protegidos por la licencia: "".
 * 
 * Usted puede encontrar una copia de esta licencia en: 
 *   http://www.igm.gov.ec
 * 
 * Copyright 2018-2021 Instituto Geogr�fico Militar. Todos los derechos reservados.
 */
package gob.igm.ec.controladores;

import gob.igm.ec.Tentidad;
import gob.igm.ec.controladores.util.EncriptUtil;
import gob.igm.ec.controladores.util.FacesUtil;
import gob.igm.ec.servicios.TUsuarioSucursalFacade;
import rh.gob.igm.ec.servicios.TDatEmpleadoFacade;
import rh.gob.igm.ec.servicios.TContratacionesFacade;
import java.io.Serializable;
import java.util.List;
import javax.faces.event.ActionEvent;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * The Class Login.
 *
 * @author PULE_DIEGO
 */
@Named("loginFinanciero")
@SessionScoped
public class LoginFinanciero extends FacesUtil implements Serializable {

@EJB
private TUsuarioSucursalFacade tUsuarioSucursalFacade;
@EJB
private TDatEmpleadoFacade tDatEmpleadoFacade;
@EJB
private TContratacionesFacade TContratacionesFacade;



    private EncriptUtil encriptUtil;
    /**
     * La variable funcionario
     */
    private String funcionario;
    /**
     * La variable clave.
     */
    private String clave;
    private String nombre;
    private String igmMail;

    
    
    public String getIgmMail() {
        return tDatEmpleadoFacade.email(funcionario);
    }

    public void setIgmMail(String igmMail) {
        this.igmMail = igmMail;
    }

    public String getNombre() {
        return tDatEmpleadoFacade.logNombre(funcionario);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private List<Tentidad> usuario;

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    public LoginFinanciero() {
    }

    /**
     * Permite ingresar los datos del usuarios a sesi�n.
     *
     * @return Regla de navegaci�n
     */
    public String ingresar() {
        String regla = "";
        int ci_financiero = this.tDatEmpleadoFacade.logFinanciero(funcionario);
        String pwd_fuuncionario = this.tUsuarioSucursalFacade.pwd(ci_financiero, clave);
        // para validar al financiero
        String financiero = this.TContratacionesFacade.Estados(funcionario);
        if (pwd_fuuncionario == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No puede ingresar clave no valida.", ""));
        } else {
            regla = "/tproforma/ListFinanciero.xhtml";
        }
        return regla;
    }

    public void cerrarSession(ActionEvent evento) {
        super.getRequest().getSession().invalidate();
    }

    /**
     * Retorna el valor Clave.
     *
     * @return El clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Ingresa el valor de Clave.
     *
     * @param clave la clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the usuario
     */
    public List<Tentidad> getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(List<Tentidad> usuario) {
        this.usuario = usuario;
    }
}
