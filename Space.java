class Space {
  final int number;
  private boolean isReserved;
  private int currentClientId;
  private static int newSpaceNumber = 1;

  public Space(boolean isReserved, int currentClientId) {
    setIsReserved(isReserved);
    setCurrentClientId(currentClientId);
    number = newSpaceNumber;
    newSpaceNumber += 1;
  }

  public void setIsReserved(boolean isReserved) {
    this.isReserved = isReserved;
  }

  public void setCurrentClientId(int currentClientId) {
    this.currentClientId = currentClientId;
  }

  public boolean getIsReserved() {
    return isReserved;
  }

  public int getCurrentClientId() {
    return currentClientId;
  }
}
