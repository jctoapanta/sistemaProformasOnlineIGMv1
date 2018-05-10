/*
 * Instituto Geogr�fico Militar
 * Sistema: IGM
 * Creado: 21-ene-2011 - 13:55:02
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

import java.util.TimeZone;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Bean de aplicaci�n que contiene los formatos para
 * fechas, n�meros, ect. del sistema.
 *
 * @version $revision$
 * @author IGM
 */
@ManagedBean
@ApplicationScoped
public class Formato {

    /** La variable formatoFechaHora. */
    private String formatoFechaHora = "dd/MM/yyyy HH:mm";
    /** La variable formatoFecha. */
    private String formatoFecha = "dd/MM/yyyy";
    
    /** La variable timeZone. */
    private TimeZone timeZone;

    /** Inicializa las variables de clase. */
    public Formato() {
        this.timeZone = TimeZone.getTimeZone("GMT-5");
    }

    /**
     * Retorna el valor FormatoFechaHora.
     *
     * @return El formato fecha hora
     */
    public String getFormatoFechaHora() {
        return formatoFechaHora;
    }

    /**
     * Ingresa el valor de FormatoFechaHora.
     *
     * @param formatoFechaHora la formato fecha hora
     */
    public void setFormatoFechaHora(String formatoFechaHora) {
        this.formatoFechaHora = formatoFechaHora;
    }

    /**
     * Retorna el valor FormatoFecha.
     *
     * @return El formato fecha
     */
    public String getFormatoFecha() {
        return formatoFecha;
    }

    /**
     * Ingresa el valor de FormatoFecha.
     *
     * @param formatoFecha la formato fecha
     */
    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    /**
     * Obtiene el valor TimeZone.
     *
     * @return the time zone
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Ingresa el valor TimeZone.
     *
     * @param timeZone nuevo valor para time zone
     */
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
