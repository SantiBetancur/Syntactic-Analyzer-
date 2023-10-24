import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Parser {
    //
    String input;
    ArrayList<Character> Non_Terminals = new ArrayList<>();
    Map<Character, ArrayList<String>> Productions = new HashMap<>();
  
   
   

    //Setters.

    public void setInput(String i){
        this.input = i ;
    }
  
    public void addN_Terminals(char NT){
        this.Non_Terminals.add(NT);
    }

    public void addProductions(Character key, String value){
        ArrayList<String> values = new ArrayList<>();
        values.add(value);
        this.Productions.put(key, values);
    }
  
    public boolean is_non_terminal(Character x){
        for (Character n : this.Non_Terminals){
            if (n == x){
                return true;
            }
        }
        return false;
    } 
    
  
    //Parsing function.

    public boolean recursive_Parser(String current_, int index){

        //Base case.
  
        if (current_.equals(this.input)){

            return true;
        }

        if (index >= current_.length() || index >= this.input.length()){
            return false;
        }

        //Compare the current state of the string.
        //Is terminal?    
        if (current_.charAt(index) == this.input.charAt(index)){
   
            index++;
            return recursive_Parser(current_, index);

        //Is non_terminal? 
        }else if (is_non_terminal(current_.charAt(index))){

            if (current_.length() > this.input.length()){
                return false;
            }

            //To save the last state if it needs to choose other path.    
            String aux_input = current_;
            int aux_index    = index;
        
            for (String production : this.Productions.get(current_.charAt(index))){

                String c = String.valueOf(current_.charAt(index));
                current_ = current_.replaceFirst(c, production);
                
                if (recursive_Parser(current_, index)){

                    //Good path.
                    return true;

                }else{

                    //Bad path, try other.
                    current_ = aux_input;
                    index = aux_index;
                    continue;

                }
            }

        }

        
        return false;
    }
   
      
}

