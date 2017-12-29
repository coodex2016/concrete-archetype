package org.coodex.example;

import org.coodex.example.entities.AddEntity;
import org.coodex.example.repos.AddEntityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataPrepared {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-example.xml");
        AddEntityRepo addEntityRepo = context.getBean(AddEntityRepo.class);
        for (int x1 = 0; x1 < 10; x1++) {
            for (int x2 = 0; x2 < 10; x2++) {
                AddEntity addEntity = new AddEntity();
                addEntity.setX1(x1);
                addEntity.setX2(x2);
                addEntity.setSum(x1 + x2);
                addEntityRepo.save(addEntity);
            }
        }
    }
}
