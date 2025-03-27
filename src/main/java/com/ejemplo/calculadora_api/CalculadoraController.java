package com.ejemplo.calculadora_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    @Autowired
    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return calculadoraService.sumar(a, b);
    }

    @GetMapping("/restar")
    public int restar(@RequestParam int a, @RequestParam int b) {
        return calculadoraService.restar(a, b);
    }

    @GetMapping("/multiplicar")
    public int multiplicar(@RequestParam int a, @RequestParam int b) {
        return calculadoraService.multiplicar(a, b);
    }

    @GetMapping("/dividir")
    public ResponseEntity<?> dividir(@RequestParam("a") double a, @RequestParam("b") double b) {
        try {
            if (b == 0) {
                return ResponseEntity.badRequest().body("No se puede dividir por cero");
            }
            double resultado = calculadoraService.dividir(a, b);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}