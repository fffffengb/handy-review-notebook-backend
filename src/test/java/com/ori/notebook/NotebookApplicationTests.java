package com.ori.notebook;

import com.ori.notebook.dao.data.CardDao;
import com.ori.notebook.dao.data.LabelDao;
import com.ori.notebook.model.data.Card;
import com.ori.notebook.model.data.Label;
import com.ori.notebook.service.data.CardService;
import com.ori.notebook.service.system.UserService;
import com.ori.notebook.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class NotebookApplicationTests {

    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private CardDao cardDao;

    @Test
    void contextLoads() {
        String subject = "ori";
        System.out.println(JwtUtils.getTimeOut());

    }

    @Test
    void testDao() {

    }


}
