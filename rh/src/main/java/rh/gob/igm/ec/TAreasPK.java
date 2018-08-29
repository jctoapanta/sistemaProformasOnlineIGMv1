/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

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
public class TAreasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_CD")
    private short noCd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_EMP_MATRIZ")
    private short noEmpMatriz;

    public TAreasPK() {
    }

    public TAreasPK(short noCd, short noEmpMatriz) {
        this.noCd = noCd;
        this.noEmpMatriz = noEmpMatriz;
    }

    public short getNoCd() {
        return noCd;
    }

    public void setNoCd(short noCd) {
        this.noCd = noCd;
    }

    public short getNoEmpMatriz() {
        return noEmpMatriz;
    }

    public void setNoEmpMatriz(short noEmpMatriz) {
        this.noEmpMatriz = noEmpMatriz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) noCd;
        hash += (int) noEmpMatriz;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAreasPK)) {
            return false;
        }
        TAreasPK other = (TAreasPK) object;
        if (this.noCd != other.noCd) {
            return false;
        }
        if (this.noEmpMatriz != other.noEmpMatriz) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TAreasPK[ noCd=" + noCd + ", noEmpMatriz=" + noEmpMatriz + " ]";
    }
    
}
