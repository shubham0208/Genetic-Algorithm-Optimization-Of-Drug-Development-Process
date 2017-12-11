
package drug_optimization;

/**
 *
 * @author shubham
 */
public class Researcher {
    
    static int defaultLiberationLength = 65;
    private byte[] liberation = new byte[defaultLiberationLength];
    
    static int defaultDissolutionLength = 65;
    private byte[] dissolution = new byte[defaultDissolutionLength];
   
    private int Liberationfitness = 0;
    private int Dissolutionfitness = 0;

    
    public void generateResearcher() {
     
        for (int i = 0; i < size(); i++) {
        
            byte x = (byte) Math.round(Math.random());
            
            liberation[i] = x;
            
            byte y = (byte) Math.round(Math.random());
            dissolution[i] = y;
        }
    }

    public static void setDefaultLiberationLength(int length) {
        defaultLiberationLength = length;
    }
    
    public static void setDefaultDissolutionLength(int length) {
        defaultDissolutionLength = length;
    }
    
    public byte getLiberation(int index) {
        return liberation[index];
    }

    public byte getDissolution(int index) {
        return dissolution[index];
    }
    
    public void setLiberation(int index, byte value) {
        liberation[index] = value;
        Liberationfitness = 0;
    }
    
    public void setDissolution(int index, byte value) {
        dissolution[index] = value;
        Dissolutionfitness = 0;
    }

    
    public int size() {
        return liberation.length;
    }
    
    public int Dissolutionsize() {
        return dissolution.length;
    }

    public int getLiberationFitness() {
        if (Liberationfitness == 0) {
            Liberationfitness = Fitness.getLiberationFitness(this);
        }
        return Liberationfitness;
    }
    public int getDissolutionFitness() {
        if (Dissolutionfitness == 0) {
            Dissolutionfitness = Fitness.getDissolutionFitness(this);
        }
        return Dissolutionfitness;
    }
}

