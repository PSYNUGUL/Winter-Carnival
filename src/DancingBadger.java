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
 * Class for modifying DancingBadger constructor and initializing its fields
 */
public class DancingBadger extends StarshipRobot {

  /**
   * Sequence of directions / dance steps for this badger to move
   */
  DanceStep[] danceSteps;

  /**
   * Index of the next step within danceSteps for this badger to move through
   */
  int stepIndex;

  /**
   * Invokes StarshipRobot StarshipRobot constructor Creates constructor for DancingBadger with
   * passed 1d float array and 1d DanceStep array
   * 
   * @param positionArray array of initial position of DancingBadger
   * @param stepArray     array of dance steps that badger has to take
   * @see StarshipRobot#StarshipRobot(float[][])
   * 
   */
  public DancingBadger(float[] positionArray, DanceStep[] stepArray) {
    super(new float[][] {positionArray, stepArray[0].getPositionAfter(positionArray)});
    danceSteps = stepArray;
    this.imageName = "images" + File.separator + "dancingBadger.png";
    this.speed = 2;
    this.isFacingRight = true;
    this.stepIndex = 1;
  }

  /**
   * Overrides the updateDestination() method invoked by StarshipRobot class
   * 
   * Updates destination of badger based on the array of dance steps Increments stepIndex one by one
   * as one step advances
   * 
   * When there is no more step left indicated by array of dance steps, restart from the initial
   * dance step and repeat
   */
  @Override
  protected void updateDestination() {
    this.destination = danceSteps[stepIndex].getPositionAfter(destination);
    stepIndex++;
    if (stepIndex >= danceSteps.length) {
      stepIndex = 0;
    }
  }



}
