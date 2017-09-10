package optimal;

public class Metric
{
    double weight;
    boolean maximizing;

    public Metric()
    {}

    public Metric(double weight, boolean maximizing)
    {
        this.weight = weight;
        this.maximizing = maximizing;
    }

    public double factor(double score)
    {
        double value = score * weight;
        if (maximizing)
        {
            return value;
        }
        else
        {
            return 1.0/value;
        }
    }
}
