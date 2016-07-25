import java.io.*;
import java.util.*;

class Solution {
  
  public static class Node {
    
   private int val;
   private Node next;
    
   public Node(int v){
      val = v;
   }
  }
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    Node node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    node.next.next.next.next = new Node(5);
    
    printList(node);
    node = ReverseList(null, node);
    printList(node);
    node = ReverseListIter(node);
    printList(node);
  }
  
  public static Node ReverseList(Node prev, Node curr){
     
    if (curr == null){
      return prev; 
    }
    
    Node head = ReverseList(curr, curr.next);
    curr.next = prev;
    
    return head;
    
  }
  
  public static Node ReverseListIter(Node node){
    
    Node prev = null;
    Node curr = node;
    
    while (curr != null){
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    
    return prev;
  
  }
  
  public static void printList(Node node){
    
    while (node != null){
      System.out.print(node.val + " ");
      node = node.next;
    }
    
    System.out.println();
  }  
}
