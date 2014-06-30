package assignment5;

import java.util.HashMap;
import java.util.Map;

public class ExistingCustomers {
    private static Map<PersonDescription, Customer> customersMap = new HashMap<>();

    public Map<PersonDescription, Customer> getCustomersMap() {
        return customersMap;
    }

    public void setCustomersMap(Map<PersonDescription, Customer> customersMap) {
        this.customersMap = customersMap;
    }

    public void addToCustomersMap(Customer customer){
         //if the customer is not already present in the existing customers map, then add
         if(isNewCustomer(customer)) {
               customersMap.put(customer.getPersonDescription(),  customer);
         }
    }

    public boolean isNewCustomer(Customer customer) {
        return customersMap.get(customer.getPersonDescription()) == null;
    }
}
