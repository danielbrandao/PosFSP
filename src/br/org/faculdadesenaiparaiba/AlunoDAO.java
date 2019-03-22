package br.org.faculdadesenaiparaiba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.org.faculdadesenaiparaiba.AlunoDTO;
import br.org.faculdadesenaiparaiba.BdConnect;

public class AlunoDAO {
	
	public void inserir(AlunoDTO alunoDTO) throws SQLException {
		// nada por enquanto
	}
	public List<AlunoDTO> listarTodos(){
		List<AlunoDTO> listaAlunos = new ArrayList<AlunoDTO>();
		try {
			Connection connection = BdConnect.getInstance().getConnection();
			
			String sql = "Select * from pessoas";
			
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				AlunoDTO alunoDTO = new AlunoDTO();
				alunoDTO.setId(resultset.getLong("id"));
				alunoDTO.setNome(resultset.getString("nome"));
				
				listaAlunos.add(alunoDTO);
			}
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaAlunos;
		
	}
	public static void main (String[] args) {
		AlunoDTO alunoDTO = new AlunoDTO();
		AlunoDAO alunoDAO = new AlunoDAO();
		
		List<AlunoDTO> listaAlunos = new ArrayList<>();
		
		listaAlunos = alunoDAO.listarTodos();
		
		for(int i = 0; i<listaAlunos.size(); i++) {
			System.out.println(listaAlunos.get(i));
		}
		
	}

}
