package jlin2.examples.localtesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAppContext() {
        // Context of the app under test
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("jlin2.examples.localtesting", appContext.packageName)
    }

    @Test
    fun testUserNameInputExists() {
        Espresso.onView(ViewMatchers.withId(R.id.userNameInput))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testEmailInputExists() {
        Espresso.onView(ViewMatchers.withId(R.id.emailInput))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}