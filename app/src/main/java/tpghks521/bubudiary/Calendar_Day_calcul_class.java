package tpghks521.bubudiary;

/**
 * Created by alfo6-13 on 2018-04-27.
 */

public class Calendar_Day_calcul_class {
    String year;
    String month;
 String[] date = new String[35];
    int datesum;

    public Calendar_Day_calcul_class(String year, String month, String[] date, int datesum) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.datesum=datesum;
    }
}
