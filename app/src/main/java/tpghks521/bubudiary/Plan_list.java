package tpghks521.bubudiary;

/**
 * Created by tpghk on 2018-05-29.
 */

public class Plan_list {
    String year;
    String month;
    String day;
    String title;
    String place;
    String time;
    String rep;
    String alarm;

    public Plan_list(String year, String month, String day, String title, String place, String time, String rep, String alarm) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.title = title;
        this.place = place;
        this.time = time;
        this.rep = rep;
        this.alarm = alarm;
    }
}
