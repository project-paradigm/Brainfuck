package myreflection;

import com.sun.java.accessibility.util.Translator;

//import com.sun.java.util.jar.pack.Instruction.Switch;

public class Tree_test {

	public static void main(String[] args) {
		Logic_tree t=new Logic_tree();
		
//		01234567
//		[]<>+-,.
		t.populateCenterFile(".\\src\\myreflection\\treeSource.groovy", ";;", ";;;");
//		t.setCurrent("s.startsWith('<')", "s=s.replaceFirst('<','>')");
//		t.addCenter("s.startsWith('<')", "s=s.replaceFirst('<','>')");
//		t.addCenter("s.contains('<>')", "s=s.replaceAll('<>','++')");
//		t.addCenter("s.contains('><')", "s=s.replaceAll('><','>+')");
//		t.addCenter("s.contains('+-')", "s=s.replaceAll('[+]-','+,')");
//		t.addCenter("s.contains('-+')", "s=s.replaceAll('-[+]','--')");
//		t.addCenter("s.contains('[]')", "s=s.replaceAll('[\\\\[][\\\\]]','<+')");
//		t.addCenter("( (!s.endsWith(']') && !s.contains('.')) && !s.endsWith('.'))", 
//				"int last=s.charAt(s.length()-1);"
//				+ "key='[<>+-,';"
//				+ "ans=']>+-,.';"
//				+ "i=key.indexOf(last);"
//				+ "s=s.subSequence(0, s.length()-1)+ans.charAt(i);");
		
		
//		still need parenthesis balancing!!!
////        fix the short length']..' problem
		
//		t.addCenter("s.contains('[]')", "s=s.replaceAll('[\\\\[][\\\\]]','<+')");
//		aghhh!! this is suuuper slow possibly because its being interperted as groovy...
		t.fix("<>+-[");
		t.fix("<>+-");
		t.fix("<>+-<><>");
		t.fix("<><><><><><><><><><><><><><><><><><><><><>+-<]]");
		t.fix("<>+-<[[");
		
		t.fix("<>+-[");
		t.fix("<>+-");
		t.fix("<>+-<><>");
		t.fix("<><><><><><><><><><><><><><><><><><><><><>+-<]]");
		t.fix("<>+-[");
		t.fix("<>+-");
		t.fix("<>+-<><>");
		t.fix("<><><><><><><><><><><><><><><><><><><><><>+-<]]");
		t.fix("<>+-<[[");
		t.fix("<>+-<[[");
		t.fix("<>+-[");
		t.fix("<>+-");
		t.fix("<>+-<><>");
		t.fix("<><><><><><><><><><><><><><><><><><><><><>+-<]]");
		t.fix("<>+-<[[");
		
//		t.reset();
//		t.print(t.current.yes.action);
//		String s="[]";
//		String te="32q1";
//		te.indexOf(t)
		
//		s.subSequence(0, s.length()-1)
//		System.out.println(s.charAt(s.length()-1));
//		if(s.contains("+-")) print("hi");
//		System.out.println(s.replaceAll("[\\[][\\]]", "<+"));
		
	}

}
