package CoreJava.AnnotationExample;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;

public class UseAnnotation {

    @WebElementName("something")
    String text = "this is the value of text";

    String getText(String value){
        return getFieldByElementNameAnnotation(value,String.class);
    }


    private <T> T getFieldByElementNameAnnotation (String name, Class<T> clazz) {
        try {
            Field[] declaredFields = getClass().getDeclaredFields();

            for (Field field : declaredFields) {
                field. setAccessible (true);

                WebElementName annotation = field.getAnnotation(WebElementName.class);

                if (annotation != null && name.equalsIgnoreCase(annotation.value())) {
                    Object value = field.get(this);

                    if(!(clazz.isInstance(value))){
                        throw new RuntimeException("   ");
                    }
                    return clazz.cast(value);
                }
            }

        } catch (IllegalAccessException e){
            throw new RuntimeException(e);
        }
        return null;
    }



    public static void main(String[] args) {
        UseAnnotation useAnnotation = new UseAnnotation();
        System.out.println(useAnnotation.getText("something"));
    }

}
