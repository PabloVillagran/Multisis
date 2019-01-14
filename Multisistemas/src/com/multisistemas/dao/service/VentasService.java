package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.sql.Types;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.Venta;

public class VentasService extends DbConnection{

	public long insertVenta(Venta venta) {
		long id = -1;
		sql = "{call "
				+ "insert into FAC_VENTAS (ID_VENTAS,DIRECCION_CLIENTE,SERIE,NUMERO,FECHA,"
				+ "TOTAL,VALOR_TOTAL,NIT,NOMBRE_CLIENTE,SUBTOTAL,DESCUENTO,IVA,ID_CLIENTE,"
				+ "ID_EMPLEADO,ID_TIPO_VENTA,ID_HISTORICO_IMPUESTO,ID_ORGANIZACION,"
				+ "ID_TIPO_TRANSACCION,OBSERVACION,ID_ESTATUS_VENTAS,USUARIO_INGRESO,"
				+ "FECHA_INGRESO,USUARIO_MODIFICO,FECHA_MODIFICO) "
				+ "values (SQ_FAC_VENTAS.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
			+ "returning ID_VENTAS INTO ?}";
		try {
			connect();
			ctm = prepareCall(sql);
			ctm.setObject(p++, venta.getDireccionCliente());
			ctm.setObject(p++, venta.getSerie());
			ctm.setObject(p++, venta.getNumero());
			ctm.setObject(p++, venta.getFecha());
			ctm.setObject(p++, venta.getTotal());
			ctm.setObject(p++, venta.getValorTotal());
			ctm.setObject(p++, venta.getNit());
			ctm.setObject(p++, venta.getNombreCliente());
			ctm.setObject(p++, venta.getSubtotal());
			ctm.setObject(p++, venta.getDescuento());
			ctm.setObject(p++, venta.getIva());
			ctm.setObject(p++, venta.getIdCliente());
			ctm.setObject(p++, venta.getIdEmpleado());
			ctm.setObject(p++, venta.getIdTipoVenta());
			ctm.setObject(p++, venta.getIdHistoricoImpuesto());
			ctm.setObject(p++, venta.getIdOrganizacion());
			ctm.setObject(p++, venta.getIdTipoTransaccion());
			ctm.setObject(p++, venta.getObservacion());
			ctm.setObject(p++, venta.getIdEstatusVentas());
			ctm.setObject(p++, venta.getUsuarioIngreso());
			ctm.setObject(p++, venta.getFechaIngreso());
			ctm.setObject(p++, venta.getUsuarioModifico());
			ctm.setObject(p++, venta.getFechaModifico());
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
