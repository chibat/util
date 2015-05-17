package io.github.chibat.util.typescript;

import java.util.Collection;

public class Foo {
    public String string;
    public short shortPremitive;
    public Short shortObject;
    public int intPremitive;
    public Integer integerObject;
    public long longPremitive;
    public Long longObject;
    public float floatPremitive;
    public Float floatObject;
    public double doublePremitive;
    public Double doubleObject;
    public Boolean booleanObject;
    public Object object;
    public Collection<String> stringCollection;
    public String[] stringArray;
    public Bar bar;
    public Bar[] barArray;

    public static class Bar {
        public String string;
    }
}
