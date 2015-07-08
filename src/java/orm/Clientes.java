/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Tano
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByPkIdCli", query = "SELECT c FROM Clientes c WHERE c.pkIdCli = :pkIdCli"),
    @NamedQuery(name = "Clientes.findByApe", query = "SELECT c FROM Clientes c WHERE c.ape = :ape"),
    @NamedQuery(name = "Clientes.findByNom", query = "SELECT c FROM Clientes c WHERE c.nom = :nom"),
    @NamedQuery(name = "Clientes.findByDni", query = "SELECT c FROM Clientes c WHERE c.dni = :dni"),
    @NamedQuery(name = "Clientes.findByTel", query = "SELECT c FROM Clientes c WHERE c.tel = :tel"),
    @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID_CLI")
    private Integer pkIdCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ape")
    private String ape;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ocup")
    private String ocup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkIdCli")
    private Collection<Prestamo> prestamoCollection;

    public Clientes() {
    }

    public Clientes(Integer pkIdCli) {
        this.pkIdCli = pkIdCli;
    }

    public Clientes(Integer pkIdCli, String ape, String nom, String dni, String tel, String ocup, String direccion) {
        this.pkIdCli = pkIdCli;
        this.ape = ape;
        this.nom = nom;
        this.dni = dni;
        this.tel = tel;
        this.ocup = ocup;
        this.direccion = direccion;
    }

    public Integer getPkIdCli() {
        return pkIdCli;
    }

    public void setPkIdCli(Integer pkIdCli) {
        this.pkIdCli = pkIdCli;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOcup() {
        return ocup;
    }

    public void setOcup(String ocup) {
        this.ocup = ocup;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCli != null ? pkIdCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.pkIdCli == null && other.pkIdCli != null) || (this.pkIdCli != null && !this.pkIdCli.equals(other.pkIdCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orm.Clientes[ pkIdCli=" + pkIdCli + " ]";
    }
    
}
