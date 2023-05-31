package Burger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendBurger {

	private ArrayList<String> burgersToRecommend = new ArrayList<>();
	
	private HashMap<String, Integer> selectBurgers = new HashMap<>();
	
    public ArrayList<String> recommendBurger(ArrayList<String> Ingredients, HashMap<String, ArrayList<String>> BurgersIngredients) {
    	    	
    	for (String userIngredient : Ingredients) {
			for (String burgerName : BurgersIngredients.keySet()) {
				for (String burgerIngredients : BurgersIngredients.get(burgerName)) {
					if(userIngredient.equals(burgerIngredients)) {
						burgersToRecommend.add(burgerName);
					}
				}
			}
		}
    	
    	return burgersToRecommend;
    }

    public HashMap<String, Integer> countBurgers(List<String> list) {
    	for(String element : list) {	
    			selectBurgers.put(element, selectBurgers.getOrDefault(element, 0) + 1);
    	}
    	return selectBurgers;
    }
    
    public HashMap<String, Integer> getMax() {
        int maxValue = Integer.MIN_VALUE; 
        String maxValueKey = null;
        HashMap<String, Integer> maxSet = new HashMap<>();

        for (Map.Entry<String, Integer> entry : selectBurgers.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxValueKey = key;
            }
        }
        
        maxSet.put(maxValueKey, maxValue);

        return maxSet;
    }
    
    
    
	public HashMap<String, Integer> getSelectBurgers() {
		return selectBurgers;
	}

	public ArrayList<String> getBurgersToRecommend() {
		return burgersToRecommend;
	}

}