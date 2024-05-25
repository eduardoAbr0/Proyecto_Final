package com.autosamistosos.basedatos.modelo;

public class Encuesta {
    private int idEncuesta;
    private String opAutomovil;
    private String opVendedor;
    private String opDistribuidora;

    public Encuesta(int idEncuesta, String opAutomovil, String opVendedor, String opDistribuidora) {
        this.idEncuesta = idEncuesta;
        this.opAutomovil = opAutomovil;
        this.opVendedor = opVendedor;
        this.opDistribuidora = opDistribuidora;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getOpAutomovil() {
        return opAutomovil;
    }

    public void setOpAutomovil(String opAutomovil) {
        this.opAutomovil = opAutomovil;
    }

    public String getOpVendedor() {
        return opVendedor;
    }

    public void setOpVendedor(String opVendedor) {
        this.opVendedor = opVendedor;
    }

    public String getOpDistribuidora() {
        return opDistribuidora;
    }

    public void setOpDistribuidora(String opDistribuidora) {
        this.opDistribuidora = opDistribuidora;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "idEncuesta=" + idEncuesta +
                ", opAutomovil='" + opAutomovil + '\'' +
                ", opVendedor='" + opVendedor + '\'' +
                ", opDistribuidora='" + opDistribuidora + '\'' +
                '}';
    }
}
