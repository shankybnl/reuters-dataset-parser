package controllers;

import play.mvc.Result;
import services.servicesImpl.FetchReutersDataImpl;

import javax.inject.Inject;

import static play.mvc.Results.ok;

public class ReutersController {


    @Inject
    FetchReutersDataImpl fetchReutersData;


    public Result getContent() {
        return ok(fetchReutersData.getContent());
    }


    public Result searchContent(String match) {
        return ok(fetchReutersData.matchString(match));
    }


    public Result getTopic(String topic) {
        return ok(fetchReutersData.getTopic(topic));
    }
}
