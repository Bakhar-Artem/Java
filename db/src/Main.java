import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:3306/postgres","postgres","root") ;
            Statement statement=connection.createStatement()){
            String sql="SELECT id, role FROM role";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        System.out.println("ok");

    }
}
