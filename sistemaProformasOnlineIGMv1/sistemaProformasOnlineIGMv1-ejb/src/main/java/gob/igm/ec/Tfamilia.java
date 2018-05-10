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
@Table(name = "TFAMILIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tfamilia.findAll", query = "SELECT t FROM Tfamilia t"),
    @NamedQuery(name = "Tfamilia.findByIdFamilia", query = "SELECT t FROM Tfamilia t WHERE t.idFamilia = :idFamilia"),
    @NamedQuery(name = "Tfamilia.findByDescFamilia", query = "SELECT t FROM Tfamilia t WHERE t.descFamilia = :descFamilia"),
    @NamedQuery(name = "Tfamilia.findByIdCentroGestion", query = "SELECT t FROM Tfamilia t WHERE t.idCentroGestion = :idCentroGestion"),
    @NamedQuery(name = "Tfamilia.findByIdCentroEjecucion", query = "SELECT t FROM Tfamilia t WHERE t.idCentroEjecucion = :idCentroEjecucion"),
    @NamedQuery(name = "Tfamilia.findByTipoFamilia", query = "SELECT t FROM Tfamilia t WHERE t.tipoFamilia = :tipoFamilia"),
    @NamedQuery(name = "Tfamilia.findByLEspecial", query = "SELECT t FROM Tfamilia t WHERE t.lEspecial = :lEspecial"),
    @NamedQuery(name = "Tfamilia.findByIdSubfamilia", query = "SELECT t FROM Tfamilia t WHERE t.idSubfamilia = :idSubfamilia"),
    @NamedQuery(name = "Tfamilia.findByLServiciosinop", query = "SELECT t FROM Tfamilia t WHERE t.lServiciosinop = :lServiciosinop")})
public class Tfamilia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FAMILIA")
    private Short idFamilia;
    @Size(max = 100)
    @Column(name = "DESC_FAMILIA")
    private String descFamilia;
    @Column(name = "ID_CENTRO_GESTION")
    private Short idCentroGestion;
    @Column(name = "ID_CENTRO_EJECUCION")
    private Short idCentroEjecucion;
    @Size(max = 1)
    @Column(name = "TIPO_FAMILIA")
    private String tipoFamilia;
    @Column(name = "L_ESPECIAL")
    private Short lEspecial;
    @Column(name = "ID_SUBFAMILIA")
    private Short idSubfamilia;
    @Column(name = "L_SERVICIOSINOP")
    private Short lServiciosinop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFamilia")
    private Collection<Titem> titemCollection;

    public Tfamilia() {
    }

    public Tfamilia(Short idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Short getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Short idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDescFamilia() {
        return descFamilia;
    }

    public void setDescFamilia(String descFamilia) {
        this.descFamilia = descFamilia;
    }

    public Short getIdCentroGestion() {
        return idCentroGestion;
    }

    public void setIdCentroGestion(Short idCentroGestion) {
        this.idCentroGestion = idCentroGestion;
    }

    public Short getIdCentroEjecucion() {
        return idCentroEjecucion;
    }

    public void setIdCentroEjecucion(Short idCentroEjecucion) {
        this.idCentroEjecucion = idCentroEjecucion;
    }

    public String getTipoFamilia() {
        return tipoFamilia;
    }

    public void setTipoFamilia(String tipoFamilia) {
        this.tipoFamilia = tipoFamilia;
    }

    public Short getLEspecial() {
        return lEspecial;
    }

    public void setLEspecial(Short lEspecial) {
        this.lEspecial = lEspecial;
    }

    public Short getIdSubfamilia() {
        return idSubfamilia;
    }

    public void setIdSubfamilia(Short idSubfamilia) {
        this.idSubfamilia = idSubfamilia;
    }

    public Short getLServiciosinop() {
        return lServiciosinop;
    }

    public void setLServiciosinop(Short lServiciosinop) {
        this.lServiciosinop = lServiciosinop;
    }

    @XmlTransient
    public Collection<Titem> getTitemCollection() {
        return titemCollection;
    }

    public void setTitemCollection(Collection<Titem> titemCollection) {
        this.titemCollection = titemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tfamilia)) {
            return false;
        }
        Tfamilia other = (Tfamilia) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tfamilia[ idFamilia=" + idFamilia + " ]";
    }
    
}
