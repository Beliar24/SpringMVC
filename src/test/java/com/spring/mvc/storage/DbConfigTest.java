package com.spring.mvc.storage;

import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.User;
import org.junit.jupiter.api.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.*;

class DbConfigTest {

    private final User CURRENT = new UserImpl("QA", 1L, "blackdid7@gmail.com");

    @Test
    public void dataSourceShouldNotBeNull() {
        DataSource dataSource = new DbConfig().dataSourceForTests();
        assertNotNull(dataSource);
    }

    @Test
    public void ShouldBeSuccessfullyConnectToDatabase() {
        DataSource dataSource = new DbConfig().dataSourceForTests();
        try (Connection connection = dataSource.getConnection()) {
            String query = "select * from users where name='QA'";
            PreparedStatement statement = connection
                    .prepareStatement(query);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            User user = new UserImpl();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet
                        .getString("name"));
                user.setEmail(resultSet
                        .getString("email"));
            }

            assertSoftly(softly -> softly.assertThat(user.getEmail()).as("The email must be same")
                    .isEqualTo(CURRENT.getEmail(),
                    softly.assertThat(user.getName()).as("The name must be same").isEqualTo(CURRENT.getName())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}