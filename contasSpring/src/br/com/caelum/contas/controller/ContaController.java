package br.com.caelum.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping(value="/form")
	public String form(){
		return "conta/formulario";
	}
	
	@RequestMapping(value="/adicionaConta")
	public String adiciona(Conta conta){
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);
		return "conta/conta-adicionada";
	}
	
	@RequestMapping(value="/listarContas")
	public ModelAndView listar(){
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		return mv;
	}
}
