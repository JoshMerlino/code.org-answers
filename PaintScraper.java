import org.code.neighborhood.Painter;

public class PaintScraper {
    public static void main(String[] args) {

        Painter painter = new Painter();

        // The starting solid line to scrape.
        painter.move();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.takePaint();
        painter.turnLeft();
        painter.turnLeft();
        painter.move();
        painter.turnLeft();
        painter.turnLeft();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.move();
        painter.paint("coral");
        painter.turnLeft();
        painter.turnLeft();

        // Iterate through the orange line
        for (int i = 0; painter.canMove(); i++) {

            // Move forward
            painter.move();

            // If hes on an odd tile
            if (i % 2 == 0) {

                // Scrape the paint
                painter.scrapePaint();

            }

        }

    }
}