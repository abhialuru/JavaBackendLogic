package movierecommender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    Connection con;
    Scanner scanner;

    public  Main(Connection con, Scanner scanner) {
        this.con = con;
        this.scanner = scanner;
    }
     public  void  specificmovie(){
         System.out.print("Enter Your Movie: ");
         String userinfo =  scanner.next();


         try{
             String query = "select * from allmovies where name = ?";
             PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userinfo);
             ResultSet res = ps.executeQuery();
             if (!res.getBoolean(userinfo)){
                 System.out.println("This movie not exist in our website.....will add soon");
             }
             while(res.next()){

                     String name = res.getString("name");
                     String genre = res.getString("genre");
                     int year = res.getInt("year");
                     float rating = res.getFloat("rating");
                     System.out.println("Title : " + name);
                     System.out.println("Genre : " + genre);
                 System.out.println("year : "+year);
                 System.out.println("rating : "+rating);

             }
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
     }

    public  void  specificgenre(){
        System.out.print("Enter Your Genre : ");
        String userinfo =  scanner.next();

        try{
            String query = "select * from allmovies where genre = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userinfo);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                System.out.println();
                String name = res.getString("name");
                String genre = res.getString("genre");
                int year = res.getInt("year");
                float rating = res.getFloat("rating");
                System.out.println("Title : " + name);
                System.out.println("Genre : " + genre);
                System.out.println("year : "+year);
                System.out.println("rating : "+rating);
                System.out.println();

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}