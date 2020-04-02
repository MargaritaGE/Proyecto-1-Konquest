/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.Scanner;
import com.margaritagarcia.proyecto1ipc1.Mapa;
import com.margaritagarcia.proyecto1ipc1.Planeta;

/**
 *
 * @author margarita
 */
public class KonquestMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jugadas = 0;
        Mapa[] mapitas = new Mapa[30];
        int cantMapas = 0;
        int opcion = 0;
        String nombre;
        int posicion = -1;
        int salir = 0;
        
        for (int i = 0; i < mapitas.length; i++){
            mapitas[i] = new Mapa();
        }

        // TODO code application logic here
        //repite las instrucciones si el usuario aun no desea salir
        do{
            //repite las instrucciones por si ingresa una opcion incorrecta
            do{
                System.out.printf("Bienvenido al juego Konquest.\n");
                
                //permite al usuario crear un primer mapa
                if (cantMapas == 0){
                    System.out.println("Para iniciar a jugar, primero deberás de crear un mapa.\n");
                    mapitas[0].crearMapa();
                    cantMapas += 1;
                }else if (cantMapas > 0){
                    
                    //Le da las opciones al usuario
                    System.out.println("Escribe el numero de lo que deseas hacer.");
                    System.out.println("1. crear mapa nuevo.");
                    System.out.println("2. editar mapa ya existente.");
                    System.out.println("3. iniciar a jugar.");
                    opcion = Integer.parseInt(scanner.nextLine());
                    
                    //realiza instruccion dependiendo de la opcion
                    if (opcion == 1){
                        mapitas[cantMapas].crearMapa();
                        cantMapas +=1;
                    }else if (opcion == 2){
                        //repite las instrucciones si ingresa un nombre de mapa incorrecto
                        do{
                            //muestra el nombre de los mapas existentes
                            System.out.println("Estos son los mapas disponibles.");
                            for (int n = 0; n <= cantMapas; n++){
                                System.out.println(mapitas[n].nombreMapa());
                            }
                            
                            System.out.println("Ingrese el nombre del mapa que desea editar.");
                            nombre = scanner.nextLine().toLowerCase();
                            
                            //evalua si existe ese mapa
                            for (int n = 0; n <= cantMapas; n++){
                                if (nombre.equals(mapitas[n].nombreMapa())){
                                posicion = n;
                                break;
                                }
                            }
                            
                            //lanza mensaje de error si no existe el nombre de mapa que se ingreso
                            if (posicion == -1){
                                System.out.println("No existe ese mapa.");
                            }
                            
                            //manda al usuario a editar el mapa que desea
                            if (posicion != -1){
                                //edita las caracteristicas del mapa
                                mapitas[posicion].editarMapa();
                            }
                        }while (posicion == -1);
                
                    //muestra un mensaje de error si la opción ingresada es erronea
                    }else if ((opcion < 1) || (opcion > 3)){
                        System.out.println("No existe esa opción. Por favor ingrese una opción correcta.");
                    }
                
                }
            }while (opcion != 3);
            
            //repite las instrucciones si ingresa un nombre de mapa incorrecto
            do{
                //muestra el nombre de los mapas existentes
                System.out.println("Estos son los mapas disponibles.");
                for (int n = 0; n <= cantMapas; n++){
                    System.out.println(mapitas[n].nombreMapa());
                }
                        
                System.out.println("Ingrese el nombre del mapa en el que desea jugar.");
                nombre = scanner.nextLine().toLowerCase();
                            
                //evalua si existe ese mapa
                for (int n = 0; n <= cantMapas; n++){
                    if (nombre.equals(mapitas[n].nombreMapa())){
                        posicion = n;
                        break;
                    }
                }
                        
                //lanza mensaje de error si no existe el nombre de mapa que se ingreso
                if (posicion == -1){
                    System.out.println("No existe ese mapa.");
                }
                            
                //manda al usuario a jugar con ese mapa
                if (posicion != -1){
                    mapitas[posicion].jugarMapa();
                }
            }while (posicion == -1);
            
        }while (salir != 1);
        
        

    }
    
       //permite al usuario visualizar todos los planetas en x mapa
}
