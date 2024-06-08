package com.autosamistosos.basedatos.modelo;

public class Automovil {
    private int idAutomovil;
    private String modeloA;
    private String color;
    private double precioAutomovil;
    private String fechaFab;
    private int pesoAutomovil;
    private int cilindroAutomovil;
    private String estado;
    private String seguro;
    private int kmAutomovil;
    private String garantiaAutomovil;
    private String paisFab;
    private String estadoFab;
    private int capacidad;

    public Automovil(int idAutomovil, String modeloA, double precioAutomovil, String fechaFab,String paisFab,String estadoFab, int pesoAutomovil, int cilindroAutomovil,  String color, int capacidad,String estado) {
        this.idAutomovil = idAutomovil;
        this.modeloA = modeloA;
        this.color = color;
        this.precioAutomovil = precioAutomovil;
        this.fechaFab = fechaFab;
        this.pesoAutomovil = pesoAutomovil;
        this.cilindroAutomovil = cilindroAutomovil;
        this.estado = estado;
        this.paisFab = paisFab;
        this.estadoFab = estadoFab;
        this.capacidad = capacidad;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(int capacidad){
        this.capacidad = capacidad;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getCilindroAutomovil() {
        return cilindroAutomovil;
    }

    public void setCilindroAutomovil(int cilindroAutomovil) {
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

    public String getPaisFab() {
        return paisFab;
    }

    public void setPaisFab(String paisFab) {
        this.paisFab = paisFab;
    }

    public String getEstadoFab() {
        return estadoFab;
    }

    public void setEstadoFab(String estadoFab) {
        this.estadoFab = estadoFab;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "idAutomovil=" + idAutomovil +
                ", modeloA='" + modeloA + '\'' +
                ", color='" + color + '\'' +
                ", precioAutomovil=" + precioAutomovil +
                ", fechaFab='" + fechaFab + '\'' +
                ", pesoAutomovil=" + pesoAutomovil +
                ", cilindroAutomovil=" + cilindroAutomovil +
                ", estado='" + estado + '\'' +
                ", seguro='" + seguro + '\'' +
                ", kmAutomovil=" + kmAutomovil +
                ", garantiaAutomovil='" + garantiaAutomovil + '\'' +
                ", paisFab='" + paisFab + '\'' +
                ", estadoFab='" + estadoFab + '\'' +
                '}';
    }
}
