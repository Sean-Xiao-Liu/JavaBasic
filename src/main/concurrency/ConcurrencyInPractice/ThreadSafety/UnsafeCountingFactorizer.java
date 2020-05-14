package ConcurrencyInPractice.ThreadSafety;

import ConcurrencyInPractice.Annotation.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    /**
     * ++count is not a atomic operation but a read-modify-write operation, which may case updates lost
     * when two un-synchronized threads try to invoke the service concurrently.
     *
     * UnsafeCountingFactorizer has several race conditions that make its results unreliable.
     * A race condition occurs when the correctness of a computation depends on the relative timing or interleaving of multiple threads by the runtime;
     * in other words, when getting the right answer relies on lucky timing. [4] The most common type of race condition is check-then-act,
     * where a potentially stale observation is used to make a decision on what to do next.
     *
     * **/
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }



    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
}
