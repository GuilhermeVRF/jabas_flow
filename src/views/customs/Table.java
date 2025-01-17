package views.customs;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Table extends JTable {

    public Table(TableModel model) {
        super(model);
        applyCustomStyles();
    }

    private void applyCustomStyles() {
        // Definir altura das linhas
        setRowHeight(40);

        // Estilizar o cabeçalho
        JTableHeader header = getTableHeader();
        header.setFont(new Font("Roboto", Font.BOLD, 16));
        header.setBackground(new Color(63, 81, 181));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        // Fonte e cores das células
        setFont(new Font("Roboto", Font.PLAIN, 14));
        setForeground(new Color(33, 33, 33)); 
        setBackground(new Color(245, 245, 245)); 

        // Seleção de linha
        setSelectionBackground(new Color(0x9AA6B2)); 
        setSelectionForeground(Color.BLACK);

        // Remover bordas da tabela
        setShowGrid(false);

        // Alinhamento centralizado para todas as colunas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultRenderer(Object.class, centerRenderer);

        // Bordas arredondadas (opcional)
        setIntercellSpacing(new Dimension(0, 0));
        setRowMargin(0);
    }
}
