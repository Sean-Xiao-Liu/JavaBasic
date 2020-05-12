/**
 * The class to which this annotation is applied is immutable. This means that its state cannot be seen to change by callers, which implies that
 *
 * all public fields are final,
 * all public final reference fields refer to other immutable objects, and
 * constructors and methods do not publish references to any internal state which is potentially mutable by the implementation.
 * Immutable objects may still have internal mutable state for purposes of performance optimization; some state variables may be lazily computed,
 * so long as they are computed from immutable state and that callers cannot tell the difference.
 * Immutable objects are inherently thread-safe; they may be passed between threads or published without synchronization.
 * */

@Documented
@Target(value=TYPE)
@Retention(value=RUNTIME)
public @interface Immutable