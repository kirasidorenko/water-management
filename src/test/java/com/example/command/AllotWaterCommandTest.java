package com.example.command;

import com.example.visitor.WaterBillVisitor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AllotWaterCommandTest {

    @Test
    public void testExecute(){
        WaterBillVisitor visitor = Mockito.mock(WaterBillVisitor.class);
        AllotWaterCommand command = new AllotWaterCommand(2, 4, 5);
        command.execute(visitor);
        Mockito.verify(visitor).visit(command);
    }
}
