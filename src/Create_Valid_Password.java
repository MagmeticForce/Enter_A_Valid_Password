import java.util.Scanner;

public class Create_Valid_Password {

    public static boolean check_if_password_is_valid (String password_argument) {
        /*requirements
         * between 8-16 characters
         * must be a combination of at least three out of the following four categories:
            * (1) lower case letters, i.e., a-z
            * (2) upper case letters, i.e., A-Z
            * (3) numbers, i.e., 0-9
            * (4) the following special symbols: ~!@#$%^&*()-=+_
         */

        

        String[] password_argument_in_array = password_argument.split("");
          
        boolean length_requirement_has_been_met = false;

        boolean lowercase_requirement_has_been_met = false;
        boolean uppercase_requirement_has_been_met = false;
        boolean number_requirement_has_been_met = false;
        boolean symbol_requirement_has_been_met = false;
        int number_of_additional_requirements_met = 0;

        //check if length requirement has been met
        if (password_argument_in_array.length >= 8 && password_argument_in_array.length <= 16) {
            length_requirement_has_been_met = true;
            //System.out.println("Length requirement has been met"); //DEBUG
        } 
        else {length_requirement_has_been_met = false;}

        int parsed_int = 0;

        //check how many additional requirements have been met
         for (int i = 0; i < password_argument_in_array.length; i++) {
            try { //chek for numbers
                parsed_int = Integer.parseInt(password_argument_in_array[i]);
                number_requirement_has_been_met = true;
            }
            catch (NumberFormatException e) {
                //check for uppercase
                if (password_argument_in_array[i].equals("A") || password_argument_in_array[i].equals("B") || password_argument_in_array[i].equals("C") || password_argument_in_array[i].equals("D") || password_argument_in_array[i].equals("E") || password_argument_in_array[i].equals("F") || password_argument_in_array[i].equals("G") || password_argument_in_array[i].equals("H") || password_argument_in_array[i].equals("I") || password_argument_in_array[i].equals("J") || password_argument_in_array[i].equals("K") || password_argument_in_array[i].equals("L") || password_argument_in_array[i].equals("M") || password_argument_in_array[i].equals("N") || password_argument_in_array[i].equals("O") || password_argument_in_array[i].equals("P") || password_argument_in_array[i].equals("Q") || password_argument_in_array[i].equals("R") || password_argument_in_array[i].equals("S") || password_argument_in_array[i].equals("T") || password_argument_in_array[i].equals("U") || password_argument_in_array[i].equals("V") || password_argument_in_array[i].equals("W") || password_argument_in_array[i].equals("X") || password_argument_in_array[i].equals("Y") || password_argument_in_array[i].equals("Z")) {
                    uppercase_requirement_has_been_met = true;
                }
                //check for lowercase
                else if (password_argument_in_array[i].equals("a") || password_argument_in_array[i].equals("b") || password_argument_in_array[i].equals("c") || password_argument_in_array[i].equals("d") || password_argument_in_array[i].equals("e") || password_argument_in_array[i].equals("f") || password_argument_in_array[i].equals("g") || password_argument_in_array[i].equals("h") || password_argument_in_array[i].equals("i") || password_argument_in_array[i].equals("j") || password_argument_in_array[i].equals("k") || password_argument_in_array[i].equals("l") || password_argument_in_array[i].equals("m") || password_argument_in_array[i].equals("n") || password_argument_in_array[i].equals("o") || password_argument_in_array[i].equals("p") || password_argument_in_array[i].equals("q") || password_argument_in_array[i].equals("r") || password_argument_in_array[i].equals("s") || password_argument_in_array[i].equals("t") || password_argument_in_array[i].equals("u") || password_argument_in_array[i].equals("v") || password_argument_in_array[i].equals("w") || password_argument_in_array[i].equals("x") || password_argument_in_array[i].equals("y") || password_argument_in_array[i].equals("z")) {
                    lowercase_requirement_has_been_met = true;                    
                }

                //check for symbols
                else if (password_argument_in_array[i].equals("~") || password_argument_in_array[i].equals("!") || password_argument_in_array[i].equals("@") || password_argument_in_array[i].equals("#") || password_argument_in_array[i].equals("$") || password_argument_in_array[i].equals("%") || password_argument_in_array[i].equals("^") || password_argument_in_array[i].equals("&") || password_argument_in_array[i].equals("*") || password_argument_in_array[i].equals("(") || password_argument_in_array[i].equals(")") || password_argument_in_array[i].equals("-") || password_argument_in_array[i].equals("+") || password_argument_in_array[i].equals("=") || password_argument_in_array[i].equals("_")) {
                    symbol_requirement_has_been_met = true;                    
                }

            }
         }

         //check howm any additional requirements were met
         if (number_requirement_has_been_met) {
            number_of_additional_requirements_met++;
            //System.out.println("Number requirement has been met"); //DEBUG
         }
         if (uppercase_requirement_has_been_met) {
            number_of_additional_requirements_met++;
            //System.out.println("Uppercase requirement has been met"); //DEBUG
         }
         if (lowercase_requirement_has_been_met) {
            number_of_additional_requirements_met++;
            //System.out.println("Lowercase requirement has been met"); //DEBUG
         }
         if (symbol_requirement_has_been_met) {
            //System.out.println("Symbol requirement has been met"); //DEBUG
            number_of_additional_requirements_met++;
         }

         if (number_of_additional_requirements_met >= 3 && length_requirement_has_been_met) {
            return true;
         }
         
         return false;
    }

    public static void main (String[] args) throws Exception {

        System.out.println("Welcome!");
        System.out.println("Please enter a valid password.");
        System.out.println("Password requirements:");
        System.out.println("* Must be between 8-16 characters");
        System.out.println("* Must meet at least three additional requirements: ");
        System.out.println("    * At least one lowercase letter");
        System.out.println("    * At least one uppercase letter");
        System.out.println("    * At least one number");
        System.out.println("    * At least one of the following symbols: ~!@#$%^&*()-+=_");
        
        //initialization
        Scanner input_detector = new Scanner(System.in);
        String user_input = "0";
        boolean the_password_is_valid = false;
        
        while (1==1) {

            user_input = input_detector.nextLine();

            the_password_is_valid = check_if_password_is_valid(user_input);

            if (the_password_is_valid) {
                System.out.println("Your password has been accepted!");
                break;
            }
            else {
                System.out.println("Unfortunately, your password has not been accepted.");
                System.out.println("Please double check that you met the requirements listed above.");
                System.out.println("Remember, your password must be between 8-16 characters.");
                System.out.println("Please try inputting a different password:");
            }

        }

        input_detector.close();

    }
}
