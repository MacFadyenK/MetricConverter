import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //constant values for critical conversions
        final double miToKm = 1.6094;
        final double inToCm = 2.54;
        final double miToIn = 63360;
        final double kgToLb = 2.204623;
        final double galToL = 3.785412;

        String unitStart = "";
        String unitEnd = "";
        double value = 0;
        double result = 0;
        int type = 0;
        
        boolean exit = false;
        boolean valid = false;
        Scanner scnr = new Scanner(System.in);

        //message to users upon first running program
        System.out.println("Welcome to the command line metric converter!\n");
        System.out.println("Enter your desired (abbreviated) units and value according to the prompts.\n");
        System.out.println("To exit the program, type -1.");

        //main loop for converter while user is still converting
        //exit becomes true when inputs -1
        contLoop:
        while(!exit){
            //Unit to be converted from
            valid = false;
            System.out.println("\nInput unit to be converted from:");
            //loops until a valid unit is input
            while(!valid){
                //scans value for first unit
                unitStart = scnr.nextLine();

                switch(unitStart){
                    //exit the program
                    case "-1":
                        exit = true;
                        break contLoop;

                    //all distance measurements implemented
                    case "km":
                    case "mi":
                    case "cm":
                    case "in":
                        //type 0 for distance
                        type = 0;
                        valid = true;
                        break;

                    //all weight measurements
                    case "kg":
                    case "lb":
                        //type 1 for weight
                        type = 1;
                        valid = true;
                        break;

                    //all volume measurements
                    case "L":
                    case "gal":
                        //type 2 for volume
                        type = 2;
                        valid = true;
                        break;

                    //for invalid/non-implemented inputs
                    default:
                        System.out.println("Input has not yet been implemented or is invalid.");
                        System.out.println("Please enter another unit:");
                        break;
                }
            }

            //Unit to be converted into
            valid = false;
            System.out.println("Input unit to be converted into:");
            //loops until valid input is entered for second unit
            while(!valid){
                unitEnd = scnr.nextLine();

                //exit the program
                if(unitEnd.equals("-1")){
                    exit = true;
                    break contLoop;
                }

                //checks for valid second units according to what the first unit is
                switch(type){
                    //when the first unit is a distance
                    case 0:
                        switch(unitEnd){
                            //valid cases for the second input
                            case "km":
                            case "mi":
                            case "cm":
                            case "in":
                                valid = true;
                                break;
                        }
                        break;

                    //when the first unit is a weight
                    case 1:
                        switch(unitEnd){
                            //valid second inputs
                            case "kg":
                            case "lb":
                                valid = true;
                                break;
                        }
                        break;

                    //when the first input is a volume
                    case 2:
                        switch(unitEnd){
                            //valid second inputs
                            case "L":
                            case "gal":
                                valid = true;
                                break;
                        }
                        break;
                }
                //if the first and second unit inputted are the same
                if(unitStart.equals(unitEnd)){
                    System.out.println("This is the same unit.");
                    System.out.println("There is no converesion needed.");
                    System.out.println("Enter a different unit to be converted into:");
                    valid = false;
                    
                }
                //the unit inputted is not valid
                else if(!valid){
                    System.out.println("Input is invalid or incompatible at this time.");
                    System.out.println("Please enter another unit:");
                }
            }

            //The numerical value for converting
            valid = false;
            System.out.println("Input numerical value to be converted:");
            //loops until valid input is entered for the value
            while(!valid){
                //when input is a number
                try {
                    value = scnr.nextDouble();
                    //exiting the program
                    if(value == -1){
                        exit = true;
                        break contLoop;
                    }
                    //when value inputted is a negative number
                    if(value < 0){
                        System.out.println("Number is negative.\nPlease input a positive number to convert:");
                    }
                    //valid input
                    else{
                        valid = true;
                    }
                //when input is not a number
                } catch (Exception e) {
                    System.out.println("Input is not a number.");
                    System.out.println("Please enter again:");
                }
                scnr.nextLine();
            }

            //Converted value calculated and printed in terminal
            System.out.println("\nConversion from " + value + " " + unitStart + " to " + unitEnd + ":");

            //switch statement to end all switch statements
            //converts from the first unit inputted into the second unit
            switch(unitStart){
                //when first unit is kilometers
                case "km":
                    switch(unitEnd){
                        //from km -> mi
                        case "mi":
                            result = value/miToKm;
                            System.out.printf("%.3f mi\n", result);
                            break;
                        //from km -> cm
                        case "cm":
                            result = value*1000*100;
                            System.out.printf("%.3f cm\n", result);
                            break;
                        //from km -> in
                        case "in":
                            result = value*1000*100/inToCm;
                            System.out.printf("%.3f in\n", result);
                            break;
                    }
                    break;

                //when first unit is miles
                case "mi":
                    switch(unitEnd){
                        //from mi -> km
                        case "km":
                            result = value*miToKm;
                            System.out.printf("%.3f km\n", result);
                            break;
                        //from mi -> cm
                        case "cm":
                            result = value*miToIn*inToCm;
                            System.out.printf("%.3f cm\n", result);
                            break;
                        //from mi -> in
                        case "in":
                            result = value*miToIn;
                            System.out.printf("%.3f in\n", result);
                            break;
                    }
                    break;

                //when first unit is kilograms
                case "kg":
                    switch(unitEnd){
                        //from kg -> lb
                        case "lb":
                            result = value*kgToLb;
                            System.out.printf("%.3f lb\n", result);
                            break;
                    }
                    break;

                //when first unit is pounds
                case "lb":
                    switch(unitEnd){
                        //from lb -> kg
                        case "kg":
                        result = value/kgToLb;
                        System.out.printf("%.3f kg\n", result);
                        break;
                    }
                    break;

                //when first unit is liters
                case "L":
                    switch(unitEnd){
                        //from L -> gal
                        case "gal":
                            result = value/galToL;
                            System.out.printf("%.3f gal\n", result);
                            break;
                    }
                    break;

                //when first unit is gallons
                case "gal":
                    switch(unitEnd){
                        //from gal -> L
                        case "L":
                            result = value*galToL;
                            System.out.printf("%.3f L\n", result);
                            break;
                    }
                    break;

                //when first unit is cm
                case "cm":
                    switch(unitEnd){
                        //from cm -> km
                        case "km":
                            result = value/1000/100;
                            System.out.printf("%.3f km\n", result);
                            break;
                        //from cm -> mi
                        case "mi":
                            result = value/1000/100/miToKm;
                            System.out.printf("%.3f mi\n", result);
                            break;
                        //from cm -> in
                        case "in":
                            result = value/inToCm;
                            System.out.printf("%.3f in\n", result);
                            break;
                    }
                    break;

                //when first unit is inches
                case "in":
                    switch(unitEnd){
                        //from in -> km
                        case "km":
                            result = value*inToCm/100/1000;
                            System.out.printf("%.3f km\n", result);
                            break;
                        //from in -> mi
                        case "mi":
                            result = value/miToIn;
                            System.out.printf("%.3f mi\n", result);
                            break;
                        //from in -> cm
                        case "cm":
                            result = value*inToCm;
                            System.out.printf("%.3f cm\n", result);
                            break;
                    }
                    break;
            }
        }
        scnr.close();

    }
}
