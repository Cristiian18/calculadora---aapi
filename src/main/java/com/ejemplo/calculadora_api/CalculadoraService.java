package com.ejemplo.calculadora_api;
import org.springframework.stereotype.Service;

@Service

public class CalculadoraService {
    
    public Integer sumar(int a, int b) {
        return a + b;
    }
    
    public Integer restar(int a, int b) {
        return a - b;
    }
    
    public Integer multiplicar(int a, int b) {
        return a * b;
    }
    
    public Double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return (double) a / b;
    }
}
