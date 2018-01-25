package com.shell.springboot.rabbitmq.sender;

import com.shell.springboot.rabbitmq.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ganguixiang on 2018/1/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DirectSenderTest {

    @Autowired
    private DirectSender directSender;

    @Test
    public void testSend() {
        directSender.send();
    }
}
