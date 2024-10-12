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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "marca_insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaInsumo.findAll", query = "SELECT m FROM MarcaInsumo m"),
    @NamedQuery(name = "MarcaInsumo.findById", query = "SELECT m FROM MarcaInsumo m WHERE m.id = :id"),
    @NamedQuery(name = "MarcaInsumo.findByNombre", query = "SELECT m FROM MarcaInsumo m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MarcaInsumo.findByActivo", query = "SELECT m FROM MarcaInsumo m WHERE m.activo = :activo")})
public class MarcaInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "marcaInsumo")
    private Collection<ComprasInsumo> comprasInsumoCollection;

    public MarcaInsumo() {
    }

    public MarcaInsumo(Integer id) {
        this.id = id;
    }

    public MarcaInsumo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<ComprasInsumo> getComprasInsumoCollection() {
        return comprasInsumoCollection;
    }

    public void setComprasInsumoCollection(Collection<ComprasInsumo> comprasInsumoCollection) {
        this.comprasInsumoCollection = comprasInsumoCollection;
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
        if (!(object instanceof MarcaInsumo)) {
            return false;
        }
        MarcaInsumo other = (MarcaInsumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
