/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author argenis javier
 */
@Entity
@Table(name = "tasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasa.findAll", query = "SELECT t FROM Tasa t"),
    @NamedQuery(name = "Tasa.findById", query = "SELECT t FROM Tasa t WHERE t.id = :id"),
    @NamedQuery(name = "Tasa.findByTasa", query = "SELECT t FROM Tasa t WHERE t.tasa = :tasa"),
    @NamedQuery(name = "Tasa.findByFecha", query = "SELECT t FROM Tasa t WHERE t.fecha = :fecha")})
public class Tasa implements Serializable, Comparable<Tasa> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa")
    private float tasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Tasa() {
    }

    public Tasa(Integer id) {
        this.id = id;
    }

    public Tasa(Integer id, float tasa, Date fecha) {
        this.id = id;
        this.tasa = tasa;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasa)) {
            return false;
        }
        Tasa other = (Tasa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.Tasa[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Tasa t) {
        int comparison = this.getFecha().compareTo(t.getFecha());
        if (comparison == 0) {
            // Si las fechas son iguales, comparamos los IDs
            System.out.println("Comparando ID");
            return Integer.compare(this.getId(), t.getId());
        } else {
            return comparison;
        }
    }
}
