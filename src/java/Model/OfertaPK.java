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
public class OfertaPK implements Serializable {
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

    public OfertaPK() {
    }

    public OfertaPK(String nombreoferente, String codigoproceso) {
        this.nombreoferente = nombreoferente;
        this.codigoproceso = codigoproceso;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreoferente != null ? nombreoferente.hashCode() : 0);
        hash += (codigoproceso != null ? codigoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaPK)) {
            return false;
        }
        OfertaPK other = (OfertaPK) object;
        if ((this.nombreoferente == null && other.nombreoferente != null) || (this.nombreoferente != null && !this.nombreoferente.equals(other.nombreoferente))) {
            return false;
        }
        if ((this.codigoproceso == null && other.codigoproceso != null) || (this.codigoproceso != null && !this.codigoproceso.equals(other.codigoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OfertaPK[ nombreoferente=" + nombreoferente + ", codigoproceso=" + codigoproceso + " ]";
    }
    
}
