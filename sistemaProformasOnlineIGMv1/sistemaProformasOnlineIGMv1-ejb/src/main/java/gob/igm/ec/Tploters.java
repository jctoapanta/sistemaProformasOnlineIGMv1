/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TPLOTERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tploters.findAll", query = "SELECT t FROM Tploters t")
    , @NamedQuery(name = "Tploters.findByIdPloter", query = "SELECT t FROM Tploters t WHERE t.idPloter = :idPloter")
    , @NamedQuery(name = "Tploters.findByDescPloter", query = "SELECT t FROM Tploters t WHERE t.descPloter = :descPloter")
    , @NamedQuery(name = "Tploters.findByControl", query = "SELECT t FROM Tploters t WHERE t.control = :control")})
public class Tploters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLOTER")
    private Short idPloter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESC_PLOTER")
    private String descPloter;
    @Size(max = 1)
    @Column(name = "CONTROL")
    private String control;

    public Tploters() {
    }

    public Tploters(Short idPloter) {
        this.idPloter = idPloter;
    }

    public Tploters(Short idPloter, String descPloter) {
        this.idPloter = idPloter;
        this.descPloter = descPloter;
    }

    public Short getIdPloter() {
        return idPloter;
    }

    public void setIdPloter(Short idPloter) {
        this.idPloter = idPloter;
    }

    public String getDescPloter() {
        return descPloter;
    }

    public void setDescPloter(String descPloter) {
        this.descPloter = descPloter;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPloter != null ? idPloter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tploters)) {
            return false;
        }
        Tploters other = (Tploters) object;
        if ((this.idPloter == null && other.idPloter != null) || (this.idPloter != null && !this.idPloter.equals(other.idPloter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tploters[ idPloter=" + idPloter + " ]";
    }
    
}
