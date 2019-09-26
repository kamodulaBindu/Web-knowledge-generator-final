package com.stackroute.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.modals.CodeBeautify;
import com.stackroute.modals.Result;
import com.stackroute.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class WebSearchServiceImpl implements WebSearchService {
    @Autowired
    private SearchRepository searchRepository;

    public WebSearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }


    @Override
    public String getSearchResults(String searchString) throws URISyntaxException {
        Result output = null;
        RestTemplate restTemplate = new RestTemplate();
        //api to get links from
        String url = "https://app.zenserp.com/api/v2/search?q=wikipedia+film"+searchString+"&hl=en&gl=US&location=United%20States&search_engine=google.com&apikey=f9e765e0-da0a-11e9-bdea-e186b5f14210";
        URI uri = new URI(url);
        String string = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        CodeBeautify result = null;
        try
        {
            result = objectMapper.readValue(string, CodeBeautify.class);
            List<Result> resultList = result.getOrganic();
            output = resultList.get(0);
            searchRepository.save(output);
        }
        catch (IOException e)
        {

        }
        String output1=output.toString();
        int len = output1.length();
        return output1.substring(10,len-3);

    }

}
