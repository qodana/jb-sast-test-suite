// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.conditions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestConstantExpression {
  public void tedt(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");

    if (filter(8)) {
      response.getWriter().println(taint); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    }
    else {
      response.getWriter().println(taint);
    }
  }

  private boolean filter(int param) {
    return param > 7;
  }
}