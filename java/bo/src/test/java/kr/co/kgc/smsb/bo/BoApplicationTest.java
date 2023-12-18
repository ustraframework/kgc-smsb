package kr.co.kgc.smsb.bo;

import com.gsitm.ustra.java.test.UstraSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("kr.co.kgc.smsb")
//@EnableAutoConfiguration
//@SpringBootTest(classes = { BoApplication.class })
@Slf4j
class BoApplicationTest extends UstraSpringTest {
    @Test
    public void test() {
        System.out.println("test!!!");
    }
}