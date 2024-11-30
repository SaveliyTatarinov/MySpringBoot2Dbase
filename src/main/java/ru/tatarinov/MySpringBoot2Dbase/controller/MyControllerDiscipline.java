package ru.tatarinov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tatarinov.MySpringBoot2Dbase.entity.Discipline;
import ru.tatarinov.MySpringBoot2Dbase.model.Result;
import ru.tatarinov.MySpringBoot2Dbase.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyControllerDiscipline {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public Result<List<Discipline>> getAllDisciplines() {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.getAllDisciplines());
    }

    @GetMapping("/disciplines/{id}")
    public Result<Discipline> getDiscipline(@PathVariable("id") int id) {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.getDiscipline(id));
    }

    @PostMapping("/disciplines")
    public Result<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        return new Result<>(Result.SUCCESS_MESSAGE, disciplineService.saveDiscipline(discipline));
    }

    @PutMapping("/disciplines")
    public Result<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        disciplineService.saveDiscipline(discipline);
        return new Result<>(Result.SUCCESS_MESSAGE, discipline);
    }

    @DeleteMapping("/disciplines/{id}")
    public Result<Object> deleteDiscipline(@PathVariable("id") int id) {
        disciplineService.deleteDiscipline(id);
        return new Result<>(Result.SUCCESS_MESSAGE, null);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
