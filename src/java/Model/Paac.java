/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author noel
 */
@Entity
@Table(name = "PAAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paac.findAll", query = "SELECT p FROM Paac p"),
    @NamedQuery(name = "Paac.findByEjerciciofiscal", query = "SELECT p FROM Paac p WHERE p.ejerciciofiscal = :ejerciciofiscal"),
    @NamedQuery(name = "Paac.findByNombreinstitucion", query = "SELECT p FROM Paac p WHERE p.nombreinstitucion = :nombreinstitucion"),
    @NamedQuery(name = "Paac.findByFechaelaboracion", query = "SELECT p FROM Paac p WHERE p.fechaelaboracion = :fechaelaboracion"),
    @NamedQuery(name = "Paac.findByVersion", query = "SELECT p FROM Paac p WHERE p.version = :version"),
    @NamedQuery(name = "Paac.findByCorrelativomodificacion", query = "SELECT p FROM Paac p WHERE p.correlativomodificacion = :correlativomodificacion")})
public class Paac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EJERCICIOFISCAL")
    private String ejerciciofiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREINSTITUCION")
    private String nombreinstitucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAELABORACION")
    @Temporal(TemporalType.DATE)
    private Date fechaelaboracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private char version;
    @Column(name = "CORRELATIVOMODIFICACION")
    private Integer correlativomodificacion;
    @JoinColumn(name = "CODIGOINSTITUCION", referencedColumnName = "CODIGOINSTITUCION")
    @ManyToOne(optional = false)
    private Datosinstitucionales codigoinstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paac")
    private Collection<Detallepaac> detallepaacCollection;

    public Paac() {
    }

    public Paac(String ejerciciofiscal) {
        this.ejerciciofiscal = ejerciciofiscal;
    }

    public Paac(String ejerciciofiscal, String nombreinstitucion, Date fechaelaboracion, char version) {
        this.ejerciciofiscal = ejerciciofiscal;
        this.nombreinstitucion = nombreinstitucion;
        this.fechaelaboracion = fechaelaboracion;
        this.version = version;
    }

    public String getEjerciciofiscal() {
        return ejerciciofiscal;
    }

    public void setEjerciciofiscal(String ejerciciofiscal) {
        this.ejerciciofiscal = ejerciciofiscal;
    }

    public String getNombreinstitucion() {
        return nombreinstitucion;
    }

    public void setNombreinstitucion(String nombreinstitucion) {
        this.nombreinstitucion = nombreinstitucion;
    }

    public Date getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(Date fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public char getVersion() {
        return version;
    }

    public void setVersion(char version) {
        this.version = version;
    }

    public Integer getCorrelativomodificacion() {
        return correlativomodificacion;
    }

    public void setCorrelativomodificacion(Integer correlativomodificacion) {
        this.correlativomodificacion = correlativomodificacion;
    }

    public Datosinstitucionales getCodigoinstitucion() {
        return codigoinstitucion;
    }

    public void setCodigoinstitucion(Datosinstitucionales codigoinstitucion) {
        this.codigoinstitucion = codigoinstitucion;
    }

    @XmlTransient
    public Collection<Detallepaac> getDetallepaacCollection() {
        return detallepaacCollection;
    }

    public void setDetallepaacCollection(Collection<Detallepaac> detallepaacCollection) {
        this.detallepaacCollection = detallepaacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejerciciofiscal != null ? ejerciciofiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paac)) {
            return false;
        }
        Paac other = (Paac) object;
        if ((this.ejerciciofiscal == null && other.ejerciciofiscal != null) || (this.ejerciciofiscal != null && !this.ejerciciofiscal.equals(other.ejerciciofiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Paac[ ejerciciofiscal=" + ejerciciofiscal + " ]";
    }
    
}
