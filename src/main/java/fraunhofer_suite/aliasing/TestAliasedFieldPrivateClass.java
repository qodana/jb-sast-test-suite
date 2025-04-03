// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.aliasing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestAliasedFieldPrivateClass {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    A x = new A();
    A y = x;
    response.getWriter().println(x.a);
    y.a = taint;
    response.getWriter().println(x.a); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }

  private class A {
    public String a;
  }
}