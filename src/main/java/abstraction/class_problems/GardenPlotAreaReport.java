package abstraction.class_problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class GardenPlot {
    protected String owner;

    public GardenPlot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();

    public String getOwner() {
        return owner;
    }
}

class CirclePlot extends GardenPlot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends GardenPlot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends GardenPlot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<GardenPlot> plots = new ArrayList<>();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String shape = input[0];
            String owner = input[1];

            GardenPlot plot;

            switch (shape) {
                case "CIRCLE":
                    double radius = Double.parseDouble(input[2]);
                    plot = new CirclePlot(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = Double.parseDouble(input[2]);
                    double width = Double.parseDouble(input[3]);
                    plot = new RectanglePlot(owner, length, width);
                    break;

                case "TRIANGLE":
                    double base = Double.parseDouble(input[2]);
                    double height = Double.parseDouble(input[3]);
                    plot = new TrianglePlot(owner, base, height);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown plot shape: " + shape
                    );
            }

            plots.add(plot);
        }

        for (GardenPlot plot : plots) {
            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.getOwner(),
                plot.getShape(),
                area
            );

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}