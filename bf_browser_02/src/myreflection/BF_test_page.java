/*
 * this skip code seems to work but is not correct since it skips
 *  too much rather try to use dynamic programming and storage.. to file
 *  7/19/14
 *  ---------------
 *  
 *  ++[>[[[
 *  should turn into
 *  ++[[ ]]
 *  ++[[.]]  <---final goal
 *  ++[>]<. <----not this
 *  
 *  or 
 *  
 *  count number of '[' - ']'
	count if can add parenthesis
	++[[>]]
	++[>.]+ for minimum output requirement..

	warning!!!
	shouldn't convert from ] to [ !

remember:
//			01234567
//			[]<>+-,.

 */

package myreflection;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class BF_test_page {

	public static String repeat(String str, int times){
		   return new String(new char[times]).replace("\0", str);
		}
	static void print(Object o){
		System.out.println(o);
	}
	
	static int min(int a, int b){
		return Math.min(a, b);
	}
	static int max(int a, int b){
		return Math.max(a, b);
	}
//	static int left_p=0;
//	static int right_p=0;
	static int ballance=0;
	static int parenthesisBallance(String a){
		int tempL=0;
		int tempR=0;
		ballance=StringUtils.countMatches(a, "[")-StringUtils.countMatches(a, "]");
		
		
//		ballance=left_p-right_p;
		return ballance;
		
	}
	public static int lastParenthesis(String s) {
		
		return Math.max(s.lastIndexOf('['),s.lastIndexOf(']'));
		
	}
	
	
	//returns position of error
	public static int isBalanced(String s) { //if no '[' or ']' or all is balanced then returns -1
											// else returns the first place where something goes wrong
											
		int A=0;
		int last_good=0;
		int current=0;
		int i=s.indexOf('[');
		if (i>s.indexOf(']') || i==-1){ 
				if (s.indexOf(']')!=-1) i=s.indexOf(']');
				else {return -1;}
		}

		current=i;
		int last = lastParenthesis(s)+1;
		for(;i<last;i++){
			char c=s.charAt(i);
			if(c=='[') {
				A++;
				last_good=current;
				current=i;
				
			}
			if(c==']') {
				A--;
				
				last_good=current;
				current=i;
			}
			
			if(A<0)  {return last_good;} 
			
		}
		
		return -1;// if all is balanced

	}
	
	public static void fix(String code){
		int bal=isBalanced(code);
		int last=lastParenthesis(code);
//		if(bal!=-5 || bal!=5)
//		print(bal);
//		print(last);
//		boolean b;
//		01234567
//		[]<>+-,.
		int loc=0;
		String[] find={"<>", "><", "+-" ,"-+", "[]"};
		String[] replace={"<+[",">>[","+,[","-,[","<[["};
		
		while(code.matches("(^[^\\[]*\\].*$)|((^.*[\\[]+[^\\]]+$)|(^.*[\\[]+$))|(^\\].*)|(^[^>]*<.*$)|(.*<>.*)|(.*><.*)|(.*\\+-.*)|(.*-\\+.*)|(.*\\[\\].*)")==true){
			
			if(code.matches("^\\].*")) { // if starts with ]
				code=repeat("<",code.length());
//				/(^<.*)|(^[^>]*<.*$)|
			}
			
//			if(code.matches("^<.*")) {
//				code=repeat(">",code.length());
//			}
		
			if(code.matches("^[^>]*<.*$")){ //if < is before > 
				
				
				loc=code.indexOf("<");
				code=code.substring(0,max(loc,0))+">"+repeat("[", code.length()-loc-1);
				//min(code.length()-(loc)+2,code.length())
				print("$"+code);
			}
			
			if(code.matches("((^.*[\\[]+[^\\]]+$)|(^.*[\\[]+$))")){//[[ error detection
				
				
				loc=code.indexOf("[");
				code=code.substring(0,max(loc,0))+">"+repeat("<", code.length()-loc-1);//>
				print("#"+code);
			}
			
			if(code.matches("(^[^\\[]*\\].*$)")){//][ : error detection if first ] is before [
				//  for ][ error detection
				
//				print("][ error!");
				loc=code.indexOf("]");
//				String A;
//				print((code.length()-loc));
//				print(loc);
				if((code.length()-loc-1)<2) {
//					print("something");
					int last_bit=code.length()-(loc);
					print(last_bit);
					if(last_bit==1) code=code.substring(0,loc)+"<";
					if(last_bit==2)	code=code.substring(0,loc)+"<<";
//					if(last_bit==3)	code=code.substring(0,loc)+"<<<";
//					print(code);
				}
				
				else if((code.length()-loc)>2){// --]..
				
					int parenths=(int)((code.length()-loc-1)/2);
					int insides=(code.length()-loc)-(2*parenths); 
					int dot=code.indexOf(".");
					int arrow=code.indexOf(">");
					
					if((dot<(loc+1)) && dot!=-1){//if dot is before error parenths
						
						code=code.substring(0,max(loc,0))+">"+repeat("x", code.length()-loc);
						
						if((arrow<(loc+1)) && arrow!=-1){//if right arrow is before error parenths 
							
							//  xxx -odd = 1 [-]  even={xxxx [--]} 2 
							// odd more xxxxx [[-]] even more xxxxxx [[--]]
							//odd xxx xxx x [[[-]]] even xxx xxx xx [[[--]]]
							// pattern need to have [-] then anything extra will start to add to center
							// 		anything even more added will reduce to [], ie: [---] -> [[-]]
							// form : (len-1)/2 = number of parenthesis on each side
							//  2-(len%2)==# of - inside the parenthesis (can only be 1 or 2)
							// option for inside (1)= . < >  (2)= << <. >.
							
//							print("parenths= "+parenths);
//							code=code.substring(0,max(loc,0))+repeat("[", (code.length()-loc)/2);
							code=code.substring(0,max(loc,0))+"<"+repeat("x", code.length()-loc);
						}
						
					}
					print("one side parenths = "+parenths);
					print("insides = "+insides);
					String in="";
					if (insides==1) in=".";
					else {
						if(code.indexOf(".")<loc){
//							print("here$%");
							in=">>";
						}
						else{
							in=">.";
						}
					}
						code=code.substring(0,loc)+repeat("[", parenths)+in+repeat("]", parenths);
					print("*"+code);
				}
				//edit it code here make it symmetrical...
			}
			
			for(int i=0;i<find.length;i++){ // goes through the find and replace streamlined rules...
//				print(find[i]);
				if( (loc=code.indexOf(find[i])) !=-1){
					print(replace[i].substring(0, 2));
				code=code.substring(0,max(loc,0))+replace[i].substring(0, 2)+repeat(replace[i].substring(2), code.length()-loc-2);
//				code=code.replace(find[i],replace[i].subSequence(0, 1))+repeat(replace[i].substring(2), min(code.length()-(loc+1)+2,code.length()));
				print(code);
				}
			}
		}
		
//		System.out.println("regex match: "+code.matches("(^\\].*)|(.*<>.*)|(.*><.*)|(.*\\+-.*)|(.*-\\+.*)|(.*\\[\\].*)"));
		print("\n	"+code);
		
		try {
			System.out.print("	running:: <"+new BrainfuckEngine(30000,5000,"1234567").interpret(code)+">");
		} catch (Exception e) {
			print("<couldn't run program>");
//			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		//notice that ] should not turn into [ but [ could stay [ !!!
//		String code=">>+,[+++";//">>+,]+++" //"++.]...";//"==="+[]>+-"//"+[][[]"
		fix(">>+,[+++");
		fix(">>+,]+++");
		fix("<>+-[");
		fix("<>+-");
		fix("<>+-<><>");
		fix("<><><><><><><><><><><><><><><><><><><><><>+-<]]");
		fix("<>+-<[[");
//						 [>]
		/*      goal ++.>[<]
		 * ++[+[.]]
		 * 
		 */
		//need to try "++[+[..."
		
		//"++]+..."
		
//		print(parenthesisBallance(code));
		
		
	}

}
