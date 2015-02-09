import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileIOtest {

	public static void main(String[] args) {
		
//		loc.replaceAll("\", "\\")
//		File f=new File(".\\number");
		String str="C:\\cygwin64\\home\\sal\\BF_CLARK_PROJECT\\Alex";
		str+="\\";
		str+="o_bfout";
		File f=new File(str);
//		File f=new File(".\\loc");
		Scanner s=null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		String st=null;
		if(s.hasNextLine()){
			st=s.nextLine();
			System.out.println("<"+st+">");
		}
		s.close();
		f=new File(st+"o_bfout");
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		if(s.hasNextLine()){
			st=s.nextLine();
			System.out.println("<"+st+">");
		}
		

	}

}
