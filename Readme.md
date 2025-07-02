1. handle Method Not Allowed
2. same structure json everywhere

1 resource for the returned data from database
same structure every where

2 validation for create or edit
3 add service

same tab width in all files of java codes

---

    + handle exception: .orElseThrow(() -> new NotFoundException(id));
    	class NotFoundException extends RuntimeException
    	@ControllerAdvice
    	public class GlobalExceptionHandler {
    resource => to khode model darimesh ??
    validations
    service
    baseService
    baseController

    factory
    seeder

    filters | Query
    sort
    pagination
    includes | Relations

    authentication | Jwt
    authorization: role, permission
    event listner
    command

    caching
    send email
    download | upload file
    Logs via grafana
    test
    profile:
    	No active profile set, falling back to 1 default profile: "default"

    	application-dev.properties
    	application-prod.properties

    	spring.profiles.active=dev
    Transactions
    http call using rest template that is legacy (web client reactive) Api clients and external call
    	Stream
    	do pipeline and addStack with http
    	Rate limiting

OTHERS:
DOCKER
AWS - CLOUD
MICROSERVICE ye spring dge | TALK microservice ha | RabbitMQ ya message brukere dge
Serverless
Knowledge:
Life cycle
dependency injection
service provider, Ioc
gradle | mavens
tomcat | apache
Sso
TEST CASE:
application Divar, agahi sabt o search beshe kard
advertises: create, read, update, delete
search o sort agahi ha
login/register
do payment using another service
micro service payment: post: /payments get: /payments

---

./gradlew build
./gradlew bootRun
./gradlew dependencies
./gradlew --refresh-dependencies
./gradlew build --refresh-dependencies
./gradlew clean build
Java: Clean Java Language Server Workspace

postgress:
http://127.0.0.1/pgadmin4
sudo -u postgres psql

    CREATE DATABASE farid3;
    CREATE ROLE farid3 WITH LOGIN PASSWORD 'farid3';
    ALTER ROLE farid3 WITH SUPERUSER CREATEDB CREATEROLE REPLICATION BYPASSRLS;

    \q

ssh commands:
ssh-keygen -t ed25519 -C "farid.sh69@gmail.com"
git remote set-url origin git@github.com:faridsh69/sprint-boot-best-practices.git

set java:
sudo mv jdk-21.0.7+6 /opt/jdk-21
nano ~/.bashrc
export JAVA_HOME=/opt/jdk-21
export PATH=$JAVA_HOME/bin:$PATH
source ~/.bashrc

- SPRINT BOOT: https://start.spring.io | Spring Web | V 3.5.3 | Java 21

  - Add dependencies
    ./gradlew build --refresh-dependencies
    ./gradlew clean build
    Java: Clean Java Language Server Workspace
  - configs for auto-rebuild:
    build.gradle:
    bootRun { sourceResources sourceSets.main }
    dependencies { runtimeOnly 'org.springframework.boot:spring-boot-devtools' }
    vscode:
    "java.autobuild.enabled": true,
    "java.configuration.updateBuildConfiguration": "automatic",
  - configs @Value("${app.name}") private String appName;
    @ConfigurationProperties(prefix = "app") public class AppConfig
    application.properties => server.port=8081
  - configs connecting to DB
    build.gradle:
    'org.springframework.boot:spring-boot-starter-data-jpa'
    'org.postgresql:postgresql'
    spring.datasource.url=jdbc:postgresql://localhost:5432/farid3
    spring.datasource.username=farid3
    spring.datasource.password=farid3
    spring.datasource.driver-class-name=org.postgresql.Driver

    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

  - migration
    spring.flyway.enabled=true
    spring.flyway.locations=classpath:db/migration
    V1\_\_create_users_table.sql
    CREATE TABLE users (id PRIMARY KEY);
  - router:
    @GetMapping("/users")
    @PostMapping("/users")
    @PutMapping("users/{id}")
    @DeleteMapping("/users/{id}")
  - controller:
    @RestController
    public class UserController {
  - model: @Entity | @Table(name = "users")
    @Id | @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private User() {} | public User(int x){ this.x = x }
  - repository
    org.springframework.data.jpa.repository.JpaRepository
    public interface UserRepository extends JpaRepository

- JAVA => openjdk version "21.0.7" 2025-04-15 LTS
  - console.log === System.out.println("log");
  - int num = 2 | boolean x = true | byte 100 | short 10,000 | long | float | double | char | String
  - string: length() | toUpperCase() | indexOf | replace | split | String.join(array)
  - array: String[] cars = {"bmw", "benz"} | for (String car: cars) | if (x == y)
  - function: void logData => Application.logData() | this.logData() | logData()
  - class: OOP: public class Car | Car benz = new Car() => benz is an instance of Car
  - constructor: public class Car { public Car() {} }
  - Encapsulation: private: accessible within the declared class | protected: subclasses | public: all
  - static x: static Attributes belongs to the class rather than obj | Application.x not this.x
  - final class Car: class cannot be inherited by other classes | final int x = 1 === const x = 1
  - abstract: class cannot be used to create objects, can be only extended
  - inheritance: extends: class Car extends Vehicle | It is useful for code reusability
  - Polymorphism: override a class attributes and methods when you create a new class from parent class
  - super class === parent class | super() call parent constructor | super.getPrice() parent method
  - interfaces === abstract class (abstraction) | interface Animal => class Cat implements Animal
  - enum: enum roles {ADMIN, USER} | for (roles role : roles.values()) | public, static and final
  - date: LocalDate d = LocalDate.now() | f = DateTimeFormatter.ofPattern("dd-MM-yyyy") | d.format(f)
  - error: throw new ArithmeticException("Access denied."); try {} catch (Exception e) {e.getMessage()}
  - File: File f = new File(add) f.createNewFile() | FileWriter w = new FileWriter(add) w.write("T")
  - Generic: class X<T> {T value;} | X<int> age = new X<>(32); | public static <T> void print(T[] arr)
  - Annotation @Override will tell compiler that this is overriding parent class, @Depricated, ...
  - Thread: extends Thread | implements Runnable | car.start()
  - lambda expression: callback function: numbers.forEach((n) -> {System.out.println(n)}) FunctionInterface
    interface FnType { int sum(int a, int b); }
    FnType cb = (a, b) -> a + b; | cb.calc(1, 7);
  - data structure
    - ArrayList: ArrayList<int> numbers = new ArrayList<int>() | add() |
    - HashSet: HashSet<String> cars = new HashSet<String>(); | add() | unique
    - HashMap: HashMap<String, String> cc = new HashMap<String, String>(); cc.put("eng", "London");
    - Collection: Collections.sort(numbers, Collections.reverseOrder())
    - Iterator<String> it = numbers.iterator() | while(it.hasNext()) {it.next()}

https://youtu.be/-G8H0IN0ECQ?si=s1h08GvV1NIYN5KM
https://youtu.be/qhKcG8m70FE?si=wcKSiVjq0NFjo3Xb
