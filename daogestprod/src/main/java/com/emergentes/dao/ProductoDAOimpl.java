package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    /**
     *
     * @param producto
     * @throws Exception
     */
    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (descripcion, cantidad, precio, categoria) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion = ?, cantidad = ?, precio = ?, categoria = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto prod = new Producto();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            
            if (rs.next()) {
                prod.setId(rs.getInt("id"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            
            this.conectar();

            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();

                prod.setId(rs.getInt("id"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setCategoria(rs.getString("categoria"));

                lista.add(prod);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
