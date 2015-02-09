import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTable;

class PicoIsAwesome extends PicoIsAwesomeEdit{}


class view{
	
	String[][] strFile;
	int[] numbFile;			// provides the count of ..?
	String[][] strCurrent;
	Scanner s=null;
	File f=null;
	PicoIsAwesome p=null;
	JTable table;
	int[] freq;
	int lowRange;
	int highRange;
	int length;
	int i;
	int max=0;
	
	//   lowRange and highRange are the count of items to be read in
	//   program will scanner will start from begining of file regardless if lowRange==0
	view(int lowRange,int highRange,File f,JTable table){ 
		length=highRange-lowRange;
		this.lowRange=lowRange;
		this.highRange=highRange;
		this.table=table;
		
		strFile=new String[length][2];
		numbFile=new int[length];
		strFile=new String[length][2];
		freq=new int[length];
		try {
			s=new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("view error!");
//			e.printStackTrace();
		}
		i=0;
		setup();
	}
	
	view(int lowRange,int highRange,File f){
		length=highRange-lowRange;
		this.lowRange=lowRange;
		this.highRange=highRange;
		
		
		strFile=new String[length][2];
		numbFile=new int[length];
		strFile=new String[length][2];
		freq=new int[length];
		try {
			s=new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("view error!");
//			e.printStackTrace();
		}
		i=0;
		setup();
	}
	
	void setup(){
		while(s.hasNextLine()) {
			try{
				numbFile[i]=s.nextInt();
//				String remain=s.next("[\\W]+");//[//.//,//-//+//<//>]+
				strFile[i][0]=s.nextLine();
				strFile[i][1]=s.nextLine();
//				System.out.println("i= "+i);
//				System.out.println("remaining= "+remain+"}");
				System.out.println("int= "+numbFile[i]);
				System.out.println("source="+strFile[i][0]);
				System.out.println("output="+strFile[i][1]+"\n");
				max=i;
				if(s.hasNextLine()) i++;
				}
			catch(Exception e){return;}
			}	
		}
	void print(){
		
		for(int a=0;a<=max;a++){
//			System.out.println("i= "+a);
//			System.out.flush();
			System.out.println(numbFile[a]);
			System.out.println(strFile[a][0]);
			System.out.println(strFile[a][1]);
			
		}
		
	}
	void reset(){
		
		i=0;
	}
	
	//For debugging. low & high are program IDs	
int printView(int low,int high){ 
		
		if((low<0) || (highRange<max)) return 0;
		p=new PicoIsAwesome();
		
		int a=0;
		for(;low>numbFile[a];a++);//set to low
		
		for(;numbFile[a]<high;a++) {
//			System.out.println(a);
//			System.out.println(numbFile[a]);
			
			//////////
			
			String[] numbers=strFile[a][1].split(" ");
			int I=0;
//			System.out.print("[");
			
//			p.startArray(strFile[a][0]);
			p.startArray();
			try{
				for(String i:numbers){
//					System.out.print("("+i+")");
//					System.out.print(" "+i);
					
					if (i.equals("[")==false && i.equals("]")==false){
					I=Integer.parseInt(i);
//					System.out.print(" "+I);
					p.add(I);
					}
				
				}
//				System.out.println(" ]");
				p.endArray();
			}catch(Exception e){
				System.out.println("Something is wrong with the file format!");
			};
			
			/////////
			
		}
		printUpdateCells();
		return 1;
	}
	
	int showView(int low,int high){
		
		if((low<0) || (highRange<max)) return 0;
		p=new PicoIsAwesome();
		
		int a=0;
		for(;low>numbFile[a];a++);//set to low
		
		for(;numbFile[a]<high;a++) {
//			System.out.println(a);
//			System.out.pritln(numbFile[a]);
			
			//////////
			
			String[] numbers=strFile[a][1].split(" ");
			int I=0;
//			System.out.print("[");
//			p.startArray(strFile[a][0]);
			p.startArray();
			try{
				for(String i:numbers){
//					System.out.print("("+i+")");
					
					if (i.equals("[")==false && i.equals("]")==false){
					I=Integer.parseInt(i);
//					System.out.print(" "+I);
					p.add(I);
					}
				
				}
//				System.out.println(" ]");
				p.endArray();
			}catch(Exception e){
				System.out.println("Something is wrong with the file format!");
			};
			
			/////////
			
		}
		updateCells();
		return 1;
	}
	
	void updateCells(){
		
		p.generateLists();//setup lists for export reading
		int y=table.getColumnCount();
		int x=table.getRowCount();
		for(int o=1;o<x;o+=2){
			for(int b=0;b<y;b++){
				p.next();
//				System.out.println(p.stop);
//				if (p.stop==1) return;
				if (p.stop==1) {
					table.setValueAt("",o,b);
					table.setValueAt("",o-1,b);
				}
				
//				System.out.println(p.getFeq());
//				System.out.println(p.getString());
				else{
				table.setValueAt(p.getString(), o,b);
				table.setValueAt(p.getFeq(), o-1,b);} 
			}
		}
	}
	
void printUpdateCells(){
		
		p.generateLists();//setup lists for export reading
//		int y=table.getColumnCount();
//		int x=table.getRowCount();
		int x=10;
		int y=10;
		for(int o=1;o<x;o+=2){
			for(int b=0;b<y;b++){
				p.next();
//				System.out.println(p.stop);
//				if (p.stop==1) return;
				if (p.stop==1) {
//					table.setValueAt("",o,b);
//					table.setValueAt("",o-1,b);
					
				}
				
//				System.out.println(p.getFeq());
//				System.out.println(p.getString());
				else{
//				table.setValueAt(p.getString(), o,b);
//				table.setValueAt(p.getFeq(), o-1,b);} 
				System.out.println(p.getString());
				System.out.println(p.getFeq());
			}
		}
	}
}
}