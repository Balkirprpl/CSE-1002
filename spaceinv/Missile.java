class Missile {
    
    // fields
    private double x;
    private double y;
    private double dy;
    private double size;
    
    // construct a missile at the given (x,y) location
    public Missile(double x, double y) {
        this.x = x;
        this.y = y;
        dy = 0.01;
        size = 0.05;
    }
    
    // getter for y-coordinate
    public double getY() { return y; }
    
    // get the x-coordate of the tip of the missile
    public double getMissileTipX() { return x; }
    
    // get the y-coordate of the tip of the missile
    public double getMissileTipY() { return y + size; }
    
    // draw the missile
    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x, y, 0.001, size);
    }
    
    // move the missile up
    public void move() {
        y += dy;
    }

} // end Missile