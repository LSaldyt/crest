package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Reader
{
    public Reader()
    {}

    public Criteria read_criteria(String filename)
    {
        Criteria criteria = new Criteria();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            lines.remove(0);

            for (String line : lines)
            {
                List<String> cells = Arrays.asList(line.split(","));
                for (String cell : cells)
                {
                    cell.replaceAll("\\s+","");
                }
                String name = cells.get(0);
                double weight = Double.parseDouble(cells.get(1));
                boolean maximizing = Boolean.parseBoolean(cells.get(2));
                criteria.addMetric(name, new Metric(weight, maximizing));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return criteria;
    }

    public RankedSet read_set(String filename)
    {
        RankedSet rankedSet = new RankedSet();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            String header = lines.get(0);
            List<String> labels = Arrays.asList(header.split(","));
            lines.remove(0);

            for (String line : lines)
            {
                List<String> cells = Arrays.asList(line.split(","));
                for (String cell : cells)
                {
                    cell.replaceAll("\\s+","");
                }
                String name = cells.get(0);

                RankedItem item = new RankedItem(name);

                for (int i = 1; i < labels.size(); i++)
                {
                    item.add(labels.get(i), Double.parseDouble(cells.get(i)));
                }

                rankedSet.add(item);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return rankedSet;
    }
}
