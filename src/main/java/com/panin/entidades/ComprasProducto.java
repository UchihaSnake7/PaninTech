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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ricke
 */
@Entity
@Table(name = "compras_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasProducto.findAll", query = "SELECT c FROM ComprasProducto c"),
    @NamedQuery(name = "ComprasProducto.findById", query = "SELECT c FROM ComprasProducto c WHERE c.id = :id"),
    @NamedQuery(name = "ComprasProducto.findByFecha", query = "SELECT c FROM ComprasProducto c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ComprasProducto.findByCantidad", query = "SELECT c FROM ComprasProducto c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ComprasProducto.findByPrecio", query = "SELECT c FROM ComprasProducto c WHERE c.precio = :precio"),
    @NamedQuery(name = "ComprasProducto.findByProducto", query = "SELECT c FROM ComprasProducto c WHERE c.producto = :producto"),
    @NamedQuery(name = "ComprasProducto.findByInsumoDesde", query = "SELECT c FROM ComprasProducto c WHERE c.producto = :producto and c.fecha >= :desde"),
    @NamedQuery(name = "ComprasProducto.findByInsumoHasta", query = "SELECT c FROM ComprasProducto c WHERE c.producto = :producto and c.fecha <= :hasta"),
    @NamedQuery(name = "ComprasProducto.findByInsumoFechas", query = "SELECT c FROM ComprasProducto c WHERE c.producto = :producto and c.fecha between :desde and :hasta"),
    @NamedQuery(name = "ComprasProducto.findByFechas", query = "SELECT c FROM ComprasProducto c WHERE c.fecha between :desde and :hasta"),
    @NamedQuery(name = "ComprasProducto.findByDesde", query = "SELECT c FROM ComprasProducto c WHERE c.fecha >= :desde"),
    @NamedQuery(name = "ComprasProducto.findByHasta", query = "SELECT c FROM ComprasProducto c WHERE c.fecha <= :hasta"),

    @NamedQuery(name = "ComprasProducto.findByProductoUnico", query = "SELECT c FROM ComprasProducto c WHERE c.producto = :producto ORDER BY c.fecha DESC, c.hora DESC"),})
public class ComprasProducto implements Serializable, Comparable<ComprasProducto> {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", precision = 20, scale = 6)
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio", precision = 10, scale = 6)
    private BigDecimal precio;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "marca", referencedColumnName = "id")
    @ManyToOne
    private MarcaInsumo marcaInsumo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "producto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "unidad_medida", referencedColumnName = "id_unidad", nullable = false)
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.ComprasInsumo[ id=" + id + " ]";
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public MarcaInsumo getMarcaInsumo() {
        return marcaInsumo;
    }

    public void setMarcaInsumo(MarcaInsumo marcaInsumo) {
        this.marcaInsumo = marcaInsumo;
    }

    @Override
    public int compareTo(ComprasProducto o) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return this.getFecha().compareTo(o.getFecha()); // Por ejemplo, comparar por fecha
    }

}
