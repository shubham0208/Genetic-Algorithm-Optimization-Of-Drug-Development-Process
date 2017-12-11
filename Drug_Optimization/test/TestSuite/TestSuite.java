package TestSuite;


import TestClasses.Evolution_Test;
import TestClasses.Fittest_Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({Evolution_Test.class, Fittest_Test.class})
public class TestSuite {
    
}
