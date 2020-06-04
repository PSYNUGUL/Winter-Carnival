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

import java.util.ArrayList;

/**
 * Class for implementing FrozenStatue, StarshipRobot, DancingBadger into WinterCarnival
 */
public class WinterCarnival extends SimulationEngine {
  /**
   * Array list consisting of constructors from FrozenStatue, StarshipRobot, and DancingBadger
   */
  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();

  /**
   * Implements various constructors in one constructor called WinterCarnival() by adding them to
   * the array list
   */
  public WinterCarnival() {
    float[] statue1_pos = {600, 100};
    float[] statue2_pos = {200, 500};
    FrozenStatue statue1 = new FrozenStatue(statue1_pos);
    FrozenStatue statue2 = new FrozenStatue(statue2_pos);
    objects.add(statue1);
    objects.add(statue2);

    float[][] starship1_pos = {{0, 0}, {600, 100}};
    float[][] starship2_pos = {{800, 300}, {200, 500}};
    StarshipRobot starship1 = new StarshipRobot(starship1_pos);
    StarshipRobot starship2 = new StarshipRobot(starship2_pos);
    objects.add(starship1);
    objects.add(starship2);

    float[] badger1_pos = {304, 268};
    float[] badger2_pos = {368, 268};
    float[] badger3_pos = {432, 268};
    float[] badger4_pos = {492, 268};
    DanceStep[] dance =
        {DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left, DanceStep.Down,
            DanceStep.Left, DanceStep.Right, DanceStep.Right, DanceStep.Left, DanceStep.Up};
    DancingBadger badger1 = new DancingBadger(badger1_pos, dance);
    DancingBadger badger2 = new DancingBadger(badger2_pos, dance);
    DancingBadger badger3 = new DancingBadger(badger3_pos, dance);
    DancingBadger badger4 = new DancingBadger(badger4_pos, dance);
    objects.add(badger1);
    objects.add(badger2);
    objects.add(badger3);
    objects.add(badger4);
  }

  /**
   * Overrides the update()method provided from P05.jar at SimulationEngine.class Inspects the array
   * list and calls update() method for each element
   * 
   * @see SimulationEngine#update()
   **/
  @Override
  public void update() {
    // updates FrozenStatue in the Array list
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).update(this);
    }
  }

  public static void main(String[] args) {
    WinterCarnival f = new WinterCarnival();
  }
}
