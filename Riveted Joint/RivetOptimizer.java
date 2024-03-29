import java.util.Scanner;

public class RivetOptimizer {
    public static void main(String[] args) {
        /**
         * Variable for analysis
         */

        // Using eighth inch steel rivets
        final double RIVET_DIAMETER = .125; // inches
        final double SIGMA_RIVET = 800; // pound force

        // Variable instantiation
        int i;
        int j;
        int k;
        int l;
        int discretization;
        int pinQuantity;
        double width;
        double height;
        double thickness;
        double maxStrength;
        double[] strengths = new double[3];
        
        /**
         * User input for discretization level
        */
        Scanner scnr = new Scanner(System.in);
        // Width
        System.out.print("Enter the width of the joint: ");
        width = scnr.nextDouble();
        System.out.println();
        // Height
        System.out.print("Enter the height of the joint: ");
        height = scnr.nextDouble();
        System.out.println();
        // Thickness
        System.out.println("Enter the thickness of the plates");
        thickness = scnr.nextDouble();
        System.out.println();
        // Discretization
        System.out.print("Enter level of discretization: ");
        discretization = scnr.nextInt();
        System.out.println();
        // Number of pins
        System.out.print("Enter the max number of pins to test for: ");
        pinQuantity = scnr.nextInt();
        System.out.println();
        scnr.close();

        // Create an array of x coordinates along the width of the plate
        double[] widthsList = new double[discretization];
        for (i = 0; i < widthsList.length; ++i) {
            widthsList[i] = (width / discretization) * i;
        }

        // Create an array of y coordinates along the height of the plate
        double[] heightsList = new double[discretization];
        for (i = 0; i < heightsList.length; ++i) {
            heightsList[i] = (height / discretization) * i;
        }

        for (i = 0; i < widthsList.length; ++i) {
            for (j = 0; j < heightsList.length; ++j) {
                for (k = 0; k < pinQuantity; ++k) {
                    
                    strengths[0] = k * thickness * widthsList[i];
                    strengths[1] = k * thickness * heightsList[j];
                    strengths[2] = k * RIVET_DIAMETER * thickness;
                    
                    double tempMax = strengths[0];
                    for (l = 0; l < strengths.length; ++l) {
                        if (strengths[i] > tempMax) {
                            tempMax = strengths[i];
                        }
                    }
                    maxStrength = tempMax;
                }
            }
        }
    }
}
