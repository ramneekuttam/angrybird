# Angry Bird Clone
##Created by
- [Anveshan Khanna](https://github.com/AnveshanK)
- [Ramneek Uttam](https://www.github.com/ramneekuttam)
```markdown
# 🐦 Angry Birds Game (LibGDX + Java)

Welcome to the **Angry Birds Game** project!  
This project recreates the iconic Angry Birds experience using the **LibGDX framework** in **Java**, with a strong focus on **object-oriented programming** and **advanced programming techniques**. Unit testing is integrated using **JUnit**.

---

## 🚀 Setup Instructions

To set up, run, and test the project, follow these steps:

### ✅ Prerequisites

- Java Development Kit (JDK) **version 8 or above**
- **IntelliJ IDEA** (Community or Ultimate)
- **LibGDX Framework**
- **JUnit**

### 📦 Installation & Running the Game

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ramneekuttam/angrybird
   ```

2. **Open in IntelliJ:**
   - Launch IntelliJ and open the cloned folder.
   - If prompted, **import as a Gradle project**.

3. **Run the game:**
   - Open the **Gradle toolbar**.
   - Navigate to: `Tasks > application > lwjgl3:run`
   - Double-click `lwjgl3:run` to launch the game using the LWJGL3 backend.

If everything is working, you’ll see the **Loading Page**. You're ready to play!

---

## 🎮 Game Features

- **3 Default Levels**:  
  - 4 birds  
  - 3 pigs  
  - Structures made of **stone**, **wood**, and **ice** in various shapes
- **Realistic Physics**:
  - Collision detection
  - Health system for all entities
  - Angular damping for rotation control
- **Victory Condition**:  
  Eliminate all pigs to win the level.
- **Trajectory Mechanics**:
  Birds launch in the opposite direction of drag for a realistic slingshot feel

---

## 🌟 Bonus Features

- **Power Abilities**:
  - 🔥 **Black Bird**: Explosion/blast damage
  - ⚡ **Yellow Bird**: Speed burst to increase impact
- **Earthquake Mechanic**:  
  Adds random impulses to structures to spice up gameplay
- **Sandbox Mode**:
  - Design custom levels
  - Choose birds, pigs, and structures
  - Save and load your creations
- **🎵 Background Music** for immersive gameplay

---

## 💾 Save/Load Support (Serialization)

You can **save** your current game state and **load** it later, even after restarting the game.

---

## ✅ JUnit Testing

- **Location**: `core/src/test/java`
- **Run Tests**:
  - Right-click on the test directory in IntelliJ
  - Click **Run Tests**

The test suite includes logic checks like `checkWinCondition` and more.

---

## 🗂️ Project Structure

```
.
├── core/
│   ├── src/                # Main game logic and screens
│   └── test/java/          # JUnit test files
├── lwjgl3/                 # LWJGL3 launcher code
├── assets/                 # Images, sound files, etc.
├── build.gradle            # Gradle build config
├── README.md               # Project documentation
```

---

## 📚 Resources & Credits

- **LibGDX Documentation**:  
  [https://libgdx.com/wiki/](https://libgdx.com/wiki/)
- **Tutorial Acknowledgment**:  
  Thanks to **dermetfan** for tutorials and sample resources
- **Assets**:  
  Images and sounds from free internet sources or created via **Canva**

---

## 📊 UML Diagram

View the UML diagram for this project here:  
[🔗 UML on Lucidchart](https://lucid.app/lucidchart/f52efb61-4c77-459d-83f9-aaa117162de2/edit?viewport_loc=-768%2C87%2C6972%2C3591%2CtGHv_QCDIsuB&invitationId=inv_a6f47a5b-2745-4f9b-b1d1-e950a6bd12)

---

## 📌 License

This project is for educational purposes. Attribution for any reused assets is appreciated.  
Feel free to fork and build upon it!

---

Happy bird-flinging! 🐦💥🏗️
```

