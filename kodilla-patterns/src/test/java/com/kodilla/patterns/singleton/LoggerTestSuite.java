package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        //Logger logger = new Logger();
        Logger.getInstance().log("Staring program kodilla-course");
        Logger.getInstance().log("Opening connection to db, as participant of the curse");
        Logger.getInstance().log("Generating files with current results");
        Logger.getInstance().log("Closing connection");
        //When
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Closing connection",lastLog);
    }
}
