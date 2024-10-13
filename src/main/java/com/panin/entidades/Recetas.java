/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author ricke
 */
@Entity
@Table(name = "recetas")
@NamedQueries({
    @NamedQuery(name = "Recetas.findAll", query = "SELECT r FROM Recetas r"),
    @NamedQuery(name = "Recetas.findByIdReceta", query = "SELECT r FROM Recetas r WHERE r.idReceta = :idReceta"),
    @NamedQuery(name = "Recetas.findByNombreReceta", query = "SELECT r FROM Recetas r WHERE r.nombreReceta = :nombreReceta"),
    @NamedQuery(name = "Recetas.findByTiempoPreparacion", query = "SELECT r FROM Recetas r WHERE r.tiempoPreparacion = :tiempoPreparacion")})
public class Recetas implements Serializable {

    @Size(max = 100)
    @Column(name = "nombre_receta")
    private String nombreReceta;
    @Lob
    @Size(max = 65535)
    @Column(name = "instrucciones")
    private String instrucciones;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receta")
    private Integer idReceta;
    @Column(name = "tiempo_preparacion")
    @Temporal(TemporalType.TIME)
    private Date tiempoPreparacion;
    @OneToMany(mappedBy = "idReceta", fetch=FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)

    private Collection<InsumoRecetas> insumoRecetasCollection;
    @Column(name = "cantidad")
    private Integer cantidad;

    public Recetas() {
    }

    public Recetas(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public Date getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Date tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }


    public Collection<InsumoRecetas> getInsumoRecetasCollection() {
        return insumoRecetasCollection;
    }

    public void setInsumoRecetasCollection(Collection<InsumoRecetas> insumoRecetasCollection) {
        this.insumoRecetasCollection = insumoRecetasCollection;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.Recetas[ idReceta=" + idReceta + " ]";
    }


    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
    
}
