package ConcurrencyInPractice.ThreadSafety;

import ConcurrencyInPractice.Annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class SafeCountingFactorizer implements Servlet {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount(){
        return count.get();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /************************************************************************************************************************************************************************************/

    /** The service is thread safe by using atomic long data type and invoke the incrementAndGet to replace the count++ operation**/
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }
    /************************************************************************************************************************************************************************************/
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
