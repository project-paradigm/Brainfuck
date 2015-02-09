import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class trashclass2 {

public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setSize(new Dimension(400, 150));
//    final Component component;

    final Object data[][] = { {"10", "20",23}, 
                        {"java", "j2ee",34}, 
                        {"40", "20",345}
                      };
    Object[] columnNames = {"Java", "J2EE","ok"};

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,int columnIndex) {
            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);  

//            System.out.println(renderer.toString());
            
            if(getValueAt(rowIndex, columnIndex).toString().equals("hi") &&
            		getValueAt(rowIndex-1, columnIndex).toString().equals("20")){//getValueAt(rowIndex, 0).toString().equalsIgnoreCase("java")){//this.equals("java")){
            	component.setBackground(Color.RED);
            }
            else{
            	component.setBackground(Color.WHITE);
            }
			return component;
            
        }

    };
//            super.prepareRenderer(renderer, Math.max(1, rowIndex), columnIndex);
            
//            public Component prepareRenderer(TableCellRenderer renderer, int rowIndex2,int columnIndex2) {
//                JComponent component2 = (JComponent) super.prepareRenderer(renderer, rowIndex2, columnIndex2);  
//            
//            if(this.equals("20")){
//            	component0.setBackground(Color.RED);
//            }
//            else {
//            	 component0.setBackground(Color.WHITE);
//            }
            
//    		if(rowIndex==columnIndex) {component.setBackground(Color.RED);}
//			else component.setBackground(Color.WHITE);
            
//			for(int i=1;i<data.length;i++){
//				for(int ii=1;ii<2;ii++){
//				String s=this.getValueAt(i, ii).toString();
//						if(ii==1) {	component.setBackground(Color.RED);}
//						else component.setBackground(Color.WHITE);
////						System.out.println(s);
//						
//						
//			}}
            
            
//            if(getValueAt(rowIndex, 0).toString().equalsIgnoreCase("java")) {
//                component.setBackground(Color.RED);
//            } else if(getValueAt(rowIndex, 1).toString().equalsIgnoreCase("j2ee")){
//                component.setBackground(Color.GREEN);
//            }
            
//            if(getValueAt(rowIndex, 0).toString().equalsIgnoreCase("java") && columnIndex == 0) {
//                component.setBackground(Color.RED);
//            } else if(getValueAt(rowIndex, 1).toString().equalsIgnoreCase("j2ee") && columnIndex == 1){
//                component.setBackground(Color.GREEN);
//            }

//            return component;
//        };
//            return this;
//    };};
    

    frame.add(new JScrollPane(table));
    frame.setVisible(true);
}
}