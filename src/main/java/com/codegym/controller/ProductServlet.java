package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showProductForm(request, response);
                break;
            }
            case "edit": {
                showEditForm(request, response);
                break;
            }
            case "delete": {
                showDeleteForm(request, response);
            }
            case "view" :{
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productService.findById(id);
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");
                dispatcher.forward(request, response);
                break;
            }
            default: {
                showlistProduct(request, response);
                break;
            }
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showlistProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("listProduct", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createProduct(request, response);
                break;
            }
            case "edit": {
                editProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
                break;
            }
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = new Product(id, name, price, description);
        productService.create(product);
        request.setAttribute("message", "Tạo mới thành công!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = new Product(id, name, price, description);
        productService.updateById(id, product);
        response.sendRedirect("/products");
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteById(id);
        response.sendRedirect("/products");
    }

}

