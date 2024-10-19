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
@Table(name = "tipo_metodo_pago", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMetodoPago.findAll", query = "SELECT t FROM TipoMetodoPago t"),
    @NamedQuery(name = "TipoMetodoPago.findById", query = "SELECT t FROM TipoMetodoPago t WHERE t.id = :id"),
    @NamedQuery(name = "TipoMetodoPago.findByDescripcion", query = "SELECT t FROM TipoMetodoPago t WHERE t.descripcion = :descripcion")})
public class TipoMetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<MetodoPago> metodoPagoList;

    public TipoMetodoPago() {
    }

    public TipoMetodoPago(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<MetodoPago> getMetodoPagoList() {
        return metodoPagoList;
    }

    public void setMetodoPagoList(List<MetodoPago> metodoPagoList) {
        this.metodoPagoList = metodoPagoList;
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
        if (!(object instanceof TipoMetodoPago)) {
            return false;
        }
        TipoMetodoPago other = (TipoMetodoPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.TipoMetodoPago[ id=" + id + " ]";
    }
    
}
