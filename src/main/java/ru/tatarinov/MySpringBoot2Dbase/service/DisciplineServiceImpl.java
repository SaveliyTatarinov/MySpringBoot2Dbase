package ru.tatarinov.MySpringBoot2Dbase.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tatarinov.MySpringBoot2Dbase.dao.DisciplineDao;
import ru.tatarinov.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService{
    @Autowired
    private DisciplineDao disciplineDao;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplineDao.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineDao.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplineDao.getDiscipline(id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        disciplineDao.deleteDiscipline(id);
    }
}
