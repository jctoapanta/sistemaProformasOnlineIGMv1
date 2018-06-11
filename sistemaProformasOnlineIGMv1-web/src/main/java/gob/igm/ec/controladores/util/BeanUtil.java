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

import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;

/**
 * Maneja informaci�n para realizar el control de la paginaci�n de los datos
 * obtenidos en las consultas, mediante la manipulaci�n de la variables de la
 * clase Paginador.
 *
 * @version $revision$
 * @author IGM
 */
public abstract class BeanUtil
        extends FacesUtil {

    /* Bandera para activar/desactivar bot�n detalle. */
    /** La variable disableBtnDetalle. */
    private Boolean disableBtnDetalle;
    /** La variable paginador. */
    private Paginador paginador;

    /**
     * Inicializa las variables de clase.
     */
    public BeanUtil() {
        this.disableBtnDetalle = Boolean.TRUE;
        this.paginador = new Paginador();
    }

    /**
     * Realiza la consulta de los primeros registros (p�gina 1).
     * @param evento Evento generado por la p�gina.
     */
    public void primero(ActionEvent evento) {
        this.paginador.setFirstItem(0);
        try {
            this.buscar();
        } catch (Exception e) {
            addErrorMessage(e.getMessage());
        }
    }

    /**
     * Realiza la b�squeda de los registros anteriores(p�gina anterior).
     * @param evento Evento generado por la p�gina.
     */
    public void anterior(ActionEvent evento) {
        this.paginador.previousPage();
        this.buscar();
    }

    /**
     * Realiza la b�squeda de los siguientes registros (siguiente p�gina).
     * @param evento Evento generado por la p�gina.
     */
    public void siguiente(ActionEvent evento) {
        this.paginador.nextPage();
        this.buscar();
    }

    /**
     * Realiza la consulta de los �ltimos registros (p�gina n).
     * @param evento Evento generado por la p�gina.
     */
    public void ultimo(ActionEvent evento) {
        int cantidad = this.paginador.getItemCount();
        int mod = cantidad % 10;
        if (mod > 0) {
            this.paginador.setFirstItem(cantidad - mod);
        } else {
            this.paginador.setFirstItem(cantidad - 10);
        }
        this.buscar();
    }

    /**
     * Reinicia los valores del paginador.
     * @param resetFirstItem True, reinicia todos los valores.
     * False, reinicia solo el valor de firstItem.
     */
    protected void reset(boolean resetFirstItem) {
        this.paginador.setItemCount(-1);
        if (resetFirstItem) {
            this.paginador.setFirstItem(0);
        }
    }

    public void resetearFiltrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    /**
     * Retorna el valor Paginador.
     *
     * @return El paginador
     */
    public Paginador getPaginador() {
        return paginador;
    }

    /**
     * Ingresa el valor de Paginador.
     *
     * @param paginador la paginador
     */
    public void setPaginador(Paginador paginador) {
        this.paginador = paginador;
    }

    /**
     * Retorna el valor de la variable disableBtnDetalle.
     * @return valor de la variable disableBtnDetalle
     */
    public Boolean getDisableBtnDetalle() {
        return disableBtnDetalle;
    }

    /**
     * Ingresa el valor para la variable disableBtnDetalle.
     * @param disableBtnDetalle valor a ingresar
     */
    public void setDisableBtnDetalle(Boolean disableBtnDetalle) {
        this.disableBtnDetalle = disableBtnDetalle;
    }

    /**
     * M�todo que define como se deben realizar las b�squedas.
     * Puesto que las b�squedas son diferentes para cada entidad
     * este m�todo defe ser redefinido de forma obligatoria, por
     * tal motivo es de tipo abstarct.
     */
    protected abstract void buscar();
}
