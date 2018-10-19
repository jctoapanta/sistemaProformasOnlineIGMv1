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

import gob.igm.ec.controladores.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import org.apache.log4j.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class Login.
 *
 * @author IGM
 */
@Named("logout")
@SessionScoped
public class Logout extends FacesUtil implements Serializable {

    /**
     * La variable logger.
     */
    private static Logger logger;

    /**
     * Creates a new instance of Logoutn.
     */
    public Logout() {
    }

    public void salir(HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();
    }

    public String salirCli(HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();
        String regla = request.getContextPath()+request.getServletPath()+"/index.xhtml";
        return regla;
    }

    public String salirAdm(HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        sesion.invalidate();
        String regla = "/indexFinanciero.xhtml";
        return regla;
    }

}
