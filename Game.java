
/**
 * Write a description of class Game here.
 *
 * Authors: Muhammad Ali Babar & Julius Lightburn
 * @version (a version number or a date)
 */
public class Game
{
    // Attributes
    private Genre genre;
    private Platform platform;
    
    private String title;
    private double rating;
    private int playTime;

    /**
     * Constructor for objects of class Game
     */
    public Game(String title, Genre genre)
    {
        this.title=title;
        this.genre=genre;
        this.platform = platform;
        this.rating=0.0;
        this.playTime=0;
    }
}
