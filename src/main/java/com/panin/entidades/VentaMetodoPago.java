/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "venta_metodo_pago", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaMetodoPago.findAll", query = "SELECT v FROM VentaMetodoPago v"),
    @NamedQuery(name = "VentaMetodoPago.findById", query = "SELECT v FROM VentaMetodoPago v WHERE v.id = :id"),
    @NamedQuery(name = "VentaMetodoPago.findByMonto", query = "SELECT v FROM VentaMetodoPago v WHERE v.monto = :monto")})
public class VentaMetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private double monto;
    @JoinColumn(name = "divisa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Divisa divisa;
    @JoinColumn(name = "metodo_pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MetodoPago metodoPago;
    @JoinColumn(name = "venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaMetodoPago() {
    }

    public VentaMetodoPago(Integer id) {
        this.id = id;
    }

    public VentaMetodoPago(Integer id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Divisa getDivisa() {
        return divisa;
    }

    public void setDivisa(Divisa divisa) {
        this.divisa = divisa;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
        if (!(object instanceof VentaMetodoPago)) {
            return false;
        }
        VentaMetodoPago other = (VentaMetodoPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.VentaMetodoPago[ id=" + id + " ]";
    }
    
}
