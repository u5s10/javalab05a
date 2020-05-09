package com.grajeta.piotr;

import java.util.Scanner;

public class View {
    Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String inputString = "0";
        int columns;
        int rows;
        this.promptMenu();
        label:
        while (true) {
            inputString = scanner.nextLine();
            switch (inputString) {
                case "1":
                    System.out.println("Podaj liczbe wierszy");
                    check(scanner);
                    rows = scanner.nextInt();
                    System.out.println("Podaj liczbe kolumn");
                    check(scanner);
                    columns = scanner.nextInt();
                    controller.createMatrices(rows, columns);
                    System.out.println("Wprowadz wartosci do macierzy A.");
                    int temp;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            check(scanner);
                            temp = scanner.nextInt();
                            controller.populateMatrixA(i, j, temp);
                        }
                    }
                    System.out.println("Wprowadz wartosci do macierzy B.");
                    for (int i = 0; i < columns; i++) {
                        for (int j = 0; j < rows; j++) {
                            check(scanner);
                            temp = scanner.nextInt();
                            controller.populateMatrixB(i, j, temp);
                        }
                    }

                    break;
                case "2":
                    this.promtpOperations();
                    inputString = scanner.nextLine();
                    if (inputString.equals("1")) {
                        if (controller.getModel().getMatrixA() == null) {
                            System.err.println("Brak macierzy A i B");
                            continue;
                        } else
                            controller.transponeInputMatrices();
                    } else if (inputString.equals("2")) {
                        if (controller.getModel().getMatrixA() == null) {
                            System.err.println("Brak macierzy A i B");
                            continue;
                        } else
                            controller.calculateMatrixC();
                    } else if (inputString.equals("3")) {
                        if (controller.getModel().getMatrixC() == null) {
                            System.err.println("Brak macierzy C");
                            continue;
                        } else
                            controller.transponeOutputMatix();
                    }
                    this.promptMenu();

                    break;
                case "3":
                    this.promtpResults();
                    inputString = scanner.nextLine();
                    if (inputString.equals("1")) {
                        this.showMatricesAB();
                    } else if (inputString.equals("2")) {
                        if (controller.getModel().getMatrixC() == null) {
                            System.err.println("Brak macierzy C");
                        } else
                            this.showMatrixC();
                    }
                    this.promptMenu();

                    break;
                case "q":
                    break label;
                default:
                    this.promptMenu();
                    break;
            }
        }
        scanner.close();
    }

    private static void check(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" nie jest liczba calkowita.\n", input);
        }
    }

    public void promptMenu() {

        System.out.println(
                "1.Wprowadz macierze wejsciowe\n2.Operacje arytmetyczne\n3.Wyswietl macierze\n");
    }

    public void promtpOperations() {

        System.out.println(
                "1.Transponuj macierze\n2.Pomnoz macierze wejsciowe\n3.Transponuj macierz wynikowa\n");
    }

    public void promtpResults() {

        System.out.println(
                "1.Wyswietl macierze wejsciowe\n2.Wyswielt macierz wynikowa\n");
    }

    public void showMatricesAB() {

        int[][] matrixA = this.controller.getModel().getMatrixA();
        int[][] matrixB = this.controller.getModel().getMatrixB();
        int rows = this.controller.getModel().getMatrixA().length;
        int columns = this.controller.getModel().getMatrixA()[0].length;

        System.out.println("Macierz A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Macierz B:");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showMatrixC() {
        int[][] matrixC = this.controller.getModel().getMatrixC();
        int rows = this.controller.getModel().getMatrixC().length;
        int columns = this.controller.getModel().getMatrixC()[0].length;

        System.out.println("Macierz C:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
