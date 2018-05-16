/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "TPROFORMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tproforma.findAll", query = "SELECT t FROM Tproforma t")
    , @NamedQuery(name = "Tproforma.findByIdPeriodoAndCiu", query = "SELECT t FROM Tproforma t WHERE t.tproformaPK.idPeriodo = :idPeriodo and t.ciu.ciu = :ciu and t.comprobantePago is null")        
    , @NamedQuery(name = "Tproforma.findByIdSucursal", query = "SELECT t FROM Tproforma t WHERE t.tproformaPK.idSucursal = :idSucursal")
    , @NamedQuery(name = "Tproforma.findByIdPeriodo", query = "SELECT t FROM Tproforma t WHERE t.tproformaPK.idPeriodo = :idPeriodo")
    , @NamedQuery(name = "Tproforma.findByIdProforma", query = "SELECT t FROM Tproforma t WHERE t.tproformaPK.idProforma = :idProforma")
    , @NamedQuery(name = "Tproforma.findByEstado", query = "SELECT t FROM Tproforma t WHERE t.estado = :estado")
    , @NamedQuery(name = "Tproforma.findByTipoProforma", query = "SELECT t FROM Tproforma t WHERE t.tipoProforma = :tipoProforma")
    , @NamedQuery(name = "Tproforma.findByNumPedido", query = "SELECT t FROM Tproforma t WHERE t.numPedido = :numPedido")
    , @NamedQuery(name = "Tproforma.findByObsProforma", query = "SELECT t FROM Tproforma t WHERE t.obsProforma = :obsProforma")
    , @NamedQuery(name = "Tproforma.findByEspecTecnica", query = "SELECT t FROM Tproforma t WHERE t.especTecnica = :especTecnica")
    , @NamedQuery(name = "Tproforma.findByValidezDias", query = "SELECT t FROM Tproforma t WHERE t.validezDias = :validezDias")
    , @NamedQuery(name = "Tproforma.findByTiempoEntrega", query = "SELECT t FROM Tproforma t WHERE t.tiempoEntrega = :tiempoEntrega")
    , @NamedQuery(name = "Tproforma.findByContacto", query = "SELECT t FROM Tproforma t WHERE t.contacto = :contacto")
    , @NamedQuery(name = "Tproforma.findByFechaRecepcion", query = "SELECT t FROM Tproforma t WHERE t.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "Tproforma.findByLAutoriza", query = "SELECT t FROM Tproforma t WHERE t.lAutoriza = :lAutoriza")
    , @NamedQuery(name = "Tproforma.findByObsAutoriza", query = "SELECT t FROM Tproforma t WHERE t.obsAutoriza = :obsAutoriza")
    , @NamedQuery(name = "Tproforma.findByFechaCreacion", query = "SELECT t FROM Tproforma t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Tproforma.findByFechaModificacion", query = "SELECT t FROM Tproforma t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Tproforma.findByObsModificacion", query = "SELECT t FROM Tproforma t WHERE t.obsModificacion = :obsModificacion")
    , @NamedQuery(name = "Tproforma.findByIdCreador", query = "SELECT t FROM Tproforma t WHERE t.idCreador = :idCreador")
    , @NamedQuery(name = "Tproforma.findByIdModificador", query = "SELECT t FROM Tproforma t WHERE t.idModificador = :idModificador")
    , @NamedQuery(name = "Tproforma.findByIdPeriodoFac", query = "SELECT t FROM Tproforma t WHERE t.idPeriodoFac = :idPeriodoFac")
    , @NamedQuery(name = "Tproforma.findByIdSucursalFac", query = "SELECT t FROM Tproforma t WHERE t.idSucursalFac = :idSucursalFac")
    , @NamedQuery(name = "Tproforma.findByIdFactura", query = "SELECT t FROM Tproforma t WHERE t.idFactura = :idFactura")
    , @NamedQuery(name = "Tproforma.findByIdAutorizador", query = "SELECT t FROM Tproforma t WHERE t.idAutorizador = :idAutorizador")
    , @NamedQuery(name = "Tproforma.findByFechaConfirmacion", query = "SELECT t FROM Tproforma t WHERE t.fechaConfirmacion = :fechaConfirmacion")
    , @NamedQuery(name = "Tproforma.findByFechaValidez", query = "SELECT t FROM Tproforma t WHERE t.fechaValidez = :fechaValidez")
    , @NamedQuery(name = "Tproforma.findByFormaEntrega", query = "SELECT t FROM Tproforma t WHERE t.formaEntrega = :formaEntrega")
    , @NamedQuery(name = "Tproforma.findByFormaPago", query = "SELECT t FROM Tproforma t WHERE t.formaPago = :formaPago")
    , @NamedQuery(name = "Tproforma.findByLVentaOnline", query = "SELECT t FROM Tproforma t WHERE t.lVentaOnline = :lVentaOnline")})
public class Tproforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TproformaPK tproformaPK;
    @Size(max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 2)
    @Column(name = "TIPO_PROFORMA")
    private String tipoProforma;
    @Size(max = 30)
    @Column(name = "NUM_PEDIDO")
    private String numPedido;
    @Size(max = 1000)
    @Column(name = "OBS_PROFORMA")
    private String obsProforma;
    @Size(max = 1000)
    @Column(name = "ESPEC_TECNICA")
    private String especTecnica;
    @Column(name = "VALIDEZ_DIAS")
    private Short validezDias;
    @Size(max = 50)
    @Column(name = "TIEMPO_ENTREGA")
    private String tiempoEntrega;
    @Size(max = 100)
    @Column(name = "CONTACTO")
    private String contacto;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "L_AUTORIZA")
    private Short lAutoriza;
    @Size(max = 100)
    @Column(name = "OBS_AUTORIZA")
    private String obsAutoriza;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 100)
    @Column(name = "OBS_MODIFICACION")
    private String obsModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CREADOR")
    private int idCreador;
    @Column(name = "ID_MODIFICADOR")
    private Integer idModificador;
    @Column(name = "ID_PERIODO_FAC")
    private Short idPeriodoFac;
    @Column(name = "ID_SUCURSAL_FAC")
    private Short idSucursalFac;
    @Column(name = "ID_FACTURA")
    private Long idFactura;
    @Column(name = "ID_AUTORIZADOR")
    private Integer idAutorizador;
    @Column(name = "FECHA_CONFIRMACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConfirmacion;
    @Column(name = "FECHA_VALIDEZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValidez;
    @Column(name = "FORMA_ENTREGA")
    private Short formaEntrega;
    @Column(name = "FORMA_PAGO")
    private Short formaPago;
    @Lob
    @Column(name = "COMPROBANTE_PAGO")
    private Serializable comprobantePago;
    @Column(name = "L_VENTA_ONLINE")
    private Short lVentaOnline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tproforma")
    private Collection<Tdetproforma> tdetproformaCollection;
    @JoinColumn(name = "ID_DIRECCION", referencedColumnName = "ID_DIRECCION")
    @ManyToOne(optional = false)
    private Tdireccionesusr idDireccion;
    @JoinColumn(name = "CIU", referencedColumnName = "CIU")
    @ManyToOne(optional = false)
    private Tentidad ciu;
    @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tsucursal tsucursal;

    public Tproforma() {
    }

    public Tproforma(TproformaPK tproformaPK) {
        this.tproformaPK = tproformaPK;
    }

    public Tproforma(TproformaPK tproformaPK, int idCreador) {
        this.tproformaPK = tproformaPK;
        this.idCreador = idCreador;
    }

    public Tproforma(long idSucursal, short idPeriodo, long idProforma) {
        this.tproformaPK = new TproformaPK(idSucursal, idPeriodo, idProforma);
    }

    public TproformaPK getTproformaPK() {
        return tproformaPK;
    }

    public void setTproformaPK(TproformaPK tproformaPK) {
        this.tproformaPK = tproformaPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoProforma() {
        return tipoProforma;
    }

    public void setTipoProforma(String tipoProforma) {
        this.tipoProforma = tipoProforma;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getObsProforma() {
        return obsProforma;
    }

    public void setObsProforma(String obsProforma) {
        this.obsProforma = obsProforma;
    }

    public String getEspecTecnica() {
        return especTecnica;
    }

    public void setEspecTecnica(String especTecnica) {
        this.especTecnica = especTecnica;
    }

    public Short getValidezDias() {
        return validezDias;
    }

    public void setValidezDias(Short validezDias) {
        this.validezDias = validezDias;
    }

    public String getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Short getLAutoriza() {
        return lAutoriza;
    }

    public void setLAutoriza(Short lAutoriza) {
        this.lAutoriza = lAutoriza;
    }

    public String getObsAutoriza() {
        return obsAutoriza;
    }

    public void setObsAutoriza(String obsAutoriza) {
        this.obsAutoriza = obsAutoriza;
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

    public String getObsModificacion() {
        return obsModificacion;
    }

    public void setObsModificacion(String obsModificacion) {
        this.obsModificacion = obsModificacion;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public Integer getIdModificador() {
        return idModificador;
    }

    public void setIdModificador(Integer idModificador) {
        this.idModificador = idModificador;
    }

    public Short getIdPeriodoFac() {
        return idPeriodoFac;
    }

    public void setIdPeriodoFac(Short idPeriodoFac) {
        this.idPeriodoFac = idPeriodoFac;
    }

    public Short getIdSucursalFac() {
        return idSucursalFac;
    }

    public void setIdSucursalFac(Short idSucursalFac) {
        this.idSucursalFac = idSucursalFac;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdAutorizador() {
        return idAutorizador;
    }

    public void setIdAutorizador(Integer idAutorizador) {
        this.idAutorizador = idAutorizador;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaValidez() {
        return fechaValidez;
    }

    public void setFechaValidez(Date fechaValidez) {
        this.fechaValidez = fechaValidez;
    }

    public Short getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(Short formaEntrega) {
        this.formaEntrega = formaEntrega;
    }

    public Short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Short formaPago) {
        this.formaPago = formaPago;
    }

    public Serializable getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(Serializable comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public Short getLVentaOnline() {
        return lVentaOnline;
    }

    public void setLVentaOnline(Short lVentaOnline) {
        this.lVentaOnline = lVentaOnline;
    }

    @XmlTransient
    public Collection<Tdetproforma> getTdetproformaCollection() {
        return tdetproformaCollection;
    }

    public void setTdetproformaCollection(Collection<Tdetproforma> tdetproformaCollection) {
        this.tdetproformaCollection = tdetproformaCollection;
    }

    public Tdireccionesusr getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Tdireccionesusr idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Tentidad getCiu() {
        return ciu;
    }

    public void setCiu(Tentidad ciu) {
        this.ciu = ciu;
    }

    public Tsucursal getTsucursal() {
        return tsucursal;
    }

    public void setTsucursal(Tsucursal tsucursal) {
        this.tsucursal = tsucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tproformaPK != null ? tproformaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tproforma)) {
            return false;
        }
        Tproforma other = (Tproforma) object;
        if ((this.tproformaPK == null && other.tproformaPK != null) || (this.tproformaPK != null && !this.tproformaPK.equals(other.tproformaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tproforma[ tproformaPK=" + tproformaPK + " ]";
    }
    
}
