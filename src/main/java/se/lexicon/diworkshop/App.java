package se.lexicon.diworkshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.diworkshop.config.componentScanConfig;
import se.lexicon.diworkshop.data_access.StudentDao;
import se.lexicon.diworkshop.models.Student;
import se.lexicon.diworkshop.service.StudentManagement;
import se.lexicon.diworkshop.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(componentScanConfig.class);

        // Part One
        //StudentDao studentDao = context.getBean(StudentDao.class);
//
//        studentDao.save(new Student(12,"Abbe Fr"));
//        studentDao.save(new Student(14,"Ann Fr"));
//
//        studentDao.findAll().forEach(System.out::println);



        // Part Two
       //UserInputService userInputService =context.getBean(UserInputService.class);
//
//        System.out.print("Sey something: " );
//        String string = userInputService.getString();
//        System.out.println("You said: " + string);
//
        //Part Tre
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        studentManagement.create();
        studentManagement.findAll().forEach(System.out::println);



    }
}
