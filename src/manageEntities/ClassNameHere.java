package manageEntities;

import javax.swing.JOptionPane;

//Pomocna klasa za iskakajuci prozor
public class ClassNameHere
{

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
};

