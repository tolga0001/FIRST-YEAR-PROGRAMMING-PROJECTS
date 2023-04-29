#include <stdio.h>
#include <math.h>

/** Tolga Fehmioğlu
 * ID:150120022
  The purpose of this program to find the super digit of a number using recursive functions.
  */


int getLength(int number);

void printConcenatedNumber(int n, int k);

int superDigit(int number);

int sum(unsigned int number);


void printResult(int number, int k, int superNumber);


int getSum(unsigned int number, unsigned int k);

int main() {
    unsigned __int64 n, k;
    // taking input from user
    printf("Please enter a number (n=) :");
    scanf("%u", &n);
    printf("Please enter repetition factor (k=) :");
    scanf("%u", &k);


    // the operations in main
    int concatenatedSum = getSum(n, k);
    int superNumber = superDigit(concatenatedSum);
    printResult(n, k, superNumber);

    return 0;
}
// 41563456465
// 15

// this part will print the number and super digit recursively
void printResult(int n, int k, int superNumber) {
    printf("Super digit of number ");

    printConcenatedNumber(n, k);
    printf(" is %d", superNumber);


}

// printing number recursively
void printConcenatedNumber(int n, int k) {

    if (k < 1) {
        return;
    }
    printf("%lld", n);
    printConcenatedNumber(n, k - 1);

}

// calculating super digit of number using recursive
int superDigit(int number) {
    if (getLength(number) == 1)
        return number;

    return superDigit(sum(number));

}

// finding the sum of digits using recursive
int sum(unsigned int number) {
    if (number == 0) {
        return number;
    }
    int remain = number % 10;
    return remain + sum(number / 10);
}

// finding the sum of digits of first number recursively
int getSum(unsigned int number, unsigned int k) {
    if (k == 1) {
        return number;
    }
    int digitsum = sum(number);
    return digitsum + getSum(digitsum, k - 1);

}

// the method which finds the number of digit recursively.
int getLength(int number) {
    int length = 0;
    if (number == 0) {
        return length;
    }
    length++;
    return length + getLength(number / 10);

}



