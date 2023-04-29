import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
    private boolean status;
    private Calendar programTime;
    private boolean programAction;

    public SmartPlug(String alias, String macId) {
        super();
        this.setAlias(alias);
        this.setMacId(macId);
        programTime = Calendar.getInstance();
    }

    public void turnOn() {
        if (isConnectionStatus()) {
            if (!status) {
                status = true;
                programAction = false;
                System.out.println("Smart Plug -" + getAlias() + " is turned on now (Current time: " + getcurrenttime() + ")");
            } else {
                System.out.println("Smart Plug -" + getAlias() + " has been already turned on ");
            }


        }

    }

    public void turnOff() {
        if (isConnectionStatus()) {
            if (status) {
                status = false;
                programAction = true;
                System.out.println("Smart Plug -" + getAlias() + " is turned off now (Current time: " + getProgramtime() + ")");
            } else {
                System.out.println("Smart Plug -" + getAlias() + " has been already turned off ");
            }

        }
    }


    @Override
    public void setTimer(int seconds) {
        if (isConnectionStatus()) {
            programTime = Calendar.getInstance();

            if (!status) {
                System.out.println("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + getcurrenttime() + ")");
            } else {
                System.out.println("Smart plug - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + getcurrenttime() + ")");
            }
        }
        programTime.add(Calendar.SECOND, seconds);

    }

    @Override
    public void cancelTimer() {
        if (isConnectionStatus()) {
            programTime = null;
        }

    }

    @Override
    public void runProgram() {
        boolean isTimeProper=gettime();
        if (isConnectionStatus() && isTimeProper&& getProgramtime().equals(getcurrenttime())) {
            System.out.println("runProgram -> Smart Plug - " + getAlias());
            if (programAction) {
                turnOn();

            } else {
                turnOff();
            }
        }

    }

    private boolean gettime() {
        return programTime != null;
    }

    @Override
    public boolean testObject() {

        if (isConnectionStatus()) {
            SmartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test  completed for SmartPlug");
            return true;
        }

        return false;
    }


    @Override
    public boolean shutDownObject() {
        if (isConnectionStatus() && status) {
            SmartObjectToString();
            turnOff();
            return true;
        }
        return false;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }

    // This method will return the string value of program time based on hour, minute and second values
    
    private String getProgramtime() {
        return programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND);
    }

   // This method will return the string value of current time based on hour, minute, and second values
    private String getcurrenttime() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND);
    }

}





