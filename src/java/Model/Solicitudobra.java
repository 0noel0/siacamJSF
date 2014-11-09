/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SOLICITUDOBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudobra.findAll", query = "SELECT s FROM Solicitudobra s"),
    @NamedQuery(name = "Solicitudobra.findByFecha", query = "SELECT s FROM Solicitudobra s WHERE s.solicitudobraPK.fecha = :fecha"),
    @NamedQuery(name = "Solicitudobra.findByNombresolicitante", query = "SELECT s FROM Solicitudobra s WHERE s.solicitudobraPK.nombresolicitante = :nombresolicitante"),
    @NamedQuery(name = "Solicitudobra.findByCargosolicitante", query = "SELECT s FROM Solicitudobra s WHERE s.cargosolicitante = :cargosolicitante"),
    @NamedQuery(name = "Solicitudobra.findByDependenciasolicitante", query = "SELECT s FROM Solicitudobra s WHERE s.dependenciasolicitante = :dependenciasolicitante"),
    @NamedQuery(name = "Solicitudobra.findByNombreautorizante", query = "SELECT s FROM Solicitudobra s WHERE s.nombreautorizante = :nombreautorizante"),
    @NamedQuery(name = "Solicitudobra.findByCargoautorizante", query = "SELECT s FROM Solicitudobra s WHERE s.cargoautorizante = :cargoautorizante"),
    @NamedQuery(name = "Solicitudobra.findByDependenciaautorizante", query = "SELECT s FROM Solicitudobra s WHERE s.dependenciaautorizante = :dependenciaautorizante"),
    @NamedQuery(name = "Solicitudobra.findByJustificacion", query = "SELECT s FROM Solicitudobra s WHERE s.justificacion = :justificacion"),
    @NamedQuery(name = "Solicitudobra.findByValorestimado", query = "SELECT s FROM Solicitudobra s WHERE s.valorestimado = :valorestimado"),
    @NamedQuery(name = "Solicitudobra.findByFormaentrega", query = "SELECT s FROM Solicitudobra s WHERE s.formaentrega = :formaentrega"),
    @NamedQuery(name = "Solicitudobra.findByLugarentrega", query = "SELECT s FROM Solicitudobra s WHERE s.lugarentrega = :lugarentrega"),
    @NamedQuery(name = "Solicitudobra.findByOtrascondiciones", query = "SELECT s FROM Solicitudobra s WHERE s.otrascondiciones = :otrascondiciones"),
    @NamedQuery(name = "Solicitudobra.findByObservaciones", query = "SELECT s FROM Solicitudobra s WHERE s.observaciones = :observaciones"),
    @NamedQuery(name = "Solicitudobra.findByNombreadmcontrato", query = "SELECT s FROM Solicitudobra s WHERE s.nombreadmcontrato = :nombreadmcontrato"),
    @NamedQuery(name = "Solicitudobra.findByCargoadmincontrato", query = "SELECT s FROM Solicitudobra s WHERE s.cargoadmincontrato = :cargoadmincontrato"),
    @NamedQuery(name = "Solicitudobra.findByDependenciaadmincontrato", query = "SELECT s FROM Solicitudobra s WHERE s.dependenciaadmincontrato = :dependenciaadmincontrato")})
public class Solicitudobra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudobraPK solicitudobraPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CARGOSOLICITANTE")
    private String cargosolicitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DEPENDENCIASOLICITANTE")
    private String dependenciasolicitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREAUTORIZANTE")
    private String nombreautorizante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CARGOAUTORIZANTE")
    private String cargoautorizante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DEPENDENCIAAUTORIZANTE")
    private String dependenciaautorizante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "JUSTIFICACION")
    private String justificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORESTIMADO")
    private BigDecimal valorestimado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FORMAENTREGA")
    private String formaentrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "LUGARENTREGA")
    private String lugarentrega;
    @Size(max = 100)
    @Column(name = "OTRASCONDICIONES")
    private String otrascondiciones;
    @Size(max = 255)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREADMCONTRATO")
    private String nombreadmcontrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CARGOADMINCONTRATO")
    private String cargoadmincontrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DEPENDENCIAADMINCONTRATO")
    private String dependenciaadmincontrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudobra")
    private Collection<Detallesolicitudobra> detallesolicitudobraCollection;

    public Solicitudobra() {
    }

    public Solicitudobra(SolicitudobraPK solicitudobraPK) {
        this.solicitudobraPK = solicitudobraPK;
    }

    public Solicitudobra(SolicitudobraPK solicitudobraPK, String cargosolicitante, String dependenciasolicitante, String nombreautorizante, String cargoautorizante, String dependenciaautorizante, String justificacion, BigDecimal valorestimado, String formaentrega, String lugarentrega, String nombreadmcontrato, String cargoadmincontrato, String dependenciaadmincontrato) {
        this.solicitudobraPK = solicitudobraPK;
        this.cargosolicitante = cargosolicitante;
        this.dependenciasolicitante = dependenciasolicitante;
        this.nombreautorizante = nombreautorizante;
        this.cargoautorizante = cargoautorizante;
        this.dependenciaautorizante = dependenciaautorizante;
        this.justificacion = justificacion;
        this.valorestimado = valorestimado;
        this.formaentrega = formaentrega;
        this.lugarentrega = lugarentrega;
        this.nombreadmcontrato = nombreadmcontrato;
        this.cargoadmincontrato = cargoadmincontrato;
        this.dependenciaadmincontrato = dependenciaadmincontrato;
    }

    public Solicitudobra(Date fecha, String nombresolicitante) {
        this.solicitudobraPK = new SolicitudobraPK(fecha, nombresolicitante);
    }

    public SolicitudobraPK getSolicitudobraPK() {
        return solicitudobraPK;
    }

    public void setSolicitudobraPK(SolicitudobraPK solicitudobraPK) {
        this.solicitudobraPK = solicitudobraPK;
    }

    public String getCargosolicitante() {
        return cargosolicitante;
    }

    public void setCargosolicitante(String cargosolicitante) {
        this.cargosolicitante = cargosolicitante;
    }

    public String getDependenciasolicitante() {
        return dependenciasolicitante;
    }

    public void setDependenciasolicitante(String dependenciasolicitante) {
        this.dependenciasolicitante = dependenciasolicitante;
    }

    public String getNombreautorizante() {
        return nombreautorizante;
    }

    public void setNombreautorizante(String nombreautorizante) {
        this.nombreautorizante = nombreautorizante;
    }

    public String getCargoautorizante() {
        return cargoautorizante;
    }

    public void setCargoautorizante(String cargoautorizante) {
        this.cargoautorizante = cargoautorizante;
    }

    public String getDependenciaautorizante() {
        return dependenciaautorizante;
    }

    public void setDependenciaautorizante(String dependenciaautorizante) {
        this.dependenciaautorizante = dependenciaautorizante;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public BigDecimal getValorestimado() {
        return valorestimado;
    }

    public void setValorestimado(BigDecimal valorestimado) {
        this.valorestimado = valorestimado;
    }

    public String getFormaentrega() {
        return formaentrega;
    }

    public void setFormaentrega(String formaentrega) {
        this.formaentrega = formaentrega;
    }

    public String getLugarentrega() {
        return lugarentrega;
    }

    public void setLugarentrega(String lugarentrega) {
        this.lugarentrega = lugarentrega;
    }

    public String getOtrascondiciones() {
        return otrascondiciones;
    }

    public void setOtrascondiciones(String otrascondiciones) {
        this.otrascondiciones = otrascondiciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreadmcontrato() {
        return nombreadmcontrato;
    }

    public void setNombreadmcontrato(String nombreadmcontrato) {
        this.nombreadmcontrato = nombreadmcontrato;
    }

    public String getCargoadmincontrato() {
        return cargoadmincontrato;
    }

    public void setCargoadmincontrato(String cargoadmincontrato) {
        this.cargoadmincontrato = cargoadmincontrato;
    }

    public String getDependenciaadmincontrato() {
        return dependenciaadmincontrato;
    }

    public void setDependenciaadmincontrato(String dependenciaadmincontrato) {
        this.dependenciaadmincontrato = dependenciaadmincontrato;
    }

    @XmlTransient
    public Collection<Detallesolicitudobra> getDetallesolicitudobraCollection() {
        return detallesolicitudobraCollection;
    }

    public void setDetallesolicitudobraCollection(Collection<Detallesolicitudobra> detallesolicitudobraCollection) {
        this.detallesolicitudobraCollection = detallesolicitudobraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudobraPK != null ? solicitudobraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudobra)) {
            return false;
        }
        Solicitudobra other = (Solicitudobra) object;
        if ((this.solicitudobraPK == null && other.solicitudobraPK != null) || (this.solicitudobraPK != null && !this.solicitudobraPK.equals(other.solicitudobraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Solicitudobra[ solicitudobraPK=" + solicitudobraPK + " ]";
    }
    
}
