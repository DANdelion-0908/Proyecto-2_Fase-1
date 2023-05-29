package Burger;
import java.util.ArrayList;

public class ShowBurger {
    
    public ShowBurger(ArrayList<String> Ingredients) {
        int i = 1;

        System.out.println("Estos son los ingredientes que has seleccionado: \n");

        for (String string : Ingredients) {
            System.out.println(i + ". " + string);
            i++;
        }
        
        System.out.println("");
    }
}
