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
@Table(name = "SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByCodser", query = "SELECT s FROM Servicio s WHERE s.codser = :codser")
    , @NamedQuery(name = "Servicio.findByNomser", query = "SELECT s FROM Servicio s WHERE s.nomser = :nomser")
    , @NamedQuery(name = "Servicio.findByEstser", query = "SELECT s FROM Servicio s WHERE s.estser = :estser")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODSER")
    private Long codser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "NOMSER")
    private String nomser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTSER")
    private Character estser='A';
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codser")
    private List<DetalleServicio> detalleServicioList;

    public Servicio() {
    }

    public Servicio(Long codser) {
        this.codser = codser;
    }

    public Servicio(Long codser, String nomser, Character estser) {
        this.codser = codser;
        this.nomser = nomser;
        this.estser = estser;
    }

    public Long getCodser() {
        return codser;
    }

    public void setCodser(Long codser) {
        this.codser = codser;
    }

    public String getNomser() {
        return nomser;
    }

    public void setNomser(String nomser) {
        this.nomser = nomser;
    }

    public Character getEstser() {
        return estser;
    }

    public void setEstser(Character estser) {
        this.estser = estser;
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
        hash += (codser != null ? codser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.codser == null && other.codser != null) || (this.codser != null && !this.codser.equals(other.codser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Servicio[ codser=" + codser + " ]";
    }
    
}
