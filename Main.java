/* 
 * @Author: Santiago Betancur   
*/

import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
      
        //__________________________
        System.out.println();

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String CYAN = "\u001B[36m";

        User_input u = new User_input();

        //__________________________
   
        while (true){

               
            System.out.println("Running...\n");
            u.catch_inputs();
            Parser parser = u.set_inputs();
            ArrayList<String> inputs = u.get_inputs();

            System.out.println(CYAN + "\n________" + RESET);
            System.out.println();    
            for (int i = 0; i < inputs.size(); i++){

                parser.setInput(inputs.get(i));

                String initial_current = String.valueOf(parser.Non_Terminals.get(0));

                if (parser.recursive_Parser(initial_current, 0)){

                    System.out.println(GREEN + " | " + RESET + CYAN + "Yes" + RESET);
                 
                }else{

                    System.out.println(RED + " | " + RESET + CYAN + "No" + RESET);
                   
                }
            }

            System.out.println(CYAN + "________\n" + RESET); 
            break;

        }
  
    }
}