package org.example;

import org.example.Ingredientes.*;

public abstract class Pizza {

    protected String nome;
    protected Massa massa;
    protected Molho molho;
    protected Queijo queijo;
    protected Calabresa calabresa;
    protected Frango frango;

    public abstract void preparar();

    public void assar() {
        System.out.println("Assando " + nome);
    }

    public void fatiar() {
        System.out.println("Fatiando " + nome);
    }

    public void embalar() {
        System.out.println("Embalando " + nome);
    }
}