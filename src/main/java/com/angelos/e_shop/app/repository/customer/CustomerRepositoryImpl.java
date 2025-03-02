package com.angelos.e_shop.app.repository.customer;

import com.angelos.e_shop.app.domain.Customer;
import com.angelos.e_shop.app.domain.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    // In-memory storage for Customer objects.
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOpt = customers.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst();
        return customerOpt.orElse(null);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId((long) (customers.size() + 1));
        }
        customers.add(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer existing = findById(customer.getId());
        if (existing != null) {
            existing.setFirstName(customer.getFirstName());
            existing.setLastName(customer.getLastName());
            existing.setEmail(customer.getEmail());
            existing.setPhoneNumber(customer.getPhoneNumber());
            existing.setUsername(customer.getUsername());
            existing.setPassword(customer.getPassword());
            existing.setBonusPoints(customer.getBonusPoints());
            existing.setActive(customer.isActive());
        }
    }

    @Override
    public void deleteById(Long id) {
        customers.removeIf(customer -> customer.getId() != null && customer.getId().equals(id));
    }

    @PostConstruct
    public void customerData() {
        System.out.println("Prepopulating costumer data");
        save(new Customer("John", "Smith", "johnsmith@email.com", "105910195199"));
        save(new Customer("Maria", "Donkey", "mariadonkey@email.com", "3252626161"));
        save(new Customer("Lucy", "Statham", "lucystatham@email.com", "75685684566"));
        save(new Customer("Albert", "Einstein", "albereinstein@email.com", "743649718"));
        save(new Customer("Angelos", "Thanasai", "angelosthanasai@email.com", "5789592875"));
        save(new Customer("James", "Tatum", "jamestatum@email.com", "3526276161"));
        System.out.println("Costumer Data Prepopulated successfully.");
    }
}
