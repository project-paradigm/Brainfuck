package myreflection;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.ws.api.server.Module;

public class OneLineBf_test {

	public static void main(String[] args) {

		String s=null;
		int i=0;
		try {					// cells, timeout, input       actual code
//			s=new BrainfuckEngine(300,300,"1234567").interpret("+[<+.]");
//			s=new BrainfuckEngine(300,255,2050,"1234567").interpret("-.[-.]+.[+.]");
			s=new BrainfuckEngine(300,255,2050,"134567").interpret(">>+,[[.]]");
//			i=Math.abs(-9)%4;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.print(s);

	}

}
