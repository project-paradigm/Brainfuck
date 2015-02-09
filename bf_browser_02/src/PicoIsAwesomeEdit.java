import java.util.*;
/*
 * example of use:
 * p=new PicoIsAwesomeEdit();
 * p.startArray();
//		p.add(3);
//		p.add(4);
//		p.endArray();
//		p.startArray();
//		p.add(3);
//		p.add(4);
//		p.endArray();
//		p.startArray();
//		p.add(1);
//		p.add(34);
//		p.endArray();
//		p.startArray();
//		p.add(132);
//		p.add(34);
//		p.endArray();
//		p.startArray();
//		p.add(2);
//		p.add(3);
//		p.endArray();
 *  p.generateList();
 *  p.next();
 *  if(p.stop==0) System.out.println(p.getString()+","+p.getCurrentFeq());
 *  p.next();
 *  if(p.stop==0) System.out.println(p.getString()+","+p.getCurrentFeq());
 *  
 */



public class PicoIsAwesomeEdit {
       
	
		
		
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
        ArrayList<ArrayList<Integer>> words;
        Map<ArrayList<Integer>, Integer> map; // mapping of arrays to frequencies
        Set<ArrayList<Integer>> sortedSet; // set of keys in map sorted by value
        ArrayList<Integer> current; // new ArrayList<Integer>();
       
        PicoIsAwesomeEdit(){
                // initalise fields
                i = -1;
//                valueToFill=-1;
                values = 100;
                words = new ArrayList<ArrayList<Integer>>();
                map = new HashMap<ArrayList<Integer>, Integer>();
                sortedSet = new TreeSet<ArrayList<Integer>>(new ValueComprtr(map));
        }
       
        void add(int val){
                current.add(val);
        }
       
        // deletes everything
        void startArray(){
                current = new ArrayList<Integer>();
        }
       
        void endArray(){
                if(!current.isEmpty()) words.add(new ArrayList<Integer>(current));
        }
       
        void countFreq(){
                for (ArrayList<Integer> a : words) {
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
                for (ArrayList<Integer> a : sortedSet) {
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
                for (ArrayList<Integer> a : sortedSet) {
                	m=a.size();
                	if(m>max) max=m;
                }
                
                cols=sortedSet.size();
                rows=max;
//                System.out.println("IM IN GEN LIST! ["+cols+", "+rows+"]");
                intList = new int[cols][rows];
                freqList=new int[cols];
                stringList=new String[cols];
                
                for (ArrayList<Integer> a : sortedSet) {
//                        System.out.println(a);
                		i=0;
                		string = "[";
//                		list[ii]=new int[]=[NAN];
//                		Arrays.fill(intList[ii],valueToFill);
                		freqList[ii]=map.get(a);
                        for(Integer b : a){
                        	intList[ii][i] = b;
                        	string+= " "+b;
                                i += 1;
                        }
                        string+="]";
                        stringList[ii]=string;
                        ii += 1;
                }
              
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
 
class ValueComprtr implements Comparator<ArrayList<Integer>> {
       
        Map<ArrayList<Integer>, Integer> base;
       
        public ValueComprtr(Map<ArrayList<Integer>, Integer> base) {
                this.base = base;
        }
       
        // Note: this comparator imposes orderings that are inconsistent with equals.
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if (base.get(a) >= base.get(b)) {
                        return -1;
                } else {
                        return 1;
                } // returning 0 would merge keys
        }
}