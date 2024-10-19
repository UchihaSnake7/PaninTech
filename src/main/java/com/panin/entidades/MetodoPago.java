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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "metodo_pago", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m"),
    @NamedQuery(name = "MetodoPago.findById", query = "SELECT m FROM MetodoPago m WHERE m.id = :id"),
    @NamedQuery(name = "MetodoPago.findByReferencia", query = "SELECT m FROM MetodoPago m WHERE m.referencia = :referencia")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "banco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Banco banco;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoMetodoPago tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoPago")
    private List<VentaMetodoPago> ventaMetodoPagoList;

    public MetodoPago() {
    }

    public MetodoPago(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public TipoMetodoPago getTipo() {
        return tipo;
    }

    public void setTipo(TipoMetodoPago tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<VentaMetodoPago> getVentaMetodoPagoList() {
        return ventaMetodoPagoList;
    }

    public void setVentaMetodoPagoList(List<VentaMetodoPago> ventaMetodoPagoList) {
        this.ventaMetodoPagoList = ventaMetodoPagoList;
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
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.MetodoPago[ id=" + id + " ]";
    }
    
}
