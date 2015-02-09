import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

import sun.org.mozilla.javascript.internal.CompilerEnvirons; 
import sun.org.mozilla.javascript.internal.Context;
import sun.org.mozilla.javascript.internal.Evaluator;
import sun.org.mozilla.javascript.internal.Function;
import sun.org.mozilla.javascript.internal.RhinoException;
import sun.org.mozilla.javascript.internal.Script;
import sun.org.mozilla.javascript.internal.Scriptable;
import sun.org.mozilla.javascript.internal.ast.NewExpression;
import sun.org.mozilla.javascript.internal.ast.ScriptNode;


public class trashclass4 {
	
//	Process process = new ProcessBuilder("C:\\PathToExe\\MyExe.exe","param1","param2").start();
	public static void main(String[] args) {

		
//		PicoIsAwesomeEdit p=new PicoIsAwesomeEdit();
//	p.newArray();
//		--------------
//	p.startArray();
//	p.add(2);
//	p.add(3);
//	p.add(45);
//	p.endArray();
//	
//	p.startArray();
//	p.add(2);
//	p.add(3);
//	p.add(45);
//	p.endArray();
//	
//	p.startArray();
//	p.add(4);
//	p.add(3);
//	p.add(45);
//	p.endArray();
	
//	p.startArray();
////	p.startArray();
//	p.newArray();
//	p.show();
//	
//	System.out.println(p.words);
//	p.generateLists();
////		/-------------
//	p.printAll();
		Scanner fileR=null;
		File main=new File(".\\loc");
		String dir=null;
		try {
			fileR = new Scanner(main);
			if(fileR.hasNextLine()) dir=fileR.nextLine();

		}catch(Exception e){
			print("sorry couldn't read loc file");
		}

File file=new File(dir+"o_bfout");
//print(file);
view v=new view(0,100,file);
//v.printView(1,1000);
//v.printUpdateCells();

//System.out.println(d.get(0, 0));
//d.printArray(0);
//	d.printAll();
		
		
//		Binding binding = new Binding();
//		GroovyShell shell = new GroovyShell(binding);
//		Object value = shell.evaluate("for (x=0; x<5; x++){println "Hello"}; return x");
		
//		GroovyShell shell = new GroovyShell();
//		shell.evaluate("println 'Hello from Groovy script!'");
		
	}
static void print(Object o){
	System.out.println(o);
}
	
}
