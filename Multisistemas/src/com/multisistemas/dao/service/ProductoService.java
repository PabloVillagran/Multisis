package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.Producto;

public class ProductoService extends DbConnection{

	public List<Producto> getByCodigo(String codigo) {
		List<Producto> lista = new ArrayList<Producto>();
		sql = "SELECT ID_PRODUCTO, DESCRIPCION, EXISTENCIA, PRECIO_VENTA"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE ID_PRODUCTO LIKE ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setString(stmPos++, codigo+"%");
			rst = executeQuery();
			while(rst.next()){
				Producto producto = new Producto();
				producto.setIdProducto(rst.getLong("ID_PRODUCTO"));
				producto.setDescripcion(rst.getString("DESCRIPCION"));
				producto.setExistencia(rst.getLong("EXISTENCIA"));
				producto.setPrecioVenta(rst.getDouble("PRECIO_VENTA"));
				lista.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return lista;
	}

	public List<Producto> getByDescripcion(String desc) {
		List<Producto> lista = new ArrayList<Producto>();
		sql = "SELECT ID_PRODUCTO, DESCRIPCION, EXISTENCIA, PRECIO_VENTA"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE DESCRIPCION LIKE ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setString(stmPos++, desc+"%");
			rst = executeQuery();
			while(rst.next()){
				Producto producto = new Producto();
				producto.setIdProducto(rst.getLong("ID_PRODUCTO"));
				producto.setDescripcion(rst.getString("DESCRIPCION"));
				producto.setExistencia(rst.getLong("EXISTENCIA"));
				producto.setPrecioVenta(rst.getDouble("PRECIO_VENTA"));
				lista.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return lista;
	}

	public Producto findById(Long value) {
		Producto producto = null;
		sql = "SELECT ID_PRODUCTO, DESCRIPCION, EXISTENCIA, PRECIO_VENTA"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE ID_PRODUCTO = ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setLong(stmPos++, value);
			rst = executeQuery();
			while(rst.next()){
				producto = new Producto();
				producto.setIdProducto(rst.getLong("ID_PRODUCTO"));
				producto.setDescripcion(rst.getString("DESCRIPCION"));
				producto.setExistencia(rst.getLong("EXISTENCIA"));
				producto.setPrecioVenta(rst.getDouble("PRECIO_VENTA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return producto;
	}

	public List<String> getCodigosLike(String codigo) {
		List<String> lista = new ArrayList<String>();
		sql = "SELECT ID_PRODUCTO"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE ID_PRODUCTO LIKE ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setString(stmPos++, codigo+"%");
			rst = executeQuery();
			while(rst.next()){
				lista.add(String.valueOf(rst.getLong("ID_PRODUCTO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return lista;
	}

	public List<String> getDescripcionLike(String desc) {
		List<String> lista = new ArrayList<String>();
		sql = "SELECT DESCRIPCION"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE UPPER(DESCRIPCION) LIKE ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setString(stmPos++, desc.toUpperCase()+"%");
			rst = executeQuery();
			while(rst.next()){
				lista.add(rst.getString("DESCRIPCION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return lista;
	}

	public Producto findByDesc(String value) {
		Producto producto = null;
		sql = "SELECT ID_PRODUCTO, DESCRIPCION, EXISTENCIA, PRECIO_VENTA"
			+ " FROM DUMMY_PRODUCTO "
			+ " WHERE DESCRIPCION = ?";
		try {
			this.connect();
			stm = prepareStatement(sql);
			stm.setString(stmPos++, value);
			rst = executeQuery();
			while(rst.next()){
				producto = new Producto();
				producto.setIdProducto(rst.getLong("ID_PRODUCTO"));
				producto.setDescripcion(rst.getString("DESCRIPCION"));
				producto.setExistencia(rst.getLong("EXISTENCIA"));
				producto.setPrecioVenta(rst.getDouble("PRECIO_VENTA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeConnection();
		}
		return producto;
	}

}
