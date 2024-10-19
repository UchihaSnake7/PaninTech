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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ricke
 */
@Entity
@Table(name = "insumo_recetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsumoRecetas.findAll", query = "SELECT i FROM InsumoRecetas i"),
    @NamedQuery(name = "InsumoRecetas.findByIdInsumoReceta", query = "SELECT i FROM InsumoRecetas i WHERE i.idInsumoReceta = :idInsumoReceta"),
    @NamedQuery(name = "InsumoRecetas.findByCantidad", query = "SELECT i FROM InsumoRecetas i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "InsumoRecetas.findByInsumo", query = "SELECT i FROM InsumoRecetas i WHERE i.idInsumo = :insumo"),
    @NamedQuery(name = "InsumoRecetas.findByReceta", query = "SELECT i FROM InsumoRecetas i WHERE i.idReceta = :receta")

})
public class InsumoRecetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insumo_receta")
    private Integer idInsumoReceta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "id_insumo", referencedColumnName = "id")
    @ManyToOne
    private Insumo idInsumo;
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")
    @ManyToOne
    private Recetas idReceta;
    @JoinColumn(name = "unidad_medida", referencedColumnName = "id_unidad")
    @ManyToOne
    private UnidadMedida unidadMedida;

    public InsumoRecetas() {
    }

    public InsumoRecetas(Integer idInsumoReceta) {
        this.idInsumoReceta = idInsumoReceta;
    }

    public Integer getIdInsumoReceta() {
        return idInsumoReceta;
    }

    public void setIdInsumoReceta(Integer idInsumoReceta) {
        this.idInsumoReceta = idInsumoReceta;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Insumo idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Recetas getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Recetas idReceta) {
        this.idReceta = idReceta;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumoReceta != null ? idInsumoReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoRecetas)) {
            return false;
        }
        InsumoRecetas other = (InsumoRecetas) object;
        if ((this.idInsumoReceta == null && other.idInsumoReceta != null) || (this.idInsumoReceta != null && !this.idInsumoReceta.equals(other.idInsumoReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.InsumoRecetas[ idInsumoReceta=" + idInsumoReceta + " ]";
    }

}
