public abstract class SmartObject {
    private String alias;
    private String macId;
    private String IP;
    private boolean connectionStatus;

    public SmartObject(){

    }
    public boolean connect(String IP){
        this.setIP(IP);
        connectionStatus=true;
        printMessage();
        return true;

    }

    private void printMessage() {
        System.out.println(alias+" connection established ");
    }

    public  boolean disconnect(){
        this.IP=null;
        this.connectionStatus=false;
        return false;

    }
    public void SmartObjectToString(){
   System.out.println("This is " + this.getClass().getName() + " device " + this.alias + 
				"\n\tMacId: " + this.getMacId() + "\n\tIP: " + this.getIP());

    }
    public boolean controlConnection(){
      if (!connectionStatus){
          System.out.println("This device is not connected. SmartCamera ->"+alias);
          return false;
      }
      return true;
    }
    public abstract boolean testObject();


    public abstract boolean shutDownObject();



    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
