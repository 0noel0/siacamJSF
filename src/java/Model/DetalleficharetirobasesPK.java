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
public class DetalleficharetirobasesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOCORRELATIVO")
    private int nocorrelativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODIGOPROCESO")
    private String codigoproceso;

    public DetalleficharetirobasesPK() {
    }

    public DetalleficharetirobasesPK(int nocorrelativo, String codigoproceso) {
        this.nocorrelativo = nocorrelativo;
        this.codigoproceso = codigoproceso;
    }

    public int getNocorrelativo() {
        return nocorrelativo;
    }

    public void setNocorrelativo(int nocorrelativo) {
        this.nocorrelativo = nocorrelativo;
    }

    public String getCodigoproceso() {
        return codigoproceso;
    }

    public void setCodigoproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nocorrelativo;
        hash += (codigoproceso != null ? codigoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleficharetirobasesPK)) {
            return false;
        }
        DetalleficharetirobasesPK other = (DetalleficharetirobasesPK) object;
        if (this.nocorrelativo != other.nocorrelativo) {
            return false;
        }
        if ((this.codigoproceso == null && other.codigoproceso != null) || (this.codigoproceso != null && !this.codigoproceso.equals(other.codigoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DetalleficharetirobasesPK[ nocorrelativo=" + nocorrelativo + ", codigoproceso=" + codigoproceso + " ]";
    }
    
}
