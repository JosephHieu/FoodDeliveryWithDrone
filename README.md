# 🍕 Hệ Thống Giao Đồ Ăn Bằng Drone

Một nền tảng giao đồ ăn hiện đại, có khả năng mở rộng với công nghệ giao hàng bằng drone đổi mới, được xây dựng theo kiến trúc microservices. Hệ thống này cho phép khách hàng đặt đồ ăn từ các nhà hàng và được giao bởi drone tự động, cung cấp dịch vụ giao hàng nhanh chóng và hiệu quả.

## 📋 Mục Lục

- [Tổng Quan](#tổng-quan)
- [Tính Năng](#tính-năng)
- [Kiến Trúc Hệ Thống](#kiến-trúc-hệ-thống)
- [Công Nghệ Sử Dụng](#công-nghệ-sử-dụng)
- [Yêu Cầu](#yêu-cầu)
- [Cài Đặt](#cài-đặt)
- [Cấu Hình](#cấu-hình)
- [Chạy Ứng Dụng](#chạy-ứng-dụng)
- [Tài Liệu API](#tài-liệu-api)
- [Cấu Trúc Dự Án](#cấu-trúc-dự-án)
- [Đóng Góp](#đóng-góp)
- [Giấy Phép](#giấy-phép)

## 🌟 Tổng Quan

Hệ Thống Giao Đồ Ăn Bằng Drone là một giải pháp toàn diện kết hợp đặt đồ ăn truyền thống với công nghệ giao hàng bằng drone tiên tiến. Được xây dựng với kiến trúc microservices, hệ thống có khả năng mở rộng cao, dễ bảo trì và được thiết kế để xử lý các tình huống giao hàng thực tế.

### Khả Năng Chính

- **Hỗ trợ đa người dùng**: Phục vụ khách hàng, chủ nhà hàng và quản trị viên
- **Theo dõi thời gian thực**: Theo dõi đơn hàng và drone trực tiếp trên bản đồ tương tác
- **Giao hàng tự động**: Phân công drone thông minh và tối ưu hóa tuyến đường
- **Thanh toán an toàn**: Xử lý thanh toán tích hợp với nhiều phương thức
- **Quản lý nhà hàng**: Hệ thống quản lý nhà hàng và thực đơn hoàn chỉnh

## ✨ Tính Năng

### Dành Cho Khách Hàng

- 🔐 Xác thực người dùng và quản lý hồ sơ
- 🍔 Duyệt nhà hàng và sản phẩm
- 🛒 Quản lý giỏ hàng
- 📝 Đặt hàng và theo dõi đơn hàng
- 💳 Nhiều phương thức thanh toán (MoMo, Tiền mặt, v.v.)
- 🗺️ Theo dõi giao hàng thời gian thực với trực quan hóa bản đồ
- 📍 Quản lý nhiều địa chỉ giao hàng
- 📱 Giao diện web responsive

### Dành Cho Chủ Nhà Hàng

- 🏪 Quản lý hồ sơ nhà hàng
- 🍽️ Quản lý thực đơn và sản phẩm
- 📦 Quản lý đơn hàng và cập nhật trạng thái
- 📊 Phân tích bán hàng và báo cáo
- 🖼️ Tải lên hình ảnh cho sản phẩm

### Dành Cho Quản Trị Viên

- 👥 Quản lý người dùng (khách hàng, chủ nhà hàng, quản trị viên)
- 🍴 Quản lý và phê duyệt nhà hàng
- 🚁 Quản lý đội drone
- 📊 Phân tích toàn hệ thống
- 💰 Giám sát thanh toán và đơn hàng

### Hệ Thống Giao Hàng Bằng Drone

- 🤖 Phân công drone tự động
- 📍 Theo dõi GPS thời gian thực
- 🔋 Giám sát pin
- 🛣️ Tối ưu hóa tuyến đường
- 🚦 Quản lý trạng thái giao hàng

## 🏗️ Kiến Trúc Hệ Thống

Hệ thống tuân theo **kiến trúc microservices** với các thành phần sau:

```
┌─────────────────────────────────────────────────────────────┐
│                    Frontend (React)                          │
│                                   │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│                API Gateway (Port 8080)                       │
└────────────────────────┬────────────────────────────────────┘
                         │
        ┌────────────────┼────────────────┐
        │                │                │
        ▼                ▼                ▼
┌──────────────┐ ┌──────────────┐ ┌──────────────┐
│ User Service │ │Order Service │ │Drone Service │
│  (Port 8081) │ │ (Port 8082)  │ │ (Port 8084)  │
└──────────────┘ └──────────────┘ └──────────────┘
        │                │                │
        ▼                ▼                ▼
┌─────────────────────────────────────────────────────────────┐
│                  MongoDB Atlas Database                      │
└─────────────────────────────────────────────────────────────┘

Các Service Bổ Sung:
├── Cart Service (Port 8086)
├── Payment Service (Port 8087)
├── Delivery Service (Port 8088)
├── Product Service (Port 8089)
├── Restaurant Service (Port 8090)
└── Eureka Server (Port 8761) - Service Discovery
```

### Các Microservices

1. **Eureka Server** (Port 8761): Khám phá và đăng ký dịch vụ
2. **API Gateway** (Port 8080): Điểm vào duy nhất, định tuyến và cân bằng tải
3. **User Service** (Port 8081): Xác thực, phân quyền và quản lý hồ sơ người dùng
4. **Order Service** (Port 8082): Xử lý và quản lý đơn hàng
5. **Drone Service** (Port 8084): Quản lý đội drone và phân công
6. **Cart Service** (Port 8086): Các thao tác giỏ hàng
7. **Payment Service** (Port 8087): Xử lý thanh toán
8. **Delivery Service** (Port 8088): Theo dõi và quản lý giao hàng
9. **Product Service** (Port 8089): Quản lý danh mục sản phẩm
10. **Restaurant Service** (Port 8090): Thông tin và quản lý nhà hàng

## 🛠️ Công Nghệ Sử Dụng

### Backend

- **Framework**: Spring Boot 3.1.5
- **Ngôn ngữ**: Java 17
- **Microservices**: Spring Cloud (Eureka, Gateway)
- **Cơ sở dữ liệu**: MongoDB Atlas
- **Bảo mật**: JWT (JSON Web Tokens)
- **Build Tool**: Maven
- **Container hóa**: Docker

### Frontend

- **Framework**: React 19.1.1
- **Ngôn ngữ**: TypeScript 5.9.3
- **Build Tool**: Vite 7.1.7
- **UI Framework**: Tailwind CSS 4.1.14
- **Quản lý State**: SWR 2.3.6
- **Routing**: React Router DOM 7.9.4
- **HTTP Client**: Axios 1.12.2
- **Bản đồ**: React Leaflet 5.0.0
- **Rich Text Editor**: Tiptap 3.7.2
- **Thông báo**: React Hot Toast 2.6.0
- **Icons**: Lucide React, React Icons

### DevOps & Công Cụ

- **Version Control**: Git
- **API Testing**: Postman (khuyến nghị)
- **IDE**: IntelliJ IDEA / VS Code
- **Package Manager**: npm, Maven

## 📋 Yêu Cầu

Trước khi bắt đầu, hãy đảm bảo bạn đã cài đặt:

- **Java Development Kit (JDK) 17** hoặc cao hơn
- **Node.js 18** hoặc cao hơn
- **npm 9** hoặc cao hơn
- **Maven 3.8** hoặc cao hơn
- **Docker** (tùy chọn, cho container hóa)
- **Git**
- **Tài khoản MongoDB Atlas** (hoặc MongoDB local)

## 🚀 Cài Đặt

### 1. Clone Repository

```bash
git clone https://github.com/yourusername/FoodDeliveryWithDrone.git
cd FoodDeliveryWithDrone
```

### 2. Cài Đặt Backend

#### Cài Đặt Dependencies Cho Tất Cả Services

Di chuyển đến từng thư mục service và chạy:

```bash
# Eureka Server
cd backend/eureka_server
mvn clean install

# API Gateway
cd ../api_gateway
mvn clean install

# User Service
cd ../user_service
mvn clean install

# Order Service
cd ../order_service
mvn clean install

# Drone Service
cd ../drone_service
mvn clean install

# Cart Service
cd ../cart_service
mvn clean install

# Payment Service
cd ../payment_service
mvn clean install

# Delivery Service
cd ../delivery_service
mvn clean install

# Product Service
cd ../product_service
mvn clean install

# Restaurant Service
cd ../restaurant_service
mvn clean install
```

### 3. Cài Đặt Frontend

```bash
cd frontend
npm install
```

## ⚙️ Cấu Hình

### Cấu Hình Backend

Mỗi service có file `application.properties` riêng trong `src/main/resources/`.

#### Các Mục Cấu Hình Quan Trọng:

1. **Kết Nối MongoDB** (Cập nhật trong mỗi service):

```properties
spring.data.mongodb.uri=mongodb+srv://your-username:your-password@your-cluster.mongodb.net/?appName=YourApp
spring.data.mongodb.database=your_database_name
```

2. **Cấu Hình Eureka Server**:

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

3. **Cấu Hình JWT** (User Service):

```properties
jwt.secret=your-secret-key-here
jwt.expiration=86400000
```

### Cấu Hình Frontend

Tạo file `.env` trong thư mục `frontend`:

```env
VITE_API_BASE_URL=http://localhost:8080
VITE_MAP_TILE_URL=https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png
```

## 🏃 Chạy Ứng Dụng

### Khởi Động Các Backend Services (Theo Thứ Tự)

1. **Khởi động Eureka Server trước**:

```bash
cd backend/eureka_server
mvn spring-boot:run
```

Đợi cho đến khi Eureka khởi động hoàn toàn (kiểm tra http://localhost:8761)

2. **Khởi động API Gateway**:

```bash
cd backend/api_gateway
mvn spring-boot:run
```

3. **Khởi động Tất Cả Các Services Khác** (có thể khởi động song song):

```bash
# User Service
cd backend/user_service
mvn spring-boot:run

# Order Service
cd backend/order_service
mvn spring-boot:run

# Drone Service
cd backend/drone_service
mvn spring-boot:run

# Cart Service
cd backend/cart_service
mvn spring-boot:run

# Payment Service
cd backend/payment_service
mvn spring-boot:run

# Delivery Service
cd backend/delivery_service
mvn spring-boot:run

# Product Service
cd backend/product_service
mvn spring-boot:run

# Restaurant Service
cd backend/restaurant_service
mvn spring-boot:run
```

### Khởi Động Frontend

```bash
cd frontend
npm run dev
```

Ứng dụng sẽ có sẵn tại:

- **Frontend**: http://localhost:5173 (hoặc cổng hiển thị trong terminal)
- **API Gateway**: http://localhost:8080
- **Eureka Dashboard**: http://localhost:8761

## 📚 Tài Liệu API

### Base URL

```
http://localhost:8080
```

### Endpoints Xác Thực

#### Đăng Ký Người Dùng

```http
POST /api/users/register
Content-Type: application/json

{
  "username": "string",
  "email": "string",
  "password": "string",
  "phone": "string",
  "role": "CUSTOMER|RESTAURANT_OWNER|ADMIN"
}
```

#### Đăng Nhập

```http
POST /api/users/login
Content-Type: application/json

{
  "email": "string",
  "password": "string"
}
```

### Endpoints Đơn Hàng

#### Tạo Đơn Hàng

```http
POST /api/orders
Authorization: Bearer {token}
Content-Type: application/json

{
  "cartId": "string",
  "deliveryAddressId": "string",
  "paymentMethod": "string"
}
```

#### Lấy Đơn Hàng Của Người Dùng

```http
GET /api/orders/user/{userId}
Authorization: Bearer {token}
```

### Endpoints Nhà Hàng

#### Lấy Tất Cả Nhà Hàng

```http
GET /api/restaurants
```

#### Lấy Chi Tiết Nhà Hàng

```http
GET /api/restaurants/{id}
```

### Endpoints Drone

#### Lấy Các Drone Khả Dụng

```http
GET /api/drones/available
Authorization: Bearer {token}
```

#### Phân Công Drone Cho Đơn Hàng

```http
POST /api/drones/assign
Authorization: Bearer {token}
Content-Type: application/json

{
  "orderId": "string",
  "droneId": "string"
}
```

_Để có tài liệu API đầy đủ, vui lòng tham khảo Postman collection hoặc Swagger UI (nếu được cấu hình)._

## 📁 Cấu Trúc Dự Án

```
FoodDeliveryWithDrone/
├── backend/
│   ├── eureka_server/          # Service discovery
│   ├── api_gateway/            # API Gateway
│   ├── user_service/           # Quản lý người dùng
│   ├── order_service/          # Xử lý đơn hàng
│   ├── drone_service/          # Quản lý drone
│   ├── cart_service/           # Giỏ hàng
│   ├── payment_service/        # Xử lý thanh toán
│   ├── delivery_service/       # Theo dõi giao hàng
│   ├── product_service/        # Danh mục sản phẩm
│   └── restaurant_service/     # Quản lý nhà hàng
│
├── frontend/
│   ├── src/
│   │   ├── components/         # React components
│   │   │   ├── admin/         # Components trang quản trị
│   │   │   ├── client/        # Components khách hàng
│   │   │   └── restaurant/    # Components chủ nhà hàng
│   │   ├── pages/             # Page components
│   │   ├── hooks/             # Custom React hooks
│   │   ├── types/             # TypeScript types
│   │   └── utils/             # Utility functions
│   └── public/                # Static assets
│
├── docs/
│   ├── ERD.drawio.png         # Sơ đồ cơ sở dữ liệu
│   └── PRD_Nhom_10.docx       # Yêu cầu sản phẩm
│
└── README.md
```
