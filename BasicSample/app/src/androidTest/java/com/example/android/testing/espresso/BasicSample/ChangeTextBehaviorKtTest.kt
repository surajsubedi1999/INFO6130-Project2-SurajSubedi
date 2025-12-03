package com.example.android.testing.espresso.BasicSample

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    // Test 1: Validate initial TextView in main activity
    @Test
    fun validateInitialTextView() {
        // Check that the initial text is "Hello World!"
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("Hello World!")))
    }

    // Test 2: Enter "123" and press Change Text button
    @Test
    fun changeText_with123_sameActivity() {
        // Type "123" in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("123"), closeSoftKeyboard())

        // Click Change Text button
        onView(withId(R.id.changeTextBt))
            .perform(click())

        // Verify TextView shows "123"
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("123")))
    }

    // Test 3: Enter "123" and press Open Activity button
    @Test
    fun changeText_with123_newActivity() {
        // Type "123" in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("123"), closeSoftKeyboard())

        // Click Open Activity button
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        // Verify ShowTextActivity shows "123"
        onView(withId(R.id.show_text_view))
            .check(matches(withText("123")))

        // Also verify the TextView is displayed
        onView(withId(R.id.show_text_view))
            .check(matches(isDisplayed()))
    }

    // Test 4: Empty input and press Change Text button
    @Test
    fun changeText_emptyInput_sameActivity() {
        // Clear any existing text in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(clearText(), closeSoftKeyboard())

        // Click Change Text button
        onView(withId(R.id.changeTextBt))
            .perform(click())

        // Verify TextView remains "Hello World!" (no change)
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("Hello World!")))
    }

    // Test 5: Empty input and press Open Activity button
    @Test
    fun changeText_emptyInput_newActivity() {
        // Clear any existing text in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(clearText(), closeSoftKeyboard())

        // Click Open Activity button
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        // Verify ShowTextActivity shows empty string
        onView(withId(R.id.show_text_view))
            .check(matches(withText("")))
    }

    // Test 6: Enter "abcdef" and press Change Text button
    @Test
    fun changeText_withAbcdef_sameActivity() {
        // Type "abcdef" in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("abcdef"), closeSoftKeyboard())

        // Click Change Text button
        onView(withId(R.id.changeTextBt))
            .perform(click())

        // Verify TextView shows "abcdef"
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("abcdef")))
    }

    // Test 7: Enter "abcdef" and press Open Activity button
    @Test
    fun changeText_withAbcdef_newActivity() {
        // Type "abcdef" in EditText
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("abcdef"), closeSoftKeyboard())

        // Click Open Activity button
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        // Verify ShowTextActivity shows "abcdef"
        onView(withId(R.id.show_text_view))
            .check(matches(withText("abcdef")))

        // Also verify the TextView is displayed
        onView(withId(R.id.show_text_view))
            .check(matches(isDisplayed()))
    }

    // Test 8: Additional test for back navigation (optional but good to have)
    @Test
    fun backNavigation_fromShowTextActivity() {
        // Type text and open ShowTextActivity
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("Test Back"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        // Press back button
        onView(isRoot()).perform(pressBack())

        // Verify we're back in MainActivity
        onView(withId(R.id.textToBeChanged))
            .check(matches(isDisplayed()))
    }
}