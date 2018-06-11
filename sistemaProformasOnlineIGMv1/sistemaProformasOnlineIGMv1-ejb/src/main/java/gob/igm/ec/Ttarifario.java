/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TTARIFARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttarifario.findAll", query = "SELECT t FROM Ttarifario t")
    , @NamedQuery(name = "Ttarifario.findByValor", query = "SELECT t FROM Ttarifario t WHERE t.valor = :valor")
    , @NamedQuery(name = "Ttarifario.findByPesoMin", query = "SELECT t FROM Ttarifario t WHERE t.pesoMin = :pesoMin")
    , @NamedQuery(name = "Ttarifario.findByPesoMax", query = "SELECT t FROM Ttarifario t WHERE t.pesoMax = :pesoMax")
    , @NamedQuery(name = "Ttarifario.findByIdZona", query = "SELECT t FROM Ttarifario t WHERE t.idZona = :idZona")
    , @NamedQuery(name = "Ttarifario.findByIdTarifa", query = "SELECT t FROM Ttarifario t WHERE t.idTarifa = :idTarifa")})
public class Ttarifario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "PESO_MIN")
    private BigDecimal pesoMin;
    @Column(name = "PESO_MAX")
    private BigDecimal pesoMax;
    @Column(name = "ID_ZONA")
    private Short idZona;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TARIFA")
    private Short idTarifa;

    public Ttarifario() {
    }

    public Ttarifario(Short idTarifa) {
        this.idTarifa = idTarifa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(BigDecimal pesoMin) {
        this.pesoMin = pesoMin;
    }

    public BigDecimal getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(BigDecimal pesoMax) {
        this.pesoMax = pesoMax;
    }

    public Short getIdZona() {
        return idZona;
    }

    public void setIdZona(Short idZona) {
        this.idZona = idZona;
    }

    public Short getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Short idTarifa) {
        this.idTarifa = idTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttarifario)) {
            return false;
        }
        Ttarifario other = (Ttarifario) object;
        if ((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Ttarifario[ idTarifa=" + idTarifa + " ]";
    }
    
}
