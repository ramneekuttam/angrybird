package com.chadgpt.win.database;
import java.io.Serializable;

public class BodyState implements Serializable {
    private float x, y;              // Position
    private float angle;             // Angle
    private float vx, vy;            // Linear velocity
    private float angularVelocity;   // Angular velocity
    private int entityType;          // Type of entity (e.g., 0 = player, 1 = enemy, etc.)
    private int health;
    private int currentLevel;
    // Constructor
    public BodyState(float x, float y, float angle, float vx, float vy, float angularVelocity, int entityType, int health, int currentLevel) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.vx = vx;
        this.vy = vy;
        this.angularVelocity = angularVelocity;
        this.entityType = entityType;
        this.health = health;
        this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public float getAngularVelocity() {
        return angularVelocity;
    }

    public void setAngularVelocity(float angularVelocity) {
        this.angularVelocity = angularVelocity;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }
}
