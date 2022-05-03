package com.incluwed.incluwed.forms;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.incluwed.incluwed.classes.Postagens;
import com.incluwed.incluwed.classes.Usuarios;
import com.incluwed.incluwed.repository.PostagensRepository;
import org.hibernate.validator.constraints.Length;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostagensForms extends Postagens {

    @NotNull @NotEmpty @Length(max=20)
    private String titulo;

    @NotNull @NotEmpty @Length(max=20)
    private String nomeLocal;

    @NotNull @NotEmpty @Length(max=120)
    private String enderecoLocal;

    @NotNull @NotEmpty @Length(max=120)
    private String texto;

    @Getter
    private Usuarios usuario;

    @NotNull @DecimalMax("5.0") @DecimalMin("0.0")
    private int nota;

    public PostagensForms(String titulo, String nomeLocal, String enderecoLocal, String msg, Usuarios usuario, int nota){
        this.titulo = titulo;
        this.nomeLocal = nomeLocal;
        this.enderecoLocal = enderecoLocal;
        this.texto = msg;
        this.usuario = usuario;
        this.nota = nota;
    }

    public Postagens converter(Usuarios usuario) {
        return new Postagens(titulo, nomeLocal, enderecoLocal, texto, usuario, nota);
    }

    public Postagens atualizarPost(long post_id, PostagensRepository postagensRepository){
        Postagens post = postagensRepository.getById(post_id);
        post.setNomeLocal(this.nomeLocal);
        post.setTitulo(this.titulo);
        post.setEnderecoLocal(this.enderecoLocal);
        post.setTexto(this.texto);
        post.setNota(this.nota);

        return post;
    }

}
