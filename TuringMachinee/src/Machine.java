import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */
/**
 * @author engyIbrahim
 *
 */

public class Machine {
    static LinkedList<transition> arr; static StringBuilder tapee=new StringBuilder();
    static public class transition{//contain all states
    	char currentstate;
		char currentchar;
		char nextstate;
		char nextchar;
		char move;
		public transition(char currentchar,char currentstate,char nextstate,char nextchar,char move)
		{   this.currentstate=currentstate;
		     this.currentchar=currentchar;
		   	this.nextstate=nextstate;
		   this. nextchar=nextchar;
			this.move=move;
			
		}
    	
    }
 public static void main(String[] args) {
		// TODO Auto-generated method stub
	  /* 
2
<-a-b-#
0 a 1 a r
0 b 0 b r
0 # 0 # y
1 a 0 a r
1 b 1 b r
1 # 1 # n
aabaab
0
	 */
	 	
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Number of states");
		int states=scan.nextInt();
		System.out.println("Enter alphabets");
		String alpha=scan.next();
		
		String ay7aga="";
		for(int i=0;i<alpha.length();i++)
		{
			if(alpha.charAt(i)!='-'&&alpha.charAt(i)!='<')
				ay7aga+=alpha.charAt(i);
		}
		
		
		arr=new LinkedList();
		
		System.out.println("Enter transitions");
		int n=ay7aga.length()*states;
		while(n-->0)
		{  
			char currentstate=scan.next().charAt(0);
			char currentchar=scan.next().charAt(0);
			char nextstate=scan.next().charAt(0);
			char nextchar=scan.next().charAt(0); 
			char move=scan.next().charAt(0) ;
			arr.add(new transition(currentchar,currentstate,nextstate,nextchar,move));
			
			
		}
		System.out.print("Enter input Tape");
	      String tape="<"+scan.next()+"#";
		tapee=new StringBuilder(tape);
		System.out.print("Enter postion of the head");
		int position=scan.nextInt();
		position++;
		char currentone='0';
		 
		for(;;) {
			char c=tape.charAt(position);
			
			int k=0;
			for(int i=0;i<arr.size();i++)
			{
				if(arr.get(i).currentstate==currentone&&arr.get(i).currentchar==c)
				{
				  k=i;	
				  break;
				}
			}
			
			  char movement=arr.get(k).move;
			  currentone=arr.get(k).nextstate;
			  tapee.setCharAt(position, arr.get(k).nextchar);
			  if(tapee.charAt(position)=='<')
			  {
				  System.out.print("you reach begin of tape ");
				  
			  }
			  if(movement=='l') {
				  position=  position-1;
				  
				  }
			  else if(movement=='r')
				  position=position+1;
			  else if(movement=='y')
			  {   
				  System.out.println("accept..................>");
				  System.out.println("Bye");
				  break;
			  }
			  else 
			  {   
				  System.out.println("reject....................>");
				  System.out.println("Bye");
				  break;
			  }
				  
			  
			
			
		}
	    
		System.out.println(tape);

	}

}
