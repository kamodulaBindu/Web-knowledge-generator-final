package com.stackroute.model;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Dictionaryy {

    ArrayList<String> movie = new ArrayList<String>();
    ArrayList<String> starring = new ArrayList<String>();
    ArrayList<String> director = new ArrayList<String>();
    ArrayList<String> releasedyear = new ArrayList<String>();
    ArrayList<String> productionhouse = new ArrayList<String>();
    ArrayList<String> producer = new ArrayList<String>();
    ArrayList<String> moviename = new ArrayList<String>();
    ArrayList<String> actorname = new ArrayList<String>();
    ArrayList<String> directorname = new ArrayList<String>();
    ArrayList<String> producername = new ArrayList<String>();
    ArrayList<String> releaseyear = new ArrayList<String>();
    ArrayList<String> productionhousename = new ArrayList<String>();
    ArrayList<String> language = new ArrayList<String>();


    public HashMap<String,String> mapvalue(LinkedList<String> list) {
        movie.add("Movie");
        movie.add("cinema");
        movie.add("movies");
        movie.add("motion picture");
        movie.add("picture");
        movie.add("film");
        movie.add("movie projector");
        movie.add("photographic film");
        movie.add("photographic film");
        movie.add("television");
        movie.add("motion picture");
        movie.add("filmmaking");
        movie.add("documentary");
        movie.add("movie theater");
        movie.add("photography");
        movie.add("screenplay");
        movie.add("microfilm");
        movie.add("episode");
        movie.add("telefilm");
        movie.add("cinematography");
        movie.add("silver screen");
        movie.add("videotape");
        movie.add("scene");
        movie.add("computer animation");
        movie.add("film noir");


        moviename.add("Kiss.of.Fire");
        moviename.add("The.Girl.Rush");
        moviename.add("Guns.Don't.Argue");
        moviename.add("Hi-Jack.Highway");

        //star cast dictionary
        starring.add("Starring");
        starring.add("CASTED_IN");
        starring.add("casting");
        starring.add("casted");
        starring.add("actor");
        starring.add("actress");
        starring.add("star");
        starring.add("act");
        starring.add("performer");
        starring.add("character");
        starring.add("player");
        starring.add("comedian");
        starring.add("tragedian");
        starring.add("villain");
        starring.add("supporting actor");
        starring.add("supporting actress");
        starring.add("hero");
        starring.add("heroine");
        starring.add("heroic");
        starring.add("protagonist");
        starring.add("leader");
        starring.add("superstar");
        starring.add("done");
        starring.add("fighter");
        starring.add("superhero");
        starring.add("man");
        starring.add("women");
        starring.add("stars");
        starring.add("acting");
        starring.add("acted");
        starring.add("action");
        starring.add("actors");
        starring.add("heroes");
        starring.add("actresses");

        actorname.add("Delia.Scala");
        actorname.add("Barbara.Rush");
        actorname.add("Rosalind.Russell");
        actorname.add("Eddie.Albert");
        actorname.add("Jean.Harvey");
        actorname.add("Paul.Dubov");
        actorname.add("Jean.Gabin");
        actorname.add("Gaby.Basset");

        // director dictionary

        director.add("Director");
        director.add("DIRECTED");
        director.add("manager");
        director.add("administrator");
        director.add("assistant");
        director.add("executive");
        director.add("assistant director");
        director.add(" managing director");
        director.add("music director");
        director.add("supervisor");
        director.add("manager");
        director.add("directing");
        director.add("direct");
        director.add("manager");
        director.add("shoot");
        director.add("shooted");
        director.add("direction");


        directorname.add("Robert.Pirosh");
        directorname.add("Bill.Karn");
        directorname.add("Gilles.Grangier");
        //producer dictionary

        producer.add("Producer");
        producer.add("PRODUCED");
        producer.add("filmmaker");
        producer.add("manufacturer");
        producer.add("maker");
        producer.add("promoter");
        producer.add("creator");
        producer.add("Producers");
        producer.add("arranger");
        producer.add("studio");
        producer.add("coproduce");
        producer.add("generate");
        producer.add("producing");

        //production house dictionary
        producer.add("ProductionHouse");
        producer.add("PRODUCTION");
        producer.add("company");
        producer.add("production house");
        producer.add("house");
        producer.add("production company");
        producer.add("production");
        producer.add("made");
        producer.add("making");
        productionhousename.add("Visual.Drama.inc");

        // released year dictionary
        releasedyear.add("ReleasedYear");
        releasedyear.add("RELEASES");
        releasedyear.add("year");
        releasedyear.add("date");
        releasedyear.add("released");
        releasedyear.add("releasing");
        releasedyear.add("Released in");
        releasedyear.add("release");
        releasedyear.add("release date");
        releasedyear.add("release date");
        releasedyear.add("releases");
        releasedyear.add("latest");
        releasedyear.add("first");
        releasedyear.add("last");



        releaseyear.add("1955");
        releaseyear.add("1957");
        releaseyear.add("1955");

        //language dictionary

        language.add("Language");
        language.add("HAS_LANGUAGE");
        language.add("Hindi");
        language.add("English");
        language.add("Telugu");
        language.add("Punjabi");
        language.add("Tamil");
        language.add("Kannad");
        language.add("Bengali");
        language.add("French");
        language.add("Urdu");
        language.add("Russian");
        language.add("Spanish");
        language.add("Korean");
        language.add("Malayali");
        language.add("Chinese");





        HashMap<String, String> relationlist = new HashMap<String, String>();
        HashMap<String, String> valuelist = new HashMap<String, String>();
        HashMap<String, String> nodelist = new HashMap<String, String>();
        HashMap<String,String> result = new HashMap<String,String>();

        System.out.println("list value is :"+list);
        int index1=1;
        int index2=1;
        int index3=1;


        Boolean isactor = false;
        Boolean isproducer = false;
        Boolean isdirector = false;
        Boolean isyear = false;
        Boolean isLanguage = false;
        Boolean isMovie = false;

        for (int i = 0; i < list.size(); i++) {

            Boolean flag = false;


            if((list.get(i) == "") || (list.get(i) == " ")){

            }else {


                if (list.get(i) != null) {
                    System.out.println("EACH KEYWORD"+list.get(i));

                    for (String item : movie) {
                        if (list.get(i).equalsIgnoreCase(item)) {
                            nodelist.put("node" + (index1++), movie.get(0));
                            flag = true;
                            isMovie = true;
                            break;
                        }
                    }

//                for (String item1 : moviename) {
//                    if (list.get(i).equalsIgnoreCase(item1)) {
//                        valuelist.put("value"+(index3++),item1);
//                        break;
//                    }
//
//                }

                    for (String item2 : starring) {

                        if (list.get(i).equalsIgnoreCase(item2)) {
                            System.out.println("starring");
                            nodelist.put("node" + (index1++), starring.get(0));
                            relationlist.put("relation" + (index2++), starring.get(1));
                            flag = true;
                            isactor = true;
                            break;

                        }

                    }
//                for (String item3 : actorname) {
//                    if (list.get(i).equalsIgnoreCase(item3)) {
//
//                        valuelist.put("value"+(index3++),item3);
//
//                        break;
//                    }
//
//                }
                    for (String item4 : director) {
                        if (list.get(i).equalsIgnoreCase(item4)) {
                            nodelist.put("node" + (index1++), director.get(0));
                            relationlist.put("relation" + (index2++), director.get(1));
                            flag = true;
                            isdirector = true;
                            break;
                        }

                    }
//                for (String item5 : directorname) {
//                    if (list.get(i).equalsIgnoreCase(item5)) {
//
//                        valuelist.put("value"+(index3++),item5);
//
//                        break;
//                    }
//
//                }
                    for (String item6 : producer) {
                        if (list.get(i).equalsIgnoreCase(item6)) {
                            nodelist.put("node" + (index1++), producer.get(0));
                            relationlist.put("relation" + (index2++), producer.get(1));
                            flag = true;
                            isproducer = true;
                            break;
                        }

                    }
//                for (String item7 : producername) {
//                    if (list.get(i).equalsIgnoreCase(item7)) {
//                        nodelist.put("node"+(index1++),producer.get(0));
//                        valuelist.put("value"+(index3++),item7);
//                        relationlist.put("relation"+(index2++),producer.get(1));
//                        break;
//                    }
//
//
//                }
//                    for (String item8 : productionhouse) {
//                        if (list.get(i).equalsIgnoreCase(item8)) {
//                            nodelist.put("node" + (index1++), productionhouse.get(0));
//                            relationlist.put("relation" + (index2++), productionhouse.get(1));
//                            flag = true;
//                             = false;
//                            break;
//                        }
//                    }
//                for (String item9 : productionhousename) {
//                    if (list.get(i).equalsIgnoreCase(item9)) {
//                        nodelist.put("node"+(index1++),productionhouse.get(0));
//                        valuelist.put("value"+(index3++),item9);
//                        relationlist.put("relation"+(index2++),productionhouse.get(1));
//                        break;
//                    }
//
//
//                }
                    for (String item10 : releasedyear) {
                        if (list.get(i).equalsIgnoreCase(item10)) {
                            nodelist.put("node" + (index1++), releasedyear.get(0));
                            relationlist.put("relation" + (index2++), releasedyear.get(1));
                            flag = true;
                            isyear = true;
                            break;

                        }

                    }

                    for (String item11 : language) {
                        if (list.get(i).equalsIgnoreCase(item11)) {
                            nodelist.put("node" + (index1++), language.get(0));
                            relationlist.put("relation" + (index2++), language.get(1));
                            flag = true;
                            isLanguage = true;
                            break;

                        }

                    }


//                for (String item11 : releaseyear) {
//                    if (list.get(i).equalsIgnoreCase(item11)) {
//                        nodelist.put("nodery"+(index1++),releasedyear.get(0));
//                        valuelist.put("valuery"+(index3++),item11);
//                        relationlist.put("relationry"+(index2++),releasedyear.get(1));
//                        break;
//                    }
//
//                }
//
                    if (flag == false) {

                        if (list.get(i).matches("^[0-9]{4}$")) {
                            if (isyear == true) {
                                valuelist.put("value" + (index3++), list.get(i));
                            } else {
                                nodelist.put("node" + (index1++), "ReleasedYear");
                                relationlist.put("relation" + (index2++), "RELEASES");
                                valuelist.put("value" + (index3++), list.get(i));
                            }

                        } else {
                            System.out.println("ACTOR VALUE"+isactor);
                            if(isMovie == true){
                                valuelist.put("value" + (index3++), list.get(i));
                                isMovie = false;
                            }
                            else if (isactor == true) {
                                valuelist.put("value" + (index3++), list.get(i));
                                isactor = false;
                            }else if (isdirector == true) {
                                valuelist.put("value" + (index3++), list.get(i));
                                isdirector = false;
                            }else  if (isproducer == true) {
                                valuelist.put("value" + (index3++), list.get(i));
                                isproducer = false;
                            }else  if (isLanguage == true) {
                                valuelist.put("value" + (index3++), list.get(i));
                                isLanguage = false;
                            }
                            else {
                                nodelist.put("node" + (index1++), "MANY");
                                relationlist.put("relation" + (index2++), "MANY");
                                valuelist.put("value" + (index3++), list.get(i));
                                System.out.println("all many node reation value");
                            }

                        }

                    }


                }

            }
        }


        System.out.println(nodelist);
        System.out.println(relationlist);
        System.out.println(valuelist);
        if(nodelist.size() == 1){
            nodelist.put("node" + 2, "MANY");
            relationlist.put("relation" + 2, "MANY");
        }

        for (Map.Entry<String,String> entry : nodelist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String,String> entry : relationlist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String,String> entry : valuelist.entrySet()){
            result.put(entry.getKey(),entry.getValue());
        }


        System.out.println(result);


        index1=1;
        index2=1;
        index3=1;

        movie.clear();
        starring.clear();
        director.clear();
        releasedyear.clear();
        productionhouse.clear();
        producer.clear();
        moviename.clear();
        actorname.clear();
        directorname.clear();
        producername.clear();
        releaseyear.clear();
        productionhousename.clear();




        return result;
    }
}