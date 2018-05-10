/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Embeddable
public class TproformaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERIODO")
    private short idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL")
    private long idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFORMA")
    private long idProforma;

    public TproformaPK() {
    }

    public TproformaPK(short idPeriodo, long idSucursal, long idProforma) {
        this.idPeriodo = idPeriodo;
        this.idSucursal = idSucursal;
        this.idProforma = idProforma;
    }

    public short getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(short idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public long getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(long idProforma) {
        this.idProforma = idProforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodo;
        hash += (int) idSucursal;
        hash += (int) idProforma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TproformaPK)) {
            return false;
        }
        TproformaPK other = (TproformaPK) object;
        if (this.idPeriodo != other.idPeriodo) {
            return false;
        }
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idProforma != other.idProforma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.TproformaPK[ idPeriodo=" + idPeriodo + ", idSucursal=" + idSucursal + ", idProforma=" + idProforma + " ]";
    }
    
}
