package com.multisistemas.dao.service;

import java.sql.SQLException;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.Cliente;

public class ClienteService extends DbConnection{

	public Cliente buscarCliente(Cliente cliente) {
		sql = "SELECT ID_CLIENTE, NOMBRE, APELLIDO, NIT FROM CC_CLIENTE WHERE TRIM(NIT) = ?";
		try {
			connect();
			stm = prepareStatement(sql);
			stm.setString(p, cliente.getNit().trim());
			rst = executeQuery();
			while(rst.next()) {
				cliente.setNombre(rst.getString("NOMBRE").trim());
				cliente.setApellido(rst.getString("APELLIDO").trim());
				cliente.setNit(rst.getString("NIT").trim());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return cliente;
	}

	public void insertarCliente(Cliente datosCliente) {
		sql = "INSERT INTO CC_CLIENTE(ID_CLIENTE, NOMBRE, APELLIDO, NIT) "
				+ "VALUES(SQ_CLIENTE.NEXTVAL,?,?,?)";
		try {
			connect();
			stm = prepareStatement(sql);
			stm.setObject(p++, datosCliente.getNombre());
			stm.setObject(p++, datosCliente.getApellido());
			stm.setObject(p++, datosCliente.getNit());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
}
