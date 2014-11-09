/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noel
 */
@Entity
@Table(name = "DETALLEOFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleoferta.findAll", query = "SELECT d FROM Detalleoferta d"),
    @NamedQuery(name = "Detalleoferta.findByNombreoferente", query = "SELECT d FROM Detalleoferta d WHERE d.detalleofertaPK.nombreoferente = :nombreoferente"),
    @NamedQuery(name = "Detalleoferta.findByCodigoproceso", query = "SELECT d FROM Detalleoferta d WHERE d.detalleofertaPK.codigoproceso = :codigoproceso"),
    @NamedQuery(name = "Detalleoferta.findByRubro", query = "SELECT d FROM Detalleoferta d WHERE d.detalleofertaPK.rubro = :rubro"),
    @NamedQuery(name = "Detalleoferta.findByMarcaofertada", query = "SELECT d FROM Detalleoferta d WHERE d.marcaofertada = :marcaofertada"),
    @NamedQuery(name = "Detalleoferta.findByPreciounitario", query = "SELECT d FROM Detalleoferta d WHERE d.preciounitario = :preciounitario"),
    @NamedQuery(name = "Detalleoferta.findByTotal", query = "SELECT d FROM Detalleoferta d WHERE d.total = :total"),
    @NamedQuery(name = "Detalleoferta.findByMontogarantia", query = "SELECT d FROM Detalleoferta d WHERE d.montogarantia = :montogarantia")})
public class Detalleoferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleofertaPK detalleofertaPK;
    @Size(max = 10)
    @Column(name = "MARCAOFERTADA")
    private String marcaofertada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOUNITARIO")
    private BigDecimal preciounitario;
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "MONTOGARANTIA")
    private BigDecimal montogarantia;
    @JoinColumns({
        @JoinColumn(name = "NOMBREOFERENTE", referencedColumnName = "NOMBREOFERENTE", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Oferta oferta;

    public Detalleoferta() {
    }

    public Detalleoferta(DetalleofertaPK detalleofertaPK) {
        this.detalleofertaPK = detalleofertaPK;
    }

    public Detalleoferta(String nombreoferente, String codigoproceso, String rubro) {
        this.detalleofertaPK = new DetalleofertaPK(nombreoferente, codigoproceso, rubro);
    }

    public DetalleofertaPK getDetalleofertaPK() {
        return detalleofertaPK;
    }

    public void setDetalleofertaPK(DetalleofertaPK detalleofertaPK) {
        this.detalleofertaPK = detalleofertaPK;
    }

    public String getMarcaofertada() {
        return marcaofertada;
    }

    public void setMarcaofertada(String marcaofertada) {
        this.marcaofertada = marcaofertada;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMontogarantia() {
        return montogarantia;
    }

    public void setMontogarantia(BigDecimal montogarantia) {
        this.montogarantia = montogarantia;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleofertaPK != null ? detalleofertaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleoferta)) {
            return false;
        }
        Detalleoferta other = (Detalleoferta) object;
        if ((this.detalleofertaPK == null && other.detalleofertaPK != null) || (this.detalleofertaPK != null && !this.detalleofertaPK.equals(other.detalleofertaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detalleoferta[ detalleofertaPK=" + detalleofertaPK + " ]";
    }
    
}
