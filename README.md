
# 🚀 Demo Gateway

Một API Gateway đơn giản, mạnh mẽ, xây dựng với **Spring Boot**.  
Giúp định tuyến request, chặn bot/spam, ghi log và cấu hình CORS linh hoạt.

---

## 🧩 Tính năng nổi bật

- 🛡️ **Chặn bot & request spam**  
   Sử dụng `BotBlockFilter` để bảo vệ hệ thống khỏi các request không mong muốn.

- 📋 **Ghi log chi tiết các request**  
   Tất cả request đều được ghi lại qua `RequestLoggingFilter`.

- 🌐 **Cấu hình CORS linh hoạt**  
   Tùy chỉnh domain truy cập với `CorsConfig`.

- 🔧 **Load biến môi trường từ `.env`**  
   Tự động đọc cấu hình qua `DotenvLoader`.

- ⚙️ **Cấu hình routing & port**  
   Dễ dàng chỉnh sửa qua `application.properties` và `.env`.

---

## 📦 Yêu cầu hệ thống

- **Java** 11+
- **Maven** 3.x

---

## 🚀 Hướng dẫn sử dụng

### 1. Clone dự án

```bash
git clone https://github.com/caovanducanh/demo_gateway.git
cd demo_gateway
```

### 2. Tạo file `.env` ở thư mục gốc

Ví dụ:

```
SERVER_PORT=8080
SPRING_APPLICATION_NAME=demo-gateway
SPRING_CLOUD_GATEWAY_ROUTES_0_ID=example-route
SPRING_CLOUD_GATEWAY_ROUTES_0_URI=http://example.org
SPRING_CLOUD_GATEWAY_ROUTES_0_PREDICATES=Path=/example/**
```

### 3. Build & chạy ứng dụng

```bash
mvn clean install
mvn spring-boot:run
```

Ứng dụng sẽ chạy trên cổng bạn cấu hình trong `.env`.

---

## �️ Cấu hình & mở rộng

- **Biến môi trường**: Tất cả biến trong `.env` sẽ được tự động load.
- **Routing**: Thêm các route gateway bằng biến `SPRING_CLOUD_GATEWAY_ROUTES_*`.
- **CORS**: Tùy chỉnh domain cho phép trong `CorsConfig.java`.

---

## 📝 Ví dụ hoạt động

- Request đến `/example/something` sẽ được chuyển tiếp tới `http://example.org/something` nếu cấu hình như trên.
- Các request bị nghi ngờ là bot/spam sẽ bị chặn bởi `BotBlockFilter`.
- Mỗi request đều được ghi log chi tiết nhờ `RequestLoggingFilter`.

---

## 📚 Tham khảo nhanh

- [Spring Cloud Gateway Documentation](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

---

## 💡 Đóng góp & liên hệ

Mọi ý kiến đóng góp hoặc báo lỗi xin gửi về [github issues](https://github.com/caovanducanh/demo_gateway/issues).

---