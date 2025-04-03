// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.invalid_code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestUnfinishedMethod {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String str = decodeSHA1(taint);

    response.getWriter().println(taint);  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}