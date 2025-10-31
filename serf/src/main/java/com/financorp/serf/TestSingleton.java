package com.financorp.serf;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

public class TestSingleton {
    public static void main(String[] args) {
        ConfiguracionGlobal c1 = ConfiguracionGlobal.getInstancia();
        ConfiguracionGlobal c2 = ConfiguracionGlobal.getInstancia();

        System.out.println(c1);
        System.out.println(c2);

        // Debería mostrar el mismo objeto en memoria
        System.out.println("¿Es la misma instancia? " + (c1 == c2));
    }
}
