package org.example.Fabricas;

import org.example.Ingredientes.*;

public class FabricaIngredientesChicago implements FabricaDeIngredientes {

    @Override
    public Queijo criarQueijo() {
        return new QueijoMussarela();
    }

    @Override public Calabresa criarCalabresa() {
        return new CalabresaDefumada(); }

    @Override public Frango criarFrango(){
        return new FrangoEmCubos(); }

    @Override
    public Molho criarMolho() {
        return new MolhoDeTomateAmeixa();
    }

    @Override
    public Massa criarMassa() {
        return new MassaGrossa();
    }
}
