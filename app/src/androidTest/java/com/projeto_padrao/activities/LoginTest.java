package com.projeto_padrao.activities;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.projeto_padrao.R;
import com.projeto_padrao.models.Aplicacao;
import com.projeto_padrao.models.Usuario;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

    @Test
    public void loginTest() {
        Aplicacao.aguardar(2000);

        if (Usuario.verificaUsuarioLogado() == null) {

            Aplicacao.aguardar(3000);

            ViewInteraction appCompatEditText = onView(
                    allOf(withId(R.id.login_editText_email), withText("admin@gmail.com"),
                            childAtPosition(
                                    allOf(withId(R.id.cronstrain),
                                            childAtPosition(
                                                    withClassName(is("androidx.core.widget.NestedScrollView")),
                                                    0)),
                                    2),
                            isDisplayed()));
            appCompatEditText.perform(replaceText("pedroh.mix@gmail.com"));
            Aplicacao.aguardar(3000);

            ViewInteraction appCompatEditText2 = onView(
                    allOf(withId(R.id.login_editText_email), withText("pedroh.mix@gmail.com"),
                            childAtPosition(
                                    allOf(withId(R.id.cronstrain),
                                            childAtPosition(
                                                    withClassName(is("androidx.core.widget.NestedScrollView")),
                                                    0)),
                                    2),
                            isDisplayed()));
            appCompatEditText2.perform(closeSoftKeyboard());
            Aplicacao.aguardar(3000);


            ViewInteraction appCompatButton = onView(
                    allOf(withId(R.id.login_button_login), withText("Login"),
                            childAtPosition(
                                    allOf(withId(R.id.cronstrain),
                                            childAtPosition(
                                                    withClassName(is("androidx.core.widget.NestedScrollView")),
                                                    0)),
                                    12),
                            isDisplayed()));
            appCompatButton.perform(click());
            Aplicacao.aguardar(3000);

        }
    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
