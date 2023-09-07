import java.sql.*;
import java.util.Scanner;

public class Registros {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****BIENVENIDOS*****");

        System.out.println("¿Deseas registar, editar o cunsultar un poducto?: / ¿Deseas registar o eliminar un usuario?: ");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("registrar producto")) {
            //

            System.out.print("Ingrese el Id Producto: ");
            String IdProducto = scanner.nextLine();

            System.out.print("Ingrese el nombre del producto: ");
            String Nombre = scanner.nextLine();

            System.out.print("Ingrese el tipo producto: ");
            String Tipo = scanner.nextLine();

            System.out.print("Ingrese la cantidad del producto: ");
            String Cantidad = scanner.nextLine();

            System.out.print("Ingrese el valor del producto: ");
            String Valor = scanner.nextLine();

            Insert(IdProducto, Nombre, Tipo, Cantidad, Valor); //
            if (IdProducto.equals("") || Nombre.equals("") || Tipo.equals("") || Cantidad.equals("") || Valor.equals("")) {
                System.out.println("No se admiten datos vacios.");
            }
        }
        if (respuesta.equals("editar producto")){
            System.out.print("Ingrese el Id Producto: ");
            String IdProducto = scanner.nextLine();

            System.out.print("Actualice el nombre del producto: ");
            String Nombre = scanner.nextLine();

            System.out.print("Actualice el tipo producto: ");
            String Tipo = scanner.nextLine();

            System.out.print("Actualice la cantidad del producto: ");
            String Cantidad = scanner.nextLine();

            System.out.print("Actualice el valor del producto: ");
            String Valor = scanner.nextLine();

            Editar(IdProducto, Nombre, Tipo, Cantidad, Valor);

        }
        if (respuesta.equals("consultar producto")){
            
            System.out.print("Ingrese el Id Producto: ");
            String IdProducto = scanner.nextLine();

            Select_One(IdProducto);
        }
                    if (respuesta.equals("registrar usuario")) {

                        System.out.println("Ingrese el nombre: ");
                        String nombreusuario = scanner.nextLine();

                        System.out.println("Ingrese documento de identidad: ");
                        String documento = scanner.nextLine();

                        System.out.print("Ingrese su usuario: ");
                        String usuario = scanner.nextLine();

                        System.out.print("Ingrese su contrase\u00f1a: ");
                        String pass = scanner.nextLine();

                        System.out.println("Ingrese tipo de usuario: ");
                        String tipo = scanner.nextLine();

                        Insert_usuario(nombreusuario, documento, usuario, pass, tipo); //
                    }
                    if (respuesta.equals("eliminar usuario")){
                        System.out.println("Que nombre de usuario deseas eliminar? ");
                        String nombreusuario = scanner.nextLine();
                        Eliminar(nombreusuario);
                    }
                }

    private static void Eliminar(String nombreusuario) throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/registros";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        String sentenciaSQL = "DELETE FROM registrousuario WHERE nombreusuario = ?";
        PreparedStatement prepareStatement = connection2.prepareStatement(sentenciaSQL);
        prepareStatement.setString(1, nombreusuario);
        prepareStatement.executeUpdate();

        System.out.println("Usuario eliminado correctamente");
    }

    private static void Select_One(String idProducto) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registros";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM registro WHERE IdProducto = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1, idProducto); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet.next()) {
            String IdProducto = resultSet.getString("IdProducto");
            String Nombre = resultSet.getString("Nombre");
            String Tipo = resultSet.getString("Tipo");
            String Cantidad = resultSet.getString("Cantidad");
            String Valor = resultSet.getString("Valor");

            System.out.println("Estes es el Id del producto a consultar: " + IdProducto + "Con nombre " + Nombre);

        } else {
            System.out.println("No se encontró un registro con el codigo especificado.");
        }

        // Cerrar recursos
        resultSet.close();
        statement.close();
        connection.close();

    }

    private static void Editar(String IdProducto, String nombre, String tipo, String cantidad, String valor) throws ClassNotFoundException, SQLException {
        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/registros";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consulta = "UPDATE registro SET nombre = ?, tipo = ?, cantidad = ?, valor = ? WHERE IdProducto = ?";
        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, tipo);
        preparedStatement.setString(3, cantidad);
        preparedStatement.setString(4, valor);
        preparedStatement.setString(5, IdProducto);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Producto actualizado exitosamente");
        } else {
            System.out.println("No se encontró el registro para actualizar");
        }

        preparedStatement.close();
        connection2.close();
    }

    private static void Insert_usuario(String nombreusuario, String documento, String usuario, String pass, String tipo) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registros";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM registrousuario");


            // Sentencia INSERT
            String sql = "INSERT INTO registrousuario (nombreusuario, documento, usuario, pass, tipo) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreusuario);
            preparedStatement.setString(2, documento);
            preparedStatement.setString(3, usuario);
            preparedStatement.setString(4, pass);
            preparedStatement.setString(5, tipo);

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("usuario agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el usuario.");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void Insert(String IdProducto, String Nombre, String Tipo, String Cantidad, String Valor) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/registros";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM registro");


            // Sentencia INSERT
            String sql = "INSERT INTO registro (IdProducto, Nombre, Tipo, Cantidad, valor) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, IdProducto);
            preparedStatement.setString(2, Nombre);
            preparedStatement.setString(3, Tipo);
            preparedStatement.setString(4, Cantidad);
            preparedStatement.setString(5, Valor);

            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("producto agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el producto.");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    }


