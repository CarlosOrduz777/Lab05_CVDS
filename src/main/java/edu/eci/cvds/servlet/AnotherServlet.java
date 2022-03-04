package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Writer responseWriter = resp.getWriter();

            //Recibir el id ingresado
            String id = req.getParameter("id");
            //Consultar el ToDo
            Todo todo = Service.getTodo(Integer.parseInt(id));

            //Respuesta OK
            resp.setStatus(HttpServletResponse.SC_OK);

            //Crear List para generar la tabla
            todoList = new ArrayList<Todo>();
            todoList.add(todo);

            //Mostrar la tabla
            responseWriter.write(Service.todosToHTMLTable(todoList));
        }
        //Valor nulo
        catch(NumberFormatException e){
            sendHtmlError(resp, "400 : Requerimiento inválido.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //Error en el servidor
        catch (MalformedURLException e){
            sendHtmlError(resp, "500 : Error interno del servidor.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //Valor nulo o caracter no valido
        catch(IOException e) {
            sendHtmlError(resp, "404 : No existe un item con el identificador dado.", HttpServletResponse.SC_NOT_FOUND);
        }

        //Excepcion para valor nulo
        catch(Exception e){
            sendHtmlError(resp, "400 : Requerimiento inválido", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Enviar un mensaje de respuesta en HTML
     * @param resp Clase respuesta
     * @param error El mensaje del error a mostrar
     * @param noError El numero del error a mostrar
     */
    private void sendHtmlError(HttpServletResponse resp, String error, int noError){
        try {
            resp.setStatus(noError);
            Writer responseWriter = resp.getWriter();
            responseWriter.write(new StringBuilder("<h1>")
                    .append(error)
                    .append("</h1>")
                    .toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Writer responseWriter = resp.getWriter();

            //Recibir el id ingresado
            String id = req.getParameter("id");
            //Consultar el ToDo
            Todo todo = Service.getTodo(Integer.parseInt(id));

            //Respuesta OK
            resp.setStatus(HttpServletResponse.SC_OK);

            //Crear List para generar la tabla
            todoList = new ArrayList<Todo>();
            todoList.add(todo);

            //Mostrar la tabla
            responseWriter.write(Service.todosToHTMLTable(todoList));
        }
        //Valor nulo
        catch(NumberFormatException e){
            sendHtmlError(resp, "400 : Requerimiento inválido.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //Error en el servidor
        catch (MalformedURLException e){
            sendHtmlError(resp, "500 : Error interno del servidor.", HttpServletResponse.SC_BAD_REQUEST);
        }

        //Valor nulo o caracter no valido
        catch(IOException e) {
            sendHtmlError(resp, "404 : No existe un item con el identificador dado.", HttpServletResponse.SC_NOT_FOUND);
        }

        //Excepcion para valor nulo
        catch(Exception e){
            sendHtmlError(resp, "400 : Requerimiento inválido", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}