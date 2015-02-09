//
//
//JTable auditTable = new JTable(){
//
//            //Implement table cell tool tips.           
//            public String getToolTipText(MouseEvent e) {
//                String tip = null;
//                java.awt.Point p = e.getPoint();
//                int rowIndex = rowAtPoint(p);
//                int colIndex = columnAtPoint(p);
//
//                try {
//                    //comment row, exclude heading
//                    if(rowIndex != 0){
//                      tip = getValueAt(rowIndex, colIndex).toString();
//                    }
//                } catch (RuntimeException e1) {
//                    //catch null pointer exception if mouse is over an empty line
//                }
//
//                return tip;
//            }
//        };