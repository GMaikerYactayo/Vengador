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
@Table(name = "PROFESIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p")
    , @NamedQuery(name = "Profesional.findByCodpro", query = "SELECT p FROM Profesional p WHERE p.codpro = :codpro")
    , @NamedQuery(name = "Profesional.findByTippro", query = "SELECT p FROM Profesional p WHERE p.tippro = :tippro")
    , @NamedQuery(name = "Profesional.findBySerpro", query = "SELECT p FROM Profesional p WHERE p.serpro = :serpro")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODPRO")
    private Long codpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPPRO")
    private String tippro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SERPRO")
    private String serpro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpro")
    private List<Venta> ventaList;

    public Profesional() {
    }

    public Profesional(Long codpro) {
        this.codpro = codpro;
    }

    public Profesional(Long codpro, String tippro, String serpro) {
        this.codpro = codpro;
        this.tippro = tippro;
        this.serpro = serpro;
    }

    public Long getCodpro() {
        return codpro;
    }

    public void setCodpro(Long codpro) {
        this.codpro = codpro;
    }

    public String getTippro() {
        return tippro;
    }

    public void setTippro(String tippro) {
        this.tippro = tippro;
    }

    public String getSerpro() {
        return serpro;
    }

    public void setSerpro(String serpro) {
        this.serpro = serpro;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Profesional[ codpro=" + codpro + " ]";
    }
    
}
