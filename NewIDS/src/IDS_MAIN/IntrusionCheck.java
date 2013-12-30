/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IDS_MAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author kode-crypt
 */
public class IntrusionCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    }
        public static void IPort(){
        try{
        Connection cnn;
        Statement pst;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
        String sql ="SELECT  *\n" +
        "FROM    idsrule.snort, ids.packets\n" +
        "WHERE idsrule.snort.sourceip  = ids.packets.sip AND idsrule.snort.sport = ids.packets.sport limit 2" ;
        
        
        String str1,str2,str3,str4,str5,str6;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str4 =rs.getString(4);
            str3 = rs.getString(3);
            str5= rs.getString(5);
            str6=rs.getString(6);
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
            System.out.println("\n");
            JOptionPane.showMessageDialog(null, "Possible intrusion source ip:"+str1+"Destination ip:"+str2);
        }
        
        }catch(Exception e)        {
            
        }
        
    }
        
        public static void Port(){
        try{
                   Connection cnn;
        Statement pst;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
        
        String sql ="SELECT  *\n" +
        "FROM    idsrule.snort, ids.packets\n" +
        "WHERE idsrule.snort.sport  = ids.packets.sport OR idsrule.snort.dport = ids.packets.dport limit 2" ;
        
        String str1,str2,str3,str4,str5,str6;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str4 =rs.getString(4);
            str3 = rs.getString(3);
            str5= rs.getString(5);
            str6=rs.getString(6);
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
            System.out.println("\n");
            JOptionPane.showMessageDialog(null, "Possible intrusion from port:"+str3+"source ip and dest ip"+str3+"\t"+str4);
        }
        
        }catch(Exception e)        {
            
        }
        
    }
       
        
        
        public static void IPonly(){
        try{
        Connection cnn;
        Statement pst;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
        String sql ="SELECT  *\n" +
        "FROM    idsrule.snort, ids.packets\n" +
        "WHERE idsrule.snort.sourceip  = ids.packets.sip OR  idsrule.snort.destip =ids.packets.dip limit 2";
        
        
        String str1,str2,str3,str4,str5,str6;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str4 =rs.getString(4);
            str3 = rs.getString(3);
            str5= rs.getString(5);
            str6=rs.getString(6);
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
            System.out.println("\n");
            JOptionPane.showMessageDialog(null, "Possible intruder's IPs source:"+str1+"\t destination:"+str2+"\t msg:"+str6);
        }
        
        }catch(Exception e)        {
            
        }
        
    }
        
        
        public static void Ddos(){
        try{
        Connection cnn;
        Statement pst;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        pst = cnn.createStatement();
        
        String sql ="SELECT sip, dip, count(*) FROM ids.packets GROUP BY sip, dip, time ORDER BY count(*)desc limit 2;";
        
        String str1,str2,str3,str4,str5,str6;
        rs=pst.executeQuery(sql);
        while(rs.next()){
            str1 = rs.getString(1);
            str2 = rs.getString(2);
            str4 =rs.getString(4);
            str3 = rs.getString(3);
            str5= rs.getString(5);
            str6=rs.getString(6);
            int d = Integer.parseInt(str3);
            if(d>=3){
            System.out.println(" "+str1+" \t " +str2+" \t " +str3);
          //  System.out.println(str1);
            JOptionPane.showMessageDialog(null, "possible ddos flood from source ip:"+str1+" destination ip: "+str2);
        }
        }  
        }catch(Exception e)        {
            System.out.println(e);
        }
        
    }
  
}

