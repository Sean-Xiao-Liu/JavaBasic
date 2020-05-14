package ConcurrencyInPractice.ThreadSafety;

import ConcurrencyInPractice.Annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;


/**
 * A ststeless class is always thread safe:
 * it does not contain other field or reference to other class.
 * The calculation result would be save to local variables uniquely.
 * These variables can be reached only when the thread is executed.
 * **/
@ThreadSafe
public class StatelessFactorizer implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
}
