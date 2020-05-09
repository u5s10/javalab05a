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

    public void run(){
        Scanner scanner = new Scanner(System.in);
        String inputString;
        int columns;
        int rows;
        this.promptMenu();
        while (scanner.hasNextLine()) {
            this.promptMenu();
            inputString = scanner.nextLine();
            if (inputString.equals("1")) {
                System.out.println("Podaj liczbe wierszy");
                rows = scanner.nextInt();
                System.out.println("Podaj liczbe kolumn");
                columns = scanner.nextInt();
                controller.createMatrices(rows, columns);
                System.out.println("Wprowadz wartosci do macierzy A.");
                int temp = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        temp = scanner.nextInt();
                        controller.populateMatrixA(i, j, temp);
                    }
                }
                System.out.println("Wprowadz wartosci do macierzy B.");
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        temp = scanner.nextInt();
                        controller.populateMatrixB(i, j, temp);
                    }
                }

            } else if (inputString.equals("2")) {
                this.promtpOperations();
                while(scanner.hasNextLine()){
                    this.promtpOperations();
                    inputString = scanner.nextLine();
                    if(inputString.equals("1")){
                        controller.transponeInputMatrices();
                    }else if(inputString.equals("2")){
                        // multiplication
                    }else if(inputString.equals("3")){
                        controller.transponeOutputMatix();
                    }else
                        break;
                }


            } else if (inputString.equals("3")) {
                this.promtpResults();
                while(scanner.hasNextLine()) {
                    this.promtpResults();
                    inputString = scanner.nextLine();
                    if (inputString.equals("1")) {
                        this.showMatricesAB();
                    } else if (inputString.equals("2")) {
                        controller.calculateMatrixC();
                        this.showMatrixC();
                    } else {
                        break;
                    }
                }

            } else if (inputString.equals("q")) {
                break;
            }
        }
        scanner.close();

    }

    public void promptMenu() {

        System.out.println(
                "1.Wprowadz macierze wejsciowe\n2.Operacje arytmetyczne\n3.Wyswietl macierze");
    }

    public void promtpOperations() {

        System.out.println(
                "1.Transponuj macierze\n2.Pomnoz macierze wejsciowe\n3.Transponuj macierz wynikowa");
    }

    public void promtpResults() {

        System.out.println(
                "1.Wyswietl macierze wejsciowe\n2.Wyswielt macierz wynikowa");
    }

    public void showMatricesAB() {

        int[][] matrixA = this.controller.getModel().getMatrixA();
        int[][] matrixB = this.controller.getModel().getMatrixB();
        int rows = this.controller.getModel().getMatrixA().length;
        int columns = this.controller.getModel().matrixA[0].length;

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
    }

    public void showMatrixC(){
        int[][] matrixC = this.controller.getModel().getMatrixC();
        int rows = this.controller.getModel().getMatrixC().length;
        int columns = this.controller.getModel().matrixC[0].length;

        System.out.println("Macierz C:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }
    }

}
