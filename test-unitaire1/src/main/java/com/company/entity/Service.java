/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

/**
 *
 * @author justi
 */
public class Service {
      private Calculator calculator;

    public Service(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(String operation, int a, int b) {
        if (operation.equals("add")) {
            return calculator.add(a, b);
        } else if (operation.equals("subtract")) {
            return calculator.subtract(a, b);
        } else {
            return 0;
        }
    }
    
}
