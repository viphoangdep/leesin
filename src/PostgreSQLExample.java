import java.sql.*;

public class PostgreSQLExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Thiết lập thông tin kết nối
            String url = "jdbc:postgresql://localhost:5432/Bill_coffe_machine";
            String username = "sa";
            String password = "1234";
            
            // Thiết lập kết nối
            connection = DriverManager.getConnection(url, username, password);
            
            // Kiểm tra kết nối đã thành công chưa
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to connect to the PostgreSQL server.");
            }
            
            String sql = "SELECT id, name FROM public.mytable LIMIT 100;";
            preparedStatement = connection.prepareStatement(sql);
            
            // Thực thi truy vấn và lấy kết quả
            resultSet = preparedStatement.executeQuery();
            
            // Thực hiện các thao tác với cơ sở dữ liệu ở đây
            while (resultSet.next()) {
                int column1Value = resultSet.getInt("id");
                String column2Value = resultSet.getString("name");
                
                // Xử lý dữ liệu ở đây
                // Ví dụ: In giá trị của column1 và column2
                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
            }
        } catch (SQLException e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
