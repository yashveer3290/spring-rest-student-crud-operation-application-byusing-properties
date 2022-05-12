package com.sunglowsys.service;

import com.sunglowsys.domain.Student;
import com.sunglowsys.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        Student stdUpdate = studentRepository.findById(id).get();
        stdUpdate.setFirstName(student.getFirstName());
        stdUpdate.setLastName(student.getLastName());
        stdUpdate.setEmail(student.getEmail());
        stdUpdate.setMobile(student.getMobile());

        return studentRepository.save(stdUpdate);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
