package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public interface OrderService {

	void sell(Game game, Player player);
	void sell(Game game, Player player, Campaign campaign);
}
