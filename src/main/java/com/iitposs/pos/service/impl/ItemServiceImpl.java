package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.paginated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemAllDetailsResponseDTo;
import com.iitposs.pos.dto.response.ItemResponseDTO;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.exception.NotFoundException;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO saveRequestDTO) {
        Item item = modelMapper.map(saveRequestDTO, Item.class);

        if (!itemRepo.existsById(item.getItemID())) {
            itemRepo.save(item);
            return "Item saved successfully";
        } else {
            return "Item already exists";
        }
    }

    @Override
    public String updateItem(ItemSaveRequestDTO requestDTO) {
        if (itemRepo.existsById(requestDTO.getItemID())) {
            Item item = itemRepo.getReferenceById(requestDTO.getItemID());

            item.setName(requestDTO.getName());
            item.setMeasuringType(requestDTO.getMeasuringType());
            item.setSupplierPrice(requestDTO.getSupplierPrice());
            item.setDisplayPrice(requestDTO.getDisplayPrice());
            item.setSellingPrice(requestDTO.getSellingPrice());
            item.setQtyOnHand(requestDTO.getQtyOnHand());
            item.setActiveState(requestDTO.isActiveState());

            itemRepo.save(item);

            return requestDTO.getName() + " has been updated...!";
        } else {
            return "something went wrong...!";
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        List<ItemResponseDTO> responseDTOS = new ArrayList<>();

        for (Item item : items) {
            responseDTOS.add(new ItemResponseDTO(
                    item.getItemID(),
                    item.getName(),
                    item.getMeasuringType(),
                    item.getSupplierPrice(),
                    item.getDisplayPrice(),
                    item.getSellingPrice(),
                    item.getQtyOnHand(),
                    item.isActiveState()
            ));
        }
        return responseDTOS;
    }

    @Override
    public String deleteItem(int itemID) {
        if (itemRepo.existsById(itemID)) {
            itemRepo.deleteById(itemID);
            return itemID + " has been deleted...!";
        } else {
            return "Item not found...!";
        }
    }

    @Override
    public List<ItemAllDetailsResponseDTo> getAllItemsByState(boolean state) {
        List<Item> items = itemRepo.findAllByActiveState(state);
        List<ItemAllDetailsResponseDTo> responseDTos = new ArrayList<>();

        for (Item item : items) {
            responseDTos.add(new ItemAllDetailsResponseDTo(
                    item.getItemID(),
                    item.getName(),
                    item.getMeasuringType(),
                    item.getSupplierPrice(),
                    item.getDisplayPrice(),
                    item.getSellingPrice(),
                    item.getQtyOnHand(),
                    item.isActiveState()
            ));
        }
        return responseDTos;
    }

    @Override
    public List<ItemResponseDTO> getItemByName(String itemName) {
        List<Item> items = itemRepo.findAllByNameEqualsAndActiveState(itemName, true);

        if (!items.isEmpty()) {
            return modelMapper.map(items, new TypeToken<List<ItemResponseDTO>>() {}.getType());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemsByState(boolean state, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(state, PageRequest.of(page, size));
        if (!items.isEmpty()){
            List<ItemResponseDTO> itemResponseDTOS =
                    modelMapper.map(items.getContent(), new TypeToken<List<ItemResponseDTO>>() {
                    }.getType());
            return new PaginatedResponseItemDTO(
                    itemResponseDTOS,
                    items.getTotalElements()
            );

        }else{
            throw new NotFoundException("No items found");
        }
    }
}