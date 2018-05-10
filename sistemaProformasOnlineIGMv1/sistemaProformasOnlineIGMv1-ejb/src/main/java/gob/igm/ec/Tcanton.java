/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TCANTON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcanton.findAll", query = "SELECT t FROM Tcanton t"),
    @NamedQuery(name = "Tcanton.findByIdProvincia", query = "SELECT t FROM Tcanton t WHERE t.tcantonPK.idProvincia = :idProvincia"),
    @NamedQuery(name = "Tcanton.findByIdCanton", query = "SELECT t FROM Tcanton t WHERE t.tcantonPK.idCanton = :idCanton"),
    @NamedQuery(name = "Tcanton.findByCanton", query = "SELECT t FROM Tcanton t WHERE t.canton = :canton"),
    @NamedQuery(name = "Tcanton.findByLPrincipal", query = "SELECT t FROM Tcanton t WHERE t.lPrincipal = :lPrincipal")})
public class Tcanton implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TcantonPK tcantonPK;
    @Size(max = 50)
    @Column(name = "CANTON")
    private String canton;
    @Column(name = "L_PRINCIPAL")
    private Short lPrincipal;
    @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tprovincia tprovincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcanton")
    private Collection<Tparroquia> tparroquiaCollection;

    public Tcanton() {
    }

    public Tcanton(TcantonPK tcantonPK) {
        this.tcantonPK = tcantonPK;
    }

    public Tcanton(int idProvincia, int idCanton) {
        this.tcantonPK = new TcantonPK(idProvincia, idCanton);
    }

    public TcantonPK getTcantonPK() {
        return tcantonPK;
    }

    public void setTcantonPK(TcantonPK tcantonPK) {
        this.tcantonPK = tcantonPK;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public Short getLPrincipal() {
        return lPrincipal;
    }

    public void setLPrincipal(Short lPrincipal) {
        this.lPrincipal = lPrincipal;
    }

    public Tprovincia getTprovincia() {
        return tprovincia;
    }

    public void setTprovincia(Tprovincia tprovincia) {
        this.tprovincia = tprovincia;
    }

    @XmlTransient
    public Collection<Tparroquia> getTparroquiaCollection() {
        return tparroquiaCollection;
    }

    public void setTparroquiaCollection(Collection<Tparroquia> tparroquiaCollection) {
        this.tparroquiaCollection = tparroquiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcantonPK != null ? tcantonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcanton)) {
            return false;
        }
        Tcanton other = (Tcanton) object;
        if ((this.tcantonPK == null && other.tcantonPK != null) || (this.tcantonPK != null && !this.tcantonPK.equals(other.tcantonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tcanton[ tcantonPK=" + tcantonPK + " ]";
    }
    
}
