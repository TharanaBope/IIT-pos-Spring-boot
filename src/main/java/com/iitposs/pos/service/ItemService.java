package com.iitposs.pos.service;

import com.iitposs.pos.dto.paginated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO saveRequestDTO);
    String updateItem(ItemSaveRequestDTO requestDTO);
    List<ItemResponseDTO> getAllItems();
    String deleteItem(int itemID);
    List<ItemAllDetailsResponseDTo> getAllItemsByState(boolean state);
    List<ItemResponseDTO> getItemByName(String itemName);
    PaginatedResponseItemDTO getItemsByState(boolean state, int page, int size); // Ensure this method is declared
}