/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tano
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByPkIdPres", query = "SELECT p FROM Prestamo p WHERE p.pkIdPres = :pkIdPres"),
    @NamedQuery(name = "Prestamo.findByFecCred", query = "SELECT p FROM Prestamo p WHERE p.fecCred = :fecCred"),
    @NamedQuery(name = "Prestamo.findByMontoCred", query = "SELECT p FROM Prestamo p WHERE p.montoCred = :montoCred"),
    @NamedQuery(name = "Prestamo.findByCantCuotas", query = "SELECT p FROM Prestamo p WHERE p.cantCuotas = :cantCuotas"),
    @NamedQuery(name = "Prestamo.findByMontMensPagar", query = "SELECT p FROM Prestamo p WHERE p.montMensPagar = :montMensPagar"),
    @NamedQuery(name = "Prestamo.findByCuotasPagadas", query = "SELECT p FROM Prestamo p WHERE p.cuotasPagadas = :cuotasPagadas"),
    @NamedQuery(name = "Prestamo.findByMontoTotalPagar", query = "SELECT p FROM Prestamo p WHERE p.montoTotalPagar = :montoTotalPagar"),
    @NamedQuery(name = "Prestamo.findByGanancia", query = "SELECT p FROM Prestamo p WHERE p.ganancia = :ganancia")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ID_PRES")
    private Integer pkIdPres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_Cred")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCred;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cred")
    private int montoCred;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_cuotas")
    private int cantCuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mont_mens_pagar")
    private int montMensPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas_pagadas")
    private int cuotasPagadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total_pagar")
    private int montoTotalPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganancia")
    private int ganancia;
    @JoinColumn(name = "PK_ID_CLI", referencedColumnName = "PK_ID_CLI")
    @ManyToOne(optional = false)
    private Clientes pkIdCli;

    public Prestamo() {
    }

    public Prestamo(Integer pkIdPres) {
        this.pkIdPres = pkIdPres;
    }

    public Prestamo(Integer pkIdPres, Date fecCred, int montoCred, int cantCuotas, int montMensPagar, int cuotasPagadas, int montoTotalPagar, int ganancia) {
        this.pkIdPres = pkIdPres;
        this.fecCred = fecCred;
        this.montoCred = montoCred;
        this.cantCuotas = cantCuotas;
        this.montMensPagar = montMensPagar;
        this.cuotasPagadas = cuotasPagadas;
        this.montoTotalPagar = montoTotalPagar;
        this.ganancia = ganancia;
    }

    public Integer getPkIdPres() {
        return pkIdPres;
    }

    public void setPkIdPres(Integer pkIdPres) {
        this.pkIdPres = pkIdPres;
    }

    public Date getFecCred() {
        return fecCred;
    }

    public void setFecCred(Date fecCred) {
        this.fecCred = fecCred;
    }

    public int getMontoCred() {
        return montoCred;
    }

    public void setMontoCred(int montoCred) {
        this.montoCred = montoCred;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public int getMontMensPagar() {
        return montMensPagar;
    }

    public void setMontMensPagar(int montMensPagar) {
        this.montMensPagar = montMensPagar;
    }

    public int getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public int getMontoTotalPagar() {
        return montoTotalPagar;
    }

    public void setMontoTotalPagar(int montoTotalPagar) {
        this.montoTotalPagar = montoTotalPagar;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }

    public Clientes getPkIdCli() {
        return pkIdCli;
    }

    public void setPkIdCli(Clientes pkIdCli) {
        this.pkIdCli = pkIdCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPres != null ? pkIdPres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.pkIdPres == null && other.pkIdPres != null) || (this.pkIdPres != null && !this.pkIdPres.equals(other.pkIdPres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orm.Prestamo[ pkIdPres=" + pkIdPres + " ]";
    }
    
}
