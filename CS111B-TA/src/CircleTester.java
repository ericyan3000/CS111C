
public class CircleTester {
    public static void main(String[] args) {
System.out.println("Original Tests with Point");
//        Initialize 3 circles
        Circle circle1 = new Circle();
        circle1.setRadius(3);
        circle1.setX(3);
        circle1.setY(3);

        Circle circle2 = new Circle();
        circle2.setRadius(4);
        circle2.setX(4);
        circle2.setY(4);

        Circle circle3 = new Circle();
        circle3.setRadius(.1);
        circle3.setX(1);
        circle3.setY(1);

//        Print the area
        System.out.println("Circle 1's area: " + String.format("%.02f", circle1.getArea()));
        System.out.println("Circle 2's area: " + String.format("%.02f", circle2.getArea()));
        System.out.println("Circle 3's area: " + String.format("%.02f", circle3.getArea()));

//        Invoke doesOverlap
        System.out.println("Circle 1 and 2 " + (circle1.doesOverlap(circle2) ? "overlap" : "do not overlap"));
        System.out.println("Circle 2 and 3 " + (circle2.doesOverlap(circle3) ? "overlap" : "do not overlap"));
        System.out.println("Circle 3 and 1 " + (circle3.doesOverlap(circle1) ? "overlap" : "do not overlap"));

//        New tests
        System.out.println("\n---------------\n\nNew tests with Point:");
        Point centerA = new Point(3,4);
        Circle circleA = new Circle(centerA, 3);
        Circle circleB = new Circle(6, 8, 5);
        Circle circleC = new Circle();
        Circle circleD = new Circle(circle1);

        System.out.println("circle1: " + circle1);
        System.out.println("circleA: " + circleA);
        System.out.println("circleB: " + circleB);
        System.out.println("circleC: " + circleC);
        System.out.println("circleD: " + circleD);

        System.out.print("Circle 1 and Circle D ");
        System.out.println(circle1.equals(circleD) ? "are the same" : "are not the same.");

        System.out.print("Circle A and Circle D ");
        System.out.println(circleA.equals(circleD) ? "are the same" : "are not the same");

        System.out.print("Circle B and Circle C ");
        System.out.println(circleB.doesOverlap(circleC) ? "overlap" : "do not overlap");

        System.out.print("Circle B and Circle D ");
        System.out.println(circleB.doesOverlap(circleD) ? "overlap" : "do not overlap");
    }
}