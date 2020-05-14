package ConcurrencyInPractice.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;



@Target(value={FIELD,METHOD})
@Retention(value=RUNTIME)
public @interface Guarded {}
