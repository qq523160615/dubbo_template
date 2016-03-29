package com.lzh.template;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:provider-test.xml")
public class AppTest extends TestCase
{
    @Test
    public void testApp()
    {
        assertTrue(true);
    }
}
