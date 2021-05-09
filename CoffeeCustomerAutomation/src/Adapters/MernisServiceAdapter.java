package Adapters;

import java.rmi.RemoteException;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		
		try {
			boolean isValid =  kpsPublicSoapProxy.TCKimlikNoDogrula(
					Long.parseUnsignedLong(customer.getNationalityId()), 
					customer.getFirstName(),
					customer.getLastName(), 
					customer.getDateOfBirth()
					
					);
		
			
			return isValid;
			
			
		} catch (RemoteException e) {

			e.printStackTrace();
			return false;
		}
		
	
				
				
		
	}

}
