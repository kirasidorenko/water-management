package com.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApplicationIT {

    @Test
    public void testExecute1() throws IOException {
        Application application = new Application();
        application.execute("src/test/resources/test1.txt");
    }

    @Test
    public void testExecute2() throws IOException {
        Application application = new Application();
        application.execute("src/test/resources/test2.txt");
    }

    @Test
    public void testExecute3() throws IOException {
        Application application = new Application();
        application.execute("src/test/resources/test3.txt");
    }
}
