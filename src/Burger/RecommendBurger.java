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
    
    public int getMaxValue() {
        int maxValue = Integer.MIN_VALUE; 

        for (int value : selectBurgers.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }
    
    public  String getMaxValueKey() {
        int maxValue = Integer.MIN_VALUE; 
        String maxValueKey = null; 

        for (Map.Entry<String, Integer> entry : selectBurgers.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxValueKey = key;
            }
        }

        return maxValueKey;
    }
    
	public HashMap<String, Integer> getSelectBurgers() {
		return selectBurgers;
	}

	public void setSelectBurgers(HashMap<String, Integer> selectBurgers) {
		this.selectBurgers = selectBurgers;
	}

	public ArrayList<String> getBurgersToRecommend() {
		return burgersToRecommend;
	}

	public void setBurgersToRecommend(ArrayList<String> burgersToReommend) {
		this.burgersToRecommend = burgersToReommend;
	}
}