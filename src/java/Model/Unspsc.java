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
@Table(name = "UNSPSC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unspsc.findAll", query = "SELECT u FROM Unspsc u"),
    @NamedQuery(name = "Unspsc.findByCodigo", query = "SELECT u FROM Unspsc u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Unspsc.findByDescripcion", query = "SELECT u FROM Unspsc u WHERE u.descripcion = :descripcion")})
public class Unspsc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigounspsc")
    private Collection<Detallesolicitudobra> detallesolicitudobraCollection;
    @OneToMany(mappedBy = "codigounspsc")
    private Collection<Detallenecesipaac> detallenecesipaacCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigounspsc")
    private Collection<Detallepaac> detallepaacCollection;

    public Unspsc() {
    }

    public Unspsc(String codigo) {
        this.codigo = codigo;
    }

    public Unspsc(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Detallesolicitudobra> getDetallesolicitudobraCollection() {
        return detallesolicitudobraCollection;
    }

    public void setDetallesolicitudobraCollection(Collection<Detallesolicitudobra> detallesolicitudobraCollection) {
        this.detallesolicitudobraCollection = detallesolicitudobraCollection;
    }

    @XmlTransient
    public Collection<Detallenecesipaac> getDetallenecesipaacCollection() {
        return detallenecesipaacCollection;
    }

    public void setDetallenecesipaacCollection(Collection<Detallenecesipaac> detallenecesipaacCollection) {
        this.detallenecesipaacCollection = detallenecesipaacCollection;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unspsc)) {
            return false;
        }
        Unspsc other = (Unspsc) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Unspsc[ codigo=" + codigo + " ]";
    }
    
}
