package com.sunglowsys.rest;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;

    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        LOGGER.debug("REST request to create Student / {}",student);
        Student result = studentService.save(student);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable("id")Long id){
        studentService.update(student, id);
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> result = studentService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id) {
        Student result = studentService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
 }
