package net.javaguides.sms.service;

import net.javaguides.sms.entity.Teacher;

public interface TeacherService {
    Teacher findByUsername(String username);
    void saveTeacher(Teacher teacher);
    boolean checkPassword(String rawPassword, String encodedPassword); 
}
