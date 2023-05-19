package Burger;

import java.util.ArrayList;

public class RecommendBurger {

    private String burgerToRecommend;
    
    
    public String CreatedBurger(ArrayList<String> Ingredients) {
        
        if (Ingredients.contains("Brioche")) {
            setBurgerToRecommend("All In Sweet Asian Pineapple del restaurante AppleBee's");
        
        } else if (Ingredients.contains("Sésamo") || Ingredients.contains("Res")) {
            setBurgerToRecommend("Big Tasty del restaurante McDonald's");

        } else if (Ingredients.contains("Sésamo") || Ingredients.contains("Pollo") || Ingredients.contains("Tomate") || Ingredients.contains("Lechuga") || Ingredients.contains("Cebolla")) {
            setBurgerToRecommend("Big Tasty de Pollo del restaurante McDonald's");
        }
        
        return burgerToRecommend;
    }

    public String getBurgerToRecommend() {
        return burgerToRecommend;
    }

    public void setBurgerToRecommend(String burgerToRecommend) {
        this.burgerToRecommend = burgerToRecommend;
    }
}
