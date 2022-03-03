package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

@WebServlet(
        urlPatterns = "/lab5"
)
public class AnotherServlet extends HttpServlet{
    static final long serialVersionUID = 35L;
    List<Todo> todoList;
    public AnotherServlet(){
        todoList = new List<Todo>;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

        Todo todo = Service.getTodo(Integer.parseInt(id));
        todoList.add(todo);
        if(todo!= null){
            resp.setStatus(HttpServletResponse.SC_OK);
            String answer = Service.todosToHTMLTable(todoList);
            responseWriter.write(answer);
            responseWriter.flush();
        }else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }


        responseWriter.write("Hello" + name + "!");
        responseWriter.flush();
    }
}