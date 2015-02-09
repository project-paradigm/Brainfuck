import java.util.*;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.OutputUtil;



public class PicoIsAwesomewSource {
       
	
		
		
        int i;
        int[][] intList;//items
        int[] freqList;//frequency of occurrence
        String[] stringList;
        int values;
//        private int rows=0;
//        private int cols=0;
        int rows=0;
        int cols=0;
//        int valueToFill;
        int stop=0;	//value to indicate if last change of index was successful or not
        //if stop=1 then something you went to an out of bounds index
        String string;
        int frequency;
        ArrayList<ArrayList<SourcenResults>> words;
        Map<ArrayList<SourcenResults>, Integer> map; // mapping of arrays to frequencies
        Set<ArrayList<SourcenResults>> sortedSet; // set of keys in map sorted by value
        SourcenResults current; // new ArrayList<Integer>(); 
        								   //current=node to be sorted by frequency
        ArrayList<Integer> currentOut=null;
       
        PicoIsAwesomewSource(){
                // initalise fields
                i = -1;
//                valueToFill=-1;
                values = 100;
                words = new ArrayList<ArrayList<SourcenResults>>();
                map = new HashMap<ArrayList<SourcenResults>, Integer>();
                sortedSet = new TreeSet<ArrayList<SourcenResults>>(new ValueComparator(map));
                
        }
       
        void add(int val){
        	currentOut.add(val);
                
        }
       
        // deletes everything
        void startArray(String sourceCode){
                current = new SourcenResults();
                current.sources.add(sourceCode);
                currentOut=current.output;
                
        }
        
       
        void endArray(){
        	try {throw new Exception("finish this part!");} catch (Exception e) {}
//                if(!currentOut.isEmpty()) words.add(new ArrayList<SourcenResults>(current));
        }
       
        void countFreq(){
        	try {throw new Exception("finish this part!");} catch (Exception e) {}
                for (ArrayList<SourcenResults> a : words) {
                        if (!map.containsKey(a)) {
                                map.put(a, 1);
                        } else {
                                map.put(a, map.get(a) + 1);
                        }
                }
                sortedSet.addAll(map.keySet());
        }
       
        // prints the keys and values in map in order sorted  by value
        //need to first call countFreq() for this to work the first time!
        void printAll(){
                for (ArrayList<SourcenResults> a : sortedSet) {
                        System.out.print(a + " : " +map.get(a)+"\n");
                }
        }
       
        void show(){
                countFreq();
                printAll();
        }
        
        int getFeq(){
        		return (frequency);
        }
        String getString(){
    		return (string);
        }
       
        
        void generateLists(){
                int i = 0;
                int ii = 0;
                countFreq();
                int max=0;
                int m=0;
//                int valueToFill=-1;
//                sortedSet.addAll(map.keySet());//please don't add this it just doubles the size
                for (ArrayList<SourcenResults> a : sortedSet) {
                	m=a.size();
                	if(m>max) max=m;
                }
                
                cols=sortedSet.size();
                rows=max;
//                System.out.println("IM IN GEN LIST! ["+cols+", "+rows+"]");
                intList = new int[cols][rows];
                freqList=new int[cols];
                stringList=new String[cols];
                try {throw new Exception("finish this part!");} catch (Exception e) {}
//                for (ArrayList<Integer> a : sortedSet) {
////                        System.out.println(a);
//                		i=0;
//                		string = "[";
////                		list[ii]=new int[]=[NAN];
////                		Arrays.fill(intList[ii],valueToFill);
//                		freqList[ii]=map.get(a);
//                        for(Integer b : a){
//                        	intList[ii][i] = b;
//                        	string+= " "+b;
//                                i += 1;
//                        }
//                        string+="]";
//                        stringList[ii]=string;
//                        ii += 1;
//                }
              
        }
       
        
        //changes String and frequency
        int next(){
        	 if ((i+1)<intList.length){
        		 i++;
        		 frequency=freqList[i];
        		 string=stringList[i];
        		 stop=0;
        		 return 1;
        	 }
        	 stop=1;
        	 return 0;
        }
        int previous(){
       	 if (i>0){
       		 i--;
       		 frequency=freqList[i];
       		 string=stringList[i];
       		 stop=0;
       		 return 1;
       	 }
       	 stop=1;
       	 return 0;
       }
        
       int goto_i(int val){
        	
          	 if ((val>=0) && (val<intList.length)){
          		 i=val;
          		 frequency=freqList[i];
          		 string=stringList[i];
          		 stop=0;
          		 return 1;
          	 }
          	stop=1;
          	return 0;
       }
        
        
        
//                string = "[";
//                updateFreq();
////                System.out.println("[ ");
//                if ((i+1)<intList.length){
//                        i += 1;
//                        for(int o = 0; o < intList[i].length; o++){
//                                int t = intList[i][o];
//                                if(t==valueToFill){string+="]";i+=1;return;}//return s;
//                                string+= " "+t;
//                                
////                                System.out.println(" "+t);
//                        }
//                }
////                else stop=1;
//                string+="]";
////                System.out.println(s);
//                i+=1;
//                return;//return s;
//        }
}
 
class ValueComparator implements Comparator<ArrayList<SourcenResults>>{
       //Comparator<ArrayList<Integer>>,  
        Map<ArrayList<SourcenResults>, Integer> base;
       
        public ValueComparator(Map<ArrayList<SourcenResults>, Integer> base) {
                this.base = base;
        }
       
        // Note: this comparator imposes orderings that are inconsistent with equals.
        public int compare(ArrayList<SourcenResults> a, ArrayList<SourcenResults> b) {
                if (base.get(a) >= base.get(b)) {
                        return -1;
                } else {
                        return 1;
                } // returning 0 would merge keys
        }

}
		