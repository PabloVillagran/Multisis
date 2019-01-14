package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.TipoPago;

public class TipoPagoService extends DbConnection{

	public List<TipoPago> select(){
		List<TipoPago> lista = new ArrayList<TipoPago>();
		sql = "SELECT ID_TIPOS_DE_PAGO, DESCRIPCION, USUARIO_INGRESO, USUARIO_MODIFICO, "
				+ "FECHA_INGRESO, FECHA_MODIFICO "
				+ "FROM FAC_TIPOS_DE_PAGO";
		try {
			connect();
			stm = con.prepareStatement(sql);
			rst = stm.executeQuery();
			while(rst.next()) {
				TipoPago tmp = new TipoPago();
				tmp.setIdTipoDePago(rst.getLong("ID_TIPOS_DE_PAGO"));
				tmp.setDescripcion(rst.getString("DESCRIPCION"));
				tmp.setUsuarioIngreso(rst.getString("USUARIO_INGRESO"));
				tmp.setFechaIngreso(rst.getDate("FECHA_INGRESO"));
				tmp.setUsuarioModifico(rst.getString("USUARIO_MODIFICO"));
				tmp.setFechaModifico(rst.getDate("FECHA_MODIFICO"));
				lista.add(tmp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return lista;
	}
	
}
