package br.com.elo7.probe.resource.plateau;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Plateau resource.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class PlateauResource {

    private Integer positionX;
    private Integer positionY;

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
