/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noel
 */
@Entity
@Table(name = "ADENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adenda.findAll", query = "SELECT a FROM Adenda a"),
    @NamedQuery(name = "Adenda.findByCodigoproceso", query = "SELECT a FROM Adenda a WHERE a.adendaPK.codigoproceso = :codigoproceso"),
    @NamedQuery(name = "Adenda.findByNocorrelativo", query = "SELECT a FROM Adenda a WHERE a.adendaPK.nocorrelativo = :nocorrelativo"),
    @NamedQuery(name = "Adenda.findByTextobases", query = "SELECT a FROM Adenda a WHERE a.textobases = :textobases"),
    @NamedQuery(name = "Adenda.findByOperacion", query = "SELECT a FROM Adenda a WHERE a.operacion = :operacion")})
public class Adenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdendaPK adendaPK;
    @Size(max = 50)
    @Column(name = "TEXTOBASES")
    private String textobases;
    @Size(max = 50)
    @Column(name = "OPERACION")
    private String operacion;
    @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Expedienteproceso expedienteproceso;

    public Adenda() {
    }

    public Adenda(AdendaPK adendaPK) {
        this.adendaPK = adendaPK;
    }

    public Adenda(String codigoproceso, int nocorrelativo) {
        this.adendaPK = new AdendaPK(codigoproceso, nocorrelativo);
    }

    public AdendaPK getAdendaPK() {
        return adendaPK;
    }

    public void setAdendaPK(AdendaPK adendaPK) {
        this.adendaPK = adendaPK;
    }

    public String getTextobases() {
        return textobases;
    }

    public void setTextobases(String textobases) {
        this.textobases = textobases;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Expedienteproceso getExpedienteproceso() {
        return expedienteproceso;
    }

    public void setExpedienteproceso(Expedienteproceso expedienteproceso) {
        this.expedienteproceso = expedienteproceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adendaPK != null ? adendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adenda)) {
            return false;
        }
        Adenda other = (Adenda) object;
        if ((this.adendaPK == null && other.adendaPK != null) || (this.adendaPK != null && !this.adendaPK.equals(other.adendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Adenda[ adendaPK=" + adendaPK + " ]";
    }
    
}
