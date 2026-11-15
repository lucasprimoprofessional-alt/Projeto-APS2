package org.example.Lojas;

import org.example.Pizza;
import org.example.LojaDePizza;

import org.example.Fabricas.FabricaDeIngredientes;
import org.example.Fabricas.FabricaIngredientesChicago;

import org.example.Sabores.PizzaDeCalabresa;
import org.example.Sabores.PizzaDeFrango;

public class LojaDePizzaChicago extends LojaDePizza {

    private final FabricaDeIngredientes fabrica =
            new FabricaIngredientesChicago();

    @Override
    protected Pizza criarPizza(String tipo) {

        if (tipo.equalsIgnoreCase("calabresa")) {
            return new PizzaDeCalabresa(fabrica);
        }

        if (tipo.equalsIgnoreCase("frango")) {
            return new PizzaDeFrango(fabrica);
        }

        return null;
    }
}