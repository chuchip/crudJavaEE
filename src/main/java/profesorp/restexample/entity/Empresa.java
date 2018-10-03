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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByEmpCodi", query = "SELECT e FROM Empresa e WHERE e.empCodi = :empCodi"),
    @NamedQuery(name = "Empresa.findByEmpNomb", query = "SELECT e FROM Empresa e WHERE e.empNomb = :empNomb"),
    @NamedQuery(name = "Empresa.findByEmpDire", query = "SELECT e FROM Empresa e WHERE e.empDire = :empDire"),
    @NamedQuery(name = "Empresa.findByEmpPobl", query = "SELECT e FROM Empresa e WHERE e.empPobl = :empPobl"),
    @NamedQuery(name = "Empresa.findByEmpCodpo", query = "SELECT e FROM Empresa e WHERE e.empCodpo = :empCodpo"),
    @NamedQuery(name = "Empresa.findByEmpTelef", query = "SELECT e FROM Empresa e WHERE e.empTelef = :empTelef"),
    @NamedQuery(name = "Empresa.findByEmpFax", query = "SELECT e FROM Empresa e WHERE e.empFax = :empFax"),
    @NamedQuery(name = "Empresa.findByEmpNif", query = "SELECT e FROM Empresa e WHERE e.empNif = :empNif")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_codi")
    private Integer empCodi;
    @Size(max = 40)
    @Column(name = "emp_nomb")
    private String empNomb;
    @Size(max = 40)
    @Column(name = "emp_dire")
    private String empDire;
    @Size(max = 30)
    @Column(name = "emp_pobl")
    private String empPobl;
    @Size(max = 15)
    @Column(name = "emp_codpo")
    private String empCodpo;
    @Size(max = 15)
    @Column(name = "emp_telef")
    private String empTelef;
    @Size(max = 15)
    @Column(name = "emp_fax")
    private String empFax;
    @Size(max = 12)
    @Column(name = "emp_nif")
    private String empNif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Subempresa> subempresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;

    public Empresa() {
    }

    public Empresa(Integer empCodi) {
        this.empCodi = empCodi;
    }

    public Integer getEmpCodi() {
        return empCodi;
    }

    public void setEmpCodi(Integer empCodi) {
        this.empCodi = empCodi;
    }

    public String getEmpNomb() {
        return empNomb;
    }

    public void setEmpNomb(String empNomb) {
        this.empNomb = empNomb;
    }

    public String getEmpDire() {
        return empDire;
    }

    public void setEmpDire(String empDire) {
        this.empDire = empDire;
    }

    public String getEmpPobl() {
        return empPobl;
    }

    public void setEmpPobl(String empPobl) {
        this.empPobl = empPobl;
    }

    public String getEmpCodpo() {
        return empCodpo;
    }

    public void setEmpCodpo(String empCodpo) {
        this.empCodpo = empCodpo;
    }

    public String getEmpTelef() {
        return empTelef;
    }

    public void setEmpTelef(String empTelef) {
        this.empTelef = empTelef;
    }

    public String getEmpFax() {
        return empFax;
    }

    public void setEmpFax(String empFax) {
        this.empFax = empFax;
    }

    public String getEmpNif() {
        return empNif;
    }

    public void setEmpNif(String empNif) {
        this.empNif = empNif;
    }

    @XmlTransient
    public Collection<Subempresa> getSubempresaCollection() {
        return subempresaCollection;
    }

    public void setSubempresaCollection(Collection<Subempresa> subempresaCollection) {
        this.subempresaCollection = subempresaCollection;
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
        hash += (empCodi != null ? empCodi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empCodi == null && other.empCodi != null) || (this.empCodi != null && !this.empCodi.equals(other.empCodi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Empresa[ empCodi=" + empCodi + " ]";
    }
    
}
