package com.masters.oops;

/**
 * Created by nikithaperumalla on 8/6/14.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TVTuner extends JFrame {

    public static final int MIN_CHANNEL = 2;
    public static final int MAX_CHANNEL = 13;

    private int currentChannel = MIN_CHANNEL;
    private int favoriteChannel = 9;
    private JLabel channelLabel = new JLabel();

    private Action upAction = new UpAction();
    private Action downAction = new DownAction();
    private GotoFavoriteAction gotoFavoriteAction = new GotoFavoriteAction();
    private Action setFavoriteAction = new SetFavoriteAction();

    public class UpAction extends AbstractAction {
        public UpAction() {
            putValue(NAME, "Channel Up");
            putValue(SMALL_ICON, new ImageIcon("images/up.gif"));
            putValue(SHORT_DESCRIPTION, "Increment the channel number");
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_U));
        }
        public void actionPerformed(ActionEvent ae) {
            // Fill in your code
            //
        }
    }

    class DownAction extends AbstractAction {
        public DownAction() {
            // Fill in your code
            //
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_D));
        }
        public void actionPerformed(ActionEvent ae) {
            // Fill in your code
            //
        }
    }

    class GotoFavoriteAction extends AbstractAction {
        public GotoFavoriteAction() {
            putValue(SMALL_ICON, new ImageIcon("images/fav.gif"));
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
            // Fill in your code
            // ...
        }
        public void updateProperties() {
            putValue(NAME, "Go to channel "+favoriteChannel);
            putValue(SHORT_DESCRIPTION, "Change the channel to "+favoriteChannel);
        }
        public void actionPerformed(ActionEvent ae) {
            // Fill in your code
            //
        }
    }

    class SetFavoriteAction extends AbstractAction {
        public SetFavoriteAction() {
            putValue(NAME, "Set Favorite channel");
            putValue(SMALL_ICON, new ImageIcon("images/set.gif"));
            putValue(SHORT_DESCRIPTION,
                    "Make current channel the Favorite channel");
            putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
        }
        public void actionPerformed(ActionEvent ae) {
            // Fill in your code
            // ......
        }
    }

    public TVTuner() {
        super("TVTuner");

        setChannel(currentChannel); // enable/disable the Actions as appropriate

        channelLabel.setHorizontalAlignment(JLabel.CENTER);
        channelLabel.setFont(new Font("Serif", Font.PLAIN, 32));

        getContentPane().add(channelLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 16, 6));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(6, 16, 16, 16));
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.add(new JButton(upAction));
        // Fill in your code
        // ...
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Channel");
        menu.add(new JMenuItem(upAction));
        // Fill in your code
        // ...
        menu.addSeparator();
        // Fill in your code
        // ...
        mb.add(menu);
        setJMenuBar(mb);
    }

    public void setChannel(int chan) {
        currentChannel = chan;
        channelLabel.setText("My TV tuned to channel: "+currentChannel);
        // enable/disable the Actions as appropriate
        downAction.setEnabled(currentChannel > MIN_CHANNEL);
        upAction.setEnabled(currentChannel < MAX_CHANNEL);
        gotoFavoriteAction.setEnabled(currentChannel != favoriteChannel);
        setFavoriteAction.setEnabled(currentChannel != favoriteChannel);
    }

    public static void main(String argv[]) {
        JFrame f = new TVTuner();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fill in your code
        // ...
    }
}