class Person {
  private String firstName;
  private String lastName;
  final int id;

  public Person(String firstName, String lastName, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }
}
