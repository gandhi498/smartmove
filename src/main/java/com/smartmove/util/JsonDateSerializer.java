package com.smartmove.util;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Calendar> {

    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void serialize(Calendar date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        //String formattedDate = dateFormat.format(date.getTime());
        StringBuffer sbf = new StringBuffer();
        sbf.append(date.get(Calendar.YEAR)).append("-").append(date.get(Calendar.MONTH) + 1).append("-").append(date.get(Calendar.DATE)).append(" ").append(date.get(Calendar.HOUR_OF_DAY)).append(":").append(date.get(Calendar.MINUTE));
        gen.writeString(sbf.toString());
    }
}
