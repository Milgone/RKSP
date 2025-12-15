package ru.kondrya.gate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kondrya.gate.model.StudentDataCreateRequest;
import ru.kondrya.gate.model.StudentDataResponse;

@FeignClient(name = "data-service", url = "http://localhost:8083")
public interface StudentDataFeignClient {
    
    @PostMapping("/api/students")
    ResponseEntity<StudentDataResponse> createStudentDataInData(
            @RequestBody StudentDataCreateRequest request);
    
    @GetMapping("/api/students")
    ResponseEntity<java.util.List<StudentDataResponse>> getAllStudents();
    
    @GetMapping("/api/students/{id}")
    ResponseEntity<StudentDataResponse> getStudentDataByIdFromData(
            @PathVariable("id") Long id);
    
    @DeleteMapping("/api/students/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id);
    
    @PutMapping("/api/students/{id}")
    ResponseEntity<StudentDataResponse> updateStudent(
            @PathVariable("id") Long id,
            @RequestBody StudentDataCreateRequest request);
}
