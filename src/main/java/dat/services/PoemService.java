package dat.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat.dtos.PoemDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PoemService {

    public static ArrayList<PoemDTO> getPoems() {
        ArrayList<PoemDTO> poemList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //JSON String
            String jsonString = JsonFileReader.readJsonFromFile("poems.json");

            //Convert JSON String to Object
            PoemDTO[] poems = objectMapper.readValue(jsonString, PoemDTO[].class);
            
            // Add poems to the list
            for (PoemDTO poem : poems) {
                poemList.add(poem);
            }
            return poemList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}