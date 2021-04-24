package ua.practice.maven;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook {
    private final LinkedList<Subscriber> subscribers = new LinkedList<>();

    public void addSubscriber(Subscriber subscriberToAdd){
        if(checkTelephoneExistence(subscriberToAdd))
            subscribers.add(subscriberToAdd);
    }
    private boolean checkTelephoneExistence(Subscriber checkedSubscriber){
        for (Subscriber subscriber : subscribers) {
            if(checkedSubscriber.equals(subscriber)) {
                System.out.println("Subscriber with the same telephone number already exists!");
                return false;
            }
        }
        return true;
    }

    public List<String> searchByLastName(String lastName){
        List<String> listOfTelephones = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getLastName().equals(lastName)) listOfTelephones.add(subscriber.getTelephone());
        }
        return listOfTelephones;
    }

    public void print(){
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }
}
