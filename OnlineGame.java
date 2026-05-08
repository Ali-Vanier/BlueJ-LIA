/**
 * Represents an online multiplayer game.
 * Authors: Muhammad Ali Babar & Julius Lightburn
 */
public class OnlineGame extends MultiPlayer
{
    private boolean internetRequired;

    public OnlineGame(String title, Genre genre, Platform platform, int maxPlayers, boolean internetRequired)
    {
        super(title, genre, platform, maxPlayers);
        this.internetRequired = internetRequired;
    }

    public boolean getInternetRequired()
    {
        return internetRequired;
    }

    public void setInternetRequired(boolean internetRequired)
    {
        this.internetRequired = internetRequired;
    }

    public String toString()
    {
        return super.toString() + " | Internet required: " + internetRequired;
    }
}
