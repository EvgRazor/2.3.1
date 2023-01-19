package start.model;



import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 3, max = 30, message = "Миниумм 3 буквы, максимум 30")
    @Column(name = "name")
    private String name;

    @Min(value = 18, message = "Возраст должен быть миниумм 18 лет")
    @Max(value = 60, message = "Возраст должен не больше 60 тел")
    @Column(name = "age")
    private int age;

    @Email(message = "Не корректный email")
    @Column(name = "email")
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
