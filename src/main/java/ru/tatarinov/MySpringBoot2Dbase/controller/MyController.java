package ru.tatarinov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tatarinov.MySpringBoot2Dbase.entity.Student;
import ru.tatarinov.MySpringBoot2Dbase.model.Result;
import ru.tatarinov.MySpringBoot2Dbase.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Result<List<Student>> getAllStudents() {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public Result<Student> getStudent(@PathVariable("id") int id) {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.getStudent(id));
    }

    @PostMapping("/students")
    public Result<Student> saveStudent(@RequestBody Student student) {
        return new Result<>(Result.SUCCESS_MESSAGE, studentService.saveStudent(student));
    }

    @PutMapping("/students")
    public Result<Student> updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new Result<>(Result.SUCCESS_MESSAGE, student);
    }

    @DeleteMapping("/students/{id}")
    public Result<Object> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return new Result<>(Result.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
