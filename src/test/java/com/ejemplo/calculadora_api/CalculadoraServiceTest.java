package com.ejemplo.calculadora_api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraServiceTest {
    private CalculadoraService calculadora = new CalculadoraService();
    
    @Test
    void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
        assertEquals(0, calculadora.sumar(-2, 2));
        assertEquals(-5, calculadora.sumar(-2, -3));
    }

    @Test
    void testRestar() {
        assertEquals(-1, calculadora.restar(2, 3));
        assertEquals(1, calculadora.restar(3, 2));
        assertEquals(0, calculadora.restar(2, 2));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
        assertEquals(-6, calculadora.multiplicar(2, -3));
        assertEquals(0, calculadora.multiplicar(0, 5));
    }

    @Test
    void testDividir() {
        assertEquals(2.0, calculadora.dividir(6, 3));
        assertEquals(0.5, calculadora.dividir(1, 2));
    }

    @Test
    void testDividirPorCero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(5, 0);
        });
    }
}