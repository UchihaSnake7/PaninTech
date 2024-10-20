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
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "compras_insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasInsumo.findAll", query = "SELECT c FROM ComprasInsumo c"),
    @NamedQuery(name = "ComprasInsumo.findById", query = "SELECT c FROM ComprasInsumo c WHERE c.id = :id"),
    @NamedQuery(name = "ComprasInsumo.findByFecha", query = "SELECT c FROM ComprasInsumo c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ComprasInsumo.findByCantidad", query = "SELECT c FROM ComprasInsumo c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ComprasInsumo.findByPrecio", query = "SELECT c FROM ComprasInsumo c WHERE c.precio = :precio"),
    @NamedQuery(name = "ComprasInsumo.findByInsumo", query = "SELECT c FROM ComprasInsumo c WHERE c.insumo = :insumo"),
    @NamedQuery(name = "ComprasInsumo.findByInsumoDesde", query = "SELECT c FROM ComprasInsumo c WHERE c.insumo = :insumo and c.fecha >= :desde"),
    @NamedQuery(name = "ComprasInsumo.findByInsumoHasta", query = "SELECT c FROM ComprasInsumo c WHERE c.insumo = :insumo and c.fecha <= :hasta"),
    @NamedQuery(name = "ComprasInsumo.findByInsumoFechas", query = "SELECT c FROM ComprasInsumo c WHERE c.insumo = :insumo and c.fecha between :desde and :hasta"),
    @NamedQuery(name = "ComprasInsumo.findByFechas", query = "SELECT c FROM ComprasInsumo c WHERE c.fecha between :desde and :hasta"),
    @NamedQuery(name = "ComprasInsumo.findByDesde", query = "SELECT c FROM ComprasInsumo c WHERE c.fecha >= :desde"),
    @NamedQuery(name = "ComprasInsumo.findByHasta", query = "SELECT c FROM ComprasInsumo c WHERE c.fecha <= :hasta"),
    
    @NamedQuery(name = "ComprasInsumo.findByInsumoUnico", query = "SELECT c FROM ComprasInsumo c WHERE c.insumo = :insumo ORDER BY c.fecha DESC, c.hora DESC"),

})
public class ComprasInsumo implements Serializable, Comparable<ComprasInsumo> {

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
    @JoinColumn(name = "marca_insumo", referencedColumnName = "id")
    @ManyToOne
    private MarcaInsumo marcaInsumo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "insumo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Insumo insumo;
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id_unidad", nullable = false)
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedidaId;

    public ComprasInsumo() {
    }

    public ComprasInsumo(Integer id) {
        this.id = id;
    }

    public ComprasInsumo(Integer id, Date fecha, BigDecimal cantidad, BigDecimal precio) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public UnidadMedida getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(UnidadMedida unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
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
        if (!(object instanceof ComprasInsumo)) {
            return false;
        }
        ComprasInsumo other = (ComprasInsumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "com.panin.entidades.ComprasInsumo[ id=" + id + " ]";
    }

    @Override
    public int compareTo(ComprasInsumo o) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return this.getFecha().compareTo(o.getFecha()); // Por ejemplo, comparar por fecha
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

}
