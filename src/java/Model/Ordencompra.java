/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ORDENCOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o"),
    @NamedQuery(name = "Ordencompra.findByNoorden", query = "SELECT o FROM Ordencompra o WHERE o.noorden = :noorden"),
    @NamedQuery(name = "Ordencompra.findByFecha", query = "SELECT o FROM Ordencompra o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Ordencompra.findByNombresuministrante", query = "SELECT o FROM Ordencompra o WHERE o.nombresuministrante = :nombresuministrante"),
    @NamedQuery(name = "Ordencompra.findByNitsuministrante", query = "SELECT o FROM Ordencompra o WHERE o.nitsuministrante = :nitsuministrante"),
    @NamedQuery(name = "Ordencompra.findByDireccionsuministrante", query = "SELECT o FROM Ordencompra o WHERE o.direccionsuministrante = :direccionsuministrante"),
    @NamedQuery(name = "Ordencompra.findByMontototal", query = "SELECT o FROM Ordencompra o WHERE o.montototal = :montototal"),
    @NamedQuery(name = "Ordencompra.findByTotalletras", query = "SELECT o FROM Ordencompra o WHERE o.totalletras = :totalletras"),
    @NamedQuery(name = "Ordencompra.findByObservaciones", query = "SELECT o FROM Ordencompra o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "Ordencompra.findByLugarentrega", query = "SELECT o FROM Ordencompra o WHERE o.lugarentrega = :lugarentrega"),
    @NamedQuery(name = "Ordencompra.findByFechaentrega", query = "SELECT o FROM Ordencompra o WHERE o.fechaentrega = :fechaentrega"),
    @NamedQuery(name = "Ordencompra.findByNombreadminorden", query = "SELECT o FROM Ordencompra o WHERE o.nombreadminorden = :nombreadminorden"),
    @NamedQuery(name = "Ordencompra.findByTeladminorden", query = "SELECT o FROM Ordencompra o WHERE o.teladminorden = :teladminorden"),
    @NamedQuery(name = "Ordencompra.findByEmailadminorden", query = "SELECT o FROM Ordencompra o WHERE o.emailadminorden = :emailadminorden")})
public class Ordencompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOORDEN")
    private Integer noorden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRESUMINISTRANTE")
    private String nombresuministrante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "NITSUMINISTRANTE")
    private String nitsuministrante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCIONSUMINISTRANTE")
    private String direccionsuministrante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTOTOTAL")
    private BigDecimal montototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TOTALLETRAS")
    private String totalletras;
    @Size(max = 255)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LUGARENTREGA")
    private String lugarentrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date fechaentrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREADMINORDEN")
    private String nombreadminorden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELADMINORDEN")
    private String teladminorden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMAILADMINORDEN")
    private String emailadminorden;
    @JoinColumn(name = "CODIGOINSTITUCION", referencedColumnName = "CODIGOINSTITUCION")
    @ManyToOne(optional = false)
    private Datosinstitucionales codigoinstitucion;

    public Ordencompra() {
    }

    public Ordencompra(Integer noorden) {
        this.noorden = noorden;
    }

    public Ordencompra(Integer noorden, Date fecha, String nombresuministrante, String nitsuministrante, String direccionsuministrante, BigDecimal montototal, String totalletras, String lugarentrega, Date fechaentrega, String nombreadminorden, String teladminorden, String emailadminorden) {
        this.noorden = noorden;
        this.fecha = fecha;
        this.nombresuministrante = nombresuministrante;
        this.nitsuministrante = nitsuministrante;
        this.direccionsuministrante = direccionsuministrante;
        this.montototal = montototal;
        this.totalletras = totalletras;
        this.lugarentrega = lugarentrega;
        this.fechaentrega = fechaentrega;
        this.nombreadminorden = nombreadminorden;
        this.teladminorden = teladminorden;
        this.emailadminorden = emailadminorden;
    }

    public Integer getNoorden() {
        return noorden;
    }

    public void setNoorden(Integer noorden) {
        this.noorden = noorden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombresuministrante() {
        return nombresuministrante;
    }

    public void setNombresuministrante(String nombresuministrante) {
        this.nombresuministrante = nombresuministrante;
    }

    public String getNitsuministrante() {
        return nitsuministrante;
    }

    public void setNitsuministrante(String nitsuministrante) {
        this.nitsuministrante = nitsuministrante;
    }

    public String getDireccionsuministrante() {
        return direccionsuministrante;
    }

    public void setDireccionsuministrante(String direccionsuministrante) {
        this.direccionsuministrante = direccionsuministrante;
    }

    public BigDecimal getMontototal() {
        return montototal;
    }

    public void setMontototal(BigDecimal montototal) {
        this.montototal = montototal;
    }

    public String getTotalletras() {
        return totalletras;
    }

    public void setTotalletras(String totalletras) {
        this.totalletras = totalletras;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getLugarentrega() {
        return lugarentrega;
    }

    public void setLugarentrega(String lugarentrega) {
        this.lugarentrega = lugarentrega;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getNombreadminorden() {
        return nombreadminorden;
    }

    public void setNombreadminorden(String nombreadminorden) {
        this.nombreadminorden = nombreadminorden;
    }

    public String getTeladminorden() {
        return teladminorden;
    }

    public void setTeladminorden(String teladminorden) {
        this.teladminorden = teladminorden;
    }

    public String getEmailadminorden() {
        return emailadminorden;
    }

    public void setEmailadminorden(String emailadminorden) {
        this.emailadminorden = emailadminorden;
    }

    public Datosinstitucionales getCodigoinstitucion() {
        return codigoinstitucion;
    }

    public void setCodigoinstitucion(Datosinstitucionales codigoinstitucion) {
        this.codigoinstitucion = codigoinstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noorden != null ? noorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.noorden == null && other.noorden != null) || (this.noorden != null && !this.noorden.equals(other.noorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Ordencompra[ noorden=" + noorden + " ]";
    }
    
}
