package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
     calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        ArrayList<Meeting> curr = new ArrayList<>(calendar);

        Collections.sort(curr, Comparator.comparing(Meeting::getStartTime));
//
//        ArrayList<Meeting[]> opt= new ArrayList<>();
//
//        Meeting [] temp = new Meeting[1];
//
//        temp[0] = curr.get(0);
//
//        opt.add(temp);
//
//        for(Meeting m : curr) {
//
//            LocalTime curr_begin = temp[0].getStartTime();
//            LocalTime curr_end =  temp[0].getEndTime();
//            LocalTime next_begin =  m.getStartTime();
//            LocalTime next_end = m.getEndTime();
//
//            if(curr_end.compareTo(next_begin) >=0){
//                int n = curr_end.compareTo(next_end);
//                if(n>0) {
//                    temp[0].setEndTime(curr_end);
//                }else{
//                    temp[0].setEndTime(next_end);
//                }
//            }else{
//                temp [0] = m;
//                opt.add(temp);
//            }
//        }
//
//        return opt.size();


         int i=0 , j=0 , count=0;

         while(j<curr.size()){

             Meeting start = curr.get(i);
             Meeting end = curr.get(j);

             if(start.getEndTime().compareTo(end.getStartTime())<0){
                 i=j;
                 count++;
             }
             j++;
         }

        return count+1;

    }
}
