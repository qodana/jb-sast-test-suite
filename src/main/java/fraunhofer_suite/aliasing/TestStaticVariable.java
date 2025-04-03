// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.aliasing;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestStaticVariable {
  static String storage = "safe";

  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    response.getWriter().println(storage);
    storage = taint;
    response.getWriter().println(storage); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}