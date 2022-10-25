package oopexercises.inheritance.points;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this.z = 0.0f;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] coords = {this.getX(), this.getY(), this.getZ()};
        return coords;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", this.x, this.y, this.z);
    }
}
