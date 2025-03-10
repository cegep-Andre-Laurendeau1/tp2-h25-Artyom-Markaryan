package ca.cal.tp2;

import org.h2.tools.Server;
import java.sql.SQLException;

public class TcpServer {
    public static void createTcpServer() throws SQLException {
        Server tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        System.out.println("TcpServer start: " + tcpServer.start());
        System.out.println(tcpServer.getStatus() + " " + tcpServer.getPort());
        System.out.println("jdbc:h2:tcp://localhost:9092/mem:tp2artyom");
    }
}
