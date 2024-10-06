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
@Table(name = "unidad_medida", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByIdUnidad", query = "SELECT u FROM UnidadMedida u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "UnidadMedida.findByNombre", query = "SELECT u FROM UnidadMedida u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "UnidadMedida.findByAbreviatura", query = "SELECT u FROM UnidadMedida u WHERE u.abreviatura = :abreviatura"),
    @NamedQuery(name = "UnidadMedida.findBySistema", query = "SELECT u FROM UnidadMedida u WHERE u.sistema = :sistema")})
public class UnidadMedida implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Size(max = 20)
    @Column(name = "sistema")
    private String sistema;
    @OneToMany(mappedBy = "unidadMedida")
    private Collection<InsumoRecetas> insumoRecetasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedidaId")
    private Collection<ComprasInsumo> comprasInsumoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad", nullable = false)
    private Integer idUnidad;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_medida")
    @ManyToOne
    private TipoMedida idTipo;
    @OneToMany(mappedBy = "unidadBaseId")
    private Collection<Conversion> conversionCollection;
    @OneToMany(mappedBy = "unidadDerivadaId")
    private Collection<Conversion> conversionCollection1;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public UnidadMedida(Integer idUnidad, String nombre) {
        this.idUnidad = idUnidad;
        this.nombre = nombre;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }


    public TipoMedida getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoMedida idTipo) {
        this.idTipo = idTipo;
    }

    @XmlTransient
    public Collection<Conversion> getConversionCollection() {
        return conversionCollection;
    }

    public void setConversionCollection(Collection<Conversion> conversionCollection) {
        this.conversionCollection = conversionCollection;
    }

    @XmlTransient
    public Collection<Conversion> getConversionCollection1() {
        return conversionCollection1;
    }

    public void setConversionCollection1(Collection<Conversion> conversionCollection1) {
        this.conversionCollection1 = conversionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAbreviatura();
    }


    @XmlTransient
    public Collection<ComprasInsumo> getComprasInsumoCollection() {
        return comprasInsumoCollection;
    }

    public void setComprasInsumoCollection(Collection<ComprasInsumo> comprasInsumoCollection) {
        this.comprasInsumoCollection = comprasInsumoCollection;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    @XmlTransient
    public Collection<InsumoRecetas> getInsumoRecetasCollection() {
        return insumoRecetasCollection;
    }

    public void setInsumoRecetasCollection(Collection<InsumoRecetas> insumoRecetasCollection) {
        this.insumoRecetasCollection = insumoRecetasCollection;
    }
    
}


