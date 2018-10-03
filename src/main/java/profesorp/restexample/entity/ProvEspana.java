/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chuchip
 */
@Entity
@Table(name = "prov_espana")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProvEspana.findAll", query = "SELECT p FROM ProvEspana p"),
    @NamedQuery(name = "ProvEspana.findByCopCodi", query = "SELECT p FROM ProvEspana p WHERE p.copCodi = :copCodi"),
    @NamedQuery(name = "ProvEspana.findByCopNombre", query = "SELECT p FROM ProvEspana p WHERE p.copNombre = :copNombre")})
public class ProvEspana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cop_codi")
    private String copCodi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cop_nombre")
    private String copNombre;

    public ProvEspana() {
    }

    public ProvEspana(String copCodi) {
        this.copCodi = copCodi;
    }

    public ProvEspana(String copCodi, String copNombre) {
        this.copCodi = copCodi;
        this.copNombre = copNombre;
    }

    public String getCopCodi() {
        return copCodi;
    }

    public void setCopCodi(String copCodi) {
        this.copCodi = copCodi;
    }

    public String getCopNombre() {
        return copNombre;
    }

    public void setCopNombre(String copNombre) {
        this.copNombre = copNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (copCodi != null ? copCodi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvEspana)) {
            return false;
        }
        ProvEspana other = (ProvEspana) object;
        if ((this.copCodi == null && other.copCodi != null) || (this.copCodi != null && !this.copCodi.equals(other.copCodi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.ProvEspana[ copCodi=" + copCodi + " ]";
    }
    
}
