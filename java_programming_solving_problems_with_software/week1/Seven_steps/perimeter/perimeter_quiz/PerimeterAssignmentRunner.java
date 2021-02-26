import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int counter = 0;
        for(Point point : s.getPoints()) {
            counter++;
        }
        return counter;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int numberOfSides = getNumPoints(s);
        return 1.0 * getPerimeter(s) / numberOfSides;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide = 0.0;
        for(Point currentPoint : s.getPoints()) {
            largestSide = prevPt.distance(currentPoint);
            prevPt = currentPoint;
            if(prevPt.distance(currentPoint) > largestSide) {
                largestSide = prevPt.distance(currentPoint);
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point previousPoint = s.getLastPoint();
        double largestX = previousPoint.getX();
        for(Point currentPoint :  s.getPoints()) {
            if(currentPoint.getX() > largestX) {
                largestX = currentPoint.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            if(getPerimeter(shape) > largestPerimeter) {
                largestPerimeter = getPerimeter(shape);
            }
        } 
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            if(getPerimeter(shape) > largestPerimeter) {
                largestPerimeter = getPerimeter(shape);
                temp = f;
            }
        } 
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numberOfPoints = getNumPoints (s);
        System.out.println("number of points = " + numberOfPoints);
        
        double avgLength = getAverageLength(s);
        System.out.println("Average length of the sides is = " + avgLength);
        
        double largestSide = getLargestSide(s);
        System.out.println("Largest side has the value of = " + largestSide);
        
        System.out.println("Largest X has the value of = " + getLargestX(s));
        
        System.out.println("the largest perimeter found in the various files has the value of = " + getLargestPerimeterMultipleFiles());
        
        System.out.println("the largest perimeter found is in the file named = " + getFileWithLargestPerimeter());
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
