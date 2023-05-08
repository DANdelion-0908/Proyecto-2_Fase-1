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

import Burger.Burger;

public class App {
    public static void main(String[] args) {
        System.out.println("Algoritmo de Recomendación de Hamburguesas \n");

        System.out.println("Responde a las preguntas que te parecerán a continuación para recomendarte una hamburguesa. \n");

        Burger getBread = new Burger();

        getBread.BreadSelection();
    }
}
