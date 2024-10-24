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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "producto_configuracion_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoConfiguracionVenta.findAll", query = "SELECT p FROM ProductoConfiguracionVenta p"),
    @NamedQuery(name = "ProductoConfiguracionVenta.findById", query = "SELECT p FROM ProductoConfiguracionVenta p WHERE p.id = :id")})
public class ProductoConfiguracionVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "configuracion_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConfiguracionVenta configuracionVenta;
    @JoinColumn(name = "producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configuracionVenta")
    private Collection<Producto> productoCollection;

    public ProductoConfiguracionVenta() {
    }

    public ProductoConfiguracionVenta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConfiguracionVenta getConfiguracionVenta() {
        return configuracionVenta;
    }

    public void setConfiguracionVenta(ConfiguracionVenta configuracionVenta) {
        this.configuracionVenta = configuracionVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
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
        if (!(object instanceof ProductoConfiguracionVenta)) {
            return false;
        }
        ProductoConfiguracionVenta other = (ProductoConfiguracionVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.ProductoConfiguracionVenta[ id=" + id + " ]";
    }
    
}
