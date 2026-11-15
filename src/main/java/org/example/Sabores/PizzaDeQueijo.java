package org.example.Sabores;

import org.example.Pizza;
import org.example.Fabricas.FabricaDeIngredientes;

public class PizzaDeQueijo extends Pizza {

    private final FabricaDeIngredientes fabrica;

    public PizzaDeQueijo(FabricaDeIngredientes fabrica) {
        this.nome = "Pizza de Queijo";
        this.fabrica = fabrica;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando " + nome);

        massa = fabrica.criarMassa();
        molho = fabrica.criarMolho();
        queijo = fabrica.criarQueijo();

        System.out.println("Massa: " + massa.getNome());
        System.out.println("Molho: " + molho.getNome());
        System.out.println("Queijo: " + queijo.getNome());
    }
}