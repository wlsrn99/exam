package org.sparta.exam.entity;

import org.sparta.exam.dto.ItemRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	private int price;

	private String username;

	public Item(ItemRequestDTO itemRequestDTO) {
		this.title = itemRequestDTO.getTitle();
		this.content = itemRequestDTO.getContent();
		this.price = itemRequestDTO.getPrice();
		this.username = itemRequestDTO.getUsername();
	}

	public void ItemUpdate(ItemRequestDTO itemRequestDTO){
		this.title = itemRequestDTO.getTitle();
		this.content = itemRequestDTO.getContent();
		this.price = itemRequestDTO.getPrice();
		this.username = itemRequestDTO.getUsername();
	}
}
