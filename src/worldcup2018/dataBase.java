package worldcup2018;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Michael Mukolwe
 */
public class dataBase {

    private static Connection conn;

    public static void newConn() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    //add the group names
    public static int addGroup(String groupName) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate("INSERT INTO groupNames VALUES (null,'" + groupName + "')");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //add teams
    public static int addTeam(String countryName, String groupName, int seq) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate("INSERT INTO team VALUES (null,'" + countryName + "','" + groupName + "'," + seq + ",0,0,0)");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //add match details
    public static int matchDetails(String homeTeam, String awayTeam, String groupName, String datE, String timE) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate("INSERT INTO match_details VALUES (null,'" + homeTeam + "','" + awayTeam + "','" + groupName + "','" + datE + "','" + timE + "')");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //add match results
    public static int matchResults(String homeTeam, String awayTeam, int homeTeamsGoal, int awayTeamGoal) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate("INSERT INTO match_results VALUES (null,'" + homeTeam + "','" + homeTeamsGoal + "','" + awayTeam + "','" + awayTeamGoal + "')");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //get points of a team
    public static int getPoints(String team) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT points FROM team WHERE countryName='" + team + "'");
            rs.next();
            return rs.getInt("points");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //get goals of a team
    public static int getGoals(String team) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT goals FROM team WHERE countryName='" + team + "'");
            rs.next();
            return rs.getInt("goals");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //get goals of a team
    public static int getMatches(String team) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT match_played FROM team WHERE countryName='" + team + "'");
            rs.next();
            return rs.getInt("match_played");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    //update points and goals
    public static int updatePointsGoals(String countryName, int goals, int points, int matches) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate("UPDATE team SET points = '" + points + "',goals = '" + goals + "',match_played = '" + matches + "' WHERE countryName = '" + countryName + "'");
        } catch (SQLException e) {
            System.out.println("error" + e);
            return 0;
        }
    }

    public static String currentSchedule(String groupName) throws Exception {
        try {
            newConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM match_details WHERE groupName='" + groupName + "'");
            rs.next();
            String match = rs.getString("datE") + " {" + rs.getString("timE") + "} " + rs.getString("homeTeam") + " vs " + rs.getString("awayTeam");
            return match;
        } catch (SQLException e) {
            System.out.println("error" + e);
            return null;
        }
    }

    //get current standing
    public static String currentStanding(String groupName) throws Exception {
        try {
            newConn();
            String standing = "";int x = 1;
            Statement stmt = conn.createStatement();
            while(x <= 4) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM team WHERE team_id = " + x + " AND groupName='" + groupName + "'");
                rs.next();
                standing = rs.getString("seq_in_group") + " \t" + rs.getString("countryName") + " \t" + " " + rs.getString("match_played") + " \t" + rs.getString("goals") + " \t" + rs.getString("points");
                return standing;
            }
            ++x;
            return standing;
        } catch (SQLException e) {
            System.out.println("error" + e);
            return null;
        }
    }
    private int x;
}
