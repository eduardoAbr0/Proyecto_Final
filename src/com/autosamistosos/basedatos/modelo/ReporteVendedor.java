package com.autosamistosos.basedatos.modelo;

public class ReporteVendedor {
    private int idReporte;
    private String mes;
    private int ventaId;

    public ReporteVendedor(int idReporte, String mes, int ventaId) {
        this.idReporte = idReporte;
        this.mes = mes;
        this.ventaId = ventaId;
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

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public String toString() {
        return "ReporteVendedor{" +
                "idReporte=" + idReporte +
                ", mes='" + mes + '\'' +
                ", ventaid=" + ventaId +
                '}';
    }
}
