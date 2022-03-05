class Employee extends Person implements IEmployee {
  private final Parking parking;
  private static int newEmployeeId = 1;

  public Employee(String firstName, String lastName, Parking parking) {
    super(firstName, lastName, newEmployeeId);
    this.parking = parking;
    newEmployeeId += 1;
    System.out.println("Employee: " + getFullName());
    System.out.println(" Id: " + id + "\n");
  }

  public int checkIn(Session session, String enterTime) {
    // Set the full name of the employee responsible for the session.
    session.setEmployeeFullName(getFullName());

    // Find a free space and assign it to the client
    Space freeSpace = parking.assignFreeSpace(session.getClientId());
    int reservedSpaceNumber = freeSpace.number;

    // Set the reserved space and the enter time
    session.setReservedSpace(freeSpace);
    session.setEnterTime(DateUtils.getParsedDate(enterTime));

    System.out.println("Employee " + getFullName() + " reserved the space " + reservedSpaceNumber + " for the client "
        + session.getClientFullName());
    System.out.println("Enter time: " + enterTime + "\n");

    return reservedSpaceNumber;
  }

  public Receipt checkOut(Session session) {
    // Calculate the duration of the parking session and set total hours
    session.setTotalHours();
    // Free up the reserved space
    // N.B. We can move the below logic into a new function, `freeUpSpace`
    // within the class Parking. That function can have a parameter
    // `spaceNumber` to get a space by its number and update its data.
    // By that, we can change the field `Space reservedSpace` to
    // `int reservedSpaceNumber` in the class Session and update
    // the relevant setter function. After that, we get below
    // the reserved space number and pass it as an argument to
    // the newly made function to free up the reserved space.
    session.getReservedSpace().setIsReserved(false);
    session.getReservedSpace().setCurrentClientId(0);

    // Create a receipt for the client
    Receipt receipt = session.getReceipt(parking);

    System.out.println("Employee " + getFullName() + " closed the completed parking session of the client "
        + session.getClientFullName() + "\n");

    return receipt;
  }
}
