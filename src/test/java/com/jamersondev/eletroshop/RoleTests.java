package com.jamersondev.eletroshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamersondev.eletroshop.domain.Role;
import com.jamersondev.eletroshop.enums.RoleAccess;
import com.jamersondev.eletroshop.service.RoleService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class RoleTests extends TestCase {

    @Autowired
    private RoleService roleService;

    @Autowired
    private WebApplicationContext wac;




    @Test
    public void testRestApiRegistration() throws JsonProcessingException, Exception {
        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        MockMvc mockMvc = defaultMockMvcBuilder.build();
        Role role = new Role();
        ObjectMapper objectMapper = new ObjectMapper();
        role.setRole(RoleAccess.ROLE_ADMIN);
        ResultActions resultApi = mockMvc
                    .perform(MockMvcRequestBuilders.post("/role/save")
                            .content(objectMapper.writeValueAsString(role))
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON));

        System.out.println("RETURN API: " + resultApi.andReturn().getResponse().getContentAsString());

        Role roleReturn = objectMapper.readValue(resultApi.andReturn().getResponse()
                .getContentAsString(), Role.class);

        assertEquals(role.getRole(), roleReturn.getRole());
    }


    @Test
    void registrationAccessTest(){
        Role role = new Role();
        role.setRole(RoleAccess.ROLE_ADMIN);
        roleService.rolePersistence(role);

        assertTrue(role.getId() > 1);
        assertEquals(RoleAccess.ROLE_ADMIN, role.getRole());
    }

}
