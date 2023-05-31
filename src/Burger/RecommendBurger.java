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
    
    public HashMap<String, Integer> getSecond(String maxValueKey){
    	int secValue = Integer.MIN_VALUE; 
        String secValueKey = null;
        HashMap<String, Integer> secSet = new HashMap<>();

        for (Map.Entry<String, Integer> entry : selectBurgers.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > secValue && key.equals(maxValueKey) == false) {
                secValue = value;
                secValueKey = key;
            }
        }
        
        secSet.put(secValueKey, secValue);

        return secSet;
    }
    
    public HashMap<String, Integer> getThird(String maxValueKey, String secValueKey){
    	int thirdValue = Integer.MIN_VALUE; 
        String thirdValueKey = null;
        HashMap<String, Integer> thirdSet = new HashMap<>();

        for (Map.Entry<String, Integer> entry : selectBurgers.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > thirdValue && key.equals(maxValueKey) == false && key.equals(secValueKey) == false) {
                thirdValue = value;
                thirdValueKey = key;
            }
        }
        
        thirdSet.put(thirdValueKey, thirdValue);

        return thirdSet;
    }
    
	public HashMap<String, Integer> getSelectBurgers() {
		return selectBurgers;
	}

	public ArrayList<String> getBurgersToRecommend() {
		return burgersToRecommend;
	}

}