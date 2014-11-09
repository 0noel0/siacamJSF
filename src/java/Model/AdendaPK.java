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
public class AdendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODIGOPROCESO")
    private String codigoproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOCORRELATIVO")
    private int nocorrelativo;

    public AdendaPK() {
    }

    public AdendaPK(String codigoproceso, int nocorrelativo) {
        this.codigoproceso = codigoproceso;
        this.nocorrelativo = nocorrelativo;
    }

    public String getCodigoproceso() {
        return codigoproceso;
    }

    public void setCodigoproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
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
        hash += (codigoproceso != null ? codigoproceso.hashCode() : 0);
        hash += (int) nocorrelativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdendaPK)) {
            return false;
        }
        AdendaPK other = (AdendaPK) object;
        if ((this.codigoproceso == null && other.codigoproceso != null) || (this.codigoproceso != null && !this.codigoproceso.equals(other.codigoproceso))) {
            return false;
        }
        if (this.nocorrelativo != other.nocorrelativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AdendaPK[ codigoproceso=" + codigoproceso + ", nocorrelativo=" + nocorrelativo + " ]";
    }
    
}
