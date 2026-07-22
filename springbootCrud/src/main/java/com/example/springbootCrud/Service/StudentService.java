package com.example.springbootCrud.Service;

import com.example.springbootCrud.Repositry.StudentRepositry;
import com.example.springbootCrud.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepositry studrepo;

    public StudentService(StudentRepositry studrepo) {
        this.studrepo = studrepo;
    }

    public Student createStudent(Student studentReq) {
        Student response = studrepo.save(studentReq);
        return response;
    }

    public Student getStudent(Long id) {
        Optional<Student> response = studrepo.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> response = studrepo.findAll();
        return response;
    }



    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> resp = studrepo.findById(id);
        Student response = resp.get();
        response = studrepo.save(studentReq);
        return response;
    }

    public boolean delete(Long id) {
        boolean present = studrepo.existsById(id);
        if (present) {
            studrepo.deleteById(id);
            return true;
        }
        return false;
    }
}