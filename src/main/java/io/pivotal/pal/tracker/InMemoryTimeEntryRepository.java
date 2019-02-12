package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long,TimeEntry> temp = new HashMap<Long,TimeEntry>();
    private long id = 0;
    public TimeEntry create(TimeEntry timeEntry){
        id++;
        System.out.println(list());
        timeEntry.setId(id);
        temp.put(timeEntry.getId(),timeEntry);
        System.out.println(list());
        return timeEntry;
    }
    public TimeEntry find(long timeEntryId){
        System.out.println(list());
        TimeEntry timeEntry = temp.get(timeEntryId);
        System.out.println(list());
        return timeEntry;
    }
    public List<TimeEntry> list(){
        List<TimeEntry> tempList = new ArrayList<TimeEntry>();
        for(Map.Entry<Long,TimeEntry> entry: temp.entrySet()){
            tempList.add(entry.getValue());
        }
        System.out.println(tempList);
        return tempList;
    }
    public TimeEntry update(long timeEntryId,TimeEntry timeEntry){
        timeEntry.setId(timeEntryId);
        System.out.println(list());
        if(temp.containsKey(timeEntryId)) {
            temp.put(timeEntryId, timeEntry);
            System.out.println(list());
            return timeEntry;
        }
        else{
            return null;
        }
    }
    public void delete(long timeEntryId){
        System.out.println(list());
        temp.remove(timeEntryId);
        System.out.println(list());
    }
}
