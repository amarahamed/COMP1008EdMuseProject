package models;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName, lastName, address;
    private LocalDate birthday;

    public Person(String firstName, String lastName, String address, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setBirthday(birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Firstname needs to be comprised of alphabetic characters, starting with an upper case letter
     * @param firstName
     */
    public void setFirstName(String firstName) {
        // converts the first letter to uppercase
        firstName = firstName.substring(0,1) + firstName.substring(1);
        if (firstName.matches("[A-Z][a-z]*"))
        {
            this.firstName = firstName;
        }
        else
        {
            throw new IllegalArgumentException("Names must start with an uppercase and only contain alphabetic characters");
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.substring(0,1) + lastName.substring(1);
        if (lastName.matches("[A-Z][a-z]*"))
        {
            this.lastName = lastName;
        }
        else
        {
            throw new IllegalArgumentException("must contain only alphabets and not contain spaces ");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address.trim();
        if (address.length() >= 5 && address.length()<=30)
        {
            this.address = address;
        }
        else
        {
            throw new IllegalArgumentException("Address must be 5 - 30 characters");
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("birthday cannot be in the future");
        }
        else {
            this.birthday = birthday;
        }
    }

    /**
     * This returns the Person's age in years based on their birthday and the current date
     * @return
     */
    public int getAge()
    {
        // Period from birthday to now
        // returns Period object
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}

