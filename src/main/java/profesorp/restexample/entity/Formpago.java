/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chuchip
 */
@Entity
@Table(name = "formpago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formpago.findAll", query = "SELECT f FROM Formpago f"),
    @NamedQuery(name = "Formpago.findByFpaCodi", query = "SELECT f FROM Formpago f WHERE f.fpaCodi = :fpaCodi"),
    @NamedQuery(name = "Formpago.findByFpaNomb", query = "SELECT f FROM Formpago f WHERE f.fpaNomb = :fpaNomb"),
    @NamedQuery(name = "Formpago.findByFpaDia1", query = "SELECT f FROM Formpago f WHERE f.fpaDia1 = :fpaDia1"),
    @NamedQuery(name = "Formpago.findByFpaDia2", query = "SELECT f FROM Formpago f WHERE f.fpaDia2 = :fpaDia2"),
    @NamedQuery(name = "Formpago.findByFpaDia3", query = "SELECT f FROM Formpago f WHERE f.fpaDia3 = :fpaDia3"),
    @NamedQuery(name = "Formpago.findByFpaEsgir", query = "SELECT f FROM Formpago f WHERE f.fpaEsgir = :fpaEsgir")})
@JsonbPropertyOrder(value = {"fpa_codi", "fpa_nomb", "fpa_dia2","fpa_dia2","fpa_dia3","fpa_esgir"})
public class Formpago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpa_codi")
    private Integer fpaCodi;
    @Size(max = 50)
    @Column(name = "fpa_nomb")
    private String fpaNomb;
    @Column(name = "fpa_dia1")
    private Integer fpaDia1;
    @Column(name = "fpa_dia2")
    private Integer fpaDia2;
    @Column(name = "fpa_dia3")
    private Integer fpaDia3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpa_esgir")
    private int fpaEsgir;
    @OneToMany(mappedBy = "fpaCodi", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;

    public Formpago() {
    }

    public Formpago(Integer fpaCodi) {
        this.fpaCodi = fpaCodi;
    }

    public Formpago(Integer fpaCodi, int fpaEsgir) {
        this.fpaCodi = fpaCodi;
        this.fpaEsgir = fpaEsgir;
    }

    public Integer getFpaCodi() {
        return fpaCodi;
    }

    public void setFpaCodi(Integer fpaCodi) {
        this.fpaCodi = fpaCodi;
    }

    public String getFpaNomb() {
        return fpaNomb;
    }

    public void setFpaNomb(String fpaNomb) {
        this.fpaNomb = fpaNomb;
    }

    public Integer getFpaDia1() {
        return fpaDia1;
    }

    public void setFpaDia1(Integer fpaDia1) {
        this.fpaDia1 = fpaDia1;
    }

    public Integer getFpaDia2() {
        return fpaDia2;
    }

    public void setFpaDia2(Integer fpaDia2) {
        this.fpaDia2 = fpaDia2;
    }

    public Integer getFpaDia3() {
        return fpaDia3;
    }

    public void setFpaDia3(Integer fpaDia3) {
        this.fpaDia3 = fpaDia3;
    }

    public int getFpaEsgir() {
        return fpaEsgir;
    }

    public void setFpaEsgir(int fpaEsgir) {
        this.fpaEsgir = fpaEsgir;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpaCodi != null ? fpaCodi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formpago)) {
            return false;
        }
        Formpago other = (Formpago) object;
        if ((this.fpaCodi == null && other.fpaCodi != null) || (this.fpaCodi != null && !this.fpaCodi.equals(other.fpaCodi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Formpago[ fpaCodi=" + fpaCodi + " ]";
    }
    
}
