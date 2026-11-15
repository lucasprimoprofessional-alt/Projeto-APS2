package org.example.Lojas;

import org.example.Pizza;
import org.example.LojaDePizza;

import org.example.Fabricas.FabricaDeIngredientes;
import org.example.Fabricas.FabricaIngredientesNovaYork;

import org.example.Sabores.PizzaDeCalabresa;
import org.example.Sabores.PizzaDeFrango;
import org.example.Sabores.PizzaDeQueijo;

public class LojaDePizzaNovaYork extends LojaDePizza {

    private final FabricaDeIngredientes fabrica =
            new FabricaIngredientesNovaYork();

    @Override
    protected Pizza criarPizza(String tipo) {

        if (tipo.equalsIgnoreCase("calabresa")) {
            return new PizzaDeCalabresa(fabrica);
        }

        if (tipo.equalsIgnoreCase("frango")) {
            return new PizzaDeFrango(fabrica);
        }

        if (tipo.equalsIgnoreCase("queijo")) {
            return new PizzaDeQueijo(fabrica);
        }

        return null;
    }
}