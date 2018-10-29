package sports;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Connector{

  private static final String dbClassName = "com.mysql.jdbc.Driver";
  private static final String CONNECTION = "jdbc:mysql://127.0.0.1/sports";
  private static Properties p = new Properties();
  private static Connection c;
  Connector() throws ClassNotFoundException, SQLException{
    System.out.println(dbClassName);
    Class.forName(dbClassName);

    p.put("user", "sports");
    p.put("password", "sports");

//    c = DriverManager.getConnection(CONNECTION, p);
    System.out.println("Connected!");

  }


  public static void main(String args[]) throws ClassNotFoundException, SQLException{
      Connector conn = new Connector();
//      System.out.println(conn.getMatches());
//       conn.getMatchInfo(1);
//        System.out.println(conn.buyTicket(1, 3, 5));
  }
  
  public boolean createUser(String username, String email, String password){
      try{
          c = DriverManager.getConnection(CONNECTION, p);
          String query = "insert into users(username, email, password) values (?, ?, ?)";

          PreparedStatement preparedStmt = c.prepareStatement(query);
          preparedStmt.setString(1, username);
          preparedStmt.setString(2, email);
          preparedStmt.setString(3, password);

          preparedStmt.execute();
          System.out.println("created user " + username);
          c.close();
          return true;
      } catch(Exception e){
          e.printStackTrace();
          return false;
      }
  }

  public List findUser(String email, String password){
      List userList = new ArrayList();

      try{
          String query = "SELECT * FROM users where email=? and password=?";
          c = DriverManager.getConnection(CONNECTION, p);

          PreparedStatement preparedStmt = c.prepareStatement(query);
          preparedStmt.setString(1, email);
          preparedStmt.setString(2, password);

          ResultSet rs = preparedStmt.executeQuery();
          ResultSetMetaData rsmd = rs.getMetaData();

          int rowCount = 0;
          if (rs.last()){
              rowCount = rs.getRow();
              rs.beforeFirst();
          }

          if (rowCount == 0 ){
              userList.add("none");
              return userList;
          }

          while (rs.next()){
              userList.add(rs.getInt(1));
              userList.add(rs.getString(2));
              userList.add(rs.getString(3));
          }

          return userList;
      } catch(Exception e){
          e.printStackTrace();
          userList.add("none");
          return userList;
      }
  }

  public boolean createStadium(String stadiumName, int stadiumCapacity){
      try{
          c = DriverManager.getConnection(CONNECTION, p);

          String query = "INSERT INTO stadiums(stadium_name, capacity) VALUES (?, ?)";

          PreparedStatement preparedStmt = c.prepareStatement(query);
          preparedStmt.setString(1, stadiumName);
          preparedStmt.setString(2, String.valueOf(stadiumCapacity));

          preparedStmt.execute();
          return true;
      } catch(Exception e){
          e.printStackTrace();
          return false;
      }
  }

  public boolean createTeam(String teamName){
      try{
          c = DriverManager.getConnection(CONNECTION, p);

          String query = "INSERT INTO teams (team_name) VALUES (?)";
          PreparedStatement preparedStmt = c.prepareStatement(query);
          preparedStmt.setString(1, teamName);
          preparedStmt.execute();


          return true;

      } catch(Exception e){
          e.printStackTrace();
          return false;
      }
  }

  public List getMatches(){
      try{
          c = DriverManager.getConnection(CONNECTION, p);

//          String query = "INSERT INTO teams (team_name) VALUES (?)";
//            String query = "SELECT teams.team_name FROM matches INNER JOIN teams ON matches.home_team_id=teams.id"
//                    + " ORDER BY matches.id";

            String homeQuery = "SELECT teams.team_name FrOM matches INNER JOIN teams ON matches.home_team_id=teams.id"
                    + " ORDER BY matches.id";
            String awayQuery = "SELECT teams.team_name FROM matches INNER JOIN teams ON matches.away_team_id=teams.id"
                    + " ORDER BY matches.id";
            String stadiumQuery = "SELECT stadiums.stadium_name FROM matches INNER JOIN stadiums ON matches.stadium_id=stadiums.id"
                    + " ORDER BY matches.id";
            String idQuery = "SELECT matches.id FROM matches INNER JOIN stadiums ON matches.stadium_id=stadiums.id "
                    + " ORDER BY matches.id";

            List<String> homeList = new ArrayList();
            List<String> awayList = new ArrayList();
            List<String> stadiumList = new ArrayList();
            List<Integer> idList = new ArrayList();
            
            PreparedStatement preparedStmt = c.prepareStatement(homeQuery);
            ResultSet rs = preparedStmt.executeQuery();
            System.out.println("HOME TEAMS###################");
            while (rs.next()){
//                System.out.println(rs.getString(1));
                homeList.add(rs.getString(1));
            }

            preparedStmt = c.prepareStatement(awayQuery);
            rs = preparedStmt.executeQuery();
            System.out.println("AWAY TEAMS#############################");
            while (rs.next())
                awayList.add(rs.getString(1));

            preparedStmt = c.prepareStatement(stadiumQuery);
            rs = preparedStmt.executeQuery();
            System.out.println("STADIUMS##########################");
            while (rs.next())
//                System.out.println(rs.getString(1));
                stadiumList.add(rs.getString(1));
            
            preparedStmt = c.prepareStatement(idQuery);
            rs = preparedStmt.executeQuery();
            System.out.println("IDS######################");
            while (rs.next())
                idList.add(rs.getInt(1));
            
            List<List> allValues = new ArrayList();
            allValues.add(idList);
            allValues.add(homeList);
            allValues.add(awayList);
            allValues.add(stadiumList);
            
            
            List<List> allMatches = new ArrayList();
            
            for (int x = 0; x < allValues.get(0).size(); x++){
                List match = new ArrayList();
                allMatches.add(match);
            }
            
            
            for (int x = 0; x < allValues.size(); x++){
                List values = allValues.get(x);
                for (int y = 0; y < values.size(); y++){
//                    allMatches.add(values.get(y));
                    allMatches.get(y).add(values.get(y));
                }
            }
            
            return allMatches;
      } catch(Exception e){
//          System.out.println("error...");
            e.printStackTrace();
//            return "Error";
            List<String> errorList = new ArrayList();
            errorList.add("error");
            return errorList;
      }
  }
  
  public List getMatchInfo(int matchId) throws ClassNotFoundException, SQLException{
      c = DriverManager.getConnection(CONNECTION, p);
      String query = "SELECT * FROM matches WHERE id=?";
      
      PreparedStatement preparedStmt = c.prepareStatement(query);
      preparedStmt.setInt(1, matchId);
      
      ResultSet rs = preparedStmt.executeQuery();
      ResultSetMetaData rsmd = rs.getMetaData();
      
      List result = new ArrayList();

      int rowCount = 0;
      
      if (rs.last()){
          rowCount = rs.getRow();
          rs.beforeFirst();
      }
      
      if (rowCount == 0 ){
          result.add("none");
          return result;
      }

      
      while (rs.next()){
          result.add(rs.getInt(1)); // id
          result.add(rs.getInt(2)); // home team id
          result.add(rs.getInt(3)); // away team id
          result.add(rs.getInt(4)); // stadium id
          result.add(rs.getInt(5)); // number of tickets
          result.add(rs.getInt(6)); // price
      }
      
      return result;
  }
  
  public boolean buyTicket(int userId, int matchId, int numberOfTickets) throws SQLException{
      
       c = DriverManager.getConnection(CONNECTION, p);
       if (numberOfTickets > 1){
            for (int x=0; x < numberOfTickets; x++){
                String query = "INSERT INTO tickets (matchId, userId) VALUES (?, ?)";
                
                PreparedStatement preparedStmt = c.prepareStatement(query);
                preparedStmt.setInt(1, matchId);
                preparedStmt.setInt(2, userId);
                
                preparedStmt.execute();
                
            }
       } else if (numberOfTickets == 1){
           String query = "INSERT INTO tickets (matchId, userId) VALUES (?, ?)";
           
           PreparedStatement preparedStmt = c.prepareStatement(query);
           preparedStmt.setInt(1, matchId);
           preparedStmt.setInt(2, userId);
           
           preparedStmt.execute();
       }
       else {
           return false;
       }
       
       return true;
  }
  
}
