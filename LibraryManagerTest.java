import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for LibraryManager and Game methods.
 */
public class LibraryManagerTest
{
    @Test
    public void testAddGame()
    {
        LibraryManager manager = new LibraryManager();
        Game game = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);

        manager.addGame(game);

        assertEquals(1, manager.getNumberOfGames());
    }

    @Test
    public void testFindGameByTitle()
    {
        LibraryManager manager = new LibraryManager();
        Game game = new Game("Minecraft", Genre.ACTION, Platform.PC);

        manager.addGame(game);

        assertEquals(game, manager.findGameByTitle("Minecraft"));
    }

    @Test
    public void testRemoveGame()
    {
        LibraryManager manager = new LibraryManager();
        Game game = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);

        manager.addGame(game);
        boolean removed = manager.removeGame("FIFA");

        assertTrue(removed);
        assertEquals(0, manager.getNumberOfGames());
    }

    @Test
    public void testSetRating()
    {
        Game game = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);

        game.setRating(4.5);

        assertEquals(4.5, game.getRating(), 0.01);
    }

    @Test
    public void testAverageRating()
    {
        LibraryManager manager = new LibraryManager();
        Game game1 = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);
        Game game2 = new Game("Minecraft", Genre.ACTION, Platform.PC);

        game1.setRating(4.0);
        game2.setRating(5.0);
        manager.addGame(game1);
        manager.addGame(game2);

        assertEquals(4.5, manager.getAverageRating(), 0.01);
    }

    @Test
    public void testEquals()
    {
        Game game1 = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);
        Game game2 = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);

        assertTrue(game1.equals(game2));
    }

    @Test
    public void testToString()
    {
        Game game = new Game("FIFA", Genre.SPORTS, Platform.PLAYSTATION);

        assertTrue(game.toString().contains("FIFA"));
        assertTrue(game.toString().contains("SPORTS"));
    }
}
