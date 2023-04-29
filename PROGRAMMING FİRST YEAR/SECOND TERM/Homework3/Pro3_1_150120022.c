#include <stdio.h>

/** Tolga Fehmioğlu
 * ID:150120022
  The purpose of this program to calculate the number of bunny's ears for each line recursively.
  */

unsigned int getbunnyEars(unsigned int n);


void printlines(unsigned int lineNumber, int currentLine);

int main() {
    unsigned int n;
    // taking input from user
    printf("Please enter the number of lines (n=):");
    scanf("%u", &n);
    printlines(n, 0);


    return 0;
}

// this function returns the ears of lineNumber according to the calculation recursively
unsigned int getbunnyEars(unsigned int n) {
    if (n == 0) {
        return 0;
    }
    if (n % 2 == 1) {
        return 2 + getbunnyEars(n - 1);
    } else {
        return 3 + getbunnyEars(n - 1);
    }
}

// this function will print all lines upto lineNumber one by one
void printlines(unsigned int lineNumber, int currentLine) {
    if (currentLine > lineNumber) {
        return;
    }
    printf("bunnyEars%u(%u): %u\n", lineNumber, currentLine, getbunnyEars(currentLine));
    ++currentLine;
    printlines(lineNumber, currentLine);
}

















