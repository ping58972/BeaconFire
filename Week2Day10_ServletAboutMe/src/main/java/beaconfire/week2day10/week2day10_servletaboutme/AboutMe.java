package beaconfire.week2day10.week2day10_servletaboutme;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "AboutMe", value = "/about-me")
public class AboutMe extends HttpServlet {
    private String name;
    private String interests;

    public void init() {
        name = "Ping Danddank";
        interests = "Enjoy Walking, Best Movie, Best Music, One Piece, Naruto, One Punch man.";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "About Me:" + "</h1>");
        out.println("<p>" + name + "</p>");
        out.println("<p>"+ interests +"</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String content = req.getParameter("song-lyrics");
        PrintWriter out = resp.getWriter();
        out.println(content);

    }

    public void destroy() {
    }
}