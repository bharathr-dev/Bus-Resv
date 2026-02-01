package Proj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

     String passengername;

     int busno;

     Date date;


    Booking() {
        Scanner sc = new Scanner(System.in);          
        System.out.println("enter passenger name ");
        passengername = sc.nextLine();
        System.out.println("enter busno");
        busno = sc.nextInt();
//        sc.nextLine();
        System.out.println("enter date in dd-mm-yyyy format");
        String dateinput = sc.next(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateinput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public int isavailable(ArrayList<Bus> buslist, ArrayList<Booking> bookingslist) {  // todo 6
        boolean m = true;
        int capacity = 0;
            for (Bus b : buslist) {
                    if (b.getbusno() == busno) {
                        m = false;
                        capacity = b.getCapacity();
                        break;
                    }
                }
                if(m){
                    return -1;
                }

            int bookingcount = 0;
            for (Booking bo : bookingslist) {
                if (bo.busno == busno && bo.date.equals(date)) {
                    bookingcount++;
                }
            }
            return bookingcount < capacity ? 1 : 0;

        }
    }

