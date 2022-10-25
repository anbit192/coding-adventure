package classexercises2.ball;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x1 + width - 1;
        this.y2 = y1 + height - 1;
    }

    public int getX() {
        return this.x1;
    }

    public void setX(int x) {
        this.x1 = x;
    }

    public int getY() {
        return this.y1;
    }

    public void setY(int y) {
        this.y1 = y;
    }

    public int getWidth() {
        return this.x2 - this.x1 + 1;
    }

    public int getHeight() {
        return this.y2 - this.y1 + 1;
    }

    @Override
    public String toString() {
        return String.format("Container at (%d, %d) to (%d, %d)", this.x1, this.y1, this.x2, this.y2);
    }

    public boolean collidesWith(Ball ball) {
        if ((ball.getX() - ball.getRadius() <= this.x1) || (ball.getX() - ball.getRadius() >= this.x2)) {
            ball.reflectHorizontal();

            return true;
        }
        else if ((ball.getY() - ball.getRadius() <= this.y1) || (ball.getY() - ball.getRadius() >= this.y2)) {
            ball.reflectVertical();
            return true;
        }

        return false;
    }
}
