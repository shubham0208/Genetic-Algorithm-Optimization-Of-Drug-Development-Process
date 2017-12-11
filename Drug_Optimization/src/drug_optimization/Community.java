
package drug_optimization;

import org.apache.log4j.Logger;

/**
 *
 * @author shubham
 */
public class Community {
    
    
    Researcher[] researcher;
    
    static int dist = 65;
 

    public Community(int comSize, boolean initialise) {
        
        researcher = new Researcher[comSize];
       
        if (initialise) {
            
            for (int i = 0; i < size(); i++) {
                
                Researcher newRes = new Researcher();
                newRes.generateResearcher();
            
                researcher[i]=newRes;
            }
        }
    }


    public Researcher getFittest() {
        
        Researcher fittest = researcher[0];
        
        
        for (int i = 0; i < size(); i++) {
           
           int fittestDis = fittest.getDissolutionFitness();
           int fittestLib = fittest.getLiberationFitness();
           
           int resDiss = getResearcher(i).getDissolutionFitness();
           int resLib = getResearcher(i).getLiberationFitness(); 
           
            if ( (Math.pow((dist - resDiss),2) + Math.pow(dist - resLib, 2))
               <= (Math.pow((dist - fittestDis),2) + Math.pow(dist - fittestLib, 2)) ){
                fittest = getResearcher(i);
               
            }
        }
       
        return fittest;
        
    }

   
 
    public int size() {
        return researcher.length;
    }

 
    public void saveResearcher(int index, Researcher res) {
        researcher[index] = res;
    }
    
    
    public Researcher getResearcher(int index) {
        return researcher[index];
    }
}
