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
public class DetalleofertaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREOFERENTE")
    private String nombreoferente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CODIGOPROCESO")
    private String codigoproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RUBRO")
    private String rubro;

    public DetalleofertaPK() {
    }

    public DetalleofertaPK(String nombreoferente, String codigoproceso, String rubro) {
        this.nombreoferente = nombreoferente;
        this.codigoproceso = codigoproceso;
        this.rubro = rubro;
    }

    public String getNombreoferente() {
        return nombreoferente;
    }

    public void setNombreoferente(String nombreoferente) {
        this.nombreoferente = nombreoferente;
    }

    public String getCodigoproceso() {
        return codigoproceso;
    }

    public void setCodigoproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreoferente != null ? nombreoferente.hashCode() : 0);
        hash += (codigoproceso != null ? codigoproceso.hashCode() : 0);
        hash += (rubro != null ? rubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleofertaPK)) {
            return false;
        }
        DetalleofertaPK other = (DetalleofertaPK) object;
        if ((this.nombreoferente == null && other.nombreoferente != null) || (this.nombreoferente != null && !this.nombreoferente.equals(other.nombreoferente))) {
            return false;
        }
        if ((this.codigoproceso == null && other.codigoproceso != null) || (this.codigoproceso != null && !this.codigoproceso.equals(other.codigoproceso))) {
            return false;
        }
        if ((this.rubro == null && other.rubro != null) || (this.rubro != null && !this.rubro.equals(other.rubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DetalleofertaPK[ nombreoferente=" + nombreoferente + ", codigoproceso=" + codigoproceso + ", rubro=" + rubro + " ]";
    }
    
}
