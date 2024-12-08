package com.iitposs.pos.dto.paginated;

import com.iitposs.pos.dto.response.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {

    List<ItemResponseDTO> list;
    private long dataCount;
}
