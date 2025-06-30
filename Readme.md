class
+ methods in w3schools

JAVA => openjdk version "21.0.7" 2025-04-15 LTS
+ console.log === System.out.println("log");
+ int num = 2 | boolean x = true | byte 100 | short 10,000 | float | double | char | String
+ string: length() | toUpperCase() | indexOf | replace | split | String.join(array)
+ array: String[] cars = {"bmw", "benz"} | for (String car: cars) | if (x == y)
+ function: void logData => Application.logData() | this.logData() | logData()
+ class: OOP: public class Car | Car benz = new Car() => benz is an instance of Car
+ constructor: public Car() {}
+ Encapsulation: private: accessible within the declared class | protected: subclasses | public: all
+ static x: static Attributes belongs to the class rather than obj | Application.x not this.x
+ final class Car: class cannot be inherited by other classes | final int x = 1 === const x = 1
+ abstract: class cannot be used to create objects, can be only extended
+ inheritance: extends: class Car extends Vehicle | It is useful for code reusability
+ Polymorphism: override a class attributes and methods when you create a new class
+ super class === parent class | super() call parent constructor | super.getPrice() parent method
+ interfaces === abstract class (abstraction) | interface Animal => class Cat implements Animal
enum
SOLID
callback function
gradle
mavens
tomcat
INTELIJ, Ctrl + F5, how to make it auto after save
SPRINT BOOT version: 3.5.3
install: start.sprint.io
configs:
change port
connecting to DB
dependency injection
migration
factory
seeder
router: @resourceMap ? how about post, put, delete
controller: get url param in controller param int
service
repository
model
resource
service provider
create
read
update
delete
Filter data
sort data
include data
test
authentication
role, permission
authorization
event listner
command
handle exception
error 404
caching
try catch
send email
save file
read logs
auto backup
MY SQL
DOCKER
AWS - CLOUD
MICROSERVICE ye spring dge
TALK microservice ha
RabbitMQ ya message brukere dge

application Divar, agahi sabt o search beshe kard
advertises: create, read, update, delete
search o sort agahi ha
login/register
do payment using another service
micro service payment: post: /payments get: /payments

byte byte1 = 100;
short short1 = 10000;
int num = 2222;
long, float, double
boolean kir = true;

byte1 = (byte) short1;
String str3 = "xxxx";

if (byte1 == short1 ) {
System.out.println("log");
}

for (int i = 1; i <= 5; i ++) {
System.out.println(i);
}

String[] cars = {"bmw", "benz"};
for (String car: cars) {
System.out.println(car);
}

return kir ? byte1 + str3 : Integer.toString(num);