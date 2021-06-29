package stream;

public record Person(String name, int age, Gender gender) {
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender.name();
    }
}
