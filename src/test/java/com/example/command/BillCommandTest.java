package com.example.command;

import com.example.visitor.WaterBillVisitor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BillCommandTest {

    @Test
    public void testExecute(){
        WaterBillVisitor visitor = Mockito.mock(WaterBillVisitor.class);
        BillCommand command = new BillCommand();
        command.execute(visitor);
        Mockito.verify(visitor).visit(command);
    }
}
