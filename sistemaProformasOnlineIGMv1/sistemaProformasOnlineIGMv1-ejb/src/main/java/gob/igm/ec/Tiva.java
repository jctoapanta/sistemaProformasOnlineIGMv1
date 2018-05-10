/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TIVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiva.findAll", query = "SELECT t FROM Tiva t"),
    @NamedQuery(name = "Tiva.findByIdIva", query = "SELECT t FROM Tiva t WHERE t.idIva = :idIva"),
    @NamedQuery(name = "Tiva.findByIdPeriodo", query = "SELECT t FROM Tiva t WHERE t.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Tiva.findByIdSucursal", query = "SELECT t FROM Tiva t WHERE t.idSucursal = :idSucursal"),
    @NamedQuery(name = "Tiva.findByIdProforma", query = "SELECT t FROM Tiva t WHERE t.idProforma = :idProforma"),
    @NamedQuery(name = "Tiva.findByNoReg", query = "SELECT t FROM Tiva t WHERE t.noReg = :noReg"),
    @NamedQuery(name = "Tiva.findByPorcentajeIva", query = "SELECT t FROM Tiva t WHERE t.porcentajeIva = :porcentajeIva"),
    @NamedQuery(name = "Tiva.findByIdResponsable", query = "SELECT t FROM Tiva t WHERE t.idResponsable = :idResponsable"),
    @NamedQuery(name = "Tiva.findByIdModificador", query = "SELECT t FROM Tiva t WHERE t.idModificador = :idModificador"),
    @NamedQuery(name = "Tiva.findByFechaCreacion", query = "SELECT t FROM Tiva t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Tiva.findByFechaModifica", query = "SELECT t FROM Tiva t WHERE t.fechaModifica = :fechaModifica"),
    @NamedQuery(name = "Tiva.findByVersion", query = "SELECT t FROM Tiva t WHERE t.version = :version"),
    @NamedQuery(name = "Tiva.findByEstado", query = "SELECT t FROM Tiva t WHERE t.estado = :estado")})
public class Tiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_IVA")
    private Long idIva;
    @Column(name = "ID_PERIODO")
    private Short idPeriodo;
    @Column(name = "ID_SUCURSAL")
    private long idSucursal;
    @Column(name = "ID_PROFORMA")
    private Long idProforma;
    @Column(name = "NO_REG")
    private Short noReg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentajeIva;
    @Column(name = "ID_RESPONSABLE")
    private Long idResponsable;
    @Column(name = "ID_MODIFICADOR")
    private Long idModificador;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifica;
    @Column(name = "VERSION")
    private BigInteger version;
    @Size(max = 2)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idIva")
    private Collection<Tdetproforma> tdetproformaCollection;

    public Tiva() {
    }

    public Tiva(Long idIva) {
        this.idIva = idIva;
    }

    public Long getIdIva() {
        return idIva;
    }

    public void setIdIva(Long idIva) {
        this.idIva = idIva;
    }

    public Short getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Short idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Long getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(Long idProforma) {
        this.idProforma = idProforma;
    }

    public Short getNoReg() {
        return noReg;
    }

    public void setNoReg(Short noReg) {
        this.noReg = noReg;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
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

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Tdetproforma> getTdetproformaCollection() {
        return tdetproformaCollection;
    }

    public void setTdetproformaCollection(Collection<Tdetproforma> tdetproformaCollection) {
        this.tdetproformaCollection = tdetproformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIva != null ? idIva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiva)) {
            return false;
        }
        Tiva other = (Tiva) object;
        if ((this.idIva == null && other.idIva != null) || (this.idIva != null && !this.idIva.equals(other.idIva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tiva[ idIva=" + idIva + " ]";
    }
    
}
