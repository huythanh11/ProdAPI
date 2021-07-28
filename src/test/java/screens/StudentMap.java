package screens;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import utilities.RestAPIUtil;

public class StudentMap {



    public String createStudent() throws JsonProcessingException {

        Students student =  new Students();
        student.setFirstname("Tao la vua");
        student.setLastname("Kingdom");
        student.setUsername("taolavua");
        student.setPassword("taolapassword");
        ObjectMapper objectMapper = new ObjectMapper();
        String createjson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
//        System.out.println(createjson);
        return  createjson;
    }
}
