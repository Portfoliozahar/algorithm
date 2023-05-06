package Error_processing_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Person {
    private String surname;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String gender;

    public Person(String surname, String firstName, String patronymic, LocalDate dateOfBirth, String phoneNumber,
            String gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;

    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        String dobString = dateFormatter.format(dateOfBirth);
        return surname + " " + firstName + " " + patronymic + " " + dobString + " " + phoneNumber + " " + gender;
    }
}