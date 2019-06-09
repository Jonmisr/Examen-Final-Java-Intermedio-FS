package com.SofwareVision.supermercado.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SofwareVision.supermercado.Models.Stock;
import com.SofwareVision.supermercado.Repository.CompraRepository;

@RestController
@RequestMapping("/api/super")
public class CompraController {
	
	@Autowired
	private CompraRepository unaCompra;

	@GetMapping
	public List<Stock> lista() {

		return unaCompra.findAll();
	}

	@PostMapping("/agregarCompra")
	@ResponseStatus(HttpStatus.OK)
	public Stock create(@RequestBody Stock laCompra) {
		Date fecha = new Date();
		laCompra.setFechaDelComprobante(fecha);
		return unaCompra.save(laCompra);
	}

	@GetMapping("/buscarCompra/{idstock}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Optional<Stock>> get(@PathVariable ("idstock") Long idstock) {	
		
		if(!(unaCompra.existsById(idstock))) { System.err.println("No Se Encontro El Id: " + idstock);
											   return ResponseEntity.notFound().build();}
		
		Optional<Stock> compraExistente = unaCompra.findById(idstock);
		return ResponseEntity.ok().body(compraExistente); 
}
	
	@DeleteMapping("/borrarCompra/{idstock}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getAndDelete(@PathVariable ("idstock") Long idstock) {
		
		if(!(unaCompra.existsById(idstock))) { System.out.println("No Se Encontro La Compra = " + idstock + " A Eliminar");
											   return ResponseEntity.notFound().build();
				 }
		
		unaCompra.deleteById(idstock);
		String respuesta = "La Compra = : " + idstock + " Fue Eliminada"; 
		return ResponseEntity.ok(respuesta);
}
	
	@PutMapping("/actualizarCompra/{idstock}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Stock> getAndPut(@PathVariable ("idstock") Long idstock, @Valid @RequestBody Stock otraCompra) {
		
		if(!(unaCompra.existsById(idstock))) {  System.err.println("No Se Encontro La Compra = " + idstock + " A Actualizar");
												return ResponseEntity.notFound().build(); }
		
		Stock modeloCompra = unaCompra.getOne(idstock);
		Date fecha = new Date();
		modeloCompra.setFechaDelComprobante(fecha);
		modeloCompra.setNumeroDelComprobante(otraCompra.getNumeroDelComprobante());
		modeloCompra.setTotalEnPesosDeLaCompra(otraCompra.getTotalEnPesosDeLaCompra());
		final Stock compraActualizada = unaCompra.save(modeloCompra);
		return ResponseEntity.ok(compraActualizada);
		
	}
}
