+ JAVA => openjdk version "21.0.7" 2025-04-15 LTS
    + console.log === System.out.println("log");
    + int num = 2 | boolean x = true | byte 100 | short 10,000 | long | float | double | char | String
    + string: length() | toUpperCase() | indexOf | replace | split | String.join(array)
    + array: String[] cars = {"bmw", "benz"} | for (String car: cars) | if (x == y)
    + function: void logData => Application.logData() | this.logData() | logData()
    + class: OOP: public class Car | Car benz = new Car() => benz is an instance of Car
    + constructor: public class Car { public Car() {} }
    + Encapsulation: private: accessible within the declared class | protected: subclasses | public: all
    + static x: static Attributes belongs to the class rather than obj | Application.x not this.x
    + final class Car: class cannot be inherited by other classes | final int x = 1 === const x = 1
    + abstract: class cannot be used to create objects, can be only extended
    + inheritance: extends: class Car extends Vehicle | It is useful for code reusability
    + Polymorphism: override a class attributes and methods when you create a new class from parent class
    + super class === parent class | super() call parent constructor | super.getPrice() parent method
    + interfaces === abstract class (abstraction) | interface Animal => class Cat implements Animal
    + enum: enum roles {ADMIN, USER} | for (roles role : roles.values()) | public, static and final
    + date: LocalDate d = LocalDate.now() | f = DateTimeFormatter.ofPattern("dd-MM-yyyy") | d.format(f)
    + error: throw new ArithmeticException("Access denied."); try {} catch (Exception e) {e.getMessage()}
    + File: File f = new File(add) f.createNewFile() | FileWriter w = new FileWriter(add) w.write("T")
    + Generic: class X<T> {T value;} | X<int> age = new X<>(32); | public static <T> void print(T[] arr)
    + Annotation @Override will tell compiler that this is overriding parent class, @Depricated, ...
    + Thread: extends Thread | implements Runnable | car.start()
    + lambda expression: callback function: numbers.forEach((n) -> {System.out.println(n)}) FunctionInterface
      interface FnType { int sum(int a, int b); }
      FnType cb = (a, b) -> a + b; | cb.calc(1, 7);
    + data structure
        + ArrayList: ArrayList<int> numbers = new ArrayList<int>() | add() |
        + HashSet: HashSet<String> cars = new HashSet<String>(); | add() | unique
        + HashMap: HashMap<String, String> cc = new HashMap<String, String>(); cc.put("eng", "London");
        + Collection: Collections.sort(numbers, Collections.reverseOrder())
        + Iterator<String> it = numbers.iterator() | while(it.hasNext()) {it.next()}
+ SPRINT BOOT: https://start.spring.io | Spring Web | V 3.5.3 | Java 21
    + Add dependencies
      ./gradlew build --refresh-dependencies
      ./gradlew clean build
      Java: Clean Java Language Server Workspace
    + configs for auto-rebuild:
      build.gradle:
      bootRun { sourceResources sourceSets.main }
      dependencies { runtimeOnly 'org.springframework.boot:spring-boot-devtools' }
      vscode:
      "java.autobuild.enabled": true,
      "java.configuration.updateBuildConfiguration": "automatic",
    + configs @Value("${app.name}") private String appName;
      @ConfigurationProperties(prefix = "app") public class AppConfig
      application.properties => server.port=8081
    + configs connecting to DB
      build.gradle:
      'org.springframework.boot:spring-boot-starter-data-jpa'
      'org.postgresql:postgresql'

      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
      spring.jpa.hibernate.ddl-auto=update
    + profile:
      application-dev.properties | application-prod.properties | spring.profiles.active=dev
    + migration
      spring.flyway.enabled=true
      spring.flyway.locations=classpath:db/migration
      V1__create_users_table.sql
      CREATE TABLE users (id PRIMARY KEY);
    + router:
      @GetMapping("/users")
      @PostMapping("/users")
      @PutMapping("users/{id}")
      @DeleteMapping("/users/{id}")
    + controller:
      @RestController
      public class UserController {
    + model: @Entity | @Table(name = "users") | @Getter
      @Id | @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer id;
      private User() {} | public User(int x){ this.x = x }
    + relations
      1 @ManyToOne
      1 @JoinColumn(name = "userId", nullable = false)
      private User user;

      1 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
      private List<Blog> blogs;

      2 @ManyToMany
      2 @JoinTable(
      name = "blog_tags",
      joinColumns = @JoinColumn(name = "blog_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
      )
      private List<Tag> tags;

      2 @ManyToMany(mappedBy = "tags")
      private List<Blog> blogs;
    + repository
      org.springframework.data.jpa.repository.JpaRepository
      public interface UserRepository extends JpaRepository
    + service
      @Service
      public class UserService extends BaseService<User, Integer, UserRequest>
    + handle exception: .orElseThrow(EntityNotFoundException::new);
      @ControllerAdvice
      public class GlobalExceptionHandler {
      @ExceptionHandler(Exception.class)
      public ResponseEntity<res> handleException(Exception ex) {
    + Api response:
      public record ApiResource<T>(T data) {}
      new ApiResource<>(resource)
    + resource:
      @Getter()
      public class UserResource extends ResourceAbstract<User> {
      public void toResource(User entity) {
      id = entity.getId(); }
      private List<BlogResource> blogs;
      blogs = user.getBlogs().stream().map(blog -> BlogResource.from(blog, BlogResource.class)).toList();
    + validation
      @NotBlank(message = "lastName is required")
      @Size(min = 3, message = "firstName must be at least 2 characters")
      @Email(message = "Invalid email format")
      @Past(message = "Birth date must be in the past")
      @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
      public User toEntity() {
    + seeder, command
      @Bean
      CommandLineRunner seedData(BlogRepository blogRepository, UserRepository userRepository) {
      return args -> {}}
    + cache
      implementation 'org.springframework.boot:spring-boot-starter-cache'
      implementation 'org.springframework.boot:spring-boot-starter-data-redis'
      @EnableCaching
      @Cacheable(value = "users", key = "#id")
    + Swagger api document
      implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
      @Operation(summary = "Greet the user", description = "Returns a greeting message")
      @GetMapping("XXX")
      ./gradlew clean build
    + Test:
      @SpringBootTest
      @BeforeEach
      public void setup() {
      @Test
      public void testShowReturnsUserById() throws Exception {
