package io.github.chibat.util.typescript;

import io.github.chibat.util.typescript.Foo.Bar;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityCodeGeneratorTest {

    @Test
    public void test() throws IOException {

        new EntityCodeGenerator(new ObjectMapper()).readClass(Foo.class).print();

        new EntityCodeGenerator().readClass(Foo.class).writeFile("aaa.d.ts");

        // generate(new ObjectMapper(), Bar.class);
        // generate(new ObjectMapper(), new Hoge<Bar>().getClass());

        // new TypeCodeGenerator().generate(new Hoge<Bar>() {
        // }.getClass());

        // generate(new ObjectMapper(), Fuga.class);
    }

    //
    // test
    //

    public static class Hoge<T> {
        public T t;
    }

    public static class Fuga extends Hoge<Bar> {
    }

    public static void main(String[] args) throws IOException {
    }

}
