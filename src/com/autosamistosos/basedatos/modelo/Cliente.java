package com.autosamistosos.basedatos.modelo;

public class Cliente {
    private int idCliente;
    private String correo;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private int numeroCasa;
    private String calle;
    private String colonia;
    private int cp;
    private String RFC;
    private int telefono;
    protected int idEmpleado;


    public Cliente(int idCliente, String correo, String nombre, int idEmpleado) {
        this.idCliente = idCliente;
        this.correo = correo;
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pApellido='" + pApellido + '\'' +
                ", sApellido='" + sApellido + '\'' +
                ", numeroCasa=" + numeroCasa +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp=" + cp +
                ", RFC='" + RFC + '\'' +
                ", telefono=" + telefono +
                ", idEmpleado=" + idEmpleado +
                '}';
    }
}
