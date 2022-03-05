import java.util.Scanner;

// The implemented parking system relies on mock data. 
// Actually, it can be part of the backend of a data-driven application.
// So, we can have different classes for API controllers, the business logic (service layer), the database connection, the data access layer, etc.
// Therefore, the implemented classes (E.g. Client, Employee, etc.) will be data models.

class Main {
  public static void main(String[] args) {
    Parking parking = new Parking("Garage Abou Zaher",
        "El Tom Center, Al Ziraa Street, Mina, Tripoli, North Lebanon, 1301", 20000, Currency.LBP, 1, 3);

    Employee employee = new Employee("Zaher", "Zaydan", parking);

    // 1st client came to the parking
    Client client1 = new Client("Hassan", "Kurdi", 76398674, "A123456", parking);
    Session session1 = Main.openParkingSession(client1, employee, "22-02-2022 06:30:00");
    // Client left the parking
    Main.closeParkingSession(client1, employee, "22-02-2022 08:10:00", session1);

    Scanner scanner = new Scanner(System.in);
    System.out.println("New clients are coming. Do you want to proceed? Enter 1 or 0 (yes or no):");
    int proceed1stTestCase = scanner.nextInt();

    if (proceed1stTestCase == 1) {
      System.out.println();

      // 2nd client came to the parking
      Client client2 = new Client("Mariam", "Matar", 76181345, "A872764", parking);
      Session session2 = Main.openParkingSession(client2, employee, "22-02-2022 09:00:00");

      // 3rd CLient came to the parking
      Client client3 = new Client("Noura", "Daou", 76292444, "B423489", parking);
      Session session3 = Main.openParkingSession(client3, employee, "22-02-2022 09:30:00");

      // 4th CLient came to the parking
      Client client4 = new Client("Shadi", "Khanji", 76345123, "A222115", parking);
      Session session4 = Main.openParkingSession(client4, employee, "22-02-2022 11:00:00");

      System.out.println("A fourth client is coming. Do you want to proceed? Enter 1 or 0 (yes or no):");
      int proceed2ndTestCase = scanner.nextInt();

      if (proceed2ndTestCase == 1) {
        System.out.println();

        // 5th CLient came to the parking
        Client client5 = new Client("Tarek", "Abou Nahas", 76371724, "B311784", parking);
        // Client found no available space
        Session session5 = Main.openParkingSession(client5, employee, "22-02-2022 12:30:00");
        Main.closeParkingSession(client5, employee, "22-02-2022 12:30:00", session5);

        System.out.println("The clients will leave. Do you want to proceed? Enter 1 or 0 (yes or no):");
        int proceed3rdTestCase = scanner.nextInt();
        scanner.close();

        if (proceed3rdTestCase == 1) {
          System.out.println();

          // Clients leaving the parking
          Main.closeParkingSession(client4, employee, "22-02-2022 13:40:00", session4);
          Main.closeParkingSession(client2, employee, "22-02-2022 17:00:00", session2);
          Main.closeParkingSession(client3, employee, "22-02-2022 17:10:00", session3);
        }
      }
    }
  }

  public static Session openParkingSession(Client client, Employee employee, String date) {
    Session session = client.requestCheckIn();

    if (session != null)
      employee.checkIn(session, date);

    return session;
  }

  public static void closeParkingSession(Client client, Employee employee, String date, Session session) {
    if (session != null) {
      client.requestCheckOut(session, date);
      Receipt receipt = employee.checkOut(session);
      client.payForService(receipt);
    }
  }
}
