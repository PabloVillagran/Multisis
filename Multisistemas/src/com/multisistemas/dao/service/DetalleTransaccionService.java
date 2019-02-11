package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.DetalleTransaccion;
import com.multisistemas.dao.entity.Transaccion;

public class DetalleTransaccionService extends DbConnection{

	public void insert(DetalleTransaccion det) {
		sql = "insert into INV_DETALLE_TRANSACCION (ID_DETALLE_TRANSACCION,VALOR,"
				+ "ID_TRANSACCION,ID_PRODUCTO,CANTIDAD,USUARIO_INGRESO,FECHA_INGRESO,"
				+ "USUARIO_MODIFICO,FECHA_MODIFICO) "
				+ "values (SQ_DETALLE_TRANSACCION.NEXTVAL,?,?,?,?,?,?,?,?)";
		try {
			connect();
			stm = con.prepareStatement(sql);
			stm.setObject(p++, det.getValor());
			stm.setObject(p++, det.getIdTransaccion());
			stm.setObject(p++, det.getIdProducto());
			stm.setObject(p++, det.getCantidad());
			stm.setObject(p++, det.getUsuarioIngreso());
			stm.setObject(p++, det.getFechaIngreso());
			stm.setObject(p++, det.getUsuarioModifico());
			stm.setObject(p++, det.getFechaModifico());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public void insert(List<DetalleTransaccion> detalleTransaccion, Transaccion datosGenerales) {
		for(DetalleTransaccion det : detalleTransaccion) {
			det.setIdTransaccion(datosGenerales.getIdTransaccion());
			insert(det);
		}
	}

}
