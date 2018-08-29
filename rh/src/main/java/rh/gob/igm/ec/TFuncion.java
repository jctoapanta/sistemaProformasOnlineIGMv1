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
@Table(name = "T_FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFuncion.findAll", query = "SELECT t FROM TFuncion t")
    , @NamedQuery(name = "TFuncion.findByNoFuncion", query = "SELECT t FROM TFuncion t WHERE t.noFuncion = :noFuncion")
    , @NamedQuery(name = "TFuncion.findByDescrip", query = "SELECT t FROM TFuncion t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TFuncion.findByAbrev", query = "SELECT t FROM TFuncion t WHERE t.abrev = :abrev")})
public class TFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_FUNCION")
    private Short noFuncion;
    @Size(max = 50)
    @Column(name = "DESCRIP")
    private String descrip;
    @Size(max = 5)
    @Column(name = "ABREV")
    private String abrev;
    @OneToMany(mappedBy = "noFuncion")
    private List<TContrataciones> tContratacionesList;

    public TFuncion() {
    }

    public TFuncion(Short noFuncion) {
        this.noFuncion = noFuncion;
    }

    public Short getNoFuncion() {
        return noFuncion;
    }

    public void setNoFuncion(Short noFuncion) {
        this.noFuncion = noFuncion;
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

    @XmlTransient
    public List<TContrataciones> getTContratacionesList() {
        return tContratacionesList;
    }

    public void setTContratacionesList(List<TContrataciones> tContratacionesList) {
        this.tContratacionesList = tContratacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noFuncion != null ? noFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFuncion)) {
            return false;
        }
        TFuncion other = (TFuncion) object;
        if ((this.noFuncion == null && other.noFuncion != null) || (this.noFuncion != null && !this.noFuncion.equals(other.noFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TFuncion[ noFuncion=" + noFuncion + " ]";
    }
    
}
