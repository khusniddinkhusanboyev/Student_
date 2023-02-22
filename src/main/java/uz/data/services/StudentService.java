package uz.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.data.model.Student;
import uz.data.repositories.StudentRepository;

import java.util.List;

@Component
public class StudentService {
    private StudentRepository crud;
    @Autowired
    public StudentService(StudentRepository crud) {
        this.crud = crud;
    }
    public List<Student> getAll() {
        return crud.getAll();
    }
    public void create(String name, String phone, String email, String region, String district) {
        crud.save(name, phone, email,region,district);
    }
    public void delete(Long id) {
        crud.delete(id);
    }
    public Student find(Long id) {
        Student flag = null;
        for (Student student : crud.getAll()) {
            if (student.getId() == id) {
                flag = student;
            }
        }
        return flag;
    }
    public void update(String name, String number, String email, String region, String district, Long id) {
        crud.update(id,name, number, email,region,district );
    }


}
