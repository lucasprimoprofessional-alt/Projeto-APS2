package org.example;

import org.example.Lojas.LojaDePizzaNovaYork;
import org.example.Lojas.LojaDePizzaChicago;

public class Main {

    public static void main(String[] args) {

        LojaDePizza lojaNovaYork =
                new LojaDePizzaNovaYork();

        LojaDePizza lojaChicago =
                new LojaDePizzaChicago();

        System.out.println("=== LOJA DE NOVA YORK ===");

        lojaNovaYork.pedirPizza("queijo");
        lojaNovaYork.pedirPizza("calabresa");
        lojaNovaYork.pedirPizza("frango");

        System.out.println();

        System.out.println("=== LOJA DE CHICAGO ===");

        lojaChicago.pedirPizza("calabresa");
        lojaChicago.pedirPizza("frango");
    }
}