/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TDETPROFORMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdetproforma.findAll", query = "SELECT t FROM Tdetproforma t"),
    @NamedQuery(name = "Tdetproforma.findByIdPeriodo", query = "SELECT t FROM Tdetproforma t WHERE t.tdetproformaPK.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Tdetproforma.findByIdSucursal", query = "SELECT t FROM Tdetproforma t WHERE t.tdetproformaPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "Tdetproforma.findByIdProforma", query = "SELECT t FROM Tdetproforma t WHERE t.tdetproformaPK.idProforma = :idProforma"),
    @NamedQuery(name = "Tdetproforma.findByNoReg", query = "SELECT t FROM Tdetproforma t WHERE t.tdetproformaPK.noReg = :noReg"),
    @NamedQuery(name = "Tdetproforma.findByDetalleItem", query = "SELECT t FROM Tdetproforma t WHERE t.detalleItem = :detalleItem"),
    @NamedQuery(name = "Tdetproforma.findByCantidad", query = "SELECT t FROM Tdetproforma t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "Tdetproforma.findByPvpTotal", query = "SELECT t FROM Tdetproforma t WHERE t.pvpTotal = :pvpTotal"),
    @NamedQuery(name = "Tdetproforma.findByFormato", query = "SELECT t FROM Tdetproforma t WHERE t.formato = :formato"),
    @NamedQuery(name = "Tdetproforma.findByTipoItem", query = "SELECT t FROM Tdetproforma t WHERE t.tipoItem = :tipoItem"),
    @NamedQuery(name = "Tdetproforma.findByIvaPorcentaje", query = "SELECT t FROM Tdetproforma t WHERE t.ivaPorcentaje = :ivaPorcentaje"),
    @NamedQuery(name = "Tdetproforma.findByDescuento", query = "SELECT t FROM Tdetproforma t WHERE t.descuento = :descuento"),
    @NamedQuery(name = "Tdetproforma.findByLAcepta", query = "SELECT t FROM Tdetproforma t WHERE t.lAcepta = :lAcepta"),
    @NamedQuery(name = "Tdetproforma.findByIdFactura", query = "SELECT t FROM Tdetproforma t WHERE t.idFactura = :idFactura"),
    @NamedQuery(name = "Tdetproforma.findByPeriodoFactura", query = "SELECT t FROM Tdetproforma t WHERE t.periodoFactura = :periodoFactura"),
    @NamedQuery(name = "Tdetproforma.findByPeriodocodigo", query = "SELECT t FROM Tdetproforma t WHERE t.periodocodigo = :periodocodigo"),
    @NamedQuery(name = "Tdetproforma.findByCodsec", query = "SELECT t FROM Tdetproforma t WHERE t.codsec = :codsec"),
    @NamedQuery(name = "Tdetproforma.findByIdCentroGestion", query = "SELECT t FROM Tdetproforma t WHERE t.idCentroGestion = :idCentroGestion"),
    @NamedQuery(name = "Tdetproforma.findByIdProyecto", query = "SELECT t FROM Tdetproforma t WHERE t.idProyecto = :idProyecto"),
    @NamedQuery(name = "Tdetproforma.findByIdFacturaAnterior", query = "SELECT t FROM Tdetproforma t WHERE t.idFacturaAnterior = :idFacturaAnterior"),
    @NamedQuery(name = "Tdetproforma.findByPeriodoFacturaAnterior", query = "SELECT t FROM Tdetproforma t WHERE t.periodoFacturaAnterior = :periodoFacturaAnterior"),
    @NamedQuery(name = "Tdetproforma.findByNumDesde", query = "SELECT t FROM Tdetproforma t WHERE t.numDesde = :numDesde"),
    @NamedQuery(name = "Tdetproforma.findByNumHasta", query = "SELECT t FROM Tdetproforma t WHERE t.numHasta = :numHasta"),
    @NamedQuery(name = "Tdetproforma.findByNumActual", query = "SELECT t FROM Tdetproforma t WHERE t.numActual = :numActual"),
    @NamedQuery(name = "Tdetproforma.findByObsLiberaProf", query = "SELECT t FROM Tdetproforma t WHERE t.obsLiberaProf = :obsLiberaProf"),
    @NamedQuery(name = "Tdetproforma.findByImpreso", query = "SELECT t FROM Tdetproforma t WHERE t.impreso = :impreso"),
    @NamedQuery(name = "Tdetproforma.findByDimension", query = "SELECT t FROM Tdetproforma t WHERE t.dimension = :dimension"),
    @NamedQuery(name = "Tdetproforma.findByFecimp", query = "SELECT t FROM Tdetproforma t WHERE t.fecimp = :fecimp")})
public class Tdetproforma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TdetproformaPK tdetproformaPK;
    @Size(max = 200)
    @Column(name = "DETALLE_ITEM")
    private String detalleItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "PVP_TOTAL")
    private BigDecimal pvpTotal;
    @Size(max = 20)
    @Column(name = "FORMATO")
    private String formato;
    @Size(max = 5)
    @Column(name = "TIPO_ITEM")
    private String tipoItem;
    @Column(name = "IVA_PORCENTAJE")
    private BigDecimal ivaPorcentaje;
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;
    @Column(name = "L_ACEPTA")
    private Short lAcepta;
    @Column(name = "ID_FACTURA")
    private BigInteger idFactura;
    @Column(name = "PERIODO_FACTURA")
    private BigInteger periodoFactura;
    @Column(name = "PERIODOCODIGO")
    private BigInteger periodocodigo;
    @Column(name = "CODSEC")
    private BigInteger codsec;
    @Column(name = "ID_CENTRO_GESTION")
    private Short idCentroGestion;
    @Column(name = "ID_PROYECTO")
    private Integer idProyecto;
    @Column(name = "ID_FACTURA_ANTERIOR")
    private BigInteger idFacturaAnterior;
    @Column(name = "PERIODO_FACTURA_ANTERIOR")
    private BigInteger periodoFacturaAnterior;
    @Column(name = "NUM_DESDE")
    private BigInteger numDesde;
    @Column(name = "NUM_HASTA")
    private BigInteger numHasta;
    @Column(name = "NUM_ACTUAL")
    private BigInteger numActual;
    @Size(max = 1000)
    @Column(name = "OBS_LIBERA_PROF")
    private String obsLiberaProf;
    @Column(name = "IMPRESO")
    private Short impreso;
    @Column(name = "DIMENSION")
    private BigDecimal dimension;
    @Column(name = "FECIMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecimp;
    @JoinColumn(name = "ID_ITEM", referencedColumnName = "ID_ITEM")
    @ManyToOne
    private Titem idItem;
    @JoinColumn(name = "ID_IVA", referencedColumnName = "ID_IVA")
    @ManyToOne
    private Tiva idIva;
    @JoinColumn(name = "ID_PLOTER", referencedColumnName = "ID_PLOTER")
    @ManyToOne
    private Tploters idPloter;
    @JoinColumns({
        @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO", insertable = false, updatable = false),
        @JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "ID_SUCURSAL", insertable = false, updatable = false),
        @JoinColumn(name = "ID_PROFORMA", referencedColumnName = "ID_PROFORMA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tproforma tproforma;
    @JoinColumn(name = "ID_TIPO_CARTA", referencedColumnName = "ID_TIPO_CARTA")
    @ManyToOne
    private Ttipocarta idTipoCarta;

    public Tdetproforma() {
    }

    public Tdetproforma(TdetproformaPK tdetproformaPK) {
        this.tdetproformaPK = tdetproformaPK;
    }

    public Tdetproforma(short idPeriodo, long idSucursal, long idProforma, short noReg) {
        this.tdetproformaPK = new TdetproformaPK(idPeriodo, idSucursal, idProforma, noReg);
    }

    public TdetproformaPK getTdetproformaPK() {
        return tdetproformaPK;
    }

    public void setTdetproformaPK(TdetproformaPK tdetproformaPK) {
        this.tdetproformaPK = tdetproformaPK;
    }

    public String getDetalleItem() {
        return detalleItem;
    }

    public void setDetalleItem(String detalleItem) {
        this.detalleItem = detalleItem;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPvpTotal() {
        return pvpTotal;
    }

    public void setPvpTotal(BigDecimal pvpTotal) {
        this.pvpTotal = pvpTotal;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public BigDecimal getIvaPorcentaje() {
        return ivaPorcentaje;
    }

    public void setIvaPorcentaje(BigDecimal ivaPorcentaje) {
        this.ivaPorcentaje = ivaPorcentaje;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Short getLAcepta() {
        return lAcepta;
    }

    public void setLAcepta(Short lAcepta) {
        this.lAcepta = lAcepta;
    }

    public BigInteger getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(BigInteger idFactura) {
        this.idFactura = idFactura;
    }

    public BigInteger getPeriodoFactura() {
        return periodoFactura;
    }

    public void setPeriodoFactura(BigInteger periodoFactura) {
        this.periodoFactura = periodoFactura;
    }

    public BigInteger getPeriodocodigo() {
        return periodocodigo;
    }

    public void setPeriodocodigo(BigInteger periodocodigo) {
        this.periodocodigo = periodocodigo;
    }

    public BigInteger getCodsec() {
        return codsec;
    }

    public void setCodsec(BigInteger codsec) {
        this.codsec = codsec;
    }

    public Short getIdCentroGestion() {
        return idCentroGestion;
    }

    public void setIdCentroGestion(Short idCentroGestion) {
        this.idCentroGestion = idCentroGestion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public BigInteger getIdFacturaAnterior() {
        return idFacturaAnterior;
    }

    public void setIdFacturaAnterior(BigInteger idFacturaAnterior) {
        this.idFacturaAnterior = idFacturaAnterior;
    }

    public BigInteger getPeriodoFacturaAnterior() {
        return periodoFacturaAnterior;
    }

    public void setPeriodoFacturaAnterior(BigInteger periodoFacturaAnterior) {
        this.periodoFacturaAnterior = periodoFacturaAnterior;
    }

    public BigInteger getNumDesde() {
        return numDesde;
    }

    public void setNumDesde(BigInteger numDesde) {
        this.numDesde = numDesde;
    }

    public BigInteger getNumHasta() {
        return numHasta;
    }

    public void setNumHasta(BigInteger numHasta) {
        this.numHasta = numHasta;
    }

    public BigInteger getNumActual() {
        return numActual;
    }

    public void setNumActual(BigInteger numActual) {
        this.numActual = numActual;
    }

    public String getObsLiberaProf() {
        return obsLiberaProf;
    }

    public void setObsLiberaProf(String obsLiberaProf) {
        this.obsLiberaProf = obsLiberaProf;
    }

    public Short getImpreso() {
        return impreso;
    }

    public void setImpreso(Short impreso) {
        this.impreso = impreso;
    }

    public BigDecimal getDimension() {
        return dimension;
    }

    public void setDimension(BigDecimal dimension) {
        this.dimension = dimension;
    }

    public Date getFecimp() {
        return fecimp;
    }

    public void setFecimp(Date fecimp) {
        this.fecimp = fecimp;
    }

    public Titem getIdItem() {
        return idItem;
    }

    public void setIdItem(Titem idItem) {
        this.idItem = idItem;
    }

    public Tiva getIdIva() {
        return idIva;
    }

    public void setIdIva(Tiva idIva) {
        this.idIva = idIva;
    }

    public Tploters getIdPloter() {
        return idPloter;
    }

    public void setIdPloter(Tploters idPloter) {
        this.idPloter = idPloter;
    }

    public Tproforma getTproforma() {
        return tproforma;
    }

    public void setTproforma(Tproforma tproforma) {
        this.tproforma = tproforma;
    }

    public Ttipocarta getIdTipoCarta() {
        return idTipoCarta;
    }

    public void setIdTipoCarta(Ttipocarta idTipoCarta) {
        this.idTipoCarta = idTipoCarta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdetproformaPK != null ? tdetproformaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tdetproforma)) {
            return false;
        }
        Tdetproforma other = (Tdetproforma) object;
        if ((this.tdetproformaPK == null && other.tdetproformaPK != null) || (this.tdetproformaPK != null && !this.tdetproformaPK.equals(other.tdetproformaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tdetproforma[ tdetproformaPK=" + tdetproformaPK + " ]";
    }
    
}
