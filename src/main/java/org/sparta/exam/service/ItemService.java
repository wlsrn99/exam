package org.sparta.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.sparta.exam.dto.ItemRequestDTO;
import org.sparta.exam.dto.ItemResponseDTO;
import org.sparta.exam.entity.Item;
import org.sparta.exam.repository.ItemRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemResponseDTO createItem(ItemRequestDTO itemRequestDTO) {
		Item item = new Item(itemRequestDTO);

		itemRepository.save(item);

		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(item);

		return itemResponseDTO;
	}

	public List<ItemResponseDTO> getItems() {
		return itemRepository.findAll().stream().map(ItemResponseDTO::new).toList();
	}

	@Transactional
	public ItemResponseDTO updateItem(Long id, ItemRequestDTO itemRequestDTO) {
		Item item = findItem(id);

		item.ItemUpdate(itemRequestDTO);

		ItemResponseDTO itemResponseDTO = new ItemResponseDTO(item);

		return itemResponseDTO;
	}

	public String deleteItem(Long id) {
		Item item = findItem(id);

		itemRepository.delete(item);

		return "{\"msg\":\"삭제완료\"}";
	}

	private Item findItem(Long id) {
		return itemRepository.findById(id).orElseThrow(() //null값 체크
			-> new IllegalArgumentException("선택한 게시글ID는 존재하지 않습니다"));
	}
}
