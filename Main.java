package optimal;

public class Main
{
    public static void main(String[] args)
    {
        Reader reader = new Reader();
        RankedSet rankedSet = reader.read_set("cars.csv");
        Criteria criteria = reader.read_criteria("criteria.csv");

        /*
        Criteria criteria = new Criteria();
        criteria.add("price", new Metric(10.0, false));
        criteria.add("efficiency", new Metric(1.0, true));
        criteria.add("mileage", new Metric(1.0, false));
        */

        criteria.sort(rankedSet);
        System.out.println(criteria);
        System.out.println(rankedSet);
    }
}
