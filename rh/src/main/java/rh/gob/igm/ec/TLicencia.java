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
@Table(name = "T_LICENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLicencia.findAll", query = "SELECT t FROM TLicencia t")
    , @NamedQuery(name = "TLicencia.findByNoLicencia", query = "SELECT t FROM TLicencia t WHERE t.noLicencia = :noLicencia")
    , @NamedQuery(name = "TLicencia.findByDescrip", query = "SELECT t FROM TLicencia t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TLicencia.findByObs", query = "SELECT t FROM TLicencia t WHERE t.obs = :obs")})
public class TLicencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_LICENCIA")
    private Short noLicencia;
    @Size(max = 20)
    @Column(name = "DESCRIP")
    private String descrip;
    @Size(max = 250)
    @Column(name = "OBS")
    private String obs;
    @OneToMany(mappedBy = "noLicencia")
    private List<TDatEmpleado> tDatEmpleadoList;

    public TLicencia() {
    }

    public TLicencia(Short noLicencia) {
        this.noLicencia = noLicencia;
    }

    public Short getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(Short noLicencia) {
        this.noLicencia = noLicencia;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
        hash += (noLicencia != null ? noLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLicencia)) {
            return false;
        }
        TLicencia other = (TLicencia) object;
        if ((this.noLicencia == null && other.noLicencia != null) || (this.noLicencia != null && !this.noLicencia.equals(other.noLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TLicencia[ noLicencia=" + noLicencia + " ]";
    }
    
}
