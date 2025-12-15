package ru.kondrya.data_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kondrya.data_service.api.StudentsApi;
import ru.kondrya.data_service.model.Student;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentsApi {

    private final StudentDbRepository studentRepository;

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        StudentDb dbStudent = new StudentDb();
        dbStudent.setName(student.getFirstName() + " " + student.getLastName());
        dbStudent.setPassport(student.getEmail());
        StudentDb saved = studentRepository.save(dbStudent);
        
        Student response = new Student();
        response.setId(saved.getId());
        response.setFirstName(saved.getName());
        response.setLastName("");
        response.setEmail(saved.getPassport());
        
        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        List<StudentDb> dbStudents = studentRepository.findAll();
        List<Student> students = dbStudents.stream()
                .map(dbStudent -> {
                    Student student = new Student();
                    student.setId(dbStudent.getId());
                    student.setFirstName(dbStudent.getName());
                    student.setLastName("");
                    student.setEmail(dbStudent.getPassport());
                    return student;
                })
                .toList();
        return ResponseEntity.ok(students);
    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(dbStudent -> {
                    Student student = new Student();
                    student.setId(dbStudent.getId());
                    student.setFirstName(dbStudent.getName());
                    student.setLastName("");
                    student.setEmail(dbStudent.getPassport());
                    return ResponseEntity.ok(student);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Student> updateStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(dbStudent -> {
                    dbStudent.setName(student.getFirstName() + " " + student.getLastName());
                    dbStudent.setPassport(student.getEmail());
                    StudentDb updated = studentRepository.save(dbStudent);
                    
                    Student response = new Student();
                    response.setId(updated.getId());
                    response.setFirstName(updated.getName());
                    response.setLastName("");
                    response.setEmail(updated.getPassport());
                    
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}