package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;
import ru.itis.group.MusicianFactory;
import ru.itis.group.listener.Listener;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
        Audition audition = ac.getBean(Audition.class);
        MusicianFactory mf = ac.getBean(MusicianFactory.class);

        audition.addMember(mf.getMusician("drummer"));
        audition.addMember(mf.getMusician("pianist"));
        audition.addMember(mf.getMusician("trumpeter"));
        audition.addMember(mf.getMusician("guitarist"));
        audition.addMember(mf.getMusician("violinist"));

        //если раскоментировать строку ниже, произойдет исключение, логгер его отобразит
        //audition.start();

        audition.setListener(new Listener("Jackob"));

        audition.start();
    }
}
