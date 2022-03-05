class Parking {
  final String name;
  final String address;
  final int feesPerHour;
  final Currency currency;
  final int totalSpaces;
  // A matrix of the parking spaces
  // m * n: number of floors * number of spaces on each floor
  private final Space[][] allSpaces;

  public Parking(String name, String address, int feesPerHour, Currency currency, int totalFloors, int floorSpaces) {
    this.name = name;
    this.address = address;
    this.feesPerHour = feesPerHour;
    this.currency = currency;
    totalSpaces = totalFloors * floorSpaces;
    allSpaces = new Space[totalFloors][floorSpaces];

    for (int i = 0; i < allSpaces.length; i++) {
      for (int j = 0; j < allSpaces[i].length; j++) {
        allSpaces[i][j] = new Space(false, 0);
      }
    }

    System.out.println("\nParking: " + this.name);
    System.out.println(" Address: " + this.address);
    System.out.println(" Fees per Hour: " + this.feesPerHour + " " + currency);
    System.out.println(" Total Spaces: " + totalSpaces + "\n");
  }

  public Space findFreeSpace() {
    Space freeSpace = null;

    for (int i = 0; i < allSpaces.length; i++) {
      for (int j = 0; j < allSpaces[i].length; j++) {
        if (allSpaces[i][j].getIsReserved() == false) {
          freeSpace = allSpaces[i][j];
          break;
        }
      }
      // Once a free space is found
      // Stop looking for an available one
      if (freeSpace != null)
        break;
    }

    return freeSpace;
  }

  public Space assignFreeSpace(int clientId) {
    Space assignedSpace = findFreeSpace();

    assignedSpace.setIsReserved(true);
    assignedSpace.setCurrentClientId(clientId);

    return assignedSpace;
  }
}

enum Currency {
  LBP, USD, EURO
}
