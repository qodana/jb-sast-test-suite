// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.invalid_code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class TestUnfinishedMethod {
  public URL getMissingNixonTapes() {

  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    response.getWriter().println(taint); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}