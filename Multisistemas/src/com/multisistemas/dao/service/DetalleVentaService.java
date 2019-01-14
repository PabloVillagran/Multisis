package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.DetalleVenta;
import com.multisistemas.dao.entity.Venta;

public class DetalleVentaService extends DbConnection{

	public void insertDetalle(DetalleVenta detalleVenta) {
		sql = "insert into FAC_DETALLE_VENTA (VALOR,CANTIDAD,ID_DETALLE_VENTA,ID_PRODUCTO,"
				+ "ID_VENTAS,PRECIO_TOTAL,PRECIO_UNITARIO,USUARIO_INGRESO,FECHA_INGRESO,"
				+ "USUARIO_MODIFICO,FECHA_MODIFICO) "
				+ "values (?,?,SQ_DETALLE_VENTA.NEXTVAL,?,?,?,?,?,?,?,?)";
		try {
			connect();
			stm = prepareStatement(sql);
			stm.setObject(p++, detalleVenta.getValor());
			stm.setObject(p++, detalleVenta.getCantidad());
			stm.setObject(p++, detalleVenta.getIdProducto());
			stm.setObject(p++, detalleVenta.getIdVentas());
			stm.setObject(p++, detalleVenta.getPrecioTotal());
			stm.setObject(p++, detalleVenta.getPrecioUnitario());
			stm.setObject(p++, detalleVenta.getUsuarioIngreso());
			stm.setObject(p++, detalleVenta.getFechaIngreso());
			stm.setObject(p++, detalleVenta.getUsuarioModifico());
			stm.setObject(p++, detalleVenta.getFechaModifico());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

	public void insertDetalle(List<DetalleVenta> detalleFactura, Venta venta) {
		for(DetalleVenta detalle : detalleFactura) {
			if(detalle.getIdProducto()>0) {
				detalle.setIdVentas(venta.getIdVenta());
				detalle.setPrecioTotal(venta.getValorTotal());
				insertDetalle(detalle);				
			}
		}
	}
	
}
