package org.casaortiz.dao.agreement;

import org.casaortiz.dao.implementations.CategoryDaoImpl;
import org.casaortiz.model.Category;
import org.junit.Test;

import java.util.List;

/**
 * Testing for CategoryDao
 * @author Ing. Jorge Ortiz
 * @version 06/30/2022
 * @see <a href= "https://jorgeortizc06.github.io">Portafolio </a>
 */
public class CategoryDaoTest {

    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Test
    public void saveTest() throws Exception {
        Category category = new Category(null, "Laptops", "Computadora portatiles");
        Category category1= new Category(null, "Monitores", "Monitor de PC y Televisores");
        Category category2 = new Category(null, "Smartphones", "Moviles inteligentes y comunes");
        Category category3 = new Category(null, "Utilidades", "Discos duros, estuche, micas, entre otros");

        System.out.println(categoryDao.save(category, true));
        System.out.println(categoryDao.save(category1, true));
        System.out.println(categoryDao.save(category2, true));
        System.out.println(categoryDao.save(category3, true));
    }

    @Test
    public void updateTest() throws Exception {
        Category category = new Category(1, "Laptops", "Computadora portatiles Editado");
        Category itemDao = categoryDao.save(category, false);
        System.out.println(itemDao.toString());
    }

    @Test
    public void findByIdTest() throws Exception {
        Category category = new Category(3, "Laptops", "Editado");
        Category itemDao = categoryDao.findById(category.getId()).get();
        System.out.println(itemDao);
    }

    @Test
    public void deleteTest() throws Exception {
        Category category = new Category(4,"Laptops", "Editado");
        categoryDao.deleteById(category.getId());
    }

    @Test
    public void findAllTest() throws Exception {
        List<Category> categories = categoryDao.findAll();
        categories.forEach(System.out::println);

    }

    @Test
    public void findCategoryByName() throws Exception {
        List<Category> categories = categoryDao.findCategoryByName("Monitores");
        categories.forEach(System.out::println);

    }
}
