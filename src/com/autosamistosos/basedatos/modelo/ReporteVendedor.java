package com.autosamistosos.basedatos.modelo;

public class ReporteVendedor {
    private int idReporte;
    private String mes;
    private double comision;

    public ReporteVendedor(int idReporte, String mes, double comision) {
        this.idReporte = idReporte;
        this.mes = mes;
        this.comision = comision;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "ReporteVendedor{" +
                "idReporte=" + idReporte +
                ", mes='" + mes + '\'' +
                ", comision=" + comision +
                '}';
    }
}
