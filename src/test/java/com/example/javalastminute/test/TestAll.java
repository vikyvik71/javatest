package com.example.javalastminute.test;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Utility test class that includes all test classes.
 * Remove ignore (added to avoid duplicated tests during
 * build) annotation to run it.
 * 
 * @author Vittorio
 */
@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses({
  FactoryTest.class,
  StrategyTest.class  
})
public class TestAll {}
