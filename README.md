# SHOPPING CART

# spring-boot rest web service
A shopping-cart webservice built using spring-boot as backend andd oracle database
##Requirements
1. Java-1.8.x
2. Spring-boot: 2.3.4
3. ORACLE : 10g


## Steps to Setup

**1. clone the branch**
```bash
git clone  https://github.com/ashish077/shopping-cart.git
```

**4. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**5. Build and run the web-service**

## for backend
run the web-service from the IDE

The web-service will start running at <http://localhost:8000>.

## Explore Rest APIs

The app defines following CRUD APIs.

1. Add to cart                    GET api/v1/shoppingcart/addcart/{userid}/products/{productid}
2. view cart                      GET    viewcart/{cartid}
3. delete a product from cart**   DELETE    deleteproduct/{cartid}/product/{productid}
4. delete cart**                  DELETE   deletecart/{cartid}
5. search a product by id**       GET    api/v1/search/searchid/{productid}
6. search a product by category** GET api/v1/search/searchcategory/{productcategory}   
7. search a product by name**     GET    api/v1/search/searchname/{productname}
    
   
You can test them using postman or any other rest client.
