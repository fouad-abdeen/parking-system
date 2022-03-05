import java.time.LocalDateTime;

class Session {
  private final int clientId;
  private final String clientFullName;
  private String employeeFullName;
  private Space reservedSpace;
  private LocalDateTime enterTime;
  private LocalDateTime exitTime;
  private long totalHours;
  private Receipt receipt;

  public Session(int clientId, String clientFullName) {
    this.clientId = clientId;
    this.clientFullName = clientFullName;
    System.out.println("A new session requested by the client " + clientFullName + "\n");
  }

  // Setters
  public void setEmployeeFullName(String employeeFullName) {
    this.employeeFullName = employeeFullName;
  }

  public void setReservedSpace(Space reservedSpace) {
    this.reservedSpace = reservedSpace;
  }

  public void setEnterTime(LocalDateTime enterTime) {
    this.enterTime = enterTime;
  }

  public void setExitTime(LocalDateTime exitTime) {
    this.exitTime = exitTime;
  }

  public void setTotalHours() {
    // Calculate the duration of a parking session in hours
    this.totalHours = DateUtils.getDifferenceHoursBetweenTwoDates(enterTime, exitTime);
  }

  // Getters
  public int getClientId() {
    return clientId;
  }

  public String getClientFullName() {
    return clientFullName;
  }

  public Space getReservedSpace() {
    return reservedSpace;
  }

  public Receipt getReceipt(Parking parking) {
    // Conver enterTime and exitTime into string
    String enterTime = DateUtils.getFormattedDate(this.enterTime);
    String exitTime = DateUtils.getFormattedDate(this.exitTime);

    this.receipt = new Receipt(parking, enterTime, exitTime, reservedSpace.number, totalHours, clientFullName,
        employeeFullName);

    return this.receipt;
  }
}
