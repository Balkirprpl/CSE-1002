/** Space Invaders program
  * Built in-class in CIS 110 at the University of Pennsylvania in Fall 2013
  * 
  * This program is built around the SketchFramework code discussed earlier in class.
  */

import java.util.ArrayList;

public class SpaceInvaders {
    
    // use this main method verbatim
    public static void main(String[] args) {
        // setup the sketch
        setup();
        // drawing and interaction loop
        boolean justPressedMouse = false;
        while(true) {
            draw();
            if (StdDraw.mousePressed()) {
                if (!justPressedMouse) mouseClicked();
                mousePressed();
                justPressedMouse = true;
            } else {
                justPressedMouse = false;
            }
            StdDraw.show(20);
        }
    }
    
    
    ///////////////////////////////////////////////
    //   Objects in game
    ///////////////////////////////////////////////
    static Mothership mothership = new Mothership();
    
    static ArrayList<LandingShip> landingShips = new ArrayList<LandingShip>();
    
    static ArrayList<Missile> missiles = new ArrayList<Missile>();
    
    static Cannon cannon = new Cannon();
    
    
    ///////////////////////////////////////////////
    //   Methods to run game
    ///////////////////////////////////////////////
    
    // setup is called once to initialize everything
    public static void setup() {
        // empty
    }
    
    // draw one frame of animation
    public static void draw() {
        
        //  draw background
        StdDraw.clear(StdDraw.WHITE);
        
        // draw and handle mothership movements
        mothership.draw();
        mothership.move();
        
        // draw cannon
        cannon.draw();
        

        // draw and update all released landingships, removing ships hit by missles
        for (int i = 0; i < landingShips.size(); i++) {
            // draw and move landship
            LandingShip ship = landingShips.get(i);
            ship.draw();
            ship.move();
            
            // remove offscreen ships
            /*if (ship.hasLanded()) {
                landingShips.remove(i);
                i--;
                StdDraw.clear(StdDraw.RED);
                continue; // skip detecting impact since ship deleted anyway
            }*/
            
            // delete ships hit by missiles
            for (int j = 0; j < missiles.size(); j++) {
                if (ship.detectImpact(missiles.get(j))) {
                    landingShips.remove(i);
                    i--;
                    break;
                }
            }
        }
        
        // draw and move all missles
        for (int i = 0; i < missiles.size(); i++) {
            // draw missiles
            Missile m = missiles.get(i);
            m.draw();
            m.move();
            // remove offscreen missiles
            if (m.getY() > 2) {
                missiles.remove(i);
                i--;
            }
        }
        
        
        // have the mothership release a new landing ship with some probability
        if (Math.random() < 0.02) {
            landingShips.add(mothership.releaseLandingShip());
        }
    }
    
    // called whenever the mouse is pressed
    public static void mousePressed() {
        // empty
    }
    
    // called once when the mouse is clicked
    public static void mouseClicked() {
        // release a new missile whenever the mouse is clicked
        missiles.add(cannon.shoot());
    }
     
}  // end SpaceInvaders