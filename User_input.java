import java.util.Scanner;
import java.util.ArrayList;

public class User_input {

    ArrayList<String> productions = new ArrayList<>();
    ArrayList<String> strs = new ArrayList<>();
    String non_T; 
    Parser parser = new Parser();
    int n = 0; // Non-terminals.
    int m = 0; // Grammar Rules.
    int k = 0; // Strings to be analysed.


    public void catch_inputs(){

        Scanner sc = new Scanner(System.in); 
        
        while (true){

            //___________________________________________________
            //As follows 1 2 3.
            String f_input = sc.nextLine();
            System.out.println("--------");
            String[] l = f_input.split(" ");

            if (l.length == 3){

                n = Integer.valueOf(l[0]);
                m = Integer.valueOf(l[1]);
                k = Integer.valueOf(l[2]);

            }
            
            //___________________________________________________
            //As follows S A D.
            non_T = sc.nextLine();
            System.out.println("--------");
        
            //___________________________________________________  
            //As follows A-a.  
            for (int i = m; i > 0; i--) { 

                String p = sc.nextLine();
                productions.add(p);
    
            }
            System.out.println("--------");
         
            //____________________________________________________
            //As follows aabb.
            for(int j = k; j > 0; j--){
                
                String str = sc.nextLine();
                strs.add(str);

            }
            System.out.println("--------");
        
            break;
        }

    sc.close();    
    }



    public Parser set_inputs(){

        //Fill the productions in a dictionary.

        for ( String i : productions){

            String[] parts = i.split("-");
            Character key = parts[0].charAt(0);
            String value  = parts[1];

            //Check if the key already exist in the dictionary.
            if(parser.Productions.containsKey(key)){
                parser.Productions.get(key).add(value);
            }else{
                parser.addProductions(key, value);
            }

        }

        //Set Non-terminals.
        String s = non_T.replace(" ", "");
        char[] c = s.toCharArray();
        for (int k = 0; k < c.length; k ++){
            parser.addN_Terminals(c[k]);
        }

        return parser;

    }

    //Getter for the inputs.
    public ArrayList<String> get_inputs(){
        
        return strs;
    }
    
}
