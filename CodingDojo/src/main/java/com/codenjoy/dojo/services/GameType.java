package com.codenjoy.dojo.services;

import com.codenjoy.dojo.services.settings.Parameter;
import com.codenjoy.dojo.services.settings.Settings;

/**
 * Это интерфейс указывает на тим игры. Как только ты его реулизуешь -
 * на админке (http://localhost:8080/codenjoy-contest/admin31415)
 * будет возможность переключиться на твою игру.
 */

public interface GameType {

    public static final GameType NULL = new NullGameType();

    /**
     * @param score значения очков перед началом игры (используется например при загрузке игры из save)
     * @return Возвращается объект который умеет в зависимости от типа события на карте подчитывать очки игроков
     */
    PlayerScores getPlayerScores(int score);

    /**
     * Так фреймворк будет стартовать новую игру для каждого пользователя
     * @param listener Через этот интерфейс фреймворк будет слушать какие ивенты возникают в твоей игре
     * @return Экземпляр игры пользователя
     */
    Game newGame(EventListener listener);

    /**
     * @return Размер доски. Важно, чтобы у всех пользователей были одинаковые по размеру поля
     */
    Parameter<Integer> getBoardSize();

    /**
     * @return Имя твоей игры
     */
    String gameName();

    /**
     * @return Список элементов отображаеммых на доске
     * @see com.codenjoy.dojo.sample.model.Elements
     */
    Enum[] getPlots();

    /**
     * @return Настройки игры
     * @see Settings
     */
    Settings getGameSettings();

    /**
     * Существует два режима игры. Для начала реализуй - каждый на своей отдельной доске.
     * Позже можешь пробовать мультиплеерную игру создать.
     * @see com.codenjoy.dojo.sample.model.SingleSample
     * @see com.codenjoy.dojo.sample.model.Sample
     * @return false - если каждый будет играть на своей отдельной доске, true - если все на одной доске
     */
    boolean isSingleBoardGame();
}
