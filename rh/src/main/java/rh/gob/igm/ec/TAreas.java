/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "T_AREAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAreas.findAll", query = "SELECT t FROM TAreas t")
    , @NamedQuery(name = "TAreas.findByNoCd", query = "SELECT t FROM TAreas t WHERE t.tAreasPK.noCd = :noCd")
    , @NamedQuery(name = "TAreas.findByNoEmpMatriz", query = "SELECT t FROM TAreas t WHERE t.tAreasPK.noEmpMatriz = :noEmpMatriz")
    , @NamedQuery(name = "TAreas.findByNoEmpresa", query = "SELECT t FROM TAreas t WHERE t.noEmpresa = :noEmpresa")
    , @NamedQuery(name = "TAreas.findByTipo", query = "SELECT t FROM TAreas t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TAreas.findByDescrip", query = "SELECT t FROM TAreas t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TAreas.findByResponsable", query = "SELECT t FROM TAreas t WHERE t.responsable = :responsable")
    , @NamedQuery(name = "TAreas.findByCodigo", query = "SELECT t FROM TAreas t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TAreas.findByCodigoCentroGestion", query = "SELECT t FROM TAreas t WHERE t.codigoCentroGestion = :codigoCentroGestion")
    , @NamedQuery(name = "TAreas.findByCPartida", query = "SELECT t FROM TAreas t WHERE t.cPartida = :cPartida")
    , @NamedQuery(name = "TAreas.findByLResponsableP", query = "SELECT t FROM TAreas t WHERE t.lResponsableP = :lResponsableP")})
public class TAreas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TAreasPK tAreasPK;
    @Column(name = "NO_EMPRESA")
    private Short noEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 200)
    @Column(name = "DESCRIP")
    private String descrip;
    @Size(max = 50)
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Size(max = 15)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CODIGO_CENTRO_GESTION")
    private Short codigoCentroGestion;
    @Size(max = 30)
    @Column(name = "C_PARTIDA")
    private String cPartida;
    @Column(name = "L_RESPONSABLE_P")
    private Short lResponsableP;
    @OneToMany(mappedBy = "tAreas")
    private List<TContrataciones> tContratacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tAreas")
    private List<TAreas> tAreasList;
    @JoinColumns({
        @JoinColumn(name = "NO_CD_PADRE", referencedColumnName = "NO_CD")
        , @JoinColumn(name = "NO_EMP_MATRIZ", referencedColumnName = "NO_EMP_MATRIZ", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TAreas tAreas;

    public TAreas() {
    }

    public TAreas(TAreasPK tAreasPK) {
        this.tAreasPK = tAreasPK;
    }

    public TAreas(TAreasPK tAreasPK, String tipo) {
        this.tAreasPK = tAreasPK;
        this.tipo = tipo;
    }

    public TAreas(short noCd, short noEmpMatriz) {
        this.tAreasPK = new TAreasPK(noCd, noEmpMatriz);
    }

    public TAreasPK getTAreasPK() {
        return tAreasPK;
    }

    public void setTAreasPK(TAreasPK tAreasPK) {
        this.tAreasPK = tAreasPK;
    }

    public Short getNoEmpresa() {
        return noEmpresa;
    }

    public void setNoEmpresa(Short noEmpresa) {
        this.noEmpresa = noEmpresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Short getCodigoCentroGestion() {
        return codigoCentroGestion;
    }

    public void setCodigoCentroGestion(Short codigoCentroGestion) {
        this.codigoCentroGestion = codigoCentroGestion;
    }

    public String getCPartida() {
        return cPartida;
    }

    public void setCPartida(String cPartida) {
        this.cPartida = cPartida;
    }

    public Short getLResponsableP() {
        return lResponsableP;
    }

    public void setLResponsableP(Short lResponsableP) {
        this.lResponsableP = lResponsableP;
    }

    @XmlTransient
    public List<TContrataciones> getTContratacionesList() {
        return tContratacionesList;
    }

    public void setTContratacionesList(List<TContrataciones> tContratacionesList) {
        this.tContratacionesList = tContratacionesList;
    }

    @XmlTransient
    public List<TAreas> getTAreasList() {
        return tAreasList;
    }

    public void setTAreasList(List<TAreas> tAreasList) {
        this.tAreasList = tAreasList;
    }

    public TAreas getTAreas() {
        return tAreas;
    }

    public void setTAreas(TAreas tAreas) {
        this.tAreas = tAreas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tAreasPK != null ? tAreasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAreas)) {
            return false;
        }
        TAreas other = (TAreas) object;
        if ((this.tAreasPK == null && other.tAreasPK != null) || (this.tAreasPK != null && !this.tAreasPK.equals(other.tAreasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.igm.ec.rh.TAreas[ tAreasPK=" + tAreasPK + " ]";
    }
    
}
