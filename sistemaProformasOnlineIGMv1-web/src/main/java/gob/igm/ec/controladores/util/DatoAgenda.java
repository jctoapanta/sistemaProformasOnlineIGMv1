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

import java.io.Serializable;
import java.util.Date;

/**
 * La Clase DatoAgenda.
 *
 * @author IGM
 */
public class DatoAgenda implements Serializable {

    /** La constante serialVersionUID. */
    private static final long serialVersionUID = 7569798463683452195L;
    /** La variable codSec. */
    private Long codSec;
    /** La variable proceso. */
    private String proceso;
    /** La variable descripcion. */
    private String descripcion;
    /** La variable fechaHoraInicioEstimada. */
    private Date fechaHoraInicioEstimada;
    /** La variable fechaHoraFinEstimada. */
    private Date fechaHoraFinEstimada;

    /**
     * Inicializa las variables de clase y
     * crea una nueva instancia de dato agenda.
     */
    public DatoAgenda() {
    }

    /**
     * Inicializa las variables de clase y
     * crea una nueva instancia de dato agenda.
     *
     * @param codSec la cod sec
     * @param proceso la proceso
     * @param descripcion la descripcion
     * @param fechaHoraInicioEstimada la fecha hora inicio estimada
     * @param fechaHoraFinEstimada la fecha hora fin estimada
     */
    public DatoAgenda(Long codSec, String proceso, String descripcion, Date fechaHoraInicioEstimada,
            Date fechaHoraFinEstimada) {
        this.codSec = codSec;
        this.proceso = proceso;
        this.descripcion = descripcion;
        this.fechaHoraInicioEstimada = fechaHoraInicioEstimada;
        this.fechaHoraFinEstimada = fechaHoraFinEstimada;
    }

    /**
     * Retorna el valor CodSec.
     *
     * @return El cod sec
     */
    public Long getCodSec() {
        return codSec;
    }

    /**
     * Ingresa el valor de CodSec.
     *
     * @param codSec la cod sec
     */
    public void setCodSec(Long codSec) {
        this.codSec = codSec;
    }

    /**
     * Retorna el valor Descripcion.
     *
     * @return El descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Ingresa el valor de Descripcion.
     *
     * @param descripcion la descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna el valor FechaHoraFinEstimada.
     *
     * @return El fecha hora fin estimada
     */
    public Date getFechaHoraFinEstimada() {
        return fechaHoraFinEstimada;
    }

    /**
     * Ingresa el valor de FechaHoraFinEstimada.
     *
     * @param fechaHoraFinEstimada la fecha hora fin estimada
     */
    public void setFechaHoraFinEstimada(Date fechaHoraFinEstimada) {
        this.fechaHoraFinEstimada = fechaHoraFinEstimada;
    }

    /**
     * Retorna el valor FechaHoraInicioEstimada.
     *
     * @return El fecha hora inicio estimada
     */
    public Date getFechaHoraInicioEstimada() {
        return fechaHoraInicioEstimada;
    }

    /**
     * Ingresa el valor de FechaHoraInicioEstimada.
     *
     * @param fechaHoraInicioEstimada la fecha hora inicio estimada
     */
    public void setFechaHoraInicioEstimada(Date fechaHoraInicioEstimada) {
        this.fechaHoraInicioEstimada = fechaHoraInicioEstimada;
    }

    /**
     * Obtiene el valor de la variable proceso.
     *
     * @return the la variable proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * Ingresa el valor de la variable proceso.
     *
     * @param proceso the new la variable proceso
     */
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
}
