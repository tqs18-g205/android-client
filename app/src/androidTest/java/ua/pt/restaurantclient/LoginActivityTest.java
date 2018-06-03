package ua.pt.restaurantclient;

import android.content.ComponentName;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    private static final String USERNAME = "restaurante@email.com";
    private static final String RIGHT_PASSWORD = "teste";
    private static final String WRONG_PASSWORD = "teste123";

    @Rule
    public IntentsTestRule<LoginActivity> mActivityRule =
            new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void loginSuccess() {
        onView(withId(R.id.input_email))
                .perform(clearText(), typeText("restaurante@email.com"));

        onView(withId(R.id.input_password))
                .perform(replaceText("teste"), closeSoftKeyboard());

        onView(withId(R.id.btn_login))
                .perform(click());

        assertEquals("Valid login", mActivityRule.getActivity().isLogged(), true);
        intended(hasComponent(OrderList.class.getName()));
    }

    @Test
    public void loginFailed() {
        onView(withId(R.id.input_email))
                .perform(clearText(), typeText("restaursante@email.com"));

        onView(withId(R.id.input_password))
                .perform(replaceText("tes2te"), closeSoftKeyboard());

        onView(withId(R.id.btn_login))
                .perform(click());

        assertEquals("Invalid Login", mActivityRule.getActivity().isLogged(), false);

    }


}
