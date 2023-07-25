package com.example.command;

public class CommandFactory {
    private final static String ALLOT_WATER = "ALLOT_WATER";
    private final static String ADD_GUESTS = "ADD_GUESTS";
    private final static String BILL = "BILL";

    public Command getCommand(String commandLine) {
        String cmd = commandLine.split("\\s")[0];
        Command command = null;
        switch(cmd){
            case ALLOT_WATER:
                command = getAllotWaterCommand(commandLine);
                break;
            case ADD_GUESTS:
                command = getAddGuestsCommand(commandLine);
                break;
            case BILL:
                command = new BillCommand();
                break;
            default:
                throw new RuntimeException("Wrong Command");
        };
        return command;
    }

    private Command getAllotWaterCommand(String commandLine) {
        int numberOfBedrooms = Integer.valueOf(commandLine.split("\\s")[1]);
        String ratio = commandLine.split("\\s")[2];
        int ratioNumerator = Integer.valueOf(ratio.split(":")[0]);
        int ratioDenominator = Integer.valueOf(ratio.split(":")[1]);
        return new AllotWaterCommand(numberOfBedrooms, ratioNumerator, ratioDenominator);
    }

    private Command getAddGuestsCommand(String commandLine){
        int numberOfGuests = Integer.valueOf(commandLine.split("\\s")[1]);
        return new AddGuestsCommand(numberOfGuests);
    }
}
