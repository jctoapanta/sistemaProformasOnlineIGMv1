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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titem.findAll", query = "SELECT t FROM Titem t"),
    @NamedQuery(name = "Titem.findByIdItem", query = "SELECT t FROM Titem t WHERE t.idItem = :idItem"),
    @NamedQuery(name = "Titem.findByDescItem", query = "SELECT t FROM Titem t WHERE t.descItem = :descItem"),
    @NamedQuery(name = "Titem.findByPvp", query = "SELECT t FROM Titem t WHERE t.pvp = :pvp"),
    @NamedQuery(name = "Titem.findByCosto", query = "SELECT t FROM Titem t WHERE t.costo = :costo"),
    @NamedQuery(name = "Titem.findByLIva", query = "SELECT t FROM Titem t WHERE t.lIva = :lIva"),
    @NamedQuery(name = "Titem.findByEstado", query = "SELECT t FROM Titem t WHERE t.estado = :estado"),
    @NamedQuery(name = "Titem.findByLInventariado", query = "SELECT t FROM Titem t WHERE t.lInventariado = :lInventariado"),
    @NamedQuery(name = "Titem.findByIdCreador", query = "SELECT t FROM Titem t WHERE t.idCreador = :idCreador"),
    @NamedQuery(name = "Titem.findByIdModificador", query = "SELECT t FROM Titem t WHERE t.idModificador = :idModificador"),
    @NamedQuery(name = "Titem.findByFechaCreacion", query = "SELECT t FROM Titem t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Titem.findByDescripcionAnterior", query = "SELECT t FROM Titem t WHERE t.descripcionAnterior = :descripcionAnterior"),
    @NamedQuery(name = "Titem.findByLVentaOnline", query = "SELECT t FROM Titem t WHERE t.lVentaOnline = :lVentaOnline")})
public class Titem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ITEM")
    private Integer idItem;
    @Size(max = 200)
    @Column(name = "DESC_ITEM")
    private String descItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PVP")
    private BigDecimal pvp;
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Column(name = "L_IVA")
    private BigInteger lIva;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "L_INVENTARIADO")
    private BigInteger lInventariado;
    @Size(max = 100)
    @Column(name = "ID_CREADOR")
    private String idCreador;
    @Size(max = 100)
    @Column(name = "ID_MODIFICADOR")
    private String idModificador;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 200)
    @Column(name = "DESCRIPCION_ANTERIOR")
    private String descripcionAnterior;
    @Column(name = "L_VENTA_ONLINE")
    private Short lVentaOnline;
    @JoinColumn(name = "ID_FAMILIA", referencedColumnName = "ID_FAMILIA")
    @ManyToOne(optional = false)
    private Tfamilia idFamilia;
    @JoinColumn(name = "ID_UNIDAD", referencedColumnName = "ID_UNIDAD")
    @ManyToOne
    private Tunidadmedida idUnidad;
    @OneToMany(mappedBy = "idItem")
    private Collection<Tdetproforma> tdetproformaCollection;

    public Titem() {
    }

    public Titem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigInteger getLIva() {
        return lIva;
    }

    public void setLIva(BigInteger lIva) {
        this.lIva = lIva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getLInventariado() {
        return lInventariado;
    }

    public void setLInventariado(BigInteger lInventariado) {
        this.lInventariado = lInventariado;
    }

    public String getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(String idCreador) {
        this.idCreador = idCreador;
    }

    public String getIdModificador() {
        return idModificador;
    }

    public void setIdModificador(String idModificador) {
        this.idModificador = idModificador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcionAnterior() {
        return descripcionAnterior;
    }

    public void setDescripcionAnterior(String descripcionAnterior) {
        this.descripcionAnterior = descripcionAnterior;
    }

    public Short getLVentaOnline() {
        return lVentaOnline;
    }

    public void setLVentaOnline(Short lVentaOnline) {
        this.lVentaOnline = lVentaOnline;
    }

    public Tfamilia getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Tfamilia idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Tunidadmedida getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Tunidadmedida idUnidad) {
        this.idUnidad = idUnidad;
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
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titem)) {
            return false;
        }
        Titem other = (Titem) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Titem[ idItem=" + idItem + " ]";
    }
    
}
