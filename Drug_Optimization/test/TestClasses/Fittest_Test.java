package TestClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import drug_optimization.Community;
import drug_optimization.Researcher;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shubham
 */
public class Fittest_Test {
    
    public Fittest_Test() {
    }
    
        
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void FittestTest() {
        
     Community c = new Community(100, true);   
     
     List l = new ArrayList();
   
     
     for(int i=34;i<65;i++){
        
         l.add(i);
         
     }
      
    Researcher r =  c.getFittest();
     
    int fittestLib = r.getLiberationFitness();
    int fittestDiss = r.getDissolutionFitness();
    
    
    int expected =0;
    if(l.contains(fittestLib) && l.contains(fittestDiss)){
        expected = fittestLib + fittestDiss;
     }
    
    int result = r.getDissolutionFitness() +r.getLiberationFitness();
     
    assertEquals(expected, result);
    
     
    
    }
    
    
}
