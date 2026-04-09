# 🛒 E-Commerce REST API  
### Built with Spring Boot, JWT Authentication, MySQL, and JPA  

A fully functional **E-Commerce Backend API** featuring complete authentication, product management, cart management, and order processing. Ideal for learning real backend development and showcasing skills to recruiters.

---

## 🚀 Features  
### 🔐 Authentication & Security  
- User Registration & Login  
- JWT-based Authentication  
- Password Encryption (BCrypt)  
- Role-based Access (USER / ADMIN)  
- Protected API Endpoints  

### 🛒 E-Commerce Modules  
#### 📦 Product Module  
- Add Products (Admin)  
- Update & Delete Products (Admin)  
- Get All Products (Public)  

#### 🛍 Cart Module  
- Add product to cart  
- View cart  
- Remove item from cart  
- Clear cart  

#### 🧾 Order Module  
- Place order from cart  
- Convert all cart items into order  
- Save order & order items  
- View user order history  

---

## 🧱 Project Structure  
```
src/main/java/com/ecommerce/api/
│
├── config/                # JWT + Security
├── controller/            # REST Controllers
├── dto/                   # Request/Response Models
├── model/                 # JPA Entities
├── repository/            # Database Layer
└── service/               # Business Logic
```

---

## 🛠 Tech Stack  
- **Spring Boot 3**  
- **Spring Security + JWT**  
- **Spring Data JPA**  
- **MySQL Database**  
- **Lombok**  
- **Maven**  

---

## 📌 API Endpoints Overview

### 🔐 Auth APIs  
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login & receive JWT |

---

### 📦 Product APIs  
(ADMIN Only)  
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/products/admin/add` | Add new product |
| PUT | `/products/admin/update/{id}` | Update product |
| DELETE | `/products/admin/delete/{id}` | Delete product |

(Public)  
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Get all products |

---

### 🛍 Cart APIs  
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/cart/add` | Add to cart |
| GET | `/cart/{userId}` | View cart |
| DELETE | `/cart/remove/{id}` | Remove item |
| DELETE | `/cart/clear/{userId}` | Clear cart |

---

### 🧾 Order APIs  
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/orders/place` | Convert cart → order |
| GET | `/orders/{userId}` | Get order history |

---

## ⚙️ Setup Instructions  
### 1️⃣ Clone the Repository  
```
git clone https://github.com/yourusername/ecommerce-rest-api.git
```

### 2️⃣ Configure Database  
Update `application.properties` if needed.

### 3️⃣ Run the Application  
```
mvn spring-boot:run
```

---

## 🎯 Why This Project Is Great for Recruiters  
- Clean and easy project structure  
- Fully working real-world API  
- JWT-based authentication  
- Multiple modules (Products, Cart, Orders)  
- Demonstrates backend architecture understanding  
- Perfect for GitHub pinned projects  

---

## 🙌 Author  
**Yash Advani**  
Java Backend Developer  
LinkedIn: https://www.linkedin.com/in/yash-advani/  
GitHub: https://github.com/YashAdvani973
