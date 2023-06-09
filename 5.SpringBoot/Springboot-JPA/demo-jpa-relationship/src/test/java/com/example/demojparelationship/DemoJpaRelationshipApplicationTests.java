package com.example.demojparelationship;

import com.example.demojparelationship.entity.IdentityCard;
import com.example.demojparelationship.entity.Post;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.IdentityCardRepository;
import com.example.demojparelationship.repository.PostRepository;
import com.example.demojparelationship.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Properties;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

class DemoJpaRelationshipApplicationTests {

    @Autowired
    private IdentityCardRepository identityCardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    void save_user_1() {
        Faker faker = new Faker();

        // Tạo card
        IdentityCard identityCard = new IdentityCard(null, "111");
        identityCardRepository.save(identityCard);

        // Tạo card
//        User user = new User(null, "Nguyễn Văn A", "a@gmail.com", "1111", identityCard);
//        userRepository.save(user);
    }

    @Test
    void save_user_2() {
        User user = User.builder()
                .name("trần văn b")
                .email("ass@gmail.com")
                .password("111")
                .identityCard(
                        new IdentityCard(null, "111")
                )
                .build();
        userRepository.save(user);
    }

    @Test
    void find_user() {
        User user = userRepository.findById(2).orElse(null);
        System.out.println(user);
    }

    @Test
    @Rollback(value = false)
    void delete_user() {
        userRepository.deleteById(2);
    }

    @Test
    @Rollback(value = false)
    void save_user_post() {
        User user = User.builder()
                .name("Trần Thị C")
                .email("asdfs@gmail.com")
                .password("111")
                .build();
        userRepository.save(user);

        for (int i = 0; i < 3; i++) {
            Post post = new Post(null,"post-" + (i+1), user);
            postRepository.save(post);

        }
    }

    @Test
    @Rollback(value = false)
    void orphan_removal() {
        User user = userRepository.findById(7).orElse(null);

        List<Post> posts = user.getPosts();
        posts.remove(0);
    }

    @Test
    void find_user_fetch() {
        User user = userRepository.findById(4).orElse(null);
        System.out.println(user);
    }
}
