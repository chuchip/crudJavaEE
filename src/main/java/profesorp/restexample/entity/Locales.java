package profesorp.restexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
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

@Entity
@Table(name = "locales")
@XmlRootElement
@JsonbPropertyOrder({"codigo", "nombre"})
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l")
})

public class Locales implements Serializable {
    public static final String FIND_ALL = "Locales.findAll";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "loc_codi")
    private String loc_codi;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "loc_nomb")
    private String nombre;
    
    @JsonbTransient    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locCodi", fetch = FetchType.LAZY)
    private Collection<Paises> paisesCollection;

    public Locales() {
    }

    public Locales(String locCodi) {
        this.loc_codi = locCodi;
    }

    public Locales(String locCodi, String locNomb) {
        this.loc_codi = locCodi;
        this.nombre = locNomb;
    }

    public String getCodigo() {
        return loc_codi;
    }

    public void setCodigo(String codigo) {
        this.loc_codi = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (loc_codi != null ? loc_codi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locales)) {
            return false;
        }
        Locales other = (Locales) object;
        if ((this.loc_codi == null && other.loc_codi != null) || (this.loc_codi != null && !this.loc_codi.equals(other.loc_codi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Locales[ locCodi=" + loc_codi + " ]";
    }
    
}
