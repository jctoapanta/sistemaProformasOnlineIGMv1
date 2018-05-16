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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "TDIRECCIONESUSR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdireccionesusr.findAll", query = "SELECT t FROM Tdireccionesusr t")
    , @NamedQuery(name = "Tdireccionesusr.findByIdDireccion", query = "SELECT t FROM Tdireccionesusr t WHERE t.idDireccion = :idDireccion")
    , @NamedQuery(name = "Tdireccionesusr.findByCallePrincipalDireccion", query = "SELECT t FROM Tdireccionesusr t WHERE t.callePrincipalDireccion = :callePrincipalDireccion")
    , @NamedQuery(name = "Tdireccionesusr.findByNumeroDireccion", query = "SELECT t FROM Tdireccionesusr t WHERE t.numeroDireccion = :numeroDireccion")
    , @NamedQuery(name = "Tdireccionesusr.findByCalleSecundariaDireccion", query = "SELECT t FROM Tdireccionesusr t WHERE t.calleSecundariaDireccion = :calleSecundariaDireccion")
    , @NamedQuery(name = "Tdireccionesusr.findByReferenciaDireccion", query = "SELECT t FROM Tdireccionesusr t WHERE t.referenciaDireccion = :referenciaDireccion")})
public class Tdireccionesusr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DIRECCION")
    private Long idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CALLE_PRINCIPAL_DIRECCION")
    private String callePrincipalDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUMERO_DIRECCION")
    private String numeroDireccion;
    @Size(max = 100)
    @Column(name = "CALLE_SECUNDARIA_DIRECCION")
    private String calleSecundariaDireccion;
    @Size(max = 200)
    @Column(name = "REFERENCIA_DIRECCION")
    private String referenciaDireccion;
    @JoinColumn(name = "CIU", referencedColumnName = "CIU")
    @ManyToOne(optional = false)
    private Tentidad ciu;
    @JoinColumns({
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA")
        , @JoinColumn(name = "ID_CANTON", referencedColumnName = "ID_CANTON")
        , @JoinColumn(name = "ID_PARROQUIA", referencedColumnName = "ID_PARROQUIA")})
    @ManyToOne(optional = false)
    private Tparroquia tparroquia;
    @JoinColumn(name = "ID_TIPO_DIRECCION", referencedColumnName = "ID_TIPO_DIRECCION")
    @ManyToOne(optional = false)
    private Ttipodireccion idTipoDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion")
    private Collection<Tproforma> tproformaCollection;

    public Tdireccionesusr() {
    }

    public Tdireccionesusr(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Tdireccionesusr(Long idDireccion, String callePrincipalDireccion, String numeroDireccion) {
        this.idDireccion = idDireccion;
        this.callePrincipalDireccion = callePrincipalDireccion;
        this.numeroDireccion = numeroDireccion;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCallePrincipalDireccion() {
        return callePrincipalDireccion;
    }

    public void setCallePrincipalDireccion(String callePrincipalDireccion) {
        this.callePrincipalDireccion = callePrincipalDireccion;
    }

    public String getNumeroDireccion() {
        return numeroDireccion;
    }

    public void setNumeroDireccion(String numeroDireccion) {
        this.numeroDireccion = numeroDireccion;
    }

    public String getCalleSecundariaDireccion() {
        return calleSecundariaDireccion;
    }

    public void setCalleSecundariaDireccion(String calleSecundariaDireccion) {
        this.calleSecundariaDireccion = calleSecundariaDireccion;
    }

    public String getReferenciaDireccion() {
        return referenciaDireccion;
    }

    public void setReferenciaDireccion(String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }

    public Tentidad getCiu() {
        return ciu;
    }

    public void setCiu(Tentidad ciu) {
        this.ciu = ciu;
    }

    public Tparroquia getTparroquia() {
        return tparroquia;
    }

    public void setTparroquia(Tparroquia tparroquia) {
        this.tparroquia = tparroquia;
    }

    public Ttipodireccion getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(Ttipodireccion idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    @XmlTransient
    public Collection<Tproforma> getTproformaCollection() {
        return tproformaCollection;
    }

    public void setTproformaCollection(Collection<Tproforma> tproformaCollection) {
        this.tproformaCollection = tproformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tdireccionesusr)) {
            return false;
        }
        Tdireccionesusr other = (Tdireccionesusr) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tdireccionesusr[ idDireccion=" + idDireccion + " ]";
    }
    
}
