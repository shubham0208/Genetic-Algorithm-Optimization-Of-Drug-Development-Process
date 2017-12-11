
package drug_optimization;

/**
 *
 * @author shubham
 */
public class Fitness {
    
    static byte[] Liberation = new byte[65];
    static byte[] Dissolution = new byte[65];
    
   
   
    public static void setLiberation(byte[] lib) {
        Liberation = lib;
    }
    
    public static void setDissolution(byte[] dis) {
        Dissolution = dis;
    }

    
    static void setLiberation(String lib) {
        
        Liberation = new byte[lib.length()];
        
        for (int i = 0; i < lib.length(); i++) {
            
            String character = lib.substring(i, i + 1);
            
            if (character.contains("0") || character.contains("1")) {
                
                Liberation[i] = Byte.parseByte(character);
                
                
                
            } else {
                
                Liberation[i] = 0;
            }
        }
    }
    
    static void setDissolution(String dis) {
        
        Dissolution = new byte[dis.length()];
        
        for (int i = 0; i < dis.length(); i++) {
            
            String character = dis.substring(i, i + 1);
            
            if (character.contains("0") || character.contains("1")) {
                Dissolution[i] = Byte.parseByte(character);
            
            } else {
                Dissolution[i] = 0;
            }
        }
    }

    
    static int getLiberationFitness(Researcher researcher) {
        int fitness = 0;
    
        for (int i = 0; i < researcher.size() && i < Liberation.length; i++) {
            if (researcher.getLiberation(i) == Liberation[i]) {
                fitness++;
            }
        }
        return fitness;
    }
    
    static int getDissolutionFitness(Researcher researcher) {
        int fitness = 0;
        
        for (int i = 0; i < researcher.size() && i < Dissolution.length; i++) {
            if (researcher.getDissolution(i) == Dissolution[i]) {
                fitness++;
            }
        }
        return fitness;
    }
    
    
    static int getMaxFitness() {
        int maxFitness = Liberation.length;
        return maxFitness;
    }
    

}
