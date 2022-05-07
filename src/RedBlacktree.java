

public class RedBlacktree {
	public static String RED   = "1";
	public static String BLACK = "0";
	static Node nullTree;
	static Node root;
	 Node S;
	 Node helpNode;
	 
	 public RedBlacktree() {
		 nullTree = new Node();
		 nullTree.color = BLACK;
		 nullTree.leftChild = null;
		 nullTree.rightChild = null;
		   root = nullTree;
		  }

	 //////////////////////////////////////////////////////////
	 void inorderTraversal(Node node){  

	        if (node != nullTree)
	        {
	        	if(node.leftChild !=null) {
	        		   inorderTraversal(node.leftChild);
	        	}
	         
	            char c = 'R';
	            if (node.color == BLACK)
	                c = 'B';
	            System.out.print(node.element +""+c+" ");
	            inorderTraversal(node.rightChild);
	        }
	    }
	    
	     void  printTree(){
	        inorderTraversal(root);
	    }
////////////////////////END PRINT/////////////////////	 
	  boolean isEmpty(){
	        return root == nullTree;
	    }
//////////////////////////////END ISEMPTY//////////////////////
	  public boolean contains(String key,Node current){
	        boolean found=false;
	        while(current != nullTree && !found){
	            if(current.element.compareTo(key) > 0) current=current.leftChild;
	            else if(current.element.compareTo(key) <0) current=current.rightChild;
	            else {
	                found=true;
	                break;
	            }
	            contains(key,current);
	        }
	        return found;
	    }
	  
	    public boolean contains(String key){
	        return contains(key,root);
	    }
//////////////////////////////////////CONTAINS//////////////////////////////	    
	    public void search(String key){
	        if(contains(key,root))
	            System.out.println("The node: "+key);

	        else {
	            System.out.println("The node: Null");
	        }

	    }
////////////////////////////////END SEARCH////////////////////////	    
	    public void getRoot(){
	        System.out.println("The root is "+root.element);
	    }

//////////////////////////////////////////END GETROOT//////////////////////////////
	   void clear() {
		   root=nullTree;
	   }

	   Node MinimumValue(Node n) {
		   Node noww = n;
		  
		    while (noww.leftChild != nullTree) {
		    	noww = noww.leftChild;
		    }if(noww.leftChild ==null) {
		    	return noww;
		    }
		    	
		    return noww;
		  }
		
		
		 void EXCHANGE(Node M, Node C) {
			 
			 if(M.P ==null) {
				 root=C;
			 }else if(M.P.leftChild ==M) {
				 M.P.leftChild=C;
			 }else {
				 M.P.rightChild=C;
			 }
			 if(C!=null) {
				 C.P=M.P;
			 }
			
		 }
				
		 void DeleteCases(Node node) {
			 

			 Node T;
			 while(node !=root && node.color==BLACK) { 
				 if(node==node.P.leftChild) {
					 
					 T=node.P.rightChild;  //right uncle
					 
					 if(T.color==RED) {
						 T.color=BLACK;     //case 1
						 node.P.color=RED;  //case 1
						 LeftRotation(node.P); //case 1
						 T=node.P.rightChild;  //case 1
					 }
					
			
					 if(T.leftChild.color==BLACK && T.rightChild.color==BLACK) { //CASE 2
						 T.color=RED;                      //CASE 2 
						 node=node.P;                    //CASE 2
						 
					 }else {
						 if(T.rightChild.color==BLACK) {   //CASE 3
					 
						 T.leftChild.color=BLACK;        //CASE 3
						 T.color=RED;                //CASE 3
						 RightRotation(T);          //CASE 3
						 T=node.P.rightChild;   //CASE 3
						 
					 }
						 T.color=node.P.color;      //CASE 4
						 node.P.color=BLACK;        //CASE 4
						 T.rightChild.color=BLACK;   //CASE 4
						 LeftRotation(node.P);       //CASE 4
						 node=root;
					 }
					 
				 }else {
					 
					 
					 T=node.P.leftChild;  //left uncle
					 if(T.color==RED) {
						 T.color=BLACK;     //case 1
						 node.P.color=RED;  //case 1
						 RightRotation(node.P); //case 1
						 T=node.P.leftChild;  //case 1
					 }
					 
					 if( T.rightChild.color==BLACK && T.leftChild.color==BLACK) { //CASE 2
						
						 T.color=RED;                      //CASE 2
						 node=node.P;                    //CASE 2
						 
					 }else {
						 if(T.leftChild.color==BLACK) {   //CASE 3
					 
						 T.rightChild.color=BLACK;        //CASE 3
						 T.color=RED;                //CASE 3
						 LeftRotation(T);          //CASE 3
						 T=node.P.leftChild;   //CASE 3
						 
					 }
						 T.color=node.P.color;      //CASE 4
						 node.P.color=BLACK;        //CASE 4
						 T.leftChild.color=BLACK;   //CASE 4
						 RightRotation(node.P);       //CASE 4
						 node=root;
					 }
 
				 }
			 } 
			 node.color=BLACK;
			
		 }
		 
		 public void deleteNode(Node node,String key) {
			 
			 Node R = nullTree;
			    Node x, helpnode;
			    while (node != nullTree) {
			      if (node.element.compareTo(key) == 0) {
			        R = node;
			      }

			      if (node.element.compareTo(key) <= 0) {
			        node = node.rightChild;
			      } else {
			        node = node.leftChild;
			      }
			    }

			    if (R == nullTree) {
			      System.out.println("Not Found");
			      return;
			    }

			    helpnode = R;
			    String yOriginalColor = helpnode.color;
			    if (R.leftChild == nullTree) {
			      x = R.rightChild;
			      EXCHANGE(R, R.rightChild);
			    } else if (R.rightChild == nullTree) {
			      x = R.leftChild;
			      EXCHANGE(R, R.leftChild);
			    } else {
			    	helpnode = MinimumValue(R.rightChild);
			      yOriginalColor = helpnode.color;
			      x = helpnode.rightChild;
			      if (helpnode.P == R) {
			        x.P = helpnode;
			      } else {
			    	  EXCHANGE(helpnode, helpnode.rightChild);
			    	  helpnode.rightChild = R.rightChild;
			    	  helpnode.rightChild.P = helpnode;
			      }

			      EXCHANGE(R, helpnode);
			      helpnode.leftChild = R.leftChild;
			      helpnode.leftChild.P = helpnode;
			      helpnode.color = R.color;
			    }
			    if (yOriginalColor == BLACK) {
			      DeleteCases(x);
			    }
					
		 }
					 
		 	      
///////////////////////////////	    ////////////////
	    void RightRotation(Node n0){
		    Node n1=n0.leftChild;
			n0.leftChild=n1.rightChild;
			if(n1.rightChild!=nullTree) {  ////////////
				n1.rightChild.P=n0;
			}
			n1.P=n0.P;
			if (n0.P == null) {
			     root = n1;
			    } else if (n0 == n0.P.rightChild) {
			      n0.P.rightChild = n1;
			    } else {
			      n0.P.leftChild = n1;
			    }
			    n1.rightChild = n0;
			    n0.P = n1;
		}
		
		void LeftRotation(Node n0){
			Node n1=n0.rightChild;
			n0.rightChild=n1.leftChild;
			if(n1.leftChild!=nullTree) { /////////
				n1.leftChild.P=n0;
			}
			n1.P=n0.P;
			if (n0.P == null) {
			      root = n1; /////////
			    } else if (n0 == n0.P.leftChild) {
			      n0.P.leftChild = n1;
			    } else {
			      n0.P.rightChild = n1;
			    }
			    n1.leftChild = n0;
			    n0.P = n1;
		}
	
//////////////////////////////////////////////////////////////////////////
		 private void fixInsert(Node k) {
			    Node u;
			    while (k.P.color == RED) {
			      if (k.P == k.P.P.rightChild) {
			        u = k.P.P.leftChild;
			        if (u.color == RED) {
			          u.color = BLACK;
			          k.P.color = BLACK;
			          k.P.P.color = RED;  
			          k = k.P.P;
			        } else {
			          if (k == k.P.leftChild) {
			            k = k.P;
			            RightRotation(k); 
			          }
			          k.P.color =BLACK;
			          k.P.P.color = RED;
			          LeftRotation(k.P.P);
			        }
			      } else {
			        u = k.P.P.rightChild;

			        if (u.color == RED) {
			          u.color = BLACK;
			          k.P.color = BLACK;
			          k.P.P.color = RED;
			          k = k.P.P;
			        } else {
			          if (k == k.P.rightChild) {
			            k = k.P;
			            LeftRotation(k);
			          }
			          k.P.color = BLACK;
			          k.P.P.color = RED;
			          RightRotation(k.P.P);
			        }
			      }
			      if (k == root) {
			        break;
			      }
			    }
			    root.color = BLACK;
			  }
		
		 
		 public void insert(String key) {
			    Node node = new Node();
			    node.P = null;
			    node.element = key;
			    node.leftChild = nullTree;
			    node.rightChild = nullTree;
			    node.color = RED;

			    Node y = null;
			    Node x = root;

			    while (x != nullTree) {
			      y = x;
			      if (node.element.compareTo(x.element) <0 ) {
			        x = x.leftChild;
			      } else {
			        x = x.rightChild;
			      }
			    }

			    node.P = y;
			    if (y == null) {
			      root = node;
			    } else if (node.element.compareTo(y.element)  < 0) {
			      y.leftChild = node;
			    } else {
			      y.rightChild = node;
			    }

			    if (node.P == null) {
			      node.color = BLACK;
			      return;
			    }

			    if (node.P.P == null) {
			      return;
			    }

			    fixInsert(node);
			  }
		

}
