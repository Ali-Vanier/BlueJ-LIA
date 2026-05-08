/**
 * Represents a video game in the library.
 * Authors: Muhammad Ali Babar & Julius Lightburn
 */
public class Game
{
    private Genre genre;
    private Platform platform;
    private String title;
    private double rating;
    private int playTime;

    /**
     * Constructor for objects of class Game.
     */
    public Game(String title, Genre genre, Platform platform)
    {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = 0.0;
        this.playTime = 0;
    }

    public String getTitle()
    {
        return title;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public Platform getPlatform()
    {
        return platform;
    }

    public double getRating()
    {
        return rating;
    }

    public int getPlayTime()
    {
        return playTime;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public void setPlatform(Platform platform)
    {
        this.platform = platform;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public void setPlayTime(int playTime)
    {
        this.playTime = playTime;
    }

    public String toString()
    {
        return title + " | " + genre + " | " + platform + " | Rating: " + rating + " | Play time: " + playTime;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof Game))
        {
            return false;
        }

        Game other = (Game) obj;
        return title.equals(other.title) && genre == other.genre && platform == other.platform;
    }
}
