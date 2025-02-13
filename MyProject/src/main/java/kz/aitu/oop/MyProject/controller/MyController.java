package kz.aitu.oop.MyProject.controller;

import kz.aitu.oop.MyProject.dbconnection.DatabaseManager;
import kz.aitu.oop.MyProject.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class MyController {

    private final DatabaseManager databaseManager = new DatabaseManager();

    @GetMapping("/getCustomer")
    public List<Customer> getAllCustomers() {
        try (Connection con = databaseManager.connect()) {
            return DatabaseManager.getAllCustomers(); // Исправлено с getCustomers() на getAllCustomers()
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    @PostMapping("/add")
    public String createCustomer(@RequestBody Customer customer) {
        try {
            DatabaseManager.createCustomer(customer.getName(), customer.getEmail());
            return "Customer created successfully with ID: " + customer.getIdC();
        } catch (Exception e) {
            return "Error creating customer: " + e.getMessage();
        }
    }

    public MyController() {
        try {
            databaseManager.createTables();
        } catch (Exception e) {
            throw new RuntimeException("Error creating tables", e);
        }
    }
}

