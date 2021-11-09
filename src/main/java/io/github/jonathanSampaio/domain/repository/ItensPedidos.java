package io.github.jonathanSampaio.domain.repository;

import io.github.jonathanSampaio.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidos extends JpaRepository<ItemPedido, Integer> {
}
