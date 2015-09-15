/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental.api.mocktests;

import dvdrental.api.CrudPageMockExample;
import static javax.swing.UIManager.get;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.MediaType;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *Customer createCustomer(String name, String surname, String idNumber
 * @author bulelani
 */
public class CrudMockPageTest {

    final String BASE_URL = "http://localhost:8080/";
    private MockMvc mockMvc;

    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(new CrudPageMockExample())
                .build();
    }

    @org.testng.annotations.Test
    public void read() throws Exception{
        mockMvc
                .perform((RequestBuilder) get(BASE_URL+"api/test/read/{id}"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) content().string("{\"name\":\"bulelani\",\"surname\":walaza}"));
    }
    
    @org.testng.annotations.Test
    public void readAll() throws Exception{
        mockMvc
                .perform((RequestBuilder) get(BASE_URL+"api/test/readall"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) content().string(
                                "{\"customers\":[{\"name\":\"bulelani\",\"surname\":walaza},"
                                        + "{\"name\":\"sihle\",\"surname\":zenzile}]}"));
    }
    
   /* @org.testng.annotations.Test
    public void create() throws Exception{
        mockMvc
                .perform(
                        post(BASE_URL+"api/test/create").contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"thando\",\"surname\":booi}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content().string("{\"name\":\"thando\",\"surname\":booi}"));
    }*/
}
