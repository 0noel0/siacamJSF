/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author noel
 */
@Embeddable
public class DetallepaacPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EJERCICIOFISCAL")
    private String ejerciciofiscal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOCORRELATIVO")
    private int nocorrelativo;

    public DetallepaacPK() {
    }

    public DetallepaacPK(String ejerciciofiscal, int nocorrelativo) {
        this.ejerciciofiscal = ejerciciofiscal;
        this.nocorrelativo = nocorrelativo;
    }

    public String getEjerciciofiscal() {
        return ejerciciofiscal;
    }

    public void setEjerciciofiscal(String ejerciciofiscal) {
        this.ejerciciofiscal = ejerciciofiscal;
    }

    public int getNocorrelativo() {
        return nocorrelativo;
    }

    public void setNocorrelativo(int nocorrelativo) {
        this.nocorrelativo = nocorrelativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejerciciofiscal != null ? ejerciciofiscal.hashCode() : 0);
        hash += (int) nocorrelativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallepaacPK)) {
            return false;
        }
        DetallepaacPK other = (DetallepaacPK) object;
        if ((this.ejerciciofiscal == null && other.ejerciciofiscal != null) || (this.ejerciciofiscal != null && !this.ejerciciofiscal.equals(other.ejerciciofiscal))) {
            return false;
        }
        if (this.nocorrelativo != other.nocorrelativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DetallepaacPK[ ejerciciofiscal=" + ejerciciofiscal + ", nocorrelativo=" + nocorrelativo + " ]";
    }
    
}
