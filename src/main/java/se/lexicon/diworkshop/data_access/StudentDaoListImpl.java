package se.lexicon.diworkshop.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.diworkshop.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao{

    List<Student> storage;


    public StudentDaoListImpl() {
        storage = new ArrayList<>();
    }


    @Override
    public Student save(Student student) {
        storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        return storage.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElseThrow(RuntimeException::new);

    }

    @Override
    public List<Student> findAll() {
        return storage;
    }

    @Override
    public void delete(int id) {
        storage.remove(find(id));

    }
}
