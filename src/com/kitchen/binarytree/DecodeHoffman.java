package com.futurejob.test.binarytree;

public class DecodeHoffman {

    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node('_');
        root.right = new Node('A');
        root.left = new Node('_');
        root.left.right = new Node('C');
        root.left.left = new Node('B');

        decode2("1001011", root);
    }

    static void decode(String s, Node root) {
        Node current=root;
        Node lastNode=current;
        StringBuffer sb=new StringBuffer();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if (c == '0'){
                lastNode = current;
                current = current.left;
            } else if (c == '1'){
                lastNode = current;
                current = current.right;
            }
            if (current == null){
                sb.append(lastNode.data);
                current = root;
                //if (i < s.length()){
                lastNode = current;
                //}
            } else {
                i++;
            }
        }
        sb.append(current.data);
        System.out.print(sb.toString());

    }

        static void decode2(String s, Node root) {
        Node current=root;
        StringBuffer sb=new StringBuffer();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ((c == '0' && current.left == null) || (c == '1' && current.right == null)){
                sb.append(current.data);
                current=root;
            } else if (c == '1'){
                current = current.right;
            } else if (c == '0'){
                current = current.right;
            }
        }
        System.out.print(sb.toString());

    }
}
