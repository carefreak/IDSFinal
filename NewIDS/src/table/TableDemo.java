package table;  
  
import java.awt.BorderLayout;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
  
  
public class TableDemo {  
  
    JTable table;  
    Object [][] array;  
  
  
private void readTableData() {  
  
   array = new Object [table.getRowCount()] [table.getColumnCount()];  
   String string ;  
   Object object = new Object();  
     
     
   for ( int i = 0; i < table.getRowCount() ; ++i) {  
  
        for ( int j = 0; j < table.getColumnCount(); ++j) {  
           array[i][j] = table.getValueAt(i, j);  
           object = table.getValueAt(i,j);  
           string = object.toString();  
  
         System.out.println("readTableData string is: " + string);            // good here  
          //System.out.println("readTableData array is: " + array[i][j]);  
            
        }  
       
    }  
}  
  
protected void copyArray( Object[][] list ) {  
  
    for ( Object item : list ) {  
     
           String string = item.toString();  
           System.out.println("WriteFile string is: " + string);    // not so good here  
  
       }  
 }  
  
private void createAndShowGUI() {  
  
    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },  
        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };  
    Object columnNames[] = { "Column One", "Column Two", "Column Three" };  
  
  
    JFrame frame = new JFrame();  
    table = new JTable(rowData, columnNames);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
    JScrollPane scrollPane = new JScrollPane(table);  
    frame.add(scrollPane, BorderLayout.CENTER);  
    frame.setSize(300, 150);  
    frame.setVisible(true);  
    readTableData();  
    copyArray(array);  
     
}  
  
public static void main(String args[]) {  
  
     java.awt.EventQueue.invokeLater(new Runnable() {  
       public void run() {  
           TableDemo demo = new TableDemo();  
           demo.createAndShowGUI();  
       }  
     });  
  } 
} 
 