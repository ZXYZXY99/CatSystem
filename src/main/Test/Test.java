import com.entity.UserEntity;
import com.service.DoDateBase;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {


    public static void main(String[] args) {

//        ApplicationContext applicationContext=
//                new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext=
                new FileSystemXmlApplicationContext("C:\\Users\\LENOVO\\IdeaProjects\\Test\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");


        DoDateBase doDateBase=fileSystemXmlApplicationContext.getBean("doDateBase",
                DoDateBase.class);

        UserEntity userEntity=new UserEntity();
        userEntity.setPassword("123");
        userEntity.setUsername("2323");
        doDateBase.addUser(userEntity);
        System.out.println(doDateBase);

    }
}
