package com.mycompany.filmmanagement;


public class SearchingFunction {
    private BSTnode root;

    public SearchingFunction(BSTnode root) {
        this.root = null;
    }
 
  public void add(String name , Object data) {
  root=addRecursive(root ,name.toLowerCase(),data);    
  }
 
  private BSTnode addRecursive(BSTnode current , String key , Object data){
      if(current==null){
          return new BSTnode(key,data);
          
      }
      
      if(key.compareTo(current.key)<0){
          current.left=addRecursive(current.left,key,data);
      }
      else if(key.compareTo(current.key)>0){
          current.right=addRecursive(current.right , key,data);
      }
      
       return current;
       
       /*A.compareTo(B):
       < 0 ise, A alfabetik olarak B'den ÃƒÂ¶nce gelir.
       > 0 ise, A alfabetik olarak B'den sonra gelir.
       = 0 ise, A ve B aynÃ„Â±dÃ„Â±r.*/
}
  
  public Object searchRecursive( String name ){
        return searchRecursive(root, name.toLowerCase());  
  }
  
  private Object searchRecursive(BSTnode current, String key) {
        if (current == null) {
            return null; // Not found
        }

        if (key.equals(current.key)) {
            return current.data; // Found
        }

        if (key.compareTo(current.key) < 0) {
            return searchRecursive(current.left, key);
        } else {
            return searchRecursive(current.right, key);
        }
    }
  
  public void printAll() {
        printInOrder(root);
    }

  private void printInOrder(BSTnode node){
      if(node != null){
          printInOrder(node.left);
          System.out.println(node.key + "--->" + node.data);
          printInOrder(node.right);
  }
  }

}
