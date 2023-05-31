package Burger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Burger {
    Scanner inputScanner = new Scanner(System.in);
 
    private String bread;
    private String meat;
    private String tomato;
    private String lettuce;
    private String onion;
    private String cheese;
    private String pickle;
    private String bacon;

    private ArrayList<String> burgerUnit = new ArrayList<>();
    
    private HashMap<String, ArrayList<String>> burgersIngredients = new HashMap<>();

/**
 * This function prompts the user to select a type of bread for a burger and adds it to the burger
 * object.
 */
    public void BreadSelection() {
    	
    	int i = 0;
    	while(i == 0) {
    		try {
    			System.out.println("¿Qué clase de pan prefieres?");
    	        System.out.println("1. Pan blanco o tradicional.");
    	        System.out.println("2. Pan con semillas de sésamo.");
    	        System.out.println("3. Pan artesanal");
    	    
    	        System.out.print("Tu opción:");
    	        int breadOption = inputScanner.nextInt();
    	        inputScanner.nextLine();
    	        System.out.println("");
    	    
    	        switch (breadOption) {
    	            case 1:
    	            	i = 1;
    	                setBread("Pan Blanco");
    	            
    	            break;

    	            case 2:
    	            	i = 1;
    	                setBread("Pan con Semillas de Sésamo");

    	            break;

    	            case 3:
    	            	i = 1;
    	                setBread("Pan Artesanal");

    	            break;    
    	            
    	            default:
    	            	System.out.println("Ingresa una opción válida\n");
    	        }
    		} catch (Exception e) {
    			System.out.println("Ingresa caracteres válidos\n");
    			inputScanner.nextLine();
    		}
    	}
        
        System.out.println("Haz seleccionado " + getBread() + " como tu preferido. \n");
        burgerUnit.add(bread);
    }

/**
 * This function prompts the user to select the type of meat for a burguer and adds it to the burger
 * object.
 */
public void MeatSelection() {

    int i = 0;
    while(i == 0) {
    	try {
    		System.out.println("¿Qué tipo de carne prefieres?");
            System.out.println("1. Carne de res.");
            System.out.println("2. Carne Angus.");
            System.out.println("3. Carne de Pollo.");
        	System.out.print("Tu opción:");
            
        	int meatOption = inputScanner.nextInt();
        	inputScanner.nextLine();
            System.out.println("");
        	switch (meatOption) {
            case 1:
            	i = 1;
                setMeat("Carne de Res");
            
            break;

            case 2:
            	i = 1;
                setMeat("Carne Angus");

            break;

            case 3:
            	i = 1;
                setMeat("Carne de Pollo");

            break; 
            
            default:
            	System.out.println("Ingresa una opción válida\n");
        	}
    	} catch (Exception e) {
    		System.out.println("Ingresa caracteres válidos\n");
			inputScanner.nextLine();
    	}
    }
    
    System.out.println("Haz seleccionado " + getMeat() + " como tu preferida. \n");
    burgerUnit.add(meat);
}

public void CheeseSelection() {
	
	int i = 0;
	while(i == 0) {
		try {
			System.out.println("¿Qué tipo de queso prefieres?");
		    System.out.println("1. Queso Cheddar.");
		    System.out.println("2. Queso Emmental.");
		    System.out.println("3. Queso Americano.");
		    System.out.println("4. Queso Blanco.");

		    System.out.print("Tu opción:");
		    int cheeseOption = inputScanner.nextInt();
		    inputScanner.nextLine();
		    System.out.println("");

		    switch (cheeseOption) {
		        case 1:
		        	i = 1;
		            setCheese("Queso Cheddar");
		        
		        break;

		        case 2:
		        	i = 1;
		            setCheese("Queso Emmental");

		        break;

		        case 3:
		        	i = 1;
		            setCheese("Queso Americano");

		        break; 
		        
		        case 4:
		        	i = 1;
		        	setCheese("Queso Blanco");
		        	
		        default:
		        	System.out.println("Ingresa una opción válida\n");
		    }
		} catch (Exception e) {
			System.out.println("Ingresa caracteres válidos\n");
			inputScanner.nextLine();
		}
	}
    
    System.out.println("Haz seleccionado " + getCheese() + " como tu preferida. \n");
    burgerUnit.add(cheese);
}

public void ExtraSelection() {
	
	int i = 0;
	while(i == 0) {
		try {
			System.out.println("¿Deseas agregar extras?");
            System.out.println("1. Sí.");
            System.out.println("2. No");

            System.out.print("Tu opción: ");
            int extrasOption = inputScanner.nextInt();
            inputScanner.nextLine();
            System.out.println("");
            
            switch(extrasOption) {
            	case 1:
            		i = 1;
            		int j = 0;
                	while(j==0) {
                		try {
                        	System.out.println("¿Deseas agregar tocino?");
                        	System.out.println("1. Si.");
                        	System.out.println("2. No.");
                        	
                        	System.out.print("Tu opción: ");
                        	int baconOptions = inputScanner.nextInt();
                        	inputScanner.nextLine();
                        	System.out.println();
                        	
                        	switch (baconOptions) {
                        		case 1:
                        			j = 1;
                        			setBacon("Tocino");
                        			burgerUnit.add(bacon);
                        		
                        			break;
                        	
                        		case 2:
                        			j = 1;
                        			System.out.println("No agregaste tocino");
                        			break;
                        	
                        		default:
                        			System.out.println("Ingresa una opción válida\n");
                    		}
                		} catch (Exception e) {
                			System.out.println("Ingresa caracteres válidos\n");
                			inputScanner.nextLine();
                		}
                	}
                	int k = 0;
                	while(k==0) {
                		try {
                        	System.out.println("¿Deseas agregar pepinillos?");
                        	System.out.println("1. Si.");
                        	System.out.println("2. No.");
                        	
                        	System.out.print("Tu opción: ");
                        	int pickleOptions = inputScanner.nextInt();
                        	inputScanner.nextLine();
                        	System.out.println();
                        	
                        	switch (pickleOptions) {
                        		case 1:
                        			k = 1;
                        			setPickle("Pepinillos");
                        			burgerUnit.add(pickle);
                        		
                        			break;
                        	
                        		case 2:
                        			k = 1;
                        			System.out.println("No agregaste pepinillos");
                        			break;
                        	
                        		default:
                        			System.out.println("Ingresa una opción válida\n");
                    		}
                		} catch (Exception e) {
                			System.out.println("Ingresa caracteres válidos\n");
                			inputScanner.nextLine();
                		}
                	}
                	
                break;
                	
            	case 2:
            		i = 1;
                    System.out.println("Has elegido sin extras. \n");
                break;
                
                default:
                	System.out.println("Ingresa una opción válida\n");
            }
		} catch (Exception e) {
			System.out.println("Ingresa caracteres válidos\n");
			inputScanner.nextLine();
		}
	}
}

public void VegetablesSelection() {
    
	int i = 0;
    while(i == 0) {
    	try {
    		System.out.println("¿Deseas agregar vegetales?");
            System.out.println("1. Sí.");
            System.out.println("2. No");

            System.out.print("Tu opción: ");
            int vegetablesOption = inputScanner.nextInt();
            inputScanner.nextLine();
            System.out.println("");

            switch (vegetablesOption) {
                case 1:
                	i = 1;
                	int j = 0;
                	while(j==0) {
                		try {
                        	System.out.println("¿Deseas agregar tomate?");
                        	System.out.println("1. Si.");
                        	System.out.println("2. No.");
                        	
                        	System.out.print("Tu opción: ");
                        	int tomatoOptions = inputScanner.nextInt();
                        	inputScanner.nextLine();
                        	System.out.println();
                        	
                        	switch (tomatoOptions) {
                        		case 1:
                        			j = 1;
                        			setTomato("Tomate");
                        			burgerUnit.add(tomato);
                        		
                        			break;
                        	
                        		case 2:
                        			j = 1;
                        			System.out.println("No agregaste tomate");
                        			break;
                        	
                        		default:
                        			System.out.println("Ingresa una opción válida\n");
                    		}
                		} catch (Exception e) {
                			System.out.println("Ingresa caracteres válidos\n");
                			inputScanner.nextLine();
                		}
                	}
                	int k = 0;
                	while(k==0) {
                		try {
                			System.out.println("¿Deseas agregar lechuga?");
                        	System.out.println("1. Si.");
                        	System.out.println("2. No.");
                        	
                        	System.out.print("Tu opción: ");
                        	int lettuceOptions = inputScanner.nextInt();
                        	inputScanner.nextLine();
                        	System.out.println();
                        	
                        	switch (lettuceOptions) {
                        		case 1:
                        			k = 1;
                        			setLettuce("Lechuga");
                        			burgerUnit.add(lettuce);
                        		
                        			break;
                        	
                        		case 2:
                        			k = 1;
                        			System.out.println("No agregaste lechuga");
                        		
                        			break;
                        			
                        		default:
                        			System.out.println("Ingresa una opción válida\n");
                        	}
                		} catch (Exception e) {
                			System.out.println("Ingresa caracteres válidos\n");
                			inputScanner.nextLine();
                		}
                	}
                	
                	int l = 0;
                	while(l == 0) {
                		try {
                			System.out.println("¿Deseas agregar cebolla?");
                        	System.out.println("1. Si.");
                        	System.out.println("2. No.");
                        	
                        	System.out.print("Tu opción: ");
                        	int onionOptions = inputScanner.nextInt();
                        	inputScanner.nextLine();
                        	System.out.println();
                        	
                        	switch (onionOptions) {
                        		case 1:
                        			l = 1;
                        			setOnion("Cebolla");
                        			burgerUnit.add(onion);
                        		
                        			break;
                        	
                        		case 2:
                        			l = 1;
                        			System.out.println("No agregaste cebolla");
                        		
                        			break;
                        			
                        		default:
                        			System.out.println("Ingresa una opción válida\n");
                        	}
                		} catch (Exception e) {
                			System.out.println("Ingresa caracteres válidos\n");
                			inputScanner.nextLine();
                		}
                	}              
                	
                break;
            
                case 2:
                	i = 1;
                    System.out.println("Has elegido sin vegetales. \n");
                break;
                
                default:
                	System.out.println("Ingresa una opción válida\n");
            }
    	} catch (Exception e) {
    		i = 0;
    		System.out.println("Ingresa caracteres válidos\n");
			inputScanner.nextLine();
    	}
    }
}

public void showMenu() {
    new ShowBurger(burgerUnit);

}

public void getMap(HashMap<String, ArrayList<String>> burgers) {
	
	burgersIngredients = burgers;
}

public ArrayList<String> showRecommendation() {
    RecommendBurger makeRecommendation = new RecommendBurger();
    
    return makeRecommendation.recommendBurger(burgerUnit, burgersIngredients);
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getBread() {
        return bread;
    }
    public void setBread(String bread) {
        this.bread = bread;
    }
    public String getMeat() {
        return meat;
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }
    public String getTomato() {
        return tomato;
    }
    public void setTomato(String tomato) {
        this.tomato = tomato;
    }
    public String getLettuce() {
        return lettuce;
    }
    public void setLettuce(String lettuce) {
        this.lettuce = lettuce;
    }
    public String getOnion() {
        return onion;
    }
    public void setOnion(String onion) {
        this.onion = onion;
    }
    public void setCheese(String cheese) {
    	this.cheese = cheese;
    }
    public String getCheese() {
    	return cheese;
    }
    public void setPickle(String pickle) {
    	this.pickle = pickle;
    }
    public String getPickle() {
    	return pickle;
    }
    public void setBacon(String bacon) {
    	this.bacon = bacon;
    }
    public String getBacon() {
    	return bacon;
    }
}
