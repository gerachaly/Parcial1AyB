/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial1prueba;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Gomez Liliana
 */
public class Parcial1Prueba {

    public static void main(String[] args) {
        int dimension = 0;
        Scanner entrada = new Scanner(System.in);
        int valorPrimerFila;
        int[] valoresCentrales = new int[9];
        int[] matrizOrdenada = new int[9];
        Random random = new Random();
        System.out.println("Bienvenido, ingrese la dimension de la matriz.");
        System.out.println("Tiene que ser impar y el valor tiene que ser entre 3 y 15");
        while (true) {
            System.out.print("Dimension de la matriz: ");
            dimension = entrada.nextInt();
            if (dimension < 3 || dimension > 15) {
                System.out.println("Tiene que ser un valor entre 3 y 15!!!");
            } else {
                if (dimension % 2 == 0) {
                    System.out.println("Tiene que ser impar!!!!");
                } else {
                    break;
                }
            }
        }
        int[][] matriz = new int[dimension][dimension];
        System.out.println("Ahora debera llenar la primer fila de la matriz:");
        System.out.println("Tiene que ser un valor positivo entre 10 y 99");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Matriz [1] [" + (i + 1) + "]: ");
            valorPrimerFila = entrada.nextInt();
            if (valorPrimerFila < 0) {
                System.out.println("El valor tiene que ser positivo!");
                i--;
            } else {
                if (valorPrimerFila < 10 || valorPrimerFila > 99) {
                    System.out.println("Tiene que estar dentro del rango entre 10 y 99!!");
                    i--;
                } else {
                    matriz[0][i] = valorPrimerFila;
                }
            }
        }

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = random.nextInt(89) + 10;
            }
        }
        int valorCentralOriginal = matriz[matriz.length / 2][matriz.length / 2];
        System.out.println("Matriz entera con numeros aleatorios:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        valoresCentrales = obtenerValoresCentrales(matriz);
        System.out.println("Matriz resultante de los valores centrales:");
        for (int i = 0; i < valoresCentrales.length; i++) {
            System.out.print(valoresCentrales[i] + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }
        }
        matrizOrdenada = ordenarMatriz(valoresCentrales);
        System.out.println("Ahora la matriz ordenada de mayor a menor:");
        for (int i = 0; i < matrizOrdenada.length; i++) {
            System.out.print(matrizOrdenada[i] + " ");
        }
        System.out.println("");
        buscarValorCentralEnMatriz(matriz, valorCentralOriginal);
    }

    public static int[] ordenarMatriz(int[] valores) {
        int valor, j;
        for (int i = 1; i < valores.length; i++) {
            valor = valores[i];
            j = i - 1;
            while (j >= 0 && valores[j] < valor) {
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = valor;
        }
        return valores;
    }

    public static int[] obtenerValoresCentrales(int[][] matriz) {
        int medio = matriz.length / 2;
        int[] valoresMedio = new int[9];

        valoresMedio[0] = matriz[medio - 1][medio - 1];
        valoresMedio[1] = matriz[medio - 1][medio];
        valoresMedio[2] = matriz[medio - 1][medio + 1];
        valoresMedio[3] = matriz[medio][medio - 1];
        valoresMedio[4] = matriz[medio][medio];
        valoresMedio[5] = matriz[medio][medio + 1];
        valoresMedio[6] = matriz[medio + 1][medio - 1];
        valoresMedio[7] = matriz[medio + 1][medio];
        valoresMedio[8] = matriz[medio + 1][medio + 1];
        return valoresMedio;
    }

    public static void buscarValorCentralEnMatriz(int[][] matriz, int valorBuscado) {
        System.out.println("Ahora le indicaremos si el valor central de");
        System.out.println("la matriz original se repite en toda la matriz.");
        System.out.println("Valor Buscado: " + valorBuscado);
        int contador = -1;
        for (int[] filas : matriz) {
            for (int columna : filas) {
                System.out.print(columna+ " ");
                if (columna == valorBuscado) {
                    contador++;
                }
            }
            System.out.println("");
        }
        if (contador == 0) {
            System.out.println("No se repite el valor buscado.");
        } else {
            if (contador == 1) {
                System.out.println("El valor se repitio 1 vez");
            }else{
                System.out.println("El valor se repitio "+contador+" veces.");
            }
        }

    }

}
