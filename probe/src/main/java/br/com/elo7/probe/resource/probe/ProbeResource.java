package br.com.elo7.probe.resource.probe;

import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Probe request.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class ProbeResource {

    private String name;
    private Integer positionX;
    private Integer positionY;
    private CardinalDirectionEnum cardinalDirection;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(final Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(final Integer positionY) {
        this.positionY = positionY;
    }

    public CardinalDirectionEnum getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(final CardinalDirectionEnum cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
