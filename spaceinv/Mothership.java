class Mothership {
    
    // fields
    private double x;
    private double y;
    private double dx;
    private double size;
    private int health;  // not used currently
    
    // construct the mothership at a random x-coordinate
    public Mothership() {
        x = Math.random();
        y = 0.95;
        size = 0.18;
        dx = 0.02;
    }
    
    // draw the mothership
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledEllipse(x, y + size/3, size/4, size/4);
        StdDraw.filledEllipse(x, y, size, size/3);
    }
    
    // move the mothership back and forth across the top of the machine
    public void move() {
        x += dx;
        if (x < 0) {
            x = 0;
            dx = -dx;
        } else if (x > 1) {
            x = 1;
            dx = -dx;
        }
    }
    
    // handle missile impacts with the mothership -- not used currently
    public boolean detectImpact(Missile m) {
        return false;
    }
    
    // release landing ship at current location
    public LandingShip releaseLandingShip() {
        return new LandingShip(x, y);
    }
    
}   // end Mothership