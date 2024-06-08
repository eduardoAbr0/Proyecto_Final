package com.autosamistosos.basedatos.modelo;

public class Encuesta {
    private int idEncuesta;
    private String opAutomovil;
    private String opVendedor;
    private String opDistribuidora;
    private int clienteId;
    private int automovilId;

    public Encuesta(int idEncuesta, String opAutomovil, String opVendedor, String opDistribuidora, int clienteId, int automovilId) {
        this.idEncuesta = idEncuesta;
        this.opAutomovil = opAutomovil;
        this.opVendedor = opVendedor;
        this.opDistribuidora = opDistribuidora;
        this.clienteId = clienteId;
        this.automovilId = automovilId;
    }

    public int getAutomovilId() {
        return automovilId;
    }

    public void setAutomovilId(int automovilId) {
        this.automovilId = automovilId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getOpDistribuidora() {
        return opDistribuidora;
    }

    public void setOpDistribuidora(String opDistribuidora) {
        this.opDistribuidora = opDistribuidora;
    }

    public String getOpVendedor() {
        return opVendedor;
    }

    public void setOpVendedor(String opVendedor) {
        this.opVendedor = opVendedor;
    }

    public String getOpAutomovil() {
        return opAutomovil;
    }

    public void setOpAutomovil(String opAutomovil) {
        this.opAutomovil = opAutomovil;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "idEncuesta=" + idEncuesta +
                ", opAutomovil='" + opAutomovil + '\'' +
                ", opVendedor='" + opVendedor + '\'' +
                ", opDistribuidora='" + opDistribuidora + '\'' +
                ", clienteId=" + clienteId +
                ", automovilId=" + automovilId +
                '}';
    }
}
