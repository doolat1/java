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

    @GetMapping("/get")
    public List<Customer> getAllCustomers() {
        try (Connection con = databaseManager.connect()) {
            return DatabaseManager.getAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    @PostMapping("/add")
    public String createCustomer(@RequestBody Customer customer) {
        try {
            int id = DatabaseManager.createCustomer(customer.getName(), customer.getEmail());
            return "Customer created successfully with ID: " + id;
        } catch (Exception e) {
            return "Error creating customer: " + e.getMessage();
        }
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            boolean updated = DatabaseManager.updateCustomer(id, customer.getName(), customer.getEmail());
            return updated ? "Customer updated successfully!" : "Customer not found!";
        } catch (Exception e) {
            return "Error updating customer: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        try {
            boolean deleted = DatabaseManager.deleteCustomer(id);
            return deleted ? "Customer deleted successfully!" : "Customer not found!";
        } catch (Exception e) {
            return "Error deleting customer: " + e.getMessage();
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
