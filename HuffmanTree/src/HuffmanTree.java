import java.util.*;

public class HuffmanTree {
    List<Node> nodes = new ArrayList<Node>();

    public static void main(String[] args) {
        HuffmanTree ht = new HuffmanTree();
    }

    HuffmanTree(){
        nodes.add(new Node("a",2));
        nodes.add(new Node("b",5));
        nodes.add(new Node("c",3));
        nodes.add(new Node("d",1));
        nodes.add(new Node("e",7));
        nodes.add(new Node("f",9));

        Node root = null;
        while(nodes.size() > 1){
            Integer left = Integer.MAX_VALUE;    //Smallest
            Integer right = Integer.MAX_VALUE;   //Second smallest
            Node leftChild = null;
            Node rightChild = null;
            for(Node node : nodes){
                if(node.m_frequency < left){
                    right = left;
                    rightChild = leftChild;
                    left = node.m_frequency;;
                    leftChild = node;
                }
                else if(node.m_frequency < right){
                    right = node.m_frequency;
                    rightChild = node;
                }
            }
            Node parent = new Node(leftChild.m_symbol + rightChild.m_symbol, leftChild.m_frequency + rightChild.m_frequency);
            parent.left = leftChild;
            parent.right = rightChild;
            leftChild.parent = parent;
            rightChild.parent = parent;
            nodes.remove(leftChild);
            nodes.remove(rightChild);
            nodes.add(parent);
            root = parent;
        }
        ArrayList<Node> huffmanTree = new ArrayList<Node>();
        huffmanTree.add(root);
        while(!huffmanTree.isEmpty()){
            Node temp = huffmanTree.remove(0);
            if(temp.left == null && temp.right == null){
                System.out.print("Leaf!  ");
            }
            else if(temp.left == null){
                huffmanTree.add(temp.right);
            }
            else if(temp.right == null){
                huffmanTree.add(temp.left);
            }
            else{
                huffmanTree.add(temp.left);
                huffmanTree.add(temp.right);
            }
            System.out.print(temp.m_symbol + " " + temp.m_frequency +"\n");
        }
    }

    public class Node {
        Node parent = null;
        Node left = null;
        Node right = null;
        String m_symbol;
        int m_frequency;

        Node(String symbol, int frequency){
            m_symbol = symbol;
            m_frequency = frequency;
        }
    }
}
