package com.autosamistosos.basedatos.modelo;

public class Licencia {
    private int idLicencia;
    private String fechaEmision;
    private String fechaExpiracion;
    private int clienteId;
    private int autoId;

    public Licencia(int idLicencia, String fechaEmision, String fechaExpiracion, int clienteId, int autoId) {
        this.idLicencia = idLicencia;
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
        this.clienteId = clienteId;
        this.autoId = autoId;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    @Override
    public String toString() {
        return "Licencia{" +
                "idLicencia=" + idLicencia +
                ", fechaEmision='" + fechaEmision + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", clienteId=" + clienteId +
                ", autoId=" + autoId +
                '}';
    }
}
