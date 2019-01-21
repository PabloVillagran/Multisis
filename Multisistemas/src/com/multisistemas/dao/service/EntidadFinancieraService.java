package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.EntidadFinanciera;

public class EntidadFinancieraService extends DbConnection{

	public List<EntidadFinanciera> select() {
		List<EntidadFinanciera> list = new ArrayList<EntidadFinanciera>();
		sql = "SELECT ID_ENTIDAD_FINANCIERA, NOMBRE, USUARIO_INGRESO, FECHA_INGRESO,"
				+ "USUARIO_MODIFICO, FECHA_MODIFICO, ID_TIPO_ENTIDAD_FINANCIERA "
				+ "FROM CC_ENTIDAD_FINANCIERA";
		try {
			connect();
			stm = prepareStatement(sql);
			rst = executeQuery();
			while(rst.next()) {
				EntidadFinanciera tmp = new EntidadFinanciera();
				tmp.setIdEntidadFinanciera(rst.getLong("ID_ENTIDAD_FINANCIERA"));
				tmp.setNombre(rst.getString("NOMBRE"));
				tmp.setUsuarioIngreso(rst.getString("USUARIO_INGRESO"));
				tmp.setFechaIngreso(rst.getDate("FECHA_INGRESO"));
				tmp.setUsuarioModifico(rst.getString("USUARIO_MODIFICO"));
				tmp.setFechaModifico(rst.getDate("FECHA_MODIFICO"));
				tmp.setIdTipoEntidadFinanciera(rst.getLong("ID_TIPO_ENTIDAD_FINANCIERA"));
				list.add(tmp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return list ;
	}

	
	
}
