/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.margaritagarcia.proyecto1ipc1;
import java.util.Scanner;
/**
 *
 * @author margarita
 */
public class Planeta extends Entidad{
    //declaración de variables
    private String nombrePlaneta;
    private double porcentajeMuerte;
    private int dinero;
    private int cantConstructores;
    private int cantNaves;
    private int cantGuerreros;
    private int posicionFila;
    private int posicionColumna;
    private String dueño;
    
    //crea los planetas
    public void crearPlaneta(int numero, String nombre, int fila, int columna){
        String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        this.nombrePlaneta = alfabeto[numero];
        this.tipo = calcularTipo();
        this.porcentajeMuerte = calcularMuerte();
        this.dinero = calcularDinero();
        this.cantConstructores = 1;
        this.cantNaves = calcularNaves();
        this.cantGuerreros = calcularGuerreros();
        this.dueño = nombre;
        this.posicionFila = fila;
        this.posicionColumna = columna;
    }
    
    //permite al usuario editar x planeta
    public void editarPlaneta(){
        Scanner scanner = new Scanner(System.in);
        mostrarDatos();
        
        System.out.println("Ingrese nombre de planeta.");
        this.nombrePlaneta = scanner.nextLine();
        System.out.println("Ingrese cantidad de galactus.");
        this.dinero = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese cantidad de constructores.");
        this.cantConstructores = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese cantidad de naves.");
        this.cantNaves = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese cantidad de guerreros.");
        this.cantGuerreros = Integer.parseInt(scanner.nextLine());
    }
    
    //muestra datos de un planeta
    public void mostrarDatos(){
        System.out.printf("Planeta: %s\n", this.nombrePlaneta);
        System.out.printf("Tipo de planeta: %s\n", this.tipo);
        System.out.printf("Porcentaje de muerte: %f\n", this.porcentajeMuerte);
        System.out.printf("Dinero: %d\n", this.dinero);
        System.out.printf("Cantidad de constructores: %d\n", this.cantConstructores);
        System.out.printf("Cantidad de naves: %d\n", this.cantNaves);
        System.out.printf("Cantidad de guerreros: %d\n", this.cantGuerreros);
        System.out.printf("El planeta es: %s\n", this.dueño);
        System.out.println();
    }
    
    //calcula tipo de planeta
    public String calcularTipo(){
        int probabilidad;
        probabilidad = (int)(Math.random()*100 + 1);
        if (probabilidad <= 45){
            return "Tierra";
        }else if ((probabilidad > 45) && (probabilidad <= 70)){
            return "Agua";
        }else if ((probabilidad > 70) && (probabilidad <= 85)){
            return "Fuego";
        }else if ((probabilidad > 85) && (probabilidad <= 95)){
            return "Orgánico";
        }else if (probabilidad > 95){
            return "Radioactivo";
        }
        return null;
    }
    
    //calcula cantidad de naves iniciales
    public int calcularNaves(){
        int cantidad;
        cantidad = (int)(Math.random()*2 + 1);
        return cantidad;
    }
    
    //calcula cantidad de guerreros iniciales
    public int calcularGuerreros(){
        int cantidad = 0;
        switch (this.tipo) {
            case "Tierra":
                cantidad = (int)(Math.random()*11 + 15);
                break;
            case "Agua":
                cantidad = (int)(Math.random()*12 + 12);
                break;
            case "Fuego":
                cantidad = (int)(Math.random()*11 + 10);
                break;
            case "Orgánico":
                cantidad = (int)(Math.random()*11 + 5);
                break;
            case "Radioactivo":
                cantidad = (int)(Math.random()*7 + 3);
                break;
        }
        return cantidad;
    }
    
    //calcula el porcentaje de muerte del planeta
    public double calcularMuerte(){
        double muerte = 0;
        
        //genera valor de muerte entre 0.1 y 0.9999
        while (muerte < 0.1){
            muerte = Math.random();
        }
        
        //redondea a solo 4 decimales
        muerte = (double)Math.round(muerte *10000d)/10000;
        return muerte;
    }
    
    //calcula dinero
    public int calcularDinero(){
        int cantidad;
        cantidad = (int)(Math.random()*401 + 100);
        return cantidad;
    }
    

}


