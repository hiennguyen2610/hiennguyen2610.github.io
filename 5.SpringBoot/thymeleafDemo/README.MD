<h2>Thymeleaf</h2>
<br>
<br>
I. Khái niệm <br><br>
Thymeleaf là một template engine (trình kết xuất mẫu) được sử dụng trong các ứng dụng web Java để tạo và hiển thị các trang HTML động.<br><br>
II. Ưu điểm <br>
<br>
Thymeleaf cho phép các lập trình viên tạo ra các trang web động một cách dễ dàng và hiệu quả. Một vài ưu điểm của Thymeleaf như:<br>
1. Dễ học và sử dụng: Thymeleaf là một công cụ dễ học và sử dụng, vì nó được thiết kế để tách biệt hoàn toàn mã Java và HTML, giúp cho việc phát triển trang web động trở nên đơn giản hơn.<br>

2. Thân thiện với người dùng: Thymeleaf cung cấp các tính năng để giúp tạo ra các trang web thân thiện với người dùng, bao gồm các thẻ điều khiển, thể hiện biến, điều kiện, vòng lặp và xử lý sự kiện.<br>

3. Đa năng: Thymeleaf có thể được sử dụng với các framework phổ biến như Spring Framework, Play Framework, Grails và các framework khác.<br>

4. Tích hợp tốt với các công nghệ khác: Thymeleaf có tính tương thích cao và dễ dàng tích hợp với các công nghệ khác như CSS, JavaScript và các thư viện phổ biến khác.<br>

5. Hiệu suất tốt: Thymeleaf được thiết kế để tối ưu hóa hiệu suất, cho phép xử lý các trang web nhanh chóng và hiệu quả.<br>

6. Hỗ trợ i18n: Thymeleaf cung cấp tính năng hỗ trợ i18n (internationalization), giúp cho việc phát triển các trang web đa ngôn ngữ trở nên dễ dàng hơn.<br>

7. Dễ dàng kiểm tra và sửa lỗi: Với Thymeleaf, các lỗi có thể được phát hiện và sửa đổi dễ dàng trong quá trình phát triển, giúp tiết kiệm thời gian và nâng cao chất lượng sản phẩm.<br><br>

III. Cách sử dụng <br> <br>

1. Thêm Thymeleaf vào file pom.xml (nếu sử dụng Maven) hoặc build.gradle (nếu sử dụng Gradle) của dự án:
<br>
```c
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
    <version>3.0.12.RELEASE</version>
</dependency>
```c
<br>

2. Cấu hình Thymeleaf trong file cấu hình ứng dụng của bạn. Ví dụ, nếu bạn sử dụng Spring Framework, bạn có thể thêm các cấu hình sau vào file application.properties:
<br>
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false<br>

3. Tạo các file mẫu HTML với Thymeleaf. Các file mẫu này sẽ chứa các thẻ Thymeleaf để tạo các trang web động. Ví dụ:<br>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>My Page</title>
</head>
<body>
    <h1 th:text="${pageTitle}"></h1>
    <ul>
        <li th:each="item : ${items}" th:text="${item}"></li>
    </ul>
</body>
</html><br>
Trong ví dụ trên, chúng ta sử dụng th:each để lặp qua một danh sách các mục và th:text để hiển thị nội dung của một biến.<br>

4. Trong mã Java của bạn, tạo các đối tượng Model và đặt các giá trị vào chúng để truyền đến các file mẫu Thymeleaf. Ví dụ:<br>

@Controller
public class MyController {
    
    @GetMapping("/my-page")
    public String myPage(Model model) {
        model.addAttribute("pageTitle", "My Page");
        model.addAttribute("items", Arrays.asList("Item 1", "Item 2", "Item 3"));
        return "my-page";
    }
}
<br>
Trong ví dụ trên, chúng ta tạo một đối tượng Model và đặt các giá trị vào đó bằng phương thức addAttribute. Cuối cùng, chúng ta trả về tên của file mẫu HTML để hiển thị trang web (trong trường hợp này là "my-page").