/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchingArray;

/**
 *
 * @author diana
 */
class LinkedSymbolTable<K,V> {
    private Node first;

    private class Node {

        K word;
        V val;
        Node next;

        Node(K key, V val, Node next) {
            this.word = key;
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return word + " - " + val;
        }
        
    }

    public void put(K word, V val) {
        for (Node x = first; x != null; x = x.next)
        {
            if (word.equals(x.word))
            {
                x.val = val;
                return;
            }
        }
        first = new Node(word, val, first);
    }

    public V get(K word) {
        for (Node x = first; x != null; x = x.next) {
            if (word.equals(x.word)) {
                return x.val;
            }
        }
        return null;
    }
    
    public boolean contains(K word){
        return get(word) != null;
    }
    
    public void print(){
        for(Node x = first; x != null; x = x.next){
            System.out.println(x.toString());
        }
    }
}
