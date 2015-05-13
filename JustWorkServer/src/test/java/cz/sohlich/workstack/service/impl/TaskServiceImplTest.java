/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack.service.impl;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import cz.sohlich.workstack.GenericTest;
import cz.sohlich.workstack.api.dto.TaskDTO;
import cz.sohlich.workstack.domain.Task;
import cz.sohlich.workstack.repository.TaskRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author radek
 */
public class TaskServiceImplTest extends GenericTest {

    @Mock TaskRepository taskRepository;
    @InjectMocks TaskServiceImpl taskService;

    Task testObject;

    public TaskServiceImplTest() {
        testObject = new Task();
        testObject.setId("testId");
        testObject.setName("Test name");
        testObject.setOrder(1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskService).build();
        RestAssuredMockMvc.mockMvc = mockMvc;
        Mockito.when(taskRepository.findOne(Matchers.anyString())).thenReturn(testObject);
        Mockito.when(taskRepository.save(Matchers.any(Task.class))).thenAnswer((InvocationOnMock invocation) -> (Task)invocation.getArguments()[0]);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createOrUpdateTask method, of class TaskServiceImpl.
     */
    @Test
    public void testCreateOrUpdateTask() {
        System.out.println("createOrUpdateTask");
        TaskDTO dto = new TaskDTO();
        dto.setId("testId");
        dto.setName("My Name");
        TaskDTO result = taskService.createOrUpdateTask(dto);
        assertEquals(testObject.getId(), result.getId());
        assertEquals(1L, (long) result.getOrder());
        assertEquals("My Name", result.getName());
    }

}
