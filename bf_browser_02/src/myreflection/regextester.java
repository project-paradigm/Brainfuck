package myreflection;

public class regextester {


public static void main(String[] args) {
	
//	System.out.print("ds ><> 2j".matches("(^.*<(?!/</>).*>.*$)"));
//	System.out.print("ab".matches(".*(^(?!a)*b.*$)"));
//	System.out.print("+<".matches("(^[^>]*<.*$)|(^\\].*)|(.*<>.*)|(.*><.*)|(.*\\+-.*)|(.*-\\+.*)|(.*\\[\\].*)"));
//	System.out.print("+[[".matches("(^[^\\[]*\\].*$)"));//ok for ][ error
	System.out.print("+[".matches("((^.*[\\[]+[^\\]]+$)|(^.*[\\[]+$))")); // [[ error
//	System.out.print("d>d<d>".matches("(^[^>]*<.*$)"));
//	System.out.print("+".matches("(^\\].*)|(^[^>]*<.*$)|(.*<>.*)|(.*><.*)|(.*\\+-.*)|(.*-\\+.*)|(.*\\[\\].*)"));
//|(^.*<(?!>).*$)
//	System.out.print("AS12ASD".indexOf("12"));
	
	}

}
