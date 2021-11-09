package io.github.jonathanSampaio;

import io.github.jonathanSampaio.domain.entity.Cliente;
import io.github.jonathanSampaio.domain.entity.Pedido;
import io.github.jonathanSampaio.domain.repository.Clientes;
import io.github.jonathanSampaio.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init (
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos){
        return args -> {
            System.out.println("Salvando clientes");
            Cliente wick = new Cliente("Sr.Wick");
            clientes.save(wick);


            Pedido p = new Pedido();
            p.setCliente(wick);
            p.setDataPedido( LocalDate.now() );
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            List<Cliente> result = clientes.encontrarPorNome("Sr.Wick");
//            Cliente cliente= clientes.findClienteFetchPedidos(wick.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(wick).forEach(System.out::println);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
