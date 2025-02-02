package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication(scanBasePackages = "net.javaguides.sms")
@ComponentScan(basePackages = {"net.javaguides.sms", "net.javaguides.sms.config"})
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String...args) throws Exception {
		
//		Student student1 = new Student ("soliyana", "kewani", "soliyana@gmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student ("daglas", "kewani", "daglas@gmail.com");
//		studentRepository.save(student2);
//		
//		Student student3 = new Student ("bubu", "dereje", "bubu@gmail.com");
//		studentRepository.save(student3);
//		
//		Student student4 = new Student ("soli", "kew", "soli@gmail.com");
//		studentRepository.save(student4);
//		
	
	}

}
