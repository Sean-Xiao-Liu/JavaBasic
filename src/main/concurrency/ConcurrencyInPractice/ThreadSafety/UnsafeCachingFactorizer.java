package ConcurrencyInPractice.ThreadSafety;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /************************************************************************************************************************************************************************************/
    /**
     * the problem is even though the atomic reference are used in the code, the operation/methods invoked are not atomic
     * the race condition may lead to bug on two set methods
     * can make this method thread safe by add synchronized key word, but will cause extreme low performance
     * **/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        if(i.equals(lastNumber.get())){
            encodeIntoResponse(servletResponse,lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            lastFactors.set(factors);
            lastNumber.set(i);
        }
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
