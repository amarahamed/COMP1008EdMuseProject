package models;

import utilities.DBUtility;

import java.time.LocalDate;
import java.util.TreeMap;

public class Student extends Person{
    private int studentNum;
    private TreeMap<String, Integer> grades;


    public Student(String firstName, String lastName, String address, LocalDate birthday, int studentNum) {
        super(firstName, lastName, address, birthday);

        setStudentNum(studentNum);
        grades = new TreeMap<>();
    }

    public int getStudentNum() {
        return studentNum;
    }

    private void setStudentNum(int studentNum) {
        if (studentNum >= 100000000)
        {
            this.studentNum = studentNum;
        }
        else
        {
            throw new IllegalArgumentException("Student number should contain at least 9 digits");
        }
    }

    public TreeMap<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(TreeMap<String, Integer> grades) {
        this.grades = grades;
    }

    /**
     * This method will validate that a courseCRN is valid and that the grade is in the range
     * of 0 - 100. if the validation passes, it will add it to the list of grades
     * @param courseCRN
     * @param grade
     */
    public void addGrades(String courseCRN, int grade)
    {
        if (!DBUtility.validCRN(courseCRN))
        {
            throw new IllegalArgumentException("course CRN not found in database");
        }
        if (grade >= 0 && grade <=100)
        {
            grades.put(courseCRN, grade);
        }
    }
    /**
     * This method receives a CRN and returns the corresponding grade earned.
     * If the crn does not exist for the student, a grade of -1 is returned
     */

    public int getGradeForCourse(String crn)
    {
        if (grades.get(crn) == null)
        {
            return -1;
        }
        // if yes return it
        return grades.get(crn);
    }

    /**
     * This method will return the number of courses that have a grade at 50 or above
     */
    public int getNumOfCoursePassed()
    {
        int numberOfPassedCourses = 0;

        // loop over the courses with grades and increases the count by 1 for an course that has
        // a grade at or above 50%
        for (Integer grade: grades.values())
        {
            numberOfPassedCourses++;
        }

        return numberOfPassedCourses;
    }
    public double getAvgGrade ()
    {
        if (grades.size() == 0)
        {
            return -1;
        }

        double sumOfGrades = 0;

        for (Integer grade: grades.values())
        {
            sumOfGrades += grade;
        }

        return  sumOfGrades/grades.size();
    }

}

