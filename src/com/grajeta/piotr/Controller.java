package com.grajeta.piotr;

public class Controller {
    private Model model;
    private View view;
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void createMatrices(int rows, int colums){
        this.model.matrixA = new int[rows][colums];
        this.model.matrixB = new int[colums][rows];
    }

    public void populateMatrixA(int row, int column, int number){
        int[][] matrix = this.model.getMatrixA();
        matrix[row][column] = number;

    }

    public void populateMatrixB(int row, int column, int number){
        int[][] matrix = this.model.getMatrixB();
        matrix[row][column] = number;
    }

    public void calculateMatrixC(){
        this.model.matrixC = multiplyAandB(this.model.matrixA, this.model.matrixB);
    }
    public static int[][] multiplyAandB(int[][] A, int[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public void transponeInputMatrices(){
        this.model.matrixA = transposeMatrix(this.model.matrixA);
        this.model.matrixB = transposeMatrix(this.model.matrixB);
    }

    public void transponeOutputMatix(){
        this.model.matrixC = transposeMatrix(this.model.matrixC);
    }

    public static int[][] transposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
