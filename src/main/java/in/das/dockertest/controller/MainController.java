package in.das.dockertest.controller;

import in.das.dockertest.models.response.BasicResponse;
import in.das.dockertest.models.response.StudentResponse;
import in.das.dockertest.models.resquest.StudentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Slf4j
public class MainController {

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BasicResponse testServer(){
        log.info("Invoked server-test..");
        return new BasicResponse(){{
            setStatusCode(200);
            setMessage("Server Up");
        }};
    }

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StudentResponse studentConfirmation(RequestEntity<StudentRequest> studentRequestEntity){
        log.info("invoking '/student' api..");
        StudentRequest studentRequest = studentRequestEntity.getBody();
        String uuid = UUID.randomUUID().toString();
        if (studentRequest != null && Objects.equals(studentRequest.getStudentName(), "xxx")){
            return new StudentResponse(){{
                setStatusMessage("Student not confirmed! Invalid error");
                setConfirmationId(uuid);
            }};
        }
        return new StudentResponse(){{
            setStatusMessage("Student confirmed! Congrats");
            setConfirmationId(uuid);
        }};
    }
}
