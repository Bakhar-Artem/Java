package by.bakhar.task3.entity;

public class ConeParameters {
    private double square;
    private double volume;

    public ConeParameters(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConeParameters)) {
            return false;
        }
        ConeParameters that = (ConeParameters) o;
        return Double.compare(that.square, square) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int hash = (13 * Double.hashCode(square)) % 101;
        hash += (15 * Double.hashCode(volume)) % 101;
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConeParameters: ");
        stringBuilder.append("square: ").append(square);
        stringBuilder.append(", volume: ").append(volume);
        return stringBuilder.toString();
    }
}
