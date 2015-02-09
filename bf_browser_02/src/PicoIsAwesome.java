//import java.util.*;
//
//public class PicoIsAwesome {
//	
//	int i=-1;
//	int[][] list;
//	int values=2000;
////   public static void main(String[] args) {
//      ArrayList<ArrayList<Integer>> words = new ArrayList<ArrayList<Integer>>();
//      Map<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
//      
//      // sorted map
//      ValueComparator bvc = new ValueComparator(map);
//      Map<ArrayList<Integer>, Integer> sortedMap = new TreeMap<ArrayList<Integer>, Integer>(bvc);
//      ArrayList<Integer> current=null;//new ArrayList<Integer>();
//      
//      PicoIsAwesome(){
//    	  
//      }
//      // add values here
////      ArrayList<Integer> i=new ArrayList<Integer>();
////      i[0]=13;
////      i[1]=12;
////      i[2]=34;
////      i.add(2);
////      i.addAll(Arrays.asList(2,3,4));
////   
////      
////      words.add(new ArrayList<Integer>(i));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
//      
////      countFreq();
////      printAll();
////      };
////      words.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(5, 7, 9)));
////      words.add(new ArrayList<Integer>(Arrays.asList(6, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4, 9, 10)));
////      words.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
//      
//      // count frequencies
//      
//      
//      
//      
//      // print the sorted map
////      for (ArrayList<Integer> a : sortedMap.keySet()) {
////         System.out.print(a + ":");
////         System.out.println(map.get(a));
////      }
//      //System.out.println(sortedMap);
//      void add(int val){
//    	  current.add(val);
//      }
//      
//      void newArray(){
//    	  
////    	if(!current.isEmpty()) {words.add(new ArrayList<Integer>(current));}
////    	if ( (!current.isEmpty()) || (current.isEmpty() && words.isEmpty()) ) {current=new ArrayList<Integer>();}
//    	
//      }
//      
//      void startArray(){
//    //	  if(!current.isEmpty()) 
////    	  if ((current.isEmpty() && words.isEmpty())||(false==current.isEmpty()))  
//    		  current=new ArrayList<Integer>();
////    	  
//      }
//      void endArray(){
//    	  if(!current.isEmpty()) words.add(new ArrayList<Integer>(current));
////    	  
//      }
//      
//      void countFreq(){
//    	  for (ArrayList<Integer> a : words) {
//    	         if (!map.containsKey(a)) {
//    	            map.put(a, 1);
//    	         } else {
//    	            map.put(a, map.get(a) + 1);
//    	         }
//    	      }
//    	  sortedMap.putAll(map);
//      }
//      void printAll(){
//      	// print the sorted map
//    	  
////    	  ArrayList o=sortedMap.keySet[0]<ArrayList>;
//            for (ArrayList<Integer> a : sortedMap.keySet()) {
//               System.out.print(a + " : " +map.get(a)+"\n");
////               System.out.println(map.get(a));
//            }
//        }
//      
//      void show(){
//    	  countFreq();
//    	  printAll();
//      }
//
//      void generateList(){
//    	  int i=0;
//    	  int ii=0;
//    	  System.out.println("IM IN GEN LIST! ["+sortedMap.entrySet().size()+", "+values+"]");
//    	  list=new int[sortedMap.entrySet().size()][values];
//    	  for (ArrayList<Integer> a : sortedMap.keySet()) {
//    		  System.out.println(a);
//    		  for(Integer b:a){
//    			  
//    			  list[ii][i]=b;
//    			  i+=1;
//    			  
//    		  }
//    		  ii+=1;
//    		  
////            System.out.print(a + " : " +map.get(a)+"\n");
//
//    	  }
//      }
//      
//      String getnextAsString(){
//    	  String s="";
//
//    	  if ((i+1)<list.length){
//    		  i+=1;
//    		  for(int o=0;o<list[i].length;o++){
//    			  int t=list[i][o];
//    			  s+=String.valueOf(t);
//    			  System.out.println(t);
//    	  		}
//      		}
//    	  System.out.println(s);
//    	  return s;
//      }
//}
////    	  Iterator<ArrayList<Integer>> inter=sortedMap.keySet().iterator();
////    	  ArrayList<Integer>[] array = map.keySet().toArray(new ArrayList<Integer>[0]);
////    	  ArrayList<Integer>[] array = new map.keySet().toArray();
//    	  
////    	  System.out.print(sortedMap.entrySet());
////    	  sortedMap.indexof(<);
////    	  Map<ArrayList<Integer>, Integer> sortedMap = new TreeMap;
////    	  
////    	  if(inter.hasNext()){
////    		  System.out.println(inter.next());
////    		  }
////    	  else {System.out.println("sorry noting in inter!");}
//    	  
//    	  //    	  for (ArrayList<Integer> a : sortedMap.keySet()) {
////              System.out.print(a + " : " +map.get(a)+"\n");
//////              System.out.println(map.get(a));
////           }
////    	  	return null;
////      }; 
////}
////}
//
//
//
//class ValueComparator implements Comparator<ArrayList<Integer>> {
//
//   Map<ArrayList<Integer>, Integer> base;
//   
//   public ValueComparator(Map<ArrayList<Integer>, Integer> base) {
//       this.base = base;
//   }
//   
//   // Note: this comparator imposes orderings that are inconsistent with equals.    
//   public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
//       if (base.get(a) >= base.get(b)) {
//           return -1;
//       } else {
//           return 1;
//       } // returning 0 would merge keys
//   }
//}