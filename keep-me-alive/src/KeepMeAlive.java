import java.awt.*;
import java.util.concurrent.TimeUnit;

public class KeepMeAlive {

    public static void main(String[] args) {
        boolean movePositive = true;
        try {
            while (true) {
                moveMouse(movePositive);
                if (movePositive)
                    movePositive = false;
                else
                    movePositive = true;
                TimeUnit.SECONDS.sleep(55);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void moveMouse(boolean movePositive) {
        try {
            // Get the current mouse position
            Point p = MouseInfo.getPointerInfo().getLocation();

            // Move the mouse cursor by a small amount
            Robot robot = new Robot();
            if (movePositive)
                robot.mouseMove(p.x + 1, p.y + 1);
            else
                robot.mouseMove(p.x - 1, p.y - 1);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

