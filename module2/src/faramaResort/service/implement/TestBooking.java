package faramaResort.service.implement;

import faramaResort.models.agreement.Booking;
import faramaResort.service.IBookingContact;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestBooking implements IBookingContact {
    Set<Booking> bookingSet = new TreeSet<>();
    List<Booking> list = new ArrayList<>();

    @Override
    public void add() {
        System.out.println(123);
        bookingSet.add(new Booking("ewewe","ewewe","ewewe","ewewe","ewewe","ewewe","ewewe"));
        bookingSet.add(new Booking("dddd","dddd","dddd","dddd","dddd","dddd","dddd"));
        list.add(new Booking("ewewe","ewewe","ewewe","ewewe","ewewe","ewewe","ewewe"));
        list.add(new Booking("dddd","dddd","dddd","dddd","dddd","dddd","dddd"));

    }

    @Override
    public void display() {
        System.out.println(bookingSet.size());
        System.out.println(list.size());
    }
}
