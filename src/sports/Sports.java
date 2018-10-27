package sports;

import java.sql.SQLException;
import javax.swing.*;

public class Sports {
    
    private Connector conn;
    
    Sports() throws ClassNotFoundException, SQLException{
         conn = new Connector();
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        
    }
}