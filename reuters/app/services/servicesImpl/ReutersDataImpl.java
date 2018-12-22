package services.servicesImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dto.Dataset;
import dto.News;

public class ReutersDataImpl extends Dataset<News> {
    private final String directory;
    static int i=0;

    public ReutersDataImpl(String reutersDir) {
        this.directory = reutersDir;
    }



    public static ArrayList<News> parseStringWithIndex(String reuters_string) {

        ArrayList<News> reuters_feed = new ArrayList<News>();
        News reuters = new News();

        //Extract the date value
        String dateTag = "<DATE>";
        int dateTagIndex = reuters_string.indexOf(dateTag);
        if(dateTagIndex > 0) {
            reuters.date = reuters_string.substring(dateTagIndex + dateTag.length(),reuters_string.indexOf("</DATE>")).trim();
        }

        //Extract the topics value
        String topicsTag = "<TOPICS>";
        int topicsTagIndex = reuters_string.indexOf(topicsTag);
        if(topicsTagIndex > 0) {
            reuters.topics = reuters_string.substring(topicsTagIndex + topicsTag.length(),reuters_string.indexOf("</TOPICS>")).trim();
            reuters.topics = reuters.topics.replaceAll("<D>","").replaceAll("</D>"," ");
        }

        //Extract the title value
        String titleTag = "<TITLE>";
        int titleTagIndex = reuters_string.indexOf(titleTag);
        if(titleTagIndex > 0) {
            reuters.title = reuters_string.substring(titleTagIndex + titleTag.length(),reuters_string.indexOf("</TITLE>")).trim();
        }

        //Extract the body value
        String bodyTag = "<BODY>";
        int bodyTagIndex = reuters_string.indexOf(bodyTag);
        if(bodyTagIndex > 0) {
            reuters.body = reuters_string.substring(bodyTagIndex + bodyTag.length(),reuters_string.indexOf("</BODY>")).trim();
        }

        //Extract the dateline value
        String dateLineTag = "<DATELINE>";
        int dateLineTagIndex = reuters_string.indexOf(dateLineTag);
        if(dateLineTagIndex > 0) {
            reuters.dateLine = reuters_string.substring(dateLineTagIndex + dateLineTag.length(),reuters_string.indexOf("</DATELINE>")).trim();
        }

        //Extract the places value
        String placesTag = "<PLACES>";
        int placesTagIndex = reuters_string.indexOf(placesTag);
        if(placesTagIndex > 0) {
            reuters.places = reuters_string.substring(placesTagIndex + placesTag.length(),reuters_string.indexOf("</PLACES>")).trim();
            reuters.places = reuters.places.replaceAll("<D>","").replaceAll("</D>"," ");
        }

        //Extract the people value
        String peopleTag = "<PEOPLE>";
        int peopleTagIndex = reuters_string.indexOf(peopleTag);
        if(peopleTagIndex > 0) {
            reuters.people = reuters_string.substring(peopleTagIndex + peopleTag.length(),reuters_string.indexOf("</PEOPLE>")).trim();
        }

        //Extract the orgs value
        String orgsTag = "<ORGS>";
        int orgsTagIndex = reuters_string.indexOf(orgsTag);
        if(orgsTagIndex > 0) {
            reuters.orgs = reuters_string.substring(orgsTagIndex + orgsTag.length(),reuters_string.indexOf("</ORGS>")).trim();
        }

        //Extract the exchanges value
        String exchangesTag = "<EXCHANGES>";
        int exchangesTagIndex = reuters_string.indexOf(exchangesTag);
        if(exchangesTagIndex > 0) {
            reuters.exchanges = reuters_string.substring(exchangesTagIndex + exchangesTag.length(),reuters_string.indexOf("</EXCHANGES>")).trim();
            reuters.exchanges = reuters.exchanges.replaceAll("<D>","").replaceAll("</D>"," ");
        }

        //Extract the companies value
        String companiesTag = "<COMPANIES>";
        int companiesTagIndex = reuters_string.indexOf(companiesTag);
        if(companiesTagIndex > 0) {
            reuters.companies = reuters_string.substring(companiesTagIndex + companiesTag.length(),reuters_string.indexOf("</COMPANIES>")).trim();
        }

        //Extract the unknown value
        String unknownTag = "<UNKNOWN>";
        int unknownTagIndex = reuters_string.indexOf(unknownTag);
        if(unknownTagIndex > 0) {
            reuters.unknown = reuters_string.substring(unknownTagIndex + unknownTag.length(),reuters_string.indexOf("</UNKNOWN>")).trim();
        }

        //Extract the author value
        String authorTag = "<AUTHOR>";
        int authorTagIndex = reuters_string.indexOf(authorTag);
        if(authorTagIndex > 0) {
            reuters.author = reuters_string.substring(authorTagIndex + authorTag.length(),reuters_string.indexOf("</AUTHOR>")).trim();
        }

        reuters_feed.add(reuters);

        return reuters_feed;
    }



    static Pattern EXTRACTION_PATTERN = Pattern.compile(
            "(<DATE>)?(.*?)(</DATE>)?.*?(<TOPICS>)?(.*?)(</TOPICS>)?.*?(<TITLE>)?(.*?)(</TITLE>)?.*?(<DATELINE>)?(.*?)(</DATELINE>)?.*?(<BODY>)?(.*?)(</BODY>)?");

    public static ArrayList<News> parseString(String reuters_string) {

        ArrayList<News> reuters_feed = new ArrayList<News>();
        //Extract the relevant pieces
        Matcher matcher = EXTRACTION_PATTERN.matcher(reuters_string);
        if (matcher.find()) {
            News reuters = new News();
            reuters.date = matcher.group(1);
            reuters.topics = matcher.group(2);
            reuters.title = matcher.group(3);
            reuters.dateLine = matcher.group(4);
            reuters.body = matcher.group(5).replaceAll("&lt;", "<");
            reuters_feed.add(reuters);
        }
        i++;
        return reuters_feed;
    }


    public Iterator<News> iterator() {

        return new ReutersIterator(directory);
    }

    private static class ReutersIterator implements Iterator<News> {

        private LinkedList<News> available = new LinkedList<News>();
        private final LinkedList<File> files = new LinkedList<File>();
        BufferedReader file_reader;

        public ReutersIterator(String dir_name) {

            File directory = new File(dir_name);
            files.addAll(Arrays.asList(directory.listFiles(new FileFilter() {

                public boolean accept(File file) {
                    return file.getName().endsWith(".sgm");
                }
            })));

            // Open first file and read the first element(s)
            openNextFile();
            readNextElements();
        }


        public boolean hasNext() {
            return !available.isEmpty();
        }


        public News next() {

            News current = available.removeFirst();
            if (available.isEmpty()) {
                readNextElements();
            }

            return current;
        }


        private void readNextElements() {

            StringBuilder buffer = new StringBuilder(1024);

            while (true) {
                try {
                    String line = file_reader.readLine();

                    // We reached the end of this file...
                    if (line == null) {
                        file_reader.close();
                        if (!openNextFile()) {
                            // No file left
                            return;
                        }

                        // Might trigger an execption if next file is empty..
                        line = file_reader.readLine();
                    }

                    // Read and append lines until we have a complete reuters news
                    if (line.indexOf("</REUTERS>") == -1) {
                        buffer.append(line).append(' ');
                        continue;
                    }

                    //   System.out.println(buffer.toString());
                    available.addAll(parseStringWithIndex(buffer.toString()));

                    if (!available.isEmpty()) {
                        return;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ReutersDataImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        private boolean openNextFile() {
            if (files.isEmpty()) {
                return false;
            }

            try {
                file_reader = new BufferedReader(new FileReader(files.removeFirst()));
            } catch (FileNotFoundException ex) {
                return false;
            }

            return true;
        }
    }
}
