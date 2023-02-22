package uz.data.repositories;

import uz.data.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();

    Student findById(Long id);

    void update(Long id, String name, String phone, String email, String region, String district);

    void save( String name, String phone, String email, String region, String district);

    void delete(Long id);
}
