package webapp.students;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;

public class StudentRequestHandler {
    private Request request;
    private JsonObject parsedRequest;

    public StudentRequestHandler(Request request) {
        this.request = request;
        String rawJson = request.body();
        parsedRequest = new JsonParser().parse(rawJson).getAsJsonObject();
    }

    public boolean isValidPostStudentRequest() {
        return parsedRequest.has("firstname")
                && parsedRequest.has("lastName")
                && parsedRequest.size() == 2;
    }
    public StudentInfo getStudentInfo() {
        StudentInfo student = new StudentInfo("", "");
        if (isValidPostStudentRequest()) {
            String firstName = parsedRequest.get("firstName").getAsString();
            String lastName = parsedRequest.get("lastName").getAsString();
            student = new StudentInfo(firstName, lastName);
        }
        return student;
    }
}
