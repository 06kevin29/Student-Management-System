public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }
        this.email = email;
    }
}
