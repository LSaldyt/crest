package optimal;

public class Optimizer
{
    public Optimizer()
    {

    }

    public void find_optimal(String directory)
    {
        find_optimal(directory, "criteria.csv");
    }

    public void find_optimal(String directory, String criteriaFile)
    {
        Reader reader = new Reader();
        RankedSet rankedSet = reader.read_set("data/" + directory + "/items.csv");
        Criteria criteria = reader.read_criteria("data/" + directory + "/" + criteriaFile);
        criteria.addFilter("MPG", new Filter("greater-equal", 20.));

        rankedSet = criteria.filter(rankedSet);
        criteria.sort(rankedSet);

        System.out.println(criteria);
        System.out.println(rankedSet);
    }
}
