package ru.kondrya.data_service.client.api;

import ru.kondrya.data_service.client.ApiClient;
import ru.kondrya.data_service.client.EncodingUtils;
import ru.kondrya.data_service.client.model.ApiResponse;

import ru.kondrya.data_service.client.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-15T19:24:59.953506586Z[Etc/UTC]", comments = "Generator version: 7.15.0")
public interface StudentsApi extends ApiClient.Api {


  /**
   * Create a new student
   * 
   * @param student  (required)
   * @return Student
   */
  @RequestLine("POST /api/students")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Student createStudent(@jakarta.annotation.Nonnull Student student);

  /**
   * Create a new student
   * Similar to <code>createStudent</code> but it also returns the http response headers .
   * 
   * @param student  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/students")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Student> createStudentWithHttpInfo(@jakarta.annotation.Nonnull Student student);



  /**
   * Delete student
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/students/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteStudent(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete student
   * Similar to <code>deleteStudent</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/students/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteStudentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Get all students
   * 
   * @return List&lt;Student&gt;
   */
  @RequestLine("GET /api/students")
  @Headers({
    "Accept: application/json",
  })
  List<Student> getAllStudents();

  /**
   * Get all students
   * Similar to <code>getAllStudents</code> but it also returns the http response headers .
   * 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/students")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<Student>> getAllStudentsWithHttpInfo();



  /**
   * Get student by ID
   * 
   * @param id  (required)
   * @return Student
   */
  @RequestLine("GET /api/students/{id}")
  @Headers({
    "Accept: application/json",
  })
  Student getStudentById(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Get student by ID
   * Similar to <code>getStudentById</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/students/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Student> getStudentByIdWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Update student
   * 
   * @param id  (required)
   * @param student  (required)
   * @return Student
   */
  @RequestLine("PUT /api/students/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Student updateStudent(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull Student student);

  /**
   * Update student
   * Similar to <code>updateStudent</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param student  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/students/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Student> updateStudentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull Student student);


}
