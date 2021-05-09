
import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());		
		
		Customer yusuf = new Customer(1, "Yusuf", "Açmacı", 2005, "12197500768");
		
		
		
		customerManager.save(yusuf);

	}

}
