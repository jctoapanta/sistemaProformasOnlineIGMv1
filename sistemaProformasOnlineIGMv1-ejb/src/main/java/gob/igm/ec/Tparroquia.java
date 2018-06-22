/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "TPARROQUIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tparroquia.findAll", query = "SELECT t FROM Tparroquia t")
    , @NamedQuery(name = "Tparroquia.findByIdProvincia", query = "SELECT t FROM Tparroquia t WHERE t.tparroquiaPK.idProvincia = :idProvincia")
    , @NamedQuery(name = "Tparroquia.findByIdCanton", query = "SELECT t FROM Tparroquia t WHERE t.tparroquiaPK.idCanton = :idCanton")
    , @NamedQuery(name = "Tparroquia.findByIdParroquia", query = "SELECT t FROM Tparroquia t WHERE t.tparroquiaPK.idParroquia = :idParroquia")
    , @NamedQuery(name = "Tparroquia.findByParroquia", query = "SELECT t FROM Tparroquia t WHERE t.parroquia = :parroquia")})
public class Tparroquia implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tparroquia")
    private List<Tdireccionesusr> tdireccionesusrList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TparroquiaPK tparroquiaPK;
    @Size(max = 50)
    @Column(name = "PARROQUIA")
    private String parroquia;
    @JoinColumns({
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_CANTON", referencedColumnName = "ID_CANTON", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tcanton tcanton;

    public Tparroquia() {
    }

    public Tparroquia(TparroquiaPK tparroquiaPK) {
        this.tparroquiaPK = tparroquiaPK;
    }

    public Tparroquia(int idProvincia, int idCanton, int idParroquia) {
        this.tparroquiaPK = new TparroquiaPK(idProvincia, idCanton, idParroquia);
    }

    public TparroquiaPK getTparroquiaPK() {
        return tparroquiaPK;
    }

    public void setTparroquiaPK(TparroquiaPK tparroquiaPK) {
        this.tparroquiaPK = tparroquiaPK;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public Tcanton getTcanton() {
        return tcanton;
    }

    public void setTcanton(Tcanton tcanton) {
        this.tcanton = tcanton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tparroquiaPK != null ? tparroquiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tparroquia)) {
            return false;
        }
        Tparroquia other = (Tparroquia) object;
        if ((this.tparroquiaPK == null && other.tparroquiaPK != null) || (this.tparroquiaPK != null && !this.tparroquiaPK.equals(other.tparroquiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return parroquia;
    }

    @XmlTransient
    public List<Tdireccionesusr> getTdireccionesusrList() {
        return tdireccionesusrList;
    }

    public void setTdireccionesusrList(List<Tdireccionesusr> tdireccionesusrList) {
        this.tdireccionesusrList = tdireccionesusrList;
    }
    
}
