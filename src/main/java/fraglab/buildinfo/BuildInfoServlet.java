package fraglab.buildinfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuildInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("buildinfo.properties");
        Properties props = new Properties();
        props.load(is);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.getOutputStream().print(gson.toJson(props));
    }


}
