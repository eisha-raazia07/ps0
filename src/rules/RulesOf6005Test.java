/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
}

/**
 * addition two tests
 * Code written entirely by yourself is always allowed, 
 * regardless of whether it was created as coursework, 
 * cited, or required by the assignment guidelines.
 */
@Test
public void testWrittenByYourselfAlwaysAllowed() {
    assertTrue("Expected true: code written entirely by yourself is always permitted",
            RulesOf6005.mayUseCodeInAssignment(true, false, false, false, true));
}

/**
 * Code obtained from a public source cannot be used if you fail 
 * to cite it, even if it wasn't explicitly required by the assignment.
 */
@Test
public void testPublicUncitedCodeNotAllowed() {
    assertFalse("Expected false: code from a public source must be cited to be used",
            RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
}
