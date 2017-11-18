package src;

public class Optimizer
{
    private RankedSet rankedSet;
    private Criteria  criteria;
    private Reader    reader;

    public Optimizer(String directory, String filename, String criteriaFile)
    {
        reader = new Reader();
        load(directory, filename);
        load_criteria(directory, criteriaFile);
    }

    public Criteria getCriteria()
    {
        return criteria;
    }

    public void load(String directory, String filename)
    {
        rankedSet = reader.read_set("data/" + directory + "/items.csv");
    }

    public void load_criteria(String directory, String filename)
    {
        criteria = reader.read_criteria("data/" + directory + "/" + filename);
    }

    public void show()
    {
        rankedSet = criteria.filter(rankedSet);
        criteria.sort(rankedSet);

        System.out.println(criteria);
        System.out.println(rankedSet);
    }
}
