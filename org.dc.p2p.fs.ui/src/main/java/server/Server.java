package server;

import conf.ServerConfigurations;
import gui.ServerHome;

import javax.swing.*;

/**
 * @author janaka
 */

public class Server {

    public void server_main() {

        System.out.println("Starting the server ...");
        ServerConfigurations configs = new ServerConfigurations();
        System.out.println("Server IP = "+ configs.getServerIP());
        System.out.println("Server Port = " + configs.getServerPort());
        System.out.println("BS IP = " + configs.getBSIP());
        System.out.println("BS Port = " + configs.getBSPort());

        InitServerHomeUI(configs);


    }

    public static void InitServerHomeUI(ServerConfigurations configs){
        JFrame frame = new JFrame("ServerHome");
        frame.setContentPane(new ServerHome(configs).ServerMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}