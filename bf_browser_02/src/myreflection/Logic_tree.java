package myreflection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class Logic_tree {
	
	Logic_node root=new Logic_node();// first one a sentinel node?
	Logic_node current=root;
	Binding binding = new Binding();
	GroovyShell shell = new GroovyShell(binding);
	String s="";
	String out="";
	
//	Check the 20Q game how the first questions was initialized
//	can I avoid doing something like setFrirst or doing a check each time??
	
	Logic_tree(){}
	void setCurrent(String test,String action){
		current.condition=test;
		current.action=action;
//		current.property=-1;
	}
	
	void addYes(String test,String action){
		current.yes=new Logic_node();
		current=current.yes;
		current.condition=test;
		current.action=action;
		current.property=1;
	}
	
	void addNo(String test,String action){
		
		current.no=new Logic_node();
		current=current.no;
		current.condition=test;
		current.action=action;
		current.property=2;
	}
	
	void addCenter(String test,String action){
		
		current.center=new Logic_node();
		current=current.center;
		current.condition=test;
		current.action=action;
		current.property=3;
	}
	
	void populateCenterFile(String file,String ifSep,String endNode){
		FileReader f = null;
		try {
			f = new FileReader(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader br=new BufferedReader(f);
//		print("a;;".endsWith(";;;"));
		
		String line="";
		String code="";
		int temp=0;
		try {
			while((line=br.readLine())!=null){
			
				
//				print((temp++)+" "+line);
//				print(line);
					
					code+=line.replaceAll("[^\\S]{2,}", "");
					if(code.endsWith(endNode)){
//						code+="+";
//						print(code);
//						print(code.substring(0,code.indexOf(ifSep)));
//						print(code.substring(code.indexOf(ifSep)+2,code.length()-2));
						String condition=code.substring(0,code.indexOf(ifSep));
						if(!condition.startsWith("//")) 
							addCenter(condition,code.substring(code.indexOf(ifSep)+2,code.length()-2));
						code="";
					}
//					print(line);
				
				
				
//				if (line!=null) if(!code.endsWith(endNode) && line.endsWith(endNode)) code+=line;
//				line=br.readLine();
//				print(code);
//				print(code.substring(0,code.indexOf(ifSep)));
//				print(code.substring(code.indexOf(ifSep)+2,code.length()-2));
				
//				addCenter(code.substring(0,code.indexOf(ifSep)),code.substring(code.indexOf(ifSep)+2,code.length()-2));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	void reset(){
		if(root.center!=null) current=root.center;
		else if(root.yes!=null) current=root.yes;
		else if(root.no!=null) current=root.no;
		else print("== empty tree! ==");
		}
	
	void fix(String s){
		reset();
		shell.setVariable("s", s);
		traverse(current);
		print("next good = '"+out+"'");
	}
	
	void traverse(Logic_node main){
		
		// Script var name (string) is "s"
		current=main;
//		shell.setVariable("s", s);
		
//		need indicator if its a center node
//		print(current.action);
		
		if (current.property==3 || current.property==0){
			
			boolean a=(boolean) shell.evaluate(current.condition);
			if(a) shell.evaluate(current.action);
			out=(String) shell.getVariable("s");
//			print("check:"+out);
			if (current.center!=null) traverse(current.center); // do this no matter what..
		
		}
		else print("check:"+out);
		
		//perform test if true go to yes
		
		boolean a=(boolean) shell.evaluate(current.condition);
//		print("if "+current.condition+" = "+a);
//		print(a);
		
		if (a){
			
			shell.evaluate(current.action);
			out=(String) shell.getVariable("s");
			
			if(main.yes!=null) traverse(main.yes);
			else if (current.center!=null) traverse(current.center);
		}
			
			
		//else go to no...
		if (!a ) {
			if(main.no!=null) traverse(main.no);
			else if (current.center!=null) traverse(current.center);
		}
		
		
	}
	
	void print(Object o){
		System.out.println(o);
	}

}
