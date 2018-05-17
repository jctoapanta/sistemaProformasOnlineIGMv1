/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "TTIPODIRECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipodireccion.findAll", query = "SELECT t FROM Ttipodireccion t")
    , @NamedQuery(name = "Ttipodireccion.findByIdTipoDireccion", query = "SELECT t FROM Ttipodireccion t WHERE t.idTipoDireccion = :idTipoDireccion")
    , @NamedQuery(name = "Ttipodireccion.findByDescTipoDireccion", query = "SELECT t FROM Ttipodireccion t WHERE t.descTipoDireccion = :descTipoDireccion")})
public class Ttipodireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_DIRECCION")
    private Short idTipoDireccion;
    @Size(max = 50)
    @Column(name = "DESC_TIPO_DIRECCION")
    private String descTipoDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDireccion")
    private Collection<Tdireccionesusr> tdireccionesusrCollection;

    public Ttipodireccion() {
    }

    public Ttipodireccion(Short idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    public Short getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(Short idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    public String getDescTipoDireccion() {
        return descTipoDireccion;
    }

    public void setDescTipoDireccion(String descTipoDireccion) {
        this.descTipoDireccion = descTipoDireccion;
    }

    @XmlTransient
    public Collection<Tdireccionesusr> getTdireccionesusrCollection() {
        return tdireccionesusrCollection;
    }

    public void setTdireccionesusrCollection(Collection<Tdireccionesusr> tdireccionesusrCollection) {
        this.tdireccionesusrCollection = tdireccionesusrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDireccion != null ? idTipoDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttipodireccion)) {
            return false;
        }
        Ttipodireccion other = (Ttipodireccion) object;
        if ((this.idTipoDireccion == null && other.idTipoDireccion != null) || (this.idTipoDireccion != null && !this.idTipoDireccion.equals(other.idTipoDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Ttipodireccion[ idTipoDireccion=" + idTipoDireccion + " ]";
    }
    
}
