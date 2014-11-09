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
import javax.persistence.JoinColumns;
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
@Table(name = "DETALLESOLICITUDOBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesolicitudobra.findAll", query = "SELECT d FROM Detallesolicitudobra d"),
    @NamedQuery(name = "Detallesolicitudobra.findByItem", query = "SELECT d FROM Detallesolicitudobra d WHERE d.detallesolicitudobraPK.item = :item"),
    @NamedQuery(name = "Detallesolicitudobra.findByFecha", query = "SELECT d FROM Detallesolicitudobra d WHERE d.detallesolicitudobraPK.fecha = :fecha"),
    @NamedQuery(name = "Detallesolicitudobra.findByNombresolicitante", query = "SELECT d FROM Detallesolicitudobra d WHERE d.detallesolicitudobraPK.nombresolicitante = :nombresolicitante"),
    @NamedQuery(name = "Detallesolicitudobra.findByCantidad", query = "SELECT d FROM Detallesolicitudobra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallesolicitudobra.findByUnidadmedida", query = "SELECT d FROM Detallesolicitudobra d WHERE d.unidadmedida = :unidadmedida"),
    @NamedQuery(name = "Detallesolicitudobra.findByObrasolicitada", query = "SELECT d FROM Detallesolicitudobra d WHERE d.obrasolicitada = :obrasolicitada"),
    @NamedQuery(name = "Detallesolicitudobra.findByEspecifictecnicas", query = "SELECT d FROM Detallesolicitudobra d WHERE d.especifictecnicas = :especifictecnicas")})
public class Detallesolicitudobra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesolicitudobraPK detallesolicitudobraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "UNIDADMEDIDA")
    private String unidadmedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "OBRASOLICITADA")
    private String obrasolicitada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ESPECIFICTECNICAS")
    private String especifictecnicas;
    @JoinColumn(name = "CODIGOUNSPSC", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Unspsc codigounspsc;
    @JoinColumns({
        @JoinColumn(name = "FECHA", referencedColumnName = "FECHA", insertable = false, updatable = false),
        @JoinColumn(name = "NOMBRESOLICITANTE", referencedColumnName = "NOMBRESOLICITANTE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Solicitudobra solicitudobra;

    public Detallesolicitudobra() {
    }

    public Detallesolicitudobra(DetallesolicitudobraPK detallesolicitudobraPK) {
        this.detallesolicitudobraPK = detallesolicitudobraPK;
    }

    public Detallesolicitudobra(DetallesolicitudobraPK detallesolicitudobraPK, int cantidad, String unidadmedida, String obrasolicitada, String especifictecnicas) {
        this.detallesolicitudobraPK = detallesolicitudobraPK;
        this.cantidad = cantidad;
        this.unidadmedida = unidadmedida;
        this.obrasolicitada = obrasolicitada;
        this.especifictecnicas = especifictecnicas;
    }

    public Detallesolicitudobra(int item, Date fecha, String nombresolicitante) {
        this.detallesolicitudobraPK = new DetallesolicitudobraPK(item, fecha, nombresolicitante);
    }

    public DetallesolicitudobraPK getDetallesolicitudobraPK() {
        return detallesolicitudobraPK;
    }

    public void setDetallesolicitudobraPK(DetallesolicitudobraPK detallesolicitudobraPK) {
        this.detallesolicitudobraPK = detallesolicitudobraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getObrasolicitada() {
        return obrasolicitada;
    }

    public void setObrasolicitada(String obrasolicitada) {
        this.obrasolicitada = obrasolicitada;
    }

    public String getEspecifictecnicas() {
        return especifictecnicas;
    }

    public void setEspecifictecnicas(String especifictecnicas) {
        this.especifictecnicas = especifictecnicas;
    }

    public Unspsc getCodigounspsc() {
        return codigounspsc;
    }

    public void setCodigounspsc(Unspsc codigounspsc) {
        this.codigounspsc = codigounspsc;
    }

    public Solicitudobra getSolicitudobra() {
        return solicitudobra;
    }

    public void setSolicitudobra(Solicitudobra solicitudobra) {
        this.solicitudobra = solicitudobra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesolicitudobraPK != null ? detallesolicitudobraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesolicitudobra)) {
            return false;
        }
        Detallesolicitudobra other = (Detallesolicitudobra) object;
        if ((this.detallesolicitudobraPK == null && other.detallesolicitudobraPK != null) || (this.detallesolicitudobraPK != null && !this.detallesolicitudobraPK.equals(other.detallesolicitudobraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detallesolicitudobra[ detallesolicitudobraPK=" + detallesolicitudobraPK + " ]";
    }
    
}
