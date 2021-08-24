package org.example.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IpCollectorServlet extends HttpServlet {

    private final Map<String, String> IpToUserAgentMap = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>IP list</h1>");

        IpToUserAgentMap.put(req.getRemoteAddr(), req.getHeader("User-Agent") + " at " + LocalDateTime.now());

        for (var entry : IpToUserAgentMap.entrySet()) {
            if (entry.getKey().equals(req.getRemoteAddr())) {
                writer.println("<b>" + entry.getKey() + " :: " + entry.getValue() + "</b>");
            } else {
                writer.println(entry.getKey() + " :: " + entry.getValue());
            }
            writer.println("</br>");
        }
    }
}
