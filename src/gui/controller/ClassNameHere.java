package gui.controller;

import javax.swing.JOptionPane;

//Pomocna klasa za iskakajuci prozor
// https://stackoverflow.com/questions/7080205/popup-message-boxes prvi odgovor
public class ClassNameHere
{

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

