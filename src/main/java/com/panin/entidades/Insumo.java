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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "insumo", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findById", query = "SELECT i FROM Insumo i WHERE i.id = :id"),
    @NamedQuery(name = "Insumo.findByDescripcion", query = "SELECT i FROM Insumo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Insumo.findByFechaCreacion", query = "SELECT i FROM Insumo i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Insumo.findByHoraCreacion", query = "SELECT i FROM Insumo i WHERE i.horaCreacion = :horaCreacion"),
    @NamedQuery(name = "Insumo.findByActivo", query = "SELECT i FROM Insumo i WHERE i.activo = :activo"),
    @NamedQuery(name = "Insumo.findByRutaImagen", query = "SELECT i FROM Insumo i WHERE i.rutaImagen = :rutaImagen")})
public class Insumo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 30)
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @OneToMany(mappedBy = "idInsumo")
    private Collection<InsumoRecetas> insumoRecetasCollection;
    @Column(name = "hora_creacion")
    @Temporal(TemporalType.TIME)
    private Date horaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo")
    private Collection<ComprasInsumo> comprasInsumoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_tipo_medida", referencedColumnName = "id_tipo_medida")
    @ManyToOne
    private TipoMedida idTipoMedida;

    public Insumo() {
    }

    public Insumo(Integer id) {
        this.id = id;
    }

    public Insumo(Integer id, String descripcion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Time getHoraCreacion() {
        return (Time) horaCreacion;
    }

    public void setHoraCreacion(Time horaCreacion) {
        this.horaCreacion = (Time) horaCreacion;
    }


    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public TipoMedida getIdTipoMedida() {
        return idTipoMedida;
    }

    public void setIdTipoMedida(TipoMedida idTipoMedida) {
        this.idTipoMedida = idTipoMedida;
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
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }


  
    public void setHoraCreacion(Date horaCreacion) {
        this.horaCreacion = horaCreacion;
    }


    @XmlTransient
    public Collection<ComprasInsumo> getComprasInsumoCollection() {
        return comprasInsumoCollection;
    }

    public void setComprasInsumoCollection(Collection<ComprasInsumo> comprasInsumoCollection) {
        this.comprasInsumoCollection = comprasInsumoCollection;
    }


   

    @XmlTransient
    public Collection<InsumoRecetas> getInsumoRecetasCollection() {
        return insumoRecetasCollection;
    }

    public void setInsumoRecetasCollection(Collection<InsumoRecetas> insumoRecetasCollection) {
        this.insumoRecetasCollection = insumoRecetasCollection;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
