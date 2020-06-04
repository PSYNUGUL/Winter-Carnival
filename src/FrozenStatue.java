//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 WinterCarnival
// Files: FrozenStatue.java, StarshipRobot.java, DancingBadger.java, WinterCarnival.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * Class for modifying FrozenStatue constructor and initializing its fields
 */
public class FrozenStatue {

  /**
   * Horizontal position of this object in pixels from 0-left to 800-right
   */
  protected float x;

  /**
   * Vertical position of this object in pixels from 0-top to 600-bottom
   */
  protected float y;

  /**
   * Used to mirror image (flip left to right) only when this field is false
   */
  protected boolean isFacingRight = true;

  /**
   * Relative path to the image file (from the working directory)
   */
  protected String imageName = "images" + File.separator + "frozenStatue.png";

  /**
   * Initializes x and y based on passed 1d array of statue's position
   * 
   * @param positionArray array of statue's position
   */
  public FrozenStatue(float[] positionArray) {
    for (int i = 0; i < 2; i++) {
      if (i == 0) {
        this.x = positionArray[i];
      }
      if (i == 1) {
        this.y = positionArray[i];
      }
    }
  }

  /**
   * Creates function for visualizing the statue
   * 
   * @param engine parameter given by P05.jar at SimulationEngine.class
   */
  public void update(SimulationEngine engine) {
    engine.draw(imageName, x, y, isFacingRight);
  }
}
