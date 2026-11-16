package org.example.Sabores;

import org.example.Pizza;
import org.example.Fabricas.FabricaDeIngredientes;

public class PizzaDeFrango extends Pizza {

    private final FabricaDeIngredientes fabrica;

    public PizzaDeFrango(FabricaDeIngredientes fabrica) {
        this.nome = "Pizza de Frango";
        this.fabrica = fabrica;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando " + nome);

        massa = fabrica.criarMassa();
        molho = fabrica.criarMolho();
        queijo = fabrica.criarQueijo();
        frango = fabrica.criarFrango();

        System.out.println("Massa: " + massa.getNome());
        System.out.println("Molho: " + molho.getNome());
        System.out.println("Queijo: " + queijo.getNome());
        System.out.println("Calabresa: " + frango.getNome());
    }
}