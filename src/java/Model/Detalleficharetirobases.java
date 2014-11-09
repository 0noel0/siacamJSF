/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noel
 */
@Entity
@Table(name = "DETALLEFICHARETIROBASES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleficharetirobases.findAll", query = "SELECT d FROM Detalleficharetirobases d"),
    @NamedQuery(name = "Detalleficharetirobases.findByNocorrelativo", query = "SELECT d FROM Detalleficharetirobases d WHERE d.detalleficharetirobasesPK.nocorrelativo = :nocorrelativo"),
    @NamedQuery(name = "Detalleficharetirobases.findByCodigoproceso", query = "SELECT d FROM Detalleficharetirobases d WHERE d.detalleficharetirobasesPK.codigoproceso = :codigoproceso"),
    @NamedQuery(name = "Detalleficharetirobases.findByNombrecomisionado", query = "SELECT d FROM Detalleficharetirobases d WHERE d.nombrecomisionado = :nombrecomisionado"),
    @NamedQuery(name = "Detalleficharetirobases.findByDocumentoidcomisionado", query = "SELECT d FROM Detalleficharetirobases d WHERE d.documentoidcomisionado = :documentoidcomisionado"),
    @NamedQuery(name = "Detalleficharetirobases.findByLugarparanotificaciones", query = "SELECT d FROM Detalleficharetirobases d WHERE d.lugarparanotificaciones = :lugarparanotificaciones"),
    @NamedQuery(name = "Detalleficharetirobases.findByFecharetirobases", query = "SELECT d FROM Detalleficharetirobases d WHERE d.fecharetirobases = :fecharetirobases"),
    @NamedQuery(name = "Detalleficharetirobases.findByHoraretirobases", query = "SELECT d FROM Detalleficharetirobases d WHERE d.horaretirobases = :horaretirobases")})
public class Detalleficharetirobases implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleficharetirobasesPK detalleficharetirobasesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRECOMISIONADO")
    private String nombrecomisionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DOCUMENTOIDCOMISIONADO")
    private String documentoidcomisionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LUGARPARANOTIFICACIONES")
    private String lugarparanotificaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHARETIROBASES")
    @Temporal(TemporalType.DATE)
    private Date fecharetirobases;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARETIROBASES")
    @Temporal(TemporalType.TIME)
    private Date horaretirobases;
    @JoinColumn(name = "NOMBREOFERENTE", referencedColumnName = "NOMBREOFERENTE")
    @ManyToOne(optional = false)
    private Oferente nombreoferente;
    @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Expedienteproceso expedienteproceso;

    public Detalleficharetirobases() {
    }

    public Detalleficharetirobases(DetalleficharetirobasesPK detalleficharetirobasesPK) {
        this.detalleficharetirobasesPK = detalleficharetirobasesPK;
    }

    public Detalleficharetirobases(DetalleficharetirobasesPK detalleficharetirobasesPK, String nombrecomisionado, String documentoidcomisionado, String lugarparanotificaciones, Date fecharetirobases, Date horaretirobases) {
        this.detalleficharetirobasesPK = detalleficharetirobasesPK;
        this.nombrecomisionado = nombrecomisionado;
        this.documentoidcomisionado = documentoidcomisionado;
        this.lugarparanotificaciones = lugarparanotificaciones;
        this.fecharetirobases = fecharetirobases;
        this.horaretirobases = horaretirobases;
    }

    public Detalleficharetirobases(int nocorrelativo, String codigoproceso) {
        this.detalleficharetirobasesPK = new DetalleficharetirobasesPK(nocorrelativo, codigoproceso);
    }

    public DetalleficharetirobasesPK getDetalleficharetirobasesPK() {
        return detalleficharetirobasesPK;
    }

    public void setDetalleficharetirobasesPK(DetalleficharetirobasesPK detalleficharetirobasesPK) {
        this.detalleficharetirobasesPK = detalleficharetirobasesPK;
    }

    public String getNombrecomisionado() {
        return nombrecomisionado;
    }

    public void setNombrecomisionado(String nombrecomisionado) {
        this.nombrecomisionado = nombrecomisionado;
    }

    public String getDocumentoidcomisionado() {
        return documentoidcomisionado;
    }

    public void setDocumentoidcomisionado(String documentoidcomisionado) {
        this.documentoidcomisionado = documentoidcomisionado;
    }

    public String getLugarparanotificaciones() {
        return lugarparanotificaciones;
    }

    public void setLugarparanotificaciones(String lugarparanotificaciones) {
        this.lugarparanotificaciones = lugarparanotificaciones;
    }

    public Date getFecharetirobases() {
        return fecharetirobases;
    }

    public void setFecharetirobases(Date fecharetirobases) {
        this.fecharetirobases = fecharetirobases;
    }

    public Date getHoraretirobases() {
        return horaretirobases;
    }

    public void setHoraretirobases(Date horaretirobases) {
        this.horaretirobases = horaretirobases;
    }

    public Oferente getNombreoferente() {
        return nombreoferente;
    }

    public void setNombreoferente(Oferente nombreoferente) {
        this.nombreoferente = nombreoferente;
    }

    public Expedienteproceso getExpedienteproceso() {
        return expedienteproceso;
    }

    public void setExpedienteproceso(Expedienteproceso expedienteproceso) {
        this.expedienteproceso = expedienteproceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleficharetirobasesPK != null ? detalleficharetirobasesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleficharetirobases)) {
            return false;
        }
        Detalleficharetirobases other = (Detalleficharetirobases) object;
        if ((this.detalleficharetirobasesPK == null && other.detalleficharetirobasesPK != null) || (this.detalleficharetirobasesPK != null && !this.detalleficharetirobasesPK.equals(other.detalleficharetirobasesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detalleficharetirobases[ detalleficharetirobasesPK=" + detalleficharetirobasesPK + " ]";
    }
    
}
