/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.company.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.never;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private Service service;

    @Test
    public void testCalculate_AddOperation_CallsCalculatorAdd() {
        int a = 2;
        int b = 3;
        String operation = "add";

        // Définir le comportement du mock Calculator
        when(calculator.add(a, b)).thenReturn(5);

        // Appeler la méthode calculate de la classe Service
        int result = service.calculate(operation, a, b);
        assertEquals(5, result);
        // Vérifier que la méthode add de Calculator a été appelée avec les bons arguments
        verify(calculator).add(a, b);

    }

    @Test
    public void testCalculate_SubtractOperation_CallsCalculatorSubtract() {
        int a = 5;
        int b = 2;
        String operation = "subtract";

        // Définir le comportement du mock Calculator
        when(calculator.subtract(a, b)).thenReturn(3);

        // Appeler la méthode calculate de la classe Service
        int result = service.calculate(operation, a, b);

        // Vérifier que la méthode subtract de Calculator a été appelée avec les bons arguments
        verify(calculator).subtract(a, b);

        // Vérifier le résultat
        assertEquals(3, result);
    }

   @Test
public void testCalculate_UnknownOperation_ReturnsZero() {
    int a = 2;
    int b = 3;
    String operation = "multiply"; // Opération inconnue

    // Appeler la méthode calculate de la classe Service
    int result = service.calculate(operation, a, b);

    // Vérifier que les méthodes de Calculator ne sont pas appelées
    verify(calculator, never()).add(anyInt(), anyInt());
    verify(calculator, never()).subtract(anyInt(), anyInt());

    // Vérifier le résultat
    assertEquals(0, result);
}

}
