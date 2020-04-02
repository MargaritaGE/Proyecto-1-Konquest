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
public class Guerrero extends Entidad{
    private String ataque;
    private int lugaresNave;
    private double porcentajeMuerte;
    private int cantGuerreros;
    private double totalMuerte;
    
    //crea guerreros nuevos
    public void crearGuerrero(String tipoPlaneta, double muertePlaneta, int guerreros){
        this.tipo = calcularTipo(tipoPlaneta);
        this.ataque = calcularAtaque();
        this.lugaresNave = calcularLugares();
        this.porcentajeMuerte = calcularMuerte(muertePlaneta);
        this.totalMuerte = this.porcentajeMuerte * this.cantGuerreros;
        this.cantGuerreros = guerreros;
    }
    
    //muestra los datos del guerrero en pantalla
    public void mostrarDatos(){
        System.out.printf("Hay %d guerreros %s, su ataque especial es %s.\n", this.cantGuerreros, this.tipo, this.ataque);
        System.out.printf("Cada uno ocupa %d posiciones en una nave.\n", this.lugaresNave);
        System.out.printf("Cada uno posee un porcentaje de muerte de %f.\n", this.porcentajeMuerte);
    }
    
    //devuelve tipo de guerrero
    public String calcularTipo(String tipoPlaneta){
        String guerrero = null;
        switch (tipoPlaneta) {
            case "Tierra":
                guerrero = "Mole";
                break;
            case "Agua":
                guerrero = "Nemo";
                break;
            case "Fuego":
                guerrero = "Magma";
                break;
            case "Orgánico":
                guerrero = "Groot";
                break;
            case "Radioactivo":
                guerrero = "Fision Guy";
                break;
        }
        return guerrero;
    }
    
    //devuelve ataque de guerrero
    public String calcularAtaque(){
        String ataqueGuerrero = null;
        switch (this.tipo) {
            case "Mole":
                ataqueGuerrero = "Entierra a sus víctimas.";
                break;
            case "Nemo":
                ataqueGuerrero = "Lanza un turbo chorro venenoso al enemigo. ";
                break;
            case "Magma":
                ataqueGuerrero = "Lanza bolas de lava.";
                break;
            case "Groot":
                ataqueGuerrero = "Toca el suelo y tiene enredaderas trampa.";
                break;
            case "Fision Guy":
                ataqueGuerrero = "Lanza un ataque con rayos gama que derrite al enemigo.";
                break;
        }
        return ataqueGuerrero;
    }
    
    //calcula la cantidad de lugares que ocupa cada guerrero en nave
    public int calcularLugares(){
        int lugares = 0;
        switch (this.tipo) {
            case "Mole":
                lugares = 1;
                break;
            case "Nemo":
                lugares = 1;
                break;
            case "Magma":
                lugares = 2;
                break;
            case "Groot":
                lugares = 3;
                break;
            case "Fision Guy":
                lugares = 4;
                break;
        }
        return lugares;
    }
    
    //calcula procentaje de muerte
    public double calcularMuerte(double muertePlaneta){
        double muerte = 0;
        switch (this.tipo) {
            case "Mole":
                muerte = 1.5;
                break;
            case "Nemo":
                muerte = 1.6;
                break;
            case "Magma":
                muerte = 1.75;
                break;
            case "Groot":
                muerte = 1.85;
                break;
            case "Fision Guy":
                muerte = 1.95;
                break;
        }
        return (muerte * muertePlaneta);
    }
}
