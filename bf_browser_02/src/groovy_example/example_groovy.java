package groovy_example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class example_groovy {
	
	static Binding binding = new Binding();
	static GroovyShell shell = new GroovyShell(binding);
	String s="";
	String out="";
	
//	Check the 20Q game how the first questions was initialized
//	can I avoid doing something like setFrirst or doing a check each time??
	
	public static void main(String[] args){
	
			shell.evaluate("a=Eval.me('2 + 2');println(a);");
			int i=(int) shell.getVariable("a");
			System.out.println("java sees that a is:"+i);
//		boolean a=(boolean) shell.evaluate(current.condition);
////					
//			shell.evaluate(current.action);
//			out=(String) shell.getVariable("s");
//		

	}		
	void print(Object o){
		System.out.println(o);
	}

}
