/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    , @NamedQuery(name = "Ttarifario.findByIdProvincia", query = "SELECT t FROM Ttarifario t WHERE t.ttarifarioPK.idProvincia = :idProvincia")
    , @NamedQuery(name = "Ttarifario.findByIdCanton", query = "SELECT t FROM Ttarifario t WHERE t.ttarifarioPK.idCanton = :idCanton")
    , @NamedQuery(name = "Ttarifario.findByValor", query = "SELECT t FROM Ttarifario t WHERE t.valor = :valor")})
public class Ttarifario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TtarifarioPK ttarifarioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @JoinColumns({
        @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_CANTON", referencedColumnName = "ID_CANTON", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Tcanton tcanton;

    public Ttarifario() {
    }

    public Ttarifario(TtarifarioPK ttarifarioPK) {
        this.ttarifarioPK = ttarifarioPK;
    }

    public Ttarifario(int idProvincia, int idCanton) {
        this.ttarifarioPK = new TtarifarioPK(idProvincia, idCanton);
    }

    public TtarifarioPK getTtarifarioPK() {
        return ttarifarioPK;
    }

    public void setTtarifarioPK(TtarifarioPK ttarifarioPK) {
        this.ttarifarioPK = ttarifarioPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Tcanton getTcanton() {
        return tcanton;
    }

    public void setTcanton(Tcanton tcanton) {
        this.tcanton = tcanton;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttarifarioPK != null ? ttarifarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttarifario)) {
            return false;
        }
        Ttarifario other = (Ttarifario) object;
        if ((this.ttarifarioPK == null && other.ttarifarioPK != null) || (this.ttarifarioPK != null && !this.ttarifarioPK.equals(other.ttarifarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.Ttarifario[ ttarifarioPK=" + ttarifarioPK + " ]";
    }
    
}
