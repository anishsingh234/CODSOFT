package Task3;

//importing the necessary libraries----->
import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Table {
  DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
      ResultSetMetaData metaData = rs.getMetaData();

      // Get column names to print the column data---->
      int columnCount = metaData.getColumnCount();
      Vector<String> columnNames = new Vector<String>();
      for (int i = 1; i <= columnCount; i++) {
          columnNames.add(metaData.getColumnName(i));
      }

      // Get row data---->
      Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();
      while (rs.next()) {
          Vector<Object> row = new Vector<Object>();
          for (int i = 1; i <= columnCount; i++) {
              row.add(rs.getObject(i));
          }
          rowData.add(row);
      }
      
      //returning the obtained row and column data------>
      return new DefaultTableModel(rowData, columnNames);
  }
}