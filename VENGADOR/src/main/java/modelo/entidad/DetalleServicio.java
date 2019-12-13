/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC14
 */
@Entity
@Table(name = "DETALLE_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServicio.findAll", query = "SELECT d FROM DetalleServicio d")
    , @NamedQuery(name = "DetalleServicio.findByCoddetser", query = "SELECT d FROM DetalleServicio d WHERE d.coddetser = :coddetser")
    , @NamedQuery(name = "DetalleServicio.findByEstdetser", query = "SELECT d FROM DetalleServicio d WHERE d.estdetser = :estdetser")
    , @NamedQuery(name = "DetalleServicio.findByPredetser", query = "SELECT d FROM DetalleServicio d WHERE d.predetser = :predetser")})
public class DetalleServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODDETSER")
    private Long coddetser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTDETSER")
    private Character estdetser='A';
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PREDETSER")
    private BigDecimal predetser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddetser")
    private List<Venta> ventaList;
    @JoinColumn(name = "CODSER", referencedColumnName = "CODSER")
    @ManyToOne(optional = false)
    private Servicio codser;
    @JoinColumn(name = "CODTIPSER", referencedColumnName = "CODTIPSER")
    @ManyToOne(optional = false)
    private TipoServicio codtipser;

    public DetalleServicio() {
    }

    public DetalleServicio(Long coddetser) {
        this.coddetser = coddetser;
    }

    public DetalleServicio(Long coddetser, Character estdetser, BigDecimal predetser) {
        this.coddetser = coddetser;
        this.estdetser = estdetser;
        this.predetser = predetser;
    }

    public Long getCoddetser() {
        return coddetser;
    }

    public void setCoddetser(Long coddetser) {
        this.coddetser = coddetser;
    }

    public Character getEstdetser() {
        return estdetser;
    }

    public void setEstdetser(Character estdetser) {
        this.estdetser = estdetser;
    }

    public BigDecimal getPredetser() {
        return predetser;
    }

    public void setPredetser(BigDecimal predetser) {
        this.predetser = predetser;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Servicio getCodser() {
        return codser;
    }

    public void setCodser(Servicio codser) {
        this.codser = codser;
    }

    public TipoServicio getCodtipser() {
        return codtipser;
    }

    public void setCodtipser(TipoServicio codtipser) {
        this.codtipser = codtipser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddetser != null ? coddetser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServicio)) {
            return false;
        }
        DetalleServicio other = (DetalleServicio) object;
        if ((this.coddetser == null && other.coddetser != null) || (this.coddetser != null && !this.coddetser.equals(other.coddetser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.DetalleServicio[ coddetser=" + coddetser + " ]";
    }
    
}
