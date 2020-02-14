package cn.com.agree.huanan.ap.tl.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.agree.huanan.ap.tl.ApTlApplication;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApTlApplication.class)
public @interface ApTest {

}
