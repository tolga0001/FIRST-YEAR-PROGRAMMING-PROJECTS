public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
        super();
        setAlias(alias);
        setMacId(macId);
        this.nightVision = nightVision;
        this.batteryLife = batteryLife;

    }

    public void recordOn(boolean isDay) {
        if (isConnectionStatus()) {
            if (nightVision || isDay) {
                if (!status) {
                    status = true;
                    System.out.println("Smart Camera - " + getAlias() + " is turned on now ");
                } else System.out.println("Smart Camera - " + getAlias() + " has been already turned on now ");
            } else System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature. ");
        }
    }

    public void recordOff() {
        if (isConnectionStatus()) {
            if (status) {
                status = false;
                System.out.println("Smart Camera - " + getAlias() + " is turned off now ");
            } else System.out.println("Smart Camera - " + getAlias() + " has been already turned off now ");

        }
    }


    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        if (hasMotion) {
            System.out.println("Motion detected");

            if (isDay) {
                recordOn(true);
            } else status = nightVision;
            return true;

        } else System.out.println("Motion not detected");

        return false;
    }

    @Override
    public boolean testObject() {
        if (isConnectionStatus()) {
            SmartObjectToString();
            System.out.println("Test is starting for SmartCamera day time ");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test  completed for SmartCamera ");
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

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    @Override
    public boolean shutDownObject() {
        if (isConnectionStatus() && status) {
            SmartObjectToString();
            status = false;
            return true;
        }
        return false;

    }
    // This will return the record information based on status.
   
    public String getStatus(){
        return status? " is recording" : " is not recording";
    }


    @Override
    public int compareTo(SmartCamera smartcamera) {
        return Integer.compare(this.batteryLife, smartcamera.batteryLife);

    }
    public String toString(){
        return "SmartCamera -> "+getAlias()+"'s battery life is "+batteryLife+" status "+getStatus();
    }
}
