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
public class RegistroTest {

    @Rule
    public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

    @Test
    public void registroTest() {
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.login_text_registrar), withText("Não possui uma conta?  Vamos criar!"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatTextView.perform(click());
        Aplicacao.aguardar(1000);

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.register_editText_usuario),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("ffff"), closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.register_editText_email),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("ffff1@gmail.com"), closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.register_editText_senha),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                7),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("123"), closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.register_editText_senha_repita),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("123"), closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.register_button_login), withText("REGISTRAR"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                8),
                        isDisplayed()));
        appCompatButton.perform(click());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.login_editText_email), withText("admin@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("ffff1@gmail.com"));
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.login_editText_email), withText("ffff1@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.login_editText_senha), withText("123456"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("123"));
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.login_editText_senha), withText("123"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());
        Aplicacao.aguardar(1000);


        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.login_button_login), withText("Login"),
                        childAtPosition(
                                allOf(withId(R.id.cronstrain),
                                        childAtPosition(
                                                withClassName(is("androidx.core.widget.NestedScrollView")),
                                                0)),
                                12),
                        isDisplayed()));
        appCompatButton2.perform(click());
        Aplicacao.aguardar(1000);

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
