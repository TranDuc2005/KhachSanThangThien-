I. Chuẩn bị môi trường trên WINDOWS
1️⃣ Cài JDK 8 (BẮT BUỘC)

Spring Boot 2.1.x không hợp JDK mới

👉 Tải:

https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html

hoặc

OpenJDK 8 (Temurin)

Sau khi cài, kiểm tra:

java -version


✅ Phải là 1.8.x

2️⃣ Cài Maven

👉 https://maven.apache.org/download.cgi

Tải Binary zip

Giải nén: C:\apache-maven

Thêm vào Environment Variables

MAVEN_HOME = C:\apache-maven

Path thêm:

%MAVEN_HOME%\bin


Kiểm tra:

mvn -v

3️⃣ Cài MySQL 8.0

👉 https://dev.mysql.com/downloads/mysql/

Trong lúc cài:

Root password: 2005 (giống Ubuntu)

Port: 3306

Authentication: Use legacy (mysql_native_password) nếu có

Kiểm tra:

mysql -u root -p

4️⃣ Fix MySQL cho Spring Boot cũ (QUAN TRỌNG)

Vào MySQL:

ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY '2005';
FLUSH PRIVILEGES;

5️⃣ Tạo database
CREATE DATABASE khachsan
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

II. Mở project trên Windows
6️⃣ Copy project từ Ubuntu sang Windows

Copy TOÀN BỘ thư mục

Không thiếu:

pom.xml

src/

7️⃣ Mở bằng Eclipse / Spring Tool Suite (STS)

👉 Khuyên dùng STS cho Spring Boot cũ

Import project:
File → Import → Existing Maven Projects


Chọn thư mục project → Finish

8️⃣ Kiểm tra pom.xml (CỦA BẠN ĐÃ ĐÚNG)

✔ Spring Boot 2.1.5
✔ Java 8
✔ MySQL connector
✔ Tomcat + JSP

👉 KHÔNG đổi version lung tung

III. Cấu hình application.properties (WINDOWS)

Mở:

src/main/resources/application.properties

Sửa lại URL cho chắc:
spring.datasource.url=jdbc:mysql://localhost:3306/khachsan?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Ho_Chi_Minh&useSSL=false
spring.datasource.username=root
spring.datasource.password=2005

IV. CHẠY PROJECT (ĐÚNG CÁCH)
✅ Cách 1 (DỄ NHẤT – NÊN DÙNG)

Trong Eclipse / STS:

Right click project
→ Run As
→ Spring Boot App


Nếu không thấy “Spring Boot App”:

Đảm bảo project đã import Maven

Có file:

@SpringBootApplication
public class KhachSanThangThienApplication {
    public static void main(String[] args) {
        SpringApplication.run(KhachSanThangThienApplication.class, args);
    }
}

✅ Cách 2 (CMD – CHẮC ĂN)

Mở CMD tại thư mục project:

mvn clean package
mvn spring-boot:run


⚠ Nếu lỗi:

No plugin found for prefix 'spring-boot'


→ Chạy:

mvn clean install


rồi chạy lại.

V. KIỂM TRA CHẠY THÀNH CÔNG

Log thấy:

Tomcat started on port(s): 8080
Started KhachSanThangThienApplication


➡ Mở trình duyệt:

http://localhost:8080


Hoặc:

http://localhost:8080/login


(tùy controller)

VI. LỖI THƯỜNG GẶP & CÁCH SỬA
❌ Lỗi Access denied for user 'root'

✔ Đã fix bằng:

mysql_native_password


✔ Password đúng
✔ Port 3306

❌ Port 8080 bị chiếm

Mở CMD (Admin):

netstat -ano | findstr :8080
taskkill /PID <PID> /F


Hoặc đổi port:

server.port=8081

❌ Build SUCCESS nhưng web không lên

➡ BẮT BUỘC phải chạy Spring Boot App
mvn package KHÔNG đồng nghĩa web chạy

VII. KẾT LUẬN

👉 Project 2019 của bạn CHẠY ĐƯỢC trên Windows nếu:

JDK 8

MySQL root dùng mysql_native_password

Chạy đúng Spring Boot App
