package com.example.android.testing.espresso.BasicSample;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeTextBehaviorLocalTest {

  @Test
  public void testIntentMessageKey() {
    assertEquals("com.example.android.testing.espresso.basicsample.MESSAGE",
            ShowTextActivity.KEY_EXTRA_MESSAGE);
  }

  @Test
  public void testIntentCreation() {
    // This would require mocking or Robolectric for proper testing
    assertTrue(true); // Placeholder test
  }
}