package me.harry.study

import me.harry.study.model.Board
import me.harry.study.model.User
import me.harry.study.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
class StudyApplicationTests {

    @Test
    @Transactional
    fun contextLoads() {
    }

}
