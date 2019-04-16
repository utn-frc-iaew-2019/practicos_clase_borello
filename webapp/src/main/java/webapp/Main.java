package webapp;

import static spark.Spark.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.sql2o.Sql2o;
import spark.Request;
import webapp.students.Student;
import webapp.students.StudentDAO;

public class Main {
    public static void main(String[] args) {
        try {
            Sql2o sql20 = new Sql2o("jdbc:h2:~/test", "sa", "");
            port(8080);


            post("/hello", ((request, response) -> processRequest(request)));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String processRequest(Request request) {
        String body = request.body();
        JsonObject json = new JsonParser().parse(body).getAsJsonObject();
        String firstName = json.get("firstName").getAsString();
        String lastName = json.get("lastName").getAsString();
        return firstName + " " + lastName;
    }
}
