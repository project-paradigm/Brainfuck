package myreflection;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.groovy.control.CompilationFailedException;

public class reflection2 {
    
public static void main(final String[] args) {

	// call groovy expressions from Java code
	Binding binding = new Binding();
//	binding.setVariable("foo", new Integer(2));
	GroovyShell shell = new GroovyShell(binding);
//	Scanner s = new Scanner(System.in);
	
	shell.setVariable("s", ">>],,,");//+<]+-
	Boolean a=null;
	a= (Boolean) shell.evaluate("s.startsWith('+')");//"s.contains('+')"
	System.out.println("a= "+a);
	
	
	
	
//	if(s.startsWith('<')) return 1 else return 0"
//	System.out.print("a= "+a);
//	shell.evaluate("s=s.replaceAll('[+]-','')");
	
//	a=(Boolean) shell.evaluate("return (s.indexOf('<') > s.indexOf('>'))");
	// if > is before < because it should be...
	
//	System.out.println("a= "+a);

	
//	String t="int lst=s.charAt(s.length()-1);"
//			+"println('lst='+lst);"
//			+"key='[<>+-,';ans=']>+-.';"
//			+ "i=key.indexOf(lst);"
//			+ "println(i)";
	
//	REMINDER:? maybe not...
//		use either (/" with //) or use (' ////) for when using a double escapes
	// Also: start using text files to reference the string... it is getting supper annoying
//	   THEn: make it so each line is an  question \n action format for a node in the logic tree
//				ex: |s.startsWith("<")
//					|s=s.replaceFirst('<','>')"	
//					|
	
	//Caution... original working java source code has been improved but this string is not updated, try to work on
//	the file action rather than trying to hand create the string again...
//String t="def repeat(String str, int number){ tmp='';number.times {tmp+=str};return tmp;};"
//		+ "if(s.matches('(^[^\\\\[]*\\\\].*$)')) {"
//			+ "loc=s.indexOf(']')+1;"
//			+ "if((s.length()-loc)<=2) {"
//				+ "int last_bit=s.length()-(loc-1);"
//				+"print(last_bit);"
//				+"if(last_bit==1) s=s.substring(0,loc-1)+'<';"
//				+"if(last_bit==2) s=s.substring(0,loc-1)+'<<';"
//				+"if(last_bit==3) s=s.substring(0,loc-1)+'<<<';"
//			+ "};"
//		
//		+ "if((s.length()-loc)>2){"
//			+ "int parenths=(int)((s.length()-loc-1)/2);"
//			+"int insides=s.length()-(2*parenths);" 
//			+"int dot=s.indexOf('.');"
//			+"int arrow=s.indexOf('>');"
//			+ "if((dot<loc) && dot!=-1){"
//				+ "s=s.substring(0,loc-1)+'>'+repeat('x', s.length()-(loc-1));"
//				+ "if((arrow<loc) && arrow!=-1){"
//					+ "s=s.substring(0,max(loc-1,0))+'<'+repeat('x', s.length()-max(loc-1,0));"	
//					+"}"
//				+"};"
//					+"\nprint('side parenths = '+parenths);"
//					+ "inS='';"
//					+"if (insides==1) inS='.';"
//						+"else {"
//							+"if(s.indexOf('.')<loc){"
//								+"inS='>>';"
//							+"}"
//							+"else{"
//							+"	inS='>.';"
//							+"}"
//						 +"};"
//						+"s=s.substring(0,loc)+repeat('[', parenths)+inS+repeat(']', parenths);"
//						+"print('*'+s);"
//					+"}};";
						
//	FileReader r=new FileReader(File)
	try {
		shell.evaluate(new File(".\\src\\myreflection\\test_source.txt"));
	} catch (CompilationFailedException | IOException e) {
		e.printStackTrace();
	}
	
//	if (a) shell.evaluate("s=s.replaceFirst('[]]','>')");
//	else shell.evaluate("s=s.replaceFirst('[]]','<')");
//	shell.evaluate("println '\\n'+s");
	
//	shell.evaluate("println y");
	
//	String test="hi";
//	test.replaceAll("hi","bte");
//	
//	String run=null;
//	while (1==1)
//	{
//		System.out.print("\n>>");
//		System.out.flush();
//		run=s.nextLine();
//		try{
//		shell.evaluate(run);
//		}
//		catch(Exception e){
//			System.out.println(e);
//			System.out.flush();
//		}
//	}
	
	
	
//	Object value = shell.evaluate("println 'Hello World!'; x = 123; return foo * 10");
	
//	shell.evaluate("x = 23");
//	shell.evaluate("for (int i=0; i < 10; i++){ println i+x}");
//	while (1){ println i+x}
	
//	assert value.equals(new Integer(20));
//	assert binding.getVariable("x").equals(new Integer(123));
	
	
}

}