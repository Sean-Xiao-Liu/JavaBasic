/**
 * The field or method to which this annotation is applied can only be accessed when holding a particular lock, which may be a built-in (synchronization) lock,
 * or may be an explicit java.util.concurrent.Lock. The argument determines which lock guards the annotated field or method:
 *
 * this : The intrinsic lock of the object in whose class the field is defined.
 * class-name.this : For inner classes, it may be necessary to disambiguate 'this'; the class-name.this designation allows you to specify which 'this' reference is intended
 * itself : For reference fields only; the object to which the field refers.
 * field-name : The lock object is referenced by the (instance or static) field specified by field-name.
 * class-name.field-name : The lock object is reference by the static field specified by class-name.field-name.
 * method-name() : The lock object is returned by calling the named nil-ary method.
 * class-name.class : The Class object for the specified class should be used as the lock object.
 * */

@Target(value={FIELD,METHOD})
@Retention(value=RUNTIME)
public @interface GuardedBy