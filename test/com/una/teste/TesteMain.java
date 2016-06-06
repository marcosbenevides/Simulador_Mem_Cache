/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.teste;

/**
 *
 * @author Marcos
 */
public class TesteMain {

    public static void main(String[] args) {

        String os = (String) System.getProperties().get("os.name");
        if (os.contains("Windows")) {
            System.err.println("Windows instalado!");
        } else if (os.contains("Linux")) {
            System.err.println("Linux instalado!");
        }

    }
}
