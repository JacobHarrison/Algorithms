import java.util.*;

public class HuffmanTree {
    HashMap<String,Integer> SymbolToFrequency = new HashMap<String, Integer>();

    HuffmanTree(){
        SymbolToFrequency.put("a",2);
        SymbolToFrequency.put("b",5);
        SymbolToFrequency.put("c",3);
        SymbolToFrequency.put("d",1);
        SymbolToFrequency.put("e",7);
        SymbolToFrequency.put("f",9);

        while(!SymbolToFrequency.keySet().isEmpty()){
            Integer smallest = 1000000;
            Integer secondSmallest = 1000000;
            for(String symbol : SymbolToFrequency.keySet()){
                Integer frequency = SymbolToFrequency.get(symbol);
                if(frequency < smallest){
                    secondSmallest = smallest;
                    smallest = frequency;
                }
                else if(frequency < secondSmallest){
                    secondSmallest = frequency;
                }
            }

        }


    }


    public class Node {
        Node parent;
        Node left;
        Node right;
        String m_symbol;
        int m_frequency;

        Node(String symbol, int frequency){
            m_symbol = symbol;
            m_frequency = frequency;
        }
    }
}
