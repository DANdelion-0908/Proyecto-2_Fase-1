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

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

import Burger.Burger;
import Burger.BurgersAndIngredients;
import Burger.RecommendBurger;
import DataBase.EmbeddedNeo4j;

public class App {

    public static void main(String[] args) {

        Burger createBurger = new Burger();
        
        BurgersAndIngredients burgersHashMap = new BurgersAndIngredients();
        
        RecommendBurger makeRecommendation = new RecommendBurger();
        
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("----------------------------------------------");
        System.out.println("| Algoritmo de Recomendación de Hamburguesas |");
        System.out.println("----------------------------------------------\n");
        
        System.out.println("Menú Principal \n");
        System.out.println("Selecciona la opción que desees realizar: \n");
        System.out.println("1. Recomendarme una Hamburguesa.");
        System.out.println("2. Mostrar todas las hamburguesas.");
        System.out.println("3. Salir. \n");
            
            System.out.print("Tu opción: ");
            int mainOpt = inputScanner.nextInt();
            System.out.println("");
            
            if(mainOpt == 1) {
            	try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "bolt://54.174.202.194:7687", "neo4j", "beginner-lieutenants-haul" ) ) {
            		LinkedList<String> mcBurgers = db.getMcBurgers();
            	
            		for (String mcName : mcBurgers) {
                    	ArrayList<String> value = db.getIngredients("McBurger", mcName);
                    	
                    	burgersHashMap.createBurgers(mcName, value);
					}
            		
            		LinkedList<String> dpBurgers = db.getDpBurgers();
            		
                    for (String dpName : dpBurgers) {
                    	ArrayList<String> value = db.getIngredients("DpBurger", dpName);
                    	
                    	burgersHashMap.createBurgers(dpName, value);
					}
                    
                    LinkedList<String> wdBurgers = db.getWdBurgers();
                    
                    for (String wdName : wdBurgers) {
                    	ArrayList<String> value = db.getIngredients("WdBurger", wdName);
                    	
                    	burgersHashMap.createBurgers(wdName, value);
					}
                    
                    createBurger.getMap(burgersHashMap.getburgersIngredients());
            	
            	}catch (Exception e) {
            		e.printStackTrace();
            	}
                System.out.println("Responde a las preguntas que te parecerán a continuación para recomendarte una hamburguesa. \n");
                createBurger.BreadSelection();
                createBurger.MeatSelection();
                createBurger.VegetablesSelection();
                createBurger.CheeseSelection();
                createBurger.showMenu();
                
                System.out.println("");
                
                ArrayList<String> burgersToCount = createBurger.showRecommendation();
                
                for(@SuppressWarnings("unused") String burgerName : burgersHashMap.getburgersIngredients().keySet()) {
                	makeRecommendation.countBurgers(burgersToCount);	
                }
                
        			
                System.out.println("Las hamburguesas que te recomendamos en base a tus gustos son: ");
                System.out.println("");
                
                System.out.println("-------------------------------------------------");
                System.out.println("| Hamburguesa           | Puntos de Coincidencia|");
                
                for(String key : makeRecommendation.getSelectBurgers().keySet()) {
                	int points = makeRecommendation.getSelectBurgers().get(key);
                	
                	System.out.println("-------------------------------------------------");
                	System.out.printf("| %-22s| %11d           |\n", key, points);
                }
                
                System.out.println("-------------------------------------------------\n");
                
                System.out.printf("La hamburguesa con la mayor cantidad de coincidencias es: %s con %d puntos.\n\n", makeRecommendation.getMax().entrySet().iterator().next().getKey(), makeRecommendation.getMax().entrySet().iterator().next().getValue());
                
                int i = 0;
                while(i == 0) {
                	try {
                		System.out.println("¿Desea volver al menú principal?\n");
                        
                        System.out.println("1. Volver al Menú.");
                        System.out.println("2. Salir \n");
                        
                        System.out.print("Tu opción: ");
                        int lastOpt = inputScanner.nextInt();
                        inputScanner.nextLine();
                        System.out.println("");
                        
                        switch(lastOpt) {
                        	case 1:
                        		i = 1;
                        		App.main(args);
                        	break;
                        	
                        	case 2:
                        		i = 1;
                        		System.out.println("Saliendo...");
                        		System.exit(0);
                        		
                        	default:
                        		System.out.println("Ingresa una opción válida\n");
                        }
                	} catch (Exception e) {
                		System.out.println("Ingresa caracteres válidos\n");
            			inputScanner.nextLine();
                	}
                }

            } else if(mainOpt == 2) {
            	try ( EmbeddedNeo4j db = new EmbeddedNeo4j( "bolt://54.174.202.194:7687", "neo4j", "beginner-lieutenants-haul" ) ) {
                    
                	LinkedList<String> mcBurgers = db.getMcBurgers();
                	
                	System.out.println("Las Hamburguesas ofrecidas por McDonald's son: \n");
                    
                    for (int i = 0; i < mcBurgers.size(); i++) {
                        System.out.println(mcBurgers.get(i));   
                    }
                    
                    for (String mcName : mcBurgers) {
                    	ArrayList<String> value = db.getIngredients("McBurger", mcName);
                    	
                    	burgersHashMap.createBurgers(mcName, value);
					}
                    
                    System.out.println("");
                    
                    LinkedList<String> dpBurgers = db.getDpBurgers();
                    
                	System.out.println("Las Hamburguesas ofrecidas por DelPuente son: \n");
                    
                    for (int i = 0; i < dpBurgers.size(); i++) {
                        System.out.println(dpBurgers.get(i));
                    }
                    
                    for (String dpName : dpBurgers) {
                    	ArrayList<String> value = db.getIngredients("DpBurger", dpName);
                    	
                    	burgersHashMap.createBurgers(dpName, value);
					}
                    
                    System.out.println("");
                    
                    LinkedList<String> wdBurgers = db.getWdBurgers();
                    
                	System.out.println("Las Hamburguesas ofrecidas por Wendy's son: \n");
                    
                    for (int i = 0; i < wdBurgers.size(); i++) {
                        System.out.println(wdBurgers.get(i));
                    }
                    
                    for (String wdName : wdBurgers) {
                    	ArrayList<String> value = db.getIngredients("WdBurger", wdName);
                    	
                    	burgersHashMap.createBurgers(wdName, value);
					}
                    
                    createBurger.getMap(burgersHashMap.getburgersIngredients());

                    System.out.println("");
                    
                    System.out.println("Los ingredientes de cada hamburguesa son: \n");
                	
                	burgersHashMap.showMap();
                	
                	App.main(args);

            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            	
            } else if(mainOpt == 3) {
            	System.out.println("Saliendo...");
                System.exit(0);
            } else {
            	System.out.println("Ingresa una opción válida\n");
            	App.main(args);
            }
            
       inputScanner.close();
    }
}
