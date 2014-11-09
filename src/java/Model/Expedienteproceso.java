/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "EXPEDIENTEPROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expedienteproceso.findAll", query = "SELECT e FROM Expedienteproceso e"),
    @NamedQuery(name = "Expedienteproceso.findByCodigoproceso", query = "SELECT e FROM Expedienteproceso e WHERE e.codigoproceso = :codigoproceso"),
    @NamedQuery(name = "Expedienteproceso.findByDenominacionproceso", query = "SELECT e FROM Expedienteproceso e WHERE e.denominacionproceso = :denominacionproceso"),
    @NamedQuery(name = "Expedienteproceso.findByResponsableproceso", query = "SELECT e FROM Expedienteproceso e WHERE e.responsableproceso = :responsableproceso"),
    @NamedQuery(name = "Expedienteproceso.findByTipoproceso", query = "SELECT e FROM Expedienteproceso e WHERE e.tipoproceso = :tipoproceso"),
    @NamedQuery(name = "Expedienteproceso.findByEstadoproceso", query = "SELECT e FROM Expedienteproceso e WHERE e.estadoproceso = :estadoproceso")})
public class Expedienteproceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODIGOPROCESO")
    private String codigoproceso;
    @Size(max = 50)
    @Column(name = "DENOMINACIONPROCESO")
    private String denominacionproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RESPONSABLEPROCESO")
    private String responsableproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPOPROCESO")
    private String tipoproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADOPROCESO")
    private String estadoproceso;
    @JoinColumn(name = "NOMBREADJUDICATARIO", referencedColumnName = "NOMBREOFERENTE")
    @ManyToOne
    private Oferente nombreadjudicatario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expedienteproceso")
    private Collection<Oferta> ofertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expedienteproceso")
    private Collection<Adenda> adendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expedienteproceso")
    private Collection<Detalleficharetirobases> detalleficharetirobasesCollection;

    public Expedienteproceso() {
    }

    public Expedienteproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
    }

    public Expedienteproceso(String codigoproceso, String responsableproceso, String tipoproceso, String estadoproceso) {
        this.codigoproceso = codigoproceso;
        this.responsableproceso = responsableproceso;
        this.tipoproceso = tipoproceso;
        this.estadoproceso = estadoproceso;
    }

    public String getCodigoproceso() {
        return codigoproceso;
    }

    public void setCodigoproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
    }

    public String getDenominacionproceso() {
        return denominacionproceso;
    }

    public void setDenominacionproceso(String denominacionproceso) {
        this.denominacionproceso = denominacionproceso;
    }

    public String getResponsableproceso() {
        return responsableproceso;
    }

    public void setResponsableproceso(String responsableproceso) {
        this.responsableproceso = responsableproceso;
    }

    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public String getEstadoproceso() {
        return estadoproceso;
    }

    public void setEstadoproceso(String estadoproceso) {
        this.estadoproceso = estadoproceso;
    }

    public Oferente getNombreadjudicatario() {
        return nombreadjudicatario;
    }

    public void setNombreadjudicatario(Oferente nombreadjudicatario) {
        this.nombreadjudicatario = nombreadjudicatario;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    @XmlTransient
    public Collection<Adenda> getAdendaCollection() {
        return adendaCollection;
    }

    public void setAdendaCollection(Collection<Adenda> adendaCollection) {
        this.adendaCollection = adendaCollection;
    }

    @XmlTransient
    public Collection<Detalleficharetirobases> getDetalleficharetirobasesCollection() {
        return detalleficharetirobasesCollection;
    }

    public void setDetalleficharetirobasesCollection(Collection<Detalleficharetirobases> detalleficharetirobasesCollection) {
        this.detalleficharetirobasesCollection = detalleficharetirobasesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoproceso != null ? codigoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expedienteproceso)) {
            return false;
        }
        Expedienteproceso other = (Expedienteproceso) object;
        if ((this.codigoproceso == null && other.codigoproceso != null) || (this.codigoproceso != null && !this.codigoproceso.equals(other.codigoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Expedienteproceso[ codigoproceso=" + codigoproceso + " ]";
    }
    
}
