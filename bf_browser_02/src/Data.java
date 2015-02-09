import java.util.ArrayList;
import java.util.List;


public class Data {

//	ArrayList <ArrayList<Integer>> list = new ArrayList <ArrayList<Integer>>();
	int[][] list=null;
	int colset=0;
	int rowset=0;
	int col=0;
	int row=0;
	
	Data(int colset,int rowset){
		this.colset=colset;this.rowset=rowset;
		list=new int[colset][rowset];
	}
	void printCell(int col,int row){
//		return list[col][row];
		System.out.println(list[col][row]);
		
	}
	
	void printArray(int col){
//		return list[col];
		System.out.print("[");
		for(int l=0;l<row;l++){
			System.out.print(" "+list[l]);
			
		}
		System.out.println(" ]");
	}
	void printAll(){
		for(int i=0;i<col;i++){
		System.out.print("[");
		for(int l: list[i]){
			System.out.print(" "+l);
			
		}
		System.out.println(" ]");}
	}
	
	void setCell(int val,int col,int row){
		list[col][row]=val;
	}
	
	void addArray(int[] array){
		
		int[] i=isinList(array);
		
		if (i==null) {storeArray(array,++col);}
		//{list[++cols]=array;}
		
		else {System.out.println("already in array!");}
		
	}
	
	private void storeArray(int[] array,int where){
				list[where][0]=array.length;
				for(int i=0;(i<array.length)&&(i<colset);i++){
					list[where][i+1]=array[i];
//					System.arraycopy(array, 0, list[where], 0, array.length);
		}
	}
	
	int[] isinList(int[] array){
		for(int[] l: list){
			if(l.equals(array)) return l;
		}
		return null;
		
	}
}
