package com.inventorycontrol.inventorycontrol.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventorycontrol.inventorycontrol.Exception.UserNotFoundException;
import com.inventorycontrol.inventorycontrol.controller.ProductController;
import com.inventorycontrol.inventorycontrol.model.Product;
import com.inventorycontrol.inventorycontrol.repository.ProductRepository;

@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> createProduct(Product product){
        
        Product savedProduct = productRepository.save(product);

        //generating product uri
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
        path("/{id}").buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public EntityModel<Product> findProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        
        if(product.isPresent() == false){
            throw new UserNotFoundException("id "+id);
        }

        //Sending link to go back to all products
        EntityModel<Product> entityModel = EntityModel.of(product.get());
        WebMvcLinkBuilder link = linkTo(methodOn(ProductController.class).findAllProducts());
        entityModel.add(link.withRel("all-products"));
        //Test
        //WebMvcLinkBuilder link2 = linkTo(methodOn(ProductController.class).findProduct(id));
        //entityModel.add(link2.withRel("one-product"));

        /*todo:
         * colocar link de metodos para adicionar ou remover quantidade de produtos 
        */
        return entityModel;
    }

    public ResponseEntity<Object> deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        
        if(product.isPresent() == false){
            throw new UserNotFoundException("id "+id);
        }

        productRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Product> updateProduct(Product product, Long id) {
        Optional<Product> productToUpdate = productRepository.findById(id);
        productToUpdate.get().setName(product.getName());
        productToUpdate.get().setDescription(product.getDescription());
        productToUpdate.get().setBrand(product.getBrand());
        productToUpdate.get().setMaxQuantity(product.getMaxQuantity());
        productToUpdate.get().setMinQuantity(product.getMinQuantity());
        productToUpdate.get().setQuantity(product.getQuantity());
        productToUpdate.get().setWeight(product.getWeight());

        Product updatedProduct = productRepository.save(productToUpdate.get());

        /*
        {
        "name": "Product X",
        "description": "This is a fantastic product",
        "brand": "ABC Corporation",
        "maxQuantity": 100,
        "minQuantity": 10,
        "quantity": 50,
        "weight": 2.5
        }
        */

        /* 
        return cursoRepository.findById(id).map(cursoParaAtualizar -> {
            cursoParaAtualizar.setNome(curso.getNome());
            cursoParaAtualizar.setPessoaInstrutora(curso.getPessoaInstrutora());
            cursoParaAtualizar.setPreco(curso.getPreco());

            Curso updatedCurso = cursoRepository.save(cursoParaAtualizar);
            return ResponseEntity.ok().body(updatedCurso); 
        }).orElse(ResponseEntity.notFound().build()); 
        */
        
        return ResponseEntity.ok().body(updatedProduct);
    }

}
