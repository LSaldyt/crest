package optimal;

public class Main
{
    public static void main(String[] args)
    {
        RankedSet rankedSet = new RankedSet();

        RankedItem ford = new RankedItem();
        ford.add("price", 4000.);
        ford.add("efficiency", 15.);
        ford.add("mileage", 92000.);

        RankedItem prius = new RankedItem();
        prius.add("price", 9000.);
        prius.add("efficiency", 40.);
        prius.add("mileage", 12000.);

        RankedItem corolla = new RankedItem();
        corolla.add("price", 3000.);
        corolla.add("efficiency", 25.);
        corolla.add("mileage", 174000.);

        rankedSet.add(ford);
        rankedSet.add(prius);
        rankedSet.add(corolla);

        Criteria criteria = new Criteria();
        criteria.add("price", 10.);
        criteria.add("efficiency", 1.);
        criteria.add("mileage", 20.);

        System.out.println(rankedSet.by(criteria));
    }
}
