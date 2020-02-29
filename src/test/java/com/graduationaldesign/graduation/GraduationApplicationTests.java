package com.graduationaldesign.graduation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraduationApplicationTests {

    @Test
    void contextLoads() {
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("00");
        String no = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()) + df.format(random.nextInt(100));
        System.out.println(no);
    }

}
