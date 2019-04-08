package interfaz;
//Librerias importadas
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class jTableSelect extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Si el objeto que se desea agregar es un boton, esto lo agrega
        if(value instanceof JButton){
            JButton boton = (JButton)value;
            return boton;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
}
