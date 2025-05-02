# Shopping Cart Application

A full-stack shopping cart web application with a Java Spring Boot backend (RESTful APIs, product/catalog management, user authentication, cart operations) and a React.js frontend (dynamic product listing, search, and interactive cart functionality).

## Requirements
- Java 1.8+
- Spring Boot 2.3.4
- Node.js & npm (for frontend)
- Oracle 10g (or update datasource for your DB)

## Project Structure
- Backend: Java Spring Boot (REST API)
- Frontend: React.js (in `shopping-cart-frontend/shopping-cart-frontend`)

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/ashish077/shopping-cart.git
cd shopping-cart
```

### 2. Configure the Backend
- Edit `src/main/resources/application.properties` to set your database username and password:
  - `spring.datasource.username=YOUR_USERNAME`
  - `spring.datasource.password=YOUR_PASSWORD`

### 3. Run the Backend
- From your IDE or terminal:
```bash
./mvnw spring-boot:run
```
- The backend will start at `http://localhost:8080` (update `API_BASE_URL` in frontend if changed).

### 4. Run the Frontend
- Open a new terminal and navigate to the frontend directory:
```bash
cd shopping-cart-frontend/shopping-cart-frontend
npm install
npm start
```
- The frontend will start at `http://localhost:3000`.

## API Endpoints (Backend)
- Add to cart: `POST /api/cart/{userId}/add`
- View cart: `GET /api/cart/{userId}`
- Remove from cart: `POST /api/cart/{userId}/remove`
- List products: `GET /api/products`
- Search products: `GET /api/products/search?q=...`

## Usage
- Access the frontend at [http://localhost:3000](http://localhost:3000)
- The frontend interacts with the backend APIs for all cart and product operations.

## Notes
- Update database configuration as needed.
- Ensure backend is running before starting the frontend.
