package com.autosamistosos.basedatos.modelo;

public class Factura {
    private int idFactura;
    private double precioF;
    private String financiamiento;
    private String fechaEm;
    private int idCliente;
    private int idVenta;
    private int idAuto;

    public Factura(int idFactura, double precioF, String financiamiento, String fechaEm, int idCliente, int idVenta, int idAuto) {
        this.idFactura = idFactura;
        this.precioF = precioF;
        this.financiamiento = financiamiento;
        this.fechaEm = fechaEm;
        this.idCliente = idCliente;
        this.idVenta = idVenta;
        this.idAuto = idAuto;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public Factura(int idFactura, double precioF, String financiamiento, String fechaEm) {
        this.idFactura = idFactura;
        this.precioF = precioF;
        this.financiamiento = financiamiento;
        this.fechaEm = fechaEm;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getPrecioF() {
        return precioF;
    }

    public void setPrecioF(double precioF) {
        this.precioF = precioF;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public String getFechaEm() {
        return fechaEm;
    }

    public void setFechaEm(String fechaEm) {
        this.fechaEm = fechaEm;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", precioF=" + precioF +
                ", financiamiento='" + financiamiento + '\'' +
                ", fechaEm='" + fechaEm + '\'' +
                '}';
    }
}
