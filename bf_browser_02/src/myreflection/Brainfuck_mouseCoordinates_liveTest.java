package myreflection;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.File;
import java.util.Scanner;

import sun.misc.Regexp;
import sun.misc.RegexpPool;

import com.sun.xml.internal.ws.util.StringUtils;




public class Brainfuck_mouseCoordinates_liveTest {

	
	
	
	public static void main(String[] args) throws Exception {
	
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
//		System.out.println("$<hi>");
//		String ooo=new BrainfuckEngine(30000,50000,"").interpret("+++++++++++++++++++++++++++++[.]");
//		System.out.println("$<"+ooo+">");
		
		for(int a=00000000;a<10000000;a++){
			String octal= Integer.toString(a,8);
//			System.out.println(code);
			String code=octal.replaceAll("0","[");
			code=code.replaceAll("1","]");
			code=code.replaceAll("2","<");
			code=code.replaceAll("3",">");
			code=code.replaceAll("4","+");
			code=code.replaceAll("5","-");
			code=code.replaceAll("6",",");
			code=code.replaceAll("7",".");
//			01234567
//			[]<>+-,.
//			System.out.println("\n>>>"+a+" "+code+"\n");
		if(code.matches("^\\].*")) {
			System.out.println("code (before)= "+code+" a="+a+" octal= "+octal);
			code="<"+code.substring(1);
			a=Integer.parseInt("2"+octal.substring(1),9);
			System.out.println("code (before)= "+code+" a="+a+" octal= "+"2"+octal.substring(1));
//			scan.nextLine();
			//to scan enter
		
			
		}
			
		if (!code.contains("<>") && !code.contains("[]") && !code.contains("-+") && !code.contains("+-") && !code.contains("<>") && !code.contains("><") && !code.startsWith("[")
				&& !code.endsWith(",") && !code.endsWith("+") && !code.endsWith("-")
				
				)
		{
		try{
			PointerInfo inf = MouseInfo.getPointerInfo();
			int xi = inf.getLocation().x;
			int yi = inf.getLocation().y;
//			char[] x=Integer.toString(xi).toCharArray();
//			char[] y=Integer.toString(yi).toCharArray();
			String x=Integer.toString(xi);
			String y=Integer.toString(yi);
			
//			System.out.print("[");
//			for(char o : x){
//				System.out.print(o+",");
//			}
//			System.out.print("]\n ");
//			
//			char[]
//			System.out.println(x+" "+y);
		
		String out=new BrainfuckEngine(30000,5000,x+" "+y).interpret(code);
		if (!out.isEmpty() && !out.matches("^[\\s]+$")){
//		System.out.println("\n>>>"+x+" "+y+" "+code+"\n");
		System.out.println(code+"<"+out+">"+a);}
		}
		catch(Exception e){};
		}
////		System.out.println("$<hi>");
//		String ooo=new BrainfuckEngine(30000,1000,"").interpret("++++++++++++++++++++++++++++++++++++++++++++[.][+.]");
//		System.out.println("$<"+ooo+">");
		
		}
	}

}

