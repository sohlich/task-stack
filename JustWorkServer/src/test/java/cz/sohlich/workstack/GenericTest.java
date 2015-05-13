/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * The generic class for all integration tests
 *
 * @author radek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class GenericTest {

    @Autowired protected WebApplicationContext wac; // cached
    @Autowired protected MockServletContext servletContext; // cached
    @Autowired protected MockHttpSession session;
    @Autowired protected MockHttpServletRequest request;
    @Autowired protected MockHttpServletResponse response;
    @Autowired protected ServletWebRequest webRequest;

    protected MockMvc mockMvc;

    public GenericTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
       
    }


    @Test
    public void basicMethod() {

    }

}