class Cannon {
    
    // fields
    private double x; 
    private double y;
    private double size;
    private int score; // not used currently
    
    // construct the cannon in the middle of the screen to start
    public Cannon() {
        y = size / 2;
        size = 0.05;
        score = 0;
    }
    
    // draw the cannon at the current mouse x-coordinate
    public void draw() {
        x = StdDraw.mouseX();
        StdDraw.filledRectangle(x, y, size / 4, size);
        StdDraw.filledRectangle(x, y, size / 2, size / 2);
    }
    
    // fires a missle at the current location
    public Missile shoot() {
        return new Missile(x, size);
    }
    
    
} // end Cannon