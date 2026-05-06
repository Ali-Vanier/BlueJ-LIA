
/**
 * Write a description of class MultiPlayer here.
 *
 * Author: Muhammad Ali Babar & Julius Lightburn
 * @version (a version number or a date)
 */
public class MultiPlayer extends Game
{
    private int maxPlayers;
    public MultiPlayer(String title, Genre genre, int maxPlayers){
        super(title, genre);
        this.maxPlayers=maxPlayers;
    }
}
