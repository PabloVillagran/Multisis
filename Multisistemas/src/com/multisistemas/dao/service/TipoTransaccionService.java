package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.TipoTransaccion;

public class TipoTransaccionService extends DbConnection{

	public List<TipoTransaccion> selectTipos() {
		List<TipoTransaccion> resultado = new ArrayList<TipoTransaccion>();
		sql = "SELECT ID_TIPO_TRANSACCION, DESCRIPCION, FORMULA, USUARIO_INGRESO, FECHA_INGRESO,"
			+ "USUARIO_MODIFICO, FECHA_MODIFICO FROM INV_TIPO_TRANSACCION";
		try {
			connect();
			stm = con.prepareStatement(sql);
			rst = stm.executeQuery();
			while(rst.next()) {
				TipoTransaccion tmp = new TipoTransaccion();
				tmp.setIdTipoTransaccion(rst.getLong("ID_TIPO_TRANSACCION"));
				tmp.setDescripcion(rst.getString("DESCRIPCION"));
				tmp.setUsuarioIngreso(rst.getString("USUARIO_INGRESO"));
				tmp.setUsuarioModifico(rst.getString("USUARIO_MODIFICO"));
				resultado.add(tmp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return resultado;
	}

}
