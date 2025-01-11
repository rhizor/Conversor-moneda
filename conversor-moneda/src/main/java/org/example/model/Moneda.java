package org.example.model;


public class Moneda {
    private String codigo;
    private String nombre;
    private double tasaCambio;


    // Constructor vacío
    public Moneda() {}


    // Constructor completo
    public Moneda(String codigo, String nombre, double tasaCambio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tasaCambio = tasaCambio;
    }


    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getTasaCambio() {
        return tasaCambio;
    }


    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }


    // Método toString para representación en texto
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }


    // Método para convertir un monto
    public double convertir(double monto) {
        return monto * tasaCambio;
    }
}
