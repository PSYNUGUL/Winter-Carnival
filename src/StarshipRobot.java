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
 * Class for modifying StarshipRobot constructor and initializing its fields
 */
public class StarshipRobot extends FrozenStatue {

  /**
   * Array of two positions, that this robot moves back and forth between the contents of this 2d
   * array are organized as follows: { { beginX, beginY }, { endX, endY }}
   */
  protected float[][] beginAndEnd;

  /**
   * Position that this robot is currently moving towards
   */
  protected float[] destination;

  /**
   * Speed in pixels that this robot moves during each update
   */
  protected float speed;

  /**
   * Invokes constructor of FrozenStatue Creates a constructor of StarshipRobot using passed 2d
   * float array of its position and destination
   * 
   * Initializes its speed, direction, and image name
   * 
   * @param positionArray array consisting initial position and destination position
   * @see FrozenStatue#FrozenStatue(float[])
   */
  public StarshipRobot(float[][] positionArray) {
    // initial x and y position
    super(positionArray[0]);

    // destination = end position
    destination = positionArray[1];

    this.speed = 6;
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "starshipRobot.png";
  }

  /**
   * Determines whether StarshipRobot is correctly heading toward destination position and whether
   * it faces right or left based on calculation
   * 
   * @return true when StarshipRobot is correctly moving toward destination position
   */
  protected boolean moveTowardDestination() {
    double initialDistance =
        Math.sqrt(Math.pow(this.x - destination[0], 2) + Math.pow(this.y - destination[1], 2));
    this.x = (float) (x + ((speed * (destination[0] - x)) / initialDistance));
    this.y = (float) (y + ((speed * (destination[1] - y)) / initialDistance));

    if (destination[0] > this.x) {
      this.isFacingRight = true;
    } else {
      this.isFacingRight = false;
    }

    if (initialDistance < (2 * speed)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Updates destination of the StarshipRobot by switching destination coordinate
   */
  protected void updateDestination() {
    this.destination[0] = this.y;
    this.destination[1] = this.x;
  }

  /**
   * Overrides the update() method invoked by FrozenStatue If StarshipRobot is correctly heading
   * toward destination position, invoke the updateDestination() method
   * 
   * Invokes update(SimulationEngine engine) method from FrozneStatue to make a function to
   * visualize StarshipRobot
   * 
   * @param engine parameter given by P05.jar at SimulationEngine.class
   * @see FrozenStatue#update(SimulationEngine)
   */
  @Override
  public void update(SimulationEngine engine) {
    // if default isFacingRight = true, no need to flip again
    if (isFacingRight) {
      this.isFacingRight = false;
    } else {
      this.isFacingRight = true;
    }

    super.update(engine);
    if (moveTowardDestination() == true) {
      updateDestination();
    }
  }
}
