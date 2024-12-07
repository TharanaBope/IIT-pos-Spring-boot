package com.iitposs.pos.controller;

import com.iitposs.pos.dto.paginated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.service.ItemService;
import com.iitposs.pos.util.enums.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save-item")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO saveRequestDTO) {
        String message = itemService.saveItem(saveRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update-item")
    public String updateItem(@RequestBody ItemSaveRequestDTO requestDTO) {
        String message = itemService.updateItem(requestDTO);
        return message;
    }

    @GetMapping(path = "/get-item-by-name", params = "name")
    public ResponseEntity<StandardResponse> getItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemResponseDTO> responseDTOS = itemService.getItemByName(itemName);
        return new ResponseEntity<>(
                new StandardResponse(201, "Success", responseDTOS), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-items")
    public List<ItemResponseDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping(path = "/delete-item/{id}")
    public String deleteItem(@PathVariable(value = "id") int itemID) {
        return itemService.deleteItem(itemID);
    }

    @GetMapping(path = "/get-all-items-by-state", params = {"state", "page", "size"})
    public ResponseEntity<StandardResponse> getAllItemByState(
            @RequestParam(value = "state") boolean state,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedResponseItemDTO pdto = itemService.getItemsByState(state, page, size);
        return new ResponseEntity<>(
                new StandardResponse(201, "Success", pdto), HttpStatus.CREATED
        );
    }
}