package com.autosamistosos.basedatos.modelo;

public class Venta {
    private int idVenta;
    private String fechaVenta;
    private double impuesto;
    private int costoLicencia;
    private String adicion;
    private String tipoPago;

    public Venta(int idVenta, String fechaVenta, double impuesto, int costoLicencia, String adicion, String tipoPago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.impuesto = impuesto;
        this.costoLicencia = costoLicencia;
        this.adicion = adicion;
        this.tipoPago = tipoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public int getCostoLicencia() {
        return costoLicencia;
    }

    public void setCostoLicencia(int costoLicencia) {
        this.costoLicencia = costoLicencia;
    }

    public String getAdicion() {
        return adicion;
    }

    public void setAdicion(String adicion) {
        this.adicion = adicion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", impuesto=" + impuesto +
                ", costoLicencia=" + costoLicencia +
                ", adicion='" + adicion + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}
