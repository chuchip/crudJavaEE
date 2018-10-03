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
public class ClientesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_codi")
    private int empCodi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_codi")
    private int cliCodi;

    public ClientesPK() {
    }

    public ClientesPK(int empCodi, int cliCodi) {
        this.empCodi = empCodi;
        this.cliCodi = cliCodi;
    }

    public int getEmpCodi() {
        return empCodi;
    }

    public void setEmpCodi(int empCodi) {
        this.empCodi = empCodi;
    }

    public int getCliCodi() {
        return cliCodi;
    }

    public void setCliCodi(int cliCodi) {
        this.cliCodi = cliCodi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empCodi;
        hash += (int) cliCodi;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesPK)) {
            return false;
        }
        ClientesPK other = (ClientesPK) object;
        if (this.empCodi != other.empCodi) {
            return false;
        }
        if (this.cliCodi != other.cliCodi) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.ClientesPK[ empCodi=" + empCodi + ", cliCodi=" + cliCodi + " ]";
    }
    
}
