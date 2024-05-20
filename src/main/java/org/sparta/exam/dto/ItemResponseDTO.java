package org.sparta.exam.dto;

import org.sparta.exam.entity.Item;

import lombok.Getter;

@Getter
public class ItemResponseDTO {
	private Long id;

	private String title;

	private String content;

	private int price;

	private String username;

	public ItemResponseDTO(Item item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.content = item.getContent();
		this.price = item.getPrice();
		this.username = item.getUsername();
	}
}
