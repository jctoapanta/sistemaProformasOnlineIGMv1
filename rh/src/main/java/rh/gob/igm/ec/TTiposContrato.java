/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "T_TIPOS_CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTiposContrato.findAll", query = "SELECT t FROM TTiposContrato t")
    , @NamedQuery(name = "TTiposContrato.findByCContrato", query = "SELECT t FROM TTiposContrato t WHERE t.cContrato = :cContrato")
    , @NamedQuery(name = "TTiposContrato.findByDescrip", query = "SELECT t FROM TTiposContrato t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TTiposContrato.findByLDuracion", query = "SELECT t FROM TTiposContrato t WHERE t.lDuracion = :lDuracion")
    , @NamedQuery(name = "TTiposContrato.findByTTiempo", query = "SELECT t FROM TTiposContrato t WHERE t.tTiempo = :tTiempo")
    , @NamedQuery(name = "TTiposContrato.findByDuracion", query = "SELECT t FROM TTiposContrato t WHERE t.duracion = :duracion")
    , @NamedQuery(name = "TTiposContrato.findByLValido", query = "SELECT t FROM TTiposContrato t WHERE t.lValido = :lValido")})
public class TTiposContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "C_CONTRATO")
    private Short cContrato;
    @Size(max = 100)
    @Column(name = "DESCRIP")
    private String descrip;
    @Column(name = "L_DURACION")
    private Short lDuracion;
    @Size(max = 1)
    @Column(name = "T_TIEMPO")
    private String tTiempo;
    @Column(name = "DURACION")
    private Short duracion;
    @Column(name = "L_VALIDO")
    private Short lValido;
    @OneToMany(mappedBy = "cContrato")
    private List<TContrataciones> tContratacionesList;

    public TTiposContrato() {
    }

    public TTiposContrato(Short cContrato) {
        this.cContrato = cContrato;
    }

    public Short getCContrato() {
        return cContrato;
    }

    public void setCContrato(Short cContrato) {
        this.cContrato = cContrato;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Short getLDuracion() {
        return lDuracion;
    }

    public void setLDuracion(Short lDuracion) {
        this.lDuracion = lDuracion;
    }

    public String getTTiempo() {
        return tTiempo;
    }

    public void setTTiempo(String tTiempo) {
        this.tTiempo = tTiempo;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public Short getLValido() {
        return lValido;
    }

    public void setLValido(Short lValido) {
        this.lValido = lValido;
    }

    @XmlTransient
    public List<TContrataciones> getTContratacionesList() {
        return tContratacionesList;
    }

    public void setTContratacionesList(List<TContrataciones> tContratacionesList) {
        this.tContratacionesList = tContratacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cContrato != null ? cContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTiposContrato)) {
            return false;
        }
        TTiposContrato other = (TTiposContrato) object;
        if ((this.cContrato == null && other.cContrato != null) || (this.cContrato != null && !this.cContrato.equals(other.cContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TTiposContrato[ cContrato=" + cContrato + " ]";
    }
    
}
