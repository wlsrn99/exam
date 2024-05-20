package org.sparta.exam.controller;

import java.util.List;

import org.sparta.exam.dto.ItemRequestDTO;
import org.sparta.exam.dto.ItemResponseDTO;
import org.sparta.exam.service.ItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;

	@PostMapping("/post")
	public ItemResponseDTO createItem(@RequestBody ItemRequestDTO itemRequestDTO) {
		return itemService.createItem(itemRequestDTO);
	}

	@GetMapping("/post")
	public List<ItemResponseDTO> getAllItems() {
		return itemService.getItems();
	}

	@PutMapping("/post/{id}")
	public ItemResponseDTO updateItem(@PathVariable Long id, @RequestBody ItemRequestDTO itemRequestDTO) {
		return itemService.updateItem(id,itemRequestDTO);
	}

	@DeleteMapping("/post/{id}")
	public String deleteItem(@PathVariable Long id){
		return itemService.deleteItem(id);
	}
}
