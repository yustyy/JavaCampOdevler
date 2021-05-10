import Abstract.CampaignService;
import Abstract.GameService;
import Abstract.OrderService;
import Abstract.PlayerService;
import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.OrderManager;
import Concrete.PlayerManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class Main {

	public static void main(String[] args) {
		Player yusuf = new Player(1, "Yusuf", "Açmacı", 2005, "12197500768");
		
		PlayerService playerService = new PlayerManager(new MernisServiceAdapter());
		
		playerService.addPlayer(yusuf);
		
		
		Game game = new Game(1, "GTA V", 180);
		
		GameService gameService = new GameManager();
		gameService.add(game);
		
		
		Campaign campaign = new Campaign(1, "Yılbaşı Kampanyası", 20);
		
		CampaignService campaignService = new CampaignManager();
		campaignService.add(campaign);
		
		OrderService orderService = new OrderManager();
		
		orderService.sell(game, yusuf);
		
		orderService.sell(game, yusuf, campaign);
		
	}

}
