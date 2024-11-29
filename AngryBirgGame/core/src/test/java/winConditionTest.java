import com.badlogic.gdx.physics.box2d.Body;
import com.chadgpt.win.methods.GameLogic;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class winConditionTest {
    Queue<Body> birdQueue;
    ArrayList<Body> pigList;
    @Before
    public void setUp(){
        birdQueue = new LinkedList<Body>();
        pigList = new ArrayList<>();
    }
    @Test
    public void test1() {
        boolean isWin = GameLogic.checkWinCondition(pigList);
        assertNotEquals("Pig list is emtpy but lost", isWin, false);
    }

}
