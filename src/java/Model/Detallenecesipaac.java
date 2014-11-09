/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noel
 */
@Entity
@Table(name = "DETALLENECESIPAAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallenecesipaac.findAll", query = "SELECT d FROM Detallenecesipaac d"),
    @NamedQuery(name = "Detallenecesipaac.findByEjerciciofiscal", query = "SELECT d FROM Detallenecesipaac d WHERE d.detallenecesipaacPK.ejerciciofiscal = :ejerciciofiscal"),
    @NamedQuery(name = "Detallenecesipaac.findByNocorrelativo", query = "SELECT d FROM Detallenecesipaac d WHERE d.detallenecesipaacPK.nocorrelativo = :nocorrelativo"),
    @NamedQuery(name = "Detallenecesipaac.findByFuenterecurso", query = "SELECT d FROM Detallenecesipaac d WHERE d.fuenterecurso = :fuenterecurso"),
    @NamedQuery(name = "Detallenecesipaac.findByDescripcionunspsc", query = "SELECT d FROM Detallenecesipaac d WHERE d.descripcionunspsc = :descripcionunspsc"),
    @NamedQuery(name = "Detallenecesipaac.findByCantidadproyectada", query = "SELECT d FROM Detallenecesipaac d WHERE d.cantidadproyectada = :cantidadproyectada"),
    @NamedQuery(name = "Detallenecesipaac.findByUnidadmedida", query = "SELECT d FROM Detallenecesipaac d WHERE d.unidadmedida = :unidadmedida"),
    @NamedQuery(name = "Detallenecesipaac.findByPreciounitario", query = "SELECT d FROM Detallenecesipaac d WHERE d.preciounitario = :preciounitario"),
    @NamedQuery(name = "Detallenecesipaac.findByPreciototal", query = "SELECT d FROM Detallenecesipaac d WHERE d.preciototal = :preciototal"),
    @NamedQuery(name = "Detallenecesipaac.findByMesesperado", query = "SELECT d FROM Detallenecesipaac d WHERE d.mesesperado = :mesesperado")})
public class Detallenecesipaac implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallenecesipaacPK detallenecesipaacPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FUENTERECURSO")
    private String fuenterecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCIONUNSPSC")
    private String descripcionunspsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDADPROYECTADA")
    private int cantidadproyectada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "UNIDADMEDIDA")
    private String unidadmedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOUNITARIO")
    private BigDecimal preciounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTAL")
    private BigDecimal preciototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MESESPERADO")
    private String mesesperado;
    @JoinColumn(name = "CODIGOUNSPSC", referencedColumnName = "CODIGO")
    @ManyToOne
    private Unspsc codigounspsc;
    @JoinColumn(name = "EJERCICIOFISCAL", referencedColumnName = "EJERCICIOFISCAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Listadonecesipaac listadonecesipaac;

    public Detallenecesipaac() {
    }

    public Detallenecesipaac(DetallenecesipaacPK detallenecesipaacPK) {
        this.detallenecesipaacPK = detallenecesipaacPK;
    }

    public Detallenecesipaac(DetallenecesipaacPK detallenecesipaacPK, String fuenterecurso, String descripcionunspsc, int cantidadproyectada, String unidadmedida, BigDecimal preciounitario, BigDecimal preciototal, String mesesperado) {
        this.detallenecesipaacPK = detallenecesipaacPK;
        this.fuenterecurso = fuenterecurso;
        this.descripcionunspsc = descripcionunspsc;
        this.cantidadproyectada = cantidadproyectada;
        this.unidadmedida = unidadmedida;
        this.preciounitario = preciounitario;
        this.preciototal = preciototal;
        this.mesesperado = mesesperado;
    }

    public Detallenecesipaac(String ejerciciofiscal, int nocorrelativo) {
        this.detallenecesipaacPK = new DetallenecesipaacPK(ejerciciofiscal, nocorrelativo);
    }

    public DetallenecesipaacPK getDetallenecesipaacPK() {
        return detallenecesipaacPK;
    }

    public void setDetallenecesipaacPK(DetallenecesipaacPK detallenecesipaacPK) {
        this.detallenecesipaacPK = detallenecesipaacPK;
    }

    public String getFuenterecurso() {
        return fuenterecurso;
    }

    public void setFuenterecurso(String fuenterecurso) {
        this.fuenterecurso = fuenterecurso;
    }

    public String getDescripcionunspsc() {
        return descripcionunspsc;
    }

    public void setDescripcionunspsc(String descripcionunspsc) {
        this.descripcionunspsc = descripcionunspsc;
    }

    public int getCantidadproyectada() {
        return cantidadproyectada;
    }

    public void setCantidadproyectada(int cantidadproyectada) {
        this.cantidadproyectada = cantidadproyectada;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigDecimal getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(BigDecimal preciototal) {
        this.preciototal = preciototal;
    }

    public String getMesesperado() {
        return mesesperado;
    }

    public void setMesesperado(String mesesperado) {
        this.mesesperado = mesesperado;
    }

    public Unspsc getCodigounspsc() {
        return codigounspsc;
    }

    public void setCodigounspsc(Unspsc codigounspsc) {
        this.codigounspsc = codigounspsc;
    }

    public Listadonecesipaac getListadonecesipaac() {
        return listadonecesipaac;
    }

    public void setListadonecesipaac(Listadonecesipaac listadonecesipaac) {
        this.listadonecesipaac = listadonecesipaac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallenecesipaacPK != null ? detallenecesipaacPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallenecesipaac)) {
            return false;
        }
        Detallenecesipaac other = (Detallenecesipaac) object;
        if ((this.detallenecesipaacPK == null && other.detallenecesipaacPK != null) || (this.detallenecesipaacPK != null && !this.detallenecesipaacPK.equals(other.detallenecesipaacPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detallenecesipaac[ detallenecesipaacPK=" + detallenecesipaacPK + " ]";
    }
    
}
