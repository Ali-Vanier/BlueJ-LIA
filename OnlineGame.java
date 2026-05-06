
/**
 * Write a description of class OnlineGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OnlineGame extends MultiPlayer
{
    private boolean internetRequired;
    public OnlineGame(String title, Genre genre, int maxPlayers, boolean internet){
        super(title, genre, maxPlayers);
        this.internetRequired=internet;
    }
}
