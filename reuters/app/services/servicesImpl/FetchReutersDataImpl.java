package services.servicesImpl;
import dto.News;
import play.Logger;
import services.FetchReutersData;

public class FetchReutersDataImpl implements FetchReutersData {

    ReutersDataImpl reuters_dataset;
    StringBuffer newsBuffer;

    @Override
    public String getContent() {
       loadDataFile();
         newsBuffer = new StringBuffer();


        long startTime = System.currentTimeMillis();
        int i = 0;
        for (News news : reuters_dataset) {

            newsBuffer.append(news.date);
            if (news.date.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.topics);
            if (news.topics.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.places);
            if (news.places.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.people);
            if (news.people.length() > 0) {
                newsBuffer.append("\n");
            }


            newsBuffer.append(news.orgs);
            if (news.orgs.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.exchanges).append("\n");
            if (news.exchanges.length() > 0) {
                newsBuffer.append("\n");
            }


            newsBuffer.append(news.companies);
            if (news.companies.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.unknown);
            if (news.unknown.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.title);
            if (news.title.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.author);
            if (news.author.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.dateLine);
            if (news.dateLine.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append(news.body);
            if (news.body.length() > 0) {
                newsBuffer.append("\n");
            }

            newsBuffer.append("\n").append("\n");
            i++;
        }

        System.out.println("size: " + i);
        long endTime = System.currentTimeMillis();

        System.out.println("total time: " + (endTime - startTime) + " ms");
        return newsBuffer.toString();

    }

    @Override
    public String matchString(String match) {
        loadDataFile();
        newsBuffer = new StringBuffer();

    Logger.info("match string: " + match);

        long startTime = System.currentTimeMillis();
        int i = 0;
        for (News news : reuters_dataset) {

            if(news.date.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.date).append("\n");
            }

            if(news.topics.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.topics).append("\n");
            }

            if(news.places.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.places).append("\n");
            }

            if(news.people.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.people).append("\n");
            }

            if(news.orgs.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.orgs).append("\n");
            }

            if(news.exchanges.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.exchanges).append("\n");
            }

            if(news.companies.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.companies).append("\n");
            }

            if(news.unknown.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.unknown).append("\n");
            }

            if(news.title.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.title).append("\n");
            }

            if(news.author.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.author).append("\n");
            }

            if(news.dateLine.toLowerCase().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.dateLine).append("\n");
            }

            if(news.body.toLowerCase().trim().contains(match.toLowerCase().trim())) {
                newsBuffer.append(news.body).append("\n");
            }
            //newsBuffer.append("\n");
            i++;
        }

        System.out.println("size: " + i);
        long endTime = System.currentTimeMillis();

        System.out.println("total time: " + (endTime - startTime) + " ms");
        return newsBuffer.toString();
    }

    @Override
    public String getTopic(String topic) {

        loadDataFile();
        StringBuffer topicDataBuffer = new StringBuffer();
       // Logger.info("value passed: " + topic);

        long startTime = System.currentTimeMillis();
        int i = 0;
        for (News news : reuters_dataset) {
         //   Logger.info("topic: " + news.title);
            if (news.title.length() > 0) {
                if(news.title.toLowerCase().contains(topic.toLowerCase().trim())) {
                    topicDataBuffer.append(news.title).append("\n");
                }
                i++;
            }

        }

       Logger.info("size: " + i);
        long endTime = System.currentTimeMillis();
        Logger.info("total time: " + (endTime - startTime) + " ms");
        return topicDataBuffer.toString();

    }


    public void loadDataFile(){
         reuters_dataset = new ReutersDataImpl("/Users/rivigo/Documents/workspace/open-source/reuters/app/data/");
    }


}
