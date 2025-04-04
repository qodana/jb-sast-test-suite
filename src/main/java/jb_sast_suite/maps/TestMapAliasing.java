// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMapAliasing {
  public static void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String a = taint;

    Map<Integer, String> map1 = new HashMap<>();
    map1.put(1, a);

    Map<Integer, String> map2 = map1;

    response.getWriter().println(map2.get(1));  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
