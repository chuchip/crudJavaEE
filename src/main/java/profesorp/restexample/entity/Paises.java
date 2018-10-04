/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author chuchip
 */
@Entity
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByPaiInic", query = "SELECT p FROM Paises p WHERE p.paiInic = :paiInic"),
    @NamedQuery(name = "Paises.findByPaiNomb", query = "SELECT p FROM Paises p WHERE p.paiNomb = :paiNomb"),
    @NamedQuery(name = "Paises.findByPaiNomcor", query = "SELECT p FROM Paises p WHERE p.paiNomcor = :paiNomcor"),
    @NamedQuery(name = "Paises.findByPaiActiv", query = "SELECT p FROM Paises p WHERE p.paiActiv = :paiActiv")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pai_inic")
    private String paiInic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pai_nomb")
    private String paiNomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "pai_nomcor")
    private String paiNomcor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pai_activ")
    private short paiActiv;
   
    
    @JoinColumn(name = "loc_codi", referencedColumnName = "loc_codi")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Locales locCodi;

    public Paises() {
    }

    public Paises(String paiInic) {
        this.paiInic = paiInic;
    }

    public Paises(String paiInic, String paiNomb, String paiNomcor, short paiActiv) {
        this.paiInic = paiInic;
        this.paiNomb = paiNomb;
        this.paiNomcor = paiNomcor;
        this.paiActiv = paiActiv;
    }

    public String getPaiInic() {
        return paiInic;
    }

    public void setPaiInic(String paiInic) {
        this.paiInic = paiInic;
    }

    public String getPaiNomb() {
        return paiNomb;
    }

    public void setPaiNomb(String paiNomb) {
        this.paiNomb = paiNomb;
    }

    public String getPaiNomcor() {
        return paiNomcor;
    }

    public void setPaiNomcor(String paiNomcor) {
        this.paiNomcor = paiNomcor;
    }

    public short getPaiActiv() {
        return paiActiv;
    }

    public void setPaiActiv(short paiActiv) {
        this.paiActiv = paiActiv;
    }

   

    public Locales getLocCodi() {
        return locCodi;
    }

    public void setLocCodi(Locales locCodi) {
        this.locCodi = locCodi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiInic != null ? paiInic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.paiInic == null && other.paiInic != null) || (this.paiInic != null && !this.paiInic.equals(other.paiInic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Paises[ paiInic=" + paiInic + " ]";
    }
    
}
