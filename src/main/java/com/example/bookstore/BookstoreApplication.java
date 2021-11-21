package com.example.bookstore;

import java.sql.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.domain.Livro;
import com.example.bookstore.repositories.CategoriaRepository;
import com.example.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{//Este Implemete serve para que toda vez que start a aplicação e ele executa o metodo "run"

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lowren ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
