/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC14
 */
@Entity
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodven", query = "SELECT v FROM Venta v WHERE v.codven = :codven")
    , @NamedQuery(name = "Venta.findByInsven", query = "SELECT v FROM Venta v WHERE v.insven = :insven")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODVEN")
    private Long codven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSVEN")
    private Character insven;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne(optional = false)
    private Cliente codcli;
    @JoinColumn(name = "CODDETSER", referencedColumnName = "CODDETSER")
    @ManyToOne(optional = false)
    private DetalleServicio coddetser;
    @JoinColumn(name = "CODPRO", referencedColumnName = "CODPRO")
    @ManyToOne(optional = false)
    private Profesional codpro;

    public Venta() {
    }

    public Venta(Long codven) {
        this.codven = codven;
    }

    public Venta(Long codven, Character insven) {
        this.codven = codven;
        this.insven = insven;
    }

    public Long getCodven() {
        return codven;
    }

    public void setCodven(Long codven) {
        this.codven = codven;
    }

    public Character getInsven() {
        return insven;
    }

    public void setInsven(Character insven) {
        this.insven = insven;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public DetalleServicio getCoddetser() {
        return coddetser;
    }

    public void setCoddetser(DetalleServicio coddetser) {
        this.coddetser = coddetser;
    }

    public Profesional getCodpro() {
        return codpro;
    }

    public void setCodpro(Profesional codpro) {
        this.codpro = codpro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codven != null ? codven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codven == null && other.codven != null) || (this.codven != null && !this.codven.equals(other.codven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Venta[ codven=" + codven + " ]";
    }
    
}
