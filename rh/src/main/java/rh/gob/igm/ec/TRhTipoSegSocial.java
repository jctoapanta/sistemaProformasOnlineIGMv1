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
@Table(name = "T_RH_TIPO_SEG_SOCIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TRhTipoSegSocial.findAll", query = "SELECT t FROM TRhTipoSegSocial t")
    , @NamedQuery(name = "TRhTipoSegSocial.findByNoSeg", query = "SELECT t FROM TRhTipoSegSocial t WHERE t.noSeg = :noSeg")
    , @NamedQuery(name = "TRhTipoSegSocial.findByDescrip", query = "SELECT t FROM TRhTipoSegSocial t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TRhTipoSegSocial.findByCodigo", query = "SELECT t FROM TRhTipoSegSocial t WHERE t.codigo = :codigo")})
public class TRhTipoSegSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_SEG")
    private Short noSeg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIP")
    private String descrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "noSeg")
    private List<TDatEmpleado> tDatEmpleadoList;

    public TRhTipoSegSocial() {
    }

    public TRhTipoSegSocial(Short noSeg) {
        this.noSeg = noSeg;
    }

    public TRhTipoSegSocial(Short noSeg, String descrip, String codigo) {
        this.noSeg = noSeg;
        this.descrip = descrip;
        this.codigo = codigo;
    }

    public Short getNoSeg() {
        return noSeg;
    }

    public void setNoSeg(Short noSeg) {
        this.noSeg = noSeg;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
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
        hash += (noSeg != null ? noSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRhTipoSegSocial)) {
            return false;
        }
        TRhTipoSegSocial other = (TRhTipoSegSocial) object;
        if ((this.noSeg == null && other.noSeg != null) || (this.noSeg != null && !this.noSeg.equals(other.noSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TRhTipoSegSocial[ noSeg=" + noSeg + " ]";
    }
    
}
