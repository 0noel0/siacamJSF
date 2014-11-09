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
@Table(name = "DATOSINSTITUCIONALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosinstitucionales.findAll", query = "SELECT d FROM Datosinstitucionales d"),
    @NamedQuery(name = "Datosinstitucionales.findByCodigoinstitucion", query = "SELECT d FROM Datosinstitucionales d WHERE d.codigoinstitucion = :codigoinstitucion"),
    @NamedQuery(name = "Datosinstitucionales.findByNombreinstitucion", query = "SELECT d FROM Datosinstitucionales d WHERE d.nombreinstitucion = :nombreinstitucion"),
    @NamedQuery(name = "Datosinstitucionales.findByDireccioninstitucion", query = "SELECT d FROM Datosinstitucionales d WHERE d.direccioninstitucion = :direccioninstitucion")})
public class Datosinstitucionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOINSTITUCION")
    private String codigoinstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREINSTITUCION")
    private String nombreinstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCIONINSTITUCION")
    private String direccioninstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoinstitucion")
    private Collection<Listadonecesipaac> listadonecesipaacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoinstitucion")
    private Collection<Paac> paacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoinstitucion")
    private Collection<Ordencompra> ordencompraCollection;

    public Datosinstitucionales() {
    }

    public Datosinstitucionales(String codigoinstitucion) {
        this.codigoinstitucion = codigoinstitucion;
    }

    public Datosinstitucionales(String codigoinstitucion, String nombreinstitucion, String direccioninstitucion) {
        this.codigoinstitucion = codigoinstitucion;
        this.nombreinstitucion = nombreinstitucion;
        this.direccioninstitucion = direccioninstitucion;
    }

    public String getCodigoinstitucion() {
        return codigoinstitucion;
    }

    public void setCodigoinstitucion(String codigoinstitucion) {
        this.codigoinstitucion = codigoinstitucion;
    }

    public String getNombreinstitucion() {
        return nombreinstitucion;
    }

    public void setNombreinstitucion(String nombreinstitucion) {
        this.nombreinstitucion = nombreinstitucion;
    }

    public String getDireccioninstitucion() {
        return direccioninstitucion;
    }

    public void setDireccioninstitucion(String direccioninstitucion) {
        this.direccioninstitucion = direccioninstitucion;
    }

    @XmlTransient
    public Collection<Listadonecesipaac> getListadonecesipaacCollection() {
        return listadonecesipaacCollection;
    }

    public void setListadonecesipaacCollection(Collection<Listadonecesipaac> listadonecesipaacCollection) {
        this.listadonecesipaacCollection = listadonecesipaacCollection;
    }

    @XmlTransient
    public Collection<Paac> getPaacCollection() {
        return paacCollection;
    }

    public void setPaacCollection(Collection<Paac> paacCollection) {
        this.paacCollection = paacCollection;
    }

    @XmlTransient
    public Collection<Ordencompra> getOrdencompraCollection() {
        return ordencompraCollection;
    }

    public void setOrdencompraCollection(Collection<Ordencompra> ordencompraCollection) {
        this.ordencompraCollection = ordencompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoinstitucion != null ? codigoinstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosinstitucionales)) {
            return false;
        }
        Datosinstitucionales other = (Datosinstitucionales) object;
        if ((this.codigoinstitucion == null && other.codigoinstitucion != null) || (this.codigoinstitucion != null && !this.codigoinstitucion.equals(other.codigoinstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Datosinstitucionales[ codigoinstitucion=" + codigoinstitucion + " ]";
    }
    
}
