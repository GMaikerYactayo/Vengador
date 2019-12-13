/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author PC14
 */
@Entity
@Table(name = "TIPO_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t")
    , @NamedQuery(name = "TipoServicio.findByCodtipser", query = "SELECT t FROM TipoServicio t WHERE t.codtipser = :codtipser")
    , @NamedQuery(name = "TipoServicio.findByNomtipser", query = "SELECT t FROM TipoServicio t WHERE t.nomtipser = :nomtipser")
    , @NamedQuery(name = "TipoServicio.findByEsttipser", query = "SELECT t FROM TipoServicio t WHERE t.esttipser = :esttipser")})
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODTIPSER")
    private Long codtipser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMTIPSER")
    private String nomtipser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTTIPSER")
    private Character esttipser='A';
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipser")
    private List<DetalleServicio> detalleServicioList;

    public TipoServicio() {
    }

    public TipoServicio(Long codtipser) {
        this.codtipser = codtipser;
    }

    public TipoServicio(Long codtipser, String nomtipser, Character esttipser) {
        this.codtipser = codtipser;
        this.nomtipser = nomtipser;
        this.esttipser = esttipser;
    }

    public Long getCodtipser() {
        return codtipser;
    }

    public void setCodtipser(Long codtipser) {
        this.codtipser = codtipser;
    }

    public String getNomtipser() {
        return nomtipser;
    }

    public void setNomtipser(String nomtipser) {
        this.nomtipser = nomtipser;
    }

    public Character getEsttipser() {
        return esttipser;
    }

    public void setEsttipser(Character esttipser) {
        this.esttipser = esttipser;
    }

    @XmlTransient
    public List<DetalleServicio> getDetalleServicioList() {
        return detalleServicioList;
    }

    public void setDetalleServicioList(List<DetalleServicio> detalleServicioList) {
        this.detalleServicioList = detalleServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipser != null ? codtipser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.codtipser == null && other.codtipser != null) || (this.codtipser != null && !this.codtipser.equals(other.codtipser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.TipoServicio[ codtipser=" + codtipser + " ]";
    }
    
}
