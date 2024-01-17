/*
 * Author: Joao 'Gabriel' Silva, jsilva2021@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Snake
*/

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Snake {
   // initializing variables and objects
   static Random rng = new Random();
   static int lengthOfBody = 5;
   static int updateRate = 100;
   static ArrayList<Integer> xPoints = new ArrayList<>();
   static ArrayList<Integer> yPoints = new ArrayList<>();
   static ArrayList<Integer> xPoop = new ArrayList<>();
   static ArrayList<Integer> yPoop = new ArrayList<>();
   static boolean newGame = true;
   static int moveCount = 0;
   static int pointCount = 0;
   static int maxSpeed = 1;
   static final int SCALE = 300;
   static final int UNIVERSENUMBER = 42;
   static final int DOTRADIUS = 5;
   static final int REDPOOP = 165;
   static final int GREENBACKGROUND = 252;
   static final int GNBLIMIT1 = 150;
   static final int GNBLIMIT2 = 200;
   static final int GOODNUMBER20 = 20;
   static final int GOODNUMBER50 = 50;
   static final int GOODNUMBER25 = 25;
   static final double GOODNUMBER02 = 0.2;
   static final double GOODNUMBER01 = 0.1;
   static final int GOODNUMBER12 = 12;
   static final int GOODNUMBER90 = 90;
   static int yFood;
   static int xFood;
   int move = DOTRADIUS * 2;
   int xSnake = 0;
   int ySnake = 0;
   int gAndB = 0;
   boolean colorDirection = true;

   // method to create the manatee snake
   public Snake() {
      lengthOfBody = 5;
      StdDraw.setXscale(-SCALE, SCALE);
      StdDraw.setYscale(-SCALE, SCALE);
      xPoints.add(0);
      yPoints.add(0);
      xPoints.add(move);
      yPoints.add(0);
      xPoints.add(move * 2);
      yPoints.add(0);
      xPoints.add(move * 3);
      yPoints.add(0);
      xPoints.add(move * 4);
      yPoints.add(0);
   }

   public static void main (final String[]  args) {
      StdDraw.setCanvasSize(SCALE, SCALE); // setting the size of the game
      mainMenu(false); // starting the menu
      int run = 1;
      while (true) { // initializing the game if the player hits R
         if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
            StdDraw.setCanvasSize(SCALE, SCALE);
            // resetting counters and creating food x and y
            pointCount = 0;
            updateRate = 100;
            maxSpeed  = 1;
            moveCount = 0;
            xFood = rng.nextInt() % GOODNUMBER25 * 10;
            yFood = rng.nextInt() % GOODNUMBER25 * 10;
            play(); // initializing the game
            lengthOfBody = 0;
            mainMenu(true); // starting the gameover menu 
            // clearing the mess you made
            xPoop.clear();
            yPoop.clear();
            // printing the scores
            System.out.printf("Run #%d%nScore: %d%nHighest speed: %d%n%n",
                     run, pointCount, maxSpeed);
            run++;
         }
      }
   }

   static void mainMenu (final boolean played) {
      StdDraw.setFont(new Font("Comic Sans", Font.BOLD, 16)); // configurating the font
      StdDraw.setXscale(0, 1);
      StdDraw.setYscale(0, 1);
      StdDraw.clear(StdDraw.BLACK);
      StdDraw.setPenColor(StdDraw.CYAN);
      if (played) { // loading the game over cofigurations
         StdDraw.picture(0.5, 0.5, "sad_manatee.png", 1, 1);
         StdDraw.text(0.5, 0.5, "Game Over");
         StdDraw.text(0.5, GOODNUMBER02, "Press R to try again");
      }
      else { // loading the new game configurations
         StdDraw.picture(0.5, 0.5, "manatee.jpg", 1, 1);
         StdDraw.text(0.5, GOODNUMBER02, "Press R to play");
         StdDraw.text(0.5, 0.5, "Manatee the game");
      }
      StdDraw.setFont(new Font("Comic Sans", Font.BOLD, GOODNUMBER12));
      StdDraw.text(0.5, GOODNUMBER01, "(All the scores will be kept on the terminal)");
      StdDraw.show();
   }


   public static void play () {
      boolean playing = false;
      StdDraw.enableDoubleBuffering();
      String key = "";
      final Snake snake = new Snake(); // creating the object
      while (!snake.draw(playing)) { // checking the keys pressed and updating new directions
         snake.setDirection(key);
         if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
            poop();
         }
         if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            if (!key.equals("down")) {
               key = "up";
               playing = true;
            }
         } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            if (!key.equals("up")) {
               key = "down";
               playing = true;
            }
         } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            if (!key.equals("right")) {
               key = "left";
               playing = true;
            }
         } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            if (!key.equals("left")) {
               key = "right";
               playing = true;
            }
         }
      }
   }
   // method draw makes the background, the snake and the food
   public boolean draw (final boolean playing) {
      StdDraw.show(updateRate); // the "speed" that the images are updated
      StdDraw.clear(new Color(3, gAndB, GREENBACKGROUND)); // creating the background
      // changing the background color
      if (gAndB < GNBLIMIT1) colorDirection = true;
      if (gAndB > GNBLIMIT2) colorDirection = false;
      if (colorDirection) gAndB += 10;
      else gAndB -= 10;
      // drawing all poop squares
      StdDraw.setPenColor(REDPOOP, UNIVERSENUMBER, UNIVERSENUMBER);
      for (int i = 0; i < xPoop.size(); i++) {
         StdDraw.filledSquare(xPoop.get(i), yPoop.get(i), DOTRADIUS);
      }
      // creating the food
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.filledSquare(xFood, yFood, DOTRADIUS);

      // making the snake manatee move to the direction it is facing
      if (playing) {
         for (int i = lengthOfBody - 1; i > 0; i--) {
            xPoints.set(i, xPoints.get(i - 1));
            yPoints.set(i, yPoints.get(i - 1));
         }
         xPoints.set(0, xSnake);
         yPoints.set(0, ySnake);
         moveCount++;
      }
      else { // giving the player intructions
         StdDraw.text(0, 0, "WASD to move and SPACE to poop");
         return false;
      }
      // drawing the snake
      for (int i = 0; i < lengthOfBody; i++) {
         StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
         StdDraw.filledSquare(xPoints.get(i), yPoints.get(i), 5);
         StdDraw.setPenColor(StdDraw.GRAY);
         StdDraw.filledSquare(xPoints.get(0), yPoints.get(0), 5);
      }
      // drawing the score and speed markers
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.textLeft(-SCALE + 10, SCALE - GOODNUMBER20, "Score: " + pointCount);
      StdDraw.textLeft(-SCALE + 10, SCALE - GOODNUMBER50, "Speed: "
               + (Math.abs((updateRate / 10) - 10)));
      if ((Math.abs((updateRate / 10) - 10)) > maxSpeed) {
         maxSpeed = (Math.abs((updateRate / 10) - 10));
      }
      // returning if the snake hits the wall or itself
      return checkPoints();
   }

   public static void poop () { // pooping to decrease speed
      xPoop.add(xPoints.get(lengthOfBody - 1));
      yPoop.add(yPoints.get(lengthOfBody - 1));
      if (updateRate < GOODNUMBER90) updateRate += 10;
   }
   // checking the head of the snake to the point it is going to
   boolean checkPoints () {
      if (((Math.abs (xSnake) + DOTRADIUS) > SCALE) 
               || ((Math.abs(ySnake) + 5) > SCALE) 
               || checkCollision()) {
         return true;
      } else if ((xSnake == xFood) && (ySnake == yFood)) {
         snakeAte();
      }
      return false;
   }
   // returning false if the y and x of the head of the snake are the same as
   // and returning true if the head hits the wall of itself to stop the game 
   boolean checkCollision () {
      boolean hitted = false;
      final int xHead = xPoints.get(0);
      final int yHead = yPoints.get(0);
      if (moveCount > lengthOfBody) {
         for (int i = 1; i < lengthOfBody; i++) {
            if ((xHead == xPoints.get(i)) && (yHead == yPoints.get(i))) {
               hitted = true;
            }
         }
      }
      return hitted;
   }

   // adding a dot to the snake object if the head goes over the food y and x
   // also generating different numbers for the new foot to be drawn
   void snakeAte () {
      xPoints.add(move);
      yPoints.add(ySnake);
      if (pointCount >=  3) { // increasing the speed for each food eaten after 3
         updateRate -= 5;
      }
      pointCount++; // increasing points 
      lengthOfBody++; // increasing the length to be drawn
      xFood = rng.nextInt() % GOODNUMBER25 * 10;
      yFood = rng.nextInt() % GOODNUMBER25 * 10;
   }
   // changing the direction depending on the key pressed
   public void setDirection (final String key) {
      if (key.equals("up")) {
         ySnake += move;
      } else if (key.equals("down")) {
         ySnake -= move;
      } else if (key.equals("left")) {
         xSnake -= move;
      } else if (key.equals("right"))  {
         xSnake += move;
      }
   }
}
