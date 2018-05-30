/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Entity
@Table(name = "TCONTROL_IVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcontrolIva.findAll", query = "SELECT t FROM TcontrolIva t")
    , @NamedQuery(name = "TcontrolIva.findByIdIva", query = "SELECT t FROM TcontrolIva t WHERE t.idIva = :idIva")
    , @NamedQuery(name = "TcontrolIva.findByCtaCtble", query = "SELECT t FROM TcontrolIva t WHERE t.ctaCtble = :ctaCtble")
    , @NamedQuery(name = "TcontrolIva.findByControl", query = "SELECT t FROM TcontrolIva t WHERE t.control = :control")
    , @NamedQuery(name = "TcontrolIva.findByValor", query = "SELECT t FROM TcontrolIva t WHERE t.valor = :valor")})
public class TcontrolIva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_IVA")
    private Short idIva;
    @Size(max = 20)
    @Column(name = "CTA_CTBLE")
    private String ctaCtble;
    @Size(max = 1)
    @Column(name = "CONTROL")
    private String control;
    @Column(name = "VALOR")
    private Short valor;

    public TcontrolIva() {
    }

    public TcontrolIva(Short idIva) {
        this.idIva = idIva;
    }

    public Short getIdIva() {
        return idIva;
    }

    public void setIdIva(Short idIva) {
        this.idIva = idIva;
    }

    public String getCtaCtble() {
        return ctaCtble;
    }

    public void setCtaCtble(String ctaCtble) {
        this.ctaCtble = ctaCtble;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Short getValor() {
        return valor;
    }

    public void setValor(Short valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIva != null ? idIva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcontrolIva)) {
            return false;
        }
        TcontrolIva other = (TcontrolIva) object;
        if ((this.idIva == null && other.idIva != null) || (this.idIva != null && !this.idIva.equals(other.idIva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.TcontrolIva[ idIva=" + idIva + " ]";
    }
    
}
