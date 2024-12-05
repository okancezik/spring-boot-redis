# Redis Caching with Spring Framework

This project demonstrates caching with **Redis** using **Spring Framework**. It is organized into three branches, each implementing a different approach to caching. 

## Branches

### 1. **Main Branch**
- **Purpose**: Contains the core structure and baseline code for the project.
- **Features**:
  - Supports Redis caching using both:
    - **Spring caching annotations** (`@Cacheable`, `@CachePut`, `@CacheEvict`)
    - **Manual implementation** with `RedisTemplate`.

---

### 2. **annotations-db Branch**
- **Approach Used**: Utilizes **Spring Framework caching annotations** for caching.
  - **`@Cacheable`**: Reads data from the Redis cache.
  - **`@CachePut`**: Updates data in the Redis cache.
  - **`@CacheEvict`**: Removes data from the Redis cache.
  
- **Advantages**:
  - Simplifies caching logic with declarative annotations.
  - Reduces boilerplate code.
  - Integrated seamlessly with Spring's cache abstraction.

---

### 3. **redis-template-db Branch**
- **Approach Used**: Implements caching **manually** using `RedisTemplate`.
  - **Features**:
    - Direct interaction with Redis to fetch, store, and delete data.
  
- **Advantages**:
  - Offers complete control over caching logic.
  - Useful for custom use cases not covered by annotations.
  
- **Key Methods**:
  - **Save Data to Cache**: Manually stores data in Redis using `RedisTemplate`.
  - **Retrieve Data from Cache**: Retrieves cached data using key lookups.
  - **Delete Data from Cache**: Removes specific data from the Redis cache.

---

## Comparison of Approaches

| Feature              | annotations-db Branch (`@Cacheable`)  | redis-template-db Branch (`RedisTemplate`)        |
|----------------------|---------------------------------------|---------------------------------------|
| Ease of Use          | High (uses Spring annotations)        | Medium (requires manual implementation) |
| Flexibility          | Limited to Spring caching abstraction | High (custom caching logic possible)  |
| Boilerplate Code     | Minimal                              | More boilerplate code                 |
| Debugging Complexity | Lower                                | Higher (manual key management)        |

---

## How to Use

1. **Switch Branches**:
   - To explore the annotated approach, switch to the `annotations-db` branch:
     ```bash
     git checkout annotations-db
     ```
   - For the manual `RedisTemplate` approach, switch to the `redis-template-db` branch:
     ```bash
     git checkout redis-template-db
     ```

2. **Run the Application**:
   - Build the project and run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

---

Feel free to explore the branches and use the approach that best fits your project requirements!
