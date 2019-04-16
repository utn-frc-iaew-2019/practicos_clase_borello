package webapp.students;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class StudentDAO {

    private Sql2o sql20;

    public StudentDAO(Sql2o sql2o) {
        this.sql20 = sql2o;
    }

    public Student createStudent(String firstName, String lastName) {
        String insertQuery = "INSERT INTO Students (FirstName, LastName)" +
                "VALUES (:firstName, :lastName)";
        Student student = new Student("", "", 0);
        try (Connection con = sql20.open()) {
            int studentId = (int) con.createQuery(insertQuery, true)
                    .addParameter("firstName", firstName)
                    .addParameter("lastName", lastName)
                    .executeUpdate()
                    .getKey();
            student = new Student(firstName, lastName, studentId);
        } catch (Exception e) {
            System.out.println("Create student failed");
            System.out.println(e);
        } finally {
            return student;
        }

    }


}
