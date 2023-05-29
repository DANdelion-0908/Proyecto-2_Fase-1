/**
 * 
 */
package Burger;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Dan
 *
 */
public class BurgersAndIngredients {

	HashMap<String, ArrayList<String>> burgersIngredients = new HashMap<>();
	
	public void createBurgers(String key, ArrayList<String> value) {
		burgersIngredients.put(key, value);
	}
	
	public void showMap() {
		for(String key : burgersIngredients.keySet()) {
			ArrayList<String> ingredients = burgersIngredients.get(key);
			
			System.out.println(key + ":" + ingredients + "\n");
		}
	}
	
	public HashMap<String, ArrayList<String>> getburgersIngredients() {
		return burgersIngredients;
	}
}
