package com.adidyk;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        Socket socket = mock(Socket.class);
//        ByteArrayInputStream in = new ByteArrayInputStream("q".getBytes());
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.init();
        server.work();
        assertThat(out.toString(), is(""));

    }

}