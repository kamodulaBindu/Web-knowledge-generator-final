package com.stackroute.service;


import com.stackroute.model.Node;
import com.stackroute.Repository.MovieRepository;
import com.stackroute.model.Node1;
import com.stackroute.model.Result;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Result getData(Node1 node) {
        String key1 = "name";
        String key2 = "name";
        String key3 = "name";
        if (node.getValue2() == null) {
            if ((node.getNode2()).equals("Starring") || (node.getNode2()).equals("Director") || (node.getNode2()).equals("Writer") || (node.getNode2()).equals("Producer") || (node.getNode2()).equals("Language") || ((node.getNode1()).equals("Movie")&&(!node.getNode2().equals("ReleasedYear")))) {
                key1 = "name";
            }
            else if (((node.getNode1()).equals("Director"))||((node.getNode1()).equals("Producer"))||((node.getNode1()).equals("Writer"))||((node.getNode1()).equals("Starring"))||((node.getNode1()).equals("ReleasedYear"))||((node.getNode1()).equals("Language"))||(node.getNode2()).equals("Movie") || (node.getNode1()).equals("Starring")||((node.getNode1().equals("Language"))&&(node.getNode2().equals("ReleasedYear")))||((node.getNode1().equals("ReleasedYear"))&&(node.getNode2().equals("ReleasedYear")))||((node.getNode1().equals("Language"))&&(node.getNode2().equals("MANY")))) {
                key1 = "title";
            }
            else if ((node.getNode2()).equals("ReleasedYear")) {
                key1 = "year";
            }
        }
        if (node.getNode3() != null) {
            if ((node.getNode3()).equals("Starring") || (node.getNode3()).equals("Director") || (node.getNode3()).equals("Writer") || (node.getNode3()).equals("Producer") || (node.getNode3()).equals("Language")) {
                key2 = "name";
            }
            else if ((node.getNode3()).equals("Movie") || (node.getNode1()).equals("Starring")) {
                key2 = "title";
            }
            else if (((node.getNode3()).equals("ReleasedYear"))&&(node.getValue3()==null)) {
                key2 = "year";
            }
            else if((node.getNode3().equals("ReleasedYear"))&&(node.getValue3()!=null))
            {
                key3="year";
            }


        }
        System.out.println(node.getValue2());
        System.out.println(node.getNode3());
         if ((node.getValue2()==null)||((node.getNode3()=="MANY") && (node.getValue2() == null))) {
            System.out.println("One hob");
            Collection<Node> nodesuggestions = movieRepository.suggestions1(node, key1);
            HashMap<String, String> queries1 = getsuggestions(nodesuggestions, node);
            Result result = new Result();
            result.setNode(movieRepository.findData(node, key1));
            result.setSuggestions(queries1);
            return result;
        } else if ((node.getValue3())== null) {
            System.out.println("second hob");
            Collection<Node> nodesuggestions = movieRepository.suggestions1(node, key1);
            System.out.println(nodesuggestions);
            HashMap<String, String> queries1 = getsuggestions(nodesuggestions, node);
            Result result = new Result();
            System.out.println(key1);
            System.out.println(key2);
            result.setNode(movieRepository.findData2(node, key1, key2));
            result.setSuggestions(queries1);
            return result;
        } else {
            System.out.println("three hobbe");
            Collection<Node> nodesuggestions = movieRepository.suggestions1(node, key1);
            HashMap<String, String> queries1 = getsuggestions(nodesuggestions, node);

            Result result = new Result();
            result.setNode(movieRepository.findData3(node, key1, key2,key3));
            result.setSuggestions(queries1);
            return result;
        }

    }

    private HashMap<String, String> getsuggestions(Collection<Node> nodesuggestions, Node1 node) {
        HashMap<String, String> queries = new HashMap<>();
        String index="";
        for (Node node1 : nodesuggestions) {
            String movie = node.getValue1();
            String question = "";
            String name = node1.getName().toString();
            int i;
            for (i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '{') {
                    break;
                }
            }
            String part = name.substring(0, i);
            //System.out.println(part);
            if (part.trim().equals("Starring") || part.trim().equals("Director") || part.trim().equals("Producer")) {
                String questions =  " Who is " + part + " of " + movie + "?";
                String[] values = name.split("'");
                queries.put(questions, values[1].trim());

            } else if (part.trim().equals("ReleasedYear")) {
                String question1 = " In which year " + movie + " released?";
                String[] value1 = name.split("'");
                queries.put(question1, value1[1].trim());

            } else if (part.trim().equals("Language")) {
                String question2 =  " In which language " + movie + " released?";
                String[] value1 = name.split("'");
                queries.put(question2, value1[1].trim());

            }
        }
        return queries;
    }
}



