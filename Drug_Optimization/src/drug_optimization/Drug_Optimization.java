package drug_optimization;

import static drug_optimization.Drug_Optimization.log;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import org.apache.log4j.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;


/**
 *
 * @author shubham
 */
public class Drug_Optimization {

    static Logger log = Logger.getRootLogger();
    
    public static void main(String[] args) {
        
    
    BasicConfigurator.configure();
    log.setLevel(Level.DEBUG);
    log.info("Optimization Of Drug Development!!!!");
    
    
    Fitness.setLiberation("11110010000011110000111000100001111110000000000111100000000001111");
    
    Fitness.setDissolution("11110010001000011100000001000000111110000000000000110000000001110");

    JFrame frame = new BounceThreadFrame();
    
    frame.show();
    }
    
}

class BounceThreadFrame extends JFrame {

    public BounceThreadFrame() {
    
        setSize(1000, 1000);

        setTitle("Genetic Algorithm -- Optimization Of Drug Developemet Process");

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            Container contentPane = getContentPane();
            canvas = new JPanel();
            contentPane.add(canvas, "Center");
            JPanel p = new JPanel();
            addButton(p, "Start", new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Ball b = new Ball(canvas);
                    b.start();
                }
            });

            addButton(p, "Close", new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    canvas.setVisible(false);
                    System.exit(0);
                }
            });
            contentPane.add(p, "South");
        }

        public void addButton(Container c, String title, ActionListener a) {
            JButton b = new JButton(title);
            c.add(b);
            b.addActionListener(a);
        }

        private JPanel canvas;
}

    class Ball extends Thread {
        int goal = 65;
        int multiplier = 10;
        public Ball(JPanel b) {
            box = b;
        }

        public void draw() {
            Graphics g = box.getGraphics();
            g.fillOval(goal*multiplier, goal*multiplier, 10, 10);
            g.dispose();
        }

        public void move(int x, int y) {
            if (!box.isVisible()) {
                return;
            }
            Graphics g = box.getGraphics();
            g.setXORMode(box.getBackground());
            g.setColor(Color.RED);
            g.fillOval(goal*multiplier, goal*multiplier, 10,10);

            g.fillOval(x*multiplier, y*multiplier, 10, 10);
            g.dispose();
        }

        public void run() {
            try {
                
                int breakPoint = 0;
                
                int libFitness = 0;
                
                int DissFitness = 0;
                
                Community community = new Community(100, true);
                
                draw();

                int counter = 0;
                
                while (community.getFittest().getLiberationFitness()<= Fitness.getMaxFitness() && community.getFittest().getDissolutionFitness()< Fitness.getMaxFitness()) {
                   
                    if (community.getFittest().getLiberationFitness()== libFitness && community.getFittest().getDissolutionFitness() == DissFitness) {
                        
                        breakPoint++;
                    }
                    
                    libFitness = community.getFittest().getLiberationFitness();
                    DissFitness = community.getFittest().getDissolutionFitness();

                    counter++;
                    
                log.info("Generation: " + counter + " Liberation: " + community.getFittest().getLiberationFitness() + " Dissolution: "+ community.getFittest().getDissolutionFitness());
                    
                    community = Mutation_Crossover.evolveCommunity(community);
                    
                    move(libFitness, DissFitness);
                    
                    
                    sleep(1500);
                    
                    if (breakPoint > 3) {
                        
                        break;
                    }
                }
                
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println("Optimized Solution found In Generation: " + counter);
                
             
            } 
            catch (InterruptedException e) {
           }
        }

        private JPanel box;

    }

