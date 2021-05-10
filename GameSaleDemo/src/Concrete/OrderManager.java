package Concrete;

import Abstract.OrderService;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class OrderManager implements OrderService {

	@Override
	public void sell(Game game, Player player) {
		System.out.println(game.getGameName()+" adlı oyun, "+
							player.getFirstName()+" adlı oyuncuya, "+
							game.getUnitPrice()+" fiyatına satıldı!");
		
	}

	@Override
	public void sell(Game game, Player player, Campaign campaign) {
		System.out.println(game.getGameName()+" adlı oyun, "+
				campaign.getCampaignName()+" kampanyasıyla "+
				player.getFirstName()+" adlı oyuncuya, "+
				(game.getUnitPrice() - (game.getUnitPrice() * campaign.getPercentageOfDiscount() / 100)+" fiyatına satıldı!"));
			
	}

}
