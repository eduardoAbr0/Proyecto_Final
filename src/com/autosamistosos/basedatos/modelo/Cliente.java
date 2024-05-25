package com.autosamistosos.basedatos.modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private int numeroCasa;
    private String calle;
    private String colonia;
    private int cp;
    private int telefono;
    private String RFC;

    public Cliente(int idCliente, String nombre, String pApellido, String sApellido, int numeroCasa, String calle, String colonia, int cp, int telefono, String RFC) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.telefono = telefono;
        this.RFC = RFC;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", pApellido='" + pApellido + '\'' +
                ", sApellido='" + sApellido + '\'' +
                ", numeroCasa=" + numeroCasa +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp=" + cp +
                ", telefono=" + telefono +
                '}';
    }

    
}
