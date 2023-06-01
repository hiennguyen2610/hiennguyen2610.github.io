package com.example.demojpa;

import com.example.demojpa.entity.User;
import com.example.demojpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_user() {
        User user = new User(null, "Hiển", "quanghien@gmail.com", LocalDate.now().plusYears(25), true);
        userRepository.save(user);
    }

    @Test
    void save_user_list() {
        List<User> userList = List.of(
                new User(null, "Hiển1", "quanghien11@gmail.com", LocalDate.now().minusYears(25), true),
                new User(null, "Hiển2", "quanghien22@gmail.com", LocalDate.now().plusYears(26), true),
                new User(null, "Hiển3", "quanghien33@gmail.com", LocalDate.now().plusYears(27), true)

        );
        userRepository.saveAll(userList);
    }

    @Test
    void find_user() {
        // Tìm theo id
        Optional<User> userOptional = userRepository.findById(1);
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
            // Kết quả của phương thức trả về đối tượng Optional
        }

        // Cập nhật
        User user = userOptional.get();
        user.setName("Hiển update");
        userRepository.save(user);

        // FindAll: lấy tất cả
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }

//    @Test
//    void test_findByName() {
//        List<User> userList = userRepository.findByName("Hiển update");
//        userList.forEach(System.out::println);
//
//        System.out.println("existByEmail");
//        boolean isExist = userRepository.existsByEmail("quanghien11@gmail.com");
//        System.out.println(isExist);
//    }

    @Test
    void example_test() {
        User user = userRepository.findByEmail("quanghien11@gmail.com").orElse(null);
        User user1 = userRepository.findByEmailUsingJPQL("quanghien11@gmail.com").orElse(null);
        User user2 = userRepository.findByEmailUsingNativeQuery("quanghien11@gmail.com").orElse(null);

        System.out.println("user" + user);
        System.out.println("user1" + user1);
        System.out.println("user2" + user2);
    }
}
