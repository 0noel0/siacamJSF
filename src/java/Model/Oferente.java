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
@Table(name = "OFERENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferente.findAll", query = "SELECT o FROM Oferente o"),
    @NamedQuery(name = "Oferente.findByNombreoferente", query = "SELECT o FROM Oferente o WHERE o.nombreoferente = :nombreoferente"),
    @NamedQuery(name = "Oferente.findByTelefonooferente", query = "SELECT o FROM Oferente o WHERE o.telefonooferente = :telefonooferente"),
    @NamedQuery(name = "Oferente.findByFaxoferente", query = "SELECT o FROM Oferente o WHERE o.faxoferente = :faxoferente"),
    @NamedQuery(name = "Oferente.findByEmailoferente", query = "SELECT o FROM Oferente o WHERE o.emailoferente = :emailoferente"),
    @NamedQuery(name = "Oferente.findByTiposervicio", query = "SELECT o FROM Oferente o WHERE o.tiposervicio = :tiposervicio"),
    @NamedQuery(name = "Oferente.findByCalificacion", query = "SELECT o FROM Oferente o WHERE o.calificacion = :calificacion"),
    @NamedQuery(name = "Oferente.findByEstadooferente", query = "SELECT o FROM Oferente o WHERE o.estadooferente = :estadooferente")})
public class Oferente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREOFERENTE")
    private String nombreoferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONOOFERENTE")
    private String telefonooferente;
    @Size(max = 10)
    @Column(name = "FAXOFERENTE")
    private String faxoferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMAILOFERENTE")
    private String emailoferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPOSERVICIO")
    private String tiposervicio;
    @Size(max = 10)
    @Column(name = "CALIFICACION")
    private String calificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADOOFERENTE")
    private String estadooferente;
    @OneToMany(mappedBy = "nombreadjudicatario")
    private Collection<Expedienteproceso> expedienteprocesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferente")
    private Collection<Oferta> ofertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreoferente")
    private Collection<Detalleficharetirobases> detalleficharetirobasesCollection;

    public Oferente() {
    }

    public Oferente(String nombreoferente) {
        this.nombreoferente = nombreoferente;
    }

    public Oferente(String nombreoferente, String telefonooferente, String emailoferente, String tiposervicio, String estadooferente) {
        this.nombreoferente = nombreoferente;
        this.telefonooferente = telefonooferente;
        this.emailoferente = emailoferente;
        this.tiposervicio = tiposervicio;
        this.estadooferente = estadooferente;
    }

    public String getNombreoferente() {
        return nombreoferente;
    }

    public void setNombreoferente(String nombreoferente) {
        this.nombreoferente = nombreoferente;
    }

    public String getTelefonooferente() {
        return telefonooferente;
    }

    public void setTelefonooferente(String telefonooferente) {
        this.telefonooferente = telefonooferente;
    }

    public String getFaxoferente() {
        return faxoferente;
    }

    public void setFaxoferente(String faxoferente) {
        this.faxoferente = faxoferente;
    }

    public String getEmailoferente() {
        return emailoferente;
    }

    public void setEmailoferente(String emailoferente) {
        this.emailoferente = emailoferente;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstadooferente() {
        return estadooferente;
    }

    public void setEstadooferente(String estadooferente) {
        this.estadooferente = estadooferente;
    }

    @XmlTransient
    public Collection<Expedienteproceso> getExpedienteprocesoCollection() {
        return expedienteprocesoCollection;
    }

    public void setExpedienteprocesoCollection(Collection<Expedienteproceso> expedienteprocesoCollection) {
        this.expedienteprocesoCollection = expedienteprocesoCollection;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
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
        hash += (nombreoferente != null ? nombreoferente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferente)) {
            return false;
        }
        Oferente other = (Oferente) object;
        if ((this.nombreoferente == null && other.nombreoferente != null) || (this.nombreoferente != null && !this.nombreoferente.equals(other.nombreoferente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Oferente[ nombreoferente=" + nombreoferente + " ]";
    }
    
}
