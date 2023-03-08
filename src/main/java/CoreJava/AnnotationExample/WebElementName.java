package CoreJava.AnnotationExample;


import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebElementName {
    String value();
}
