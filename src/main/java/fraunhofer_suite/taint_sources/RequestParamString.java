// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.taint_sources;

import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestParamString extends HttpServlet {
  public void test(@RequestParam String taint, HttpServletResponse response) throws IOException {
    response.getWriter().println(taint);  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}