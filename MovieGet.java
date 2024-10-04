import java.sql.SQLException;
import java.util.Scanner;



public class MovieGet {
    private static final String url = "jdbc:mysql://localhost:3306/movies";
    private static final String user = "root";
    private static final String password = "1289";
    
     public static void main(String[] args) {

         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
         }catch (ClassNotFoundException e){
             System.out.println(e.getMessage());
         }
       Scanner sc = new Scanner(System.in);
         try{
             Connection connection = DriverManager.getConnection(url, user, password);
             Main specific = new Main(connection, sc);
             Main genres = new Main(connection, sc);

             System.out.println("This is the best website for you if you don't know what to watch!\n\nThe instruction to use this website :- \n1.if you want the recommendation based on the genre then click '1' \n2.if you want to know the specific movie rating then click '2'");
             System.out.println();
             System.out.println("start your search :-");
             System.out.println("--------------------");
             System.out.println("1.Movies recommendation based on genre");
             System.out.println("2.TO know the rating of the movie");
             System.out.println();

             while (true) {
                 System.out.print("Enter your choice : ");
                 int choice = sc.nextInt();
                 switch (choice){
                     case 1:
                         genres.specificgenre();
                         System.out.println();
                         break;
                     case 2:
                         specific.specificmovie();
                         System.out.println();
                         break;
                     case 3:
                         return;
                     default:
                         System.out.println("Enter valid choice!!!");
                 }
             }

         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
     }
}