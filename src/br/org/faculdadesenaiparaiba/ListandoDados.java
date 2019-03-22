	// pacote onde a classe se encontra
	package br.org.faculdadesenaiparaiba;

	import java.io.InputStream;
	// bibliotecas da Linguagem java
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	// biblioteca de conexão com banco MySQL
	import com.mysql.jdbc.PreparedStatement;

	// importanto outras classes
	import br.org.faculdadesenaiparaiba.AlunoDTO;
	import br.org.faculdadesenaiparaiba.BdConnect;

public class ListandoDados {

		// método -- listarTodos -- do tipo array
		public List<AlunoDTO> listarTodos(){
			List<AlunoDTO> listaAlunos = new ArrayList<AlunoDTO>();
			
			// try é o lançamento de uma exceção
			try {
				// criando objeto conncection
				Connection connection = BdConnect.getInstance().getConnection();
				
				// criando atributo -- sql --
				String sql = "Select * from aluno";
				
				// criando objeto -- statement --
				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
				
				// criando bojeto --resultset--
				ResultSet resultset = statement.executeQuery();
				
				// laço que procura resultados na consulta SQL
				while(resultset.next()) {
					AlunoDTO alunoDTO = new AlunoDTO();
					alunoDTO.setId(resultset.getLong("id"));
					alunoDTO.setNome(resultset.getString("nome"));
					alunoDTO.setEmail(resultset.getString("email"));
					alunoDTO.setCpf(resultset.getString("cpf"));
					
					// adicionando os dados da consulta no array -- listaAlunos
					listaAlunos.add(alunoDTO);
				}
				
				// encerrando conexão com banco de dados
				connection.close();
				
				// lançamento das exceções
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//retorno do método -- listarTodos --
			return listaAlunos;
			
		}
		// método main responsável por executar o programa
		public static void main (String[] args) {
			
			// criando os objetos
			AlunoDTO alunoDTO = new AlunoDTO();
			NovoDAO alunoDAO = new NovoDAO();
			
			// TODO Auto-generated method stub
			InputStream entrada = System.in;
			Scanner scanner = new Scanner(entrada);
			
			System.out.println("Digite seu nome: ");
			scanner.hasNextLine();
			alunoDTO.setNome(scanner.nextLine());
			
			System.out.println("Digite seu CPF: ");
			scanner.hasNextLine();
			alunoDTO.setCpf(scanner.nextLine());
			
			System.out.println("Digite seu email: ");
			scanner.hasNextLine();
			alunoDTO.setEmail(scanner.nextLine());
			
			System.out.println("Digite uma senha: ");
			scanner.hasNextLine();
			alunoDTO.setSenha(scanner.nextLine());
			
			// Inserindo dados através do objeto -alunoDAO- pelo método -inserir-
			alunoDAO.inserir(alunoDTO);
			
			// atribuindo ao objeto -listaAlunos- o valor resultante da consulta
			List<AlunoDTO> listaAlunos = new ArrayList<>();
			listaAlunos = alunoDAO.listarTodos();
			
			// laço de repetição para impprimir resultados
			for(int i = 0; i<listaAlunos.size(); i++) {
				// comando de impressão no console dos resultados
				System.out.println(listaAlunos.get(i));
			}
		}
}