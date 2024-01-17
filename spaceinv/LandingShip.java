class LandingShip {
    
    // fields
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double size;
    
    // construct a landinship at the given (x,y) coordinate with a random y-velocity
    public LandingShip(double x, double y) {
        this.x = x;
        this.y = y;
        size = 0.05;
        dx = 0;
        dy = Math.random() * 0.015 + 0.001;
    }
    
    // getter for the y coordinate
    public double getY() { return y; }
    
    // draw the landingship
    public void draw() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledEllipse(x, y + size/3, size/4, size/4);
        StdDraw.filledEllipse(x, y, size, size/3);
    }
    
    // simple the landingship's descent
    public void move() {
        if (!hasLanded())
            y -= dy;
    }
    
    // determine whether a missile has hit the landingship
    public boolean detectImpact(Missile m) {
        // ((m.x - x) / size) ^ 2 + ((m.y - y) / size) ^2 <= 1
        double missileTipX = m.getMissileTipX();
        double missileTipY = m.getMissileTipY();
        return (Math.pow((missileTipX - x) / size, 2) + 
                Math.pow((missileTipY - y) / (size/3), 2) <= 1);
    }
    
    // returns whether or not the landing ship has landed
    public boolean hasLanded() {
        return y <= -0.05;
    }
} // end LandingShip