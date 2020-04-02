/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.margaritagarcia.proyecto1ipc1;

/**
 *
 * @author margarita
 */
public class Constructor extends Entidad{
    private int tiempoConstruccion;
    private String tipoNave;
    private int precioCompra;
    private int precioVenta;
    private int constructoresDisponibles;
    
    //crea un nuevo constructor
    public void crearConstructor(int constructores, String constructor){
        this.tipo = constructor;
        this.tipoNave = calcularNave();
        this.tiempoConstruccion = calcularTiempo();
        this.precioCompra = calcularCompra();
        this.precioVenta = calcularVenta();
        this.constructoresDisponibles = constructores;
        
    }
    
    //muestra datos del constructor
    @Override
    public void mostrarDatos(){
        System.out.printf("Tipo de constructor: %s.\n", this.tipo);
        System.out.printf("Puede construir naves %s.\n", this.tipoNave);
        System.out.printf("Tiene un precio de compra en tienda de %d galactus.\n", this.precioCompra);
        System.out.printf("Tiene un precio de venta en tienda de %d galactus.\n", this.precioVenta);
        System.out.printf("Tiene %d constructores disponibles.\n", this.constructoresDisponibles);
    }
    
    //calcula tipo de nave a construir
    public String calcularNave(){
        String nave = null;
        switch (this.tipo) {
            case "Obrero":
                nave = "Naboo N-1";
                break;
            case "Maestro de Obra":
                nave = "X-Wing";
                break;
            case "Arquitecto":
                nave = "Millenial Falcon";
                break;
            case "Ingeniero":
                nave = "Star Destroyer";
                break;
        }
        return nave;
    }
    
    //devuelve el tiempo que tarda en construir una nave
    public int calcularTiempo(){
        int tiempo = 0;
        switch (this.tipo) {
            case "Obrero":
                tiempo = 3;
                break;
            case "Maestro de Obra":
                tiempo = 2;
                break;
            case "Arquitecto":
                tiempo = 1;
                break;
            case "Ingeniero":
                tiempo = 1;
                break;
        }
        return tiempo;
    }
    
    //calcula precio de compra
    public int calcularCompra(){
        int precio = 0;
        switch (this.tipo) {
            case "Obrero":
                precio = 50;
                break;
            case "Maestro de Obra":
                precio = 100;
                break;
            case "Arquitecto":
                precio = 250;
                break;
            case "Ingeniero":
                precio = 300;
                break;
        }
        return precio;
    }
    
    //calcula precio de venta
    public int calcularVenta(){
        int precio = 0;
        switch (this.tipo) {
            case "Obrero":
                precio = 40;
                break;
            case "Maestro de Obra":
                precio = 70;
                break;
            case "Arquitecto":
                precio = 175;
                break;
            case "Ingeniero":
                precio = 200;
                break;
        }
        return precio;
    }

}
