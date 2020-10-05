package DesignPattern.HeadFirst.Adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumIterAdapter implements Iterator {

    Enumeration enumeration;

    public EnumIterAdapter(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    // since the enumeration doesn't have a remove method, throw a exception
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
