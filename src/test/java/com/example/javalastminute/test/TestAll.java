package com.example.javalastminute.test;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Utility test class that includes all test classes.
 * Remove ignore annotation (added to avoid duplicated 
 * tests during build) to run it.
 * 
 * @author Vittorio
 */
@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses({
  FactoryTest.class,
  StrategyTest.class,
  ServiceTest.class  
})
public class TestAll {}