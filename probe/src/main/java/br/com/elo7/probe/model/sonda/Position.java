package br.com.elo7.probe.model.sonda;

import br.com.elo7.probe.model.enums.CardinalDirectionEnum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Postion.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class Position {

    private Integer positionX;
    private Integer positionY;
    private CardinalDirectionEnum direction;

    public Position(final Integer positionX, final Integer positionY, final CardinalDirectionEnum direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
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

    public CardinalDirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(final CardinalDirectionEnum direction) {
        this.direction = direction;
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
