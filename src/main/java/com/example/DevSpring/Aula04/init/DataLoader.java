package com.example.DevSpring.Aula04.init;

import com.example.DevSpring.Aula03.model.Cliente03;
import com.example.DevSpring.Aula03.model.Pedido03;
import com.example.DevSpring.Aula03.model.Produto03;
import com.example.DevSpring.Aula03.repository.ClienteRepository03;
import com.example.DevSpring.Aula03.repository.PedidoRepository03;
import com.example.DevSpring.Aula03.repository.ProdutoRepository03;
import com.example.DevSpring.Aula04.model.Cliente04;
import com.example.DevSpring.Aula04.model.Contato04;
import com.example.DevSpring.Aula04.repository.ClienteRepository04;
import com.example.DevSpring.Aula04.repository.ContatoRepository04;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    //Numeração ao final das classes e variáveis é referente a aula.

    private final ClienteRepository03 clienteRepository03;
    private final PedidoRepository03 pedidoRepository03;
    private final ProdutoRepository03 produtoRepository03;

    private final ClienteRepository04 clienteRepository04;
    private final ContatoRepository04 contatoRepository04;

    public DataLoader(
            ClienteRepository03 clienteRepository03,
            PedidoRepository03 pedidoRepository03,
            ProdutoRepository03 produtoRepository03,
            ClienteRepository04 clienteRepository04,
            ContatoRepository04 contatoRepository04
    ) {
        this.clienteRepository03 = clienteRepository03;
        this.pedidoRepository03 = pedidoRepository03;
        this.produtoRepository03 = produtoRepository03;
        this.clienteRepository04 = clienteRepository04;
        this.contatoRepository04 = contatoRepository04;
    }

    @Override
    public void run(String... args) throws Exception {
        //Data aula 03 a seguir -->

        Cliente03 cliente03_01 = new Cliente03();
        cliente03_01.setNome("Lucas");
        cliente03_01.setSenha("123456");
        cliente03_01.setEmail("teste@gmail.com");

        Cliente03 cliente03_02 = new Cliente03();
        cliente03_02.setNome("Marcos");
        cliente03_02.setSenha("123456789");
        cliente03_02.setEmail("teste02@gmail.com");

        clienteRepository03.save(cliente03_01);
        clienteRepository03.save(cliente03_02);

        Pedido03 pedido03_01 = new Pedido03();
        pedido03_01.setDescricao("Pedido 01");
        pedido03_01.setData(LocalDate.parse("2026-08-26"));

        Pedido03 pedido03_02 = new Pedido03();
        pedido03_02.setDescricao("Pedido 02");
        pedido03_02.setData(LocalDate.now());

        pedidoRepository03.save(pedido03_01);
        pedidoRepository03.save(pedido03_02);

        Produto03 produto03_01 = new Produto03();
        produto03_01.setNome("Produto 01");
        produto03_01.setPreco(20.00);

        Produto03 produto03_02 = new Produto03();
        produto03_02.setNome("Produto 02");
        produto03_02.setPreco(30.50);

        produtoRepository03.save(produto03_01);
        produtoRepository03.save(produto03_02);

        //Data aula 04 a seguir -->

        Cliente04 cliente04_01 =  new Cliente04();
        cliente04_01.setNome("Joao");
        cliente04_01.setEmail("joao@gmail.com");

        Cliente04 cliente04_02 =  new Cliente04();
        cliente04_02.setNome("Marcos");
        cliente04_02.setEmail("marcos@gmail.com");

        clienteRepository04.save(cliente04_01);
        clienteRepository04.save(cliente04_02);

        Contato04 contato04_01 = new Contato04();
        contato04_01.setTipo("Celular");
        contato04_01.setValor("48999999999");
        contato04_01.setCliente(cliente04_01);

        Contato04 contato04_02 = new Contato04();
        contato04_02.setTipo("Telefone-Fixo");
        contato04_02.setValor("90909090");
        contato04_02.setCliente(cliente04_01);

        Contato04 contato04_03 = new Contato04();
        contato04_03.setTipo("Celular");
        contato04_03.setValor("51990909090");
        contato04_03.setCliente(cliente04_02);

        contatoRepository04.save(contato04_01);
        contatoRepository04.save(contato04_02);
        contatoRepository04.save(contato04_03);
    }
}
