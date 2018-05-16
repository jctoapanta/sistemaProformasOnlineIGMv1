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
public class TtarifarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA")
    private int idProvincia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CANTON")
    private int idCanton;

    public TtarifarioPK() {
    }

    public TtarifarioPK(int idProvincia, int idCanton) {
        this.idProvincia = idProvincia;
        this.idCanton = idCanton;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProvincia;
        hash += (int) idCanton;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtarifarioPK)) {
            return false;
        }
        TtarifarioPK other = (TtarifarioPK) object;
        if (this.idProvincia != other.idProvincia) {
            return false;
        }
        if (this.idCanton != other.idCanton) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.TtarifarioPK[ idProvincia=" + idProvincia + ", idCanton=" + idCanton + " ]";
    }
    
}
