//package com.rusamaha.gm.view.Impl;
//
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.MapperFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.rusamaha.gm.view.JsonManager;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.io.InputStream;
//import java.io.StringWriter;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.logging.Logger;
//
////import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
//
///**
// * User: shushkov.r
// * Time: 9/24/13 12:28 PM
// */
//@Component
//public class JacksonJsonManager implements JsonManager {
//    private static Logger log = Logger.getLogger("jacksonJsonManager");
//    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
//
//    public JacksonJsonManager() {
//        this.mapper = new ObjectMapper();
//        init();
//    }
//
//    @PostConstruct
//    public void init() {
////        mapper.registerModule(new Hibernate4Module());
////        mapper.registerModule(new JaxbAnnotationModule());
//        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
//        mapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
//        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
//        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        mapper.disableDefaultTyping();
//        mapper.setVisibilityChecker(mapper.getVisibilityChecker().with(JsonAutoDetect.Visibility.NONE));
//        mapper.setVisibility(PropertyAccessor.NONE, JsonAutoDetect.Visibility.ANY);
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/y");
//        mapper.setDateFormat(dateFormat);
//        mapper.getSerializationConfig().with(dateFormat);
//
//    }
//
//    @Transactional
//    public String marshall(Object instance) {
//        StringWriter writer = new StringWriter();
//        try {
//            mapper.writeValue(writer, instance);
//        } catch (Exception e) {
//            log.info("Can't marshal: "+e);
//        }
//        return writer.toString();
//    }
//
//    public <T2> T2 unMarshall(String json, Class<T2> type) {
//        T2 result = null;
//        try {
//            result = mapper.readValue(json, type);
//        } catch (Exception e) {
//            log.info("Can't unMarshall: "+e);
//        }
//        return result;
//    }
//
//    public <T2> T2 unMarshall(InputStream jsonStream, Class<T2> type) {
//        T2 result = null;
//        try {
//            result = mapper.readValue(jsonStream, type);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
