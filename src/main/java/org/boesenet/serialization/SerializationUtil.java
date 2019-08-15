package org.boesenet.serialization;

import org.boesenet.FilterableHttpResult;

import java.io.*;
import java.util.Base64;
import java.util.function.Predicate;

public class SerializationUtil {

    public static <T> String serializePredicate(Predicate<T> predicateTree) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(predicateTree);
        oos.close();
        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }

    public static <T> Predicate<T> deserializePredicate(String base64) throws IOException, ClassNotFoundException {
    //public static Predicate<FilterableHttpResult> deserializePredicate(String base64) throws IOException, ClassNotFoundException {
        byte[] bytes = Base64.getDecoder().decode(base64);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Predicate<T> predicate = (Predicate<T>) ois.readObject();
        return predicate;
    }
}
