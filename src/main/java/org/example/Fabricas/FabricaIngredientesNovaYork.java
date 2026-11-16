package org.example.Fabricas;

import org.example.Ingredientes.*;

public class FabricaIngredientesNovaYork implements FabricaDeIngredientes {

    @Override
    public Molho criarMolho() {
        return new MolhoMarinara();
    }

    @Override
    public Queijo criarQueijo() {
        return new QueijoReggiano();
    }

    @Override
    public Massa criarMassa() {
        return new MassaFina();
    }

    @Override public Calabresa criarCalabresa() {
        return new CalabresaFatiada(); }

    @Override public Frango criarFrango()       {
        return new FrangoDesfiado(); }


}
