/**
 * Represents a single player game.
 * Authors: Muhammad Ali Babar & Julius Lightburn
 */
public class SinglePlayer extends Game
{
    private String difficultyLevel;

    public SinglePlayer(String title, Genre genre, Platform platform, String difficultyLevel)
    {
        super(title, genre, platform);
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel()
    {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
    }

    public String toString()
    {
        return super.toString() + " | Difficulty: " + difficultyLevel;
    }
}
