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
@Table(name = "T_PROFESIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TProfesiones.findAll", query = "SELECT t FROM TProfesiones t")
    , @NamedQuery(name = "TProfesiones.findByNoProfesion", query = "SELECT t FROM TProfesiones t WHERE t.noProfesion = :noProfesion")
    , @NamedQuery(name = "TProfesiones.findByDescrip", query = "SELECT t FROM TProfesiones t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TProfesiones.findByAbrev", query = "SELECT t FROM TProfesiones t WHERE t.abrev = :abrev")
    , @NamedQuery(name = "TProfesiones.findByCodigo", query = "SELECT t FROM TProfesiones t WHERE t.codigo = :codigo")})
public class TProfesiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_PROFESION")
    private Short noProfesion;
    @Size(max = 50)
    @Column(name = "DESCRIP")
    private String descrip;
    @Size(max = 10)
    @Column(name = "ABREV")
    private String abrev;
    @Size(max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "noProfesion")
    private List<TDatEmpleado> tDatEmpleadoList;

    public TProfesiones() {
    }

    public TProfesiones(Short noProfesion) {
        this.noProfesion = noProfesion;
    }

    public Short getNoProfesion() {
        return noProfesion;
    }

    public void setNoProfesion(Short noProfesion) {
        this.noProfesion = noProfesion;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        hash += (noProfesion != null ? noProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TProfesiones)) {
            return false;
        }
        TProfesiones other = (TProfesiones) object;
        if ((this.noProfesion == null && other.noProfesion != null) || (this.noProfesion != null && !this.noProfesion.equals(other.noProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TProfesiones[ noProfesion=" + noProfesion + " ]";
    }
    
}
