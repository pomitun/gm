//package com.rusamaha.gm.view;
//
//import com.rusamaha.gm.controllers.BaseController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.servlet.view.AbstractView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.util.Map;
//
//
//@Component
//public class JsonView extends AbstractView {
//    @Autowired
//    @Qualifier("jacksonJsonManager")
//    private JsonManager jsonManager;
//
//    @Transactional
//    protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out;
//        try {
//            out = response.getWriter();
//            Object result = map.get(BaseController.ROOT_OBJECT_MAP_KEY);
//            if (result != null) {
//                out.write(jsonManager.marshall(result));
//            } else {
//                out.write(jsonManager.marshall(""));
//            }
//        } catch (Exception ex) {
//        }
//    }
//}