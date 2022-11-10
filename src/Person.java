class Person {
   private int personId = 0  ;
    private String lastName="" ;
    private String firstName = "";

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Person(int personId, String lastName, String firstName) {
        this.personId = personId;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public void printPerson() {
        System.out.println(this.personId+" "+this.firstName+" "+this.lastName);
    }
}
