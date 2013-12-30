/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycodef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kode-crypt
 */
public class Mycodef {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection cnn;
        Statement pst;
        ResultSet rs;
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
      /*  String sql ="SELECT  *\n" +
"FROM    mycomp1.tab1,mycompare.tab1\n" +
"WHERE mycompare.tab1.name=mycomp1.tab1.name;"; */
               /*String sql ="SELECT  *\n" +
"FROM    idsrule.snort, ids.packets\n" +
"WHERE ids.packets.sip = idsrule.snort.destip";*/
     
        String sql ="SELECT  *\n" +
"FROM    idsrule.snort, ids.packets\n" +
"WHERE idsrule.snort.sourceip  = ids.packets.sip AND idsrule.snort.sport = ids.packets.sport" ;
        
        
        String str1,str2,str3;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str3 = rs.getString(6);
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
            System.out.println("\n");
            JOptionPane.showMessageDialog(null, "Possible intrusion:"+str3);
        }
        
        }catch(Exception e)        {
            
        }
        
    }
    
}
