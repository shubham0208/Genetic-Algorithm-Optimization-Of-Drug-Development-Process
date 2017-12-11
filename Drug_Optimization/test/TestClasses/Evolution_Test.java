package TestClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import drug_optimization.Community;
import drug_optimization.Mutation_Crossover;
import drug_optimization.Researcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shubham
 */
public class Evolution_Test {
    
    public Evolution_Test() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
  @Test
  public void EvolutionTest() {
  
  
        Community c = new Community(100, true);
       
        Researcher expected = c.getFittest();
        
        
        Community c1 =  Mutation_Crossover.evolveCommunity(c);
        
        Researcher result = c1.getResearcher(0);
        
        
        assertEquals(expected, result);}
}
