package com.example.visitor;

import com.example.command.AddGuestsCommand;
import com.example.command.AllotWaterCommand;
import com.example.command.BillCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaterBillVisitorTest {

    @Test
    public void testVisitAllotWaterCommand(){
        WaterBillVisitor visitor = new WaterBillVisitor();
        AllotWaterCommand command = new AllotWaterCommand(2, 1, 1);
        visitor.visit(command);
        Assertions.assertEquals(450, visitor.getCorpWaterInLitres());
        Assertions.assertEquals(450, visitor.getBorewellWaterInLitres());
        Assertions.assertEquals(0, visitor.getTankerWaterInLitres());
    }

    @Test
    public void testVisitAddGuestsCommand(){
        WaterBillVisitor visitor = new WaterBillVisitor();
        AddGuestsCommand command = new AddGuestsCommand(5);
        visitor.visit(command);
        Assertions.assertEquals(0, visitor.getCorpWaterInLitres());
        Assertions.assertEquals(0, visitor.getBorewellWaterInLitres());
        Assertions.assertEquals(1500, visitor.getTankerWaterInLitres());
    }

    @Test
    public void testVisitBillCommand(){
        WaterBillVisitor visitor = new WaterBillVisitor();

        AllotWaterCommand populateAllotWaterCommand = new AllotWaterCommand(2, 3, 7);
        visitor.visit(populateAllotWaterCommand);

        AddGuestsCommand addGuestsCommand = new AddGuestsCommand(5);
        visitor.visit(addGuestsCommand);

        BillCommand command = new BillCommand();
        visitor.visit(command);

        Assertions.assertEquals(5215, visitor.getTotalCost());
        Assertions.assertEquals(2400, visitor.getTotalWaterInLitres());
    }
}
