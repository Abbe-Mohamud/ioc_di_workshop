package se.lexicon.diworkshop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.diworkshop.config.componentScanConfig;
import se.lexicon.diworkshop.data_access.StudentDao;

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


        StudentDao studentDao = context.getBean(StudentDao.class);

    }
}
