package worldcup2018;

/**
 *
 * @author Michael Mukolwe
 */
public class TeamClass {

    //Team Variables
    private String teamCountry;
    private int matchesPlayed;
    private int matchPoints;
    private int TotalGoalsFor;
    private int TotalGoalsAgainst;
//    private static dataBase db;
    
    //Default constructor
    public TeamClass() {

    }

    //Non-default constructor
    public TeamClass(String teamCountry) throws Exception {
        this.teamCountry = teamCountry;
        this.matchesPlayed = 0;
        this.matchPoints = 0;
        this.TotalGoalsFor = 0;
        this.TotalGoalsAgainst = 0;
    }

    //Accessor Method
    public String getTeamCountry(String teamCountry) {
        return teamCountry;
    }

    public String getTestTeam(String testTeam) {
        return testTeam;
    }

    public int getMatchPoints() {
        return matchPoints;
    }

    public int getTotalGoalsFor() {
        return TotalGoalsFor;
    }

    public int getTotalGoalsAgainst() {
        return TotalGoalsAgainst;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    //Set methods
    public boolean setTeamCountry() {

        return true;
    }

    public boolean setTestTeam() {
        return true;
    }

    public void setMatchPoints() {
        this.matchPoints = 0;
    }

    public void setTotalGoalsFor() {
        this.TotalGoalsFor = 0;
    }

    public void setTotalGoalsAgainst() {
        this.TotalGoalsAgainst = 0;
    }

    public void setMatchesPlayed() {
        this.matchesPlayed = 0;
    }

    //Increment Matches Played
    public int incrementMatchesPlayed(int MatchesPlayed) {
        this.matchesPlayed = matchesPlayed + MatchesPlayed;
        return this.matchesPlayed;
    }

    //Increment Matches Points
    public int incrementMatchPoints(int MatchPoints) {
        this.matchPoints = matchPoints + MatchPoints;
        return this.matchPoints;
    }
    //Increment Goals For

    public int incrementGoalsFor(int toatalGoalsFor) {
        this.TotalGoalsFor = TotalGoalsFor + toatalGoalsFor;
        return this.TotalGoalsFor;
    }
    //Increment Goals Againts

    public int incrementGoalsAgainst(int totalGoalsAgainst) {
        this.TotalGoalsAgainst = TotalGoalsAgainst + totalGoalsAgainst;
        return this.TotalGoalsAgainst;
    }

     
    //toString method
    @Override
    public String toString() {
        return "Country: "+teamCountry + ",\nPoints: " + matchPoints + ",\nTotal Goals Scored: " + TotalGoalsFor + ",\nTotal Goals Conceeded: " + TotalGoalsAgainst + ",\n";
    }
}
