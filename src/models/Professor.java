package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Person{

    private int employeeNum;
    private ArrayList<String> teachable;

    public Professor(String firstName, String lastName, String address, LocalDate birthday, int employeeNum) {
        super(firstName, lastName, address, birthday);
        setEmployeeNum(employeeNum);
        teachable = new ArrayList<>();
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    private void setEmployeeNum(int employeeNum) {
        if (employeeNum >= 10000)
        {
            this.employeeNum = employeeNum;
        }
        else
        {
            throw new IllegalArgumentException("Employee number must be greater than 10000");
        }
    }

    public ArrayList<String> getTeachable() {
        return teachable;
    }

    /**
     * This method will ensure that the argument matches the pattern of "COMP XXXX" where X is any digit 0 - 9
     * @param courseCode
     */
    public void addTeachable (String courseCode)
    {
        if (courseCode.matches("COMP [0-9]{4}"))
        {
            teachable.add(courseCode);
        }
        else
        {
            throw new IllegalArgumentException("Course code must match the pattern of COMP XXXX where XXXX are numbers");
        }
    }

    public void setTeachable(ArrayList<String> teachable) {
        this.teachable = teachable;
    }
}

