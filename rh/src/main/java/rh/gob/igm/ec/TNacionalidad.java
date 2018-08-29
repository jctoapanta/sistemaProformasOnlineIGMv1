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
@Table(name = "T_NACIONALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TNacionalidad.findAll", query = "SELECT t FROM TNacionalidad t")
    , @NamedQuery(name = "TNacionalidad.findByIdNacionalidad", query = "SELECT t FROM TNacionalidad t WHERE t.idNacionalidad = :idNacionalidad")
    , @NamedQuery(name = "TNacionalidad.findByNacionalidad", query = "SELECT t FROM TNacionalidad t WHERE t.nacionalidad = :nacionalidad")})
public class TNacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NACIONALIDAD")
    private Short idNacionalidad;
    @Size(max = 20)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @OneToMany(mappedBy = "idNacionalidad")
    private List<TDatEmpleado> tDatEmpleadoList;

    public TNacionalidad() {
    }

    public TNacionalidad(Short idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public Short getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Short idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
        hash += (idNacionalidad != null ? idNacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TNacionalidad)) {
            return false;
        }
        TNacionalidad other = (TNacionalidad) object;
        if ((this.idNacionalidad == null && other.idNacionalidad != null) || (this.idNacionalidad != null && !this.idNacionalidad.equals(other.idNacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TNacionalidad[ idNacionalidad=" + idNacionalidad + " ]";
    }
    
}
