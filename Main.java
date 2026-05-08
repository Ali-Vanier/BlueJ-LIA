import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for the Game Library application.
 * Provides an interactive text-based menu for managing a game library.
 *
 * Authors: Muhammad Ali Babar & Julius Lightburn
 * Date: 2026
 */
public class Main
{
    private static LibraryManager library = new LibraryManager();
    private static ArrayList<String> sessionLog = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main method - entry point of the application.
     */
    public static void main(String[] args)
    {
        loadSampleGames();

        int choice = -1;

        System.out.println("       Welcome to Game Library!         ");

        while (choice != 0)
        {
            printMenu();
            choice = getIntInput("Enter your choice: ");

            switch (choice)
            {
                case 1:
                    printLibraryDetails();
                    break;
                case 2:
                    listAllGames();
                    break;
                case 3:
                    listGamesByFilter();
                    break;
                case 4:
                    listTopRatedGames();
                    break;
                case 5:
                    printGameDetails();
                    break;
                case 6:
                    rateGame();
                    break;
                case 7:
                    startGameSession();
                    break;
                case 8:
                    printSessionLog();
                    break;
                case 9:
                    addYourOwnGame();
                    break;
                case 0:
                    System.out.println("\nThank you for using Game Library. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Prints the main menu options.
     */
    private static void printMenu()
    {
        System.out.println("\n========================================");
        System.out.println("              MAIN MENU                 ");
        System.out.println("========================================");
        System.out.println("  1. Print library details");
        System.out.println("  2. List all games");
        System.out.println("  3. List games by genre, platform");
        System.out.println("  4. List top-rated games");
        System.out.println("  5. Print game details");
        System.out.println("  6. Rate a game");
        System.out.println("  7. Start a game session");
        System.out.println("  8. Print game session log");
        System.out.println("  9. Add your own game");
        System.out.println("  0. EXIT");
        System.out.println("========================================");
    }

    /**
     * Prints overall library details including total games and average rating.
     */
    private static void printLibraryDetails()
    {
        System.out.println("\n--- Library Details ---");
        System.out.printf("%-25s %s%n", "Total games:", library.getNumberOfGames());
        System.out.printf("%-25s %.2f%n", "Average rating:", library.getAverageRating());
    }

    /**
     * Lists all games in the library.
     */
    private static void listAllGames()
    {
        System.out.println("\n--- All Games ---");

        if (library.getNumberOfGames() == 0)
        {
            System.out.println("No games in the library.");
            return;
        }

        System.out.printf("%-5s %-20s %-12s %-12s %-8s %-10s%n",
            "#", "Title", "Genre", "Platform", "Rating", "Play Time");
        System.out.println("-".repeat(75));

        ArrayList<Game> games = library.getGames();
        for (int i = 0; i < games.size(); i++)
        {
            Game g = games.get(i);
            System.out.printf("%-5d %-20s %-12s %-12s %-8.1f %-10d hrs%n",
                (i + 1), g.getTitle(), g.getGenre(), g.getPlatform(),
                g.getRating(), g.getPlayTime());
        }
    }

    /**
     * Lists games filtered by genre or platform.
     */
    private static void listGamesByFilter()
    {
        System.out.println("\n--- Filter Games ---");
        System.out.println("1. By Genre");
        System.out.println("2. By Platform");

        int filterChoice = getIntInput("Choose filter: ");

        if (filterChoice == 1)
        {
            System.out.println("\nAvailable genres:");
            Genre[] genres = Genre.values();
            for (int i = 0; i < genres.length; i++)
            {
                System.out.println("  " + (i + 1) + ". " + genres[i]);
            }

            int genreChoice = getIntInput("Choose genre number: ") - 1;

            if (genreChoice < 0 || genreChoice >= genres.length)
            {
                System.out.println("Invalid choice.");
                return;
            }

            Genre selectedGenre = genres[genreChoice];
            System.out.println("\n--- Games in genre: " + selectedGenre + " ---");

            boolean found = false;
            for (Game g : library.getGames())
            {
                if (g.getGenre() == selectedGenre)
                {
                    System.out.println("  " + g.getTitle() + " | " + g.getPlatform() + " | Rating: " + g.getRating());
                    found = true;
                }
            }

            if (!found)
            {
                System.out.println("No games found for this genre.");
            }
        }
        else if (filterChoice == 2)
        {
            System.out.println("\nAvailable platforms:");
            Platform[] platforms = Platform.values();
            for (int i = 0; i < platforms.length; i++)
            {
                System.out.println("  " + (i + 1) + ". " + platforms[i]);
            }

            int platformChoice = getIntInput("Choose platform number: ") - 1;

            if (platformChoice < 0 || platformChoice >= platforms.length)
            {
                System.out.println("Invalid choice.");
                return;
            }

            Platform selectedPlatform = platforms[platformChoice];
            System.out.println("\n--- Games on platform: " + selectedPlatform + " ---");

            boolean found = false;
            for (Game g : library.getGames())
            {
                if (g.getPlatform() == selectedPlatform)
                {
                    System.out.println("  " + g.getTitle() + " | " + g.getGenre() + " | Rating: " + g.getRating());
                    found = true;
                }
            }

            if (!found)
            {
                System.out.println("No games found for this platform.");
            }
        }
        else
        {
            System.out.println("Invalid choice.");
        }
    }

    /**
     * Lists the top 3 rated games in the library.
     */
    private static void listTopRatedGames()
    {
        System.out.println("\n--- Top Rated Games ---");

        if (library.getNumberOfGames() == 0)
        {
            System.out.println("No games in the library.");
            return;
        }

        ArrayList<Game> games = library.getGames();
        ArrayList<Game> sorted = new ArrayList<Game>(games);

        // Bubble sort by rating descending
        for (int i = 0; i < sorted.size() - 1; i++)
        {
            for (int j = 0; j < sorted.size() - 1 - i; j++)
            {
                if (sorted.get(j).getRating() < sorted.get(j + 1).getRating())
                {
                    Game temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }

        int limit = Math.min(3, sorted.size());
        System.out.printf("%-5s %-20s %-8s%n", "Rank", "Title", "Rating");
        System.out.println("-".repeat(35));

        for (int i = 0; i < limit; i++)
        {
            System.out.printf("%-5d %-20s %-8.1f%n", (i + 1), sorted.get(i).getTitle(), sorted.get(i).getRating());
        }
    }

    /**
     * Prints detailed info about a specific game.
     */
    private static void printGameDetails()
    {
        System.out.println("\n--- Print Game Details ---");
        System.out.print("Enter game title: ");
        String title = scanner.nextLine().trim();

        Game game = library.findGameByTitle(title);

        if (game == null)
        {
            System.out.println("Game not found.");
            return;
        }

        System.out.println("\n" + game.toString());

        if (game instanceof OnlineGame)
        {
            OnlineGame og = (OnlineGame) game;
            System.out.println("Type: Online Game");
            System.out.println("Internet Required: " + og.getInternetRequired());
            System.out.println("Max Players: " + og.getMaxPlayers());
        }
        else if (game instanceof MultiPlayer)
        {
            MultiPlayer mp = (MultiPlayer) game;
            System.out.println("Type: Multiplayer Game");
            System.out.println("Max Players: " + mp.getMaxPlayers());
        }
        else if (game instanceof SinglePlayer)
        {
            SinglePlayer sp = (SinglePlayer) game;
            System.out.println("Type: Single Player Game");
            System.out.println("Difficulty: " + sp.getDifficultyLevel());
        }
    }

    /**
     * Allows the user to rate a game.
     */
    private static void rateGame()
    {
        System.out.println("\n--- Rate a Game ---");
        System.out.print("Enter game title: ");
        String title = scanner.nextLine().trim();

        Game game = library.findGameByTitle(title);

        if (game == null)
        {
            System.out.println("Game not found.");
            return;
        }

        double rating = -1;
        while (rating < 0 || rating > 5)
        {
            rating = getDoubleInput("Enter rating (0.0 - 5.0): ");
            if (rating < 0 || rating > 5)
            {
                System.out.println("Rating must be between 0.0 and 5.0.");
            }
        }

        game.setRating(rating);
        System.out.println("Rating updated successfully for \"" + title + "\"!");
    }

    /**
     * Starts a game session and logs it.
     */
    private static void startGameSession()
    {
        System.out.println("\n--- Start a Game Session ---");
        System.out.print("Enter game title: ");
        String title = scanner.nextLine().trim();

        Game game = library.findGameByTitle(title);

        if (game == null)
        {
            System.out.println("Game not found.");
            return;
        }

        int hours = -1;
        while (hours < 0)
        {
            hours = getIntInput("Enter hours played this session: ");
            if (hours < 0)
            {
                System.out.println("Hours must be a positive number.");
            }
        }

        game.setPlayTime(game.getPlayTime() + hours);

        String logEntry = "Played \"" + title + "\" for " + hours + " hour(s). Total play time: " + game.getPlayTime() + " hrs.";
        sessionLog.add(logEntry);

        System.out.println("Session started! " + logEntry);
    }

    /**
     * Prints the game session log.
     */
    private static void printSessionLog()
    {
        System.out.println("\n--- Game Session Log ---");

        if (sessionLog.isEmpty())
        {
            System.out.println("No sessions recorded yet.");
            return;
        }

        for (int i = 0; i < sessionLog.size(); i++)
        {
            System.out.println("  " + (i + 1) + ". " + sessionLog.get(i));
        }
    }

    /**
     * Allows the user to add their own game to the library.
     */
    private static void addYourOwnGame()
    {
        System.out.println("\n--- Add Your Own Game ---");

        System.out.print("Enter game title: ");
        String title = scanner.nextLine().trim();

        // Choose genre
        System.out.println("\nAvailable genres:");
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++)
        {
            System.out.println("  " + (i + 1) + ". " + genres[i]);
        }
        int genreChoice = getIntInput("Choose genre number: ") - 1;
        if (genreChoice < 0 || genreChoice >= genres.length)
        {
            System.out.println("Invalid genre.");
            return;
        }
        Genre genre = genres[genreChoice];

        // Choose platform
        System.out.println("\nAvailable platforms:");
        Platform[] platforms = Platform.values();
        for (int i = 0; i < platforms.length; i++)
        {
            System.out.println("  " + (i + 1) + ". " + platforms[i]);
        }
        int platformChoice = getIntInput("Choose platform number: ") - 1;
        if (platformChoice < 0 || platformChoice >= platforms.length)
        {
            System.out.println("Invalid platform.");
            return;
        }
        Platform platform = platforms[platformChoice];

        // Choose game type
        System.out.println("\nGame type:");
        System.out.println("  1. Single Player");
        System.out.println("  2. Multiplayer");
        System.out.println("  3. Online Game");
        int typeChoice = getIntInput("Choose type: ");

        Game newGame = null;

        if (typeChoice == 1)
        {
            System.out.print("Enter difficulty level (Easy/Medium/Hard): ");
            String difficulty = scanner.nextLine().trim();
            newGame = new SinglePlayer(title, genre, platform, difficulty);
        }
        else if (typeChoice == 2)
        {
            int maxPlayers = getIntInput("Enter max number of players: ");
            newGame = new MultiPlayer(title, genre, platform, maxPlayers);
        }
        else if (typeChoice == 3)
        {
            int maxPlayers = getIntInput("Enter max number of players: ");
            System.out.print("Internet required? (yes/no): ");
            String internetInput = scanner.nextLine().trim().toLowerCase();
            boolean internetRequired = internetInput.equals("yes");
            newGame = new OnlineGame(title, genre, platform, maxPlayers, internetRequired);
        }
        else
        {
            System.out.println("Invalid type.");
            return;
        }

        library.addGame(newGame);
        System.out.println("\nGame \"" + title + "\" added successfully!");
    }

    /**
     * Helper method to safely read an integer from the user.
     */
    private static int getIntInput(String prompt)
    {
        int value = -1;
        boolean valid = false;

        while (!valid)
        {
            System.out.print(prompt);
            try
            {
                value = Integer.parseInt(scanner.nextLine().trim());
                valid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number.");
            }
        }

        return value;
    }

    /**
     * Helper method to safely read a double from the user.
     */
    private static double getDoubleInput(String prompt)
    {
        double value = -1;
        boolean valid = false;

        while (!valid)
        {
            System.out.print(prompt);
            try
            {
                value = Double.parseDouble(scanner.nextLine().trim());
                valid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number.");
            }
        }

        return value;
    }

    /**
     * Loads sample games into the library at startup.
     */
    private static void loadSampleGames()
    {
        library.addGame(new SinglePlayer("Call Of Duty", Genre.RPG, Platform.PC, "Hard"));
        library.addGame(new SinglePlayer("Hollow Knight", Genre.ACTION, Platform.NINTENDO, "Medium"));
        library.addGame(new MultiPlayer("FIFA 25", Genre.SPORTS, Platform.PLAYSTATION, 22));
        library.addGame(new OnlineGame("Fortnite", Genre.ACTION, Platform.PC, 100, true));
        library.addGame(new OnlineGame("Rocket League", Genre.SPORTS, Platform.XBOX, 6, true));

        library.findGameByTitle("Call Of Duty").setRating(4.9);
        library.findGameByTitle("Hollow Knight").setRating(4.7);
        library.findGameByTitle("FIFA 25").setRating(3.8);
        library.findGameByTitle("Fortnite").setRating(3.5);
        library.findGameByTitle("Rocket League").setRating(4.2);
    }
}
