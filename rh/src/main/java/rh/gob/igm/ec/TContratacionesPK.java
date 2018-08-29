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
public class TContratacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_PERSONA")
    private int noPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_CONT")
    private int noCont;

    public TContratacionesPK() {
    }

    public TContratacionesPK(int noPersona, int noCont) {
        this.noPersona = noPersona;
        this.noCont = noCont;
    }

    public int getNoPersona() {
        return noPersona;
    }

    public void setNoPersona(int noPersona) {
        this.noPersona = noPersona;
    }

    public int getNoCont() {
        return noCont;
    }

    public void setNoCont(int noCont) {
        this.noCont = noCont;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) noPersona;
        hash += (int) noCont;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TContratacionesPK)) {
            return false;
        }
        TContratacionesPK other = (TContratacionesPK) object;
        if (this.noPersona != other.noPersona) {
            return false;
        }
        if (this.noCont != other.noCont) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TContratacionesPK[ noPersona=" + noPersona + ", noCont=" + noCont + " ]";
    }
    
}
