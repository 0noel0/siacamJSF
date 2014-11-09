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
@Table(name = "DETALLEPAAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepaac.findAll", query = "SELECT d FROM Detallepaac d"),
    @NamedQuery(name = "Detallepaac.findByEjerciciofiscal", query = "SELECT d FROM Detallepaac d WHERE d.detallepaacPK.ejerciciofiscal = :ejerciciofiscal"),
    @NamedQuery(name = "Detallepaac.findByNocorrelativo", query = "SELECT d FROM Detallepaac d WHERE d.detallepaacPK.nocorrelativo = :nocorrelativo"),
    @NamedQuery(name = "Detallepaac.findByFuenterecurso", query = "SELECT d FROM Detallepaac d WHERE d.fuenterecurso = :fuenterecurso"),
    @NamedQuery(name = "Detallepaac.findByFormacontratacion", query = "SELECT d FROM Detallepaac d WHERE d.formacontratacion = :formacontratacion"),
    @NamedQuery(name = "Detallepaac.findByNombreprelimproceso", query = "SELECT d FROM Detallepaac d WHERE d.nombreprelimproceso = :nombreprelimproceso"),
    @NamedQuery(name = "Detallepaac.findByDescripcionunspsc", query = "SELECT d FROM Detallepaac d WHERE d.descripcionunspsc = :descripcionunspsc"),
    @NamedQuery(name = "Detallepaac.findByCodigoobjetopres", query = "SELECT d FROM Detallepaac d WHERE d.codigoobjetopres = :codigoobjetopres"),
    @NamedQuery(name = "Detallepaac.findByMesestimado", query = "SELECT d FROM Detallepaac d WHERE d.mesestimado = :mesestimado"),
    @NamedQuery(name = "Detallepaac.findByMontopresupuestado", query = "SELECT d FROM Detallepaac d WHERE d.montopresupuestado = :montopresupuestado")})
public class Detallepaac implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallepaacPK detallepaacPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FUENTERECURSO")
    private String fuenterecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FORMACONTRATACION")
    private String formacontratacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREPRELIMPROCESO")
    private String nombreprelimproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCIONUNSPSC")
    private String descripcionunspsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOOBJETOPRES")
    private String codigoobjetopres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MESESTIMADO")
    private String mesestimado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOPRESUPUESTADO")
    private BigDecimal montopresupuestado;
    @JoinColumn(name = "CODIGOUNSPSC", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Unspsc codigounspsc;
    @JoinColumn(name = "EJERCICIOFISCAL", referencedColumnName = "EJERCICIOFISCAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paac paac;

    public Detallepaac() {
    }

    public Detallepaac(DetallepaacPK detallepaacPK) {
        this.detallepaacPK = detallepaacPK;
    }

    public Detallepaac(DetallepaacPK detallepaacPK, String fuenterecurso, String formacontratacion, String nombreprelimproceso, String descripcionunspsc, String codigoobjetopres, String mesestimado, BigDecimal montopresupuestado) {
        this.detallepaacPK = detallepaacPK;
        this.fuenterecurso = fuenterecurso;
        this.formacontratacion = formacontratacion;
        this.nombreprelimproceso = nombreprelimproceso;
        this.descripcionunspsc = descripcionunspsc;
        this.codigoobjetopres = codigoobjetopres;
        this.mesestimado = mesestimado;
        this.montopresupuestado = montopresupuestado;
    }

    public Detallepaac(String ejerciciofiscal, int nocorrelativo) {
        this.detallepaacPK = new DetallepaacPK(ejerciciofiscal, nocorrelativo);
    }

    public DetallepaacPK getDetallepaacPK() {
        return detallepaacPK;
    }

    public void setDetallepaacPK(DetallepaacPK detallepaacPK) {
        this.detallepaacPK = detallepaacPK;
    }

    public String getFuenterecurso() {
        return fuenterecurso;
    }

    public void setFuenterecurso(String fuenterecurso) {
        this.fuenterecurso = fuenterecurso;
    }

    public String getFormacontratacion() {
        return formacontratacion;
    }

    public void setFormacontratacion(String formacontratacion) {
        this.formacontratacion = formacontratacion;
    }

    public String getNombreprelimproceso() {
        return nombreprelimproceso;
    }

    public void setNombreprelimproceso(String nombreprelimproceso) {
        this.nombreprelimproceso = nombreprelimproceso;
    }

    public String getDescripcionunspsc() {
        return descripcionunspsc;
    }

    public void setDescripcionunspsc(String descripcionunspsc) {
        this.descripcionunspsc = descripcionunspsc;
    }

    public String getCodigoobjetopres() {
        return codigoobjetopres;
    }

    public void setCodigoobjetopres(String codigoobjetopres) {
        this.codigoobjetopres = codigoobjetopres;
    }

    public String getMesestimado() {
        return mesestimado;
    }

    public void setMesestimado(String mesestimado) {
        this.mesestimado = mesestimado;
    }

    public BigDecimal getMontopresupuestado() {
        return montopresupuestado;
    }

    public void setMontopresupuestado(BigDecimal montopresupuestado) {
        this.montopresupuestado = montopresupuestado;
    }

    public Unspsc getCodigounspsc() {
        return codigounspsc;
    }

    public void setCodigounspsc(Unspsc codigounspsc) {
        this.codigounspsc = codigounspsc;
    }

    public Paac getPaac() {
        return paac;
    }

    public void setPaac(Paac paac) {
        this.paac = paac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallepaacPK != null ? detallepaacPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepaac)) {
            return false;
        }
        Detallepaac other = (Detallepaac) object;
        if ((this.detallepaacPK == null && other.detallepaacPK != null) || (this.detallepaacPK != null && !this.detallepaacPK.equals(other.detallepaacPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detallepaac[ detallepaacPK=" + detallepaacPK + " ]";
    }
    
}
