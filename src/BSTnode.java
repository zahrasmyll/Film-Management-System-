package com.mycompany.filmmanagement;


public class BSTnode {
    String key; //film ya da aktor ismi
 Object data; //film veya aktor nesnesi
 BSTnode left;
 BSTnode right;
 
 public BSTnode(String key , Object data){
     this.key=key;
     this.data=data;
     this.left=null;
     this.right=null;
 }

}
