/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "banco", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findById", query = "SELECT b FROM Banco b WHERE b.id = :id"),
    @NamedQuery(name = "Banco.findByDescripcion", query = "SELECT b FROM Banco b WHERE b.descripcion = :descripcion"),
    @NamedQuery(name = "Banco.findByReferencia", query = "SELECT b FROM Banco b WHERE b.referencia = :referencia")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "referencia")
    private String referencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private Collection<MetodoPago> metodoPagoCollection;

    public Banco() {
    }

    public Banco(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @XmlTransient
    public Collection<MetodoPago> getMetodoPagoCollection() {
        return metodoPagoCollection;
    }

    public void setMetodoPagoCollection(Collection<MetodoPago> metodoPagoCollection) {
        this.metodoPagoCollection = metodoPagoCollection;
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
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.Banco[ id=" + id + " ]";
    }
    
}
