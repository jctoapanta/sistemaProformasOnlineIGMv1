/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "T_CONTRATACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TContrataciones.findAll", query = "SELECT t FROM TContrataciones t")
    , @NamedQuery(name = "TContrataciones.findByNoPersona", query = "SELECT t FROM TContrataciones t WHERE t.tContratacionesPK.noPersona = :noPersona")
    , @NamedQuery(name = "TContrataciones.findByNoCont", query = "SELECT t FROM TContrataciones t WHERE t.tContratacionesPK.noCont = :noCont")
    , @NamedQuery(name = "TContrataciones.findByNoDoc", query = "SELECT t FROM TContrataciones t WHERE t.noDoc = :noDoc")
    , @NamedQuery(name = "TContrataciones.findByResponsable", query = "SELECT t FROM TContrataciones t WHERE t.responsable = :responsable")
    , @NamedQuery(name = "TContrataciones.findByNivel", query = "SELECT t FROM TContrataciones t WHERE t.nivel = :nivel")
    , @NamedQuery(name = "TContrataciones.findByCategoria", query = "SELECT t FROM TContrataciones t WHERE t.categoria = :categoria")
    , @NamedQuery(name = "TContrataciones.findByNoEmp", query = "SELECT t FROM TContrataciones t WHERE t.noEmp = :noEmp")
    , @NamedQuery(name = "TContrataciones.findByFContrato", query = "SELECT t FROM TContrataciones t WHERE t.fContrato = :fContrato")
    , @NamedQuery(name = "TContrataciones.findByFSalida", query = "SELECT t FROM TContrataciones t WHERE t.fSalida = :fSalida")
    , @NamedQuery(name = "TContrataciones.findByTSalida", query = "SELECT t FROM TContrataciones t WHERE t.tSalida = :tSalida")
    , @NamedQuery(name = "TContrataciones.findByEstado", query = "SELECT t FROM TContrataciones t WHERE t.estado = :estado")
    , @NamedQuery(name = "TContrataciones.findByCMoneda", query = "SELECT t FROM TContrataciones t WHERE t.cMoneda = :cMoneda")
    , @NamedQuery(name = "TContrataciones.findByVSueldoImponible", query = "SELECT t FROM TContrataciones t WHERE t.vSueldoImponible = :vSueldoImponible")
    , @NamedQuery(name = "TContrataciones.findByCostoHora", query = "SELECT t FROM TContrataciones t WHERE t.costoHora = :costoHora")
    , @NamedQuery(name = "TContrataciones.findByCostoHoraExtra", query = "SELECT t FROM TContrataciones t WHERE t.costoHoraExtra = :costoHoraExtra")
    , @NamedQuery(name = "TContrataciones.findByNoBanco", query = "SELECT t FROM TContrataciones t WHERE t.noBanco = :noBanco")
    , @NamedQuery(name = "TContrataciones.findByNoCta", query = "SELECT t FROM TContrataciones t WHERE t.noCta = :noCta")
    , @NamedQuery(name = "TContrataciones.findByLLicencia", query = "SELECT t FROM TContrataciones t WHERE t.lLicencia = :lLicencia")
    , @NamedQuery(name = "TContrataciones.findByDiasLicencia", query = "SELECT t FROM TContrataciones t WHERE t.diasLicencia = :diasLicencia")
    , @NamedQuery(name = "TContrataciones.findByDiasUtilizados", query = "SELECT t FROM TContrataciones t WHERE t.diasUtilizados = :diasUtilizados")
    , @NamedQuery(name = "TContrataciones.findByHoraIngreso", query = "SELECT t FROM TContrataciones t WHERE t.horaIngreso = :horaIngreso")
    , @NamedQuery(name = "TContrataciones.findByHoraSalida", query = "SELECT t FROM TContrataciones t WHERE t.horaSalida = :horaSalida")
    , @NamedQuery(name = "TContrataciones.findByLGeneraRol", query = "SELECT t FROM TContrataciones t WHERE t.lGeneraRol = :lGeneraRol")
    , @NamedQuery(name = "TContrataciones.findByObs", query = "SELECT t FROM TContrataciones t WHERE t.obs = :obs")
    , @NamedQuery(name = "TContrataciones.findByNoEmpPre", query = "SELECT t FROM TContrataciones t WHERE t.noEmpPre = :noEmpPre")
    , @NamedQuery(name = "TContrataciones.findByNoCdPre", query = "SELECT t FROM TContrataciones t WHERE t.noCdPre = :noCdPre")
    , @NamedQuery(name = "TContrataciones.findByNoCargo", query = "SELECT t FROM TContrataciones t WHERE t.noCargo = :noCargo")
    , @NamedQuery(name = "TContrataciones.findByVSueldoImponibleSuc", query = "SELECT t FROM TContrataciones t WHERE t.vSueldoImponibleSuc = :vSueldoImponibleSuc")
    , @NamedQuery(name = "TContrataciones.findByCostoHoraSuc", query = "SELECT t FROM TContrataciones t WHERE t.costoHoraSuc = :costoHoraSuc")
    , @NamedQuery(name = "TContrataciones.findByCostoHoraExtraSuc", query = "SELECT t FROM TContrataciones t WHERE t.costoHoraExtraSuc = :costoHoraExtraSuc")
    , @NamedQuery(name = "TContrataciones.findByManoObra", query = "SELECT t FROM TContrataciones t WHERE t.manoObra = :manoObra")
    , @NamedQuery(name = "TContrataciones.findByProyectoCodigo", query = "SELECT t FROM TContrataciones t WHERE t.proyectoCodigo = :proyectoCodigo")
    , @NamedQuery(name = "TContrataciones.findByTipoViatico", query = "SELECT t FROM TContrataciones t WHERE t.tipoViatico = :tipoViatico")
    , @NamedQuery(name = "TContrataciones.findByNoCdPreAnt", query = "SELECT t FROM TContrataciones t WHERE t.noCdPreAnt = :noCdPreAnt")
    , @NamedQuery(name = "TContrataciones.findByNivelAprobacion", query = "SELECT t FROM TContrataciones t WHERE t.nivelAprobacion = :nivelAprobacion")
    , @NamedQuery(name = "TContrataciones.findByRmu", query = "SELECT t FROM TContrataciones t WHERE t.rmu = :rmu")})
public class TContrataciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TContratacionesPK tContratacionesPK;
    @Size(max = 10)
    @Column(name = "NO_DOC")
    private String noDoc;
    @Size(max = 50)
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Size(max = 2)
    @Column(name = "NIVEL")
    private String nivel;
    @Size(max = 2)
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "NO_EMP")
    private Short noEmp;
    @Column(name = "F_CONTRATO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fContrato;
    @Column(name = "F_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fSalida;
    @Size(max = 1)
    @Column(name = "T_SALIDA")
    private String tSalida;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "C_MONEDA")
    private Short cMoneda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "V_SUELDO_IMPONIBLE")
    private BigDecimal vSueldoImponible;
    @Column(name = "COSTO_HORA")
    private BigDecimal costoHora;
    @Column(name = "COSTO_HORA_EXTRA")
    private BigDecimal costoHoraExtra;
    @Column(name = "NO_BANCO")
    private Short noBanco;
    @Size(max = 15)
    @Column(name = "NO_CTA")
    private String noCta;
    @Column(name = "L_LICENCIA")
    private Short lLicencia;
    @Column(name = "DIAS_LICENCIA")
    private Short diasLicencia;
    @Column(name = "DIAS_UTILIZADOS")
    private Short diasUtilizados;
    @Column(name = "HORA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaIngreso;
    @Column(name = "HORA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSalida;
    @Column(name = "L_GENERA_ROL")
    private Short lGeneraRol;
    @Size(max = 250)
    @Column(name = "OBS")
    private String obs;
    @Column(name = "NO_EMP_PRE")
    private Short noEmpPre;
    @Column(name = "NO_CD_PRE")
    private Short noCdPre;
    @Column(name = "NO_CARGO")
    private Short noCargo;
    @Column(name = "V_SUELDO_IMPONIBLE_SUC")
    private BigDecimal vSueldoImponibleSuc;
    @Column(name = "COSTO_HORA_SUC")
    private BigDecimal costoHoraSuc;
    @Column(name = "COSTO_HORA_EXTRA_SUC")
    private BigDecimal costoHoraExtraSuc;
    @Size(max = 1)
    @Column(name = "MANO_OBRA")
    private String manoObra;
    @Column(name = "PROYECTO_CODIGO")
    private Short proyectoCodigo;
    @Size(max = 1)
    @Column(name = "TIPO_VIATICO")
    private String tipoViatico;
    @Column(name = "NO_CD_PRE_ANT")
    private Short noCdPreAnt;
    @Column(name = "NIVEL_APROBACION")
    private Short nivelAprobacion;
    @Column(name = "RMU")
    private BigDecimal rmu;
    @JoinColumns({
        @JoinColumn(name = "NO_CD", referencedColumnName = "NO_CD")
        , @JoinColumn(name = "NO_EMP_MATRIZ", referencedColumnName = "NO_EMP_MATRIZ")})
    @ManyToOne
    private TAreas tAreas;
    @JoinColumn(name = "NO_PERSONA", referencedColumnName = "NO_PERSONA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TDatEmpleado tDatEmpleado;
    @JoinColumn(name = "NO_FUNCION", referencedColumnName = "NO_FUNCION")
    @ManyToOne
    private TFuncion noFuncion;
    @JoinColumn(name = "C_CONTRATO", referencedColumnName = "C_CONTRATO")
    @ManyToOne
    private TTiposContrato cContrato;

    public TContrataciones() {
    }

    public TContrataciones(TContratacionesPK tContratacionesPK) {
        this.tContratacionesPK = tContratacionesPK;
    }

    public TContrataciones(int noPersona, int noCont) {
        this.tContratacionesPK = new TContratacionesPK(noPersona, noCont);
    }

    public TContratacionesPK getTContratacionesPK() {
        return tContratacionesPK;
    }

    public void setTContratacionesPK(TContratacionesPK tContratacionesPK) {
        this.tContratacionesPK = tContratacionesPK;
    }

    public String getNoDoc() {
        return noDoc;
    }

    public void setNoDoc(String noDoc) {
        this.noDoc = noDoc;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Short getNoEmp() {
        return noEmp;
    }

    public void setNoEmp(Short noEmp) {
        this.noEmp = noEmp;
    }

    public Date getFContrato() {
        return fContrato;
    }

    public void setFContrato(Date fContrato) {
        this.fContrato = fContrato;
    }

    public Date getFSalida() {
        return fSalida;
    }

    public void setFSalida(Date fSalida) {
        this.fSalida = fSalida;
    }

    public String getTSalida() {
        return tSalida;
    }

    public void setTSalida(String tSalida) {
        this.tSalida = tSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Short getCMoneda() {
        return cMoneda;
    }

    public void setCMoneda(Short cMoneda) {
        this.cMoneda = cMoneda;
    }

    public BigDecimal getVSueldoImponible() {
        return vSueldoImponible;
    }

    public void setVSueldoImponible(BigDecimal vSueldoImponible) {
        this.vSueldoImponible = vSueldoImponible;
    }

    public BigDecimal getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(BigDecimal costoHora) {
        this.costoHora = costoHora;
    }

    public BigDecimal getCostoHoraExtra() {
        return costoHoraExtra;
    }

    public void setCostoHoraExtra(BigDecimal costoHoraExtra) {
        this.costoHoraExtra = costoHoraExtra;
    }

    public Short getNoBanco() {
        return noBanco;
    }

    public void setNoBanco(Short noBanco) {
        this.noBanco = noBanco;
    }

    public String getNoCta() {
        return noCta;
    }

    public void setNoCta(String noCta) {
        this.noCta = noCta;
    }

    public Short getLLicencia() {
        return lLicencia;
    }

    public void setLLicencia(Short lLicencia) {
        this.lLicencia = lLicencia;
    }

    public Short getDiasLicencia() {
        return diasLicencia;
    }

    public void setDiasLicencia(Short diasLicencia) {
        this.diasLicencia = diasLicencia;
    }

    public Short getDiasUtilizados() {
        return diasUtilizados;
    }

    public void setDiasUtilizados(Short diasUtilizados) {
        this.diasUtilizados = diasUtilizados;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Short getLGeneraRol() {
        return lGeneraRol;
    }

    public void setLGeneraRol(Short lGeneraRol) {
        this.lGeneraRol = lGeneraRol;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Short getNoEmpPre() {
        return noEmpPre;
    }

    public void setNoEmpPre(Short noEmpPre) {
        this.noEmpPre = noEmpPre;
    }

    public Short getNoCdPre() {
        return noCdPre;
    }

    public void setNoCdPre(Short noCdPre) {
        this.noCdPre = noCdPre;
    }

    public Short getNoCargo() {
        return noCargo;
    }

    public void setNoCargo(Short noCargo) {
        this.noCargo = noCargo;
    }

    public BigDecimal getVSueldoImponibleSuc() {
        return vSueldoImponibleSuc;
    }

    public void setVSueldoImponibleSuc(BigDecimal vSueldoImponibleSuc) {
        this.vSueldoImponibleSuc = vSueldoImponibleSuc;
    }

    public BigDecimal getCostoHoraSuc() {
        return costoHoraSuc;
    }

    public void setCostoHoraSuc(BigDecimal costoHoraSuc) {
        this.costoHoraSuc = costoHoraSuc;
    }

    public BigDecimal getCostoHoraExtraSuc() {
        return costoHoraExtraSuc;
    }

    public void setCostoHoraExtraSuc(BigDecimal costoHoraExtraSuc) {
        this.costoHoraExtraSuc = costoHoraExtraSuc;
    }

    public String getManoObra() {
        return manoObra;
    }

    public void setManoObra(String manoObra) {
        this.manoObra = manoObra;
    }

    public Short getProyectoCodigo() {
        return proyectoCodigo;
    }

    public void setProyectoCodigo(Short proyectoCodigo) {
        this.proyectoCodigo = proyectoCodigo;
    }

    public String getTipoViatico() {
        return tipoViatico;
    }

    public void setTipoViatico(String tipoViatico) {
        this.tipoViatico = tipoViatico;
    }

    public Short getNoCdPreAnt() {
        return noCdPreAnt;
    }

    public void setNoCdPreAnt(Short noCdPreAnt) {
        this.noCdPreAnt = noCdPreAnt;
    }

    public Short getNivelAprobacion() {
        return nivelAprobacion;
    }

    public void setNivelAprobacion(Short nivelAprobacion) {
        this.nivelAprobacion = nivelAprobacion;
    }

    public BigDecimal getRmu() {
        return rmu;
    }

    public void setRmu(BigDecimal rmu) {
        this.rmu = rmu;
    }

    public TAreas getTAreas() {
        return tAreas;
    }

    public void setTAreas(TAreas tAreas) {
        this.tAreas = tAreas;
    }

    public TDatEmpleado getTDatEmpleado() {
        return tDatEmpleado;
    }

    public void setTDatEmpleado(TDatEmpleado tDatEmpleado) {
        this.tDatEmpleado = tDatEmpleado;
    }

    public TFuncion getNoFuncion() {
        return noFuncion;
    }

    public void setNoFuncion(TFuncion noFuncion) {
        this.noFuncion = noFuncion;
    }

    public TTiposContrato getCContrato() {
        return cContrato;
    }

    public void setCContrato(TTiposContrato cContrato) {
        this.cContrato = cContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tContratacionesPK != null ? tContratacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TContrataciones)) {
            return false;
        }
        TContrataciones other = (TContrataciones) object;
        if ((this.tContratacionesPK == null && other.tContratacionesPK != null) || (this.tContratacionesPK != null && !this.tContratacionesPK.equals(other.tContratacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TContrataciones[ tContratacionesPK=" + tContratacionesPK + " ]";
    }
    
}
