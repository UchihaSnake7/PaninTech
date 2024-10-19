/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import com.panin.application.utilities.tipoProducto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 *
 * @author ricke
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByPrecioProduccion", query = "SELECT p FROM Producto p WHERE p.precioProduccion = :precioProduccion"),
    @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Producto.findByReceta", query = "SELECT p FROM Producto p WHERE p.idReceta = :receta")

})

public class Producto implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_produccion")
    private Double precioProduccion;
    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<VentaProductos> ventaProductosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(columnDefinition = "ENUM('Comprado', 'Elaborado')")
    @Enumerated(EnumType.STRING)
    private String tipo;

    @Column(name = "id_receta")
    private Integer idReceta;

    @JoinColumn(name = "id_tipo_medida", referencedColumnName = "id_tipo_medida")
    @ManyToOne
    private TipoMedida idTipoMedida;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecioProduccion() {
        return precioProduccion;
    }

    public void setPrecioProduccion(double precioProduccion) {
        this.precioProduccion = precioProduccion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public TipoMedida getIdTipoMedida() {
        return idTipoMedida;
    }

    public void setIdTipoMedida(TipoMedida idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioProduccion(Double precioProduccion) {
        this.precioProduccion = precioProduccion;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<VentaProductos> getVentaProductosList() {
        return ventaProductosList;
    }

    public void setVentaProductosList(List<VentaProductos> ventaProductosList) {
        this.ventaProductosList = ventaProductosList;
    }

}
