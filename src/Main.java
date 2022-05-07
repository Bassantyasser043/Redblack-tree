import java.util.Scanner;


public class Main {
	 void analysis() {
		 
	 }
	 public static void main(String[] args) {
		 analysis analy=new analysis();
	        Scanner input=new Scanner(System.in);
	        boolean temp=false;
	        String operation;
	        RedBlacktree nodeinsert=new RedBlacktree();
	       
	        while(!temp) {
	            System.out.println("Enter your desired operation: (insert - delete - isEmpty - print - clear - getRoot - contains - search) or (exit) to end the program: ");
	            operation=input.next();
	            switch(operation) {
	                case "insert":
	                    System.out.println("Enter the element: ");
	                    String item=input.next();
	                   nodeinsert.insert(item);
	                    break;
	                case "isEmpty":
	                    System.out.println(nodeinsert.isEmpty());
	                    break;
	                case "clear":
	                   nodeinsert.clear();
	                    break;
	                case "print":
	                    nodeinsert.printTree();
	                    break;
	                case "delete":
	                	 System.out.println("Enter the element: ");
	                	 String itemdeleted=input.next();
		                    nodeinsert.deleteNode(nodeinsert.root,itemdeleted);

	                    break;
	                case "contains":
	                    System.out.println("Please the required item: ");
	                    String foundingitem=input.next();
	                    System.out.println("found: "+nodeinsert.contains(foundingitem));

	                    break;
	                case "search":
	                    System.out.println("Please the required item: ");
	                    String it=input.next();
	                   nodeinsert.search(it);
	                    break;
	                case "getRoot":
	                    nodeinsert.getRoot();
	                    break;
	                case"exit":
	                    System.exit(0);
	                 
	                case "analysis":
	                	int num=input.nextInt();
						  long startTime = System.currentTimeMillis();
						
						for(int i = 0; i < num ; i++){
							String s=analy.randomString();
							 nodeinsert.insert(s);
		
						}
						long endTime = System.currentTimeMillis();
					      System.out.println("Total execution time: " + (endTime-startTime) + "ms/insertion");
					      
					      startTime = System.currentTimeMillis();
					      for(int i = 0; i < num ; i++){
							String s=analy.randomString();
							// System.out.println(analy.randomString());
							nodeinsert.deleteNode( nodeinsert.root, s);

						}  endTime = System.currentTimeMillis();
					      System.out.println("Total execution time: " + (endTime-startTime) + "ms/deletion");
						
						break;

	                default:
	                    System.out.println("It IS Not Available. Please Enter The Right Operation: ");
	                    break;

	            }
	        }

	 }
}
