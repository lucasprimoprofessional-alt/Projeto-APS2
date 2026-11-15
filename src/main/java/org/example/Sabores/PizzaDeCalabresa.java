package org.example.Sabores;

import org.example.Pizza;
import org.example.Fabricas.FabricaDeIngredientes;

public class PizzaDeCalabresa extends Pizza {

    private final FabricaDeIngredientes fabrica;

    public PizzaDeCalabresa(FabricaDeIngredientes fabrica) {
        this.nome = "Pizza de Calabresa";
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