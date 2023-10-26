package all.in.one.UI.service;
import all.in.one.UI.entity.*;
import java.util.Map;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class bankService {
    private Map<String, Player> players;


    public bankService() {
        this.players = new HashMap<>();
        players.put("admin", new Player("admin", "admin","admin","admin"));
    }
    public void registerPlayer(String username, String password, String name, String surname) {
        if (!players.containsKey(username)) {
            Player newPlayer = new Player(username, password, name, surname);
            players.put(username, newPlayer);
            System.out.println("Привет, " + username + ". Вы успешно зарегистрировались.");
        } else {
            System.out.println("Пользователь с именем " + username + " уже существует. Повторите попытку, вызовите заново команду регистрации!");
        }
    }
    public boolean loginPlayer(String username, String password) {
        if (!players.containsKey(username)) {
            System.out.println("Пользователь с именем " + username + " не существует. Повторите попытку, вызовите заново команду регистрации!");
            return false;
        } else {
            Player player = players.get(username);
            if(player.getPassword().equals(password)){
                System.out.println("Вы успешно вошли в систему.");
                return true;
            }
            else{
                System.out.println("Ошибка авторизации. Пожалуйста, проверьте пароль.");
                return false;
            }
        }
    }
}
