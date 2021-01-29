package br.com.pulse.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.model.exception.ProdutoNotFoundException;

public class ProdutoServiceTest {

	private ProdutoMapper produtoMapper;
	private ProdutoService produtoService;

	@Before
	public void setUp() {
		produtoMapper = mock(ProdutoMapper.class);
		produtoService = new ProdutoService(produtoMapper);

	}
	
	@Test
	public void deveRetornarTodosOsProdutos() {
		
		List<Produto> mockProdutos = new ArrayList<>();
		mockProdutos.add(new Produto(1L, "desc", "00001", LocalDateTime.now(), true));
		mockProdutos.add(new Produto(2L, "desc", "00001", LocalDateTime.now(), true));
		mockProdutos.add(new Produto(3L, "desc", "00001", LocalDateTime.now(), true));
		
		when(produtoMapper.buscarTodos()).thenReturn(mockProdutos);
		
		List<Produto> produtos = produtoService.buscarTodos();
		
		assertEquals(mockProdutos, produtos);
			
	}
	

	@Test
	public void deveRetornarUmProdutoPorId() throws ProdutoNotFoundException {
		Long produtoId = 22L;

		Produto mockProduto = mock(Produto.class);

		when(produtoMapper.buscar(produtoId)).thenReturn(mockProduto);

		Produto produto = produtoService.buscar(produtoId);

		assertEquals(mockProduto, produto);

	}

	@Test
	public void deveLancarProdutoNotFoundException() {

		Assertions.assertThatThrownBy(() -> produtoService.buscar(null))
				.isExactlyInstanceOf(ProdutoNotFoundException.class).hasMessage("Product not found.");

	}
	
	
	@Test
	public void deveInserirUmProduto() {
		
		ArgumentCaptor<Produto> produtoCaptor = ArgumentCaptor.forClass(Produto.class);
		
		Produto produto = new Produto();
		
		LocalDateTime data = LocalDateTime.now();
		
		produto.setId(2L);
		produto.setDescricao("Produto1");
		produto.setCodBarras("0001");
		produto.setDataCadastro(data);
		produto.setAtivo(true);
		
		when(produtoMapper.buscar(produto.getId())).thenReturn(produto);
		
		Produto produto2 = produtoService.insere(produto);
		
		verify(produtoMapper).inserir(produtoCaptor.capture());
		
		
		Assertions.assertThat(produtoCaptor.getValue().getId()).isEqualTo(produto.getId());
		
		assertEquals(produto, produto2);
		
		
	}
	
	@Test
	public void deveAlterarUmProduto() {	
	
		ArgumentCaptor<Produto> produtoCaptor = ArgumentCaptor.forClass(Produto.class);
		ArgumentCaptor<Long> produtoIdCaptor = ArgumentCaptor.forClass(Long.class);
		
		Produto alteraProduto = criaProduto();
		
		alteraProduto.setDescricao("Produto2");
		
		when(produtoMapper.buscar(alteraProduto.getId())).thenReturn(alteraProduto);
		
		Produto produto = produtoService.alterar(alteraProduto, criaProduto().getId());
			
		verify(produtoMapper, times(1)).alterar(produtoCaptor.capture(), produtoIdCaptor.capture());
		
		Assertions.assertThat(alteraProduto).isEqualTo(produto);
		
	}
	
	public Produto criaProduto() {
		LocalDateTime data = LocalDateTime.now();
		return new Produto(2L, "0001", "Produto1", data, true);
	}
	
}
