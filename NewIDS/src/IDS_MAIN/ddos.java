/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycodef;

/**
 *
 * @author susankhya
 */
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ddos {
     public static void main(String[] args) {
        // TODO code application logic here
        Connection cnn;
        Statement pst;
        ResultSet rs;
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
     
        String sql ="SELECT sip, dip, count( * )\n "+"FROM ids.packets \n"+"GROUP BY sip, dip, time ORDER BY count( * ) DESC ";

        
        String str1,str2,str3;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str3 = rs.getString(6);
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
            System.out.println("\n");
            JOptionPane.showMessageDialog(null, "Possible intrusion:"+str1);
        }
        
        }catch(Exception e)        {
            
        }
        
    }
    
}*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package mysrev2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kode-crypt
 */
public class ddos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       
        Connection cnn;
        Statement pst;
        ResultSet rs;
        String str1,str2,str3;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
              pst = cnn.createStatement();    
        String sql ="SELECT sip, dip, count(*) FROM ids.packets GROUP BY sip, dip, time ORDER BY count(*)desc limit 2;";

        rs=pst.executeQuery(sql);
           
        while(rs.next()){
           
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str3 = rs.getString(3);
            int d = Integer.parseInt(str3);
            if(d>= 3){
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
          //  System.out.println(str1);
            JOptionPane.showMessageDialog(null, "possible ddos flood source ip:"+str1+"destination ip:"+str2);
        }
        }
        }catch(Exception e)        {
           
        }
       
    }
}
    

