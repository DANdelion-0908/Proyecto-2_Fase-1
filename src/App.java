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

 import java.io.PrintWriter;
import java.util.LinkedList;

import Burger.Burger;
import DataBase.EmbeddedNeo4j;

public class App {
    public static void main(String[] args) {

        try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "bolt://3.236.163.127:7687", "neo4j", "alphabets-slopes-conn" ) ) {
            
        	LinkedList<String> mcBurgers = db.getMcBurgers();
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
            
            /*for(String string : myactors) {
                LinkedList<String> myMovies = db.getMoviesByActor(string);
                System.out.println(string + " ha actuado en: "+ myMovies);
            }
            */
            System.out.println("");
            
            //db.insertMovie("Kingsman", 2016, "XD");
            
            //System.out.println("Película agregada exitosamente.");
           
       } catch (Exception e) {
           e.printStackTrace();
       }

       /* 
       System.out.println("Algoritmo de Recomendación de Hamburguesas \n");
       
       System.out.println("Responde a las preguntas que te parecerán a continuación para recomendarte una hamburguesa. \n");
       
        Burger createBurger = new Burger();

        createBurger.BreadSelection();
        createBurger.MeatSelection();
        createBurger.VegetablesSelection();
        createBurger.showMenu();

        System.out.println("");

        System.out.println("La hamburguesa que te recomendamos en base a tus gustos es: " + createBurger.showRecommendation());
        */
    }
}
