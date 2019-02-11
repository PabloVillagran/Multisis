package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.sql.Types;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.Transaccion;

public class TransaccionService extends DbConnection {

	public Long insertTransaccion(Transaccion datosGenerales) {
		Long id = null;
		sql = "{call "
				+ "insert into INV_TRANSACCION (SERIE,NUMERO,FECHA_TRANSACCION,"
				+ "ID_TRANSACCION,ID_TIPO_TRANSACCION,USUARIO_INGRESO,"
				+ "FECHA_INGRESO,USUARIO_MODIFICO,FECHA_MODIFICO,ID_EMPLEADO,"
				+ "ID_ORGANIZACIONAL) "
				+ "values (?,?,SYSDATE,SQ_TRANSACCION.NEXTVAL,?,?,?,?,?,?,?)"
			+ "returning ID_TRANSACCION INTO ?}";
		try {
			connect();
			ctm = prepareCall(sql);
			ctm.setObject(p++, datosGenerales.getSerie());
			ctm.setObject(p++, datosGenerales.getNumero());
			ctm.setObject(p++, datosGenerales.getIdTipoTransaccion());
			ctm.setObject(p++, datosGenerales.getUsuarioIngreso());
			ctm.setObject(p++, datosGenerales.getFechaIngreso());
			ctm.setObject(p++, datosGenerales.getUsuarioModifico());
			ctm.setObject(p++, datosGenerales.getFechaModifico());
			ctm.setObject(p++, datosGenerales.getIdEmpleado());
			ctm.setObject(p++, datosGenerales.getIdOrganizacional());
			ctm.registerOutParameter(p++, Types.NUMERIC);
			ctm.executeUpdate();
			id = ctm.getLong(p-1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return id;
	}

}
