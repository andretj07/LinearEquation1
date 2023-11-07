public class LinearEquation {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return roundedToHundredth(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    public double yIntercept() {
        double slope = slope();
        return roundedToHundredth(y1 - slope * x1);
    }

    public double slope() {
        if (x1 == x2) {
            throw new ArithmeticException("The line is vertical, and the slope is undefined.");
        }
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String equation() {
        double slope = slope();
        double yIntercept = yIntercept();
        
        if (slope == 0) {
            return "y = " + yIntercept;
        } else {
            return "y = " + (slope != 1 ? slope : "") + "x " + (yIntercept >= 0 ? "+ " : "- ") + Math.abs(yIntercept);
        }
    }

    public String coordinateForX(double xValue) {
        double slope = slope();
        double yIntercept = yIntercept();
        double yValue = slope * xValue + yIntercept;
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(yValue) + ")";
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

    public String lineInfo() {
        String info = "Original points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        info += "Equation of the line: " + equation() + "\n";
        info += "Slope: " + slope() + "\n";
        info += "Y-Intercept: " + yIntercept() + "\n";
        info += "Distance: " + distance();
        return info;
    }
}
