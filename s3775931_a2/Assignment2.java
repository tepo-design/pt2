import javax.print.attribute.standard.Media;

public class Assignment2 
{
    /*
     *  NETTRIX CATALOGUE!
     */   
    private String[] catalogue=
    {
        "MOVIE#2001: A Space Odyssey#1968",
        "GAME#The Witcher 3#2015",
        "TV-SERIES#Stranger Things (Season 1)#2016",
        "GAME#Minecraft#2009",
        "ALBUM#All Eyez On Me#1996",
        "MOVIE#Star Trek II: The Wrath of Khan#1982",
        "ALBUM#Hand on the Torch#1993",
        "TV-Series#Black Mirror (Season 1)#2011",
        "GAME#Zork#1980",
        "ALBUM#Fetch the Bolt Cutters#20190",
        "MOVIEZ#The Irishman#2019",
        "GAME#Papers, Please#2013"
    }; 

    /*
     * DO NOT MODIFY THIS METHOD STRUCTURE!
     * FEEL FREE TO MODIFY VALUES FOR myYear AND myTitleType TO TEST METHOD IMPLEMENTATIONS.
     */
    public void run()
    {
        int myYear=1995;
        int myTitleType=0;

        System.out.println("Printing names of existing titles in the catalog...");
        printTitleNames(myTitleType);
        System.out.println("------------");
        if (isThereMusicAfter(myYear))
        {
            System.out.println("There is some music after "+myYear);
        }
        else
        {
            System.out.println("Seriously, there is NO music after "+myYear);
        }

        System.out.println("------------");
        System.out.println("Printing report on catalog format...");
        System.out.println(getFormatReport());
        System.out.println("------------");
        System.out.println("Printing statistics on media release periods...");
        System.out.println(releasedTitlesHistogram());  
    }

    /**
     * Implement Q1, feel free to modify the body of this method
     */
    private void printTitleNames(int titleType)
    {
        String[] allTitles = new String[50];
        String[] movies = new String[50];
        String[] games = new String[50];
        String[] tvSeries = new String[50];
        String[] albums = new String[50];

        int movieCount = 0;
        int gamesCount = 0;
        int tvSeriesCount = 0;
        int albumsCount = 0;

        for (int i = 0; i < catalogue.length; i++)
        {
            String titlesSubstring = catalogue[i].substring(catalogue[i].indexOf("#")+1, catalogue[i].lastIndexOf("#"));
            
            allTitles[i] = titlesSubstring;
            
            String mediaSubstring = (catalogue[i].substring(0, catalogue[i].indexOf("#"))).toUpperCase();
        
            if (mediaSubstring.equals("MOVIE"))
            {
                movies[movieCount] = titlesSubstring;
                movieCount++;
            }
            else if (mediaSubstring.equals("GAME"))
            {
                games[gamesCount] = titlesSubstring;
                gamesCount++;
            }
            else if (mediaSubstring.equals("TV-SERIES"))
            {
                tvSeries[tvSeriesCount] = titlesSubstring;
                tvSeriesCount++;
            }
            else if (mediaSubstring.equals("ALBUM"))
            {
                albums[albumsCount] = titlesSubstring;
                albumsCount++;
            }
        } 

        if (titleType == 0)
        {
            printArrays(allTitles);
        }
        else if (titleType == 1)
        {
            printArrays(movies);
        }
        else if (titleType == 2)
        {
            printArrays(tvSeries);
        }
        else if (titleType == 3)
        {
            printArrays(games);
        }
        else if (titleType == 4)
        {
            printArrays(albums);
        }
        else 
        {
            System.out.print("Invalid Media Type");
        }
    }

    private void printArrays(String[] array)
    {
        for (String s : array)
        {
            if (s != null)
            {
                System.out.println(s);
            }
        }
    }
    
    /**
     * Implement Q2, feel free to modify the body of this method
     * @return Whether there is music in the catalog released after the 90s
     */
    private boolean isThereMusicAfter(int year) 
    {
        boolean musicAfter = false;

        for (int i = 0; i < catalogue.length; i++)
        {
            String mediaSubString = catalogue[i].substring(0, catalogue[i].indexOf("#")).toUpperCase();
            String yearSubString = catalogue[i].substring(catalogue[i].lastIndexOf("#")+1);
            int yearToInt = Integer.parseInt(yearSubString);

            if ((yearToInt > year) && (year >= 1920 && year <= 2019) && (yearToInt >= 1920 && yearToInt <= 2019)  && mediaSubString.equals("ALBUM"))
            {
                musicAfter = true;
                break;
            }
        }
        return musicAfter;
    }

    /**
     * Implement Q3, feel free to modify the body of this method
     * @return A report on format validity of the provided catalogue.
     */
    private String getFormatReport()
    {
        String report = "";

        for (int i = 0; i < catalogue.length; i ++)
        {
            String yearSubString = catalogue[i].substring(catalogue[i].lastIndexOf("#")+1);
            int yearToInt = Integer.parseInt(yearSubString);

            String mediaSubstring = catalogue[i].substring(0, catalogue[i].indexOf("#")).toUpperCase();

            if ((yearToInt >= 1920 && yearToInt <= 2019))
            {
                if (mediaSubstring.equals("MOVIE") || mediaSubstring.equals("TV-SERIES") || mediaSubstring.equals("GAME") || mediaSubstring.equals("ALBUM"))
                {
                    report += "Item #" + (i+1) + " - OK." + "\n";
                }
                else
                {
                    report += "Item #" + (i+1) + " - incorrect media type." + "\n";
                }
            } 
            else if (mediaSubstring.equals("MOVIE") || mediaSubstring.equals("TV-SERIES") || mediaSubstring.equals("GAME") || mediaSubstring.equals("ALBUM"))
            {
                report += "Item #" + (i+1) + " - year incorrect or out of range." + "\n";
            }

        }

        return report;
    }

    /**
     * Implement Q4, feel free to modify the body of this method
     */
    private String releasedTitlesHistogram()
    {
        int count1920 = 0;
        int count1945 = 0;
        int count1970 = 0;
        int count1995 = 0;

        for (int i = 0; i < catalogue.length; i ++)
        {
            String substringOfYear = catalogue[i].substring(catalogue[i].lastIndexOf("#")+1);
            int yearToInt = Integer.parseInt(substringOfYear);

            if (yearToInt >= 1920 && yearToInt <= 1944)
            {
                count1920++;
            }
            else if (yearToInt >= 1945 && yearToInt <= 1969)
            {
                count1945++;
            }
            else if (yearToInt >= 1970 && yearToInt <= 1994)
            {
                count1970++;
            }
            else if (yearToInt >= 1995 && yearToInt <= 2019)
            {
                count1995++;
            }
        }

        String histogram = "Number of titles in 1920 - 1944: " + count1920 + "\n" +
                           "Number of titles in 1945 - 1969: " + count1945 + "\n" +
                           "Number of titles in 1970 - 1994: " + count1970 + "\n" +
                           "Number of titles in 1995 - 2019: " + count1995 + "\n";

        return histogram;
    }  
}