package com.melquias.lojaapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.melquias.lojaapi.domain.Categoria;
import com.melquias.lojaapi.domain.Cidade;
import com.melquias.lojaapi.domain.Cliente;
import com.melquias.lojaapi.domain.Endereco;
import com.melquias.lojaapi.domain.Estado;
import com.melquias.lojaapi.domain.Produto;
import com.melquias.lojaapi.domain.enums.TipoCliente;
import com.melquias.lojaapi.repositories.CategoriaRepository;
import com.melquias.lojaapi.repositories.CidadeRepository;
import com.melquias.lojaapi.repositories.ClienteRepository;
import com.melquias.lojaapi.repositories.EnderecoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
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
		
		
		Cliente clit1= new Cliente(null, "Melquias Rosa Ribeiro", "mequias10.mr@mail.com", "91290561661", TipoCliente.PESSOAFISICA);
		clit1.getTelefones().addAll(Arrays.asList("98988888881","98999999991"));		
		Endereco end1=new Endereco(null, "estrada velha da raposa", "8", "condominio moradas da ilha ", "turu", "65058581", clit1, cid1);
		clit1.getEnderecos().addAll(Arrays.asList( end1));
		
		Cliente clit2= new Cliente(null, "Antornio Carlos Ribeiro	", "mequias10.mr@mail.com", "91290561662", TipoCliente.PESSOAFISICA);
		clit2.getTelefones().addAll(Arrays.asList("98988888882","98999999992"));
		Endereco end2=new Endereco(null, "estrada velha da raposa", "9", "condominio moradas da ilha ", "turu", "65058581", clit2, cid2);
		clit2.getEnderecos().addAll(Arrays.asList( end2));

		
		Cliente clit3= new Cliente(null, "Miqueias Rosa Ribeiro", "mequias10.mr@mail.com", "91290561663", TipoCliente.PESSOAFISICA);
		clit3.getTelefones().addAll(Arrays.asList("98988888883","98999999993"));
		Endereco end3=new Endereco(null, "estrada velha da raposa", "10", "condominio moradas da ilha ", "turu", "65058581", clit3, cid3);
		clit2.getEnderecos().addAll(Arrays.asList( end3));

		
		clienteRepository.saveAll(Arrays.asList(clit1,clit2,clit3));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
	}

	
}
