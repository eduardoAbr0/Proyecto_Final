package com.autosamistosos.basedatos.modelo;

public class Venta {
    private int idVenta;
    private String fechaVenta;
    private double impuesto;
    private int costoLicencia;
    private String adicion;
    private String tipoPago;
    private double comision;
    private int idCliente;
    private int idEmpleado;
    private int idAuto;

    public Venta(int idVenta, String fechaVenta, double impuesto, int costoLicencia, String adicion, String tipoPago, double comision, int idCliente, int idEmpleado, int idAuto) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.impuesto = impuesto;
        this.costoLicencia = costoLicencia;
        this.adicion = adicion;
        this.tipoPago = tipoPago;
        this.comision = comision;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idAuto = idAuto;
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

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
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
                ", comision=" + comision +
                ", idCliente=" + idCliente +
                ", idEmpleado=" + idEmpleado +
                ", idAuto=" + idAuto +
                '}';
    }
}
