/*
 * Instituto Geogr�fico Militar
 * Sistema: IGM
 * Creado: 26/06/2018
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

import gob.igm.ec.controladores.util.EncriptUtil;
import gob.igm.ec.controladores.util.FacesUtil;
import groovy.ui.text.FindReplaceUtility;
import java.io.Serializable;
import java.util.logging.Level;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 * The Class Login.
 *
 * @author IGM
 */
@Named ("templateController")
@SessionScoped
public class TemplateController extends FacesUtil implements Serializable {

    /** La variable logger. */
    private static Logger logger;

    private EncriptUtil encriptUtil;

    /**
     * Creates a new instance of Login.
     */
    public TemplateController() {
        this.encriptUtil = new EncriptUtil();
    }
 
    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
         .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        //context.renderResponse(); //Optional
        application.getStateManager().saveSerializedView(context);
    }
}