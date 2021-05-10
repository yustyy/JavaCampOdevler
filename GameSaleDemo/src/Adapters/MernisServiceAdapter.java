package Adapters;

import java.rmi.RemoteException;

import Abstract.PlayerCheckService;
import Entities.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements PlayerCheckService {

	
	boolean result;
	
	@Override
	public boolean checkIfRealPerson(Player player) {
		
		KPSPublicSoapProxy publicSoapProxy = new KPSPublicSoapProxy();
		
		try {
			 result =  publicSoapProxy.TCKimlikNoDogrula(Long.parseLong(player.getNationalityId()),
					player.getFirstName().toUpperCase(),
					player.getLastName().toUpperCase(),
					player.getDateOfBirth());
			
			
			
		} catch (RemoteException e) {

			result = false;
			System.out.println("Bir hata oluştu!");
			e.printStackTrace();
		}
		
		return result;
		
	}

}
