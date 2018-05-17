/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TUNIDADMEDIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tunidadmedida.findAll", query = "SELECT t FROM Tunidadmedida t")
    , @NamedQuery(name = "Tunidadmedida.findByIdUnidad", query = "SELECT t FROM Tunidadmedida t WHERE t.idUnidad = :idUnidad")
    , @NamedQuery(name = "Tunidadmedida.findByDescUnidad", query = "SELECT t FROM Tunidadmedida t WHERE t.descUnidad = :descUnidad")
    , @NamedQuery(name = "Tunidadmedida.findByObsUnidad", query = "SELECT t FROM Tunidadmedida t WHERE t.obsUnidad = :obsUnidad")
    , @NamedQuery(name = "Tunidadmedida.findByIdResponsable", query = "SELECT t FROM Tunidadmedida t WHERE t.idResponsable = :idResponsable")
    , @NamedQuery(name = "Tunidadmedida.findByIdModificador", query = "SELECT t FROM Tunidadmedida t WHERE t.idModificador = :idModificador")
    , @NamedQuery(name = "Tunidadmedida.findByFechaCreacion", query = "SELECT t FROM Tunidadmedida t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Tunidadmedida.findByFechaModificacion", query = "SELECT t FROM Tunidadmedida t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Tunidadmedida.findByVersion", query = "SELECT t FROM Tunidadmedida t WHERE t.version = :version")})
public class Tunidadmedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD")
    private Long idUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESC_UNIDAD")
    private String descUnidad;
    @Size(max = 100)
    @Column(name = "OBS_UNIDAD")
    private String obsUnidad;
    @Column(name = "ID_RESPONSABLE")
    private Long idResponsable;
    @Column(name = "ID_MODIFICADOR")
    private Long idModificador;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "VERSION")
    private BigInteger version;
    @OneToMany(mappedBy = "idUnidad")
    private Collection<Titem> titemCollection;

    public Tunidadmedida() {
    }

    public Tunidadmedida(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Tunidadmedida(Long idUnidad, String descUnidad) {
        this.idUnidad = idUnidad;
        this.descUnidad = descUnidad;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getDescUnidad() {
        return descUnidad;
    }

    public void setDescUnidad(String descUnidad) {
        this.descUnidad = descUnidad;
    }

    public String getObsUnidad() {
        return obsUnidad;
    }

    public void setObsUnidad(String obsUnidad) {
        this.obsUnidad = obsUnidad;
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Long getIdModificador() {
        return idModificador;
    }

    public void setIdModificador(Long idModificador) {
        this.idModificador = idModificador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
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
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tunidadmedida)) {
            return false;
        }
        Tunidadmedida other = (Tunidadmedida) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tunidadmedida[ idUnidad=" + idUnidad + " ]";
    }
    
}
