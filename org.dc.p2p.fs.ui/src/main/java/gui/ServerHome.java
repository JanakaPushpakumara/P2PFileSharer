package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import conf.ServerConfigurations;
import service.Neighbour;
import service.Node;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;

/**
 * @author janaka
 */
public class ServerHome {
 public JPanel ServerMain;

 JButton searchButton;
 JTextField textField1;
 JTextPane textPaneFiles;
 JTextPane textPaneNeighbours;
 JTextPane serverIPServerPortTextPane;
 JPanel JPFiles;
 JPanel JPNeighbours;
 JPanel JPBottom;
 JPanel JPTop;
 JPanel JPServerInfo;

 private Node node;

 public void setServerIPServerPortTextPane(JTextPane serverIPServerPortTextPane, ServerConfigurations configs) {
  serverIPServerPortTextPane.setText("Server IP :" + configs.getServerIP() + "\n" +
          "Server Port :" + configs.getServerPort());
 }

 public void setTextPaneFiles(JTextPane textPaneFiles, ServerConfigurations config) {
  File f = new File(config.getFilesStorage());
  String[] filelist = f.list();
  String files = "";
  for (int i = 0; i < filelist.length; i++) {
   files += filelist[i] + "\n";
  }
  String[] randomfilelist = config.getRandomNameList().toArray(new String[0]);
  for (int i = 0; i < randomfilelist.length; i++) {
   files += randomfilelist[i] + "\n";
  }
  textPaneFiles.setText(files);
 }

 public void setTextPaneNeighbours(JTextPane textPaneNeighbours, Node node) {
  String str = "";
  for (Neighbour neighbour : node.getNeighboursList()) {
   str += " IP " + neighbour.getIp() + " PORT " + neighbour.getPort() + "\n";
  }
  textPaneNeighbours.setText(str);
 }

 public ServerHome(ServerConfigurations configs, Node node) {

  this.node = node;
  setServerIPServerPortTextPane(serverIPServerPortTextPane, configs);
  setTextPaneFiles(textPaneFiles, configs);
  setTextPaneNeighbours(textPaneNeighbours, node);
  searchButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    System.out.println("Searching for the files");
    // Query flooding needs to be implemented

    String searchString = textField1.getText();

    try {
     node.searchFiles(searchString);
    } catch (IOException ex) {
     ex.printStackTrace();
    }
    String resultText = "";
    for (String element : node.getResultList().getFileList()) {
     System.out.println(element);
     resultText += element + "\n";
    }

    SearchResult searchResult = new SearchResult();
    searchResult.init(node, searchString, resultText);

    JFrame ResultFrame = new JFrame("SearchResult");
    ResultFrame.setContentPane(searchResult.SearchResult);
    ResultFrame.pack();
    ResultFrame.setVisible(true);

   }
  });
 }

 {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
  $$$setupUI$$$();
 }

 /**
  * Method generated by IntelliJ IDEA GUI Designer
  * >>> IMPORTANT!! <<<
  * DO NOT edit this method OR call it in your code!
  *
  * @noinspection ALL
  */
 private void $$$setupUI$$$() {
  ServerMain = new JPanel();
  ServerMain.setLayout(new GridLayoutManager(6, 6, new Insets(0, 0, 0, 0), -1, -1));
  ServerMain.setPreferredSize(new Dimension(800, 500));
  ServerMain.setRequestFocusEnabled(true);
  ServerMain.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
  searchButton = new JButton();
  searchButton.setBackground(new Color(-3553335));
  searchButton.setForeground(new Color(-16219205));
  searchButton.setText("Search");
  ServerMain.add(searchButton, new GridConstraints(2, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(200, -1), 0, false));
  JPFiles = new JPanel();
  JPFiles.setLayout(new GridLayoutManager(2, 1, new Insets(0, 10, 0, 0), -1, -1));
  JPFiles.setForeground(new Color(-3553335));
  ServerMain.add(JPFiles, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
  final JLabel label1 = new JLabel();
  label1.setText("Files");
  JPFiles.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
  textPaneFiles = new JTextPane();
  JPFiles.add(textPaneFiles, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
  textField1 = new JTextField();
  ServerMain.add(textField1, new GridConstraints(1, 0, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
  JPNeighbours = new JPanel();
  JPNeighbours.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 10), -1, -1));
  ServerMain.add(JPNeighbours, new GridConstraints(4, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
  final JLabel label2 = new JLabel();
  label2.setText("Neighbours");
  JPNeighbours.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
  textPaneNeighbours = new JTextPane();
  JPNeighbours.add(textPaneNeighbours, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
  JPBottom = new JPanel();
  JPBottom.setLayout(new BorderLayout(0, 0));
  ServerMain.add(JPBottom, new GridConstraints(5, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
  JPTop = new JPanel();
  JPTop.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
  ServerMain.add(JPTop, new GridConstraints(0, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
  JPServerInfo = new JPanel();
  JPServerInfo.setLayout(new GridLayoutManager(1, 1, new Insets(0, 10, 0, 10), -1, -1));
  ServerMain.add(JPServerInfo, new GridConstraints(3, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, new Dimension(-1, 50), 0, false));
  serverIPServerPortTextPane = new JTextPane();
  serverIPServerPortTextPane.setText("Server IP :\nServer Port : \n");
  JPServerInfo.add(serverIPServerPortTextPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
 }

 /**
  * @noinspection ALL
  */
 public JComponent $$$getRootComponent$$$() {
  return ServerMain;
 }

}
