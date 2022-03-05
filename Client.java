class Client extends Person implements IClient {
  final int mobileNumber;
  final String carPlateNumber;
  private final Parking parking;
  private static int newClientId = 1;

  public Client(String firstName, String lastName, int mobileNumber, String carPlateNumber, Parking parking) {
    super(firstName, lastName, newClientId);
    this.mobileNumber = mobileNumber;
    this.carPlateNumber = carPlateNumber;
    this.parking = parking;
    newClientId += 1;

    System.out.println("Client: " + getFullName());
    System.out.println(" Id: " + id);
    System.out.println(" Mobile Number: " + mobileNumber);
    System.out.println(" Car Plate Number: " + carPlateNumber + "\n");
  }

  public Session requestCheckIn() {
    if (parking.findFreeSpace() != null)
      return new Session(id, getFullName());
    else {
      // There's no need to throw an exception here
      // Logging the issue and returning a null value is more than enough
      System.out.println("There is no available parking space for the client " + getFullName() + "\n");
      return null;
    }
  }

  public void requestCheckOut(Session session, String exitTime) {
    session.setExitTime(DateUtils.getParsedDate(exitTime));
    System.out.println("Client " + getFullName() + " completed the parking session");
    System.out.println("Exit time: " + exitTime + "\n");
  }

  public void payForService(Receipt receipt) {
    System.out.println("Client " + getFullName() + " is paying for the service\n");
    // Print the receipt
    receipt.printReceipt();
    // Then, finalize the payment for the service
  }
}
