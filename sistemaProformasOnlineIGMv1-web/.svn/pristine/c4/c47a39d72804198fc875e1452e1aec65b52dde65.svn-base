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

/**
 * Clase creada para realizar el manejo de la
 * paginaci�n de la informaci�n del resultado
 * de las b�squedas.
 *
 * @version        $revision$
 * @author         IGM
 */
public class Paginador {

    /** La variable batchSize. */
    private int batchSize = 10; //tama�o del paginaci�n
    /** La variable firstItem. */
    private int firstItem = 0; //ubicaci�n del primer item
    /** La variable itemCount. */
    private int itemCount = -1; //cantidad de datos

    /**
     * Obtiene el valor de la primera posici�n desde la cual
     * se obtendr�n los datos en la consulta ejbql.
     * @return Posici�n desde la cual se obtendr�n los datos.
     */
    public int getFirstItem() {
        //Error si no se ha cargado la cantidad de datos totales
        if (this.itemCount == -1) {
            throw new IllegalStateException("itemCount se debe establecer antes de invocar a getFirstItem");
        }
        if (this.firstItem >= this.itemCount) {
            if (this.itemCount == 0) {
                this.firstItem = 0;
            } else {
                int zeroBasedItemCount = this.itemCount - 1;
                double pageDouble = zeroBasedItemCount / this.batchSize;
                int page = (int) Math.floor(pageDouble);
                this.firstItem = page * this.batchSize;
            }
        }
        return this.firstItem;
    }

    /**
     * Ingresa el valor para la varible firstItem.
     * @param firstItem Valor a ser ingresado
     */
    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }

    /**
     * Calcula el valor del �ltimo item.
     * @return valor del �ltimo item
     */
    public int getLastItem() {
        this.getFirstItem();
        return (this.firstItem + this.batchSize > this.itemCount)
                ? this.itemCount
                : this.firstItem + this.batchSize;
    }

    /**
     * Calcula la posici�n a la cual debe moverse firstItem(siguiente p�gina).
     */
    public void nextPage() {
        this.getFirstItem();
        if (this.firstItem + this.batchSize < this.itemCount) {
            this.firstItem += this.batchSize;
        }
    }

    /**
     * Calcula la posici�n a la cual debe volver firstItem(p�gina anterior).
     */
    public void previousPage() {
        this.getFirstItem();
        this.firstItem -= this.batchSize;
        if (this.firstItem < 0) {
            this.firstItem = 0;
        }
    }

    /**
     * Retorna el valor de batchSize.
     * 
     * @return valor de batchSize
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * Retorna el valor de itemCount.
     *
     * @return valor de itemCount
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Ingresa el valor para itemCount.
     * @param itemCount valor a ingresar
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * Determina si se debe visualizar la opci�n anterior del paginador.
     * @return True si se debe visualizar, false caso contrario
     */
    public Boolean getRenderAnterior() {
        return this.firstItem >= this.batchSize;
    }

    /**
     * Determina si se debe visualizar la opci�n siguiente del paginador.
     * @return True si se debe visualizar, false caso contrario
     */
    public Boolean getRenderSiguiente() {
        return this.getLastItem() + this.batchSize <= this.itemCount;
    }
}
