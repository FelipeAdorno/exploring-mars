package br.com.elo7.probe.model.enums;

/**
 * The enum Cardinal direction enum.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public enum CardinalDirectionEnum {

    N("N", "W", "E"),
    W("W", "S", "N"),
    S("S", "E", "W"),
    E("E", "N", "S");


    private String direction;
    private String left;
    private String right;

    CardinalDirectionEnum(final String direction, final String left,
                          final String right) {
        this.direction = direction;
        this.left = left;
        this.right = right;
    }

    public String getDirection() {
        return direction;
    }

    public CardinalDirectionEnum getLeft() {
        return CardinalDirectionEnum.getEnumByDirection(left);
    }

    public CardinalDirectionEnum getRight() {
        return CardinalDirectionEnum.getEnumByDirection(right);
    }

    public static final CardinalDirectionEnum getEnumByDirection(final String direction) {
        for (CardinalDirectionEnum cardinalDirectionEnum : CardinalDirectionEnum.values()) {
            if (cardinalDirectionEnum.getDirection().equalsIgnoreCase(direction)) {
                return cardinalDirectionEnum;
            }
        }
        throw new IllegalArgumentException("Not found enum for a direction: " + direction);
    }

}
