package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest // Classe de test para testar um repositorio
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;
    
    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloNome(){
        String nomeCurso = "HTML 5";

        Curso curso = this.repository.findByNome(nomeCurso);

        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoNomeNaoEstejaCadastrado(){
        String nomeCurso = "JPA";

        Curso curso = this.repository.findByNome(nomeCurso);

        Assert.assertNull(curso);
    }
}
