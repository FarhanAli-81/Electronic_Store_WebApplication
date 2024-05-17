package com.ElectronicStore.com.fifth.Controller;


import com.ElectronicStore.com.fifth.Entity.Product;
import com.ElectronicStore.com.fifth.Entity.ProductObject;
import com.ElectronicStore.com.fifth.Service.StoreService;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//import java.nio.file.StandardCopyOption;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
//import jakarta.validation.*;
import static org.aspectj.bridge.Version.getTime;


@Controller
//@RequestMapping("/products")
public class Controller2 {

    @Autowired
    private StoreService storeService;

    @GetMapping("/product")
    public String displayAll(Model model){
        List<Product> products=storeService.findAll();
        model.addAttribute("products", products);

        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductObject productObject=new ProductObject();
        model.addAttribute("productObject", productObject);

        return "createProduct";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ProductObject productObject, BindingResult result){
        MultipartFile file=productObject.getImageFile();
        Date createdAt=new Date();
        if (!file.isEmpty()) {
            try {
                // Define the directory where you want to save the file
                String uploadDir = "C:\\Users\\ADMIN\\Downloads\\com.fifth\\public\\images";

                // If the directory doesn't exist, create it
//                File uploadDirFile = new File(uploadDir);
//                if (!uploadDirFile.exists()) {
//                    uploadDirFile.mkdirs();
//                }

                // Save the file to the server
                File uploadedFile = new File(uploadDir+"\\"+file.getOriginalFilename());
                file.transferTo(uploadedFile);




                Product obj=new Product();
                obj.setBrand(productObject.getBrand());
                obj.setCategory(productObject.getCategory());
                obj.setName(productObject.getName());
                obj.setPrice(productObject.getPrice());
                obj.setDescription(productObject.getDescription());
                obj.setCreatedDate(createdAt);
                obj.setImageFileName(file.getOriginalFilename());

                storeService.save(obj);
                // File uploaded successfully
//                return "redirect:/success"; // Redirect to success page or do something else
                return "redirect:/product";
            } catch (IOException ex) {
                ex.printStackTrace(); // Handle the exception properly
                // File upload failed
                return "redirect:/error"; // Redirect to error page or do something else
            }
        }
//        else {
//            // No file uploaded
//            return "redirect:/error"; // Redirect to error page or do something else
//        }


        return "index";

    }



//    @GetMapping("/delete/{id}")
//    public void delete(@PathVariable("id") Long id){
//        System.out.println(id+" 999999999999999999999999999999999999999999999999999999999999999999999");
//        storeService.deleteById(id);
//    }


    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Long id){
         storeService.deleteById(id);
         return "redirect:/product";
    }



// @MOdelAttribute is used to pass info from page to controller
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model){
         Product pro=storeService.findById(id);
         model.addAttribute("product", pro);
         ProductObject productObject=new ProductObject();
         productObject.setBrand(pro.getBrand());
         productObject.setName(pro.getName());
         productObject.setPrice(pro.getPrice());
         productObject.setDescription(pro.getDescription());
         productObject.setCategory(pro.getCategory());
//        System.out.println(id+" "+pro);
        model.addAttribute("productObject", productObject);


         return "editPage";
    }
    @PostMapping("/edit")
    public String updateProduct(Model model, @RequestParam Long id, @Valid @ModelAttribute ProductObject productObject, BindingResult result) throws IOException {
            MultipartFile file=productObject.getImageFile();
//        System.out.println(productObject.getName());
          Product product=storeService.findById(id);


        System.out.println("prodcut object : "+productObject );
        System.out.println("product = "+product);

          product.setBrand(productObject.getBrand());
          product.setPrice(productObject.getPrice());
          product.setName(productObject.getName());
          product.setCategory(productObject.getCategory());
          product.setDescription(productObject.getDescription());
          Date createdAt=new Date();
          product.setCreatedDate(createdAt);
          product.setImageFileName(file.getOriginalFilename());


          storeService.save(product);


          String uploadDir="C:\\Users\\ADMIN\\Downloads\\com.fifth\\public\\images";
          File uploadedFile=new File(uploadDir+"\\"+file.getOriginalFilename());
          file.transferTo(uploadedFile);





        return "redirect:/product";
    }



}
