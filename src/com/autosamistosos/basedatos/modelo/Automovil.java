package com.autosamistosos.basedatos.modelo;

public class Automovil {
    private int idAutomovil;
    private String modeloA;
    private String precio;
    private double precioAutomovil;
    private String fechaFab;
    private int pesoAutomovil;
    private byte cilindroAutomovil;
    private String estado;
    private String seguro;
    private int kmAutomovil;
    private String garantiaAutomovil;

    public Automovil(int idAutomovil, String modeloA, String precio, double precioAutomovil, String fechaFab, int pesoAutomovil, byte cilindroAutomovil, String estado, String seguro, int kmAutomovil, String garantiaAutomovil) {
        this.idAutomovil = idAutomovil;
        this.modeloA = modeloA;
        this.precio = precio;
        this.precioAutomovil = precioAutomovil;
        this.fechaFab = fechaFab;
        this.pesoAutomovil = pesoAutomovil;
        this.cilindroAutomovil = cilindroAutomovil;
        this.estado = estado;
        this.seguro = seguro;
        this.kmAutomovil = kmAutomovil;
        this.garantiaAutomovil = garantiaAutomovil;
    }

    public int getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(int idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getModeloA() {
        return modeloA;
    }

    public void setModeloA(String modeloA) {
        this.modeloA = modeloA;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public double getPrecioAutomovil() {
        return precioAutomovil;
    }

    public void setPrecioAutomovil(double precioAutomovil) {
        this.precioAutomovil = precioAutomovil;
    }

    public String getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(String fechaFab) {
        this.fechaFab = fechaFab;
    }

    public int getPesoAutomovil() {
        return pesoAutomovil;
    }

    public void setPesoAutomovil(int pesoAutomovil) {
        this.pesoAutomovil = pesoAutomovil;
    }

    public byte getCilindroAutomovil() {
        return cilindroAutomovil;
    }

    public void setCilindroAutomovil(byte cilindroAutomovil) {
        this.cilindroAutomovil = cilindroAutomovil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getKmAutomovil() {
        return kmAutomovil;
    }

    public void setKmAutomovil(int kmAutomovil) {
        this.kmAutomovil = kmAutomovil;
    }

    public String getGarantiaAutomovil() {
        return garantiaAutomovil;
    }

    public void setGarantiaAutomovil(String garantiaAutomovil) {
        this.garantiaAutomovil = garantiaAutomovil;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "idAutomovil=" + idAutomovil +
                ", modeloA='" + modeloA + '\'' +
                ", precio='" + precio + '\'' +
                ", precioAutomovil=" + precioAutomovil +
                ", fechaFab='" + fechaFab + '\'' +
                ", pesoAutomovil=" + pesoAutomovil +
                ", cilindroAutomovil=" + cilindroAutomovil +
                ", estado='" + estado + '\'' +
                ", seguro='" + seguro + '\'' +
                ", kmAutomovil=" + kmAutomovil +
                ", garantiaAutomovil='" + garantiaAutomovil + '\'' +
                '}';
    }
}
