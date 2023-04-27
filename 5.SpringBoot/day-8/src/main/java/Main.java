import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
   static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Student student = Student.builder()
                .id(3)
                .name("abc")
                .hometown("HN")
                .gpa(7.0)
                .build();
        System.out.println(student);
        log.info(student);
    }


}
