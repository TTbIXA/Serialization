import java.io.*;

public class SerializationUtil {

    public static void serializePerson(Person person, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePerson(String filename) {
        Person person = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            person = (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        String filename = "person.ser";


        serializePerson(person, filename);
        System.out.println("Сериализованный объект: " + person);


        Person deserializedPerson = deserializePerson(filename);
        System.out.println("Десериализованный объект: " + deserializedPerson);
    }
}
