/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tipo_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedida.findAll", query = "SELECT t FROM TipoMedida t"),
    @NamedQuery(name = "TipoMedida.findByIdTipoMedida", query = "SELECT t FROM TipoMedida t WHERE t.idTipoMedida = :idTipoMedida"),
    @NamedQuery(name = "TipoMedida.findByNombre", query = "SELECT t FROM TipoMedida t WHERE t.nombre = :nombre")})
public class TipoMedida implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idTipo", fetch=FetchType.EAGER)
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "unidad_medida", joinColumns = @JoinColumn(name = "id_tipo"))
    private Collection<UnidadMedida> unidadMedidaCollection ;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_medida", nullable = false)
    private Integer idTipoMedida;
    @OneToMany(mappedBy = "idTipoMedida")
    private Collection<Insumo> insumoCollection;

    public TipoMedida() {
    }

    public TipoMedida(Integer idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }

    public TipoMedida(Integer idTipoMedida, String nombre) {
        this.idTipoMedida = idTipoMedida;
        this.nombre = nombre;
    }

    public Integer getIdTipoMedida() {
        return idTipoMedida;
    }

    public void setIdTipoMedida(Integer idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
    }


    @XmlTransient
    public Collection<Insumo> getInsumoCollection() {
        return insumoCollection;
    }

    public void setInsumoCollection(Collection<Insumo> insumoCollection) {
        this.insumoCollection = insumoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMedida != null ? idTipoMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMedida)) {
            return false;
        }
        TipoMedida other = (TipoMedida) object;
        if ((this.idTipoMedida == null && other.idTipoMedida != null) || (this.idTipoMedida != null && !this.idTipoMedida.equals(other.idTipoMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }


    @XmlTransient
    public Collection<UnidadMedida> getUnidadMedidaCollection() {
        return unidadMedidaCollection;
    }

    public void setUnidadMedidaCollection(Collection<UnidadMedida> unidadMedidaCollection) {
        this.unidadMedidaCollection = unidadMedidaCollection;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}