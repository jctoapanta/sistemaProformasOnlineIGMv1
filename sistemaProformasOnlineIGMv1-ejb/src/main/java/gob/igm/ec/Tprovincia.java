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
@Table(name = "TPROVINCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tprovincia.findAll", query = "SELECT t FROM Tprovincia t")
    , @NamedQuery(name = "Tprovincia.findByIdProvincia", query = "SELECT t FROM Tprovincia t WHERE t.idProvincia = :idProvincia")
    , @NamedQuery(name = "Tprovincia.findByProvincia", query = "SELECT t FROM Tprovincia t WHERE t.provincia = :provincia")
    , @NamedQuery(name = "Tprovincia.findByDiasEntrega", query = "SELECT t FROM Tprovincia t WHERE t.diasEntrega = :diasEntrega")})
public class Tprovincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROVINCIA")
    private Integer idProvincia;
    @Size(max = 50)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "DIAS_ENTREGA")
    private Integer diasEntrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tprovincia")
    private Collection<Tcanton> tcantonCollection;

    public Tprovincia() {
    }

    public Tprovincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    @XmlTransient
    public Collection<Tcanton> getTcantonCollection() {
        return tcantonCollection;
    }

    public void setTcantonCollection(Collection<Tcanton> tcantonCollection) {
        this.tcantonCollection = tcantonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tprovincia)) {
            return false;
        }
        Tprovincia other = (Tprovincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return provincia;
    }
    
}
