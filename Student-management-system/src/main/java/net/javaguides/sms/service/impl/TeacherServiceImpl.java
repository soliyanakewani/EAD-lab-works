package net.javaguides.sms.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.repository.TeacherRepository;
import net.javaguides.sms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public TeacherServiceImpl(TeacherRepository teacherRepository, BCryptPasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Teacher findByUsername(String username) {
        return teacherRepository.findByUsername(username);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        System.out.println("Saving teacher: " + teacher.getUsername());

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(teacher.getPassword());
        System.out.println("Hashed Password: " + hashedPassword);
        
        teacher.setPassword(hashedPassword);
        
        teacherRepository.save(teacher);
        
        System.out.println("Teacher saved successfully!");
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        // Verify the raw password against the encoded password
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
