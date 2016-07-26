import java.io.*;
import java.util.*;

/*
 convert this tree:
 
             ___________50___________
            |                        |
       ____30____                ____75____
      |          |              |          | 
   __20__      __40__        __60__      __85__
  |      |    |      |      |      |    |      |
 10      25  35      45    55      70  80      100 
 
 
 to this linked list:
 50->30->75->20->40->60->85->10->25->35->45->55->70->80->100 
 
*/

class Solution {
  
  public static class TreeNode {
    
   private int val;
   private TreeNode left;
   private TreeNode right;
    
   public TreeNode(int v){
      val = v;
   }
  }
  
  public static class LLNode {
    
   private int val;
   private LLNode next;
    
   public LLNode(int v){
      val = v;
   }
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(75);
    
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(85);
    
    root.left.left.left = new TreeNode(10);
    root.left.left.right = new TreeNode(25);
    root.left.right.left = new TreeNode(35);
    root.left.right.right = new TreeNode(45);
    
    root.right.left.left = new TreeNode(55);
    root.right.left.right = new TreeNode(70);
    root.right.right.left = new TreeNode(80);
    root.right.right.right = new TreeNode(100);
    
    printTreeInOrder(root);
    
    LLNode node = converTreeToList(root);
    System.out.println();
    printList(node);
    
  }

    public static LLNode converTreeToList(TreeNode root){
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    
    LLNode head = null;
    LLNode curr = null;
    
    while (!queue.isEmpty()){
     
      TreeNode node = queue.remove();
      
      if (head == null){
        head = new LLNode(node.val);
        curr = head;
      }else{  
        curr.next = new LLNode(node.val);
        curr = curr.next;
      }
      
      if (node.left != null){
        queue.add(node.left);
      }
      if (node.right != null){
        queue.add(node.right);
      }
    }
  
    return head;
  }
  
  public static void printList(LLNode node){
    
    while (node != null){
      System.out.print(node.val + " ");
      node = node.next;
    }
    
    System.out.println();
  } 
  
  public static void printTreeInOrder(TreeNode node){
    
    if (node == null){
      return;
    }
    
    printTreeInOrder(node.left);
    System.out.print(node.val + " ");
    printTreeInOrder(node.right);
  }
}
