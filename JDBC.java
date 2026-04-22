import java.sql.*;
import java.util.*;

public class Main{
    static final String URL="jdbc:mysql://localhost:3306/college_db";
    static final String USER="root";
    static final String PASS="password";

    static Connection getCon() throws Exception{
        return DriverManager.getConnection(URL,USER,PASS);
    }

    static void create(){
        try(Connection c=getCon();Statement s=c.createStatement()){
            s.executeUpdate("CREATE TABLE IF NOT EXISTS students(roll INT PRIMARY KEY,name VARCHAR(50),branch VARCHAR(30),marks DOUBLE)");
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    static void insert(int r,String n,String b,double m){
        try(Connection c=getCon();PreparedStatement p=c.prepareStatement("INSERT INTO students VALUES(?,?,?,?)")){
            p.setInt(1,r);p.setString(2,n);p.setString(3,b);p.setDouble(4,m);
            p.executeUpdate();
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    static void view(){
        try(Connection c=getCon();Statement s=c.createStatement();ResultSet r=s.executeQuery("SELECT * FROM students")){
            while(r.next())
                System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getDouble(4));
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    static void update(int r,double m){
        try(Connection c=getCon();PreparedStatement p=c.prepareStatement("UPDATE students SET marks=? WHERE roll=?")){
            p.setDouble(1,m);p.setInt(2,r);
            p.executeUpdate();
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    static void delete(int r){
        try(Connection c=getCon();PreparedStatement p=c.prepareStatement("DELETE FROM students WHERE roll=?")){
            p.setInt(1,r);
            p.executeUpdate();
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    public static void main(String[] a){
        create();
        insert(1,"A","CS",80);
        insert(2,"B","IT",90);
        view();
        update(1,95);
        delete(2);
        System.out.println("After:");
        view();
    }
}

