Spring Web MVC
I.	Khái niệm
Spring Web MVC là một framework phát triển ứng dụng web Java, được phát triển bởi Spring Framework. Nó được sử dụng để xây dựng các ứng dụng web Java và được thiết kế để cung cấp một cơ chế để xử lý yêu cầu HTTP, phân chia ứng dụng thành các thành phần tương tác và hỗ trợ các kỹ thuật bảo mật để bảo vệ ứng dụng của bạn.
Spring Web MVC được xây dựng trên các tiêu chuẩn Java EE như Servlet, JSP và JSTL, vì vậy nó có thể chạy trên bất kỳ máy chủ web hỗ trợ Java EE nào. Nó cũng có thể tích hợp với các thư viện phổ biến khác như Hibernate, MyBatis, JPA để truy cập cơ sở dữ liệu.
Spring Web MVC cung cấp một kiến trúc tổ chức ứng dụng linh hoạt, cho phép bạn chia ứng dụng thành các thành phần khác nhau như Controllers, Models và Views. Kiến trúc này giúp tách biệt các phần khác nhau của ứng dụng và giúp cho việc bảo trì, phát triển và tái sử dụng ứng dụng dễ dàng hơn.
II.	Cách sử dụng Spring MVC


 
Hình 1. Mô hình của Spring MVC


Các bước sử dụng Spring MVC
1.	Cấu hình DispatcherServlet. DispatcherServlet là một servlet chính trong Spring MVC, nó xử lý các yêu cầu và chuyển hướng chúng đến các Controller phù hợp. Bạn cần đăng ký DispatcherServlet trong tệp cấu hình web.xml hoặc trong lớp cấu hình Java.
 
2.	Tạo Controller. Bạn cần tạo các Controller để xử lý các yêu cầu HTTP từ người dùng. Controller có thể được đánh dấu bằng @Controller annotation và các phương thức xử lý yêu cầu HTTP có thể được đánh dấu bằng @RequestMapping annotation.
 
3.	Tạo View. Bạn cần tạo các View để hiển thị kết quả trả về từ Controller. Spring MVC hỗ trợ nhiều template engine như JSP, Thymeleaf, Velocity,...
 
4.	Sử dụng các thành phần khác của Spring MVC để xử lý các yêu cầu phức tạp hơn, như xác thực người dùng, xử lý tệp đính kèm, xử lý lỗi và nhiều tính năng khác. Ví dụ:
•	Model: Lưu trữ dữ liệu để truyền giữa Controller và View.
 
Trong ví dụ trên, đó là một phương thức xử lý yêu cầu để hiển thị danh sách người dùng. Phương thức này sử dụng Model để truyền danh sách người dùng từ Controller đến View.
•	ViewResolver: Xác định view tương ứng với một tên view được trả về từ một phương thức xử lý yêu cầu trong Controller.
 
Trong ví dụ này, chúng ta sử dụng InternalResourceViewResolver, một ViewResolver được cung cấp sẵn bởi Spring MVC, để tìm kiếm và trả về các tệp JSP trong thư mục "/WEB-INF/views/". Điều này đảm bảo rằng các tệp JSP của chúng ta được bảo mật và không thể truy cập trực tiếp từ trình duyệt của người dùng.
•	DataBinder: Trích xuất dữ liệu từ yêu cầu HTTP và chuyển đổi nó thành đối tượng Java.
 
Trong ví dụ trên, đó là một phương thức xử lý yêu cầu để tạo người dùng mới. Phương thức này sử dụng @ModelAttribute annotation để chuyển đổi dữ liệu từ yêu cầu HTTP thành đối tượng User. Phương thức initBinder() được đánh dấu bằng @InitBinder annotation để đăng ký một DataBinder để chuyển đổi ngày được nhập từ form thành đối tượng Date.
•	Validator: Xác nhận dữ liệu được truyền từ người dùng và báo cáo các lỗi nếu có.
 




•	ExceptionHandler: Xử lý các ngoại lệ được ném ra từ phương thức xử lý yêu cầu trong Controller.
 

