package src;

public class Filter
{
    private String type;
    private double comparison;

    public Filter()
    {
        type = "greater";
        comparison = 0.0;
    }

    public Filter(String type, double comparison)
    {
        this.type = type;
        this.comparison = comparison;
    }

    public boolean filter(double value)
    {
        if (type == "less")
        {
            return value < comparison;
        }
        else if (type == "less-equal")
        {
            return value <= comparison;
        }
        else if (type == "greater")
        {
            return value > comparison;
        }
        else if (type == "greater-equal")
        {
            return value >= comparison;
        }
        else if (type == "equal")
        {
            return value == comparison;
        }
        else
        {
            System.err.println("Invalid filter type: " + type);
            return false;
        }
    }

    public String toString()
    {
        String interpretation;
        if (type == "equal")
        {
            interpretation = "to"; // "equal to"
        }
        else
        {
            interpretation = "than"; // "less,greater,less-equal,greater-equal than"
        }

        return "Filter: " + type + " " + interpretation + " " + comparison;
    }
}
