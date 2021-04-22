package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRespository;
import guru.springframework.repositories.UnitOfMeasureRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final CategoryRespository categoryRespository;
    private final UnitOfMeasureRespository unitOfMeasureRespository;

    @RequestMapping({"", "/", "/index"})
    public String index() {
        Optional<Category> category = categoryRespository.findByDescription("Italian");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRespository.findByDescription("Ounce");

        System.out.println("Cat id is: " + category.get().getId());
        System.out.println("Uom id is: " + unitOfMeasure.get().getId());

        return "index";
    }
}
