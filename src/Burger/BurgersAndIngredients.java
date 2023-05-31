/**
 * 
 */
package Burger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * @author Dan
 *
 */
public class BurgersAndIngredients {

	HashMap<String, ArrayList<String>> burgersIngredients = new HashMap<>();
	
	public void createBurgers(String key, ArrayList<String> value) {
		burgersIngredients.put(key, value);
	}
	
	public void showMap(LinkedList<String> MC, LinkedList<String> DP, LinkedList<String> WD) {
		String MCham = "Las Hamburguesas ofrecidas por McDonald's son: \n";
		String DPham = "Las Hamburguesas ofrecidas por DelPuente son: \n";
		String WDham = "Las Hamburguesas ofrecidas por Wendy's son: \n";
		
		for(String key : burgersIngredients.keySet()) {
			
			ArrayList<String> ingredients = burgersIngredients.get(key);
			if(MC.contains(key) == true) {
				MCham = MCham + key + ": " + ingredients + "\n";
			}
			else if(DP.contains(key) == true) {
				DPham = DPham + key + ": " + ingredients + "\n";
			}
			else if(WD.contains(key) == true) {
				WDham = WDham + key + ": " + ingredients + "\n";
			}
		}
		System.out.println(MCham + "\n" + DPham + "\n" + WDham);
	}
	
	public HashMap<String, ArrayList<String>> getburgersIngredients() {
		return burgersIngredients;
	}
}
