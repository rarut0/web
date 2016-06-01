package dominioBD;

import BasedeDatos.ConnectionPool;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Roberto
 */
public class ProductoDB {

    public static int insertar(Producto productoNuevo) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "INSERT INTO PRODUCTOS (ID, NOMBRE, DESCRIPCION, PRECIO, IMAGEN, VALORACION, ANIMAL, CATEGORIA) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productoNuevo.getNombre());
            ps.setString(2, productoNuevo.getDescripcion());
            ps.setDouble(3, productoNuevo.getPrecio());
            ps.setString(4, productoNuevo.getImagen());
            ps.setInt(5, productoNuevo.getValoracion());
            ps.setString(6, productoNuevo.getAnimal());
            ps.setString(7, productoNuevo.getCategoria());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Producto getProductoPorNombre(String nombreProducto) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        Producto producto = null;
        String query = "SELECT * FROM PRODUCTOS WHERE NOMBRE = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getInt("id"),
                        rs.getString("nomre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getString("imagen"),
                        rs.getInt("valoracion"),
                        rs.getString("animal"),
                        rs.getString("categoria"));
            }
            ps.close();
            pool.freeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return producto;
    }

    public static List<Producto> buscarProducto(String s) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        List<Producto> resultado = new ArrayList<Producto>();
        String query = "SELECT DISTINCT a.* FROM PRODUCTO a WHERE ((a.NOMBRE = ?) OR (a.ANIMAL = ?) OR (a.CATEGORIA = ?))";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,s);
            ps.setString(2,s);
            ps.setString(3,s);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                Producto producto = new Producto(res.getInt("id"),
                        res.getString("nombre"),
                        res.getString("descripcion"),
                        res.getDouble("precio"),
                        res.getString("imagen"),
                        res.getInt("valoracion"),
                        res.getString("animal"),
                        res.getString("categoria"));
                resultado.add(producto);
            }
            ps.close();
            pool.freeConnection(connection);
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return resultado;
        }
    }
    
    public static ArrayList<Producto> buscarProductosPorValoracion(int i) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        String query = "SELECT * FROM PRODUCTOS WHERE VALORACION = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,i);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                Producto producto = new Producto(res.getInt("id"),
                        res.getString("nombre"),
                        res.getString("descripcion"),
                        res.getDouble("precio"),
                        res.getString("imagen"),
                        res.getInt("valoracion"),
                        res.getString("animal"),
                        res.getString("categoria"));
                resultado.add(producto);
            }
            ps.close();
            pool.freeConnection(connection);
            return resultado;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return resultado;
        }
    }
    
    public static Diario getDiarioPorId(int idDiario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        Diario diario = null;
        String query = "SELECT * FROM diario WHERE id= ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idDiario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                diario = new Diario(rs.getInt("id"),
                        rs.getString("nombreUsuario"),
                        rs.getString("titulo"),
                        rs.getDate("fechaInicio"),
                        rs.getDate("fechaFin"),
                        rs.getString("descripcion"),
                        rs.getBoolean("enCurso"));
            }
            ps.close();
            pool.freeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return diario;
    }

    public static int modificarDiario(int id, String tituloViaje, Date fechaInicio, Date fechaFin, String descripcion) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query
                = "UPDATE diario SET titulo = ? , fechaInicio = ? , fechaFin = ? "
                + ", descripcion = ? WHERE id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tituloViaje);
            ps.setDate(2, fechaInicio);
            ps.setDate(3, fechaFin);
            ps.setString(4, descripcion);
            ps.setInt(5, id);
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getTituloDelDiario(int idDiario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String titulo = null;
        String query = "SELECT * FROM diario WHERE id= ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idDiario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                titulo = rs.getString("titulo");
            }
            ps.close();
            pool.freeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return titulo;
    }
}
