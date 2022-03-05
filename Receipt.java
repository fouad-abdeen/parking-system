import java.time.LocalDate;

class Receipt {
  private final String text;
  private static int newReceiptNumber = 1;

  public Receipt(Parking parking, String enterTime, String exitTime, int reservedSpaceNumber, long totalHours,
      String clientFullName, String employeeFullName) {
    text = getReceiptContent(newReceiptNumber, parking, enterTime, exitTime, reservedSpaceNumber, totalHours,
        clientFullName, employeeFullName);

    newReceiptNumber += 1;
  }

  public void printReceipt() {
    System.out.println("Receipt:\n");
    System.out.println(text);
  }

  private String getReceiptContent(int number, Parking parking, String enterTime, String exitTime,
      int reservedSpaceNumber, long totalHours, String clientFullName, String employeeFullName) {
    // Create the text content of the receipt
    String text = "Date: " + LocalDate.now() + "\nNumber: " + number + "\n\nParking: " + parking.name + "\nAddress: "
        + parking.address + "\nFees per Hour: " + parking.feesPerHour + " " + parking.currency + "\n\nEnter Time: " + enterTime + "\nExit Time: "
        + exitTime + "\nReserved Space Number: " + reservedSpaceNumber + "\n\nCash Receipt" + "\n From: " + clientFullName
        + "\n Total Amount: " + totalHours * parking.feesPerHour + " " + parking.currency + "\n For: " + totalHours
        + " hours of space reservation" + "\n\nSigned by: " + employeeFullName + "\n";

    return text;
  }
}
