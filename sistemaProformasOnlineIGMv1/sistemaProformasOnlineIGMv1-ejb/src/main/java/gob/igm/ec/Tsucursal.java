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
import javax.persistence.CascadeType;
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
@Table(name = "TSUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsucursal.findAll", query = "SELECT t FROM Tsucursal t")
    , @NamedQuery(name = "Tsucursal.findByIdSucursal", query = "SELECT t FROM Tsucursal t WHERE t.idSucursal = :idSucursal")
    , @NamedQuery(name = "Tsucursal.findByDescSucursal", query = "SELECT t FROM Tsucursal t WHERE t.descSucursal = :descSucursal")
    , @NamedQuery(name = "Tsucursal.findByDireccion", query = "SELECT t FROM Tsucursal t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Tsucursal.findByTelefono", query = "SELECT t FROM Tsucursal t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Tsucursal.findByFax", query = "SELECT t FROM Tsucursal t WHERE t.fax = :fax")
    , @NamedQuery(name = "Tsucursal.findByEmail", query = "SELECT t FROM Tsucursal t WHERE t.email = :email")
    , @NamedQuery(name = "Tsucursal.findByRuc", query = "SELECT t FROM Tsucursal t WHERE t.ruc = :ruc")
    , @NamedQuery(name = "Tsucursal.findByIdResponsable", query = "SELECT t FROM Tsucursal t WHERE t.idResponsable = :idResponsable")
    , @NamedQuery(name = "Tsucursal.findByCCtble", query = "SELECT t FROM Tsucursal t WHERE t.cCtble = :cCtble")
    , @NamedQuery(name = "Tsucursal.findByIdModificador", query = "SELECT t FROM Tsucursal t WHERE t.idModificador = :idModificador")
    , @NamedQuery(name = "Tsucursal.findByFechaCreacion", query = "SELECT t FROM Tsucursal t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Tsucursal.findByFechaModificacion", query = "SELECT t FROM Tsucursal t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Tsucursal.findByVersion", query = "SELECT t FROM Tsucursal t WHERE t.version = :version")})
public class Tsucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUCURSAL")
    private Long idSucursal;
    @Size(max = 100)
    @Column(name = "DESC_SUCURSAL")
    private String descSucursal;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "ID_RESPONSABLE")
    private Long idResponsable;
    @Size(max = 30)
    @Column(name = "C_CTBLE")
    private String cCtble;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tsucursal")
    private Collection<Tproforma> tproformaCollection;

    public Tsucursal() {
    }

    public Tsucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescSucursal() {
        return descSucursal;
    }

    public void setDescSucursal(String descSucursal) {
        this.descSucursal = descSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getCCtble() {
        return cCtble;
    }

    public void setCCtble(String cCtble) {
        this.cCtble = cCtble;
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
    public Collection<Tproforma> getTproformaCollection() {
        return tproformaCollection;
    }

    public void setTproformaCollection(Collection<Tproforma> tproformaCollection) {
        this.tproformaCollection = tproformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsucursal)) {
            return false;
        }
        Tsucursal other = (Tsucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tsucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
