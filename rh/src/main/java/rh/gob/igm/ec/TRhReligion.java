/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "T_RH_RELIGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRhReligion.findAll", query = "SELECT t FROM TRhReligion t")
    , @NamedQuery(name = "TRhReligion.findByNoRelig", query = "SELECT t FROM TRhReligion t WHERE t.noRelig = :noRelig")
    , @NamedQuery(name = "TRhReligion.findByDescrip", query = "SELECT t FROM TRhReligion t WHERE t.descrip = :descrip")})
public class TRhReligion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_RELIG")
    private Short noRelig;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIP")
    private String descrip;
    @OneToMany(mappedBy = "noRelig")
    private List<TDatEmpleado> tDatEmpleadoList;

    public TRhReligion() {
    }

    public TRhReligion(Short noRelig) {
        this.noRelig = noRelig;
    }

    public TRhReligion(Short noRelig, String descrip) {
        this.noRelig = noRelig;
        this.descrip = descrip;
    }

    public Short getNoRelig() {
        return noRelig;
    }

    public void setNoRelig(Short noRelig) {
        this.noRelig = noRelig;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @XmlTransient
    public List<TDatEmpleado> getTDatEmpleadoList() {
        return tDatEmpleadoList;
    }

    public void setTDatEmpleadoList(List<TDatEmpleado> tDatEmpleadoList) {
        this.tDatEmpleadoList = tDatEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noRelig != null ? noRelig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRhReligion)) {
            return false;
        }
        TRhReligion other = (TRhReligion) object;
        if ((this.noRelig == null && other.noRelig != null) || (this.noRelig != null && !this.noRelig.equals(other.noRelig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TRhReligion[ noRelig=" + noRelig + " ]";
    }
    
}
