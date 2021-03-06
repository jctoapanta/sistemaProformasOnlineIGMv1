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
public class TdetproformaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL")
    private long idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERIODO")
    private short idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFORMA")
    private long idProforma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_REG")
    private short noReg;

    public TdetproformaPK() {
    }

    public TdetproformaPK(long idSucursal, short idPeriodo, long idProforma, short noReg) {
        this.idSucursal = idSucursal;
        this.idPeriodo = idPeriodo;
        this.idProforma = idProforma;
        this.noReg = noReg;
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public short getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(short idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public long getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(long idProforma) {
        this.idProforma = idProforma;
    }

    public short getNoReg() {
        return noReg;
    }

    public void setNoReg(short noReg) {
        this.noReg = noReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSucursal;
        hash += (int) idPeriodo;
        hash += (int) idProforma;
        hash += (int) noReg;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdetproformaPK)) {
            return false;
        }
        TdetproformaPK other = (TdetproformaPK) object;
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idPeriodo != other.idPeriodo) {
            return false;
        }
        if (this.idProforma != other.idProforma) {
            return false;
        }
        if (this.noReg != other.noReg) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.TdetproformaPK[ idSucursal=" + idSucursal + ", idPeriodo=" + idPeriodo + ", idProforma=" + idProforma + ", noReg=" + noReg + " ]";
    }
    
}
