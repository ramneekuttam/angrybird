import com.chadgpt.win.database.BodyState;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class bodyStateTest {
    private BodyState entity;

    @Before
    public void setUp() {
        // Initialize the entity with sample values
        entity = new BodyState(1.0f, 2.0f, 30.0f, 1.5f, 2.5f, 0.5f, 0, 100, 0);
    }

    // Test that constructor correctly initializes all fields
    @Test
    public void test1() {
        assertEquals("X position should be 1.0", 1.0f, entity.getX(), 0.01);
        assertEquals("Y position should be 2.0", 2.0f, entity.getY(), 0.01);
        assertEquals("Angle should be 30.0", 30.0f, entity.getAngle(), 0.01);
        assertEquals("Linear velocity X should be 1.5", 1.5f, entity.getVx(), 0.01);
        assertEquals("Linear velocity Y should be 2.5", 2.5f, entity.getVy(), 0.01);
        assertEquals("Angular velocity should be 0.5", 0.5f, entity.getAngularVelocity(), 0.01);
        assertEquals("BodyState type should be 0 (player)", 0, entity.getEntityType());
        assertEquals("Health should be 100", 100, entity.getHealth());
    }

    // Test default constructor with edge values (zero values for position and velocity)
    @Test
    public void test2() {
        BodyState zeroBodyState = new BodyState(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0);
        assertEquals("X position should be 0.0", 0.0f, zeroBodyState.getX(), 0.01);
        assertEquals("Y position should be 0.0", 0.0f, zeroBodyState.getY(), 0.01);
        assertEquals("Angle should be 0.0", 0.0f, zeroBodyState.getAngle(), 0.01);
        assertEquals("Linear velocity X should be 0.0", 0.0f, zeroBodyState.getVx(), 0.01);
        assertEquals("Linear velocity Y should be 0.0", 0.0f, zeroBodyState.getVy(), 0.01);
        assertEquals("Angular velocity should be 0.0", 0.0f, zeroBodyState.getAngularVelocity(), 0.01);
        assertEquals("BodyState type should be 0", 0, zeroBodyState.getEntityType());
        assertEquals("Health should be 0", 0, zeroBodyState.getHealth());
    }

    // Test setter methods by changing the position and velocity
    @Test
    public void test3() {
        entity.setX(10.0f);
        entity.setY(15.0f);
        entity.setVx(3.5f);
        entity.setVy(4.5f);

        assertEquals("X position should be updated to 10.0", 10.0f, entity.getX(), 0.01);
        assertEquals("Y position should be updated to 15.0", 15.0f, entity.getY(), 0.01);
        assertEquals("Velocity X should be updated to 3.5", 3.5f, entity.getVx(), 0.01);
        assertEquals("Velocity Y should be updated to 4.5", 4.5f, entity.getVy(), 0.01);
    }

    // Test health updates
    @Test
    public void test4() {
        entity.setHealth(80);
        assertEquals("Health should be updated to 80", 80, entity.getHealth());

        entity.setHealth(120);
        assertEquals("Health should be updated to 120", 120, entity.getHealth());
    }

    // Test edge case for negative health
    @Test
    public void test5() {
        entity.setHealth(-10);
        assertEquals("Health should be updated to -10", -10, entity.getHealth());
    }

    // Test setter for angular velocity
    @Test
    public void test6() {
        entity.setAngularVelocity(1.5f);
        assertEquals("Angular velocity should be updated to 1.5", 1.5f, entity.getAngularVelocity(), 0.01);
    }

    // Test entity type update
    @Test
    public void test7() {
        entity.setEntityType(1); // Set entity as an enemy
        assertEquals("BodyState type should be 1 (enemy)", 1, entity.getEntityType());

        entity.setEntityType(2); // Set entity as another type
        assertEquals("BodyState type should be 2", 2, entity.getEntityType());
    }

    // Test edge case where entity type is set to an invalid value (negative)
    @Test
    public void test8() {
        entity.setEntityType(-1); // Invalid entity type
        assertEquals("BodyState type should be -1", -1, entity.getEntityType());
    }

    // Test for boundary cases with position and velocity (large values)
    @Test
    public void test9() {
        entity.setX(1000000f);
        entity.setY(1000000f);
        entity.setVx(5000f);
        entity.setVy(5000f);
        assertEquals("X position should be 1000000", 1000000f, entity.getX(), 0.01);
        assertEquals("Y position should be 1000000", 1000000f, entity.getY(), 0.01);
        assertEquals("Velocity X should be 5000", 5000f, entity.getVx(), 0.01);
        assertEquals("Velocity Y should be 5000", 5000f, entity.getVy(), 0.01);
    }

    // Test for boundary cases with small values (close to zero)
    @Test
    public void test10() {
        entity.setX(0.0001f);
        entity.setY(0.0001f);
        entity.setVx(0.0001f);
        entity.setVy(0.0001f);
        assertEquals("X position should be 0.0001", 0.0001f, entity.getX(), 0.00001);
        assertEquals("Y position should be 0.0001", 0.0001f, entity.getY(), 0.00001);
        assertEquals("Velocity X should be 0.0001", 0.0001f, entity.getVx(), 0.00001);
        assertEquals("Velocity Y should be 0.0001", 0.0001f, entity.getVy(), 0.00001);
    }
}
