// DUE 2/1/2022 Program Abstract and Design Assignment 3 Ascii Art
// This file contains different functions that print out different types of pyramids (including a mario stair pyramid)
// The goal of this assignment was really just to create some ascii art

public class AsciiArt {
    static final int SIZE = 10; // have many faces (dudes) that will be printed
    static final int ROWS = 10; // amount of rows the pyramid will be made out of

    public static final String ARMleft = "¯\\_"; // dudes left arm design
    public static final String ARMright = "_/¯"; // dudes right arm design
    public static final String FACE = "(ツ)"; // dudes face design
    public static final String BETWEEN = "   "; // what spaces out the dudes
    public static final String PyramidSymbol = "*"; // what symbol our pyramids are made out of

    // ¯\_ (ツ) _/¯ |||||| Original Dude Design
    public static void main(String[] agrs) {
        lineOfFaces();
        System.out.println(" ");
        HalfPyramid();
        System.out.println(" ");
        invertHalfPyramid();
        System.out.println(" ");
        interestingFinding();
    }

    static void lineOfFaces() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(ARMleft);
            for (int o = 0; o < SIZE - 1; o++) ;
            {
                System.out.print(FACE);
                for (int p = 0; p < SIZE - 2; p++) ;
                {
                    System.out.print(ARMright);
                    for (int h = 0; h < SIZE - 3; h++) ;
                    {
                        System.out.print(BETWEEN);
                    }
                }
            }
        }
    }

    static void HalfPyramid() {
        for (int i = 0;i <= ROWS-1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(PyramidSymbol + " ");
            }
            System.out.println();
        }
    }

    static void invertHalfPyramid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < ROWS - i; j++) {
                System.out.print(PyramidSymbol + " ");
            }
            System.out.println();
        }
    }
    static void interestingFinding () { // if you leave out the space on line 63 (next comment down) you get a mario staircase
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < ROWS - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* "); // add space here on either side and comment out the fourth for loop for an Isosceles Triangle
            }
            System.out.println();
        }
    }
}
