import java.lang.Math;

// Creates a circle class
public class Circle {
//  fields of a circle
    private Point center;
    private double radius;
    private double x;
    private double y;

//   Constructors
    public Circle(double x, double y, double r) {
        center = new Point(x, y);
        radius = r;
    }
    public Circle() {
        center = new Point(0,0);
        radius = 1;
    }
    public Circle(Point point, double r) {
        center = new Point(point);
        radius = r;
    }
    public Circle(Circle c) {
        center = new Point(c.getCenter());
        radius = c.getRadius();
    }

//  get methods
    public double getRadius() {
        return radius;
    }
    public Point getCenter() {
        return center;
    }
    public double getX() {
        return center.getX();
    }
    public double getY() {
        return center.getY();
    }

//   set methods
    public void setRadius(double length) {
        radius = length;
    }
    public void setCenter(Point centerPoint) {
        center = new Point(centerPoint);
    }
    public void setX(double coordinate) {
        center.setX(coordinate);
    }
    public void setY(double coordinate) {
        center.setY(coordinate);
    }

    /**
     * getArea determines the area of a circle
     * @return the area using Math.PI with no rounding.
     */
    public double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    public String toString() {
        String str = "Coordinates : (" + this.getX() + "," + this.getY() + ") | Radius : "
                + this.radius;
        return str;
    }

    public boolean equals(Circle c) {
        boolean isEqual = false;
        if(this.center.equals(c.center) &&
                this.radius == c.radius) {
            isEqual = true;
        }
        return isEqual;
    }

    /**
     * doesOverlap identifies if the current object overlaps with another circle object.
     * Given that these are circles, the method of identifying the overlap is to find the distance between
     * the two center-points and see if the radiuses of the two circles is greater or less than this amount.
     * @param otherCircle the other circle required for comparison
     * @return a boolean indicating if the circles overlap
     */

    public boolean doesOverlap(Circle otherCircle) {
//        Find the distnace between two circles
//        Formula is finding the hypotenuse of the x and y coordinates
//        sqrt((x1-x2)^2+(y1-y2)^2)
        double hypotenuse;
//        set circle1 variables (for clarity)
        double x1 = this.center.getX();
        double y1 = this.center.getY();
//        set circle 2 variables (for clarity)
        double x2 = otherCircle.center.getX();
        double y2 = otherCircle.center.getY();
//        set sum of radius
        double sumRadius = radius + otherCircle.getRadius();
//        calculate hypotenuse
        hypotenuse = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

//        if condition on if radius>hypotenuse
        if(sumRadius > hypotenuse) {
            return true;
        }
        else {
            return false;
        }

    }
}