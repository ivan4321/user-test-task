package com.comparus.assessment;

import com.comparus.assessment.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.MountableFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
@EnableConfigurationProperties
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientServiceApplicationTests {

    public static final String USER_API_ENDPOINT = "/users";

    @Autowired
    protected MockMvc mockMvc;


    static PostgreSQLContainer<?> postgres1 = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("postgres")
            .withUsername("testuser")
            .withPassword("testpass")
            .withExposedPorts(5432)
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("init_postgres1.sql"),
                    "/docker-entrypoint-initdb.d/init.sql");

    static PostgreSQLContainer<?> postgres2 = new PostgreSQLContainer<>("postgres:13")
            .withDatabaseName("postgres")
            .withUsername("testuser")
            .withPassword("testpass")
            .withExposedPorts(5432)
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("init_postgres2.sql"),
                    "/docker-entrypoint-initdb.d/init.sql");


    static {
        postgres1.start();
        System.setProperty("test.db1.port", postgres1.getFirstMappedPort().toString());
        postgres2.start();
        System.setProperty("test.db2.port", postgres2.getFirstMappedPort().toString());
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Simple get all contacts")
    void all_contacts_are_getting() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get(USER_API_ENDPOINT))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn()
                .getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        List<User> result = objectMapper.readValue(responseString, new TypeReference<>() {
        });

        assertEquals(80, result.size());

    }
}
