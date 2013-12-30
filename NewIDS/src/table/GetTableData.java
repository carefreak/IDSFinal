package table;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

class GetJTableData{
    public static Object[][] getTableData (JTable table) {
    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
    Object[][] tableData = new Object[nRow][nCol];
    for (int i = 0 ; i < nRow ; i++)
        for (int j = 0 ; j < nCol ; j++)
            tableData[i][j] = dtm.getValueAt(i,j);
    return tableData;
}
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Getting Cell Values in JTable");
    frame.setLayout(null);
    String data[][] = {{"A","Delhi"},
                      {"B","Mumbai"},
                      {"C","Chennai"},
                      {"D","Kolkata"}};
    String col[] = {"Name","Address"};    
    DefaultTableModel model = new DefaultTableModel(data, col);
    final JTable table = new JTable(model);
    JTableHeader header = table.getTableHeader();
    header.setBackground(Color.yellow);
    JScrollPane pane = new JScrollPane(table);
    pane.setBounds(10,10,300,200);
    JButton b=new JButton("Get");
    b.setBounds(10,250,80,20);
    frame.add(pane);
    frame.add(b);
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
Object[][] A=getTableData(table);
for (int i=0 ; i < A.length ; i++)
        {     System.out.println();
            for  (int j=0 ; j < A[i].length ; j++){
                System.out.print(A[i][j].toString()+" ");
                  }
        }
     }
    });
    frame.setSize(350,350);
    frame.setUndecorated(true);
    frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    frame.setVisible(true);
    }
}

