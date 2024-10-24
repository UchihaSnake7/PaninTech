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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "configuracion_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionVenta.findAll", query = "SELECT c FROM ConfiguracionVenta c"),
    @NamedQuery(name = "ConfiguracionVenta.findById", query = "SELECT c FROM ConfiguracionVenta c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracionVenta.findByUnidadVenta", query = "SELECT c FROM ConfiguracionVenta c WHERE c.unidadVenta = :unidadVenta"),
    @NamedQuery(name = "ConfiguracionVenta.findByPorcentajeGanancia", query = "SELECT c FROM ConfiguracionVenta c WHERE c.porcentajeGanancia = :porcentajeGanancia")})
public class ConfiguracionVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "unidad_venta")
    private Integer unidadVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_ganancia")
    private Double porcentajeGanancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuracionVenta")
    private Collection<ProductoConfiguracionVenta> productoConfiguracionVentaCollection;

    public ConfiguracionVenta() {
    }

    public void inicializar(){
        this.unidadVenta = 1;
        this.porcentajeGanancia = 0.0;
    }
    
    public ConfiguracionVenta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(Integer unidadVenta) {
        this.unidadVenta = unidadVenta;
    }

    public Double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(Double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    @XmlTransient
    public Collection<ProductoConfiguracionVenta> getProductoConfiguracionVentaCollection() {
        return productoConfiguracionVentaCollection;
    }

    public void setProductoConfiguracionVentaCollection(Collection<ProductoConfiguracionVenta> productoConfiguracionVentaCollection) {
        this.productoConfiguracionVentaCollection = productoConfiguracionVentaCollection;
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
        if (!(object instanceof ConfiguracionVenta)) {
            return false;
        }
        ConfiguracionVenta other = (ConfiguracionVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.ConfiguracionVenta[ id=" + id + " ]";
    }
    
}
