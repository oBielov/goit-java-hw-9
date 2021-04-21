package files_practice;

import java.util.Objects;

/**
 * Model class for user. Have {@link #name} and {@link #age}
 * fields. Equals, Hash and toString methods are overridden.
 */
public class User {


    private String name;
    private int age;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User name: " + name + "\n"
                + "User age: " + age;
    }
}
