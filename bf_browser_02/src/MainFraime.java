import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JSlider;

import java.awt.Scrollbar;
import java.awt.Component;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

import sun.text.normalizer.RangeValueIterator;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;





public class MainFraime extends JFrame {

	private static final long serialVersionUID = -2065494788099040241L;
	private JTable table;
	int x=0;//universal scroll value
	int y=0;//universal scroll value
	int rows=0;
	int cols=0;
	String read;
	String dir=null;
	Scanner line=null;
	File file;
	File fileLineData;
	File main;
	
	Scanner fileR=null;
	int divisions;
	int lowGlobal;
	int highGlobal;
	int minHighlight=1000; // amount of min count value to highlight 
	int range;//to be used with divisions, lowGloabal & highGlobal
	int lockRange=2;//2 is unlocked
	int rangeDistance=1;//if lockRange==1 then use this var
	
	String search=null;
	int lowLocal;//uses divisions
	int highLocal;//uses divisions max
	view v;//the most important part that updates the cells
	Boolean useMinfilter=true;
	
	JProgressBar progressBar = new JProgressBar();
	DefaultTableModel dtm=null;
	private JPanel contentPane= new JPanel();
	JSlider bottom_slider = new JSlider();
	JSlider top_slider= new JSlider();
	JTextPane txtpnMinum = new JTextPane();
	JTextPane txtpnMaximum = new JTextPane();
	JTextPane txtpnHello = new JTextPane();
	TextField textField = new TextField();
	JToggleButton tglbtnLockDistance = new JToggleButton("Lock distance");
	JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("min amount");
	JTextField textField_minHilight = new JTextField();
	JLabel lblNewLabel = new JLabel("Search");
	JSlider search_min_slider = new JSlider();
//	PicoIsAwesome p;
	PicoIsAwesomeEdit p;
	Scanner s=null;
	private JTextPane txtpnHi = new JTextPane();
	
	
	MouseMotionListener M=new MouseMotionAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
			x=e.getX();	
			y=e.getY();	
//			table.setValueAt(x, 0, 0);
//			table.setValueAt(y, 0, 1);
//			
			if (x>4) cols=(int) Math.pow(x,.5);
			if (y>4) rows=(int) Math.pow(y,.5);
//			dtm.setRowCount(rows);
//			dtm.setColumnCount(cols);
//			System.out.println("row and col#="+rows+","+cols);
			if (x<250/2 && y<250/2) table.setGridColor(new Color(x*2,y*2,2));
			
			progressBar.setValue(x);

		}
		
	};
	
	//not used, old way of coloring cells...
	@SuppressWarnings("serial")
	public class MyTableCellRenderer_old extends DefaultTableCellRenderer implements TableCellRenderer {
		
//		public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){  
//			Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);  
//
//			if(getValueAt(rowIndex, columnIndex).toString().equals("Red")) {  
//			   componenet.setBackground(Color.RED);  
//			} else if(getValueAt(rowIndex, columnIndex).toString().equals("Green")) {
//			   componenet.setBackground(Color.GREEN);
//			}
//			return componenet;
//			} 
		
//		 public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,
//	                int columnIndex) {
//			 super.prepareRenderer(renderer, rowIndex, columnIndex); 
//			 
//						return this;
//			 
//			 
//		 }
		
		
		 int good=0;
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(null);
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            setText(String.valueOf(value));
            setText(value.toString());
//            boolean interestingRow = row % 2 == 0;
//            boolean secondColumn = column == 1;
//            if (interestingRow) {
//                setBackground(Color.YELLOW);
//            }
//            System.out.println(value);
           
            try{
		            if (Integer.parseInt(value.toString())>=minHighlight) {
		                setBackground(Color.YELLOW);
		                good=1;
		            }    
            	}
            
            catch(Exception e){};
            
            try{
            	if (value.toString().contains(search) && !search.matches(" *")) {
	                setBackground(new Color(100,250,100));
//	            	setBackground(Color.BLUE);
	            }
            }
            catch(Exception e){};
//                else if (secondColumn) {
//                setBackground(Color.RED);
//            }
//            if (interestingRow && secondColumn) {
//                setBackground(Color.BLUE);
//            } else if (interestingRow) {
//                setBackground(Color.YELLOW);
//            } else if (secondColumn) {
//                setBackground(Color.RED);
//            }
            return this;
        }

    }
	
		

	
	
	File directory=null;
	private JTextField textField_1;

	
	int setSource(){ //source of C-bf rendered files
//		int setSource(int count,String currentdir){
		
//		print("can't open file! ["+count+"]\n");
//		print("can't find files!");
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(true);
		fc.setDialogTitle("Select BF  output directory");
		fc.setCurrentDirectory(new File(".//")); //choose from current dir
		int returnVal = fc.showOpenDialog(MainFraime.this);
		if (returnVal== JFileChooser.APPROVE_OPTION){
			directory=fc.getSelectedFile();
			dir=directory.toString()+"\\";
			dir=dir.replace("\\", "\\\\");
			return 1;
		}
		if (returnVal==JFileChooser.CANCEL_OPTION){
			return -1;
		}
		return 0;
//		print("{"+dir+"}");
	}
	void smallSet() throws FileNotFoundException{
		
		file=new File(dir+"o_bfout");
		fileLineData=new File(dir+"lines");
		line=new Scanner(fileLineData);
		line.nextLine();
		line.nextLine();
		lowGlobal=line.nextInt();
		highGlobal=line.nextInt();
		
	}
	
	void fileManagement(){//setup 1=loc file  doesn't exist, setup=2 contents of loc contents problem
		int tmp=0;
		main=new File(".\\loc");
		try {
			fileR=new Scanner(main);
			if(fileR.hasNextLine()) dir=fileR.nextLine();

		}catch(Exception e){
			print("sorry couldn't read loc file");
		}
		try{
			smallSet();
		}catch(Exception e){
			print("lines file format was not correct using saved settings");
		}
		
		do{
			
			if(((!file.exists() || !fileLineData.exists()) || highGlobal==0) && tmp!=-1) {print("Couldn't find "+'"'+"o_bfout"+'"'+" or/and "+'"'+"list"+'"'+" in this directory,"
					+ " or correct format of them\nplease select a different directory.");					
			tmp=setSource();
			}
			
			try {
				smallSet();
				
			} catch (Exception e) {
				print("lines file format was not correct from current selection");
			}
			
//			print("tmp= "+tmp);
			
				}while(((!file.exists() || !fileLineData.exists()) || (tmp==1 && highGlobal==0)) && (tmp!=-1));
		//repeat if files don't exits in directory or not the right format...
			
		
			if (tmp==-1) {
				print("we are sorry that the files couldn't be located...");
				System.exit(0);
				return;}
			
//			print("highglobal="+highGlobal);
			print("selected good directory!");
//			if ALL GOOD! then->>>>>>>>>>
					FileWriter fwr=null;
					try {
						fwr=new FileWriter(new File(".//loc"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						fwr.write(dir);//update the directory for all the rest of the files
						fwr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						s=new Scanner(file);
						
						
					} catch (FileNotFoundException e2) {
//						e2.printStackTrace();
						print("\nsorry the bf_out couldn't be read!");
					}
//			>>>>>>>>>>>>>>>>>>>>>>>
			
	}


	public MainFraime() {
		setTitle("PAI-Sci 00.1");
		divisions=100;
////		good to know how to run external processes
//		Runtime rt = Runtime.getRuntime();
//		try {
//			Process proc = rt.exec("C:\\cygwin64\\home\\sal\\BF_CLARK_PROJECT\\Alex\\bf 0 10000000");
//			try {
//				int exitVal = proc.waitFor();
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}//wait till this finishes
////			proc.exitValue();//run at same time
//		} catch (IOException e1) {e1.printStackTrace();}
		
		final Component component;
		
		fileManagement();

			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 573);	//bounds of frame where grid is added onto
		
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setFocusCycleRoot(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		textField.setBackground(new Color(0, 255, 102));
		textField.setBounds(882, 430, 206, 20);
		contentPane.add(textField);
		
		
		txtpnHello.setBounds(591, 445, 149, 36);
		txtpnHello.setText("");
		contentPane.add(txtpnHello);
		progressBar.setBounds(577, 495, 547, 29);
		progressBar.setStringPainted(true);
		
		contentPane.add(progressBar);
		
		bottom_slider.setToolTipText("max value");
		bottom_slider.setFocusable(true);
		bottom_slider.setBounds(75, 495, 474, 23);
		bottom_slider.setValue(1);
		contentPane.add(bottom_slider);
		
		
		top_slider.setFocusable(true);
		top_slider.setFocusTraversalKeysEnabled(false);
		top_slider.setToolTipText("min value");
		top_slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		top_slider.setBounds(75, 461, 474, 23);
		top_slider.setValue(0);
		contentPane.add(top_slider);
		
		tglbtnLockDistance.setBounds(256, 396, 121, 23);
		contentPane.add(tglbtnLockDistance);
		
		
		txtpnMinum.setText(String.valueOf(lowLocal));
		txtpnMinum.setBounds(5, 461, 54, 20);
		contentPane.add(txtpnMinum);
		
		
		txtpnMaximum.setText(String.valueOf(highLocal));
		txtpnMaximum.setBounds(5, 498, 54, 20);
		contentPane.add(txtpnMaximum);
		txtpnHi.setBounds(286, 430, 54, 20);
		contentPane.add(txtpnHi);
		
		
		lblNewLabel.setBounds(959, 400, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
	
		chckbxmntmNewCheckItem.setSelected(true);
		chckbxmntmNewCheckItem.setBounds(600, 378, 129, 22);
		contentPane.add(chckbxmntmNewCheckItem);
		
		textField_minHilight.setBackground(new Color(255, 255, 51));
		textField_minHilight.setBounds(616, 414, 74, 20);
		contentPane.add(textField_minHilight);
		textField_minHilight.setColumns(10);
		
		
		
		search_min_slider.setBounds(719, 411, 113, 23);
		contentPane.add(search_min_slider);

		rows=(int)(getWidth()/43);
//		int y=(int)(getHeight()/55);
		cols=(int)6;
		print("rows= "+rows+", columns= "+cols);
		table = new JTable(rows,cols){
			
			public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    //comment row, exclude heading
//                    if(rowIndex != 0){
                      tip = getValueAt(rowIndex, colIndex).toString();
//                    }
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
			 @Override
		        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,int columnIndex) {
		            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);  

//		            System.out.println(renderer.toString());
		            try{
		            	
		            	
		            	if((rowIndex-1)>=0){
		            		String val=getValueAt(rowIndex-1, columnIndex).toString();
		            		if (val.contains("[") || val.equals("") || search==null) {// looking at the bf output rows
		            			component.setBackground(Color.WHITE);
		            			return component;
		            			}
		            		int number=Integer.parseInt(val);
//		            		String regex=".*"+search+".*";
				            if(getValueAt(rowIndex, columnIndex).toString().contains(search) && !search.matches(" *")
				            		){
				            	//getValueAt(rowIndex, columnIndex).toString().matches(regex)
				            	//getValueAt(rowIndex, columnIndex).toString().contains(search)
				            	
				            	//getValueAt(rowIndex, 0).toString().equalsIgnoreCase("java")){//this.equals("java")){
				            	//getValueAt(rowIndex-1, columnIndex).equals("1")
				            	//Integer.parseInt((String) getValueAt(rowIndex-1, columnIndex))
					            if((number>=minHighlight && useMinfilter) || !useMinfilter ){	
					            	component.setBackground(Color.GREEN);}
					            
					            else if((number<minHighlight && useMinfilter)){
					            	component.setBackground(Color.lightGray);
					            }
					            
					            else{
					            	component.setBackground(Color.WHITE);
					            }
				            }
				            
		            		
				            else{
				            	component.setBackground(Color.WHITE);
				            }
		            		}
		            	}
		            	
		            
		            	 
//		            	if(search!=null && !getValueAt(rowIndex-1, columnIndex).equals("")){
//		            	System.out.println(">>"+getValueAt(rowIndex-1, columnIndex));
//		            	}}
		           
		            
		            catch(Exception e) {System.out.print(" "+e);};
					return component;
		            
		        }
		};
		
//		table.addMouseMotionListener(new MouseMotionAdapter() {
//			
//			public void mouseMoved(MouseEvent e) {
//				print(table.columnAtPoint(e.getPoint())+" , "+table.rowAtPoint(e.getPoint()));
//				
//				TableColumn sportColumn = table.getColumnModel().getColumn(2);
//				
//				
//			}
//		});
		table.setCellSelectionEnabled(true);
		
		
		table.setRowHeight(16);
		table.setAlignmentY(Component.TOP_ALIGNMENT);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		table.setColumnSelectionAllowed(true);
		
		
//      dtm = (DefaultTableModel) table.getModel();
//		table.addMouseMotionListener(contentPane.getMouseMotionListeners().clone());
		//can't copy it?
		
//		table.addMouseMotionListener(M);
		table.setBounds(5, 11, 1139, 350);
		contentPane.add(table);
//		progressBar.setMaximum(getWidth());
		progressBar.setMaximum(divisions+1);
		// +1/ extra bit to include the whole range
		progressBar.setMinimum(0);
		
		range=(highGlobal-lowGlobal)/(divisions-1);
		lowLocal=0;
		highLocal=1;
		txtpnHi.setText(String.valueOf((highLocal-lowLocal)*range-lowGlobal));
		txtpnMaximum.setText(String.valueOf(highLocal*range+lowGlobal));
		txtpnMinum.setText(String.valueOf(lowLocal*range+lowGlobal));
		
		textField_minHilight.setText(String.valueOf(minHighlight)); //minimun search textbox
		
		bottom_slider.setFocusCycleRoot(true);
		bottom_slider.setFocusTraversalKeysEnabled(false);
        
		
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				search=textField.getText();
//				v.showView(Math.max(lowLocal*range+lowGlobal,lowGlobal), Math.min(highLocal*range+lowGlobal,highGlobal-1));
				repaint();
			}
			
		});
		
		
		//PROGRESS BARR ACTION!		
		progressBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override

			public void mouseMoved(MouseEvent e) {
//				float xx=(float) (e.getX()*2.15);///progressBar.getWidth());	
//				y=e.getY()/progressBar.get();	
//				table.setValueAt(x, 0, 0);
//				table.setValueAt(y, 0, 1);
//				
//				if (x>progressBar.getWidth()) cols=(int) Math.pow(x,.5);
//				if (y>4) rows=(int) Math.pow(y,.5);
//				dtm.setRowCount(rows);
//				dtm.setColumnCount(cols);
//				System.out.println("row and col#="+rows+","+cols);
//				if (x<250/2 && y<250/2) 
//				progressBar.getLocation().x
//				print("x="+x+"width "+progressBar.getWidth()+"start"+progressBar.getBounds().x);
//				table.setGridColor(new Color(x*2,y*2,2));
//				float val=1173;
//				progressBar.setValue((int) xx);
				int val = e.getX();
				rangeDistance=highLocal-lowLocal;
				int xx = (int)Math.round(((double)val / (double)progressBar.getWidth()) * progressBar.getMaximum());
				 
				lowLocal=(int) (Math.max((xx)-(float)((rangeDistance)/2),0));
				highLocal=(int) (Math.min((xx)+(rangeDistance)-(float)(rangeDistance/2),divisions));
//				print(String.valueOf((100*xx/val)));
				
				if(lockRange==1 && lowLocal!=(highLocal-rangeDistance)) {
					top_slider.setValue((int) highLocal-rangeDistance);
					lowLocal=top_slider.getValue();
					txtpnMinum.setText(String.valueOf(lowLocal*range));
					
					bottom_slider.setValue((int) lowLocal+rangeDistance);
					highLocal=bottom_slider.getValue();
					txtpnMaximum.setText(String.valueOf(highLocal*range));
					
					xx = (lowLocal+highLocal)/2;
					
				}
				else if(lockRange==2 && lowLocal>=highLocal) {
					top_slider.setValue((int) highLocal-1);
					lowLocal=top_slider.getValue();
					txtpnMinum.setText(String.valueOf(lowLocal*range));
					
					xx = (lowLocal+highLocal)/2;
				}
				
				
						
				print(String.valueOf(lowLocal)+","+String.valueOf(highLocal));
//				print(xx);
//				v.showView(lowLocal*range, highLocal*range);
				progressBar.setValue(xx);
				
				
				
				top_slider.setValue(lowLocal);
				txtpnMinum.setText(String.valueOf(lowLocal*range+lowGlobal));

				bottom_slider.setValue(highLocal);
				txtpnMaximum.setText(String.valueOf(highLocal*range+lowGlobal));
				
				repaint();
//				((x/val)+(rangeDistance/2))*range
//				v.showView(((x/val)-(rangeDistance/2))*range, ((x/val)+(rangeDistance/2))*range);

			}
			
		});
		

		search_min_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				minHighlight=(int) Math.pow(1.096479,search_min_slider.getValue());
				textField_minHilight.setText(String.valueOf(minHighlight));
				repaint();
				
				
			}
		});
		
		

		bottom_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				highLocal=bottom_slider.getValue();
				
//			System.out.println("high>"+highLocal);
			txtpnMaximum.setText(String.valueOf( Math.min(highLocal*range+lowGlobal,highGlobal) ));
//			print(lowLocal+","+highLocal);
			
			if(lockRange==1 && lowLocal!=(highLocal-rangeDistance)) {
				top_slider.setValue((int) highLocal-rangeDistance);
				lowLocal=top_slider.getValue();
//				int low=Math.max(lowLocal*range+lowGlobal+rangeDistance,lowGlobal);
//				bottom_slider.setValue(Math.max(lowLocal,1));
//				txtpnMinum.setText(String.valueOf(Math.max(lowLocal*range+lowGlobal,lowGlobal+range)));
				
			}
			else if(lockRange==2 && lowLocal>=highLocal) {
				top_slider.setValue((int) highLocal-1);
				lowLocal=top_slider.getValue();
//				int low=Math.max(lowLocal*range+lowGlobal+range,lowGlobal);
//				print(lowLocal);
				highLocal=Math.max(lowLocal+1,1);
				bottom_slider.setValue(highLocal);
				txtpnMinum.setText(String.valueOf(Math.max(lowLocal*range+lowGlobal,lowGlobal+range)));
			}
			repaint();
			}
			
		});
		
		bottom_slider.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
//				
				if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
					lockRange=(lockRange==1?2:1);
					if(lockRange==1) rangeDistance=highLocal-lowLocal;
					}
					
					if(arg0.getKeyCode()==KeyEvent.VK_UP){
						// @Todo how to change focus 
						top_slider.requestFocusInWindow();
						
					}
			
					repaint();
			}
		});
		
		top_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lowLocal=top_slider.getValue();
				txtpnMinum.setText(String.valueOf(lowLocal*range+lowGlobal));
				
//				System.out.println("low>"+lowLocal);
				if(lockRange==1 && lowLocal!=(highLocal-rangeDistance)) {
					bottom_slider.setValue((int) lowLocal+rangeDistance);
					highLocal=bottom_slider.getValue();
//					int high=Math.min(highLocal*range+lowGlobal,highGlobal-1);
//					txtpnMaximum.setText(String.valueOf(high));
				}
				else if(lockRange==2 && lowLocal>=highLocal) {
					bottom_slider.setValue((int) lowLocal+1);
					highLocal=bottom_slider.getValue();
//					int high=Math.min(highLocal*range+lowGlobal,highGlobal-1);
//					txtpnMaximum.setText(String.valueOf(high));
//					top_slider.setValue(Math.max(highLocal,divisions-1));
//					txtpnMaximum.setText(String.valueOf(Math.max(highLocal*range+lowGlobal,highGlobal-range)));
					lowLocal=Math.min(highLocal-1,divisions-1);
					top_slider.setValue(lowLocal);
					txtpnMaximum.setText(String.valueOf(Math.min(highLocal*range+lowGlobal,highGlobal-range)));
				}
				repaint();
			}
		});
		
		top_slider.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_SPACE){
				lockRange=(lockRange==1?2:1);
				if(lockRange==1) rangeDistance=highLocal-lowLocal;
				}
				
				if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
					bottom_slider.requestFocusInWindow();
				}
				repaint();
			}
		});
		
		
		
		
		
		
		//lcok action ,what to do when lock has been initiated..
		
		tglbtnLockDistance.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lockRange=arg0.getStateChange();
				if (lockRange==1) rangeDistance=highLocal-lowLocal;
//				System.out.println(rangeDistance);
			}
		});
		



		
		
		/////////Calculates global file min and max
		/////////need better way to associate the start of the number range wanting 
		////////to view and getting it rather than running a for loop each time..
		///////(associative array) hash

//		print(lowGlobal+" - "+highGlobal);
//		range=(highGlobal-lowGlobal)/divisions;
		print(lowGlobal+"-"+highGlobal+" each range="+range);
		
		v=new view(lowGlobal,highGlobal,file,table);
		
		JButton btnDebugg = new JButton("print data");
		btnDebugg.setFont(new Font("Source Sans Pro", Font.PLAIN, 10));
		btnDebugg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.print();
			}
		});
		btnDebugg.setBounds(25, 391, 74, 23);
		contentPane.add(btnDebugg);
		
		chckbxmntmNewCheckItem.addItemListener(new ItemListener() { //change checkbox for minfilter..
			public void itemStateChanged(ItemEvent arg0) {
//				print(chckbxmntmNewCheckItem.getState());
				useMinfilter=chckbxmntmNewCheckItem.getState();
				v.showView(Math.max(lowLocal*range+lowGlobal,lowGlobal), Math.min(highLocal*range+lowGlobal,highGlobal-1));
				
			}
		});
		
		textField_minHilight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try{
				minHighlight=Integer.parseInt(textField_minHilight.getText().toString());
				}
				catch(Exception e){};
				
				repaint();
			}
		});
		
//		txtpnHi.setText("hi");
		
		v.showView(lowGlobal, highGlobal);
//		updateCells();

		//WHERE COLOR IS SET!
//				Enumeration<TableColumn> en = table.getColumnModel().getColumns();
//		        while (en.hasMoreElements()) {
//		            TableColumn tc = en.nextElement();
//		            tc.setCellRenderer(new MyTableCellRenderer());
//		        }
		
		
		

	}
	
	public void paint(Graphics g){
		super.paint(g);
		int high=Math.min(highLocal*range+lowGlobal,highGlobal-1);
		int low=Math.max(lowLocal*range+lowGlobal,lowGlobal);
		
		v.showView(Math.max(lowLocal*range+lowGlobal,lowGlobal), Math.min(highLocal*range+lowGlobal,highGlobal-1));
		txtpnHi.setText(String.valueOf((highLocal-lowLocal)*range+lowGlobal));
		txtpnHello.setText(low+"  -  "+high);
		
//		Enumeration<TableColumn> en = table.getColumnModel().getColumns();
//		int table[][]=new int[rows][cols];
		//ex:30 total
		//6 rows 4 cols
		// count%4+1 = col place
		// int(count/4) row place
		
//        while (en.hasMoreElements()) {
//        	
//        	
//            TableColumn tc = en.nextElement();
//            MyTableCellRenderer cellren = new MyTableCellRenderer();
//            tc.setCellRenderer(cellren);
////            table[count%(cols+1)][(int) Math.floor((float)(count/cols))]=cellren.good;
////            System.out.print(cellren.good);
////            if((count%(cols+1))==0) print("\n");
////            print(">"+count+","+(count%(cols+1))+","+Math.floor((float)((float)count/(float)cols)));
////            print("x="+rows+" y="+cols);
//        }
//        print("");
		
		
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	

	
	void print(Object s){
		System.out.println(s);	
	}
}

