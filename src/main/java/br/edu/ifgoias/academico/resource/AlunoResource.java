package br.edu.ifgoias.academico.resource;

import java.util.List;

import org.hibernate.annotations.OnDelete;
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

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno> > listarAlunos(){
		
	List<Aluno> listaAluno = alunoService.listarAlunos();
	return ResponseEntity.ok().body(listaAluno);	
	}
	
	@GetMapping  ( value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		
		Aluno aluno = alunoService.findBAluno(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
		aluno = alunoService.insertAluno(aluno);
		return ResponseEntity.ok().body(aluno);
	}
	

	
	@DeleteMapping ( value = "/{id}")
	@ResponseStatus (HttpStatus.ACCEPTED)
	public void delete(@PathVariable Integer id) {
		alunoService.deletAluno(id);
	}
	
	
	@PutMapping( value = "/{id}")
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody Aluno aluno){
		aluno = alunoService.updateAluno(id, aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	/*usar quando quer deletar todos os 
	 * alunos do banco de dados
	 *
	@DeleteMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletarAluno(){
		alunoService.deletAluno();
		
	}*/
}
