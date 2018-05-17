import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class GA1 {

    public GA1() {

        JFrame frame = new JFrame("G A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new EvolutionPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    public class EvolutionPane extends JPanel {

//        private TriangleShape triangleShape;
//        private Polygon poly;
        private TextField outputField;
        String target = "000000000010000000000" +
                "000000000111000000000" +
                "000000001111100000000" +
                "000000010111010000000" +
                "000000100111001000000" +
                "000001000111000100000" +
                "000010000111000010000" +
                "000100000111000001000" +
                "001000000111000000100" +
                "010000000111000000010" +
                "111111111111111111111" +
                "010000000111000000010" +
                "001000000111000000100" +
                "000100000111000001000" +
                "000010000111000010000" +
                "000001000111000100000" +
                "000000100111001000000" +
                "000000010111010000000" +
                "000000001111100000000" +
                "000000000111000000000" +
                "000000000010000000000" ;

        public EvolutionPane() {
//            triangleShape = new TriangleShape(
//                    new Point2D.Double(50, 0),
//                    new Point2D.Double(100, 100),
//                    new Point2D.Double(0, 100)
//            );
//
//            poly = new Polygon(
//                    new int[]{50, 100, 0},
//                    new int[]{0, 100, 100},
//                    3);

            outputField = new TextField();
            outputField.setText("test text");
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);

            int maxPopulation = 1000;
            double mutationRate = 0.05;

            Population population = new Population(target, maxPopulation);

            Operations operation = new Operations(population, mutationRate);

            boolean t = true;
            while (t) {
                population = operation.selection();
                g2d.drawString("Best Phrase: " + "\n" + population.getBest(), 200, 200);

                if (population.finished())
                    t = false;
            }
            System.out.println("Total generations: " + population.generations);

        }
    }

//    public class TriangleShape extends Path2D.Double {
//
//        public TriangleShape(Point2D... points) {
//            moveTo(points[0].getX(), points[0].getY());
//            lineTo(points[1].getX(), points[1].getY());
//            lineTo(points[2].getX(), points[2].getY());
//            closePath();
//        }
//
//    }
}
