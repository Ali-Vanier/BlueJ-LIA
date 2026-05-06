
/**
 * Write a description of class SinglePlayer here.
 *
 * Authors: Muhammad Ali Babar & Julius Lightburn
 * @version (a version number or a date)
 */
public class SinglePlayer extends Game
{
    private String difficultyLevel;
    public SinglePlayer(String title,Genre genre, String difficulty){
        super(title, genre);
        this.difficultyLevel=difficulty;
    }
}
