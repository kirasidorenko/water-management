package com.example.command;

import com.example.visitor.WaterBillVisitor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AddGuestsCommandTest {

    @Test
    public void testExecute(){
        WaterBillVisitor visitor = Mockito.mock(WaterBillVisitor.class);
        AddGuestsCommand command = new AddGuestsCommand(5);
        command.execute(visitor);
        Mockito.verify(visitor).visit(command);
    }
}
