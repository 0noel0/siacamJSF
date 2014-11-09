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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author noel
 */
@Embeddable
public class DetallesolicitudobraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM")
    private int item;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRESOLICITANTE")
    private String nombresolicitante;

    public DetallesolicitudobraPK() {
    }

    public DetallesolicitudobraPK(int item, Date fecha, String nombresolicitante) {
        this.item = item;
        this.fecha = fecha;
        this.nombresolicitante = nombresolicitante;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombresolicitante() {
        return nombresolicitante;
    }

    public void setNombresolicitante(String nombresolicitante) {
        this.nombresolicitante = nombresolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) item;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (nombresolicitante != null ? nombresolicitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesolicitudobraPK)) {
            return false;
        }
        DetallesolicitudobraPK other = (DetallesolicitudobraPK) object;
        if (this.item != other.item) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.nombresolicitante == null && other.nombresolicitante != null) || (this.nombresolicitante != null && !this.nombresolicitante.equals(other.nombresolicitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DetallesolicitudobraPK[ item=" + item + ", fecha=" + fecha + ", nombresolicitante=" + nombresolicitante + " ]";
    }
    
}
