/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chuchip
 */
@Embeddable
public class SubempresaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_codi")
    private int empCodi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sbe_codi")
    private short sbeCodi;

    public SubempresaPK() {
    }

    public SubempresaPK(int empCodi, short sbeCodi) {
        this.empCodi = empCodi;
        this.sbeCodi = sbeCodi;
    }

    public int getEmpCodi() {
        return empCodi;
    }

    public void setEmpCodi(int empCodi) {
        this.empCodi = empCodi;
    }

    public short getSbeCodi() {
        return sbeCodi;
    }

    public void setSbeCodi(short sbeCodi) {
        this.sbeCodi = sbeCodi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empCodi;
        hash += (int) sbeCodi;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubempresaPK)) {
            return false;
        }
        SubempresaPK other = (SubempresaPK) object;
        if (this.empCodi != other.empCodi) {
            return false;
        }
        if (this.sbeCodi != other.sbeCodi) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.SubempresaPK[ empCodi=" + empCodi + ", sbeCodi=" + sbeCodi + " ]";
    }
    
}
