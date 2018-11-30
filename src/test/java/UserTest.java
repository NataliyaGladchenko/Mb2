import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import servlet.UserServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class UserTest {

//    @Test
//    public void testGetAllUserRequest() throws IOException {
//        HttpUriRequest requestGetAllUsers = new HttpGet("http://localhost:8080/user");
//        HttpResponse responseGetAllUsers = HttpClientBuilder.create().build().execute(requestGetAllUsers);
//        HttpEntity entityGetAllUsers = responseGetAllUsers.getEntity();
//        int count = 0;
//        InputStream inputStream = entityGetAllUsers.getContent();
//        try (Scanner scanner = new Scanner(inputStream).useDelimiter("\n")) {
//            while (scanner.hasNext()) {
//                String result = scanner.next();
//                count++;
//            }
//        }
//        assertEquals(8, count);
//    }
//
//    @Test
//    public void testAddUser() throws IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        when(request.getParameter("name")).thenReturn("Nicolas");
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
//        when(response.getWriter()).thenReturn(writer);
//
//        new UserServlet().doPost(request, response);
//
//        verify(request).getParameter("name");
//        assertTrue(stringWriter.toString().contains(""));
//
//    }

}