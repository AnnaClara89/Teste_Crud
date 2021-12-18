package   com.senai.anna ;

import   java.util.Arrays ;

import   org.springframework.beans.factory.annotation.Autowired ;
import   org.springframework.boot.CommandLineRunner ;
import   org.springframework.boot.SpringApplication ;
import   org.springframework.boot.autoconfigure.SpringBootApplication ;

import   com.senai.anna.domain.Cidade ;
import   com.senai.anna.domain.Cliente ;
import   com.senai.anna.domain.Endereco ;
import   com.senai.anna.domain.Estado ;
import   com.senai.anna.domain.enums.TipoCliente ;
import   com.senai.anna.repositories.CidadeRepository ;
import   com.senai.anna.repositories.ClienteRepository ;
import   com.senai.anna.repositories.EstadoRepository ;
@SpringBootApplication
public class AnnaAplication implements CommandLineRunner { 

	@Autowired
    private EstadoRepository estadoRepository; 
	@Autowired 
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	@Autowired
	private com.senai3.julia.repositories.EnderecoRepository EnderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	public static void main(String[] args) {
		SpringApplication.run(JuliaApplication.class, args); 
	} 
	@Override
	public void run(String... args ) throws Exception {
		Estado est1 = new Estado(null ,"São Paulo", null); 
		Estado est2 = new Estado(null ,"Minas Gerais", null);
		estadoRepository.saveAll(Arrays.asList(est1, est2)); 
		
		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "Uberlândia", est2);
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
		
	
	Cliente cli = new Cliente(null, " Anna Clara Ribeiro " , " 85694123789 " , " naclararibs89@gmail.com " , TipoCliente  .  PESSOAFISICA );
	cli.getTelefones().addAll(Arrays.asList( " 987123544 " , " 96547710 " ));
	clienteRepository.saveAll(Arrays.asList(cli));
	
	Endereco e1 = new Endereco(null, " Rua Da Amora " , " 12 " , "  " , " São Sebastião " , " 63918754 " , cli, c1);
	
	cli.getEnderecos().addAll(Arrays.asList(e1));
	
	EnderecoRepository.saveAll(Arrays.asList(e1));
	}
	public ClienteRepository getClienteRepository() {
		return ClienteRepository;
	}
	public void setClienteRepository(ClienteRepository clienteRepository) {
		ClienteRepository = clienteRepository;
	}
	}