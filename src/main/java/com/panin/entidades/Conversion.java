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
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "conversion", catalog = "panin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversion.findAll", query = "SELECT c FROM Conversion c"),
    @NamedQuery(name = "Conversion.findByIdConversion", query = "SELECT c FROM Conversion c WHERE c.idConversion = :idConversion"),
    @NamedQuery(name = "Conversion.findByFactorConversion", query = "SELECT c FROM Conversion c WHERE c.factorConversion = :factorConversion")})
public class Conversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conversion", nullable = false)
    private Integer idConversion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "factor_conversion", nullable = false, precision = 10, scale = 5)
    private BigDecimal factorConversion;
    @JoinColumn(name = "unidad_base_id", referencedColumnName = "id_unidad")
    @ManyToOne
    private UnidadMedida unidadBaseId;
    @JoinColumn(name = "unidad_derivada_id", referencedColumnName = "id_unidad")
    @ManyToOne
    private UnidadMedida unidadDerivadaId;

    public Conversion() {
    }

    public Conversion(Integer idConversion) {
        this.idConversion = idConversion;
    }

    public Conversion(Integer idConversion, BigDecimal factorConversion) {
        this.idConversion = idConversion;
        this.factorConversion = factorConversion;
    }

    public Integer getIdConversion() {
        return idConversion;
    }

    public void setIdConversion(Integer idConversion) {
        this.idConversion = idConversion;
    }

    public BigDecimal getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(BigDecimal factorConversion) {
        this.factorConversion = factorConversion;
    }

    public UnidadMedida getUnidadBaseId() {
        return unidadBaseId;
    }

    public void setUnidadBaseId(UnidadMedida unidadBaseId) {
        this.unidadBaseId = unidadBaseId;
    }

    public UnidadMedida getUnidadDerivadaId() {
        return unidadDerivadaId;
    }

    public void setUnidadDerivadaId(UnidadMedida unidadDerivadaId) {
        this.unidadDerivadaId = unidadDerivadaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConversion != null ? idConversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversion)) {
            return false;
        }
        Conversion other = (Conversion) object;
        if ((this.idConversion == null && other.idConversion != null) || (this.idConversion != null && !this.idConversion.equals(other.idConversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.panin.entidades.Conversion[ idConversion=" + idConversion + " ]";
    }
    
}
