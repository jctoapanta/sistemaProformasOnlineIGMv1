/*
 * Instituto Geogr�fico Militar
 * Sistema: IGM
 * Creado: 21-ene-2011 - 13:53:28
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
import gob.igm.ec.controladores.util.JsfUtil;

import gob.igm.ec.servicios.TentidadFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;


/**
 * The Class Login.
 *
 * @author IGM
 */
@Named ("login")
@SessionScoped
public class Login extends FacesUtil implements Serializable {

    /**
     * @return the cliente
     */
    public Tentidad getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Tentidad cliente) {
        this.cliente = cliente;
    }

    /** La variable logger. */
    private static Logger logger;
    @EJB
    private TentidadFacade usuarioServicio;
    private EncriptUtil encriptUtil;
    /** La variable aliasBase. */
    private String aliasBase;
    /** La variable clave. */
    private String clave;
    private List<Tentidad> usuario;
    private Tentidad cliente;

//    static {
//        logger = Logger.getLogger(Login.class);
//    }

    /**
     * Creates a new instance of Login.
     */
    public Login() {
        this.encriptUtil = new EncriptUtil();
        this.cliente=new Tentidad();
    }

    /**
     * Permite ingresar los datos del usuarios a sesi�n.
     * @return Regla de navegaci�n
     */
    public String ingresar() {
        //List<Object> usuario;
        String regla = "faces/tproforma/ListProXCli.xhtml";
        try {
            String cifrado = this.encriptUtil.encrypt3DES(this.clave);
            setUsuario(this.usuarioServicio.buscarUsuarioClave(this.aliasBase, cifrado));
            for (Tentidad tentidad : usuario) {
                cliente.setCiu(tentidad.getCiu());
                cliente.setApellidos(tentidad.getApellidos());
                cliente.setNombres(tentidad.getNombres());
                cliente.setDireccion(tentidad.getDireccion());
            }
            if (getUsuario().isEmpty()){
                JsfUtil.addErrorMessage("Usuario no existe o Clave incorrecta, favor verifique");
                regla = "faces/index.xhtml";
            }
        }
        catch (Exception ex) {
            regla = "#";
            logger.error(ex.getMessage(), ex);
            super.addErrorMessage(super.getRecursoGeneral().getString("msgErrorLogin"));
        }
        return regla;
    }

    /**
     * Permite Registrar los datos del usuarios.
     * @return Regla de navegaci�n
     */
    public String registrar() {
        List<Object> usuario;
        String regla = "faces/registro.xhtml";
        try {
            String cifrado = this.encriptUtil.encrypt3DES(this.clave);
            usuario = this.usuarioServicio.buscarExisteUsuario(this.aliasBase);
            if (usuario.isEmpty()){
                JsfUtil.addErrorMessage("Usuario no existe o Clave incorrecta, favor verifique");
                regla = "faces/index.xhtml";
            }
        }
        catch (Exception ex) {
            regla = "#";
            logger.error(ex.getMessage(), ex);
            super.addErrorMessage(super.getRecursoGeneral().getString("msgErrorBooking"));
        }
        return regla;
    }    
    
    /**
     * Cierra la sesi�n del usuario.
     * @param evento Evento generado por la p�gina
     */
    public void cerrarSession(ActionEvent evento) {
        super.getRequest().getSession().invalidate();
    }

    /**
     * Retorna el valor AliasBase.
     *
     * @return El alias base
     */
    public String getAliasBase() {
        return aliasBase;
    }

    /**
     * Ingresa el valor de AliasBase.
     *
     * @param aliasBase la alias base
     */
    public void setAliasBase(String aliasBase) {
        this.aliasBase = aliasBase;
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