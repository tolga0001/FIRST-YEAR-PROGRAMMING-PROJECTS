import java.util.ArrayList;
import java.util.Arrays;

public class SmartHome {
    private ArrayList<SmartObject> smartObjectList = new ArrayList<>();

    public SmartHome() {
    }

    public boolean addSmartObject(SmartObject smartObject) {
        if (!smartObjectList.contains(smartObject)) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Adding new SmartObject");
            System.out.println("-------------------------------------------------------------------------- ");

            smartObjectList.add(smartObject);
            String IP = calculateIP(smartObject);
            smartObject.connect(IP);
            System.out.println("Test is starting for " + smartObject.getClass().getName());
            smartObject.testObject();
            System.out.println();
            return true;

        }
        return false;
    }

    public boolean removeSmartObject(SmartObject smartObject) {
        if (smartObjectList.contains(smartObject)) {
            smartObjectList.remove(smartObject);
            return true;
        }
        return false;
    }

    public void controlLocation(boolean onCome) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("LocationControl: " + findtime(onCome));
        System.out.println("-------------------------------------------------------------------------- ");
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof LocationControl) {
                if (onCome) {
                    ((LocationControl) smartObject).onCome();
                } else ((LocationControl) smartObject).onLeave();
            }
        }


    }

    private String findtime(boolean onCome) {
        return onCome ? "onCome" : "onLeave";
    }


    public void controlMotion(boolean hasMotion, boolean isDay) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("MotionControl: " + "hasMotion" + "," + "isDay");
        System.out.println("-------------------------------------------------------------------------- ");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof MotionControl) {
                ((MotionControl) smartObject).controlMotion(hasMotion, isDay);
            }
        }
    }

  
   

    public void controlProgrammable() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: runProgram");
        System.out.println("--------------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                ((Programmable) smartObject).runProgram();
            }

        }


    }

    /**
     * controlTimer(seconds: int): void controlTimerRandomly(): void sortCameras(): void
     */
    public void controlTimer(int seconds) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Programmable: Timer = " + seconds + " seconds ");

        for (SmartObject s : smartObjectList) {
            if (s instanceof Programmable) {
                if (seconds != 0) {
                    ((Programmable) s).setTimer(seconds);
                } else ((Programmable) s).cancelTimer();
            }


        }
    }

    public void controlTimerRandomly() {
        System.out.println("-------------------------------------------------------------------------- ");
        System.out.println("-------------------------------------------------------------------------- ");
        System.out.println("Programmable: Timer =  5 or 10 seconds randomly");
        int random;
        for (SmartObject s : smartObjectList) {
            if (s instanceof Programmable) {
                random = getrandom();
                if ((random == 0)) {
                    ((Programmable) s).cancelTimer();
                } else {
                    ((Programmable) s).setTimer(random); //give random numbers only return 0 5 or 10 ?
                }


            }
        }
    }

    // The method will return random three values which consist of 0,5 or 10.
   
    private int getrandom() {
        int x = (int) (Math.random() * 3);
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 5;
        } else return 10;
    }


    public void sortCameras() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort Smart Cameras");
        System.out.println("--------------------------------------------------------------------------");
         ArrayList<SmartCamera> smartCameraslist = new ArrayList<>();
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof SmartCamera) {
                smartCameraslist.add((SmartCamera) smartObject);
            }
        }
        Object[] smartcameras = smartCameraslist.toArray();
        Arrays.sort(smartcameras);

        for (Object smartcamera : smartcameras) {
            System.out.println(smartcamera.toString());
        }


    }

   // The method will be used to calculate the IP value based on the index value of smart object.
   
    private String calculateIP(SmartObject smartObject) {

        int ipIndex = 100 + smartObjectList.indexOf(smartObject);
        return "10.0.0." + ipIndex;

    }


}



