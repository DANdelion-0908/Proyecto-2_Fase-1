package Burger;

import java.util.ArrayList;
import java.util.Scanner;

public class Burger {
    Scanner inputScanner = new Scanner(System.in);
 
    private String bread;
    private String  meat; 
    private String tomato;
    private String lettuce;
    private String onion;

    private boolean sauce;
    private String ketchup;
    private String mayonnaise;
    private String mustard;
    private String spicy;
    private String bbq;

    private boolean extras;
    private String egg;
    private String beacon;

    private ArrayList<String> burgerUnit = new ArrayList<>();
    
    private boolean breadKey;

    public void BreadSelection() {

        while(breadKey){

            System.out.println("¿Qué clase de pan prefieres?");
            System.out.println("1. Pan blanco o tradicional.");
            System.out.println("2. Pan con semillas de sésamo.");
            System.out.println("3. Pan chapata.");
            System.out.println("4. Pan brioche.");
            System.out.println("5. Pan pretzel. \n");
    
            int breadOption = inputScanner.nextInt();
            System.out.print("Tu opción:");
    
            switch (breadOption) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }































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
    public boolean isSauce() {
        return sauce;
    }
    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }
    public String getKetchup() {
        return ketchup;
    }
    public void setKetchup(String ketchup) {
        this.ketchup = ketchup;
    }
    public String getMayonnaise() {
        return mayonnaise;
    }
    public void setMayonnaise(String mayonnaise) {
        this.mayonnaise = mayonnaise;
    }
    public String getMustard() {
        return mustard;
    }
    public void setMustard(String mustard) {
        this.mustard = mustard;
    }
    public String getSpicy() {
        return spicy;
    }
    public void setSpicy(String spicy) {
        this.spicy = spicy;
    }
    public String getBbq() {
        return bbq;
    }
    public void setBbq(String bbq) {
        this.bbq = bbq;
    }
    public boolean isExtras() {
        return extras;
    }
    public void setExtras(boolean extras) {
        this.extras = extras;
    }
    public String getEgg() {
        return egg;
    }
    public void setEgg(String egg) {
        this.egg = egg;
    }
    public String getBeacon() {
        return beacon;
    }
    public void setBeacon(String beacon) {
        this.beacon = beacon;
    }
}
