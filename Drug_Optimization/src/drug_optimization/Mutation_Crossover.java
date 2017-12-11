
package drug_optimization;

/**
 *
 * @author shubham
 */
public class Mutation_Crossover {
    
    private static final double uniformRate = 0.5;
    
    private static final double mutationRate = 0.015;
    
    private static final boolean flag = true;

    
    
    
    public static Community evolveCommunity(Community com) {
    
        Community community = new Community(com.size(), false);

        
        if (flag) {
           
            community.saveResearcher(0, com.getFittest());
        }

        
        int offset;
        
        if (flag) {
            
            offset = 1;
            
        } else {
            
            offset = 0;
        }
        
        for (int i = offset; i < com.size(); i++) {
            
            Researcher res1 = Selection(com);
            Researcher res2 = Selection(com);
            
            Researcher newRes = crossover(res1, res2);
            
            
            community.saveResearcher(i, newRes);
        }

     
        for (int i = offset; i < community.size(); i++) {
           
            mutate(community.getResearcher(i));
        }

        
        return community;
       
    }


    private static Researcher crossover(Researcher res1, Researcher res2) {
       
        Researcher newRes = new Researcher();
        
        for (int i = 0; i < res1.size(); i++) {
          
            if (Math.random() <= uniformRate) {
                
                newRes.setLiberation(i, res1.getLiberation(i));
                newRes.setDissolution(i, res1.getDissolution(i));
                
            } else {
                newRes.setLiberation(i, res2.getLiberation(i));
                newRes.setDissolution(i, res2.getDissolution(i));
            }
        }
        return newRes;
    }

  
    private static void mutate(Researcher res) {
 
        for (int i = 0; i < res.size(); i++) {
            
            if (Math.random() <= mutationRate) {
                
                byte lib = (byte) Math.round(Math.random());
                byte dis = (byte) Math.round(Math.random());
                
                res.setLiberation(i, lib);
                res.setDissolution(i, dis);
            }
        }
    }

 
    private static Researcher Selection(Community com) {
 
        Community bestFit = new Community(10, false);
 
        for (int i = 0; i < 10; i++) {
            
            int id = (int) (Math.random() * com.size());
            
            bestFit.saveResearcher(i, com.getResearcher(id));
        }
        
        Researcher fittest = bestFit.getFittest();
        
        return fittest;
    }
    
}