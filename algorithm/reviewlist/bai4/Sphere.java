package reviewlist.bai4;

public class Sphere {
    private double[] center;
    private double radius;

    public Sphere() {
        this.center = new double[]{0, 0, 0};
        this.radius = 1;
    }

    public Sphere(double radius, double x, double y, double z) {
        this.center = new double[]{x, y, z};
        this.radius = radius;
    }

    public static void main(String[] args) {
        Sphere sphere1 = new Sphere();
        Sphere sphere2 = new Sphere(0.5, 0, 0, 0);

        System.out.println(sphere1);
        System.out.println(sphere2);

        System.out.println("Surface area of sphere 1:");
        System.out.println(sphere1.surfaceArea());

        System.out.println("Volume of sphere 2:");
        System.out.println(sphere2.volume());

        System.out.println("is sphere 1 intersect with sphere 2:");
        System.out.println(sphere1.intersectWith(sphere2));

        System.out.println("is sphere 1 contain sphere 2:");
        System.out.println(sphere1.isContaining(sphere2));
    }

    public double getCenterX() {
        return this.center[0];
    }

    public double getCenterY() {
        return this.center[1];
    }

    public double getCenterZ() {
        return this.center[2];
    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    public double volume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(this.radius, 3);
    }

    @Override
    public String toString() {
        return String.format("Sphere[ x = %.2f, y = %.2f, z = %.2f, r = %.2f]", this.getCenterX(), this.getCenterY(),
                this.getCenterZ(), this.getRadius());
    }

    public double distanceFrom(Sphere another) {
        return Math.sqrt(Math.pow(this.getCenterX() - another.getCenterX(), 2) + Math.pow(this.getCenterY() - another.getCenterY(), 2) +
                Math.pow(this.getCenterZ() - another.getCenterZ(), 2));
    }

    public boolean intersectWith(Sphere another) {
        return this.distanceFrom(another) <= this.radius + another.radius || this.distanceFrom(another) >= Math.abs(this.radius - another.radius);
    }

    public boolean isContaining(Sphere another) {
        return this.distanceFrom(another) <= Math.abs(this.radius - another.radius);
    }
}
