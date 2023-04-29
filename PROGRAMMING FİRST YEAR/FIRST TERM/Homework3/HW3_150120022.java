import java.util.Scanner;
// Tolga Fehmioðlu 150120022

public class HW3_150120022 {
    public static void main(String[] args) {
    	// Creating a scanner object
        Scanner input = new Scanner(System.in);

          // Creating a while loop to prompt the user to choose a shape until choosing exit option 
        while (true) {
            System.out.println("Which shape would you like to draw");
            System.out.println("1. Line");
            System.out.println("2. Triangle");
            System.out.println("3. Rectangle");
            System.out.println("4. Parabola");
            System.out.println("5. Circle");
            System.out.println("6.Exit");
           
            //Taking shape number from the user
            int shapenumber = input.nextInt();
            
             // The condition if the user selects 1(Calculation line)
            if (shapenumber == 1) {
                System.out.println("Line formula is y=ax+b");
                System.out.print("Please enter the coefficients a and b: ");
                
                // Taking the coefficients of the line from the user
                int a = input.nextInt();
                int b = input.nextInt();
                 
                for (int j = 10; j >= -11; j--) {// Creating a loop to control the y axis
                    for (int i = -10; i <= 11; i++) { // Creating another loop to control the x axis

                    	// The condition for drawing line if there is a root
                        if (a * i + b == j)
                            System.out.print("*");
                        // The condition for drawing y axis 
                        else if (j == 0) {
                            if (i == 0)
                                System.out.print("|");
                            else if (a * i + b == j)
                                System.out.print("*");
                            else if (i == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                            // The condition for drawing x axis 
                        } else if (i == 0)
                            if (j == 10)
                                System.out.print("y");
                            else
                                System.out.print("|");
                        
                        // Ýf there is no condition, We need to print space.
                        else {
                            System.out.print(" ");
                        }


                    }
                    System.out.println();
                }
                
                // The condition if the statement is a triangle

            } else if (shapenumber == 2) {
                System.out.println("For triangle, we need the coordinates of the points for three vertices");
                System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f: ");
                
                // Taking three coordinates of 3 vertices of the rectangle from the user 
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();
                int d = input.nextInt();
                int e = input.nextInt();
                int f = input.nextInt();
                input.nextLine();
                
                // Declaring variables to return the slope and constant value of 3 line of triangle while creating new methods.
                double k, l, m, n, t, p;
                k = calculateSlope(a, b, c, d);
                l = calculateConstant(a, b, c, d);
                m = calculateSlope(c, d, e, f);
                n = calculateConstant(c, d, e, f);
                t = calculateSlope(a, b, e, f);
                p = calculateConstant(a, b, e, f);
                
                // Using math class to calculate the max and min values of coordinates to limit the triangle 
                int ymax = Math.max(Math.max(b, d), f);
                int ymin = Math.min(Math.min(b, d), f);
                int xmax = Math.max(Math.max(a, c), e);
                int xmin = Math.min(Math.min(a, c), e);

                for (int j = 10; j >= -11; j--) {// The same loop for y axis as well as drawing line
                	
                    String line = ""; // Ýnitialing a line to add *
                    
                    for (int i = -10; i <= 11; i++) { //// The same loop for x axis as well as drawing line
                    	
                    	// Creating a boolean variable to check if the coordinates are in the triangle or not
                        boolean isRangeValid = (xmin <= i && i <= xmax) && (ymin <= j && j <= ymax);
                      
                        // Ýf the coordinates are in the triangle and indicates a line we need to print *
                        if (Math.round(k * i + l) == j && isRangeValid) {
                            line += "*";
                        } else if (Math.round(m * i + n) == j && isRangeValid) {
                            line += "*";
                        } else if (Math.round(t * i + p) == j && isRangeValid) {
                            line += "*";
                            
                            // the else condition will print the coordinate system.
                        } else line = printCoordinateSystem(a, b, ymax, ymin, xmax, xmin, j, line, i);


                    }
                    // in this part, the triangle is not the same as its planned. Ýt prints two * for two line.We are modifying it 
                    // in that part using a method to fix it. 
                    line = modifyLine(line);
                    System.out.print(line);
                    System.out.println();
                }

                 // the condition if the  shape indicates a rectangle 
            } else if (shapenumber == 3) {
                System.out.println("For rectangle, we need the coordinates of the points for three vertices.");
                System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f:");
              
                // Taking the coordinates of six vertices of rectangle from the user 
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();
                int d = input.nextInt();
                int e = input.nextInt();
                int f = input.nextInt();
                input.nextLine();
                
                // The condition to prompt the user if the points doesn't give us a rectangle
                if (a!=e || b != d) {
                    System.out.println("These points cannot construct a rectangle"+"\n");
                    
                } else {
                    int ymax = b;
                    int ymin = f;
                    int xmax = c;
                    int xmin = a;
                    for (int j = 10; j >= -11; j--) {// creating a loop to draw the y axis
                    	
                    	// initialing a string variable to add * to the rectangle
                        String line = "";
                        
                        for (int i = -10; i <= 11; i++) { // creating a loop to draw the x axis
                           
                        	// Ýf the coordinates are in the rectangle and indicates a line we need to print *
                        	boolean isRangeValid = (xmin <= i && i <= xmax) && (ymin <= j && j <= ymax);
                            if ((j == ymax || j == ymin) && isRangeValid) {
                                line += "*";
                            } else if ((i == a || i == c) && isRangeValid) {
                                line += "*";
                                
                                // the else condition will print the coordinate system.
                            } else {
                                line = printCoordinateSystem(a, b, ymax, ymin, xmax, xmin, j, line, i);
                            }


                        }
                        System.out.print(line);
                        System.out.println();
                    }
                }

                // The condition if the statement is a parabola
            } else if (shapenumber == 4) {
                System.out.println("Parabola formula is y = ax^2 + bx + c");
                System.out.print("Please enter the coefficients a, b and c: ");
             
                // Taking three coefficients of parabola from the user
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();
                
                for (int j = 10; j > -11; j--) { // The same logic to draw y axis
                    for (int i = -10; i <= 11; i++) { // The same logic to draw x axis
                        
                    	// A boolean variable to check if the point is a root or not
                    	boolean root = a * i * i + b * i + c == j;
                    	
                    	// The same logic to implement the coordinate system as well as drawing a line
                        if (root) {
                            System.out.print("*");
                        } else if (j == 0) {
                            if (i == 0)
                                System.out.print("|");
                            else if (root)
                                System.out.print("*");
                            else if (i == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                        } else if (i == 0) {
                            if (root)
                                System.out.print("*");
                            else if (j == 10)
                                System.out.print("y");
                            else
                                System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }

                    }
                    System.out.println();

                }
                // The condition if the shape is a circle
            } else if (shapenumber == 5) {
                System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
                System.out.print("Please enter the coordinates of the center (a,b) and the radius: ");
                int a = input.nextInt();
                int b = input.nextInt();
                int radius = input.nextInt();
                input.nextLine();
                for (int j = 10; j >= -11; j--) {// //  The same logic to draw y axis
                    for (int i = -10; i <= 11; i++) { // The same logic to draw x axis
                    	
                    	// A boolean variable to check if the point is the root of circle or not
                       boolean root = Math.pow(i - a, 2) + Math.pow(j - b, 2) == Math.pow(radius, 2);
                       
                       // The same  logic to implement the coordinate system as well as drawing a line and a parabola.
                       if (root)
                            System.out.print("*");
                        else if (j == 0) {
                            if (i == 0)
                                System.out.print("|");
                            else if (root)
                                System.out.print("*");
                            else if (i == 11)
                                System.out.print("x");
                            else
                                System.out.print("-");
                        } else if (i == 0) {
                            if (j == 10)
                                System.out.print("y");
                            else if (root)
                                System.out.print("*");
                            else
                                System.out.print("|");
                        } else
                            System.out.print(" ");
                    }
                    System.out.println();
                }
                
                // The condition if the user select 6 which means exit the loop and finish the program.
            } else {
                break;
            }


        }

    }

    // Creating a method to implement the coordinate system and to use it in main method
    public static String printCoordinateSystem(int a, int b, int ymax, int ymin, int xmax, int xmin, int j, String line, int i) {
        if (j == 0) {
            if (i == 0) {
                line += "|";
            } 
              else if (i == 11) {
                line += "x";
            } else {
                line += "-";
            }

            // -1 2 3 2 -1 -5 3 -5
        } else if (i == 0)
            if (j == 10) {
                line += "y";

            } else {
                line += "|";
            }
        else {
            line += " ";
        }
        return line;
    }

    public static String modifyLine(String line) {

    	// This method enables us to fix the triangle's fix two lines and return the new line which is correct one
        if (isLineValid(line)) {
            return line;
        } else {
            int firstIndexOfStar = line.indexOf('*');
            int lastIndexOfStar = line.lastIndexOf('*');
            String newLine = "";
            int length = line.length();
            for (int i = 0; i < length; i++) {
                if (line.charAt(i) == '*') {
                    if ((i == firstIndexOfStar) || (i == lastIndexOfStar)) {
                        newLine += "*";
                    } else {
                        newLine += " ";
                    }
                } else {
                    newLine += line.charAt(i);
                }
            }
            return newLine;
        }
    }

    // This is a method which the elimination part of two rows of rectangle except first and final to fix these parts
    public static boolean isLineValid(String line) {
        int lineLength = line.length();
        int midIndex = (lineLength - 1) / 2;
        return line.charAt(midIndex) != '|' || !line.contains("*");
    }
    // This is another method to calculate the slope of a line of rectangle
    public static double calculateSlope(int x1, int y1, int x2, int y2) {
        //  We are using the calculation according to this formula: y - y1 = m(x-x1) -> y = mx - mx1 + y1
        
        double slope = 0;
        
        if (x1 - x2!=0) {
           slope = (double) (y1 - y2) / (x1 - x2);
        }
       return slope;
   }
    

    // The method to calculate the constant value of each line
    public static double calculateConstant(int x1, int y1, int x2, int y2) {
       
    	// We use this formula to calculate it:  y - y1 = m(x-x1) -> y = mx - mx1 + y1
        double slope = calculateSlope(x1, y1, x2, y2);
        return -slope * x1 + y1;
    }


}