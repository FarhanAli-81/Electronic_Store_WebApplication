package com.ElectronicStore.com.fifth.Entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductObject {
    @NotEmpty(message="the name is required")
    private String name;
    @NotEmpty(message = "the brand is required")
    private String brand;
    @NotEmpty(message = "the category cannot be empty")
    private String category;
    @Min(0)
    private double price;
    @Size(min=10, message="aleast 10 characters")
    @Size(max=2000, message="cannot exceed 2000 characters")
    private String description;
    private MultipartFile imageFile;
}
