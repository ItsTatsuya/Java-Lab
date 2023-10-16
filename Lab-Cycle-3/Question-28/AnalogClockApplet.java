import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AnalogClockApplet extends JApplet {
    private ClockPanel clockPanel;

    public void init() {
        // Retrieve starting time as an applet parameter
        String startTimeParam = getParameter("startTime");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        Date startTime;
        try {
            startTime = dateFormat.parse(startTimeParam);
        } catch (Exception e) {
            startTime = new Date();
        }

        // Initialize the clock panel
        clockPanel = new ClockPanel(startTime);
        add(clockPanel);
    }

    public void start() {
        clockPanel.startClock();
    }

    public void stop() {
        clockPanel.stopClock();
    }
}

class ClockPanel extends JPanel implements Runnable {
    private Thread clockThread;
    private Date currentTime;

    public ClockPanel(Date startTime) {
        currentTime = startTime;
    }

    public void startClock() {
        if (clockThread == null) {
            clockThread = new Thread(this);
            clockThread.start();
        }
    }

    public void stopClock() {
        if (clockThread != null) {
            clockThread.interrupt();
            clockThread = null;
        }
    }

    public void run() {
        try {
            while (true) {
                currentTime = new Date();
                repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Thread interrupted, stopping the clock
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw clock face
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 10;
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw clock hands
        drawClockHands(g, centerX, centerY, radius);
    }

    private void drawClockHands(Graphics g, int centerX, int centerY, int radius) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);

        int seconds = calendar.get(Calendar.SECOND);
        int minutes = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR);

        int secondHandLength = radius - 10;
        int minuteHandLength = radius - 20;
        int hourHandLength = radius / 2;

        // Draw hour hand
        int hourAngle = (int) (360 * ((hours % 12) + (minutes / 60.0)) / 12);
        drawHand(g, centerX, centerY, hourAngle, hourHandLength);

        // Draw minute hand
        int minuteAngle = (int) (360 * ((minutes % 60) + (seconds / 60.0)) / 60);
        drawHand(g, centerX, centerY, minuteAngle, minuteHandLength);

        // Draw second hand
        int secondAngle = (int) (360 * seconds / 60);
        drawHand(g, centerX, centerY, secondAngle, secondHandLength);
    }

    private void drawHand(Graphics g, int centerX, int centerY, int angle, int length) {
        double radianAngle = Math.toRadians(angle - 90);
        int x = (int) (centerX + length * Math.cos(radianAngle));
        int y = (int) (centerY + length * Math.sin(radianAngle));

        g.drawLine(centerX, centerY, x, y);
    }
}
