package Concrete;

import Abstract.PlayerCheckService;
import Abstract.PlayerService;
import Entities.Player;

public class PlayerManager implements PlayerService {
	
	PlayerCheckService playerCheckService;
	
	public PlayerManager(PlayerCheckService playerCheckService) {
		this.playerCheckService = playerCheckService;
	}

	@Override
	public void addPlayer(Player player) {
		if(playerCheckService.checkIfRealPerson(player)) {
			System.out.println(player.getFirstName()+" adlı oyuncu eklendi!");
		}else {
			System.out.println("Kayıt bilgileri hatalı!");
		}
		
	}

	@Override
	public void updatePlayer(Player player) {
		System.out.println(player.getFirstName()+" adlı oyuncu güncellendi!");
		
	}

	@Override
	public void deletePlayer(Player player) {
		System.out.println(player.getFirstName()+" adlı oyuncu silindi!");
		
	}

}
