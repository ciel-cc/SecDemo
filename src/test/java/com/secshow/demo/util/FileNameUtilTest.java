package com.secshow.demo.util;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FileNameUtilTest {

    @Test
    void getFileName() {
        System.out.println(FileNameUtil.getFileName("abcd.jpg"));
        System.out.println(FileNameUtil.getFileName("fseswa.jpg"));
    }
}