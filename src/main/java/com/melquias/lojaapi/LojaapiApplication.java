package com.melquias.lojaapi;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melquias.lojaapi.domain.Categoria;
import com.melquias.lojaapi.domain.Cidade;
import com.melquias.lojaapi.domain.Estado;
import com.melquias.lojaapi.domain.Produto;
import com.melquias.lojaapi.repositories.CategoriaRepository;
import com.melquias.lojaapi.repositories.CidadeRepository;
import com.melquias.lojaapi.repositories.EstadoRepository;
import com.melquias.lojaapi.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaapiApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LojaapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");	
		Categoria cat2 = new Categoria(null,"Escritório");		
		
		Produto p1 = new Produto(null,"computador",2000.00);	
		Produto p2 = new Produto(null,"impressora",1000.00);		
		Produto p3 = new Produto(null,"mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 =new Cidade(null,"São Paulo",est2);
		Cidade cid2 =new Cidade(null,"Uberlandia",est1);
		Cidade cid3 =new Cidade(null,"Campinas",est2);
			
		est1.getCidades().addAll(Arrays.asList(cid2));
		est2.getCidades().addAll(Arrays.asList(cid1,cid3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

	}

	
}
