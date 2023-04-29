import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
    private boolean hasLightTurned;
    Calendar programTime;
    boolean programAction;

    public SmartLight(String alias, String macId) {
        super();
        this.setAlias(alias);
        this.setMacId(macId);
        programTime = Calendar.getInstance();


    }

    public void turnOnLight() {
        if (controlConnection()) {
            if (!hasLightTurned) {
               setHasLightTurned(true);
                programAction = false;
                System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + getprogramtime() + ")");
            } else {
                System.out.println("Smart Light - " + getAlias() + "  has been already turned on ");

            }

        }
    }

    public void turnOffLight() {
        if (controlConnection()) {
            if (hasLightTurned) {
                setHasLightTurned(false);
                programAction = true;
                System.out.println("Smart Light - " + getAlias() + " is turned off now  (Current time: " + getprogramtime() + ")");
            } else {
                System.out.println("Smart Light - " + getAlias() + " Light has been already turned off");
            }


        }
    }

    public boolean testObjects() {
        if (controlConnection()) {
            SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight ");
            return true;

        }
        return false;
    }


    @Override
    public void onLeave() {
        System.out.println("On Leave -> Smart Light - Living Room Light ");
        if (controlConnection()) {
            turnOffLight();

        }


    }

    @Override
    public void onCome() {
        System.out.println("On Come -> Smart Light - " + getAlias());
        if (isConnectionStatus()) {
            turnOnLight();
        }

    }

    @Override
    public boolean testObject() {

        if (controlConnection()) {
            SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            return true;
        }
        return false;
    }

    @Override
    public boolean shutDownObject() {
        if (controlConnection() && hasLightTurned) {
            SmartObjectToString();
            turnOffLight();
            return true;
        }
        return false;

    }


    @Override
    public void setTimer(int seconds) {

        if (controlConnection()) {
            programTime = Calendar.getInstance();
         


            if (hasLightTurned) {
                System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + getprogramtime() + ")");
            } else {
                System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + getProgramTime() + ")");
            }
            programTime.add(Calendar.SECOND, seconds);
            
        }

    }


    @Override
    public void cancelTimer() {
        if (isConnectionStatus()) {
            programTime = null;
        }

    }

    @Override
    public void runProgram() {
         boolean isTimeProper = gettime();
        if (controlConnection() && isTimeProper&& getprogramtime().equals(getcurrenttime())) {
            System.out.println("runProgram -> Smart Light - " + getAlias());
            if (programAction) {
                turnOnLight();
            } else {
                turnOffLight();
            }
            programTime=null;
        }
    }

    private boolean gettime() {
        return programTime != null;
    }

 // This method will return the string value of program time based on hour, minute and second values
   
    private String getprogramtime() {

        return programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + ":" + programTime.get(Calendar.SECOND);
    }


    public boolean isHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
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

    // This method will return the string value of current time based on hour, minute, and second values
    
    private String getcurrenttime() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND);
    }
}
