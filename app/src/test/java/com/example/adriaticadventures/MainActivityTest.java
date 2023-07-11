package com.example.adriaticadventures;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.example.adriaticadventures.MainActivity;
import com.example.adriaticadventures.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        // Add initialization code here if needed.
    }

    @Test
    public void test_SendEmail() {
        onView(withId(R.id.fab)).perform(click());
        // Wait for the chooser dialog to appear
        onView(withText("Pošalji e-poštu")).inRoot(RootMatchers.isDialog()).check(matches(isDisplayed()));
        // Click on the email app you want to use
        onView(withText("Gmail")).perform(click());
        // Wait for the compose email screen to appear
        try {
            Thread.sleep(2000); // Wait for the new activity to launch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verify that the email recipient is correct
        //onView(withId(android.R.id.to)).check(matches(withText(equalTo("marko.vrban@student.uniri.hr"))));
        // Verify that the email subject is correct
        //onView(withId(R.id.SUBJECT)).check(matches(withText(equalTo("Adriatic Adventures"))));
    }

    @After
    public void tearDown() {
        // Add cleanup code here if needed.
    }
}