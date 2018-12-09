import connect.Util;
import entity.Game;
import implementation.GameDAOImpl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class Domain {

    public static void main(String[] args){
        //Util test = new Util();
        //test.getConnection();

        GameDAOImpl gameDAOImpl = new GameDAOImpl();
        Game game = new Game();



        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.MARCH, 3);
        game.setIdDeveloperCompany(1);
        game.setReleaseDate(new java.sql.Date(calendar.getTime().getTime()));
        game.setUserRating(69);
        game.setCost(1999);
        game.setPegi(18);
        game.setName("Far Cry 5");
        game.setMetacritic(72);
        game.setIdPublisher(2);
        game.setIdPlatform(1);
        game.setMultiplayer((byte) 1);

        //System.out.println(game.toString());
        try {
            //get by ID
            //Game game1 = gameDAOImpl.getById(11);
            //System.out.println(game1.toString());

            //ADD
            //gameDAOImpl.add(game);

            //UPDATE
            //game.setIdGame(11);
            //game1DAOImpl.update(game);

            //System.out.println(game.toString());

            //GET ALL
            List<Game> gameList = gameDAOImpl.getAll();
            for (Game g : gameList){
                System.out.println(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

    }
}
