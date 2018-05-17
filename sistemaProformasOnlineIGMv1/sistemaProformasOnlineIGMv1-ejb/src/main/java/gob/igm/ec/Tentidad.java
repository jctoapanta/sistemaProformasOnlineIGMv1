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
@Table(name = "TENTIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tentidad.findAll", query = "SELECT t FROM Tentidad t")
    , @NamedQuery(name = "Tentidad.findByCiu", query = "SELECT t FROM Tentidad t WHERE t.ciu = :ciu")
    , @NamedQuery(name = "Tentidad.findByNombres", query = "SELECT t FROM Tentidad t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "Tentidad.findByApellidos", query = "SELECT t FROM Tentidad t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Tentidad.findByDireccion", query = "SELECT t FROM Tentidad t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Tentidad.findByTelefonoConvencional", query = "SELECT t FROM Tentidad t WHERE t.telefonoConvencional = :telefonoConvencional")
    , @NamedQuery(name = "Tentidad.findByTelefonoCelular", query = "SELECT t FROM Tentidad t WHERE t.telefonoCelular = :telefonoCelular")
    , @NamedQuery(name = "Tentidad.findByFax", query = "SELECT t FROM Tentidad t WHERE t.fax = :fax")
    , @NamedQuery(name = "Tentidad.findByEmail", query = "SELECT t FROM Tentidad t WHERE t.email = :email")
    , @NamedQuery(name = "Tentidad.findByCCtble", query = "SELECT t FROM Tentidad t WHERE t.cCtble = :cCtble")
    , @NamedQuery(name = "Tentidad.findByIdCreador", query = "SELECT t FROM Tentidad t WHERE t.idCreador = :idCreador")
    , @NamedQuery(name = "Tentidad.findByIdModificador", query = "SELECT t FROM Tentidad t WHERE t.idModificador = :idModificador")
    , @NamedQuery(name = "Tentidad.findByClave", query = "SELECT t FROM Tentidad t WHERE t.clave = :clave")
    , @NamedQuery(name = "Tentidad.findByLNatural", query = "SELECT t FROM Tentidad t WHERE t.lNatural = :lNatural")})
public class Tentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CIU")
    private String ciu;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "TELEFONO_CONVENCIONAL")
    private String telefonoConvencional;
    @Size(max = 20)
    @Column(name = "TELEFONO_CELULAR")
    private String telefonoCelular;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "FAX")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "C_CTBLE")
    private String cCtble;
    @Column(name = "ID_CREADOR")
    private Integer idCreador;
    @Column(name = "ID_MODIFICADOR")
    private Integer idModificador;
    @Size(max = 250)
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "L_NATURAL")
    private Short lNatural;
    @OneToMany(mappedBy = "ciu")
    private Collection<Tdireccionesusr> tdireccionesusrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciu")
    private Collection<Tproforma> tproformaCollection;

    public Tentidad() {
    }

    public Tentidad(String ciu) {
        this.ciu = ciu;
    }

    public String getCiu() {
        return ciu;
    }

    public void setCiu(String ciu) {
        this.ciu = ciu;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoConvencional() {
        return telefonoConvencional;
    }

    public void setTelefonoConvencional(String telefonoConvencional) {
        this.telefonoConvencional = telefonoConvencional;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
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

    public String getCCtble() {
        return cCtble;
    }

    public void setCCtble(String cCtble) {
        this.cCtble = cCtble;
    }

    public Integer getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Integer idCreador) {
        this.idCreador = idCreador;
    }

    public Integer getIdModificador() {
        return idModificador;
    }

    public void setIdModificador(Integer idModificador) {
        this.idModificador = idModificador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Short getLNatural() {
        return lNatural;
    }

    public void setLNatural(Short lNatural) {
        this.lNatural = lNatural;
    }

    @XmlTransient
    public Collection<Tdireccionesusr> getTdireccionesusrCollection() {
        return tdireccionesusrCollection;
    }

    public void setTdireccionesusrCollection(Collection<Tdireccionesusr> tdireccionesusrCollection) {
        this.tdireccionesusrCollection = tdireccionesusrCollection;
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
        hash += (ciu != null ? ciu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tentidad)) {
            return false;
        }
        Tentidad other = (Tentidad) object;
        if ((this.ciu == null && other.ciu != null) || (this.ciu != null && !this.ciu.equals(other.ciu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Tentidad[ ciu=" + ciu + " ]";
    }
    
}
