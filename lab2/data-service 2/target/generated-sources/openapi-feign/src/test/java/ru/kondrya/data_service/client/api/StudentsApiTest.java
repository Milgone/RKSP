package ru.kondrya.data_service.client.api;

import ru.kondrya.data_service.client.ApiClient;
import ru.kondrya.data_service.client.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StudentsApi
 */
class StudentsApiTest {

    private StudentsApi api;

    @BeforeEach
    public void setup() {
        api = new ApiClient().buildClient(StudentsApi.class);
    }

    
    /**
     * Create a new student
     *
     * 
     */
    @Test
    void createStudentTest() {
        Student student = null;
        // Student response = api.createStudent(student);

        // TODO: test validations
    }

    
    /**
     * Delete student
     *
     * 
     */
    @Test
    void deleteStudentTest() {
        Long id = null;
        // api.deleteStudent(id);

        // TODO: test validations
    }

    
    /**
     * Get all students
     *
     * 
     */
    @Test
    void getAllStudentsTest() {
        // List<Student> response = api.getAllStudents();

        // TODO: test validations
    }

    
    /**
     * Get student by ID
     *
     * 
     */
    @Test
    void getStudentByIdTest() {
        Long id = null;
        // Student response = api.getStudentById(id);

        // TODO: test validations
    }

    
    /**
     * Update student
     *
     * 
     */
    @Test
    void updateStudentTest() {
        Long id = null;
        Student student = null;
        // Student response = api.updateStudent(id, student);

        // TODO: test validations
    }

    
}
