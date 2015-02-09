A problem with a JTable is that the right click does not change the row selection. So you if have an Action that works on a specific row you need to left click the row first before right clicking to have the popup menu displayed.

If you want the row to be selected where your right click then you can use code like the following:   

   public TableRightClick()
    {
        popup = new JPopupMenu();
        popup.add( new JMenuItem("Do Something1") );
        popup.add( new JMenuItem("Do Something2") );
        popup.add( new JMenuItem("Do Something3") );
        JMenuItem menuItem = new JMenuItem("ActionPerformed");
        menuItem.addActionListener( this );
        popup.add( menuItem );

        JTable table = new JTable(50, 5);
        table.addMouseListener( new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("pressed");
            }

            public void mouseReleased(MouseEvent e)
            {
                if (e.isPopupTrigger())
                {
                    JTable source = (JTable)e.getSource();
                    int row = source.rowAtPoint( e.getPoint() );
                    int column = source.columnAtPoint( e.getPoint() );

                    if (! source.isRowSelected(row))
                        source.changeSelection(row, column, false, false);

                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        getContentPane().add( new JScrollPane(table) );
    }

    public void actionPerformed(ActionEvent e)
    {
        Component c = (Component)e.getSource();
        JPopupMenu popup = (JPopupMenu)c.getParent();
        JTable table = (JTable)popup.getInvoker();
        System.out.println(table.getSelectedRow() + " : " + table.getSelectedColumn());
    }

    public static void main(String[] args)
    {
        TableRightClick frame = new TableRightClick();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}