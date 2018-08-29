/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "T_DAT_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDatEmpleado.findAll", query = "SELECT t FROM TDatEmpleado t")
    , @NamedQuery(name = "TDatEmpleado.findByNoPersona", query = "SELECT t FROM TDatEmpleado t WHERE t.noPersona = :noPersona")
    , @NamedQuery(name = "TDatEmpleado.findByNoProveedor", query = "SELECT t FROM TDatEmpleado t WHERE t.noProveedor = :noProveedor")
    , @NamedQuery(name = "TDatEmpleado.findByCodigo", query = "SELECT t FROM TDatEmpleado t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TDatEmpleado.findByNoCedula", query = "SELECT t FROM TDatEmpleado t WHERE t.noCedula = :noCedula")
    , @NamedQuery(name = "TDatEmpleado.findByPriApellido", query = "SELECT t FROM TDatEmpleado t WHERE t.priApellido = :priApellido")
    , @NamedQuery(name = "TDatEmpleado.findBySegApellido", query = "SELECT t FROM TDatEmpleado t WHERE t.segApellido = :segApellido")
    , @NamedQuery(name = "TDatEmpleado.findByNombres", query = "SELECT t FROM TDatEmpleado t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "TDatEmpleado.findByNombreC", query = "SELECT t FROM TDatEmpleado t WHERE t.nombreC = :nombreC")
    , @NamedQuery(name = "TDatEmpleado.findByLibMilitar", query = "SELECT t FROM TDatEmpleado t WHERE t.libMilitar = :libMilitar")
    , @NamedQuery(name = "TDatEmpleado.findBySeguroSocial", query = "SELECT t FROM TDatEmpleado t WHERE t.seguroSocial = :seguroSocial")
    , @NamedQuery(name = "TDatEmpleado.findBySexo", query = "SELECT t FROM TDatEmpleado t WHERE t.sexo = :sexo")
    , @NamedQuery(name = "TDatEmpleado.findByEstCivil", query = "SELECT t FROM TDatEmpleado t WHERE t.estCivil = :estCivil")
    , @NamedQuery(name = "TDatEmpleado.findByGSangre", query = "SELECT t FROM TDatEmpleado t WHERE t.gSangre = :gSangre")
    , @NamedQuery(name = "TDatEmpleado.findByFNacimiento", query = "SELECT t FROM TDatEmpleado t WHERE t.fNacimiento = :fNacimiento")
    , @NamedQuery(name = "TDatEmpleado.findByFMuerte", query = "SELECT t FROM TDatEmpleado t WHERE t.fMuerte = :fMuerte")
    , @NamedQuery(name = "TDatEmpleado.findByDireccion", query = "SELECT t FROM TDatEmpleado t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TDatEmpleado.findByTelefono", query = "SELECT t FROM TDatEmpleado t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TDatEmpleado.findByTipo", query = "SELECT t FROM TDatEmpleado t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TDatEmpleado.findByFoto", query = "SELECT t FROM TDatEmpleado t WHERE t.foto = :foto")
    , @NamedQuery(name = "TDatEmpleado.findByColorPiel", query = "SELECT t FROM TDatEmpleado t WHERE t.colorPiel = :colorPiel")
    , @NamedQuery(name = "TDatEmpleado.findByColorCabello", query = "SELECT t FROM TDatEmpleado t WHERE t.colorCabello = :colorCabello")
    , @NamedQuery(name = "TDatEmpleado.findByColorOjos", query = "SELECT t FROM TDatEmpleado t WHERE t.colorOjos = :colorOjos")
    , @NamedQuery(name = "TDatEmpleado.findByEstatura", query = "SELECT t FROM TDatEmpleado t WHERE t.estatura = :estatura")
    , @NamedQuery(name = "TDatEmpleado.findByPeso", query = "SELECT t FROM TDatEmpleado t WHERE t.peso = :peso")
    , @NamedQuery(name = "TDatEmpleado.findByTallaCamisa", query = "SELECT t FROM TDatEmpleado t WHERE t.tallaCamisa = :tallaCamisa")
    , @NamedQuery(name = "TDatEmpleado.findByTallaPantalon", query = "SELECT t FROM TDatEmpleado t WHERE t.tallaPantalon = :tallaPantalon")
    , @NamedQuery(name = "TDatEmpleado.findByNoCalzado", query = "SELECT t FROM TDatEmpleado t WHERE t.noCalzado = :noCalzado")
    , @NamedQuery(name = "TDatEmpleado.findByFIngreso", query = "SELECT t FROM TDatEmpleado t WHERE t.fIngreso = :fIngreso")
    , @NamedQuery(name = "TDatEmpleado.findByTelefono2", query = "SELECT t FROM TDatEmpleado t WHERE t.telefono2 = :telefono2")
    , @NamedQuery(name = "TDatEmpleado.findByLVivPropia", query = "SELECT t FROM TDatEmpleado t WHERE t.lVivPropia = :lVivPropia")
    , @NamedQuery(name = "TDatEmpleado.findByAlergia", query = "SELECT t FROM TDatEmpleado t WHERE t.alergia = :alergia")
    , @NamedQuery(name = "TDatEmpleado.findByNoLocNace", query = "SELECT t FROM TDatEmpleado t WHERE t.noLocNace = :noLocNace")
    , @NamedQuery(name = "TDatEmpleado.findByNoLocDir", query = "SELECT t FROM TDatEmpleado t WHERE t.noLocDir = :noLocDir")
    , @NamedQuery(name = "TDatEmpleado.findByNoCabeza", query = "SELECT t FROM TDatEmpleado t WHERE t.noCabeza = :noCabeza")
    , @NamedQuery(name = "TDatEmpleado.findByLUsaLentes", query = "SELECT t FROM TDatEmpleado t WHERE t.lUsaLentes = :lUsaLentes")
    , @NamedQuery(name = "TDatEmpleado.findByComisariato", query = "SELECT t FROM TDatEmpleado t WHERE t.comisariato = :comisariato")
    , @NamedQuery(name = "TDatEmpleado.findByFReingreso", query = "SELECT t FROM TDatEmpleado t WHERE t.fReingreso = :fReingreso")
    , @NamedQuery(name = "TDatEmpleado.findByAliasBaseDatos", query = "SELECT t FROM TDatEmpleado t WHERE t.aliasBaseDatos = :aliasBaseDatos")
    , @NamedQuery(name = "TDatEmpleado.findByPieFirma", query = "SELECT t FROM TDatEmpleado t WHERE t.pieFirma = :pieFirma")
    , @NamedQuery(name = "TDatEmpleado.findByNoDirec", query = "SELECT t FROM TDatEmpleado t WHERE t.noDirec = :noDirec")
    , @NamedQuery(name = "TDatEmpleado.findByNivel", query = "SELECT t FROM TDatEmpleado t WHERE t.nivel = :nivel")
    , @NamedQuery(name = "TDatEmpleado.findByCargoLossca", query = "SELECT t FROM TDatEmpleado t WHERE t.cargoLossca = :cargoLossca")
    , @NamedQuery(name = "TDatEmpleado.findByPatronal", query = "SELECT t FROM TDatEmpleado t WHERE t.patronal = :patronal")
    , @NamedQuery(name = "TDatEmpleado.findByPersonal", query = "SELECT t FROM TDatEmpleado t WHERE t.personal = :personal")
    , @NamedQuery(name = "TDatEmpleado.findByIece", query = "SELECT t FROM TDatEmpleado t WHERE t.iece = :iece")
    , @NamedQuery(name = "TDatEmpleado.findByProceso", query = "SELECT t FROM TDatEmpleado t WHERE t.proceso = :proceso")
    , @NamedQuery(name = "TDatEmpleado.findBySubproceso", query = "SELECT t FROM TDatEmpleado t WHERE t.subproceso = :subproceso")
    , @NamedQuery(name = "TDatEmpleado.findByPartidaPresupuestaria", query = "SELECT t FROM TDatEmpleado t WHERE t.partidaPresupuestaria = :partidaPresupuestaria")
    , @NamedQuery(name = "TDatEmpleado.findByGestion", query = "SELECT t FROM TDatEmpleado t WHERE t.gestion = :gestion")
    , @NamedQuery(name = "TDatEmpleado.findByUnidad", query = "SELECT t FROM TDatEmpleado t WHERE t.unidad = :unidad")
    , @NamedQuery(name = "TDatEmpleado.findByEmail", query = "SELECT t FROM TDatEmpleado t WHERE t.email = :email")
    , @NamedQuery(name = "TDatEmpleado.findByLDiscapacidad", query = "SELECT t FROM TDatEmpleado t WHERE t.lDiscapacidad = :lDiscapacidad")
    , @NamedQuery(name = "TDatEmpleado.findByNoConadis", query = "SELECT t FROM TDatEmpleado t WHERE t.noConadis = :noConadis")
    , @NamedQuery(name = "TDatEmpleado.findByAutoidentificacionEtnica", query = "SELECT t FROM TDatEmpleado t WHERE t.autoidentificacionEtnica = :autoidentificacionEtnica")
    , @NamedQuery(name = "TDatEmpleado.findByNacionalidadIndigena", query = "SELECT t FROM TDatEmpleado t WHERE t.nacionalidadIndigena = :nacionalidadIndigena")
    , @NamedQuery(name = "TDatEmpleado.findByLCatastrofica", query = "SELECT t FROM TDatEmpleado t WHERE t.lCatastrofica = :lCatastrofica")
    , @NamedQuery(name = "TDatEmpleado.findByNoConadisCatastrofica", query = "SELECT t FROM TDatEmpleado t WHERE t.noConadisCatastrofica = :noConadisCatastrofica")
    , @NamedQuery(name = "TDatEmpleado.findByCalleSecundaria", query = "SELECT t FROM TDatEmpleado t WHERE t.calleSecundaria = :calleSecundaria")
    , @NamedQuery(name = "TDatEmpleado.findByReferencia", query = "SELECT t FROM TDatEmpleado t WHERE t.referencia = :referencia")
    , @NamedQuery(name = "TDatEmpleado.findByExtension", query = "SELECT t FROM TDatEmpleado t WHERE t.extension = :extension")
    , @NamedQuery(name = "TDatEmpleado.findByContactoApellidos", query = "SELECT t FROM TDatEmpleado t WHERE t.contactoApellidos = :contactoApellidos")
    , @NamedQuery(name = "TDatEmpleado.findByContactoNombres", query = "SELECT t FROM TDatEmpleado t WHERE t.contactoNombres = :contactoNombres")
    , @NamedQuery(name = "TDatEmpleado.findByContactoTelefono", query = "SELECT t FROM TDatEmpleado t WHERE t.contactoTelefono = :contactoTelefono")
    , @NamedQuery(name = "TDatEmpleado.findByContactoCelular", query = "SELECT t FROM TDatEmpleado t WHERE t.contactoCelular = :contactoCelular")
    , @NamedQuery(name = "TDatEmpleado.findByEmailInstitucional", query = "SELECT t FROM TDatEmpleado t WHERE t.emailInstitucional = :emailInstitucional")})
public class TDatEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_PERSONA")
    private Integer noPersona;
    @Column(name = "NO_PROVEEDOR")
    private Long noProveedor;
    @Size(max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 10)
    @Column(name = "NO_CEDULA")
    private String noCedula;
    @Size(max = 20)
    @Column(name = "PRI_APELLIDO")
    private String priApellido;
    @Size(max = 20)
    @Column(name = "SEG_APELLIDO")
    private String segApellido;
    @Size(max = 40)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 81)
    @Column(name = "NOMBRE_C")
    private String nombreC;
    @Size(max = 15)
    @Column(name = "LIB_MILITAR")
    private String libMilitar;
    @Size(max = 15)
    @Column(name = "SEGURO_SOCIAL")
    private String seguroSocial;
    @Size(max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 1)
    @Column(name = "EST_CIVIL")
    private String estCivil;
    @Size(max = 3)
    @Column(name = "G_SANGRE")
    private String gSangre;
    @Column(name = "F_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fNacimiento;
    @Column(name = "F_MUERTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fMuerte;
    @Size(max = 200)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 16)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 50)
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 1)
    @Column(name = "COLOR_PIEL")
    private String colorPiel;
    @Size(max = 1)
    @Column(name = "COLOR_CABELLO")
    private String colorCabello;
    @Size(max = 1)
    @Column(name = "COLOR_OJOS")
    private String colorOjos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTATURA")
    private BigDecimal estatura;
    @Column(name = "PESO")
    private BigDecimal peso;
    @Column(name = "TALLA_CAMISA")
    private BigDecimal tallaCamisa;
    @Column(name = "TALLA_PANTALON")
    private BigDecimal tallaPantalon;
    @Column(name = "NO_CALZADO")
    private Short noCalzado;
    @Column(name = "F_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fIngreso;
    @Size(max = 16)
    @Column(name = "TELEFONO2")
    private String telefono2;
    @Column(name = "L_VIV_PROPIA")
    private Short lVivPropia;
    @Size(max = 100)
    @Column(name = "ALERGIA")
    private String alergia;
    @Column(name = "NO_LOC_NACE")
    private Integer noLocNace;
    @Column(name = "NO_LOC_DIR")
    private Integer noLocDir;
    @Column(name = "NO_CABEZA")
    private BigDecimal noCabeza;
    @Column(name = "L_USA_LENTES")
    private Short lUsaLentes;
    @Size(max = 1)
    @Column(name = "COMISARIATO")
    private String comisariato;
    @Column(name = "F_REINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fReingreso;
    @Size(max = 30)
    @Column(name = "ALIAS_BASE_DATOS")
    private String aliasBaseDatos;
    @Size(max = 50)
    @Column(name = "PIE_FIRMA")
    private String pieFirma;
    @Size(max = 10)
    @Column(name = "NO_DIREC")
    private String noDirec;
    @Column(name = "NIVEL")
    private Short nivel;
    @Size(max = 50)
    @Column(name = "CARGO_LOSSCA")
    private String cargoLossca;
    @Column(name = "PATRONAL")
    private BigDecimal patronal;
    @Column(name = "PERSONAL")
    private BigDecimal personal;
    @Column(name = "IECE")
    private BigDecimal iece;
    @Size(max = 100)
    @Column(name = "PROCESO")
    private String proceso;
    @Size(max = 100)
    @Column(name = "SUBPROCESO")
    private String subproceso;
    @Size(max = 60)
    @Column(name = "PARTIDA_PRESUPUESTARIA")
    private String partidaPresupuestaria;
    @Size(max = 100)
    @Column(name = "GESTION")
    private String gestion;
    @Size(max = 100)
    @Column(name = "UNIDAD")
    private String unidad;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "L_DISCAPACIDAD")
    private Short lDiscapacidad;
    @Size(max = 10)
    @Column(name = "NO_CONADIS")
    private String noConadis;
    @Size(max = 35)
    @Column(name = "AUTOIDENTIFICACION_ETNICA")
    private String autoidentificacionEtnica;
    @Size(max = 10)
    @Column(name = "NACIONALIDAD_INDIGENA")
    private String nacionalidadIndigena;
    @Column(name = "L_CATASTROFICA")
    private Short lCatastrofica;
    @Size(max = 10)
    @Column(name = "NO_CONADIS_CATASTROFICA")
    private String noConadisCatastrofica;
    @Size(max = 100)
    @Column(name = "CALLE_SECUNDARIA")
    private String calleSecundaria;
    @Size(max = 200)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 50)
    @Column(name = "CONTACTO_APELLIDOS")
    private String contactoApellidos;
    @Size(max = 50)
    @Column(name = "CONTACTO_NOMBRES")
    private String contactoNombres;
    @Size(max = 20)
    @Column(name = "CONTACTO_TELEFONO")
    private String contactoTelefono;
    @Size(max = 10)
    @Column(name = "CONTACTO_CELULAR")
    private String contactoCelular;
    @Size(max = 40)
    @Column(name = "EMAIL_INSTITUCIONAL")
    private String emailInstitucional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tDatEmpleado")
    private List<TContrataciones> tContratacionesList;
    @JoinColumn(name = "NO_LICENCIA", referencedColumnName = "NO_LICENCIA")
    @ManyToOne
    private TLicencia noLicencia;
    @JoinColumn(name = "ID_NACIONALIDAD", referencedColumnName = "ID_NACIONALIDAD")
    @ManyToOne
    private TNacionalidad idNacionalidad;
    @JoinColumn(name = "NO_PROFESION", referencedColumnName = "NO_PROFESION")
    @ManyToOne
    private TProfesiones noProfesion;
    @JoinColumn(name = "NO_RELIG", referencedColumnName = "NO_RELIG")
    @ManyToOne
    private TRhReligion noRelig;
    @JoinColumn(name = "NO_SEG", referencedColumnName = "NO_SEG")
    @ManyToOne
    private TRhTipoSegSocial noSeg;

    public TDatEmpleado() {
    }

    public TDatEmpleado(Integer noPersona) {
        this.noPersona = noPersona;
    }

    public Integer getNoPersona() {
        return noPersona;
    }

    public void setNoPersona(Integer noPersona) {
        this.noPersona = noPersona;
    }

    public Long getNoProveedor() {
        return noProveedor;
    }

    public void setNoProveedor(Long noProveedor) {
        this.noProveedor = noProveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNoCedula() {
        return noCedula;
    }

    public void setNoCedula(String noCedula) {
        this.noCedula = noCedula;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getLibMilitar() {
        return libMilitar;
    }

    public void setLibMilitar(String libMilitar) {
        this.libMilitar = libMilitar;
    }

    public String getSeguroSocial() {
        return seguroSocial;
    }

    public void setSeguroSocial(String seguroSocial) {
        this.seguroSocial = seguroSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getGSangre() {
        return gSangre;
    }

    public void setGSangre(String gSangre) {
        this.gSangre = gSangre;
    }

    public Date getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public Date getFMuerte() {
        return fMuerte;
    }

    public void setFMuerte(Date fMuerte) {
        this.fMuerte = fMuerte;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public void setColorPiel(String colorPiel) {
        this.colorPiel = colorPiel;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public BigDecimal getEstatura() {
        return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
        this.estatura = estatura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTallaCamisa() {
        return tallaCamisa;
    }

    public void setTallaCamisa(BigDecimal tallaCamisa) {
        this.tallaCamisa = tallaCamisa;
    }

    public BigDecimal getTallaPantalon() {
        return tallaPantalon;
    }

    public void setTallaPantalon(BigDecimal tallaPantalon) {
        this.tallaPantalon = tallaPantalon;
    }

    public Short getNoCalzado() {
        return noCalzado;
    }

    public void setNoCalzado(Short noCalzado) {
        this.noCalzado = noCalzado;
    }

    public Date getFIngreso() {
        return fIngreso;
    }

    public void setFIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Short getLVivPropia() {
        return lVivPropia;
    }

    public void setLVivPropia(Short lVivPropia) {
        this.lVivPropia = lVivPropia;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public Integer getNoLocNace() {
        return noLocNace;
    }

    public void setNoLocNace(Integer noLocNace) {
        this.noLocNace = noLocNace;
    }

    public Integer getNoLocDir() {
        return noLocDir;
    }

    public void setNoLocDir(Integer noLocDir) {
        this.noLocDir = noLocDir;
    }

    public BigDecimal getNoCabeza() {
        return noCabeza;
    }

    public void setNoCabeza(BigDecimal noCabeza) {
        this.noCabeza = noCabeza;
    }

    public Short getLUsaLentes() {
        return lUsaLentes;
    }

    public void setLUsaLentes(Short lUsaLentes) {
        this.lUsaLentes = lUsaLentes;
    }

    public String getComisariato() {
        return comisariato;
    }

    public void setComisariato(String comisariato) {
        this.comisariato = comisariato;
    }

    public Date getFReingreso() {
        return fReingreso;
    }

    public void setFReingreso(Date fReingreso) {
        this.fReingreso = fReingreso;
    }

    public String getAliasBaseDatos() {
        return aliasBaseDatos;
    }

    public void setAliasBaseDatos(String aliasBaseDatos) {
        this.aliasBaseDatos = aliasBaseDatos;
    }

    public String getPieFirma() {
        return pieFirma;
    }

    public void setPieFirma(String pieFirma) {
        this.pieFirma = pieFirma;
    }

    public String getNoDirec() {
        return noDirec;
    }

    public void setNoDirec(String noDirec) {
        this.noDirec = noDirec;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public String getCargoLossca() {
        return cargoLossca;
    }

    public void setCargoLossca(String cargoLossca) {
        this.cargoLossca = cargoLossca;
    }

    public BigDecimal getPatronal() {
        return patronal;
    }

    public void setPatronal(BigDecimal patronal) {
        this.patronal = patronal;
    }

    public BigDecimal getPersonal() {
        return personal;
    }

    public void setPersonal(BigDecimal personal) {
        this.personal = personal;
    }

    public BigDecimal getIece() {
        return iece;
    }

    public void setIece(BigDecimal iece) {
        this.iece = iece;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getSubproceso() {
        return subproceso;
    }

    public void setSubproceso(String subproceso) {
        this.subproceso = subproceso;
    }

    public String getPartidaPresupuestaria() {
        return partidaPresupuestaria;
    }

    public void setPartidaPresupuestaria(String partidaPresupuestaria) {
        this.partidaPresupuestaria = partidaPresupuestaria;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getLDiscapacidad() {
        return lDiscapacidad;
    }

    public void setLDiscapacidad(Short lDiscapacidad) {
        this.lDiscapacidad = lDiscapacidad;
    }

    public String getNoConadis() {
        return noConadis;
    }

    public void setNoConadis(String noConadis) {
        this.noConadis = noConadis;
    }

    public String getAutoidentificacionEtnica() {
        return autoidentificacionEtnica;
    }

    public void setAutoidentificacionEtnica(String autoidentificacionEtnica) {
        this.autoidentificacionEtnica = autoidentificacionEtnica;
    }

    public String getNacionalidadIndigena() {
        return nacionalidadIndigena;
    }

    public void setNacionalidadIndigena(String nacionalidadIndigena) {
        this.nacionalidadIndigena = nacionalidadIndigena;
    }

    public Short getLCatastrofica() {
        return lCatastrofica;
    }

    public void setLCatastrofica(Short lCatastrofica) {
        this.lCatastrofica = lCatastrofica;
    }

    public String getNoConadisCatastrofica() {
        return noConadisCatastrofica;
    }

    public void setNoConadisCatastrofica(String noConadisCatastrofica) {
        this.noConadisCatastrofica = noConadisCatastrofica;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContactoApellidos() {
        return contactoApellidos;
    }

    public void setContactoApellidos(String contactoApellidos) {
        this.contactoApellidos = contactoApellidos;
    }

    public String getContactoNombres() {
        return contactoNombres;
    }

    public void setContactoNombres(String contactoNombres) {
        this.contactoNombres = contactoNombres;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getContactoCelular() {
        return contactoCelular;
    }

    public void setContactoCelular(String contactoCelular) {
        this.contactoCelular = contactoCelular;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    @XmlTransient
    public List<TContrataciones> getTContratacionesList() {
        return tContratacionesList;
    }

    public void setTContratacionesList(List<TContrataciones> tContratacionesList) {
        this.tContratacionesList = tContratacionesList;
    }

    public TLicencia getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(TLicencia noLicencia) {
        this.noLicencia = noLicencia;
    }

    public TNacionalidad getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(TNacionalidad idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public TProfesiones getNoProfesion() {
        return noProfesion;
    }

    public void setNoProfesion(TProfesiones noProfesion) {
        this.noProfesion = noProfesion;
    }

    public TRhReligion getNoRelig() {
        return noRelig;
    }

    public void setNoRelig(TRhReligion noRelig) {
        this.noRelig = noRelig;
    }

    public TRhTipoSegSocial getNoSeg() {
        return noSeg;
    }

    public void setNoSeg(TRhTipoSegSocial noSeg) {
        this.noSeg = noSeg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noPersona != null ? noPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDatEmpleado)) {
            return false;
        }
        TDatEmpleado other = (TDatEmpleado) object;
        if ((this.noPersona == null && other.noPersona != null) || (this.noPersona != null && !this.noPersona.equals(other.noPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TDatEmpleado[ noPersona=" + noPersona + " ]";
    }
    
}
