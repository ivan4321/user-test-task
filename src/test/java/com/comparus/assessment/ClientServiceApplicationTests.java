package com.comparus.assessment;

import com.comparus.assessment.api.UserFilter;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.MountableFile;

import java.util.List;
import java.util.Map;

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

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Simple get all contacts")
    void all_contacts_are_getting() throws Exception {
        List<User> result = getUsers();

        assertEquals(80, result.size());

    }

    @Test
    @DisplayName("Get filtered contact")
    void filtered_contacts_are_getting() throws Exception {
        List<User> result = getUsers(new UserFilter() {{
            setName("Endy");
        }});

        assertEquals(1, result.size());
        User expected = new User() {{
            setId("50");
            setUsername("elder");
            setName("Endy");
            setSurname("Siblingenko");
        }};
        assertEquals(expected, result.get(0));

    }

    private List<User> getUsers() throws Exception {
        return getUsers(new UserFilter());
    }

    private List<User> getUsers(UserFilter userFilter) throws Exception {

        String responseString = mockMvc.perform(MockMvcRequestBuilders.get(USER_API_ENDPOINT).params(convertToParams(userFilter)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn()
                .getResponse().getContentAsString();

        return mapper.readValue(responseString, new TypeReference<>() {
        });
    }

    private MultiValueMap<String, String> convertToParams(Object request) {
        Map<String, Object> map = mapper.convertValue(request, new TypeReference<>() {
        });

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        map.forEach((key, value) -> {
            if (value != null) {
                params.add(key, value.toString());
            }
        });
        return params;
    }

}
