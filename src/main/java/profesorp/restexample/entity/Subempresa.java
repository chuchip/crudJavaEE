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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "subempresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subempresa.findAll", query = "SELECT s FROM Subempresa s"),
    @NamedQuery(name = "Subempresa.findByEmpCodi", query = "SELECT s FROM Subempresa s WHERE s.subempresaPK.empCodi = :empCodi"),
    @NamedQuery(name = "Subempresa.findBySbeCodi", query = "SELECT s FROM Subempresa s WHERE s.subempresaPK.sbeCodi = :sbeCodi"),
    @NamedQuery(name = "Subempresa.findBySbeNomb", query = "SELECT s FROM Subempresa s WHERE s.sbeNomb = :sbeNomb"),
    @NamedQuery(name = "Subempresa.findBySbeAlbped", query = "SELECT s FROM Subempresa s WHERE s.sbeAlbped = :sbeAlbped")})
public class Subempresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubempresaPK subempresaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "sbe_nomb")
    private String sbeNomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sbe_albped")
    private short sbeAlbped;
    
    @JoinColumn(name = "emp_codi", referencedColumnName = "emp_codi", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subempresa", fetch = FetchType.LAZY)
    private Collection<Clientes> clientesCollection;

    public Subempresa() {
    }

    public Subempresa(SubempresaPK subempresaPK) {
        this.subempresaPK = subempresaPK;
    }

    public Subempresa(SubempresaPK subempresaPK, String sbeNomb, short sbeAlbped) {
        this.subempresaPK = subempresaPK;
        this.sbeNomb = sbeNomb;
        this.sbeAlbped = sbeAlbped;
    }

    public Subempresa(int empCodi, short sbeCodi) {
        this.subempresaPK = new SubempresaPK(empCodi, sbeCodi);
    }

    public SubempresaPK getSubempresaPK() {
        return subempresaPK;
    }

    public void setSubempresaPK(SubempresaPK subempresaPK) {
        this.subempresaPK = subempresaPK;
    }

    public String getSbeNomb() {
        return sbeNomb;
    }

    public void setSbeNomb(String sbeNomb) {
        this.sbeNomb = sbeNomb;
    }

    public short getSbeAlbped() {
        return sbeAlbped;
    }

    public void setSbeAlbped(short sbeAlbped) {
        this.sbeAlbped = sbeAlbped;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        hash += (subempresaPK != null ? subempresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subempresa)) {
            return false;
        }
        Subempresa other = (Subempresa) object;
        if ((this.subempresaPK == null && other.subempresaPK != null) || (this.subempresaPK != null && !this.subempresaPK.equals(other.subempresaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Subempresa[ subempresaPK=" + subempresaPK + " ]";
    }
    
}
