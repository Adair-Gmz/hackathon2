package com.generations.agenda;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
    protected Map<String, Contacto> contactos;
    protected int LIMITE_CONTACTOS;

    public Agenda() {
        this.LIMITE_CONTACTOS = 10; // Valor por defecto
        contactos = new HashMap<>();
    }

}
