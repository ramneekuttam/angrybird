import com.badlogic.gdx.math.Vector2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.chadgpt.win.methods.methods;

public class methodTest {
    private Vector2 dragAreaCenter;
    private float dragAreaRadius;

    @Before
    public void setup() {
        // This method runs before each test, providing common setup
        dragAreaCenter = new Vector2(5, 5); // Center of drag area
        dragAreaRadius = 2.5f; // Radius of drag area
    }

    @Test
    public void testIsInsideDragArea_Inside() {
        // Test where touch is inside the drag area
        Vector2 touch = new Vector2(5, 6);
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertTrue("Touch should be inside the drag area", isInside);
    }

    @Test
    public void testIsInsideDragArea_ExactlyOnEdge() {
        // Test where touch is exactly on the boundary of the drag area
        Vector2 touch = new Vector2(5, 7.5f); // Distance should be exactly equal to radius
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertTrue("Touch should be inside or on the edge of the drag area", isInside);
    }

    @Test
    public void testIsInsideDragArea_Outside() {
        // Test where touch is outside the drag area
        Vector2 touch = new Vector2(8, 8);
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertFalse("Touch should be outside the drag area", isInside);
    }

    @Test
    public void testIsInsideDragArea_NegativeCoordinates() {
        // Test with negative coordinates
        Vector2 touch = new Vector2(-1, -1);
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertFalse("Touch with negative coordinates should be outside the drag area", isInside);
    }

    @Test
    public void testIsInsideDragArea_CenterTouch() {
        // Test where touch is exactly at the center of the drag area
        Vector2 touch = new Vector2(5, 5); // Center of the drag area
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertTrue("Touch at the center should be inside the drag area", isInside);
    }

    @Test
    public void testIsInsideDragArea_LargeRadius() {
        // Test with a large drag area radius
        dragAreaRadius = 10f;
        Vector2 touch = new Vector2(10, 10);
        boolean isInside = methods.isInsideDragArea(touch, dragAreaCenter, dragAreaRadius);
        Assert.assertTrue("Touch should be inside the drag area with a large radius", isInside);
    }
}
