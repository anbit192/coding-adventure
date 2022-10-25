package classexercises2.ball;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(50,50,5,10,30);
        Container box = new Container(0,0,100,100);

        for (int i = 0; i < 100; i++) {
            ball.move();
            if (box.collidesWith(ball)) {
                System.out.println("Collided");
            }
            System.out.println(ball);
        }
    }
}
