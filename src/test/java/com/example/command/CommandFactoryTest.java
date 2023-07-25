package com.example.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

    @Test
    public void testAllotWaterCommand(){
        CommandFactory factory = new CommandFactory();
        Command command = factory.getCommand("ALLOT_WATER 3 1:5");
        Assertions.assertTrue(command instanceof AllotWaterCommand);
    }

    @Test
    public void testAddGuestsCommand(){
        CommandFactory factory = new CommandFactory();
        Command command = factory.getCommand("ADD_GUESTS 10");
        Assertions.assertTrue(command instanceof AddGuestsCommand);
    }

    @Test
    public void testBillCommand(){
        CommandFactory factory = new CommandFactory();
        Command command = factory.getCommand("BILL");
        Assertions.assertTrue(command instanceof BillCommand);
    }
}
