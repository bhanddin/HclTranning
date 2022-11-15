package com.MediatorPatterns;


import java.util.Scanner;

public class MediatorPatternDemo {  
    
    public static void main(String args[])  
    {  
    	
    	Scanner Scan= new Scanner(System.in);
          
          ApnaChatRoom chat = new ApnaChatRoomImpl();  
          User1 u1=new User1(chat);  
            
          User2 u2=new User2(chat); 
          

          System.out.println("Enter bye to close your chat");
          
          System.out.println("first user name");
          String a= Scan.nextLine();
          System.out.println("Second user name");
          String b= Scan.nextLine();
          boolean y=true;
          while (y) {
        	  u1.setname(a);
        	  System.out.println(b+ " please enter message for "+ a);
        	  String mesg1=Scan.nextLine();
        	  u1.sendMsg(mesg1);
        	  if(mesg1.equals("bye") ) {
        		  System.out.println(b+ " say bye  \n Ending chat");
        		  y=false;
        		  break;
        		  
        	  }
        	  
        	  u2.setname(b);
        	  System.out.println(a+ " please enter message for "+ b);
        	  String mesg2=Scan.nextLine();
        	  u2.sendMsg(mesg2);
        	  
        	  if(mesg2.equals("bye")) {
        		  System.out.println(a+ " say bye  \n Ending chat");
        		  y=false;
        		  
        	  }
        	  
          }
         // u1.setname("Ashwani Rajput");  
         // u1.sendMsg("Hi Ashwani! how are you?"); 
         // u2.setname("Soono Jaiswal");  
        //  u2.sendMsg("I am Fine ! You tell?");   
          Scan.close();
    }  
  
}// End of the MediatorPatternDemo class.  

