package com.multisistemas.dao.service;

import java.sql.SQLException;
import java.util.List;

import com.multisistemas.dao.DbConnection;
import com.multisistemas.dao.entity.DetallePagosVentas;
import com.multisistemas.dao.entity.Venta;

public class DetallePagosVentaService extends DbConnection{
	
	public void insertDetalle(DetallePagosVentas det) {
		sql = "insert into FAC_DETALLE_PAGOS_VENTAS (ID_DETALLE_PAGOS_VENTAS,SERIE,NUMERO,VALOR,"
				+ "USUARIO_INGRESO,FECHA_INGRESO,USUARIO_MODIFICO,FECHA_MODIFICO,ID_VENTAS,"
				+ "FECHA_AUTORIZACION,NUMERO_AUTORIZACION,ID_ENTIDAD_FINANCIERA,ID_TIPOS_DE_PAGO) "
				+ "values (SQ_DET_PAGOS_VENTA.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connect();
			stm = prepareStatement(sql);
			stm.setObject(p++, det.getSerie());
			stm.setObject(p++, det.getNumero());
			stm.setObject(p++, det.getValor());
			stm.setObject(p++, det.getUsuarioIngreso());
			stm.setObject(p++, det.getFechaIngreso());
			stm.setObject(p++, det.getUsuarioModifico());
			stm.setObject(p++, det.getFechaModifico());
			stm.setObject(p++, det.getIdVentas());
			stm.setObject(p++, det.getFechaAutorizacion());
			stm.setObject(p++, det.getNumeroAutorizacion());
			stm.setObject(p++, det.getIdEntidadFinanciera());
			stm.setObject(p++, det.getIdTiposDePago());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

	public void insertDetalle(List<DetallePagosVentas> detalleFactura, Venta venta) {
		for(DetallePagosVentas detalle : detalleFactura) {
			if(detalle.getIdTiposDePago()>0) {
				detalle.setIdVentas(venta.getIdVenta());
				insertDetalle(detalle);				
			}
		}
	}
	
}
