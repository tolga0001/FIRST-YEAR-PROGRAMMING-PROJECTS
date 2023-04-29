#include <stdio.h>
/** Tolga Fehmioğlu
 * ID:150120022
  The purpose of this program to create 3 identical triangles for each triangle  using recursive functions.
  */

const int ROW = 32;
const int COL = 63;

void initializeMatrix(char matrix[ROW][COL]);

void printTriangles(char matrix[ROW][COL]);

void createTriangle(char matrix[ROW][COL], int start_row, int start_col, int length);

// base case is iteration 0 and at each iteration length divides.This function creates three triangle for each triangle using the length at that time(original left and right triangles)
// Recursive


void makeOnes(char matrix[ROW][COL], int startRow, int startCol, int length, int iteration) {
    if (iteration == 0) {
        createTriangle(matrix, startRow, startCol, length);

    } else {
        makeOnes(matrix, startRow, startCol, length / 2, iteration - 1);
        makeOnes(matrix, startRow + length / 2, startCol - length / 2, length / 2, iteration - 1);
        makeOnes(matrix, startRow + length / 2, startCol + length / 2, length / 2, iteration - 1);
    }
}

// this function arrange the matrix  according to row col and length of each triangle one by one.
void createTriangle(char matrix[ROW][COL], int start_row, int start_col, int length) {
    int i, j;
    for (i = 0; i < length; i++) {
        for (j = start_col - i; j <= start_col + i; j++) {
            matrix[start_row + i][j] = '1';
        }
    }
}


int main(void) {
// taking input from user
    int n;
    printf("Enter number of iteration:");
    scanf("%d", &n);

    char matrix[ROW][COL];
    // initializing matrix with full of '_'.
    initializeMatrix(matrix);

    // the function that will create ones as triangle
    makeOnes(matrix, 0, COL / 2, ROW, n);

    // printing triangle matrix
    printTriangles(matrix);
    return 0;
}

void printTriangles(char matrix[ROW][COL]) {
    for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
            printf("%c", matrix[i][j]);
        }
        printf("\n");
    }
}

// initializing our matriz with full underscore.
void initializeMatrix(char matrix[ROW][COL]) {
    int i, j;
    for (i = 0; i < ROW; i++) {
        for (j = 0; j < COL; j++) {
            matrix[i][j] = '_';
        }
    }
}
