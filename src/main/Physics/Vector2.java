package main.Physics;

public class Vector2 {
    public float x;
    public float y;

    public float originX;
    public float originY;

    public Vector2() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.originX = x;
        this.originY = y;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        this.originX = x;
        this.originY = y;
    }

    public boolean equals(Vector2 other) {
        return (this.x == other.x && this.y == other.y);
    }

    public static double distance(Vector2 a, Vector2 b) {
        float v0 = b.x -  a.x;
        float v1 = b.y - a.y;
        return Math.sqrt(v0*v0+v1*v1);
    }

    public void normalize() {
        double length = Math.sqrt(x*x + y*y);

        if (length != 0.0) {
            float s = 1.0f / (float)length;
            x = x*s;
            y = y*s;
        }
    }
}
