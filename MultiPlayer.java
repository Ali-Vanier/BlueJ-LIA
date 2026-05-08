/**
 * Represents a multiplayer game.
 * Authors: Muhammad Ali Babar & Julius Lightburn
 */
public class MultiPlayer extends Game
{
    private int maxPlayers;

    public MultiPlayer(String title, Genre genre, Platform platform, int maxPlayers)
    {
        super(title, genre, platform);
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers()
    {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers)
    {
        this.maxPlayers = maxPlayers;
    }

    public String toString()
    {
        return super.toString() + " | Max players: " + maxPlayers;
    }
}
