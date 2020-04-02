/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.margaritagarcia.proyecto1ipc1;
import com.margaritagarcia.proyecto1ipc1.Planeta;
import java.util.Scanner;

/**
 *
 * @author margarita
 */
public class Mapa {
    //declaracion de variables
    private String nombreMapa;
    private int filas;
    private int columnas;
    private int planetasNeutrales;
    private String[] jugadores = new String[2];
    private Planeta[] planetas = new Planeta[10];
    private String[][] posicionesPlanetas = new String[10][10];

    
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    

    public static final String ANSI_WHITE = "\u001B[37m";
    
    //creación mapas
    public void crearMapa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creación de un mapa.");
        System.out.println("Ingrese el nombre del mapa.");
        this.nombreMapa = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese cantidad de filas.");
        this.filas = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese cantidad de columnas.");
        this.columnas = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese cantidad de planetas neutrales.");
        this.planetasNeutrales = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nombre del Jugador 1.");
        this.jugadores[0] = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese el nombre del Jugador 2.");
        this.jugadores[1] = scanner.nextLine().toLowerCase();
        System.out.println();
        planetas();
        generarPlanetas();
    }
         
    
    
    
    public void planetas(){
        for (int i = 0; i < planetas.length; i++){
            planetas[i] = new Planeta();
        }
    }
    
    //edita mapas
    public void editarMapa(){
        Scanner scanner = new Scanner(System.in);
        
        mostrarDatos();
        System.out.println("Ingrese nuevo nombre.");
        this.nombreMapa = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese nueva cantidad de filas.");
        this.filas = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese nueva cantidad de columnas.");
        this.columnas = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese nueva cantidad de planetas neutrales.");
        this.planetasNeutrales = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nombre del Jugador 1.");
        this.jugadores[0] = scanner.nextLine().toLowerCase();
        System.out.println("Ingrese el nombre del Jugador 2.");
        this.jugadores[1] = scanner.nextLine().toLowerCase();
        System.out.println();
    }
    
    //muestra datos de mapas
    public void mostrarDatos(){
        System.out.printf("El mapa %s tiene %d filas, %d columnas y %d planetas neutrales.\n", this.nombreMapa, this.filas, this.columnas, this.planetasNeutrales);
        System.out.printf("Sus jugadores son %s y %s\n", jugadores[0], jugadores[1]);
        System.out.println();
    }
    
    //muestra datos de planetas
    public void mostrarPlanetas(){
        for (int n = 0; n <= this.planetasNeutrales +1; n++){
            planetas[n].mostrarDatos();
        }
    }
    
    //muestra mapa en pantalla
    public void mostrarMapa(){
        
        String[] abecedario = {"a", "b", "c", "d", "e", "f", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
 
        //imprime cada fila -------
        for (int f = 0; f <= this.filas; f++){
            
            //imprime el encabezado de cada columna
            if (f == 0){
                for (int c = 0; c <= this.columnas; c++){
                    if (c == 0){
                        System.out.printf(" ");
                    }else if (c < this.columnas){
                        System.out.printf("   %s    *", abecedario[c - 1]);
                    }else if (c == this.columnas){
                        System.out.printf("   %s    *\n", abecedario[c - 1]);
                    }
                }
            }
            
            //imprime cada inicio de columna |
            for (int c = 0; c < this.columnas; c++){
                if (c == 0){
                    System.out.printf(" ");
                }else if ((c > 0) && (c < (this.columnas - 1))){
                    System.out.printf("* * * * * ");
                }else if (c == (this.columnas - 1)){
                    System.out.printf("* * * * * \n");
                }
            }
            
            //imprime altura a cada columna
            for (int a = 0; a <= 2; a++){
                if (a == 1){
                    System.out.print(f + 1);
                }
                for (int c = 0; c < this.columnas; c++){
                    if (c < (this.columnas - 1)){
                        System.out.printf("         *");
                    }else if (c == (this.columnas - 1)){
                        System.out.printf("         *\n");
                    }
                }
            }
        }
        
        //imprime el cierre de las columnas
        for (int c = 0; c < this.columnas; c++){
            if (c < (this.columnas - 1)){
                System.out.printf("* * * * * * ");
            }else if (c == (this.columnas - 1)){
                System.out.printf("* * * * * * \n");
            }
        }
    }
    
    //devuelve cantidad de planetas neutrales
    public int cantPlanetas(){
        return this.planetasNeutrales;
    }
    
    //decuelve el nombre del mapa
    public String nombreMapa(){
        return this.nombreMapa;
    }
    
    //genera la posicion de x planeta
    public String posicionPlaneta(){
        boolean resultado = false;
        String posicion;
        int fila;
        int columna;
        
        //se repite el ciclo cada vez que se genera una 
        //posición que ya se habia generado con anterioridad
        do{
            fila = (int)(Math.random()*this.filas);
            columna = (int)(Math.random()*this.columnas);
            posicion = String.valueOf(fila) + String.valueOf(columna);
               
            //evalua si la posicion generada ya existia
            for (int f = 0; f <= this.filas; f++){
                for (int c = 0; c <= this.columnas; c++){
                    if (posicion.equals(this.posicionesPlanetas[f][c])){
                        resultado = true;
                        break;
                        }
                }
            }
        }while(resultado);
        
        this.posicionesPlanetas[fila][columna] = posicion;
        return posicion;
    }
    
    //devuelve la fila de x planeta
    public int filaPlaneta(String posicion){
        int ubicacionFila = (Integer.parseInt(posicion)/10);
        
        return ubicacionFila;
    }
    
    //devuelve la columna de x planeta
    public int columnaPlaneta(String posicion){
        int ubicacionColumna = (Integer.parseInt(posicion)%10);
        
        return ubicacionColumna;
    }
    
    //genera los planetas del mapa
    public void generarPlanetas(){
        //genera los planetas neutrales solicitados
        for (int n = 0; n <= this.planetasNeutrales; n++){
            this.planetas[n].crearPlaneta(n, "neutral", filaPlaneta(posicionPlaneta()), columnaPlaneta(posicionPlaneta()));
        }
        
        //genera los planetas de los jugadores
        for (int n = this.planetasNeutrales -1; n <= this.planetasNeutrales + 1; n++){
            this.planetas[n].crearPlaneta(n, jugadores[n], filaPlaneta(posicionPlaneta()), columnaPlaneta(posicionPlaneta()));
        }
    }
    
    //se empieza la partida
    public void jugarMapa(){
        System.out.println("Hasta aqui llegue");
    }
}
