package com.tutorialspoint.mw;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tutorialspoint.StudentMarks;

/**
 * Modified from com.tutorialspoint.MainApp
 * http://www.tutorialspoint.com/spring/programmatic_management.htm
 */
public class MainApp2 {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("tutContext.xml");

      StudentJDBCTemplate studentJDBCTemplate = 
      (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");

      System.out.println("------Records creation--------" );
      studentJDBCTemplate.createTx("Mark Carr", 11, 99, 2010);
      studentJDBCTemplate.createTx("Juash Rosa", 20, 97, 2010);
      studentJDBCTemplate.createTx("Joe Smith", 25, 100, 2011);
      studentJDBCTemplate.createTx("Mary Johnson", 21, 89, 1998);

      System.out.println("------Listing all the records--------" );
      List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
      for (StudentMarks record : studentMarks) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.print(", Marks : " + record.getMarks());
         System.out.print(", Year : " + record.getYear());
         System.out.println(", Age : " + record.getAge());
      }
   }
}