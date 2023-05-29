/*--------------------------------------------------
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * 
 * Proyecto 2
 * Fase 1
 * 
 * Tema: Algoritmo de Recomendación de hamburguesas
 * -------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Burger.Burger;
import DataBase.EmbeddedNeo4j;

public class App {

    public static void main(String[] args) {

        Burger createBurger = new Burger();

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Algoritmo de Recomendación de Hamburguesas \n");
        
        System.out.println("Menú Principal \n");
            System.out.println("Selecciona la opción que desees realizar: \n");
            System.out.println("1. Recomendarme una Hamburguesa.");
            System.out.println("2. Mostrar todas las hamburguesas.");
            System.out.println("3. Salir. \n");
            
            System.out.print("Tu opción: ");
            int mainOpt = inputScanner.nextInt();
            System.out.println("");
            
            if(mainOpt == 1) {
                System.out.println("Responde a las preguntas que te parecerán a continuación para recomendarte una hamburguesa. \n");
                createBurger.BreadSelection();
                createBurger.MeatSelection();
                createBurger.VegetablesSelection();
                createBurger.showMenu();
                System.out.println("La hamburguesa que te recomendamos en base a tus gustos es: " + createBurger.showRecommendation());
                System.out.println();

            } else if(mainOpt == 2) {
            	try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "bolt://54.174.202.194:7687", "neo4j", "beginner-lieutenants-haul" ) ) {
                    
                	LinkedList<String> mcBurgers = db.getMcBurgers();
                	
                	System.out.println("La prueba es: \n");
                	
                	ArrayList<String> test = db.getIngredients();
                	for(int i = 0; i < test.size(); i++) {
                		System.out.println(test.get(i));
                	}
                	
                	System.out.println("Las Hamburguesas ofrecidas por McDonald's son: \n");
                    
                    for (int i = 0; i < mcBurgers.size(); i++) {
                        System.out.println(mcBurgers.get(i));
                    }
                    
                    System.out.println("");
                    
                    LinkedList<String> dpBurgers = db.getDpBurgers();
                	System.out.println("Las Hamburguesas ofrecidas por DelPuente son: \n");
                    
                    for (int i = 0; i < dpBurgers.size(); i++) {
                        System.out.println(dpBurgers.get(i));
                    }
                    
                    System.out.println("");
                    
                    LinkedList<String> wdBurgers = db.getWdBurgers();
                	System.out.println("Las Hamburguesas ofrecidas por Wendy's son: \n");
                    
                    for (int i = 0; i < wdBurgers.size(); i++) {
                        System.out.println(wdBurgers.get(i));
                    }
                    
                    System.out.println("");

            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            	
            } else if(mainOpt == 3) {
            	System.out.println("Saliendo...");
                System.exit(0);
            }
            
       inputScanner.close();
    }
}
