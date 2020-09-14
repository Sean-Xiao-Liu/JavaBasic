package CoreJava;

@MyOwnAnnotation(value = 10)
@MyAnnotation2(value2 = "value2", value3 = "value3")
public class Annotation {
}


@interface MyOwnAnnotation{
    int value();
}

@interface MyAnnotation2{
    int value1() default 0;
    String value2();
    String value3();
}
