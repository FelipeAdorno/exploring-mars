package br.com.elo7.probe.model.enums;

/**
 * The enum Probe direction enum.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public enum ProbeDirectionEnum {

    M("M"),
    L("L"),
    R("R");

    private String direction;

    ProbeDirectionEnum(final String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public static final ProbeDirectionEnum getEnumByDirection(final String direction) {
        for (ProbeDirectionEnum probeDirectionEnum : ProbeDirectionEnum.values()) {
            if (probeDirectionEnum.getDirection().equalsIgnoreCase(direction)) {
                return probeDirectionEnum;
            }
        }
        throw new IllegalArgumentException("Not found enum for a direction: " + direction);
    }
}
