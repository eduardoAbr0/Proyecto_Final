package com.autosamistosos.basedatos.modelo;

public class Factura {
    private int idFactura;
    private double precioF;
    private String financiamiento;
    private String fechaEm;

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
