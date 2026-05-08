import java.util.ArrayList;

/**
 * Manages a library of games.
 * Authors: Muhammad Ali Babar & Julius Lightburn
 */
public class LibraryManager
{
    private ArrayList<Game> games;

    public LibraryManager()
    {
        games = new ArrayList<Game>();
    }

    public void addGame(Game game)
    {
        games.add(game);
    }

    public int getNumberOfGames()
    {
        return games.size();
    }

    public Game findGameByTitle(String title)
    {
        for (Game game : games)
        {
            if (game.getTitle().equals(title))
            {
                return game;
            }
        }
        return null;
    }

    public boolean removeGame(String title)
    {
        Game game = findGameByTitle(title);

        if (game != null)
        {
            games.remove(game);
            return true;
        }

        return false;
    }

    public double getAverageRating()
    {
        if (games.size() == 0)
        {
            return 0.0;
        }

        double total = 0.0;

        for (Game game : games)
        {
            total += game.getRating();
        }

        return total / games.size();
    }

    public String toString()
    {
        return "Library has " + games.size() + " games.";
    }
}
