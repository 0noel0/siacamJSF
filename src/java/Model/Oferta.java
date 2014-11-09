/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
 * @author noel
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByNombreoferente", query = "SELECT o FROM Oferta o WHERE o.ofertaPK.nombreoferente = :nombreoferente"),
    @NamedQuery(name = "Oferta.findByCodigoproceso", query = "SELECT o FROM Oferta o WHERE o.ofertaPK.codigoproceso = :codigoproceso"),
    @NamedQuery(name = "Oferta.findByEstadooferta", query = "SELECT o FROM Oferta o WHERE o.estadooferta = :estadooferta"),
    @NamedQuery(name = "Oferta.findByMontooferta", query = "SELECT o FROM Oferta o WHERE o.montooferta = :montooferta")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OfertaPK ofertaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADOOFERTA")
    private String estadooferta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOOFERTA")
    private BigDecimal montooferta;
    @JoinColumn(name = "NOMBREOFERENTE", referencedColumnName = "NOMBREOFERENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferente oferente;
    @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Expedienteproceso expedienteproceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<Detalleoferta> detalleofertaCollection;

    public Oferta() {
    }

    public Oferta(OfertaPK ofertaPK) {
        this.ofertaPK = ofertaPK;
    }

    public Oferta(OfertaPK ofertaPK, String estadooferta, BigDecimal montooferta) {
        this.ofertaPK = ofertaPK;
        this.estadooferta = estadooferta;
        this.montooferta = montooferta;
    }

    public Oferta(String nombreoferente, String codigoproceso) {
        this.ofertaPK = new OfertaPK(nombreoferente, codigoproceso);
    }

    public OfertaPK getOfertaPK() {
        return ofertaPK;
    }

    public void setOfertaPK(OfertaPK ofertaPK) {
        this.ofertaPK = ofertaPK;
    }

    public String getEstadooferta() {
        return estadooferta;
    }

    public void setEstadooferta(String estadooferta) {
        this.estadooferta = estadooferta;
    }

    public BigDecimal getMontooferta() {
        return montooferta;
    }

    public void setMontooferta(BigDecimal montooferta) {
        this.montooferta = montooferta;
    }

    public Oferente getOferente() {
        return oferente;
    }

    public void setOferente(Oferente oferente) {
        this.oferente = oferente;
    }

    public Expedienteproceso getExpedienteproceso() {
        return expedienteproceso;
    }

    public void setExpedienteproceso(Expedienteproceso expedienteproceso) {
        this.expedienteproceso = expedienteproceso;
    }

    @XmlTransient
    public Collection<Detalleoferta> getDetalleofertaCollection() {
        return detalleofertaCollection;
    }

    public void setDetalleofertaCollection(Collection<Detalleoferta> detalleofertaCollection) {
        this.detalleofertaCollection = detalleofertaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertaPK != null ? ofertaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.ofertaPK == null && other.ofertaPK != null) || (this.ofertaPK != null && !this.ofertaPK.equals(other.ofertaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Oferta[ ofertaPK=" + ofertaPK + " ]";
    }
    
}
