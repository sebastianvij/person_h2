package com.example.person_h2;

import com.example.person_h2.model.Person;
import com.example.person_h2.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:h2init.sql", executionPhase = BEFORE_TEST_METHOD)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repo;

    @Test
    void readAll() {
        List<Person> all = repo.findAll();

        assertThat(all).isNotNull();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getName()).isEqualTo("Alice");
        assertThat(all.get(1).getName()).isEqualTo("Bob");
    }


    @Test
    void insertAndReadBack() {
        repo.save(new Person(3, "Carol"));
        var carol = repo.findById(3);
        assertThat(carol).isNotNull();
        assertThat(carol.getName()).isEqualTo("Carol");
    }
}
