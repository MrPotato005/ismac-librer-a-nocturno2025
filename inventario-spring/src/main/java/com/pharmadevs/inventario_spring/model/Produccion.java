package com.pharmadevs.inventario_spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Produccion")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Produccion")
    private int idProduccion;

    @Column(name = "Fecha_Produccion")
    @Temporal(TemporalType.DATE)
    private Date fechaProduccion;

    @Column(name = "Fecha_Vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "Lote")
    private String lote;

    @Column(name = "Cantidad_Producida")
    private int cantidadProducida;

    // Constructor vacío
    public Produccion() {}

    // Constructor completo
    public Produccion(int idProduccion, Date fechaProduccion, Date fechaVencimiento, String lote, int cantidadProducida) {
        this.idProduccion = idProduccion;
        this.fechaProduccion = fechaProduccion;
        this.fechaVencimiento = fechaVencimiento;
        this.lote = lote;
        this.cantidadProducida = cantidadProducida;
    }

    // Getters y Setters
    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(int cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    @Override
    public String toString() {
        return "Produccion{" +
                "idProduccion=" + idProduccion +
                ", fechaProduccion=" + fechaProduccion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", lote='" + lote + '\'' +
                ", cantidadProducida=" + cantidadProducida +
                '}';
    }
}
