package businessLogic;

import Model.Product;
import dataAccess.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL()
    {
        productDAO = new ProductDAO();
    }

    public ArrayList<Product> getAllProduct()
    {
        List<Product> products = productDAO.findAll();
        return new ArrayList<Product>(products);
    }

    public void deleteProduct(Product product, int id)
    {
        //productDAO.delete(product, id);
    }

    public void insertProduct(Product product)
    {
        productDAO.insert(product);
    }

    public void updateProduct(Product product, int id)
    {
        productDAO.update(product,id);
    }

}
