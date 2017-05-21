package worldcup2018;

import java.util.Scanner;

/**
 *
 * @author Michael Mukolwe
 */
public class GroupClass {

    //DATABASE Object
    dataBase db = new dataBase();
    //GROUP Variables
    public static TeamClass team;
    private String groupName;
    private String teamCountry;
    public static int matchPoints, goalsTotal, match_played;
    public static int homeGoals, awayGoals;
    private static String homeTeam, awayTeam, datE, timE;

    //Non-Default constructor
    public GroupClass(String add) throws Exception {
        Scanner scan = new Scanner(System.in);
        db.newConn();
        String[] units = new String[4];
        int ctr = 1;
        while (ctr <= units.length) {
            boolean valid = false;
            String u = "";
            do {
                System.out.print("Add Group Name e.g A #" + ctr + ": ");
                u = scan.nextLine();
                db.addGroup(u);
                if (u.length() == 0) {
                    System.out.print("Invalid unit!");
                } else {
                    valid = true;
                }
            } while (!valid);
            units[ctr - 1] = u;
            ctr++;
        }

        System.out.println("Your Groups:");
        for (int i = 0; i < units.length; i++) {
            System.out.println("# " + i + "\t" + units[i]);
        }
    }

    //Default constructor
    public GroupClass() {

    }

    public void addTeam() throws Exception {
        Scanner scan = new Scanner(System.in);
        String[] teams = new String[4];
        int ctr = 1;
        while (ctr <= teams.length) {
            boolean valid = false;
            String u = "";
            String v = "";
            do {
                System.out.println("Group Name:");
                v = scan.nextLine();
                setGroupName(v);
                System.out.print("Add Team #" + ctr + ": ");
                u = scan.nextLine();
                dataBase.addTeam(u, v, ctr);
                if (u.length() == 0) {
                    System.out.print("Invalid team!");
                } else {
                    valid = true;
                }
            } while (!valid);
            teams[ctr - 1] = u;
            ctr++;
        }

        System.out.println("Group " + getGroupName(groupName) + " teams:");
        for (int i = 0; i < teams.length; i++) {
            System.out.println("\t" + teams[i]);
        }
    }

    //Accessor 
    public String getTeamCountry(String teamCountry) {
        return teamCountry;
    }

    public String getTestTeam(String testTeam) {
        return testTeam;
    }

    public String getGroupName(String groupName) {
        return groupName;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getGoalsTotal() {
        return goalsTotal;
    }

    public int getMatchesPlayed() {
        return match_played;
    }

    public String getMatchDetails() {
        String dets = "Game Schedule::"
                + "[" + datE + "]\n"
                + timE + " " + homeTeam + " vs " + awayTeam;
        return dets;
    }

    public String getMatchResults() {
        String dets = "[date]\n"
                + "time " + homeTeam + " " + homeGoals + "-" + awayGoals + " " + awayTeam;
        return dets;
    }

    //Set methods
    public boolean setTeamCountry() {

        return true;
    }

    public void setGroupName(String groupName) {

        this.groupName = groupName;
    }

    public boolean setTestTeam() {
        return true;
    }

    public void setMatchPoints() {
        this.matchPoints = 0;
    }

    public void setGoalsTotal() {
        this.goalsTotal = 0;
    }

    public void setMatchesPlayed() {
        this.match_played = 0;
    }

    public void setMatchDetails(String homeTeam, String awayTeam, String groupName, String datE, String timE) throws Exception {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        this.datE = datE;
        this.timE = timE;
        this.groupName = groupName;
        db.matchDetails(this.homeTeam, this.awayTeam, this.groupName, this.datE, this.timE);
    }

    public void setMatchResults(String homeTeam, String awayTeam, int homeGoals, int awayGoals) throws Exception {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        db.matchResults(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals);
        setPoints(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals);
    }

    public void setPoints(String homeTeam, String awayTeam, int homeGoals, int awayGoals) throws Exception {
        //check the winner and award points
        if (homeGoals > awayGoals) {
            this.incrementMatchPoints(homeTeam, homeGoals, 3);
            this.incrementMatchPoints(awayTeam, awayGoals, 0);
        } else if (awayGoals > homeGoals) {
            this.incrementMatchPoints(awayTeam, awayGoals, 3);
            this.incrementMatchPoints(homeTeam, homeGoals, 0);
        } else if (homeGoals == awayGoals) {
            this.incrementMatchPoints(homeTeam, homeGoals, 1);
            this.incrementMatchPoints(awayTeam, awayGoals, 1);
        }
    }

    //Increment Matches Points,Goals & # of matches played for the teams
    public int incrementMatchPoints(String team, int goals, int MatchPoints) throws Exception {
        //get current values
        this.matchPoints = db.getPoints(team);
        this.goalsTotal = db.getGoals(team);
        this.match_played = db.getMatches(team);
        //update values
        this.goalsTotal = goalsTotal + goals;
        this.match_played = match_played + 1;
        this.matchPoints = matchPoints + MatchPoints;
        db.updatePointsGoals(team,this.goalsTotal, this.matchPoints, this.match_played);
        return this.matchPoints;
    }

     
    //toString method
    @Override
    public String toString() {
        return "";
    }

}
