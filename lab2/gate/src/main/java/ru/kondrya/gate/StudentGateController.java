package ru.kondrya.gate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kondrya.gate.api.StudentsApi;
import ru.kondrya.gate.client.StudentDataFeignClient;
import ru.kondrya.gate.model.StudentDataCreateRequest;
import ru.kondrya.gate.model.StudentDataResponse;
import ru.kondrya.gate.model.Student;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentGateController implements StudentsApi {
    
    private final StudentDataFeignClient studentDataFeignClient;
    
    /**
     * Проксирует создание студента во внутренний DATA-SERVICE.
     * Получает запрос от клиента, преобразует модель и перенаправляет.
     */
    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        StudentDataCreateRequest dataRequest = new StudentDataCreateRequest();
        dataRequest.setFullName(student.getFirstName() + " " + student.getLastName());
        dataRequest.setPassport(student.getEmail());
        
        ResponseEntity<StudentDataResponse> dataResponse = 
            studentDataFeignClient.createStudentDataInData(dataRequest);
        
        Student gateResponse = new Student();
        if (dataResponse.getBody() != null) {
            gateResponse.setId(dataResponse.getBody().getId());
            gateResponse.setFirstName(dataResponse.getBody().getFullName());
            gateResponse.setLastName("");
            gateResponse.setEmail(dataResponse.getBody().getPassport());
        }
        
        return ResponseEntity.status(201).body(gateResponse);
    }
    
    @Override
    public ResponseEntity<Void> deleteStudent(Long id) {
        return studentDataFeignClient.deleteStudent(id);
    }
    
    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        ResponseEntity<java.util.List<StudentDataResponse>> dataResponse = 
            studentDataFeignClient.getAllStudents();
        
        List<Student> students = dataResponse.getBody() != null ? 
            dataResponse.getBody().stream()
                .map(data -> {
                    Student student = new Student();
                    student.setId(data.getId());
                    student.setFirstName(data.getFullName());
                    student.setLastName("");
                    student.setEmail(data.getPassport());
                    return student;
                })
                .toList() : 
            List.of();
        
        return ResponseEntity.ok(students);
    }
    
    @Override
    public ResponseEntity<Student> getStudentById(Long id) {
        ResponseEntity<StudentDataResponse> dataResponse = 
            studentDataFeignClient.getStudentDataByIdFromData(id);
        
        if (dataResponse.getBody() == null) {
            return ResponseEntity.notFound().build();
        }
        
        Student student = new Student();
        student.setId(dataResponse.getBody().getId());
        student.setFirstName(dataResponse.getBody().getFullName());
        student.setLastName("");
        student.setEmail(dataResponse.getBody().getPassport());
        
        return ResponseEntity.ok(student);
    }
    
    @Override
    public ResponseEntity<Student> updateStudent(Long id, Student student) {
        StudentDataCreateRequest dataRequest = new StudentDataCreateRequest();
        dataRequest.setFullName(student.getFirstName() + " " + student.getLastName());
        dataRequest.setPassport(student.getEmail());
        
        ResponseEntity<StudentDataResponse> dataResponse = 
            studentDataFeignClient.updateStudent(id, dataRequest);
        
        if (dataResponse.getBody() == null) {
            return ResponseEntity.notFound().build();
        }
        
        Student response = new Student();
        response.setId(dataResponse.getBody().getId());
        response.setFirstName(dataResponse.getBody().getFullName());
        response.setLastName("");
        response.setEmail(dataResponse.getBody().getPassport());
        
        return ResponseEntity.ok(response);
    }
}
