package br.com.elo7.test.support;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;
import org.hamcrest.CoreMatchers;

/**
 * The type Test support.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public abstract class TestSupport {

    /**
     * Sets up test.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUpTest() throws Exception {
        setUp();
    }

    /**
     * Sets up.
     */
    public abstract void setUp();

    /**
     * Assert equals.
     *
     * @param expected the expected
     * @param actual   the actual
     */
    public void assertEquals(final Object expected, final Object actual) {
        Assert.assertEquals(expected, actual);
    }

    /**
     * In order.
     *
     * @param mocks the mocks
     * @return the in order
     */
    public InOrder inOrder(final Object... mocks) {
        return Mockito.inOrder(mocks);
    }

    /**
     * When ongoing stubbing.
     *
     * @param <T>        the type parameter
     * @param methodCall the method call
     * @return the ongoing stubbing
     */
    public <T> OngoingStubbing<T> when(final T methodCall) {
        return Mockito.when(methodCall);
    }

    /**
     * This method can be used to avoid casting
     * in your code.
     * @param clazz The type parameter to avoid casting
     * @return the clazz
     */
    public <T> T any(Class<T> clazz) {
        return Matchers.any(clazz);
    }

    /**
     * Verifies certain behavior <b>happened once</b>.
     * @param mock to be verified
     * @return mock object itself
     */
    public <T> T verify(T mock) {
        return Mockito.verify(mock);
    }

    /**
     * Verifies certain behavior <b>happened once</b>.
     * @param mock mock to be verified
     * @param mode mode times(x), atLeastOnce() or never()
     * @return mock object itself
     */
    public static <T> T verify(T mock, VerificationMode mode) {
        return Mockito.verify(mock, mode);
    }
    
    /**
     * Allows at-least-once verification. E.g:
     * <pre class="code"><code class="java">
     *   verify(mock, atLeastOnce()).someMethod("some arg");
     * </code></pre>
     * Alias to <code>atLeast(1)</code>.
     * <p>
     * 
     * @return verification mode
     */
    public static VerificationMode atLeastOnce() {
        return Mockito.atLeastOnce();
    }
    
    /**
     * Use <code>doReturn()</code> in those rare occasions when you cannot use {@link Mockito#when(Object)}.
     * <p>
     * <b>Beware that {@link Mockito#when(Object)} is always recommended for stubbing because it is argument type-safe 
     * and more readable</b> (especially when stubbing consecutive calls). 
     * <p>
     *
     * @param toBeReturned to be returned when the stubbed method is called
     * @return stubber - to select a method for stubbing
     */
    public static Stubber doReturn(Object toBeReturned) {
        return Mockito.doReturn(toBeReturned);
    }
    
    /**
     * Creates a spy of the real object. The spy calls <b>real</b> methods unless they are stubbed.
     * <p>
     * 
     * @param object
     *            to spy on
     * @return a spy of the real object
     */
    public static <T> T spy(T object) {
        return  Mockito.spy(object);
    }
    
    /**
     * Allows at-most-x verification. E.g:
     * <pre class="code"><code class="java">
     *   verify(mock, atMost(3)).someMethod("some arg");
     * </code></pre>
     * 
     * @param maxNumberOfInvocations max number of invocations 
     * 
     * @return verification mode
     */
    public static VerificationMode atMost(int maxNumberOfInvocations) {
        return Mockito.atMost(maxNumberOfInvocations);
    }
    
    /**
     * Allows verifying exact number of invocations.
     * 
     * @param wantedNumberOfInvocations wanted number of invocations 
     * 
     * @return verification mode
     */
    public static VerificationMode times(int wantedNumberOfInvocations) {
        return Mockito.times(wantedNumberOfInvocations);
    }
    
    /**
     * Asserts that <code>actual</code> satisfies the condition specified by
     * <code>matcher</code>. If not, an {@link AssertionError} is thrown with
     * information about the matcher and failing value. 
     *
     * @param <T> the static type accepted by the matcher (this can flag obvious
     * compile-time problems such as {@code assertThat(1, is("a"))}
     * @param actual the computed value being compared
     * @param matcher an expression, built of {@link Matcher}s, specifying allowed
     * values
     */
    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        Assert.assertThat("", actual, matcher);
    }
    
    /**
     * Asserts that <code>actual</code> satisfies the condition specified by
     * <code>matcher</code>. If not, an {@link AssertionError} is thrown with
     * the reason and information about the matcher and failing value.
     *
     * @param reason additional information about the error
     * @param <T> the static type accepted by the matcher (this can flag obvious
     * compile-time problems such as {@code assertThat(1, is("a"))}
     * @param actual the computed value being compared
     * @param matcher an expression, built of {@link Matcher}s, specifying allowed
     * values
     */
    public static <T> void assertThat(String reason, T actual,
            Matcher<? super T> matcher) {
        Assert.assertThat(reason, actual, matcher);
    }
    
    /**
     * Creates a matcher that matches when the examined object is logically equal to the specified
     * <code>operand</code>, as determined by calling the {@link java.lang.Object#equals} method on
     * the <b>examined</b> object.
     * 
     */
    public static <T> org.hamcrest.Matcher<T> equalTo(T operand) {
        return CoreMatchers.equalTo(operand);
      }
    
}
