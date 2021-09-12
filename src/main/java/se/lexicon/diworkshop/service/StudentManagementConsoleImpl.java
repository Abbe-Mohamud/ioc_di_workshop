package se.lexicon.diworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.diworkshop.data_access.StudentDao;
import se.lexicon.diworkshop.models.Student;
import se.lexicon.diworkshop.util.UserInputService;


import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {


    UserInputService userInputService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }



    @Override
    public Student create() {
        System.out.print("Id: ");
        int id = userInputService.getInt();

        System.out.print("Name: ");
        String name = userInputService.getString();

        return save(new Student(id,name));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);
        studentDao.delete(id);
        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {

        if (find(student.getId()) !=null){
            studentDao.delete(student.getId());
            studentDao.save(student);
        }
        return student;
    }
}
