public class Person {
    private String name;
    private int age;
    private String address;
    private int phone;

    public Person(String name, int age, String address, int phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public void print() {
        System.out.println("Person{name= " + name + ", age= " + age + ", address= " + address + ", phone= " + phone + '}');
    }

}
