/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.jws.WebMethod;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chuchip
 */
@Entity
@Table(name = "locales")
@XmlRootElement
@JsonbPropertyOrder({"loc_codi", "loc_nomb"})
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l"),
    @NamedQuery(name = "Locales.findByLocCodi", query = "SELECT l FROM Locales l WHERE l.locCodi = :locCodi"),
    @NamedQuery(name = "Locales.findByLocNomb", query = "SELECT l FROM Locales l WHERE l.locNomb = :locNomb")})

public class Locales implements Serializable {
    public static final String FIND_ALL = "Locales.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "loc_codi")
    private String locCodi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "loc_nomb")
    private String locNomb;
    
    @JsonbTransient    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locCodi", fetch = FetchType.LAZY)
    private Collection<Paises> paisesCollection;

    public Locales() {
    }

    public Locales(String locCodi) {
        this.locCodi = locCodi;
    }

    public Locales(String locCodi, String locNomb) {
        this.locCodi = locCodi;
        this.locNomb = locNomb;
    }

    public String getLocCodi() {
        return locCodi;
    }

    public void setLocCodi(String locCodi) {
        this.locCodi = locCodi;
    }

    public String getLocNomb() {
        return locNomb;
    }

    public void setLocNomb(String locNomb) {
        this.locNomb = locNomb;
    }

     @JsonbTransient
    public Collection<Paises> getPaisesCollection() {
        return paisesCollection;
    }
    @JsonbTransient
    public void setPaisesCollection(Collection<Paises> paisesCollection) {
        this.paisesCollection = paisesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locCodi != null ? locCodi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locales)) {
            return false;
        }
        Locales other = (Locales) object;
        if ((this.locCodi == null && other.locCodi != null) || (this.locCodi != null && !this.locCodi.equals(other.locCodi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Locales[ locCodi=" + locCodi + " ]";
    }
    
}
