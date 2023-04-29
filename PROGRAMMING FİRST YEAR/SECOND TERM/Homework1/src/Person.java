import java.util.Calendar;
import java.util.Date;

public class Person {

    // id: int- firstName: String  lastName: String  gender: byte  birthDate: java.util.Calendar maritalStatus: byte hasDriverLicence: boolean
    private int id;
    private String firstName;
    private String lastName;


    private byte gender;
    private Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;

    public Person(int id, String firstName, String Lastname,
                  String gender, Calendar Birthrate, String maritalStatus,
                  String hasDriverLicence) throws Exception {
        this.id=id;
        this.setFirstName(firstName);
        this.setLastName(Lastname);
        this.setGender(gender);
        this.setMaritalStatus(maritalStatus);
        this.birthDate = Birthrate;
        this.setHasDriverLicence(hasDriverLicence);
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if (firstName.length() < 3) {
            try {
                throw new Exception("LastName contains at least 3 characters!!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public String getGender() {
        if (gender == 1) {
            return "Man";
        } else
            return "Woman";
    }

    public void setGender(String gender) {
        if (gender.equals("Man")) {
            this.gender = 1;
        } else if (gender.equals("Woman")) {
            this.gender = 2;
        } else try {
            throw new Exception("Invalid input");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setId(int id) {
        this.id = id;
    }


    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        if (maritalStatus == 1) {
            return "Single";
        } else return "Married";
    }

    public void setMaritalStatus(String maritalStatus) {
        switch (maritalStatus) {
            case "Single":
                this.maritalStatus = 1;
                break;
            case "Married":
                this.maritalStatus = 2;
                break;

        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        if (lastName.length() < 3) {
            try {
                throw new Exception("LastName contains at least 3 characters!!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public String isHasDriverLicence() {
        if (hasDriverLicence) {
            return "Yes";
        } else return "No";
    }

    public void setHasDriverLicence(String hasDriverLicence) {
        if (hasDriverLicence.equalsIgnoreCase("yes")) {
            this.hasDriverLicence = true;
        } else if (hasDriverLicence.equalsIgnoreCase("no")) {
            this.hasDriverLicence = false;
        } else try {
            throw new Exception("Invalid input!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\t\t\t\tPerson Info [" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + getGender() +
                "]";
    }

    public String printInfo() {
        String printİnfo = "";
        System.out.println("Person [" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", gender=" + getGender() + ", birthDate=" + getDateFormatted(birthDate)
                + ", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence=" + isHasDriverLicence() + "]");
        printİnfo += "Person [" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", gender=" + getGender() + ", birthDate=" + getDateFormatted(birthDate)
                + ", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence=" + isHasDriverLicence() + "]" + "\n";
        return printİnfo;
    }

    public String getDateFormatted(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
    }
}




