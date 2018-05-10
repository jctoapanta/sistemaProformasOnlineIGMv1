/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "TTIPOCARTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipocarta.findAll", query = "SELECT t FROM Ttipocarta t"),
    @NamedQuery(name = "Ttipocarta.findByIdTipoCarta", query = "SELECT t FROM Ttipocarta t WHERE t.idTipoCarta = :idTipoCarta"),
    @NamedQuery(name = "Ttipocarta.findByDescCarta", query = "SELECT t FROM Ttipocarta t WHERE t.descCarta = :descCarta"),
    @NamedQuery(name = "Ttipocarta.findByTamanio", query = "SELECT t FROM Ttipocarta t WHERE t.tamanio = :tamanio"),
    @NamedQuery(name = "Ttipocarta.findByTipoTamanio", query = "SELECT t FROM Ttipocarta t WHERE t.tipoTamanio = :tipoTamanio"),
    @NamedQuery(name = "Ttipocarta.findByControl", query = "SELECT t FROM Ttipocarta t WHERE t.control = :control")})
public class Ttipocarta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_CARTA")
    private Short idTipoCarta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESC_CARTA")
    private String descCarta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAMANIO")
    private BigDecimal tamanio;
    @Size(max = 1)
    @Column(name = "TIPO_TAMANIO")
    private String tipoTamanio;
    @Size(max = 1)
    @Column(name = "CONTROL")
    private String control;
    @OneToMany(mappedBy = "idTipoCarta")
    private Collection<Tdetproforma> tdetproformaCollection;

    public Ttipocarta() {
    }

    public Ttipocarta(Short idTipoCarta) {
        this.idTipoCarta = idTipoCarta;
    }

    public Ttipocarta(Short idTipoCarta, String descCarta) {
        this.idTipoCarta = idTipoCarta;
        this.descCarta = descCarta;
    }

    public Short getIdTipoCarta() {
        return idTipoCarta;
    }

    public void setIdTipoCarta(Short idTipoCarta) {
        this.idTipoCarta = idTipoCarta;
    }

    public String getDescCarta() {
        return descCarta;
    }

    public void setDescCarta(String descCarta) {
        this.descCarta = descCarta;
    }

    public BigDecimal getTamanio() {
        return tamanio;
    }

    public void setTamanio(BigDecimal tamanio) {
        this.tamanio = tamanio;
    }

    public String getTipoTamanio() {
        return tipoTamanio;
    }

    public void setTipoTamanio(String tipoTamanio) {
        this.tipoTamanio = tipoTamanio;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
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
        hash += (idTipoCarta != null ? idTipoCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttipocarta)) {
            return false;
        }
        Ttipocarta other = (Ttipocarta) object;
        if ((this.idTipoCarta == null && other.idTipoCarta != null) || (this.idTipoCarta != null && !this.idTipoCarta.equals(other.idTipoCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Ttipocarta[ idTipoCarta=" + idTipoCarta + " ]";
    }
    
}
