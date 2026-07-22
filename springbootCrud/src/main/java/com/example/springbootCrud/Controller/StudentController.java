package com.example.springbootCrud.Controller;

import com.example.springbootCrud.Service.StudentService;
import com.example.springbootCrud.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService s;
    StudentController(StudentService s){
        this.s=s;
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        Student createdStudent=s.createStudent(student);
        return createdStudent;
    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable Long id){
        Student resp=s.getStudent(id);
        return resp;
    }

    @GetMapping("/getAll")
    public List<Student> get(){
        List<Student> resp=s.getAllStudent();
        return resp;
    }

    @PutMapping("/put/{id}")
    public Student put(@PathVariable Long id,@RequestBody Student student ){
        Student resp=s.updateStudent(id,student);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return s.delete(id);
    }
} 