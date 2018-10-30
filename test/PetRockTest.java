
import org.junit.*;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PetRockTest {
    private PetRock rocky =new PetRock("Rocky");
//
//    @BeforeClass //only happen once
////    @Before
////    //before each test case run do this thing
////    public void setUp() throws Exception {
////
////    }
    //Timeout rule:
    @Rule
    public Timeout globalTimeout=Timeout.seconds(10);
    @Test
    public void getName() {

        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Ignore ("Exception thrown not yet define")
    @Test (expected=IllegalStateException.class)
    public void nameFail() throws Exception {
        rocky.getHappyMessage();
    }

    @Test
    public void name() throws Exception {
        rocky.playWithRock();
        String msg=rocky.getHappyMessage();
        assertEquals("I'm happy", msg);
    }

    @Test
    public void testFavNum() {
        assertEquals(42, rocky.getFavNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyNameFail() throws Exception {
        new PetRock("");
    }

    @Test (timeout=100) //100ms
    public void waitForHappyTimeout() {
        rocky.waitTillHappy();
    }
}