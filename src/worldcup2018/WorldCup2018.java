package worldcup2018;

import java.util.Scanner;

/**
 *
 * @author Michael Mukolwe
 */
public class WorldCup2018 {

    //Team Variables
    public static TeamClass team;
    public static GroupClass group;
    public static String teamCountry;
    public static String groupName;
    public static String teamName;
    public static int matchesPlayed;
    public static int matchPoints;
    public static int TotalGoalsFor;
    public static int TotalGoalsAgainst;
    public static String homeTeam, awayTeam, datE, timE;
    public static String homeTeamGoals, awayTeamGoals;
    private static String add = "true";
    private static dataBase db;
    private static String schedule;
    private static String standing[][] = new String[4][5];

    public static void main(String[] args) throws Exception {
        db = new dataBase();
        welcome();
        displayMenu();
    }

    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Welcome to the FIFA World Cup 2018 \n");

    }

    public static void displayMenu() throws Exception {
        int choice = 0;
        while (choice != 7) {
            Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.println("<--- System Menu --->\n");
            System.out.println("1. Add groups");
            System.out.println("2. Add teams to group");
            System.out.println("3. Input match details");
            System.out.println("4. Input match results");
            System.out.println("5. View Current Group Schedule");
            System.out.println("6. View Current Group Standings");
            System.out.println("7. Quit\n");
            System.out.println("What do you want to do:\t");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addGroups(choice);
                    break;
                case 2:
                    addTeams(choice);
                    break;
                case 3:
                    matchDetails();
                    break;
                case 4:
                    matchResults();
                    break;
                case 5:
                    viewSchedule();
                    break;
                case 6:
                    viewStandings();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!!");
                    break;

            }
        }
    }

    public static void addGroups(int choice) throws Exception {

        while (choice != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.println("<--- Group Menu --->\n");
            System.out.println("1. Insert Group Name\n");
            System.out.println("2. Go Back to menu\n");
            System.out.println("Choose\t");
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("WorlCUP 2018 Groups: \n");
                    group = new GroupClass(add);
                    break;
                case 2:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice, try again!!");
                    break;
            }
        }
    }

    public static void addTeams(int choice) throws Exception {
        while (choice != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.println("<--- Team Menu --->\n");
            System.out.println("1. Insert Group Name\n");
            System.out.println("2. Go Back to menu\n");
            System.out.println("Choose\t");
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("WorlCUP 2018 Teams: \n");
                    group = new GroupClass();
                    group.addTeam();
                    break;
                case 2:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice, try again!!");
                    break;
            }
        }
    }

    public static void matchDetails() throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("<--- Team Menu --->\n");

        System.out.println("Insert Group Name:\n");
        groupName = scan.nextLine();
        System.out.println("");
        System.out.println("1. Insert Home Team:\n");
        homeTeam = scan.nextLine();
        System.out.println("");
        System.out.println("2. Insert Away Team:\n");
        awayTeam = scan.nextLine();
        System.out.println("");
        System.out.println("3. Insert Date:\n");
        datE = scan.nextLine();
        System.out.println("");
        System.out.println("4. Insert Time:\n");
        timE = scan.nextLine();
        System.out.println("");

        group = new GroupClass();
        group.setMatchDetails(homeTeam, awayTeam, groupName, datE, timE);
        System.out.println(group.getMatchDetails());
        System.out.println("");
    }

    public static void matchResults() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("<--- Team Menu --->\n");
        System.out.println("1. Insert Home Team:\n");
        homeTeam = scan.nextLine();
        System.out.println("");
        System.out.println(homeTeam + " scored: \n");
        homeTeamGoals = scan.nextLine();
        System.out.println("");
        System.out.println("2.  Insert Away Team:\n");
        awayTeam = scan.nextLine();
        System.out.println("");
        System.out.println(awayTeam + " scored: \n");
        awayTeamGoals = scan.nextLine();
        System.out.println("");
        group = new GroupClass();
        group.setMatchResults(homeTeam, awayTeam, Integer.parseInt(homeTeamGoals), Integer.parseInt(awayTeamGoals));
        System.out.println(group.getMatchResults());
        System.out.println("");
    }

    public static void viewSchedule() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("<--- Team Menu --->\n");
        System.out.println("1. Insert Group Name:\n");
        groupName = scan.nextLine();
        System.out.println("");
        System.out.println("DATE  TIME \t\tHOME \t AWAY");
        System.out.println(dataBase.currentSchedule(groupName));
    }

    public static void viewStandings() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("<--- Team Menu --->\n");
        System.out.println("1. Insert Group Name:\n");
        groupName = scan.nextLine();
        System.out.println("");
        System.out.println("#POSITION COUNTRY MATCHES GOALS POINTS");
        System.out.println(dataBase.currentStanding(groupName));

    }
}
