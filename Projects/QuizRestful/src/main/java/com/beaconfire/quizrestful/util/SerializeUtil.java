package com.beaconfire.quizrestful.util;

import com.beaconfire.quizrestful.domain.message.QuizHistoryMessage;
import com.beaconfire.quizrestful.domain.message.SimpleMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String serializeQuiz(QuizHistoryMessage message) {
        String result = null;
        try{
            result = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return result;
    }
    public static String serializeSimple(SimpleMessage message) {
        String result = null;
        try{
            result = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return result;
    }
}
