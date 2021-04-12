package by.bakhar.task3.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (13 * Double.hashCode(x)) % 101;
        hash += (13 * Double.hashCode(y)) % 101;
        hash += (13 * Double.hashCode(z)) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x= ").append(x);
        stringBuilder.append(" y= ").append(y);
        stringBuilder.append(" z= ").append(z);
        return stringBuilder.toString();
    }
}
