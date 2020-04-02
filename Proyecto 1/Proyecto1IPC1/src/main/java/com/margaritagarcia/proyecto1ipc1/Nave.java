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
public class Nave extends Entidad{
    private double velocidad;
    private int espaciosNave;
    private int costoProduccion;
    private String constructor;
    
    //crea la nave
    public void crearNave(String constructor){
        this.tipo = calcularNave();
        this.costoProduccion = calcularCosto();
        this.espaciosNave = calcularEspacios();
        this.velocidad = calcularVelocidad();
        this.constructor = constructor;
    }
    
    //muestra datos de la nave
    public void mostrarDatos(){
        System.out.printf("Esta nave es %s y solo la puede construir un %s.\n", this.tipo, this.constructor);
        System.out.printf("Tiene un costo de producción y de venta de %d galactus.\n", this.costoProduccion);
        System.out.printf("Consta de %d espacios. Tiene una velocidad de %f años luz.\n", this.espaciosNave, this.velocidad);
    }
    
    //determina el tipo de nave dependiendo del constructor
    public String calcularNave(){
        String nave = null;
        switch (this.constructor){
            case "Obrero" :
                nave = "Naboo N-1";
                break;
            case "Maestro de Obra" :
                nave = "X-Wing";
                break;
            case "Arquitecto" :
                nave = "Millenial Falcon";
                break;
            case "Ingeniero" :
                nave = "Star Destroyer";
                break;
        }    
        return nave;
    }
    
    //devuelve el costo de produccion de la nave dependiendo del tipo
    public int calcularCosto(){
        int costo = 0;
        switch (this.tipo){
            case "Naboo N-1" :
                costo = 40;
                break;
            case "X-Wing" :
                costo = 50;
                break;
            case "Millenial Falcon" :
                costo = 70;
                break;
            case "Star Destroyer" :
                costo = 100;
                break;
        }    
        return costo;
    }
    
    //devuelve la cantidad de espacios en la nave dependiendo del tipo
    public int calcularEspacios(){
        int espacios = 0;
        switch (this.tipo){
            case "Naboo N-1" :
                espacios = 25;
                break;
            case "X-Wing" :
                espacios = 42;
                break;
            case "Millenial Falcon" :
                espacios = 58;
                break;
            case "Star Destroyer" :
                espacios = 80;
                break;
        }    
        return espacios;
    }
    
    //devuelve la velocidad de la nave dependiendo del tipo
    public double calcularVelocidad(){
        double rapidez = 0;
        switch (this.tipo){
            case "Naboo N-1" :
                rapidez = 1;
                break;
            case "X-Wing" :
                rapidez = 1.25;
                break;
            case "Millenial Falcon" :
                rapidez = 1.5;
                break;
            case "Star Destroyer" :
                rapidez = 1.75;
                break;
        }    
        return rapidez;
    }
}
