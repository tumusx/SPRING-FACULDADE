package br.edu.ifgoias.academico.services;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno findBAluno(Integer id) {
		return alunoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Aluno insertAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public void deletAluno(Integer idAluno) {
		alunoRepository.deleteById(idAluno);
	}
	
	/*@params
	 * caso queira deletar todos os alunos
	 **/
	public void deletAluno() {
		alunoRepository.deleteAll();
	}
	
	public Aluno updateAluno(Integer idAlunoInteger, Aluno aluno) {
		return alunoRepository.findById(idAlunoInteger).map(alunoLam -> {
			alunoLam.setNome(aluno.getNome());
			return alunoRepository.save(alunoLam);

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
